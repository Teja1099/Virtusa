package com.teja;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teja.dao.rDao;

/**
 * Servlet implementation class rr
 */
@WebServlet("/rr")
public class rr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rr() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = request.getParameter("uid");
		String uname = request.getParameter("uname");
		String mbno = request.getParameter("mbno");
		String pass = request.getParameter("pass");
		rDao dao  = new rDao();
		
			try {
				if(dao.push(uid,uname,mbno,pass)) {
					response.sendRedirect("llgin.html");
				}
				else {
					response.sendRedirect("reg.html");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
	}

}
