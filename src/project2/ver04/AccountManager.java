package project2.ver04;

import java.util.InputMismatchException;
import java.util.Scanner;
import project2.ver03.MenuChoice;

public class AccountManager {

	private Account accountInfo[];
	String accNum, name, searchNum;
	int balance, numofArray, depositMoney, withdrawMoney;
	Scanner scan = new Scanner(System.in);

	public AccountManager(int size) {
		accountInfo = new Account[size];
		numofArray=0;
	}

	public void printMenu() throws MenuSelectException {
		while(true) {
			try {
				System.out.println("-----Menu-----");
				System.out.println("1. 계좌  개설");
				System.out.println("2. 입	금");
				System.out.println("3. 출	금");
				System.out.println("4. 계좌정보출력");
				System.out.println("5. 프로그램 종료");
				System.out.print("선택 : ");

				int choice = scan.nextInt();
				scan.nextLine();
				if(choice>5||choice<1) {
					MenuSelectException mse=new MenuSelectException();
					throw mse;
				}

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
				System.out.print("아무키나 입력하세요> ");
				scan.nextLine();
			}catch (InputMismatchException e) {
				System.out.println("지정된 정수만 입력가능합니다.");
			}catch (MenuSelectException e) {
				System.out.println(e.getMessage());
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

		if(depositMoney<0) {
			System.out.println("음수를 입금할 수 없습니다.");
			return;
		}
		if(depositMoney%500!=0) {
			System.out.println("500원단위로 입금이 가능합니다.");
			return;
		}

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

				if(withdrawMoney%1000!=0) {
					System.out.println("1000원단위로 출금이 가능합니다.");
					return;
				}

				if(withdrawMoney>balance) {
					System.out.println("잔고가 부족합니다. 금액전체를 출금할까요?");
					int choice2;
					System.out.println("YES(1) : 금액전체 출금처리, NO(2) : 출금요청취소");
					choice2 = scan.nextInt();
					if(choice2 == 1) {
						accountInfo[i].balance=0;
						return;
					}else if(choice2 ==2) {
						return;
					}
				}else {
					accountInfo[i].balance=
							accountInfo[i].balance-withdrawMoney;
				}
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
