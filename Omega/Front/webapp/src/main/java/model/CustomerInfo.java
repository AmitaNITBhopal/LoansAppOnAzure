package model;

import org.springframework.stereotype.Component;

import lombok.*;

@Component("customerInfo")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class CustomerInfo {
	private String name;
	private String email;
	private double loanAmount;
	private String mobileNumber;
}
