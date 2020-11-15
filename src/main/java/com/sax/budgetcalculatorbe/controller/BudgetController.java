package com.sax.budgetcalculatorbe.controller;

import com.sax.budgetcalculatorbe.dto.BudgetDto;
import com.sax.budgetcalculatorbe.facade.BudgetFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/budgets")
public class BudgetController {
    private final BudgetFacade budgetFacade;

    public BudgetController(BudgetFacade budgetFacade) {
        this.budgetFacade = budgetFacade;
    }

    @GetMapping
    public ResponseEntity<List<BudgetDto>> findAll() {
        return new ResponseEntity<>(this.budgetFacade.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.budgetFacade.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<BudgetDto> save(@RequestBody BudgetDto budgetDto) {
        return new ResponseEntity<>(this.budgetFacade.saveOrUpdate(budgetDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<BudgetDto> update(@RequestBody BudgetDto budgetDto) {
        return new ResponseEntity<>(this.budgetFacade.saveOrUpdate(budgetDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.budgetFacade.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
