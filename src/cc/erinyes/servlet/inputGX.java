package cc.erinyes.servlet;

import cc.erinyes.model.GXinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.service.GXinfoService;

/**
 * Servlet implementation class inputGXinfo
 */
@WebServlet(name = "inputGX", urlPatterns = "/inputGX")
public class inputGX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputGX() {
        super();
        // TODO Auto-generated constructor GXb
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method GXb
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method GXb
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String info = request.getParameter("info");
		GXinfo GX=new GXinfo();

		GX.setinfo(info);
		GX.setname(name);
		if(new GXinfoService().addGX(GX))
			response.sendRedirect("../input_success.jsp");
		else
			response.sendRedirect("../inputGX.jsp");
			
	}

}

