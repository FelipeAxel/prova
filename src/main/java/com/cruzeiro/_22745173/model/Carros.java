package com.cruzeiro._22745173.model;

public class Carros {
	private int id;
	private String placa;
	private String modelo;
	private String horaentrada;
	private String horasaida;
	
	public Carros(int id, String placa, String modelo, String horaentrada, String horasaida) {
		super();
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.horaentrada = horaentrada;
		this.horasaida = horasaida;
	}
	public Carros() {
		super();
		this.id = 0;
		this.placa = "";
		this.modelo = "";
		this.horaentrada = "";
		this.horasaida = "";
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	public String getHoraentrada() {
		return horaentrada;
	}
	
	
	public void setHoraentrada(String horaentrada) {
		this.horaentrada = horaentrada;
	}
	
	
	
	public String getHorasaida() {
		return horasaida;
	}
	
	
	public void setHorasaida(String horasaida) {
		this.horasaida = horasaida;
	}

}
