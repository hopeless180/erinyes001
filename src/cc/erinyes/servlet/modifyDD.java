package cc.erinyes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.model.DDinfo;
import cc.erinyes.service.DDinfoService;

/**
 * Servlet implementation class modifyDD
 */
@WebServlet("/modifyDD")
public class modifyDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyDD() {
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
		String creator = request.getParameter("creator");
		String status = request.getParameter("status");
		String content = request.getParameter("content");
		double cost = Double.parseDouble(request.getParameter("cost"));
		double total = cost * quantity;
		
		DDinfo DD=new DDinfo();
		DD.setid(id);
		DD.setname(name);
		DD.setcreator(creator);
		DD.setcontent(content);
		DD.setcost(cost);
		DD.setstatus(status);
		DD.settotal(total);
		DD.setquantity(quantity);
		if(new DDinfoService().updateDD(DD))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputDD.jsp");
	}
			
}

