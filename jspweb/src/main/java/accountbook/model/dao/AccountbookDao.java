package accountbook.model.dao;

import accountbook.model.dto.AccountbookDto;

public class AccountbookDao extends Dao{
	private static AccountbookDao accountbookDao = new AccountbookDao();
	private AccountbookDao() {}
	public static AccountbookDao getInstance() {return accountbookDao;}
	
	public boolean awriter( AccountbookDto accountbookDto ) {
		try {
			String sql = "insert into accountbook( atext , anumber , adate ) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1 , accountbookDto.getAtext());
			ps.setString(2, accountbookDto.getAnumber());
			ps.setString(3, accountbookDto.getAdate());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
}
