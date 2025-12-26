package com.demo.demo.controller;

import com.demo.demo.dto.CreateExpenseRequest;
import com.demo.demo.model.Expense;
import com.demo.demo.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Expense addExpense(@RequestBody CreateExpenseRequest request) {
        return expenseService.createExpense(request);
    }
}
