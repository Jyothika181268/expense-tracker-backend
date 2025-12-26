package com.demo.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    private String description;

    private LocalDate expenseDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    private LocalDateTime createdAt = LocalDateTime.now();
}

