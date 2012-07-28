package by.minsler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.minsler.beans.Expense;
import by.minsler.beans.Receiver;
import by.minsler.db.ConnectionInit;

public class MysqlExpenseReceiverDAO implements ExpenseReceiverDAO {

	private static MysqlExpenseReceiverDAO inst;
	private static Connection connection;

	public static final String selectAllExpenses = "select * from expenses";
	public static final String selectByNumExpense = "select * from expenses where num = ?";
	public static final String insertExpense = "insert into expenses(num, paydate, receiver, value) values(?,?,?,?)";
	public static final String deleteByNumExpense = "delete from expenses where num=?";
	public static final String updateByNumExpense = "update expenses set paydate=?, receiver=?, value=? where num=?";
	public static final String selectAllReceivers = "select * from receivers";
	public static final String selectByNumReceiver = "select * from receivers where num = ?";
	public static final String insertReceiver = "insert into receivers(num, name) values(?,?)";
	public static final String deleteByNumReceiver = "delete from receivers where num=?";
	public static final String updateByNumReceiver = "update receivers set name=? where num=?";

	private static Statement selectAllExpensesStatement = null;
	private static PreparedStatement selectByNumExpenseStatement = null;
	private static PreparedStatement insertExpenseStatement = null;
	private static PreparedStatement deleteByNumExpenseStatement = null;
	private static PreparedStatement updateByNumExpenseStatement = null;
	private static Statement selectAllReceiverStatement = null;
	private static PreparedStatement selectByNumReceiverStatement = null;
	private static PreparedStatement insertReceiverStatement = null;
	private static PreparedStatement deleteByNumReceiverStatement = null;
	private static PreparedStatement updateByNumReceiverStatement = null;

	private MysqlExpenseReceiverDAO() {
		connection = ConnectionInit.getConnection();
		createStatements();
	}

	synchronized public static MysqlExpenseReceiverDAO getInstance() {
		if (inst == null) {
			inst = new MysqlExpenseReceiverDAO();
		}
		return inst;
	}

	private void createStatements() {
		try {
			selectAllExpensesStatement = connection.createStatement();
			selectByNumExpenseStatement = connection
					.prepareStatement(selectByNumExpense);
			insertExpenseStatement = connection.prepareStatement(insertExpense);
			deleteByNumExpenseStatement = connection
					.prepareStatement(deleteByNumExpense);
			updateByNumExpenseStatement = connection
					.prepareStatement(updateByNumExpense);
			selectAllReceiverStatement = connection.createStatement();
			selectByNumReceiverStatement = connection
					.prepareStatement(selectByNumReceiver);
			insertReceiverStatement = connection
					.prepareStatement(insertReceiver);
			deleteByNumReceiverStatement = connection
					.prepareStatement(deleteByNumReceiver);
			updateByNumReceiverStatement = connection
					.prepareStatement(updateByNumReceiver);

		} catch (SQLException e) {
			System.out.println("sql exception on create statements"
					+ e.getMessage());
		}
	}

	private void closeConnection() {
		if (connection != null) {
			System.out.print("close connection: ");
			try {
				connection.close();
				System.out.println("success");
			} catch (SQLException e) {
				System.out.println("error" + e.getMessage());
			}
		}
	}

	@Override
	public ArrayList<Expense> getExpenses() {
		ArrayList<Expense> list = new ArrayList<Expense>();
		try {
			ResultSet result = selectAllExpensesStatement
					.executeQuery(selectAllExpenses);
			while (result.next()) {
				Expense expense = new Expense();
				expense.setNum(result.getInt("num"));
				expense.setPaydate(result.getDate("paydate"));
				expense.setReceiver(result.getInt("receiver"));
				expense.setValue(result.getInt("value"));
				list.add(expense);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("error sql " + e.getMessage());
			return null;
		}

	}

	@Override
	public Expense getExpense(int num) {
		Expense expense = null;
		try {
			selectByNumExpenseStatement.clearParameters();
			selectByNumExpenseStatement.setInt(1, num);
			ResultSet result = selectByNumExpenseStatement.executeQuery();
			if (result.next()) {
				expense = new Expense();
				expense.setNum(result.getInt("num"));
				expense.setPaydate(result.getDate("paydate"));
				expense.setReceiver(result.getInt("receiver"));
				expense.setValue(result.getInt("value"));
			}
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return expense;
	}

	@Override
	public int addExpense(Expense expense) {
		int result = 0;
		try {
			insertExpenseStatement.clearParameters();
			insertExpenseStatement.setInt(1, expense.getNum());
			insertExpenseStatement.setDate(2, expense.getPaydate());
			insertExpenseStatement.setInt(3, expense.getReceiver());
			insertExpenseStatement.setInt(4, expense.getValue());
			result = insertExpenseStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public int delExpense(int num) {
		int result = 0;
		try {
			deleteByNumExpenseStatement.setInt(1, num);
			result = deleteByNumExpenseStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public int updateExpense(int num, Expense expense) {
		int result = 0;

		try {
			updateByNumExpenseStatement.setInt(4, num);
			updateByNumExpenseStatement.setDate(1, expense.getPaydate());
			updateByNumExpenseStatement.setInt(2, expense.getReceiver());
			updateByNumExpenseStatement.setInt(3, expense.getValue());
			result = updateByNumExpenseStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public ArrayList<Receiver> getReceivers() {
		ArrayList<Receiver> list = new ArrayList<Receiver>();
		try {
			ResultSet result = selectAllReceiverStatement
					.executeQuery(selectAllReceivers);
			while (result.next()) {
				Receiver receiver = new Receiver();
				receiver.setNum(result.getInt("num"));
				receiver.setName(result.getString("name"));
				list.add(receiver);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("error sql " + e.getMessage());
			return null;
		}
	}

	@Override
	public Receiver getReceiver(int num) {
		Receiver receiver = null;

		try {

			selectByNumReceiverStatement.setInt(1, num);
			ResultSet result = selectByNumReceiverStatement.executeQuery();
			if (result.next()) {
				receiver = new Receiver();
				receiver.setNum(result.getInt("num"));
				receiver.setName(result.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return receiver;
	}

	@Override
	public int addReceiver(Receiver receiver) {
		int result = 0;
		try {
			insertReceiverStatement.setInt(1, receiver.getNum());
			insertReceiverStatement.setString(2, receiver.getName());
			result = insertReceiverStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public int delReceiver(int num) {
		int result = 0;
		try {
			deleteByNumReceiverStatement.setInt(1, num);
			result = deleteByNumReceiverStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return result;
	}

	@Override
	public int updateReceiver(int num, Receiver receiver) {
		int result = 0;
		try {
			updateByNumReceiverStatement.setInt(2, num);
			updateByNumReceiverStatement.setString(1, receiver.getName());
			result = updateByNumReceiverStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql exception" + e.getMessage());
		}
		return result;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		closeConnection();
	}
}
