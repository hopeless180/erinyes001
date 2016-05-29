package cc.erinyes.servlet;

import cc.erinyes.model.RXinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.service.RXinfoService;

/**
 * Servlet implementation class inputRXinfo
 */
@WebServlet(name = "inputRX", urlPatterns = "/inputRX")
public class inputRX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputRX() {
        super();
        // TODO Auto-generated constructor RXb
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method RXb
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method RXb
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String status = request.getParameter("status");
		RXinfo RX=new RXinfo();

		RX.setlocation(location);
		RX.setname(name);
		RX.setstatus(status);
		if(new RXinfoService().addRX(RX))
			response.sendRedirect("../input_success.jsp");
		else
			response.sendRedirect("../inputRX.jsp");
			
	}

}

