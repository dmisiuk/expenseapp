package by.minsler.dao;

import java.util.ArrayList;

import by.minsler.beans.Expense;
import by.minsler.beans.Receiver;

public interface ExpenseReceiverDAO {

	ArrayList<Expense> getExpenses();

	Expense getExpense(int num);

	int addExpense(Expense expense);

	int delExpense(int num);

	int updateExpense(int num, Expense expense);

	ArrayList<Receiver> getReceivers();

	Receiver getReceiver(int num);

	int addReceiver(Receiver receiver);

	int delReceiver(int num);

	int updateReceiver(int num, Receiver receiver);
}
