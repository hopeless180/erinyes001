package cc.erinyes.servlet;

import cc.erinyes.model.KCinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.service.KCinfoService;

/**
 * Servlet implementation class inputKCinfo
 */
//@webservlet(name = "inputKC", urlPatterns = "/inputKC")
public class inputKC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputKC() {
        super();
        // TODO Auto-generated constructor KCb
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method KCb
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method KCb
		request.setCharacterEncoding("utf-8");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String no = request.getParameter("no");
		KCinfo KC=new KCinfo();
		KC.setname(name);
		KC.setcontent(content);
		KC.setquantity(quantity);
		KC.setno(no);
		if(new KCinfoService().addKC(KC))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputKC.jsp");
			
	}

}
