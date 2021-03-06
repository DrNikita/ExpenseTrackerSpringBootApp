package com.example.ExpenseTracker.expense;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "expenses")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "description")
	private String expenseName;

	private BigDecimal amount;

	private String note;

	@Column(name = "created_at")
	private Long createdAt;

	public Expense(String expenseName, BigDecimal amount, String note, Long createdAt) {
		this.expenseName = expenseName;
		this.amount = amount;
		this.note = note;
		this.createdAt = createdAt;
	}

}
