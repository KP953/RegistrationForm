package com.placement.WebApplication;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/web")
public class RegisstrationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("fname");
		String middleName = req.getParameter("mname");
		String lastName = req.getParameter("lname");
		String gender = req.getParameter("gend");
		String email = req.getParameter("email");
		String phone = req.getParameter("pho");
		String course = req.getParameter("course");
		String university = req.getParameter("university");
		String college = req.getParameter("college");
		String stream = req.getParameter("stream");
		String sscSelect = req.getParameter("sscSelect");
		String sscScore = req.getParameter("scos");
		String hscSelect = req.getParameter("hscSelect");
		String hscScore = req.getParameter("scoh");
		String ugSelect = req.getParameter("ugSelect");
		String ugScore = req.getParameter("scou");
		String pgSelect=req.getParameter("pgSelect");
		String pgScore = req.getParameter("scop");
		String myfile=req.getParameter("mf");
		String sql = "insert into placement.info values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=pvk@123");

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setString(2, middleName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, gender);
			pstmt.setString(5, email);
			pstmt.setString(6, phone);
			pstmt.setString(7, course);
			pstmt.setString(8, university);
			pstmt.setString(9, college);
			pstmt.setString(10, stream);
			pstmt.setString(11, sscSelect);
			pstmt.setString(12, sscScore);
			pstmt.setString(13, hscSelect);
			pstmt.setString(14, hscScore);
			pstmt.setString(15, ugSelect);
			pstmt.setString(16, ugScore);
			pstmt.setString(17,pgSelect );
			pstmt.setString(18,pgScore);
			pstmt.setString(19, myfile);
			
			FileReader reader =new FileReader("C:\\Users\\Pratik Kadam\\Downloads");
			pstmt.setCharacterStream(19, reader);
			pstmt.executeUpdate();

            resp.sendRedirect("success.html");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
