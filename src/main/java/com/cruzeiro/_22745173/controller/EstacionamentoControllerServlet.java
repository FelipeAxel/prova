package com.cruzeiro._22745173.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.cruzeiro._22745173.jdbc.EstacionamentoDbUtil;
import com.cruzeiro._22745173.model.Carros;

/**
 * Servlet implementation class EstacionamentoControllerServlet
 */
@WebServlet("/EstacionamentoControllerServlet")
public class EstacionamentoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EstacionamentoDbUtil carrosDbUtil;
	@Resource (name = "jdbc/estacionamento")
	private DataSource datasource;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstacionamentoControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
    	try {
    		carrosDbUtil = new EstacionamentoDbUtil(datasource);
    	}catch(Exception e) {
    		throw new ServletException(e);
    	}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String command = request.getParameter("command");
			if(command == null) {
				command ="LIST";
			}
			
			switch(command) {
			case "LIST":
				listCarros(request, response);
				break;
			case "ADD":
				addCarro(request, response);
				break;
			case "LOAD":
				loadCarros(request,response);
				break;
			case "UPDATE":
				updateCarros(request, response);
				break;
			case "DELETE":
				deleteCarros(request,response);
				break;
			}
			
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


	private void deleteCarros(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("carrosId"));
		
		carrosDbUtil.deleteCarros(id);
		listCarros(request, response);
	}

	private void updateCarros(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String placa = request.getParameter("placa");
		String modelo = request.getParameter("modelo");
		String horaentrada = request.getParameter("horaentrada");
		String horasaida = request.getParameter("horasaida");
		int id = Integer.parseInt(request.getParameter("carrosId"));
		
		Carros carro = new Carros(id, placa, modelo, horaentrada, horasaida);
		carrosDbUtil.updateCarros(carro);
		listCarros(request, response);
	}

	private void loadCarros(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String carrosId = request.getParameter("carrosId");
		Carros carro = carrosDbUtil.getCarros(carrosId);
		request.setAttribute("T_carro", carro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-carros-form.jsp");
		dispatcher.forward(request, response);
	}

	private void addCarro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String placa = request.getParameter("placa");
		String modelo = request.getParameter("modelo");
		String horaentrada = request.getParameter("horaentrada");
		String horasaida = request.getParameter("horasaida");

		Carros carro = new Carros(0, placa, modelo, horaentrada, horasaida);
		carrosDbUtil.addCarro(carro);
		listCarros(request,response);
	}

	private void listCarros(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Carros> carros = carrosDbUtil.getCarros();
		request.setAttribute("carro_lista", carros);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/lista_carros.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
