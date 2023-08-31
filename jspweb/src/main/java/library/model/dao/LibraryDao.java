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
			String sql = "insert into library(  lno , lname , lphone ) values( ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, libraryDto.getLno());
			ps.setString(2, libraryDto.getLname());
			ps.setString(3, libraryDto.getLphone());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	public boolean findSeat( int lno ) {
	try {
		String sql = "select * from library where lno =?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, lno);
		rs = ps.executeQuery();
		if( rs.next() )
		return true;
	} catch (Exception e) {System.out.println(e);}
	return false;
}
}

