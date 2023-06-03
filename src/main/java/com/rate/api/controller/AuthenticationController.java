package com.rate.api.controller;

import com.rate.api.dto.AuthenticationRequest;
import com.rate.api.dto.AuthenticationResponse;
import com.rate.api.model.User;
import com.rate.api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping(path = "login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        System.out.println("In AuthenticationController.authenticate()");
        System.out.println(request);
        return ResponseEntity.status(HttpStatus.OK).body(
                authenticationService.authenticate(request)
        );
    }

//    @PostMapping("/login-success")
//    public ResponseEntity<User> getLoginInfo(@AuthenticationPrincipal User user,
//                                             HttpServletResponse response) throws IOException {
//        System.out.println("*********************************");
//        System.out.println("SUCCESS");
//        System.out.println("*********************************");
//        if (user.getAuthorities()
//                .contains(new SimpleGrantedAuthority(Role.LECTURER.name())) || user.getAuthorities()
//                .contains(new SimpleGrantedAuthority(Role.STUDENT.name()))) {
//            response.sendRedirect("/subjects");
//        } else if (user.getAuthorities()
//                .contains(new SimpleGrantedAuthority(Role.ADMIN.name()))) {
//            response.sendRedirect("/admins/departments");
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(user);
//    }

    @PostMapping("/login-success")
    public ResponseEntity<String> getRole(@AuthenticationPrincipal User user) {
        System.out.println("*********************************");
        System.out.println("SUCCESS");
        System.out.println("*********************************");

        return ResponseEntity.status(HttpStatus.OK).body(user.getRole().getValue());
    }
}
