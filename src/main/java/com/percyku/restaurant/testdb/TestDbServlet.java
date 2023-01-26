package com.percyku.restaurant.testdb;//package com.percyku.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//setup connection variables
		String user     ="restaurant";
		String password ="restaurant";

		String jdbcUrl="jdbc:mysql://localhost:3306/restaurant?useSSL=false&serverTimezone=UTC";
		//String driver = "com.mysql.jdbc.Driver";
		String driver = "com.mysql.cj.jdbc.Driver";

		//get connection to databases
		try {

			PrintWriter out = response.getWriter();

			out.println("Connecting to database: "+jdbcUrl);

			Class.forName(driver);

			Connection myConn=DriverManager.getConnection(jdbcUrl, user, password);

			out.println("Connecting successful");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
