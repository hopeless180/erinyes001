package cc.erinyes.servlet;

import cc.erinyes.model.CKinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.service.CKinfoService;

/**
 * Servlet implementation class inputCKinfo
 */
//@webservlet(name = "inputCK", urlPatterns = "/inputCK")
public class inputCK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputCK() {
        super();
        // TODO Auto-generated constructor CKb
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method CKb
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method CKb
		request.setCharacterEncoding("utf-8");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String name = request.getParameter("name");
		String user = request.getParameter("user");
		String content = request.getParameter("content");
		String no = request.getParameter("no");
		String date = request.getParameter("date");
		
		CKinfo CK=new CKinfo();
		CK.setname(name);
		CK.setcontent(content);
		CK.setquantity(quantity);
		CK.setdate(date);
		CK.setno(no);
		CK.setuser(user);
		if(new CKinfoService().addCK(CK))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputCK.jsp");
			
	}

}

