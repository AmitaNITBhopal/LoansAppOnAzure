package com.omegadummy.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omegadummy.backend.constants.AccountsConstants;
import com.omegadummy.backend.dto.CustomerDto;
import com.omegadummy.backend.dto.ResponseDto;
import com.omegadummy.backend.service.CustomerService;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CustomerController {
	
	private CustomerService customerService;
	
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
    	customerService.createCustomer(customerDto);
        return ResponseEntity
                .status(HttpStatusCode.valueOf(201))
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }
    
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                                                               @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                               String mobileNumber) {
    	
        CustomerDto customerDto = customerService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

}
