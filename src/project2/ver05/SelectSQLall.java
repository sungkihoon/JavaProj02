package project2.ver05;

import java.sql.SQLException;


public class SelectSQLall extends ConnectDB {

	public SelectSQLall() {}

	@Override
	public void execute() {
		try {

			stmt = con.createStatement();
			System.out.println("계좌정보 전체를 출력합니다.");
			String query = "SELECT tb_accNum, tb_name, tb_balance"
					+ " FROM banking_tb";

			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String tb_accNum = rs.getString(1);
				String tb_name = rs.getString(2);
				int tb_balance = rs.getInt(3);

				System.out.printf("계좌번호 : %s\n고객이름 : %s\n잔고 : %s\n",
						tb_accNum, tb_name, tb_balance);
				System.out.println();
			}
			System.out.println("계좌정보 출력이 완료되었습니다.");
		}
		catch (SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
}
