package com.baby_care_website;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

class Login{
	public boolean check(String name, String pwd) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn= DriverManager.getConnection("jdbc:mysql://rajesh.chjqklkgoer7.us-west-2.rds.amazonaws.com:3306/rajesh","admin","password");
		PreparedStatement ps=conn.prepareStatement("select * from register where name=? and pwd=?");
		ps.setString(1, name);
		ps.setString(2, pwd);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			return true;
		return false;
	}
}
@Controller
public class Connect extends HttpServlet{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	@RequestMapping("/enter")
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("name");
		String pwd= req.getParameter("pwd");
		Login log=new Login();
		try {
			if(log.check(name, pwd)) {
				HttpSession hs= req.getSession();
				hs.setAttribute("user", name);
				resp.sendRedirect("welcome.jsp");
			}
			else {
				HttpSession sh=req.getSession();
				sh.setAttribute("data", "wrong user and password");
				resp.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}