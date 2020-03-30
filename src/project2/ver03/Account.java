package project2.ver03;

abstract class Account {

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

}
