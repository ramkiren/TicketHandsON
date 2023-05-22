package controller;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Mocks.MockHttpServletRequest;
import Mocks.MockHttpServletResponse;

public class GetTicketByIDTest {

	private static MockHttpServletRequest request;
	private static MockHttpServletResponse response;
	private static StringWriter stringWriter;

	private static PrintWriter writer;

	@BeforeAll
	public static void setUp() throws Exception {

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
		request.setPathInfo("ticket/" + ticketId);
		servlet.init();
		servlet.doGet(request, response);
		String actualJson = stringWriter.toString();
		String expectedJson = "{\"primaryId\":1005,\"id\":5,\"name\":\"Sarah\",\"priority\":\"Low\",\"medium\":\"Email\",\"email\":\"sarah@example.com\",\"phone\":5678901234}"; 																																			// response
		assertEquals(expectedJson, actualJson);
		assertEquals("application/json", response.getContentType());
		assertEquals(HttpServletResponse.SC_OK, response.getStatus());
	}

	@AfterAll
	public static void clear() {
		writer.flush();
	}

}
