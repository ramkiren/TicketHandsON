package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import DAO.TicketDaoImpl;
import model.TicketModel;



@WebServlet(name = "TicketServlet", urlPatterns = {"/ticket/*"})
public class getTicketByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TicketDaoImpl ticketDao;

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ticketDao = new TicketDaoImpl();

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		System.out.print("hai    "+request.getPathInfo());
        String pathInfo = request.getPathInfo();
       

        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
          
    		System.out.print("null  "+response.getStatus());

            return;
        }
        String[] pathParts = pathInfo.split("/");
        if (pathParts.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
          
            System.out.print("no parm "+response.getStatus());

            return;
        }
        int ticketId;
        try {
            ticketId = Integer.parseInt(pathParts[1]);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            System.out.print("non int   "+response.getStatus());

            return;
        }
      if(ticketId<0) {
	 response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	 System.out.print("id<0  "+response.getStatus());
	 return;
     }
		// TODO Auto-generated method stub
		doOptions(request, response);
		
		PrintWriter out = response.getWriter();
		TicketModel ticketList=new TicketModel();
		try {
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json");
			ticketList=ticketDao.getTicket(ticketId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(ticketList);
		
        
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