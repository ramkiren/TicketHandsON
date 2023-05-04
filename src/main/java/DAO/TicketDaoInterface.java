package DAO;

import java.sql.SQLException;
import java.util.List;

import model.TicketModel;


public interface TicketDaoInterface {
    boolean insertUser(TicketModel ticket);
    List<TicketModel> getTickets();
    TicketModel getTicket(Integer id) throws SQLException;
    boolean updateTicket(TicketModel ticket) throws SQLException;
    boolean deleteTicket(Integer id, Integer ticket_id) throws SQLException;
}
