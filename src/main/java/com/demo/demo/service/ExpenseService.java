package com.demo.demo.service;

import com.demo.demo.dto.CreateExpenseRequest;
import com.demo.demo.model.Category;
import com.demo.demo.model.Expense;
import com.demo.demo.repository.CategoryRepository;
import com.demo.demo.repository.ExpenseRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    public ExpenseService(ExpenseRepository expenseRepository,
                          CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    public Expense createExpense(CreateExpenseRequest request) {

        Category category = categoryRepository
                .findByName(request.getCategory())
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setName(request.getCategory());
                    return categoryRepository.save(newCategory);
                });

        Expense expense = new Expense();
        expense.setAmount(request.getAmount());
        expense.setExpenseType(request.getExpenseType());
        expense.setPaymentMode(request.getPaymentMode());
        expense.setCategory(category);
        expense.setDescription(request.getDescription());
        expense.setExpenseDate(request.getExpenseDate());

        return expenseRepository.save(expense);
    }
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll(
                Sort.by(Sort.Direction.DESC, "expenseDate")
        );
    }
}
