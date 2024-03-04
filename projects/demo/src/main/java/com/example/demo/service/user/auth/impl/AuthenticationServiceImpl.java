package com.example.demo.service.user.auth.impl;

import com.example.demo.config.jwt.util.JwtTokenService;
import com.example.demo.converter.user.UserConverter;
import com.example.demo.entity.user.Customer;
import com.example.demo.entity.user.Seller;
import com.example.demo.entity.user.auth.Token;
import com.example.demo.entity.user.UserBaseEntity;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.user.UserDto;
import com.example.demo.model.user.request.AuthenticateRequest;
import com.example.demo.model.user.request.RegisterCustomerRequest;
import com.example.demo.model.user.request.RegisterSellerRequest;
import com.example.demo.model.user.response.AuthenticateResponse;
import com.example.demo.model.user.response.RegisterResponse;
import com.example.demo.repository.user.CustomerRepository;
import com.example.demo.repository.user.SellerRepository;
import com.example.demo.repository.user.UserRepository;
import com.example.demo.repository.user.auth.TokenRepository;
import com.example.demo.service.user.auth.AuthenticationService;
import com.example.demo.utils.constants.Message;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final CustomerRepository customerRepository;
    private final SellerRepository sellerRepository;
    private final UserConverter userConverter;

    @Override
    public RegisterResponse registerOneCustomer(RegisterCustomerRequest request) {
        Customer customer = (Customer) userConverter.toEntity(request);
        customerRepository.save(customer);
        String jwt = jwtTokenService.generateToken(customer, jwtTokenService.generateExtraClaims(customer));
        saverUserToken(customer, jwt);
        RegisterResponse response = userConverter.toDto(customer);
        response.setJwt(jwt);
        return response;
    }

    @Override
    public RegisterResponse registerOneSeller(RegisterSellerRequest request) {
        Seller seller = (Seller) userConverter.toEntity(request);
        sellerRepository.save(seller);
        String jwt = jwtTokenService.generateToken(seller, jwtTokenService.generateExtraClaims(seller));
        saverUserToken(seller, jwt);
        RegisterResponse response = userConverter.toDto(seller);
        response.setJwt(jwt);
        return response;
    }


    @Override
    public AuthenticateResponse login(AuthenticateRequest request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        authenticationManager.authenticate(authentication);
        UserBaseEntity users = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(Message.USER_NOT_FOUND));
        String jwt = jwtTokenService.generateToken(users, jwtTokenService.generateExtraClaims(users));
        saverUserToken(users, jwt);
        return new AuthenticateResponse(jwt);
    }

    private void saverUserToken(UserBaseEntity users, String jwt) {
        Token token = new Token();
        token.setToken(jwt);
        token.setUserBaseEntity(users);
        token.setValid(true);
        token.setExpiration(jwtTokenService.extractExpiration(jwt));
        tokenRepository.save(token);
    }


    @Override
    public boolean validateToken(String token) {
        try {
            jwtTokenService.extractUsername(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public UserDto findLoggedInUser() {
        //UserDto useDto = new UserDto();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = null;
        if (auth instanceof UsernamePasswordAuthenticationToken authToke) {
            username = (String) authToke.getPrincipal();
        }

        return userRepository.findByUsername(username).map((dto) -> new UserDto(dto.getId(), dto.getName(), dto.getUsername(), dto.getRole().name()))
                .orElseThrow(() -> new UsernameNotFoundException(Message.USER_NOT_FOUND));
    }

    @Override
    public void logout(HttpServletRequest request) {
      String jwt =  jwtTokenService.extractJwtFromRequest(request);
      if(!StringUtils.hasText(jwt)){
          throw new NotFoundException(Message.NOT_AUTHENTICATION);
      }
        Optional<Token> token = tokenRepository.findByToken(jwt);
      if(token.isPresent() && token.get().isValid()){
          token.get().setValid(false);
          tokenRepository.save(token.get());
      }
    }
}
