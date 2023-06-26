package com.portal.citizenportal.repository;

import com.portal.citizenportal.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen , Integer> {
}
