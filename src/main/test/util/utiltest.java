package util;



import org.junit.jupiter.api.Test;



import model.TicketModel;
import org.junit.jupiter.api.Assertions;


class utiltest {
    
    @Test
    void testIsValidTicket() {
        // Test valid ticket
        TicketModel validTicket = new TicketModel(1, "ram", "low", "email", "ram@example.com", 1234567890L);
        Assertions.assertTrue(TicketValidationUtil.isValidTicket(validTicket));
        
        // Test invalid ticket with null values
        TicketModel invalidTicket1 = new TicketModel(1, null, null, null, null, 0L);
        Assertions.assertFalse(TicketValidationUtil.isValidTicket(invalidTicket1));
        
        // Test invalid ticket with empty name
        TicketModel invalidTicket2 = new TicketModel(1, "", "low", "email", "ram@example.com", 1234567890L);
        Assertions.assertFalse(TicketValidationUtil.isValidTicket(invalidTicket2));
        
        // Test invalid ticket with invalid priority
        TicketModel invalidTicket3 = new TicketModel(1, "kiren", "invalid", "email", "ram@example.com", 1234567890L);
        Assertions.assertFalse(TicketValidationUtil.isValidTicket(invalidTicket3));
        
        // Test invalid ticket with invalid medium
        TicketModel invalidTicket4 = new TicketModel(1, "ram", "low", "invalid", "ram@example.com", 1234567890L);
        Assertions.assertFalse(TicketValidationUtil.isValidTicket(invalidTicket4));
          
    }
    
    @Test
    void testIsValidId() {
        Assertions.assertTrue(TicketValidationUtil.isValidId(1));
        Assertions.assertFalse(TicketValidationUtil.isValidId(0));
        Assertions.assertFalse(TicketValidationUtil.isValidId(-1));
    }
    
    @Test
    void testIsValidName() {
        Assertions.assertTrue(TicketValidationUtil.isValidName("John Doe"));
        Assertions.assertFalse(TicketValidationUtil.isValidName(null));
        Assertions.assertFalse(TicketValidationUtil.isValidName(""));
        Assertions.assertFalse(TicketValidationUtil.isValidName(" "));
    }
    
    @Test
    void testIsValidPriority() {
        Assertions.assertTrue(TicketValidationUtil.isValidPriority("low"));
        Assertions.assertTrue(TicketValidationUtil.isValidPriority("medium"));
        Assertions.assertTrue(TicketValidationUtil.isValidPriority("high"));
        Assertions.assertFalse(TicketValidationUtil.isValidPriority(null));
        Assertions.assertFalse(TicketValidationUtil.isValidPriority(""));
        Assertions.assertFalse(TicketValidationUtil.isValidPriority("invalid"));
    }
    
    @Test
    void testIsValidMedium() {
        Assertions.assertTrue(TicketValidationUtil.isValidMedium("email"));
        Assertions.assertTrue(TicketValidationUtil.isValidMedium("phone"));
        Assertions.assertTrue(TicketValidationUtil.isValidMedium("chat"));
        Assertions.assertFalse(TicketValidationUtil.isValidMedium(null));
        Assertions.assertFalse(TicketValidationUtil.isValidMedium(""));
        Assertions.assertFalse(TicketValidationUtil.isValidMedium("invalid"));
    }
  
    
    // write remaining validation
    
}
