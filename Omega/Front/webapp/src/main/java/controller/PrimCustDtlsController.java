package controller;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;


import model.CustomerInfo;

@Controller
public class PrimCustDtlsController {

	@PostMapping("/submit")
	public String CapturePrimCustomerDtls(@ModelAttribute("inName") String name, Model model) {
		System.out.println("\n Inside CapturePrimCustomerDtls :\n");
		//System.out.println(txt + " :\n");
		System.out.println("customerInfo :\n");
		System.out.println(name); 
		
		CustomerInfo resInfo = SubmitData(name);
		if(resInfo != null) {
			System.out.println("Success!");
			model.addAttribute("txt", "Success!");
			model.addAttribute("resInfo", resInfo);
		} else {
			model.addAttribute("txt", "Failure!");
		}
		return "Dashboard";
	}
	
	@GetMapping("/api") 
	public String ShowIndexHTML(Model model) {
		System.out.println("\n Inside ShowIndexHTML :\n");
		CustomerInfo info = new CustomerInfo();
		info.setName("amita");
		String str = "abc";
		model.addAttribute("info",info);
		 
		 
		return "Dashboard";
	}
	
	public CustomerInfo SubmitData(String Name) {
URI uri;
		String number = "9090909090";
		CustomerInfo info = null;
        try {
			uri = UriComponentsBuilder.fromUriString("http://localhost:8090/api/fetch")
					.queryParam("mobileNumber", "{number}")
					.build(number);
			
			RestClient restClient = RestClient.create();
			info = restClient.get()
										.uri(uri)
										.accept(MediaType.APPLICATION_JSON)
										//.header("X-Api-Key", "GsDrLfXDz3vHetT37vUQqQ==fLrCa1LH9youyDna")
										.retrieve()
										.body(CustomerInfo.class);
			System.out.println(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
	
	@GetMapping("/") 
	public String ShowIndex(Model model) {
		System.out.println("\n Inside ShowIndexHTML :\n");
		CustomerInfo info = new CustomerInfo();
		info.setName("amita");
		String str = "abc";
		model.addAttribute("info",info);
		 
		 
		return "Index";
	}
}
