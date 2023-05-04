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

;

public class deleteTicket {
	TicketDaoImpl ticketDao;
    public void init() throws ServletException {
    	ticketDao = new TicketDaoImpl();
    }
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject(request.getReader().lines().collect(Collectors.joining()));
		ObjectMapper mapper = new ObjectMapper();
		try {
			Integer primaryId = json.getInt("primaryId");
			Integer id = json.getInt("id");
			boolean isUpdated  = ticketDao.deleteTicket(primaryId, id);
			if(isUpdated) {
				MessageModel message = new MessageModel("Ticket deleted");
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

}
