package project2.ver04;

import java.util.Scanner;

/*
신용계좌 : 잔고 + (잔고 * 기본이자) + (잔고 * 추가이자) + 입금액
Ex) 5000 + (5000 * 0.02) + (5000 * 0.04) + 2000 = 7,300원
A,B,C 등급별로 각각 기본이율에 7%, 4%, 2%의 이율을 추가로 제공한다.
 */

//신용신뢰계좌 > 신용도가 높은 고객에게 개설이 허용되며 높은 이율의 계좌이다.
public class HighCreditAccount extends Account 
implements CustomSpecialRate{

	int Hinterest, gradeRate, depositMoney;
	String grade;

	public HighCreditAccount(String accNum,String name, int balance
			, int Hinterest, String grade) {
		super(accNum, name, balance);
		this.Hinterest = Hinterest;
		this.grade = grade;
	}

	@Override
	public void accInfo() {
		super.accInfo();
		System.out.println("기본이자> "+Hinterest+"%");
		System.out.println("신용등급> "+grade);
		System.out.println("----------");
	}

	@Override
	public void interestRate(int money) {
		Scanner scan = new Scanner(System.in);
		String choiceRate=scan.nextLine();
		switch(choiceRate) {
		case "A":
			gradeRate=CustomSpecialRate.A;
			break;
		case "B":
			gradeRate=CustomSpecialRate.B;
			break;
		case "C":
			gradeRate=CustomSpecialRate.C;
			break;
		}
		balance = balance + (balance*Hinterest/100)+
				(balance*gradeRate/100) + money;
	}

	@Override
	public String toString() {
		return "계좌번호> "+accNum+"\n고객이름> "+name+"\n잔고> "+balance
				+"\n기본이자%(정수형태로입력)> "+Hinterest+"%"
				+"\n신용등급(A,B,C)등급> "+grade;
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