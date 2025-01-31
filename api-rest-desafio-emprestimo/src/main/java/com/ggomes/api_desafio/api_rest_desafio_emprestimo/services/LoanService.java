package com.ggomes.api_desafio.api_rest_desafio_emprestimo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ggomes.api_desafio.api_rest_desafio_emprestimo.dtos.CustomerRequestDTO;
import com.ggomes.api_desafio.api_rest_desafio_emprestimo.dtos.LoanResponseDTO;

@Service
public class LoanService{

	public List<LoanResponseDTO> determineLoans(CustomerRequestDTO dto) {
		int age = dto.getAge();
		int income = dto.getIncome();
		String location = dto.getLocation();
		
		List<LoanResponseDTO> loans = new ArrayList<>();
		
		if (income <= 3000) {
			loans.add(new LoanResponseDTO("PERSONAL", 4));
			loans.add(new LoanResponseDTO("GUARATEED", 3));
		}
		
		if (income <= 5000) {
			loans.add(new LoanResponseDTO("CONSIGNMENT", 2));
		}
		
		if (income > 3000 && income <= 5000 && age < 30 && "SP".equalsIgnoreCase(location)) {
			loans.add(new LoanResponseDTO("PERSONAL", 4));
			loans.add(new LoanResponseDTO("GUARATEED", 3));
		}
		
		return loans;
		
	}
}
