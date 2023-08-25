package library.model.dao;



import library.model.dto.LibraryDto;
import model.dao.Dao;

public class LibraryDao extends Dao{
	private static LibraryDao libraryDao = new LibraryDao();
	private LibraryDao() {}
	public static LibraryDao getInstance() {return libraryDao;}
	
	public boolean inroom( LibraryDto libraryDto ) {
		System.out.println(libraryDto.getLname());
		try {
			String sql = "insert into library(  lname , lphone ) values( ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1, libraryDto.getLname());
			ps.setString(2, libraryDto.getLphone());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
}
