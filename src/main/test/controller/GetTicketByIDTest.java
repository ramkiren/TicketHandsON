package controller;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Mocks.MockHttpServletRequest;
import Mocks.MockHttpServletResponse;

public class GetTicketByIDTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private StringWriter stringWriter;
    
	private PrintWriter writer;
	
    @BeforeEach
    public void setUp() throws Exception {

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        stringWriter = new StringWriter();
		writer = new PrintWriter(stringWriter);
        
    }
    @Test
    public void testDoGetWithValidTicketId() throws Exception {
        int ticketId = 5;
        getTicketByID servlet = new getTicketByID();
	    response.setWriter(writer);
	    request.setPathInfo("ticket/"+ticketId);
        servlet.init();
        servlet.doGet(request, response);
        String actualJson = stringWriter.toString();
       
        writer.flush();
        String expectedJson = "{\"primaryId\":1005,\"id\":5,\"name\":\"Sarah\",\"priority\":\"Low\",\"medium\":\"Email\",\"email\":\"sarah@example.com\",\"phone\":5678901234}"; // Replace with expected JSON response
     
        assertEquals(expectedJson, actualJson);
        assertEquals("application/json", response.getContentType());
        assertEquals(HttpServletResponse.SC_OK, response.getStatus());
    }
    @Test
    public void testDoGetWithInvalidTicketId() throws Exception {
        
        getTicketByID servlet = new getTicketByID();
        response.setWriter(writer);
        request.setPathInfo(null);
        servlet.init();
        servlet.doGet(request, response);
        writer.flush();
        assertEquals(HttpServletResponse.SC_BAD_REQUEST, response.getStatus());
    }

}
