package com.example.ExpenseTracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.ExpenseTracker.expense.Expense;
import com.example.ExpenseTracker.expense.ExpenseService;

@Controller
public class FrontController {

	@Autowired
	ExpenseService expenseService;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("message", "List of expenses:");
		List<Expense> expenses = expenseService.findAll();
		mav.addObject("expenses", expenses);
		return mav;
	}

	@RequestMapping("/expense")
	public ModelAndView addExpense() {
		ModelAndView mav = new ModelAndView("expense");
		mav.addObject("expense", new Expense());
		return mav;
	}

	@RequestMapping(value = "/expense", method = RequestMethod.POST)
	public String saveExpense(@ModelAttribute("expense") Expense expense) {
		expenseService.save(expense);
		return "redirect:/";
	}

	@RequestMapping(value = "/expense/{id}")
	public ModelAndView editExpense(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("expense");
		Optional<Expense> expense = expenseService.findById(id);

		if (expense.isPresent()) {
			mav.addObject("expense", expense.get());
			return mav;
		} else {
			return new ModelAndView("error");
		}
	}

	@RequestMapping(value = "/expense/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {

		Optional<Expense> expense = expenseService.findById(id);

		if (expense.isPresent()) {
			expenseService.deleteById(id);
			return "redirect:/";
		} else {
			return "redirect:/error";
		}
	}

}
