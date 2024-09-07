package tn.barmegtech.workshopformationspring.controller;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.barmegtech.workshopformationspring.dto.AuthenticationRequest;
import tn.barmegtech.workshopformationspring.dto.AuthenticationResponse;
import tn.barmegtech.workshopformationspring.dto.DirecteurDto;
import tn.barmegtech.workshopformationspring.dto.Response;
import tn.barmegtech.workshopformationspring.serviceimpl.AuthenticationService;
import tn.barmegtech.workshopformationspring.serviceimpl.UserService;


@RestController
    @RequestMapping("/api/v1/auth")
    @RequiredArgsConstructor
    public class AuthController {

        private final AuthenticationService service;
        private final UserService userService;

        @PostMapping("/register")
        public ResponseEntity<Response> register(
                @RequestBody @Valid DirecteurDto userRequest,
                HttpServletRequest request
        )  {
            return service.register(userRequest,request);
        }
        @PostMapping("/authenticate")
        public ResponseEntity<AuthenticationResponse> authenticate(
                @RequestBody AuthenticationRequest request
        ) {
            return ResponseEntity.ok(service.authenticate(request));
        }

        @PostMapping("/refresh-token")
        public void refreshToken(
                HttpServletRequest request,
                HttpServletResponse response
        ) throws IOException {
            service.refreshToken(request, response);
        }





}
