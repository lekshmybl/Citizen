package com.portal.citizenportal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "citizendata1")
public class Citizen {

    @NotNull(message="Id Cannot be null")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @NotBlank(message="Name cannot be Blank")
    @NotNull(message="Name cannot be null")
    @Column(name = "name")
    String citizenName;

    @NotNull(message="addresscCannot be null")
    @Column(name = "address")
    String citizenAddress;

    @Column(name = "phone")
    String citizenPhone;

    @Column(name = "dob")
    LocalDate dateOfBirth;

}
