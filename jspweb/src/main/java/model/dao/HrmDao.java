package model.dao;

import model.dto.HrmDto;

public class HrmDao extends Dao{
	private static HrmDao hrmDao = new HrmDao();
	private HrmDao() {}
	public static HrmDao getInstance() {return hrmDao;}
	
	public boolean sumit( HrmDto dto ) {
		try {
			String sql = "";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getHimg());
			ps.setString(2, dto.getHname());
			ps.setString(3, dto.getHphone());
			ps.setString(4, dto.getHposition());
			ps.executeUpdate();
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
}
