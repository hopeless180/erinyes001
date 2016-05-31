package cc.erinyes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.model.EHinfo;
import cc.erinyes.service.EHinfoService;

/**
 * Servlet implementation class modifyEH
 */
@WebServlet("/modifyEH")
public class modifyEH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyEH() {
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
		int errid = Integer.parseInt(request.getParameter("errid"));
		String handler = request.getParameter("handler");
		String date = request.getParameter("date");
		String info = request.getParameter("info");
		
		EHinfo EH=new EHinfo();

		EH.setid(errid);
		EH.setdate(date);
		EH.seterrid(errid);
		EH.sethandler(handler);
		EH.setinfo(info);
		if(new EHinfoService().updateEH(EH))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputEH.jsp");
	}

}
