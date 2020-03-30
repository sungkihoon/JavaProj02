package project2.ver05;

import java.sql.SQLException;

public class depositQuery extends IConnectImpl {

	//생성자에서 DB연결
	public depositQuery() {
		super("kosmo", "1234");
	}

	@Override
	public void execute() {
		String sql = "update banking_tb "
				+ "Set tb_balance=tb_balance+? "
				+ "where tb_accNum = ? ";
		try {
			psmt = con.prepareStatement(sql);
			/*
			사용자 입력시 exit 입력할때까지는 계속 실행되는 형태로 구성
			 */

			//인파라미터 설정시 해당 인덱스만 맞으면 순서는 상관없다.
			psmt.setString(2, scanValue("계좌번호 "));
			psmt.setString(1, scanValue("입금할 금액"));

			psmt.executeUpdate();

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

}