package com.example.controller.impl;

import com.example.controller.IRestAuthenticationController;
import com.example.controller.RestBaseController;
import com.example.controller.RootEntity;
import com.example.dto.AuthRequest;
import com.example.dto.DtoUser;
import com.example.service.IAuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class RestAuthenticationControllerImpl extends RestBaseController
        implements IRestAuthenticationController {

    private final IAuthenticationService authenticationService;

    public RestAuthenticationControllerImpl(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest authRequest) {
        return ok(authenticationService.register(authRequest));
    }
}
