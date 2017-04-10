package com.webapp02.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondPage
 */
@WebServlet("/SecondPage")
public class SecondPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String FirstName="fname";
		FirstName=request.getParameter("fname");
		String LastName="lname";
		FirstName=request.getParameter("lname");
		String EmailId="em";
		EmailId=request.getParameter("em");
		String MobileNo="mb";
		MobileNo=request.getParameter("mb");
		String Password="pw";
		Password=request.getParameter("pw");
		System.out.println(FirstName+"   "+LastName+" "+"  "+ EmailId+"  "+MobileNo+"   "+Password);
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root1234");
            stmt = con.prepareStatement("INSERT INTO db.table1(fname,lname,emailid,mobileno,password) VALUES (?,?,?,?,?)");
           stmt.setString(1, FirstName);
           stmt.setString(2, LastName);
           stmt.setString(3, EmailId);
           stmt.setString(4, MobileNo);
           stmt.setString(5, Password);
           
         int i=stmt.executeUpdate();
        if(i>0)
       System.out.println("Data is submitted");
  }catch(Exception e)
  {
      System.out.println(e.getMessage());
  }
            }
        
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
