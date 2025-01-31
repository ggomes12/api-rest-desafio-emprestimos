package com.ggomes.api_desafio.api_rest_desafio_emprestimo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequestDTO {
    private int age;
    private String name;
    private int income;
    private String location;
}