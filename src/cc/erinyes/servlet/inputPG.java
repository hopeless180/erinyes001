package cc.erinyes.servlet;

import cc.erinyes.model.PGinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;

import cc.erinyes.service.PGinfoService;

/**
 * Servlet implementation class inputPGinfo
 */
//@webservlet(name = "inputPG", urlPatterns = "/inputPG")
public class inputPG extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputPG() {
        super();
        // TODO Auto-generated constructor PGb
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method PGb
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method PGb
		request.setCharacterEncoding("utf-8");
		String company =request.getParameter("company");
		String begin = request.getParameter("begin");
		String end = request.getParameter("end");
		String name = request.getParameter("name");
		String neirong = request.getParameter("neirong");
		
		PGinfo PG=new PGinfo();
		PG.setcompany(company);
		PG.setbegin(begin);
		PG.setend(end);
		PG.setname(name);
		PG.setneirong(neirong);
		if(new PGinfoService().addPG(PG))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputPG.jsp");
			
	}

}

