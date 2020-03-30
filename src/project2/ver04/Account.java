package project2.ver04;
import java.io.Serializable;

abstract class Account implements Serializable{

	String accNum, name;
	int balance;

	public Account(String accNum, String name, int balance) {
		this.accNum = accNum;
		this.name = name;
		this.balance = balance;
	}

	public void accInfo() {
		System.out.println("----------");
		System.out.println("계좌번호> "+accNum);
		System.out.println("고객이름> "+name);
		System.out.println("잔고> "+balance);
	}

	public void interestRate(int money) {

	}
	@Override
	public String toString() {
		return "계좌번호> "+accNum+"\n고객이름> "+name+"\n잔고> "+balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accNum == null) ? 0 : accNum.hashCode());
		//result = prime * result + balance;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Account account = (Account)obj;
		if(account.accNum.equals(this.accNum)) {
			return true;
		}else return false;
	}



}
