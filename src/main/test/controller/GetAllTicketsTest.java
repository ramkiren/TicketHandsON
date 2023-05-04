package controller;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import Mocks.MockHttpServletRequest;
import Mocks.MockHttpServletResponse;

public class GetAllTicketsTest {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private StringWriter stringWriter;
	private PrintWriter writer;

	@Before
	public void setUp() throws Exception {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		stringWriter = new StringWriter();
		writer = new PrintWriter(stringWriter);
	    response.setWriter(writer);
	}

	@Test
	public void testDoGet() throws ServletException, IOException {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		stringWriter = new StringWriter();
		writer = new PrintWriter(stringWriter);
	    response.setWriter(writer);
		getAllTickets servlet = new getAllTickets();
		String expectedJson = "[{\"primaryId\":1001,\"id\":1,\"name\":\"John\",\"priority\":\"High\",\"medium\":\"Email\",\"email\":\"john@example.com\",\"phone\":1234567890},{\"primaryId\":1002,\"id\":2,\"name\":\"Mary\",\"priority\":\"Low\",\"medium\":\"Phone\",\"email\":\"mary@example.com\",\"phone\":2345678901},{\"primaryId\":1003,\"id\":3,\"name\":\"Jane\",\"priority\":\"Medium\",\"medium\":\"Email\",\"email\":\"jane@example.com\",\"phone\":3456789012},{\"primaryId\":1004,\"id\":4,\"name\":\"Bob\",\"priority\":\"High\",\"medium\":\"Phone\",\"email\":\"bob@example.com\",\"phone\":4567890123},{\"primaryId\":1005,\"id\":5,\"name\":\"Sarah\",\"priority\":\"Low\",\"medium\":\"Email\",\"email\":\"sarah@example.com\",\"phone\":5678901234},{\"primaryId\":1006,\"id\":6,\"name\":\"David\",\"priority\":\"Medium\",\"medium\":\"Phone\",\"email\":\"david@example.com\",\"phone\":6789012345},{\"primaryId\":1007,\"id\":7,\"name\":\"Karen\",\"priority\":\"High\",\"medium\":\"Email\",\"email\":\"karen@example.com\",\"phone\":7890123456},{\"primaryId\":1008,\"id\":8,\"name\":\"Tom\",\"priority\":\"Low\",\"medium\":\"Phone\",\"email\":\"tom@example.com\",\"phone\":8901234567},{\"primaryId\":1009,\"id\":9,\"name\":\"Amy\",\"priority\":\"Medium\",\"medium\":\"Email\",\"email\":\"amy@example.com\",\"phone\":9012345678},{\"primaryId\":1010,\"id\":10,\"name\":\"Peter\",\"priority\":\"High\",\"medium\":\"Phone\",\"email\":\"peter@example.com\",\"phone\":1234567890}]";
		servlet.init();
		servlet.doGet(request, response);
		String actualJson = stringWriter.toString();
	    System.out.print(response.getStatus());
		writer.flush();
		assertEquals(expectedJson, actualJson);
		assertEquals("application/json", response.getContentType());
	    assertEquals(HttpServletResponse.SC_OK, response.getStatus());
	}

}
