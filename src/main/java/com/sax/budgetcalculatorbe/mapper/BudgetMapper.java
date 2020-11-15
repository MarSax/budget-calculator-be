package com.sax.budgetcalculatorbe.mapper;

import com.sax.budgetcalculatorbe.dto.BudgetDto;
import com.sax.budgetcalculatorbe.entity.Budget;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BudgetMapper {
    BudgetDto toDto(Budget budget);
    Budget toEntity(BudgetDto budgetDto);
}
