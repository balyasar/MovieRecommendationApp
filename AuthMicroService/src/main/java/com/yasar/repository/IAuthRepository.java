package com.yasar.repository;

import com.yasar.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthRepository extends JpaRepository<Auth, Long> {
    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);

    Optional<Auth> findByUserNameAndPassword(String password, String password1);
}
