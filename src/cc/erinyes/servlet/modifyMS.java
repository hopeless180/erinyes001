package cc.erinyes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.model.MSinfo;
import cc.erinyes.service.MSinfoService;

/**
 * Servlet implementation class modifyMS
 */
@WebServlet("/modifyMS")
public class modifyMS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyMS() {
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
		String repository = request.getParameter("repository");
		int mid = Integer.parseInt(request.getParameter("mid"));
		String date = request.getParameter("repository");
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		MSinfo MS=new MSinfo();
		MS.setid(id);
		MS.setmid(mid);
		MS.setname(name);
		MS.setquantity(quantity);
		MS.setrepository(repository);
		MS.setdate(date);
		if(new MSinfoService().updateMS(MS))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputMS.jsp");
	}

}
