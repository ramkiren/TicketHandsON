package util;

import model.TicketModel;

public class TicketValidationUtil {
    public static boolean isValidTicket(TicketModel ticket) {
        return ticket != null &&
                isValidId(ticket.getId()) &&
                isValidName(ticket.getName()) &&
                isValidPriority(ticket.getPriority()) &&
                isValidMedium(ticket.getMedium()) &&
                isValidEmail(ticket.getEmail()) &&
                isValidPhone(ticket.getPhone());
    }

    static boolean isValidId(int id) {
        return id > 0;
    }

    static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    static boolean isValidPriority(String priority) {
        return priority != null && (priority.equals("low") || priority.equals("medium") || priority.equals("high"));
    }

    static boolean isValidMedium(String medium) {
        return medium != null && (medium.equals("email") || medium.equals("phone") || medium.equals("chat"));
    }

    private static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        // Use regular expressions to validate email format
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
    }

    private static boolean isValidPhone(long phone) {
        String phoneString = String.valueOf(phone);
        // Phone number must be between 8 and 15 digits
        return phoneString != null && phoneString.matches("\\d{8,15}");
    }
}
