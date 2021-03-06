package com.example.ExpenseTracker.expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

	List<Expense> findAll();

	void save(Expense expense);

	Optional<Expense> findById(Long id);

	void deleteById(Long id);

}
