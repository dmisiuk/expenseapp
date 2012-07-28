package by.minsler.beans;

public class Receiver {

	private static Object o = new Object();

	private int num;
	private String name;

	public Receiver() {
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "num: " + this.getNum() + ", name: " + this.getName();
	}

}
