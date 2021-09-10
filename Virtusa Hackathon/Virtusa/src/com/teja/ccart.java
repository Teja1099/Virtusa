package com.teja;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teja.dao.cartDao;

/**
 * Servlet implementation class ccart
 */
@WebServlet("/ccart")
public class ccart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ccart() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bill= request.getParameter("totsum");
		System.out.println(bill);
		cartDao dao=new cartDao();
		HttpSession session =request.getSession();
		session.setAttribute("bill", bill);
		dao.push(session.getAttribute("uname").toString(),bill,session.getAttribute("restname").toString());
		response.sendRedirect("transaction.jsp");
	}

}
