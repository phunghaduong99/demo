//package com.example.demo.api.auth;
//
//import com.example.demo.model.user.UserDto;
//import com.example.demo.model.user.request.AuthenticateRequest;
//import com.example.demo.model.user.response.AuthenticateResponse;
//import com.example.demo.model.user.response.LogoutResponse;
//import com.example.demo.service.user.auth.AuthenticationService;
//import com.example.demo.utils.constants.Message;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//
//@RestController
//@RequestMapping("/auth")
//@RequiredArgsConstructor
//@Tag(name = "Authentication", description = "Authentication")
//public class AuthenticationApi {
//    private final AuthenticationService authenticateService;
//
//    @Operation(summary = "Validate token")
//    @PreAuthorize("permitAll")
//    @GetMapping("/validate-token")
//    public ResponseEntity<Boolean> validateToken(@RequestParam String token) {
//        boolean isValid = authenticateService.validateToken(token);
//        return ResponseEntity.ok(isValid);
//    }
//    @Operation(summary = "Login")
//    @ApiResponse(responseCode = "200", description = "Login successfully",  content = {@Content(mediaType = "application/json")})
//    @PreAuthorize("permitAll")
//    @PostMapping("/login")
//    public ResponseEntity<AuthenticateResponse> login(@Valid @RequestBody AuthenticateRequest request) {
//        AuthenticateResponse response = authenticateService.login(request);
//        return ResponseEntity.ok(response);
//
//    }
//
//
//    @GetMapping("/profile")
//    @PreAuthorize("hasAuthority('READ_MY_PROFILE')")
//    public ResponseEntity<UserDto> profile() {
//        UserDto userDto = authenticateService.findLoggedInUser();
//        return ResponseEntity.ok(userDto);
//    }
//    @Operation(summary = "Logout")
//    @ApiResponse(responseCode = "200", description = "Logout successfully",  content = {@Content(mediaType = "application/json")})
//    @PreAuthorize("permitAll")
//    @PostMapping("/logout")
//    public ResponseEntity<LogoutResponse> logout(HttpServletRequest request){
//        authenticateService.logout(request);
//        LogoutResponse response = new LogoutResponse(Message.LOGOUT_SUCCESSFULLY, 200, HttpStatus.OK, LocalDateTime.now());
//        return ResponseEntity.ok(response);
//    }
//}
