package util;


import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

import DAO.TicketDaoImpl;
import model.MessageModel;
import util.TicketDeletionHandler;

public class TicketDeletionHandler {



	public String deleteTicket(String requestBody) throws Exception {
		JSONObject json = new JSONObject(requestBody);
		TicketDaoImpl ticketDeleter= new TicketDaoImpl ();
		try {
			Integer primaryId = json.getInt("primaryId");
			Integer id = json.getInt("id");
			validateInput(primaryId, id);
			boolean wasTicketDeleted = ticketDeleter.deleteTicket(primaryId, id);
            if (wasTicketDeleted) {
                return getSuccessMessage();
            } else {
                throw new Exception("Ticket not found or could not be deleted: primaryId=" + primaryId + ", id=" + id);
            }
			
		} catch (JSONException | IllegalArgumentException e) {
			throw new Exception("Error deleting ticket");
		}
	}

	private String getSuccessMessage() throws JsonProcessingException {
        MessageModel message = new MessageModel("Ticket deleted");
        return JsonConverter.toJsonString(message);
    }

	private void validateInput(Integer primaryId, Integer id) {
		if (primaryId == null || id == null) {
			throw new IllegalArgumentException("Primary ID and Ticket ID cannot be null");
		}
		if (primaryId <= 0 || id <= 0) {
			throw new IllegalArgumentException("Primary ID and Ticket ID must be positive integers");
		}
	}


}
