package cc.erinyes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.service.CAinfoService;
import cc.erinyes.service.CKinfoService;
import cc.erinyes.service.DDinfoService;
import cc.erinyes.service.EHinfoService;
import cc.erinyes.service.ERRinfoService;
import cc.erinyes.service.GXinfoService;
import cc.erinyes.service.KCinfoService;
import cc.erinyes.service.MSinfoService;
import cc.erinyes.service.PGinfoService;
import cc.erinyes.service.RDinfoService;
import cc.erinyes.service.RKinfoService;
import cc.erinyes.service.RXinfoService;

/**
 * Servlet implementation class deleteInfoServlet
 */
//@webservlet(name = "deleteInfoServlet",urlPatterns = "/deleteInfoServlet")
public class deleteInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteInfoServlet() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		String key = request.getParameter("key");
		if(key.equals("DD") && new DDinfoService().deleteDD(id))
			response.sendRedirect("/mysys/success.jsp");
		if(key.equals("CA") && new CAinfoService().deleteCA(id))
			response.sendRedirect("/mysys/success.jsp");
		if(key.equals("CK") && new CKinfoService().deleteCK(id))
			response.sendRedirect("/mysys/success.jsp");
		if(key.equals("EH") && new EHinfoService().deleteEH(id))
			response.sendRedirect("/mysys/success.jsp");
		if(key.equals("ERR") && new ERRinfoService().deleteERR(id))
			response.sendRedirect("/mysys/success.jsp");
		if(key.equals("GX") && new GXinfoService().deleteGX(id))
			response.sendRedirect("/mysys/success.jsp");
		if(key.equals("KC") && new KCinfoService().deleteKC(id))
			response.sendRedirect("/mysys/success");
		if(key.equals("MS") && new MSinfoService().deleteMS(id))
			response.sendRedirect("/mysys/success.jsp");
		if(key.equals("PG") && new PGinfoService().deletePG(id))
			response.sendRedirect("/mysys/success.jsp");
		if(key.equals("RD") && new RDinfoService().deleteRD(id))
			response.sendRedirect("/mysys/success.jsp");
		if(key.equals("RK") && new RKinfoService().deleteRK(id))
			response.sendRedirect("/mysys/success.jsp");
		if(key.equals("RX") && new RXinfoService().deleteRX(id))
			response.sendRedirect("/mysys/success.jsp");
	}

}
