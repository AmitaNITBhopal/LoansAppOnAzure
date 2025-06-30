package com.omegadummy.backend.mapper;

import com.omegadummy.backend.dto.CustomerDto;
import com.omegadummy.backend.entity.Applicant;

public class CustomerMapper {
	public static CustomerDto mapToCustomerDto(Applicant customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Applicant mapToCustomer(CustomerDto customerDto, Applicant customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

}
