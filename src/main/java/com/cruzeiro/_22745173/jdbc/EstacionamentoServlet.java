package com.cruzeiro._22745173.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EstacionamentoServlet
 */
@WebServlet("/EstacionamentoServlet")
public class EstacionamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Resource(name ="jdbc/estacionamento")
    private DataSource datasource;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstacionamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		PrintWriter out = response.getWriter();
		
		try {
			myConn = datasource.getConnection();
			String sql = "select * from carros";
			myStmt = myConn.createStatement();
			myRs =myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				out.println(myRs.getString("placa").toString());
			}
			
		}catch (Exception e) {
			out.println("Erro" + e.getMessage());
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
