public class Contact_info {
	
	private String phone_no, email_id,name;

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Contact_info(String phone_no, String email_id, String name) {
		super();
		this.phone_no = phone_no;
		this.email_id = email_id;
		this.name = name;
	}
}
