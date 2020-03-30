package project2.ver02;

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
}
