package cc.erinyes.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.erinyes.model.*;
import cc.erinyes.service.CAinfoService;
import cc.erinyes.service.CKinfoService;
import cc.erinyes.service.DDinfoService;
import cc.erinyes.service.CAinfoService;
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
 * Servlet implementation class modifyInfoServlet
 */
public class modifyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CAinfo test;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyInfoServlet() {
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
		System.out.println("s");
		HttpSession session=request.getSession();
		int id=Integer.parseInt(request.getParameter("id"));
		String key = request.getParameter("key");

		if(key.equals("CA")){
			CAinfo CA = new CAinfoService().queryCAbyID(id);
			session.setAttribute("CA",CA);
		}
		else if(key.equals("DD")){
			DDinfo DD = new DDinfoService().queryDDbyID(id);
			session.setAttribute("DD",DD);
		}
		else if(key.equals("CA")){
			CAinfo CA = new CAinfoService().queryCAbyID(id);
			session.setAttribute("CA",CA);
		}
		else if(key.equals("CK")){
			CKinfo CK = new CKinfoService().queryCKbyID(id);
			session.setAttribute("CK",CK);
		}
		else if(key.equals("EH")){
			EHinfo EH = new EHinfoService().queryEHbyID(id);
			session.setAttribute("EH",EH);
		}
		else if(key.equals("ERR")){
			ERRinfo ERR = new ERRinfoService().queryERRbyID(id);
			session.setAttribute("ERR",ERR);
		}
		else if(key.equals("GX")){
			GXinfo GX = new GXinfoService().queryGXbyID(id);
			session.setAttribute("GX",GX);
		}
		else if(key.equals("KC")){
			KCinfo KC = new KCinfoService().queryKCbyID(id);
			session.setAttribute("KC",KC);
		}
		else if(key.equals("MS")){
			MSinfo MS = new MSinfoService().queryMSbyID(id);
			session.setAttribute("MS",MS);
		}
		else if(key.equals("PG")){
			PGinfo PG = new PGinfoService().queryPGbyID(id);
			session.setAttribute("PG",PG);
		}
		else if(key.equals("RD")){
			RDinfo RD = new RDinfoService().queryRDbyID(id);
			session.setAttribute("RD",RD);
		}
		else if(key.equals("RK")){
			RKinfo RK = new RKinfoService().queryRKbyID(id);
			session.setAttribute("RK",RK);
		}
		else if(key.equals("RX")){
			RXinfo RX = new RXinfoService().queryRXbyID(id);
			session.setAttribute("RX",RX);
		}
		System.out.println("www");
		response.sendRedirect("/mysys/modify"+key+".jsp");
	}

}
