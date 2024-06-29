package com.yasar.entity;

import com.yasar.utility.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructor
@SuperBuilder
@Document
public class UserProfile extends BaseEntity {
    @Id
    private String id;
    private Long authId;
    private String userName;
    private String email;
    private String name;
    private String surName;
    private String phone;
    private String address;
    private String avatar;
    private String about;
    private LocalDate birthDate;
    @Builder.Default
    private EStatus status = EStatus.PENDING;
    private List<String> favMovies;
    private List<String> favGenres;
    private List<String> favComments;
    private Map<String, Double> ratings;
}
