package com.example.demo.service.user.impl;

import com.example.demo.entity.enumration.Gender;
import com.example.demo.entity.enumration.RoleEnum;
import com.example.demo.entity.user.Customer;
import com.example.demo.entity.user.Seller;
import com.example.demo.model.user.request.RegisterCustomerRequest;
import com.example.demo.model.user.request.RegisterSellerRequest;
import com.example.demo.model.user.request.RegisterUserRequest;
import com.example.demo.repository.user.CustomerRepository;
import com.example.demo.repository.user.SellerRepository;
import com.example.demo.service.user.CustomerService;
import com.example.demo.service.user.SellerService;
import com.example.demo.utils.constants.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

}
