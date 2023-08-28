package library.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.model.dao.LibraryDao;
import library.model.dto.LibraryDto;


@WebServlet("/LibraryController")
public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LibraryController() {
        super();
        // TODO Auto-generated constructor stub
    }
    // C
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lno = Integer.parseInt(request.getParameter("lno"));
		String lname = request.getParameter("lname"); System.out.println("lname : " +lname);
		String lphone = request.getParameter("lphone"); System.out.println("lphone : " +lphone);

		
		LibraryDto libraryDto = new LibraryDto( lno , lname, lphone);

		boolean result = LibraryDao.getInstance().inroom(libraryDto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	// R
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// U
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	// D
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
