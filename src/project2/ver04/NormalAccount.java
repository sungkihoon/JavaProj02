package project2.ver04;

/*
 일반계좌 : 잔고 + (잔고 * 기본이자) + 입금액 
Ex) 5000 + (5000 * 0.02) + 2000 = 7,100원
 */

//보통예금계좌 > 최소한의 이자를 지급하는 자율 입출금식 계좌
public class NormalAccount extends Account{

	int Ninterest;

	public NormalAccount(String accNum,
			String name, int balance, int Ninterest) {
		super(accNum, name, balance);
		this.Ninterest = Ninterest;
	}

	@Override
	public void accInfo() {
		super.accInfo();
		System.out.println("기본이자> "+Ninterest+"%");
		System.out.println("----------");
	}

	@Override
	public void interestRate(int money) {
		balance =  balance + (balance*Ninterest/100) + money;
	}

	@Override
	public String toString() {
		return "계좌번호> "+accNum+"\n고객이름> "+name+"\n잔고> "
				+balance+"\n기본이자%(정수형태로입력)> "+Ninterest+"%";
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
