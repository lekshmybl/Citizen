package com.portal.citizenportal.contract;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class CitizenContract {

    int id;

    @NotEmpty(message="Name cannot be Empty")
    @NotNull(message="Name cannot be null")
    String citizenName;

    @NotEmpty(message="Name cannot be Empty")
    @NotNull(message="Name cannot be null")
    String citizenAddress;

    String citizenPhone;

    LocalDate dateOfBirth;
}
