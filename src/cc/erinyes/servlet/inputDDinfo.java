package cc.erinyes.servlet;

import cc.erinyes.model.DDinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.erinyes.service.DDinfoService;

/**
 * Servlet implementation class inputDDinfo
 */
@WebServlet("/inputDDinfo")
public class inputDDinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputDDinfo() {
        super();
        // TODO Auto-generated constructor DDb
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method DDb
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method DDb
		request.setCharacterEncoding("utf-8");
		String nicheng=request.getParameter("nicheng");
		String truename=request.getParameter("truename");
		byte xb=Byte.parseByte(request.getParameter("xb"));
		String csrq=request.getParameter("csrq");
		String zy=request.getParameter("zy");
		System.out.println(zy);
		//String kc=request.getParameter("kc");
		String kcs[]=request.getParameterValues("kc");
		String xqs[]=request.getParameterValues("xq");
		String bz=request.getParameter("bz");
		DDinfo DD=new DDinfo();
		DD.setNicheng(nicheng);
		DD.setTruename(truename);
		
		DD.setCsrq(csrq);
		if(csrq.equals(""))
			DD.setCsrq(null);
		if(kcs!=null)
		DD.setKc(kcs);
		if(xqs!=null)
		DD.setXq(xqs);
		DD.setBz(bz);
		DD.setZy(zy);
		DD.setXb(xb);
		if(new DDinfoService().addDD(DD))
			response.sendRedirect("../inputDDInfo_success.jsp");
		else
			response.sendRedirect("../inputDDInfo.jsp");
			
	}

}
