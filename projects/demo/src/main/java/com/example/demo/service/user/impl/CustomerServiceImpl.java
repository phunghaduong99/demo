package com.example.demo.service.user.impl;

import com.example.demo.entity.enumration.Gender;
import com.example.demo.entity.enumration.RoleEnum;
import com.example.demo.entity.user.Customer;
import com.example.demo.entity.user.UserBaseEntity;
import com.example.demo.model.user.request.RegisterCustomerRequest;
import com.example.demo.model.user.request.RegisterUserRequest;
import com.example.demo.repository.user.CustomerRepository;
import com.example.demo.repository.user.UserRepository;
import com.example.demo.service.user.CustomerService;
import com.example.demo.service.user.UserService;
import com.example.demo.utils.constants.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

}
