package model;

public class TicketModel {
	
	private Integer primaryId;
	private Integer id;
	private String name;
	private String priority;
	private String medium;
	private String email;
	private Long phone;
	
	public TicketModel(Integer id, String name, String priority, String medium, String email, Long phone) {
		super();
		this.id = id;
		this.name = name;
		this.priority = priority;
		this.medium = medium;
		this.email = email;
		this.phone = phone;
	}

	public TicketModel(Integer primaryId, Integer id, String name, String priority, String medium, String email,
			Long phone) {
		super();
		this.primaryId = primaryId;
		this.id = id;
		this.name = name;
		this.priority = priority;
		this.medium = medium;
		this.email = email;
		this.phone = phone;
	}

	public TicketModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Integer getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(Integer primaryId) {
		this.primaryId = primaryId;
	}
	
}
