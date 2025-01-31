package com.ggomes.api_desafio.api_rest_desafio_emprestimo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggomes.api_desafio.api_rest_desafio_emprestimo.dtos.CustomerRequestDTO;
import com.ggomes.api_desafio.api_rest_desafio_emprestimo.dtos.LoanResponseDTO;
import com.ggomes.api_desafio.api_rest_desafio_emprestimo.services.LoanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer-loans")
@RequiredArgsConstructor
@Slf4j
public class LoanController {
	
	@Autowired
	private LoanService loanService;

    @PostMapping
    @Operation(
            summary = "Determines the loans available to a customer",
            description = "This endpoint receives information from the customer and returns which types of loans it can access, including interest rates."
        )
    @ApiResponse(responseCode = "200", description = "Returns the customer's name and the list of loans available.")
        
    public ResponseEntity<Map<String, Object>> getEligibleLoans(@RequestBody CustomerRequestDTO dto) {
    	
    	log.info("Request received: {}", dto);
        List<LoanResponseDTO> loans = loanService.determineLoans(dto);
        
        log.info("Loans determined: {}", loans);
        Map<String, Object> response = new HashMap<>();
        response.put("customer", dto.getName());
        response.put("loans", loans);
        
        return ResponseEntity.ok(response);
    }

}
