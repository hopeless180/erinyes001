package cc.erinyes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.model.RKinfo;
import cc.erinyes.service.RKinfoService;

/**
 * Servlet implementation class modifyRK
 */
@WebServlet("/modifyRK")
public class modifyRK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyRK() {
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
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String name = request.getParameter("name");
		String user = request.getParameter("user");
		String content = request.getParameter("content");
		String no = request.getParameter("no");
		String date = request.getParameter("date");
		
		RKinfo RK=new RKinfo();
		RK.setid(id);
		RK.setname(name);
		RK.setcontent(content);
		RK.setquantity(quantity);
		RK.setdate(date);
		RK.setno(no);
		RK.setuser(user);
		if(new RKinfoService().updateRK(RK))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputRK.jsp");
			
	}

}
