package com.omegadummy.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omegadummy.backend.entity.Applicant;

public interface CustomerRepository extends JpaRepository<Applicant, Long>{
	Optional<Applicant> findByMobileNumber(String mobileNumber);
	
}
