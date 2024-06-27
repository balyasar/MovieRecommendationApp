package com.yasar.controller;

import com.yasar.dto.request.UserProfileSaveRequestDto;
import com.yasar.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.yasar.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
public class UserProfileController {
    private final UserProfileService service;

    @PostMapping(SAVE)
    public ResponseEntity<?> saveUserProfile(@RequestBody UserProfileSaveRequestDto dto) {
        return ResponseEntity.ok(service.saveUserProfile(dto));
    }

    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<String> activateStatus(@RequestParam Long authId) {
        return ResponseEntity.ok(service.activateStatus(authId));
    }

    // updateUserProfile eğer username veya email değişmiş ise auth microservicesinde update edilecek.
}
