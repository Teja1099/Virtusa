package com.teja;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teja.dao.lDao;

/**
 * Servlet implementation class lloc
 */
@WebServlet("/lloc")
public class lloc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lloc() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double lat = Double.parseDouble(request.getParameter("latitude"));
		double lng = Double.parseDouble(request.getParameter("longitude"));
		lDao dao=new lDao();
		String restname = dao.leastdist(lat,lng);
		HttpSession session =request.getSession();
		session.setAttribute("restname",restname);
		//System.out.println(lat);
		response.sendRedirect("cart.html");
	}

}
