package project2.ver02;

import java.util.Scanner;
import project2.ver02.MenuChoice;

public class AccountManager {

	private Account accountInfo[];
	String accNum, name, searchNum;
	int balance, numofArray, depositMoney, withdrawMoney;

	public AccountManager(int size) {
		accountInfo = new Account[size];
		numofArray=0;
	}

	public void printMenu() {
		while(true) {
			System.out.println("-----Menu-----");
			System.out.println("1. 계좌  개설");
			System.out.println("2. 입	금");
			System.out.println("3. 출	금");
			System.out.println("4. 계좌정보출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택 : ");

			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			scan.nextLine();

			switch(choice) {
			case MenuChoice.MAKE:
				makeAccount();
				break;
			case MenuChoice.DEPOSIT:
				depositMoney();
				break;
			case MenuChoice.WITHDRAW:
				withdrawMoney();
				break;
			case MenuChoice.INQUIRE:
				showAccInfo();
				break;
			case MenuChoice.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}

	public void makeAccount(){

		int Ninterest, Hinterest;
		String grade;
		Scanner scan = new Scanner(System.in);

		System.out.println("***신규계좌개설***");
		System.out.println("-----계좌선택-----");
		System.out.println("1. 보통계좌");
		System.out.println("2. 신용신뢰계좌");
		System.out.print("선택 >> ");
		int inputNum = scan.nextInt();
		scan.nextLine();

		if(inputNum==1) {
			System.out.print("계좌번호 : "); accNum=scan.nextLine();
			System.out.print("고객이름 : "); name=scan.nextLine();
			System.out.print("잔고 : "); balance=scan.nextInt();
			System.out.print("기본이자%(정수형태로입력):"); 
			Ninterest=scan.nextInt();
			scan.nextLine();
			System.out.println("계좌개설이 완료되었습니다.");
			NormalAccount acc1 = new NormalAccount(accNum, name
					, balance, Ninterest);
			accountInfo[numofArray++]=acc1;

		}else if(inputNum==2) {
			System.out.print("계좌번호 : "); accNum=scan.nextLine();
			System.out.print("고객이름 : "); name=scan.nextLine();
			System.out.print("잔고 : "); balance=scan.nextInt();
			System.out.print("기본이자%(정수형태로입력):"); 
			Hinterest=scan.nextInt();
			scan.nextLine();
			System.out.print("신용등급(A,B,C)등급:"); 
			grade=scan.nextLine();
			System.out.println("계좌개설이 완료되었습니다.");
			HighCreditAccount acc1 = new HighCreditAccount
					(accNum, name, balance, Hinterest, grade);
			accountInfo[numofArray++]=acc1;
		}
	}

	public void depositMoney() {
		Scanner scan = new Scanner(System.in);

		System.out.println("***입	금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : "); searchNum=scan.nextLine();
		System.out.print("입금액 : "); depositMoney=scan.nextInt();

		for(int i=0 ; i<numofArray ; i++) {
			if(searchNum.compareTo(accountInfo[i].accNum)==0) {

				accountInfo[i].interestRate(depositMoney);
			}
		}
		System.out.println("입금이 완료되었습니다.");
	}

	public void withdrawMoney() {
		Scanner scan = new Scanner(System.in);

		System.out.println("***출	금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호 : "); searchNum=scan.nextLine();
		System.out.print("출금액 : "); withdrawMoney=scan.nextInt();
		scan.nextLine();

		for(int i=0 ; i<numofArray ; i++) {
			if(searchNum.compareTo(accountInfo[i].accNum)==0) {
				accountInfo[i].balance=
						accountInfo[i].balance-withdrawMoney;
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

}
