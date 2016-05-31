package cc.erinyes.servlet;

import cc.erinyes.model.ERRinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.service.ERRinfoService;

/**
 * Servlet implementation class inputERRinfo
 */
//@webservlet(name = "inputERR", urlPatterns = "/inputERR")
public class inputERR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputERR() {
        super();
        // TODO Auto-generated constructor ERRb
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method ERRb
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method ERRb
		request.setCharacterEncoding("utf-8");
		
		String finder = request.getParameter("finder");
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String info = request.getParameter("info");
		String status = request.getParameter("status");
		
		ERRinfo ERR=new ERRinfo();

		ERR.setdate(date);
		ERR.setfinder(finder);
		ERR.setinfo(info);
		ERR.setname(name);
		ERR.setstatus(status);
		if(new ERRinfoService().addERR(ERR))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputERR.jsp");
			
	}

}

