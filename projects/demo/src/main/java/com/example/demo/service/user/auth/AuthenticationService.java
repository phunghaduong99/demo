package com.example.demo.service.user.auth;


import com.example.demo.model.user.UserDto;
import com.example.demo.model.user.request.AuthenticateRequest;
import com.example.demo.model.user.request.RegisterCustomerRequest;
import com.example.demo.model.user.request.RegisterSellerRequest;
import com.example.demo.model.user.request.RegisterUserRequest;
import com.example.demo.model.user.response.AuthenticateResponse;
import com.example.demo.model.user.response.RegisterResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    RegisterResponse registerOneCustomer(RegisterCustomerRequest request);
    RegisterResponse registerOneSeller(RegisterSellerRequest request);

    AuthenticateResponse login(AuthenticateRequest request);

    boolean validateToken(String token);

    UserDto findLoggedInUser();

    void logout(HttpServletRequest request);
}
