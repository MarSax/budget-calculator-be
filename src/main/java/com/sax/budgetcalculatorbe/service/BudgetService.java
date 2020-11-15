package com.sax.budgetcalculatorbe.service;

import com.sax.budgetcalculatorbe.entity.Budget;
import com.sax.budgetcalculatorbe.repository.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {
    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public List<Budget> findAll() {
        return this.budgetRepository.findAll();
    }

    public Budget findById(Long id) {
        return this.budgetRepository.findById(id).orElse(null);
    }

    public Budget saveOrUpdate(Budget budget) {
        return this.budgetRepository.save(budget);
    }

    public void delete(Long id) {
        this.budgetRepository.deleteById(id);
    }
}
