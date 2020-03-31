package project2.ver05;

import java.util.Scanner;

public class Account {

	public Account() {}
	public Account(int size) {}

	public void printMenu() {
		while(true) {
			System.out.println("-----Menu-----");
			System.out.println("1. 계좌  개설");
			System.out.println("2. 입	금");
			System.out.println("3. 출	금");
			System.out.println("4. 계좌정보출력");
			System.out.println("5. 퍼 즐 게 임");
			System.out.println("6. 프로그램 종료");
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
			case MenuChoice.GAME:
				puzzleGame();
			case MenuChoice.EXIT:
				System.out.println("프로그램을 종료합니다.");
				
				return;
			}
		}
	}

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
	public void puzzleGame() {
		new Puzzle3by3().execute();
	}
}