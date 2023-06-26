package com.portal.citizenportal.service;

import com.portal.citizenportal.contract.CitizenContract;
import com.portal.citizenportal.model.Citizen;
import com.portal.citizenportal.repository.CitizenRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
