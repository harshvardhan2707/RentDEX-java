import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main1 {

	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("E:\\Flats\\A1\\Bedroom_1.jpg");
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","1234");  
            Statement stmt = conn.createStatement();  
            stmt.executeUpdate("insert into images values('E:\\"+"\\Flats\\"+"\\A1\\"+"\\Washroom_2.jpg','7825462383','Washroom 2')");  
            ResultSet rs=stmt.executeQuery("select * from images");
            
       
            System.out.println("Done");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
