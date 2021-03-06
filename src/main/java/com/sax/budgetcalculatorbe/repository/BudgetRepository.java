package com.sax.budgetcalculatorbe.repository;

import com.sax.budgetcalculatorbe.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
