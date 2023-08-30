package controller.hrm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import model.dao.HrmDao;
import model.dto.HrmDto;


@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HrmController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadpath = request.getSession().getServletContext().getRealPath("/hrm/img");
		MultipartRequest multi = new MultipartRequest(request, uploadpath , 1024*1024*10, "UTF-8");
		String himg = multi.getFilesystemName("himg");
		String hname = multi.getParameter("hname");
		String hphone = multi.getParameter("hphone");
		String hposition = multi.getParameter("hposition");
		
		HrmDto hrmDto = new HrmDto(himg, hname, hphone, hposition);
		
		if( himg == null ) { himg = "default.webp";}
		
		boolean result = HrmDao.getInstance().sumit(hrmDto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}




	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
