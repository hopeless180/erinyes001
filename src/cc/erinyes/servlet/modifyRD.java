package cc.erinyes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.model.RDinfo;
import cc.erinyes.service.RDinfoService;

/**
 * Servlet implementation class modifyRD
 */
@WebServlet("/modifyRD")
public class modifyRD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyRD() {
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
		String date = request.getParameter("date");
		String begin = request.getParameter("begin");
		String end = request.getParameter("end");
		String ygname = request.getParameter("ygname");
		String item = request.getParameter("item");
		String location = request.getParameter("location");
		RDinfo RD=new RDinfo();
		RD.setid(id);
		RD.setbegin(begin);
		RD.setdate(date);
		RD.setend(end);
		RD.setitem(item);
		RD.setlocation(location);
		RD.setygname(ygname);
		if(new RDinfoService().updateRD(RD))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputRD.jsp");
	}

}
