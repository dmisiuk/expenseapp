package by.minsler.beans;

import java.sql.Date;

public class Expense {

	private int num;
	private Date paydate;
	private int receiver;
	private int value;

	public Expense() {
	}

	public Expense(int num, Date paydate, int receiver, int value) {
		this.num = num;
		this.receiver = receiver;
		this.paydate = paydate;
		this.value = value;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getPaydate() {
		return paydate;
	}

	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "num: " + this.getNum() + ", paydate: " + this.getPaydate()
				+ ", receiver: " + this.getReceiver() + ", value: "
				+ this.getValue();
	}

}
