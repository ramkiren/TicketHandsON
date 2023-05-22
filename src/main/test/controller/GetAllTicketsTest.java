package controller;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;


import org.junit.Before;
import org.junit.Test;

import DAO.TicketDaoImpl;
import Mocks.MockHttpServletRequest;
import Mocks.MockHttpServletResponse;
import Mocks.TicketDeletionHandlerMock;
import model.TicketModel;
import util.JsonConverter;

public class GetAllTicketsTest {
	
	private static MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private StringWriter stringWriter;
	private static PrintWriter writer;
    private TicketDaoImplMock TicketListMock;
	private getAllTickets getAlltickets;
	@Before
	public void setUp() throws Exception {
		
		response = new MockHttpServletResponse();
		stringWriter = new StringWriter();
		writer = new PrintWriter(stringWriter);
		request = new MockHttpServletRequest();
	    response.setWriter(writer);
	    TicketListMock= new TicketDaoImplMock();
	    getAlltickets = new getAllTickets(TicketListMock);
	}
	@Test
	public void testDoGet() throws ServletException, IOException {
		//given
		TicketListMock.addTicket(new TicketModel(1005,5,"Sarah","Low","Email","sarah@example.com",5678901234L));
		List<TicketModel> ticketList =(ArrayList<TicketModel>)TicketListMock.getTickets();
        String jsonString = JsonConverter.convertToJson(ticketList);
        String expectedJson = "[{\"primaryId\":1005,\"id\":5,\"name\":\"Sarah\",\"priority\":\"Low\",\"medium\":\"Email\",\"email\":\"sarah@example.com\",\"phone\":5678901234}]";
        //when
        getAlltickets.doGet(request, response);
        PrintWriter out = response.getWriter();
        out.write(jsonString);
        String actualJson = stringWriter.toString();
        //then
        assertEquals(expectedJson, actualJson);
       
	}
}
