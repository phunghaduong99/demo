package com.example.demo.converter.user;

import com.example.demo.entity.enumration.RoleEnum;
import com.example.demo.entity.user.Customer;
import com.example.demo.entity.user.Seller;
import com.example.demo.entity.user.UserBaseEntity;
import com.example.demo.model.user.request.RegisterCustomerRequest;
import com.example.demo.model.user.request.RegisterSellerRequest;
import com.example.demo.model.user.request.RegisterUserRequest;
import com.example.demo.model.user.response.RegisterResponse;
import com.example.demo.utils.constants.Message;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class UserConverter {
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserConverter(ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserBaseEntity toEntity(RegisterUserRequest registerUserRequest){
        validatePassword(registerUserRequest);
        if(registerUserRequest instanceof  RegisterCustomerRequest){
            Customer customer =  modelMapper.map(registerUserRequest, Customer.class);
            customer.setRole(RoleEnum.ROLE_CUSTOMER);
            customer.setPassword(bCryptPasswordEncoder.encode(registerUserRequest.getPassword()));
            return customer;
        } else if(registerUserRequest instanceof  RegisterSellerRequest){
            Seller seller =  modelMapper.map(registerUserRequest, Seller.class);
            seller.setRole(RoleEnum.ROLE_SELLER);
            seller.setPassword(bCryptPasswordEncoder.encode(registerUserRequest.getPassword()));
            return seller;
        } else {
            return null;
        }
    }

    public RegisterResponse toDto(UserBaseEntity userBaseEntity){
        return modelMapper.map(userBaseEntity, RegisterResponse.class);
    }


    private void validatePassword(RegisterUserRequest request) {
        if(!StringUtils.hasText(request.getPassword()) || !StringUtils.hasText(request.getRepeatedPassword())){
            throw new UsernameNotFoundException(Message.PASSWORD_NOT_VALID);
        }
        if(!request.getPassword().equals(request.getRepeatedPassword())){
            throw new UsernameNotFoundException(Message.PASSWORD_NOT_VALID);
        }
    }
}
