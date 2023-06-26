package com.portal.citizenportal.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portal.citizenportal.validation.BirthDate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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

    @Schema(description = "Mobile number is mandatory, and should be valid '\\d{10}' (eg. 9544754386)")
    @Pattern(regexp = "\\d{10}",message="Mobile should have 10 digits")
    String citizenPhone;

    @BirthDate(message = "The birth date must be greater or equal than 18")
    @Past(message = "The date of birth must be in the past.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfBirth;
}
