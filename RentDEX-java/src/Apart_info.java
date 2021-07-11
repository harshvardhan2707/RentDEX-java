import java.util.ArrayList;

public class Apart_info {
    private String state, city,type;private double area,price;
    private Contact_info contact_info;
	public Apart_info(String name,String state,String city, String phno, String email, double price, double area,String type) {
		super();
		this.contact_info=new Contact_info(phno,email,name);
		this.state = state;
		this.city = city;
		this.area = area;
		this.price = price;
		this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Contact_info getContact_info() {
		return contact_info;
	}

	public void setContact_info(Contact_info contact_info) {
		this.contact_info = contact_info;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
