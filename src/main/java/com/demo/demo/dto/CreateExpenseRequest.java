package com.demo.demo.dto;

import com.demo.demo.model.ExpenseType;
import com.demo.demo.model.PaymentMode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class CreateExpenseRequest {
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    private Double amount;
    private ExpenseType expenseType;
    private PaymentMode paymentMode;
    private String category;
    private String description;
    private LocalDate expenseDate;

    public String getCategory() {
        return category;
    }


    // getters & setters
}
