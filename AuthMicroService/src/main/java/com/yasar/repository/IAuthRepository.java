package com.yasar.repository;

import com.yasar.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthRepository extends JpaRepository<Auth, Long> {
    Boolean existsByUserName(String userName);
}
