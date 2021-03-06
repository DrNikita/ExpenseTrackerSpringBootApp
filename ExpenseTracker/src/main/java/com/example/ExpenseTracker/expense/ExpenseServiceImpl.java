package com.example.ExpenseTracker.expense;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	@Override
	public List<Expense> findAll() {
		return expenseRepository.findAll();
	}

	@Override
	public void save(Expense expense) {
		expense.setCreatedAt(System.currentTimeMillis());
		expenseRepository.save(expense);
	}

	@Override
	public Optional<Expense> findById(Long id) {
		return expenseRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		expenseRepository.deleteById(id);
	}

}
