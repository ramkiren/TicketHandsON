package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnectionUtil;

import model.TicketModel;
import util.TicketValidationUtil;

public class TicketDaoImpl implements TicketDaoInterface {

	private static final String INSERT_TICKET_SQL = "INSERT INTO dl_tickets"
			+ " (ticket_id, name, priority, medium, email, phone	) VALUE" + " (?, ?, ?, ?, ?, ?);";
	private static final String DELETE_TICKET_SQL = "DELETE FROM dl_tickets WHERE ticket_id=? and id=?;";
	private static final String UPDATE_TICKET_SQL = "UPDATE dl_tickets set name=?, priority=?, medium=?, email=?, phone=? where ticket_id=? and id=?;";
	private static final String LIST_TICKET_SQL = "SELECT * FROM dl_tickets";
	private static final String SELECT_TICKEY_BY_PRIMARYID = "SELECT * FROM dl_tickets WHERE ticket_id=?;";


	public TicketModel getTicket(Integer id) throws SQLException {
		TicketModel ticket = new TicketModel();
		try (Connection connection = DatabaseConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_TICKEY_BY_PRIMARYID)) {

			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			ticket = new TicketModel();
			while (rs.next()) {
				Integer primaryId = rs.getInt("id");
				Integer id1 = rs.getInt("ticket_id");
				String name = rs.getString("name");
				String priority = rs.getString("priority");
				String medium = rs.getString("medium");
				String email = rs.getString("email");
				Long phone = rs.getLong("phone");
				ticket = new TicketModel(primaryId, id1, name, priority, medium, email, phone);
			}
		}
		return ticket;
	}

	public List<TicketModel> getTickets() {
		ArrayList<TicketModel> ticketsList = new ArrayList<TicketModel>();
		try (Connection connection = DatabaseConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(LIST_TICKET_SQL)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Integer primaryId = rs.getInt("id");
				Integer id = rs.getInt("ticket_id");
				String name = rs.getString("name");
				String priority = rs.getString("priority");
				String medium = rs.getString("medium");
				String email = rs.getString("email");
				Long phone = rs.getLong("phone");
				TicketModel ticket = new TicketModel(primaryId, id, name, priority, medium, email, phone);
				ticketsList.add(ticket);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticketsList;
	}

	public boolean insertUser(TicketModel ticket) {
		if (!TicketValidationUtil.isValidTicket(ticket)) {
			System.out.println("Invalid ticket data.");
			return false;
		}
		boolean valueInserted = false;
		try (Connection connection = DatabaseConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_TICKET_SQL)) {
			statement.setInt(1, ticket.getId());
			statement.setString(2, ticket.getName());
			statement.setString(3, ticket.getPriority());
			statement.setString(4, ticket.getMedium());
			statement.setString(5, ticket.getEmail());
			statement.setLong(6, ticket.getPhone());
			System.out.println(statement);
			statement.executeUpdate();
			valueInserted = true;
		} catch (SQLException e) {
			e.printStackTrace();
			valueInserted = false;
		}
		return valueInserted;
	}

	public boolean updateTicket(TicketModel ticket) throws SQLException {
		boolean ticketUpdate = false;
		try (Connection connection = DatabaseConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TICKET_SQL)) {
			statement.setString(1, ticket.getName());
			statement.setString(2, ticket.getPriority());
			statement.setString(3, ticket.getMedium());
			statement.setString(4, ticket.getEmail());
			statement.setLong(5, ticket.getPhone());
			statement.setInt(6, ticket.getId());
			statement.setInt(7, ticket.getPrimaryId());
			statement.executeUpdate();
			ticketUpdate = true;
		}
		return ticketUpdate;
	}
	public boolean deleteTicket(Integer primaryId, Integer id) throws SQLException {
	 
	    if (!ticketExists(primaryId, id)) {
	        throw new SQLException("Ticket with primary ID " + primaryId + " and ID " + id + " does not exist");
	    }

	    try (Connection connection = DatabaseConnectionUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement(DELETE_TICKET_SQL)) {
	        statement.setInt(1, primaryId);
	        statement.setInt(2, id);
	        int rowsAffected = statement.executeUpdate();
	        return rowsAffected > 0;
	    }
	}

	private boolean ticketExists(Integer primaryId, Integer id) throws SQLException {
	    try (Connection connection = DatabaseConnectionUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement(SELECT_TICKEY_BY_PRIMARYID)) {
	        statement.setInt(1, primaryId);
	        try (ResultSet rs = statement.executeQuery()) {
	            return rs.next();
	        }
	    }
	}

}
