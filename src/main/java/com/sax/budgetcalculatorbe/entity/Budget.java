package com.sax.budgetcalculatorbe.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Budget {
    @Id
    private Long id;
    private BigDecimal amount;
    private String description;
}
