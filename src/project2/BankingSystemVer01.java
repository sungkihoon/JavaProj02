package project2;
import java.util.Scanner;
import project2.ver01.Account;
import project2.ver01.MenuChoice;

public class BankingSystemVer01 {

	public static void main(String[] args) {

		Account act = new Account(50);
		
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
				act.makeAccount();
				break;
			case MenuChoice.DEPOSIT:
				act.depositMoney();
				break;
			case MenuChoice.WITHDRAW:
				act.withdrawMoney();
				break;
			case MenuChoice.INQUIRE:
				act.showAccInfo();
				break;
			case MenuChoice.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	
}
