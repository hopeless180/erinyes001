package cc.erinyes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.model.CKinfo;
import cc.erinyes.service.CKinfoService;

/**
 * Servlet implementation class modifyCK
 */
@WebServlet("/modifyCK")
public class modifyCK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyCK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String name = request.getParameter("name");
		String user = request.getParameter("user");
		String content = request.getParameter("content");
		String no = request.getParameter("no");
		String date = request.getParameter("date");
		
		CKinfo CK=new CKinfo();
		CK.setid(id);
		CK.setname(name);
		CK.setcontent(content);
		CK.setquantity(quantity);
		CK.setdate(date);
		CK.setno(no);
		CK.setuser(user);
		if(new CKinfoService().updateCK(CK))
			response.sendRedirect("/mysys/success.jsp");
		else
			response.sendRedirect("/mysys/inputCK.jsp");
	}

}
