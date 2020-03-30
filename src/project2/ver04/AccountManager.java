package project2.ver04;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

public class AccountManager {

	HashSet<Account> set = new HashSet<Account>();
	String accNum, name, searchNum;
	int balance, numofArray, depositMoney, withdrawMoney;
	Scanner scan = new Scanner(System.in);

	public void printMenu() throws MenuSelectException {
		readAccountInfo();
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
					saveAccountInfo();
					return;
				}
			}catch (InputMismatchException e) {
				System.out.println("지정된 정수만 입력가능합니다.");
			}catch (MenuSelectException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void makeAccount() throws MenuSelectException{

		int Ninterest, Hinterest;
		String grade;

		System.out.println("***신규계좌개설***");
		System.out.println("-----계좌선택-----");
		System.out.println("1. 보통계좌");
		System.out.println("2. 신용신뢰계좌");
		System.out.print("선택 >> ");
		int inputNum = scan.nextInt();
		scan.nextLine();

		if(inputNum==1) {
			System.out.print("계좌번호 : "); accNum=scan.nextLine();
			checkDouble(accNum);
			System.out.print("고객이름 : "); name=scan.nextLine();
			System.out.print("잔고 : "); balance=scan.nextInt();
			scan.nextLine();
			System.out.print("기본이자%(정수형태로입력):"); 
			Ninterest=scan.nextInt();
			scan.nextLine();
			System.out.println("계좌개설이 완료되었습니다.");
			NormalAccount na = new NormalAccount(accNum, name
					, balance, Ninterest);
			set.add(na);
		}else if(inputNum==2) {
			System.out.print("계좌번호 : "); accNum=scan.nextLine();
			checkDouble(accNum);
			System.out.print("고객이름 : "); name=scan.nextLine();
			System.out.print("잔고 : "); balance=scan.nextInt();
			scan.nextLine();
			System.out.print("기본이자%(정수형태로입력):"); 
			Hinterest=scan.nextInt();
			scan.nextLine();
			System.out.print("신용등급(A,B,C)등급:"); 
			grade=scan.nextLine();
			System.out.println("계좌개설이 완료되었습니다.");
			HighCreditAccount ha = new HighCreditAccount
					(accNum, name, balance, Hinterest, grade);
			set.add(ha);
		}
	}

	public void depositMoney() {
		try {
			int check = 0;

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

			Iterator<Account> itr = set.iterator();
			while(itr.hasNext()) {
				Account ac = itr.next();
				if(ac.accNum.contains(accNum)) {
					ac.interestRate(depositMoney);
					check = 1;
				}
			}
			System.out.println("입금이 완료되었습니다.");
			if(check==0) {
				NullPointerException ex = new NullPointerException();
				throw ex;
			}
		}catch (InputMismatchException e) {
			System.out.println("지정된 정수만 입력하세요.");
		}catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("요청한 데이터가 없습니다.");
		}

	}

	public void withdrawMoney() {
		try {
			int check = 0;
			System.out.println("***출	금***");
			System.out.println("계좌번호와 출금할 금액을 입력하세요");
			System.out.print("계좌번호 : "); searchNum=scan.nextLine();
			System.out.print("출금액 : "); withdrawMoney=scan.nextInt();
			scan.nextLine();

			Iterator<Account> itr = set.iterator();

			while (itr.hasNext()) {
				Account ac = itr.next();
				if(ac.accNum.contains(accNum)) {
					if(ac.balance<withdrawMoney) {
						System.out.println("잔고가 부족합니다. 금액전체를 출금할까요?");
						System.out.println("YES(1) : 금액전체 출금처리, NO(2) : 출금요청취소");
						System.out.print("선택> ");
						int choice2 = scan.nextInt();
						if(choice2==1) {
							System.out.println(ac.balance+"원 출금하겠습니다.");
							ac.balance = 0;
						}else if (choice2==2) {
							System.out.println("요청이 취소되었습니다.");
							return;
						}
					}
					ac.balance -= withdrawMoney;
					System.out.println("출금이 완료되었습니다.");
					check = 1;
				}
			}
			if (check == 0) {
				NullPointerException ex = new NullPointerException();
				throw ex;
			}
		} catch (InputMismatchException e) {
			System.out.println("지정된 정수만 입력하세요.");
			scan.nextLine();
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("요청한 데이터가 없습니다.");
		}
	}

	public void showAccInfo() {
		System.out.println("***계좌정보출력***");
		try {
			for(Account ac: set){
				System.out.println(ac.toString());
				System.out.println();
			}
			System.out.println("전체계좌정보 출력이 완료되었습니다.");
		}catch (NullPointerException e) {
			System.out.println("요청한 데이터가 없습니다.");
		}
	}

	public void checkDouble(String accnum) throws MenuSelectException{
		boolean check = false;
		int checkNum=0;

		Iterator<Account> itr = set.iterator();
		while(itr.hasNext()) {
			Account account = itr.next();
			if(accnum.equals(account.accNum)) {
				check = true;
			}
		}  
		if(check==true) {
			System.out.println("중복된 계좌가 존재합니다. 덮어쓰시겠습니까?");
			System.out.println("1.덮어쓰기   2.메뉴로 돌아가기");
			checkNum = scan.nextInt();

			if(checkNum==1) {
				itr.remove();
			}else if(checkNum==2) {
				makeAccount();
			}
		}else {
			return;
		}
		scan.nextLine();
	}

	//주소록을 파일 형태로 저장하기
	public void saveAccountInfo() {

		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(
							new FileOutputStream
							("src/project2/ver04/BankingInfo.obj"));

			Iterator<Account> itr= set.iterator();

			while (itr.hasNext()) {
				Account account = itr.next();
				out.writeObject(account);
			}
			out.close();

		} catch (Exception e) {
			System.out.println("저장실패!");
			e.printStackTrace();
		}
	}

	//주소록 파일을 불러오기
	public void readAccountInfo() {
		try {
			ObjectInputStream in = 
					new ObjectInputStream(
							new FileInputStream
							("src/project2/ver04/BankingInfo.obj"));
			Iterator<Account> itr = set.iterator();

			while (true) {
				Account account =(Account)in.readObject();
				if(account==null)break;
				set.add(account);
			}

			showAccInfo();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
}
