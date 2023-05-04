package model;


public class MessageModel {
	
	private String message;

	public MessageModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageModel(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageModel [message=" + message + "]";
	}

}
