package com.portal.citizenportal.service;

import com.portal.citizenportal.model.Citizen;
import com.portal.citizenportal.model.Response;
import com.portal.citizenportal.repository.CitizenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CitizenService {
    @Autowired
    CitizenRepository repository;
    public void createCitizen(Citizen citizen) {
        repository.save(citizen);
    }
}
