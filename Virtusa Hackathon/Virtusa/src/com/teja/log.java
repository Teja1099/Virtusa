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
 * Servlet implementation class log
 */
@WebServlet("/log")
public class log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String u = request.getParameter("uname");
		String p = request.getParameter("pwd");
		//System.out.println(u);
		loginDao dao=new loginDao();
		rating rdao=new rating();
		if(dao.check(u,p)) {
			HttpSession session =request.getSession();
			session.setAttribute("uname",u);
			session.setAttribute("pwd",p);
			
			response.sendRedirect("loc.html");
		}
		else {
			response.sendRedirect("llgin.html");
		}
		//rdao.rateRest(2,"jamjam");
	}

}
