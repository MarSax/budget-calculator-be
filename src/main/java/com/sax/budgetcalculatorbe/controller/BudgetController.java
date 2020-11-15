package com.sax.budgetcalculatorbe.controller;

import com.sax.budgetcalculatorbe.dto.BudgetDto;
import com.sax.budgetcalculatorbe.facade.BudgetFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "rest/budgets")
public class BudgetController {
    private final BudgetFacade budgetFacade;

    public BudgetController(BudgetFacade budgetFacade) {
        this.budgetFacade = budgetFacade;
    }

    public ResponseEntity<List<BudgetDto>> findAll() {
        return new ResponseEntity<>(this.budgetFacade.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<BudgetDto> findById(Long id) {
        return new ResponseEntity<>(this.budgetFacade.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<BudgetDto> saveOrUpdate(BudgetDto budgetDto) {
        return new ResponseEntity<>(this.budgetFacade.saveOrUpdate(budgetDto), HttpStatus.CREATED);
    }

    public ResponseEntity<Void> delete(Long id) {
        this.budgetFacade.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
