package com.yasar.entity;

import com.yasar.utility.ERole;
import com.yasar.utility.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructor
@Builder
@Entity
@SuperBuilder
@Table(name = "tbl_auth")
public class Auth extends BaseEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID için otomatik artan bir HB sequence oluşturur.
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String activationCode;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.PENDING;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ERole role = ERole.USER;



}
