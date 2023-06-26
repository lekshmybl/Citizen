package com.portal.citizenportal.controller;

import com.portal.citizenportal.model.Citizen;
import com.portal.citizenportal.model.Response;
import com.portal.citizenportal.service.CitizenService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("portal/")
public class CitizenController {
@Autowired
    private CitizenService citizenService;

    @GetMapping("hello")
    public String helloWorld() {
        return "Hello";
    }

    @SneakyThrows
    @PostMapping(path = "/create")
    public ResponseEntity<Response> save(@RequestBody Citizen citizens) {
        if(citizens.getDateOfBirth().isAfter(LocalDate.now()) == true){
            return new ResponseEntity<>( Response.builder().message("Error in date").build(), HttpStatus.BAD_REQUEST);
        }
        if(citizens.getCitizenName() != null){
            return new ResponseEntity<>( Response.builder().message("Name could not be null").build(), HttpStatus.BAD_REQUEST);
        }
        if(citizens.getCitizenAddress() != null){
            return new ResponseEntity<>( Response.builder().message("Address could not be null").build(), HttpStatus.BAD_REQUEST);
        }
        citizenService.createCitizen(citizens);
        return new ResponseEntity<>(
                Response.builder().message("SUCCESS").build(), HttpStatus.OK);
    }


}
