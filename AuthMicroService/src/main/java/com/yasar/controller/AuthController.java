package com.yasar.controller;

import com.yasar.dto.request.ActivateRequestDto;
import com.yasar.dto.request.RegisterRequestDto;
import com.yasar.dto.response.RegisterResponseDto;
import com.yasar.entity.Auth;
import com.yasar.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yasar.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {
    private final AuthService service;

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    //activate --> aktivasyon kodu ile authun statüsünü pendingden active'e çekecek.
    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<String> activateStatus(@RequestBody ActivateRequestDto dto) {
        return ResponseEntity.ok(service.activateStatus(dto));
    }


}
