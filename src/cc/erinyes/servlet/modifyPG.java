package cc.erinyes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.model.PGinfo;
import cc.erinyes.service.PGinfoService;

/**
 * Servlet implementation class modifyPG
 */
@WebServlet("/modifyPG")
public class modifyPG extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyPG() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		String company =request.getParameter("company");
		String begin = request.getParameter("begin");
		String end = request.getParameter("end");
		String name = request.getParameter("name");
		String neirong = request.getParameter("neirong");
		
		PGinfo PG=new PGinfo();
		PG.setid(id);
		PG.setcompany(company);
		PG.setbegin(begin);
		PG.setend(end);
		PG.setname(name);
		PG.setneirong(neirong);
		if(new PGinfoService().updatePG(PG))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputPG.jsp");
	}

}
