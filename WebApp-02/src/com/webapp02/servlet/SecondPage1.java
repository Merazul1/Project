package com.webapp02.servlet;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;


/**
 * Servlet implementation class SecondPage1
 */
@WebServlet("/SecondPage1")
public class SecondPage1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private Connection connect = null;
	  private Statement statement = null;
	 //  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
       
   
    public SecondPage1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{  
	
		
		String Email="em";
		Email=request.getParameter("em");
		String Password="pw";
		Password =request.getParameter("pw");
		
		// TODO Auto-generated method stub
		 Connection con = null;
	        PreparedStatement ps = null;
	        try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	     
	         try {
	            con = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "root1234");
	            ps = con.prepareStatement("select * from table1 where emailid =? And password = ?");
	            ps.setString(1, Email);
	            ps.setString(2, Password);
	          ps.executeQuery();
	       if (con!=null)
	       {
	       System.out.println("Successfully LogIn");
	       response.sendRedirect("WelcomePage");  


	       }
	    }
	       catch(Exception e)
	  {
	      System.out.println(e.getMessage());
	  }
	            }
	      
	
	
	private void writeResultSet(ResultSet resultSet2) {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
