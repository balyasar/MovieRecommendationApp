package com.yasar.controller;

import com.yasar.dto.request.ActivateRequestDto;
import com.yasar.dto.request.LoginRequestDto;
import com.yasar.dto.request.RegisterRequestDto;
import com.yasar.dto.request.UpdateEmailAndUserNameRequestDto;
import com.yasar.dto.response.RegisterResponseDto;
import com.yasar.service.AuthService;
import com.yasar.utility.JwtTokenManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.yasar.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {
    private final AuthService service;
    private final JwtTokenManager tokenManager;

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    //activate --> aktivasyon kodu ile authun statüsünü pendingden active'e çekecek.
    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<String> activateStatus(@RequestBody ActivateRequestDto dto) {
        return ResponseEntity.ok(service.activateStatus(dto));
    }

    // token olusturma ve verify etmek için deneme amaclı end pointler
    @GetMapping("/create-token-by-id")
    private Optional<String> createToken(Long id) {
        return tokenManager.createToken(id);
    }

    @GetMapping("/create-token-by-id-and-role")
    private Optional<String> createToken(Long id, String role) {
        return tokenManager.createToken(id, role);
    }

    @GetMapping("/get-role-by-token")
    private Optional<String> getRoleByToken(String token) {
        return tokenManager.getAuthRoleFromToken(token);
    }

    @GetMapping("/get-id-by-token")
    private Optional<Long> getAuthIdByToken(String token) {
        return tokenManager.getAuthIdFromToken(token);
    }

    @PostMapping(LOGIN)
    private ResponseEntity<String> login(@RequestBody @Valid LoginRequestDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<String> updateEmailAndUserName (@RequestBody @Valid UpdateEmailAndUserNameRequestDto dto){
        return ResponseEntity.ok(service.updateEmailAndUserName(dto));
    }

}
