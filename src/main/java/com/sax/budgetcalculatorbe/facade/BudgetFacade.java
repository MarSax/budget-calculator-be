package com.sax.budgetcalculatorbe.facade;

import com.sax.budgetcalculatorbe.dto.BudgetDto;
import com.sax.budgetcalculatorbe.entity.Budget;
import com.sax.budgetcalculatorbe.mapper.BudgetMapper;
import com.sax.budgetcalculatorbe.service.BudgetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BudgetFacade {
    private final BudgetService budgetService;
    private final BudgetMapper budgetMapper;

    public BudgetFacade(BudgetService budgetService, BudgetMapper budgetMapper) {
        this.budgetService = budgetService;
        this.budgetMapper = budgetMapper;
    }

    public List<BudgetDto> findAll() {
        return this.budgetService.findAll().stream()
                .map(this.budgetMapper::toDto)
                .collect(Collectors.toList());
    }

    public BudgetDto findById(Long id) {
        return this.budgetMapper.toDto(this.budgetService.findById(id));
    }

    public BudgetDto saveOrUpdate(BudgetDto budgetDto) {
        Budget oldBudget = this.budgetService.findById(budgetDto.getId());
        return this.budgetMapper.toDto(this.budgetService.saveOrUpdate(this.budgetMapper.toEntity(budgetDto)));
    }

    public void delete(Long id) {
        this.budgetService.delete(id);
    }
}
