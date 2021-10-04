package com.example.shoppingonline.controller;




import com.example.shoppingonline.DTO.LoginRequest;
import com.example.shoppingonline.DTO.LoginResponse;
import com.example.shoppingonline.config.jwt.JwtUtils;
import com.example.shoppingonline.service.jwt.JwtUserDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final
    AuthenticationManager authenticationManager;
    private final
    JwtUserDetailService jwtUserDetailsService;
    private final
    JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, JwtUserDetailService jwtUserDetailsService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        authenticate(loginRequest.getUserName(),loginRequest.getPassword());
        UserDetails u = jwtUserDetailsService.loadUserByUsername(loginRequest.getUserName());
        final String token = jwtUtils.generateToken(u);

        System.out.println(Thread.currentThread().getId());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    private void authenticate(String name, String pass) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(name,pass));
    }
}
