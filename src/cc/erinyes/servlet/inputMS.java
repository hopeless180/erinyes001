package cc.erinyes.servlet;

import cc.erinyes.model.MSinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.service.MSinfoService;

/**
 * Servlet implementation class inputMSinfo
 */
//@webservlet(name = "inputMS", urlPatterns = "/inputMS")
public class inputMS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputMS() {
        super();
        // TODO Auto-generated constructor MSb
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method MSb
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method MSb
		request.setCharacterEncoding("utf-8");
		
		String repository = request.getParameter("repository");
		int mid = Integer.parseInt(request.getParameter("mid"));
		String date = request.getParameter("repository");
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		MSinfo MS=new MSinfo();
		MS.setmid(mid);
		MS.setname(name);
		MS.setquantity(quantity);
		MS.setrepository(repository);
		MS.setdate(date);
		if(new MSinfoService().addMS(MS))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputMS.jsp");
			
	}

}

