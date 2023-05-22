package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.TicketDaoImpl;
import model.TicketModel;

@WebServlet("/ticket/all")
public class getAllTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TicketDaoImpl ticketDao;

	@Override
	public void init() throws ServletException {
		super.init();
		ticketDao = new TicketDaoImpl();
	}

	public getAllTickets(TicketDaoImpl ticketDao) throws ServletException {
		this.ticketDao = ticketDao;
	}
	public getAllTickets() {
	    // Constructor implementation
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("application/json");
		doOptions(request, response);
		ArrayList<TicketModel> ticketList = (ArrayList<TicketModel>) ticketDao.getTickets();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(ticketList);
		PrintWriter out = response.getWriter();
		out.write(jsonString);
	}

	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(request, response);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
		response.setHeader("Allow", "GET, HEAD, POST, TRACE, OPTIONS");
		response.setContentType("application/json");
	}

}