package com.yasar.manager;

import com.yasar.dto.request.UpdateEmailAndUserNameRequestDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.yasar.config.RestApis.UPDATE;

@FeignClient(url = "http://localhost:8090/api/v1/auth",name = "auth-microservice")
public interface IAuthManager {
    @PutMapping(UPDATE)
    public ResponseEntity<String> updateEmailAndUserName (@RequestBody @Valid UpdateEmailAndUserNameRequestDto dto);
}
