package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.TicketDaoImpl;
import util.TicketDeletionHandler;

@WebServlet(name = "DeleteTicketServlet", urlPatterns = { "/ticket/delete" })
public class deleteTicket extends HttpServlet {

	private static final long serialVersionUID = 1L;
	TicketDaoImpl ticketDao;
	TicketDeletionHandler ticketDeletionHandler; // Added dependency

	public deleteTicket(TicketDaoImpl ticketDao, TicketDeletionHandler ticketDeletionHandler) {
		this.ticketDao = ticketDao;
		this.ticketDeletionHandler = ticketDeletionHandler;
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, JSONException {
		PrintWriter out = response.getWriter();
		String requestBody = request.getReader().lines().collect(Collectors.joining());
		ObjectMapper mapper = new ObjectMapper();
		try {
			String  responseString = ticketDeletionHandler.deleteTicket(requestBody); // Use the injected dependency
			if (responseString=="Ticket deleted") {
				String jsonString = mapper.writeValueAsString(responseString);
				response.setStatus(200);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.write(jsonString);
			} else
				throw new Exception("Failed to delete ticket");
		} catch (Exception e) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(400);
			String jsonString = new ObjectMapper().writeValueAsString(e);
			out.write(jsonString);
		}
	}
}
