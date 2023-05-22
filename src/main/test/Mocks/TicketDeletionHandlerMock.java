package Mocks;

import util.TicketDeletionHandler;

//Mock implementation of TicketDeletionHandler
public class TicketDeletionHandlerMock extends TicketDeletionHandler {
    private String deleteTicketResult;
    private boolean deleteTicketCalled;

    public void setDeleteTicketResult(String deleteTicketResult) {
        this.deleteTicketResult = deleteTicketResult;
    }

    public boolean isDeleteTicketCalled() {
        return deleteTicketCalled;
    }

    @Override
    public String deleteTicket(String requestBody) {
        deleteTicketCalled = true;
        return deleteTicketResult;
    }
}