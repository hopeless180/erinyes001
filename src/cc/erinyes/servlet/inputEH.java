package cc.erinyes.servlet;

import cc.erinyes.model.EHinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.service.EHinfoService;

/**
 * Servlet implementation class inputEHinfo
 */
@WebServlet(name = "inputEH", urlPatterns = "/inputEH")
public class inputEH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputEH() {
        super();
        // TODO Auto-generated constructor EHb
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method EHb
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method EHb
		request.setCharacterEncoding("utf-8");
		
		int errid = Integer.parseInt(request.getParameter("errid"));
		String handler = request.getParameter("handler");
		String date = request.getParameter("date");
		String info = request.getParameter("info");
		
		EHinfo EH=new EHinfo();

		EH.setdate(date);
		EH.seterrid(errid);
		EH.sethandler(handler);
		EH.setinfo(info);
		if(new EHinfoService().addEH(EH))
			response.sendRedirect("../input_success.jsp");
		else
			response.sendRedirect("../inputEH.jsp");
			
	}

}

