package cc.erinyes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.model.ERRinfo;
import cc.erinyes.service.ERRinfoService;

/**
 * Servlet implementation class modifyERR
 */
@WebServlet("/modifyERR")
public class modifyERR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyERR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String finder = request.getParameter("finder");
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String info = request.getParameter("info");
		String status = request.getParameter("status");
		
		ERRinfo ERR=new ERRinfo();

		ERR.setid(id);
		ERR.setdate(date);
		ERR.setfinder(finder);
		ERR.setinfo(info);
		ERR.setname(name);
		ERR.setstatus(status);
		if(new ERRinfoService().updateERR(ERR))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputERR.jsp");
	}

}
