package accountbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accountbook.model.dao.AccountbookDao;
import accountbook.model.dto.AccountbookDto;


@WebServlet("/Accountbook")
public class Accountbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Accountbook() {
        super();
     
    }
    // Create
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String atext = request.getParameter("atext");
		String anumber = request.getParameter("anumber");
		String adate = request.getParameter("adate");
		AccountbookDto accountbookDto = new AccountbookDto(atext, anumber, adate);
		
		boolean result = AccountbookDao.getInstance().awriter(accountbookDto);
		
	}
	// Read
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	// Update
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// Delete
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
