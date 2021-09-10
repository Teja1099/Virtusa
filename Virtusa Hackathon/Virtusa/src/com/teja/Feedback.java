package com.teja;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.teja.dao.loginDao;
import com.teja.dao.rating;


/**
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rate=Integer.parseInt(request.getParameter("experience"));
		HttpSession session =request.getSession();
		String restname= session.getAttribute("restname").toString();
		rating dao=new rating();
		//System.out.println(rate+""+restname);
		dao.rateRest(rate,restname);
		response.sendRedirect("cart.html");
	}

}
