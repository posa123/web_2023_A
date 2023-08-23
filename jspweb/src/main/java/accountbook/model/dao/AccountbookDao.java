package accountbook.model.dao;

import accountbook.model.dto.AccountbookDto;

public class AccountbookDao extends Dao{
	private static AccountbookDao accountbookDao = new AccountbookDao();
	private AccountbookDao() {}
	public static AccountbookDao getInstance() {return accountbookDao;}
	
	public boolean awriter( AccountbookDto accountbookDto ) {
		try {
			String sql = "";
			ps = conn.prepareStatement(sql);
			ps.setString(2 , accountbookDto.getAtext());
			ps.setString(3, accountbookDto.getAnumber());
			ps.setString(4, accountbookDto.getAdate());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
}
