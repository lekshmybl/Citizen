package com.portal.citizenportal.service;

import com.portal.citizenportal.contract.CitizenContract;
import com.portal.citizenportal.model.Citizen;
import com.portal.citizenportal.model.Response;
import com.portal.citizenportal.repository.CitizenRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CitizenService {

    private final CitizenRepository repository;

    private final ModelMapper modelMapper;
    public void createCitizen(CitizenContract citizenContract) {
        Citizen citizen = modelMapper.map(citizenContract, Citizen.class);
        repository.save(citizen);
        citizenContract.setId(citizen.getId());
    }

    public CitizenContract getCitizenById(int id) {
        CitizenContract citizen = modelMapper.map(repository.getReferenceById(id), CitizenContract.class);
        System.out.println(citizen.getCitizenName());
        return  citizen;

    }
}
