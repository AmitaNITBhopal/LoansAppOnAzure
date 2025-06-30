package com.omegadummy.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString 
@Table(name="customerTbl")
public class Applicant extends  BaseEntity {

	public Applicant() {
		super("DefaultUser");
	}
	
	public Applicant(Long customerId, String name, String email, String mobileNumber) {
		
		super("DefaultUser");
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
	private Long customerId;
	
	private String name;
	
	private String email;
	
	/* private double loanAmount; */
	
	@Column(name="mobile_number")
	private String mobileNumber;
}
