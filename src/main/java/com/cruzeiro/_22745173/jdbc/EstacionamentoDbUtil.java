package com.cruzeiro._22745173.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.cruzeiro._22745173.model.Carros;

public class EstacionamentoDbUtil {
	private DataSource datasource;
	
	public EstacionamentoDbUtil(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<Carros>getCarros() throws Exception{
		List<Carros> carros = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		String mySql;
		try {
			myConn = datasource.getConnection();
			mySql = "select id, placa, modelo, horaentrada, horasaida from carros order by id";
			myStmt = myConn.createStatement();
			myRs =myStmt.executeQuery(mySql);
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String placa = myRs.getString("placa");
				String modelo = myRs.getString("modelo");
				String horaentrada = myRs.getString("horaentrada");
				String horasaida = myRs.getString("horasaida");
				
				Carros tempEstacionamento = new Carros(id, placa, modelo, horaentrada, horasaida);
				carros.add(tempEstacionamento);
			}
			return carros;
		}
		finally {
			myRs.close();
			myStmt.close();
			myConn.close();
		}
	}

	public void addCarro(Carros carro)throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt =null;
		String mySql="";
		try {
			myConn = datasource.getConnection();
			mySql="INSERT INTO carros (placa, modelo, horaentrada, horasaida)VALUE(?,?,?,?)";
			myStmt = myConn.prepareStatement(mySql);
			myStmt.setString(1,carro.getPlaca());
			myStmt.setString(2,carro.getModelo());
			myStmt.setString(3,carro.getHoraentrada());
			myStmt.setString(4,carro.getHorasaida());
			myStmt.execute();
		}finally{
			myStmt.close();
			myConn.close();
		}
		
		
	}

	public Carros getCarros(String carrosId) throws Exception {
		Carros carro =null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String mySql= "";
		try {
			myConn = datasource.getConnection();
			mySql = "SELECT id, placa, modelo, horaentrada, horasaida FROM CARROS WHERE id =?";
			myStmt = myConn.prepareStatement(mySql);
			myStmt.setInt(1, Integer.parseInt(carrosId));
			myRs = myStmt.executeQuery();
			if(myRs.next()) {
				
				int id = myRs.getInt("id");
				String placa = myRs.getString("placa");
				String modelo = myRs.getString("modelo");
				String horaentrada = myRs.getString("horaentrada");
				String horasaida = myRs.getString("horasaida");
				carro = new Carros(id,placa,modelo,horaentrada,horasaida);
			}else {
				throw new Exception("Nao foi possivel localizar o ID " + carrosId);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		/*finally {
			myRs.close();
			myStmt.close();
			myConn.close();
		}*/
		return carro;
	}
	
	public void updateCarros(Carros carro) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		String mySql = "";
		try {
			myConn = datasource.getConnection();
			mySql="UPDATE carros SET placa=?, modelo=?, horaentrada=?, horasaida=? WHERE ID =?";
			myStmt = myConn.prepareStatement(mySql);
			myStmt.setString(1,carro.getPlaca());
			myStmt.setString(2,carro.getModelo());
			myStmt.setString(3,carro.getHoraentrada());
			myStmt.setString(4,carro.getHorasaida());
			myStmt.setInt(5,carro.getId());
			myStmt.execute();
		}finally {
			myStmt.close();
			myConn.close();
		}
	}
	
	public void deleteCarros(int carrosId)throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		String mySql = "";
		try {
			myConn = datasource.getConnection();
			mySql="DELETE FROM carros WHERE ID =?";
			myStmt = myConn.prepareStatement(mySql);
			myStmt.setInt(1,carrosId);
			myStmt.execute();
		}finally {
			myStmt.close();
			myConn.close();
		}
	}

}
