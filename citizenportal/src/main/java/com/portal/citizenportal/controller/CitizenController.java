package com.portal.citizenportal.controller;

import ch.qos.logback.core.model.INamedModel;
import com.portal.citizenportal.contract.CitizenContract;
import com.portal.citizenportal.model.Citizen;

import com.portal.citizenportal.model.Response;
import com.portal.citizenportal.service.CitizenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Iterator;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("portal/")
public class CitizenController {

    private final CitizenService citizenService;

    @GetMapping("hello")
    public String helloWorld() {
        return "Hello";
    }

    @GetMapping("getcitizen/{id}")
    public CitizenContract getCitizenById(@PathVariable Integer id) {

       return citizenService.getCitizenById(id);
    }

    @SneakyThrows
    @PostMapping(path = "/create")
    public ResponseEntity<Response> save(@RequestBody @Valid CitizenContract citizens) {

        LocalDate yesterday = LocalDate.now().minusDays(365*18);
//        if(citizens.getDateOfBirth().isAfter(yesterday)){
//            return new ResponseEntity<>( Response.builder().message("The birth date must be greater or equal than 18").build(), HttpStatus.BAD_REQUEST);
//        }
        if(citizens.getCitizenName() == null){
            return new ResponseEntity<>( Response.builder().message("Name must not be null or blank").build(), HttpStatus.BAD_REQUEST);
        }
        if(citizens.getCitizenAddress() == null){
            return new ResponseEntity<>( Response.builder().message("Address must not be null or blank").build(), HttpStatus.BAD_REQUEST);
        }
        citizenService.createCitizen(citizens);
        return new ResponseEntity<>(
                Response.builder().message("SUCCESS").payload(citizens).build(), HttpStatus.OK);
    }


}
