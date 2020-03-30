package project2.ver01;
import java.util.Scanner;

public class Account {

	String accNum, name, searchNum;
	int balance, numofArray, depositMoney, withdrawMoney;
	private Account accountInfo[];
	Scanner scan = new Scanner(System.in);

	public Account(String accNum, String name, int balance) {
		this.accNum = accNum;
		this.name = name;
		this.balance = balance;
	}

	public Account(int size) {
		accountInfo = new Account[size];
		numofArray=0;
	}

	public void makeAccount(){
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호 : "); accNum=scan.nextLine();
		System.out.print("고객이름 : "); name=scan.nextLine();
		System.out.print("잔고 : "); balance=scan.nextInt();
		scan.nextLine();
		System.out.println("계좌개설이 완료되었습니다.");
		Account acc1 = new Account(accNum, name, balance);
		accountInfo[numofArray++]=acc1;
	}

	public void depositMoney() {
		System.out.println("***입	금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : "); searchNum=scan.nextLine();
		System.out.print("입금액 : "); depositMoney=scan.nextInt();
		scan.nextLine();

		for(int i=0 ; i<numofArray ; i++) {
			if(searchNum.compareTo(accountInfo[i].accNum)==0) {
				accountInfo[i].balance=accountInfo[i].balance+depositMoney;
			}
		}
		System.out.println("입금이 완료되었습니다.");
	}

	public void withdrawMoney() {
		System.out.println("***출	금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호 : "); searchNum=scan.nextLine();
		System.out.print("출금액 : "); withdrawMoney=scan.nextInt();
		scan.nextLine();

		for(int i=0 ; i<numofArray ; i++) {
			if(searchNum.compareTo(accountInfo[i].accNum)==0) {
				accountInfo[i].balance=accountInfo[i].balance-withdrawMoney;
			}
		}
		System.out.println("출금이 완료되었습니다.");
	}

	public void showAccInfo() {
		System.out.println("***계좌정보출력***");
		for(int i=0;i<numofArray;i++) {
			accountInfo[i].accInfo();
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}

	public void accInfo() {
		System.out.println("----------");
		System.out.println("계좌번호 : "+accNum);
		System.out.println("고객이름 : "+name);
		System.out.println("잔고 : "+balance);
		System.out.println("----------");
	}
}
