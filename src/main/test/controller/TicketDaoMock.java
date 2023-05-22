package controller;

import java.util.ArrayList;
import java.util.List;

import DAO.TicketDaoImpl;
import model.TicketModel;

class TicketDaoImplMock extends TicketDaoImpl {
        private List<TicketModel> tickets;

        public TicketDaoImplMock() {
            this.tickets = new ArrayList<>();
        }

        public void addTicket(TicketModel ticket) {
            tickets.add(ticket);
        }

        public List<TicketModel> getTickets() {
            return tickets;
        }
    }