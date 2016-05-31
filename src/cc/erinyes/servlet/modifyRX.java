package cc.erinyes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.util.PackagePrefixChecker;

import cc.erinyes.model.RXinfo;
import cc.erinyes.service.RXinfoService;

/**
 * Servlet implementation class modifyRX
 */
@WebServlet("/modifyRX")
public class modifyRX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyRX() {
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
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String status = request.getParameter("status");
		RXinfo RX=new RXinfo();
		RX.setid(id);
		RX.setlocation(location);
		RX.setname(name);
		RX.setstatus(status);
		if(new RXinfoService().updateRX(RX))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputRX.jsp");
	}

}
