package cc.erinyes.servlet;

import cc.erinyes.model.CAinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.service.CAinfoService;

/**
 * Servlet implementation class inputCAinfo
 */
//@webservlet(name = "inputCA", urlPatterns = "/inputCA")
public class inputCA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputCA() {
        super();
        // TODO Auto-generated constructor CAb
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method CAb
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method CAb
		request.setCharacterEncoding("utf-8");

		String item = request.getParameter("item");
		String name = request.getParameter("name");
		String analyst = request.getParameter("analyst");
		String date = request.getParameter("date");
		String conclusion = request.getParameter("conclusion");
		
		CAinfo CA=new CAinfo();
		CA.setanalyst(analyst);
		CA.setconclusion(conclusion);
		CA.setdate(date);
		CA.setitem(item);
		CA.setname(name);
		if(new CAinfoService().addCA(CA))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputCA.jsp");
			
	}

}

