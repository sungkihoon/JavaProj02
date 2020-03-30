package project2.ver05;

import java.util.Scanner;

public class InsertQuery extends IConnectImpl{

	public InsertQuery() {
		super("kosmo", "1234");
	}

	@Override
	public void execute() {
		try {
			// 1. 쿼리문 준비 : 값의 세팅이 필요한 부분을 ?로 대체한다.
			String query = "INSERT into banking_tb values (?, ?, ?)";

			// 2. prepared 객체 생성 : 생성시 준비한 쿼리문을 인자로 전달한다.
			psmt = con.prepareStatement(query);

			// 3. DB에 입력할 값을 사용자로부터 입력받음.
			Scanner scan = new Scanner(System.in);
			System.out.print("계좌번호 : ");
			String pb_name = scan.nextLine();
			System.out.print("고객이름 : ");
			String pb_phoneNumber = scan.nextLine();
			System.out.print("잔고 : ");
			int pb_birthday = scan.nextInt();

			// 4. 인파라미타 설정하기 : ?의 순서대로 설정하고 DB이므로 인덱스는 1부터 시작
			psmt.setString(1, pb_name);
			psmt.setString(2, pb_phoneNumber);
			psmt.setInt(3, pb_birthday);

			/*
			 인파라미터 설정시 사용하는 메소드
			 	쿼리문에 ?가 있는 부분에 인덱스로 접근해서 설정한다.
			 	자료형이
			 		숫자면 setInt()
			 		문자면 setString()
			 		날짜면 setDate() 를 사용한다.
			 	해당 메소드 사용시 '(싱글쿼테이션)은 자동으로 삽입된다.
			 */
			
			// 5. 쿼리실행을 위해 prepared객체를 실행한다.
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
