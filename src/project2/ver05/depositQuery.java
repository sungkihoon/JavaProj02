package project2.ver05;

import java.sql.SQLException;

public class depositQuery extends IConnectImpl {

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