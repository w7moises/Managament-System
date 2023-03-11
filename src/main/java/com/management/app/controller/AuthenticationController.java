package com.management.app.controller;

import com.management.app.dto.UserDto;
import com.management.app.dto.auth.AuthenticationRequest;
import com.management.app.dto.auth.AuthenticationResponse;
import com.management.app.entity.Role;
import com.management.app.service.impl.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  private final AuthenticationService service;

  public AuthenticationController(AuthenticationService service) {
    this.service = service;
  }

  @PostMapping("/register/role/{role}")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid UserDto request, @PathVariable Role role) {
    return ResponseEntity.ok(service.register(request,role));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody @Valid AuthenticationRequest request) {
    return ResponseEntity.ok(service.authenticate(request));
  }


}
