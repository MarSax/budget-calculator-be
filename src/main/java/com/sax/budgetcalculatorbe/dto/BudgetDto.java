package com.sax.budgetcalculatorbe.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BudgetDto {
    private Long id;
    private BigDecimal amount;
    private String description;
}
