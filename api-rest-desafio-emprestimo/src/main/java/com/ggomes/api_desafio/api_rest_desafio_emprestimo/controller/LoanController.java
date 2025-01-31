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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customer-loans")
@RequiredArgsConstructor
public class LoanController {
	
	@Autowired
	private LoanService loanService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> getEligibleLoans(@RequestBody CustomerRequestDTO dto) {
    	
        List<LoanResponseDTO> loans = loanService.determineLoans(dto);
        
        Map<String, Object> response = new HashMap<>();
        response.put("customer", dto.getName());
        response.put("loans", loans);
        
        return ResponseEntity.ok(response);
    }

}
