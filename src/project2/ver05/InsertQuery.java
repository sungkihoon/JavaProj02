package project2.ver05;

import java.util.Scanner;

public class InsertQuery extends IConnectImpl{

	public InsertQuery() {
		super("kosmo", "1234");
	}

	@Override
	public void execute() {
		try {
			String query = "INSERT into banking_tb values  (seq_banking.nextval, ?, ?, ?)";

			psmt = con.prepareStatement(query);

			Scanner scan = new Scanner(System.in);
			System.out.print("계좌번호 : ");
			String pb_name = scan.nextLine();
			System.out.print("고객이름 : ");
			String pb_phoneNumber = scan.nextLine();
			System.out.print("잔고 : ");
			int pb_birthday = scan.nextInt();

			psmt.setString(1, pb_name);
			psmt.setString(2, pb_phoneNumber);
			psmt.setInt(3, pb_birthday);

			int affected = psmt.executeUpdate();
			System.out.println(affected + "개의 계좌입력이 완료되었습니다.");

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

}
