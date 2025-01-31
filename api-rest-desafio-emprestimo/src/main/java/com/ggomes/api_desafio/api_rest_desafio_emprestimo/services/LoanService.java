package com.ggomes.api_desafio.api_rest_desafio_emprestimo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ggomes.api_desafio.api_rest_desafio_emprestimo.dtos.CustomerRequestDTO;
import com.ggomes.api_desafio.api_rest_desafio_emprestimo.dtos.LoanResponseDTO;
import com.ggomes.api_desafio.api_rest_desafio_emprestimo.exceptions.UnprocessableEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoanService{

	public List<LoanResponseDTO> determineLoans(CustomerRequestDTO dto) {
		
		 if (dto.getCpf() == null || dto.getCpf().isEmpty()) {
	            throw new UnprocessableEntity("The CPF cannot be empty.");
	        }
		 
        if (dto.getIncome() < 0) {
            throw new UnprocessableEntity("The income cannot be negative.");
        }
		
		int age = dto.getAge();
		int income = dto.getIncome();
		String location = dto.getLocation();
		
		log.info("Determining loans for customer: {}", dto);
		List<LoanResponseDTO> loans = new ArrayList<>();
		
		if (income <= 3000) {
			loans.add(new LoanResponseDTO("PERSONAL", 4));
			loans.add(new LoanResponseDTO("GUARANTEED", 3));
			log.info("Added PERSONAL and GUARANTEED loans");
		}
		
		if (income <= 5000) {
			loans.add(new LoanResponseDTO("CONSIGNMENT", 2));
			log.info("Added CONSIGNMENT loan");
		}
		
		if (income > 3000 && income <= 5000 && age < 30 && "SP".equalsIgnoreCase(location)) {
			loans.add(new LoanResponseDTO("PERSONAL", 4));
			loans.add(new LoanResponseDTO("GUARANTEED", 3));
			log.info("Added PERSONAL and GUARANTEED loans");
		}
		
		log.info("Loans determined: {}", loans);
		return loans;
		
	}
}
