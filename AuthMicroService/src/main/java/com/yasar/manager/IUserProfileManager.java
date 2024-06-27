package com.yasar.manager;

import com.yasar.dto.request.UserProfileSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static com.yasar.config.RestApis.*;

@FeignClient(url = "http://localhost:8091/api/v1/user", name = "auth-userprofile", dismiss404 = true)
public interface IUserProfileManager {
    @PostMapping(SAVE)
    public ResponseEntity<?> saveUserProfile(@RequestBody UserProfileSaveRequestDto dto);

    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<String> activateStatus(@RequestParam Long authId);
}
