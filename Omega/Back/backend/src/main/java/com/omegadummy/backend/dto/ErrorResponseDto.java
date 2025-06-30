package com.omegadummy.backend.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;

//import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ErrorResponseDto {
	
	private  String apiPath;

    private HttpStatusCode errorCode;

    private  String errorMessage;

    private LocalDateTime errorTime;
}
