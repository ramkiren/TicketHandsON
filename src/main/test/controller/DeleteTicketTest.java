package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DAO.TicketDaoImpl;
import Mocks.MockHttpServletRequest;
import Mocks.MockHttpServletResponse;
import Mocks.TicketDeletionHandlerMock;

class DeleteTicketTest {

	private TicketDaoImpl TicketDao;
	private TicketDeletionHandlerMock TicketDeletionHandler;
	private static MockHttpServletRequest request;
	private static MockHttpServletResponse response;

	private StringWriter stringWriter;
	private PrintWriter writer;
	private deleteTicket deleteTicketServlet;

	@BeforeEach
	void setUp() throws IOException {
		TicketDao = new TicketDaoImpl();
		TicketDeletionHandler = new TicketDeletionHandlerMock();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		stringWriter = new StringWriter();
		writer = new PrintWriter(stringWriter);
		deleteTicketServlet = new deleteTicket(TicketDao, TicketDeletionHandler);
	}

	@Test
	void testDoDelete_SuccessfulDeletion() throws ServletException, IOException {
		//Given
		String requestBody = "{\"primaryId\": 1, \"id\": 1}";
		request.setReader(new BufferedReader(new StringReader(requestBody)));
		response.setWriter(writer);
		TicketDeletionHandler.setDeleteTicketResult("Ticket deleted");

		//When
		deleteTicketServlet.doDelete(request, response);

		//Then
		assertTrue(TicketDeletionHandler.isDeleteTicketCalled());
		assertEquals(HttpServletResponse.SC_OK, response.getStatus());
		assertEquals("application/json", response.getContentType());
		assertEquals("UTF-8", response.getCharacterEncoding());

		writer.flush();
		String responseString = stringWriter.toString().trim();
		assertEquals("\"Ticket deleted\"", responseString);
	}

	@Test
	void testDoDelete_FailedDeletion() throws ServletException, IOException {
		// Arrange
		String requestBody = "{\"primaryId\": 1, \"id\": 1}";
		request.setReader(new BufferedReader(new StringReader(requestBody)));
		response.setWriter(writer);
		TicketDeletionHandler.setDeleteTicketResult("Error deleting ticket");

		// Act
		deleteTicketServlet.doDelete(request, response);

		// Assert
		assertTrue(TicketDeletionHandler.isDeleteTicketCalled());
		assertEquals(HttpServletResponse.SC_BAD_REQUEST, response.getStatus());
		assertEquals("application/json", response.getContentType());
		assertEquals("UTF-8", response.getCharacterEncoding());

		writer.flush();
		String responseString = stringWriter.toString().trim();
		assertTrue(responseString.contains("Failed to delete ticket"));
	}

}