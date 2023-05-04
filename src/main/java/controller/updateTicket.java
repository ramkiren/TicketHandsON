package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.TicketDaoImpl;
import model.MessageModel;
import model.TicketModel;


public class updateTicket {
	TicketDaoImpl ticketDao;
   

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doOptions(request, response);
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject(request.getReader().lines().collect(Collectors.joining()));
		ObjectMapper mapper = new ObjectMapper();
		try {
			Integer primaryId = json.getInt("primaryId");
			Integer id = json.getInt("id");
			String name = json.getString("name");
			String priority = json.getString("priority");
			String medium = json.getString("medium");
			String email = json.getString("email");
			Long phone = json.getLong("phone");
			TicketModel ticket = new TicketModel(primaryId, id, name, priority, medium, email, phone);
			boolean isUpdated  = ticketDao.updateTicket(ticket);
			if(isUpdated) {
				MessageModel message = new MessageModel("Ticket Updated");
				String jsonString = mapper.writeValueAsString(message);
				response.setStatus(200);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.write(jsonString);
			}
			else {
				throw new Exception();
			}
		} catch (JSONException e) {
			System.out.println(e);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(400);
			String jsonString = mapper.writeValueAsString(e);
			out.write(jsonString);

		} catch (Exception e) {
			System.out.println(e);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(400);
			String jsonString = mapper.writeValueAsString(e);
			out.write(jsonString);
		}
		
	}
	

	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doOptions(request, response);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
		response.setHeader("Allow", "GET, HEAD, POST, TRACE, OPTIONS");
		response.setContentType("application/json");
	}
}
