package com.webapp02.servlet;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	  private PreparedStatement preparedStatement = null;
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
		// TODO Auto-generated method stub
		try
	    {
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/test";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "root1234");
	      
	      resultSet = statement.executeQuery(myUrl);
	      writeResultSet(resultSet);
	      
	      PreparedStatement ps =conn.prepareStatement("select * from table1 where email ='merazul@gmail.com' And password = 'merazul123'");

	      resultSet = preparedStatement.executeQuery();
	      writeResultSet(resultSet);
	    
	
		 int i=ps.executeUpdate();
	        if(i>0)
	       System.out.println("Successfully LogIn");
	  }catch(Exception e)
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
