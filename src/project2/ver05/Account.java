package project2.ver05;

public class Account {

	public Account(int size) {}

	public void makeAccount(){
		new InsertQuery().execute();
	}

	public void depositMoney() {
		new depositQuery().execute();
	}

	public void withdrawMoney() {
		new withdrawQuery().execute();
	}

	public void showAccInfo() {
		new SelectSQLall().execute();
	}

}