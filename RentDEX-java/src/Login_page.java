//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//public class Signup extends JFrame {
//
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Signup frame = new Signup();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public Signup() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//	}
//
//}
import java.util.regex.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Login_page{
	static Connection conn;static Statement stmt;static ResultSet rs;static String u,p;
	private JFrame frame;
	private JTextField T1;
	private JPasswordField P1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_page window = new Login_page();
					window.frame.setVisible(true);
					Class.forName("com.mysql.cj.jdbc.Driver");  
		            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","1234");  
		            stmt = conn.createStatement();  
		            rs = stmt.executeQuery("select * from login");    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_page() {
		initialize();
	}
	public JFrame getframe() {
		return frame;
	}
	private void clearText(){
        T1.setText("");
        P1.setText("");
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 0, 128));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(215, 49, 514, 642);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 102, 153));
		panel_1.setBounds(10, 10, 494, 622);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Poor Richard", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 10, 474, 68);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1.setFont(new Font("Poor Richard", Font.BOLD, 33));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 162, 238, 55);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		panel_2.setBounds(238, 162, 228, 56);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		T1 = new JTextField();
		T1.setHorizontalAlignment(SwingConstants.CENTER);
		T1.setFont(new Font("Agency FB", Font.BOLD, 30));
		T1.setBounds(10, 10, 208, 36);
		panel_2.add(T1);
		T1.setColumns(10);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		panel_2_1.setBounds(238, 270, 228, 56);
		panel_1.add(panel_2_1);
		
		P1 = new JPasswordField();
		P1.setHorizontalAlignment(SwingConstants.CENTER);
		P1.setFont(new Font("Tahoma", Font.BOLD, 22));
		P1.setBounds(10, 10, 208, 36);
		panel_2_1.add(P1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1_1.setFont(new Font("Poor Richard", Font.BOLD, 33));
		lblNewLabel_1_1.setBounds(0, 270, 238, 55);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 0, 128));
		panel_3.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		panel_3.setBounds(165, 376, 179, 55);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.setBounds(10, 10, 157, 34);
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String regex = "^[A-Za-z]\\w{5,29}$";
				Pattern p1 = Pattern.compile(regex);
				u=T1.getText();
                p=String.valueOf(P1.getPassword()); 
try {
	Matcher m=p1.matcher(u);
	if(u==null || !m.matches()) throw new Exception("Invalid username! Username should begin with a letter and consist of at least 6 characters.");
	if(p==null|| p.length()<8) throw new Exception("Password should be atleast 8 characters long.");
	Class.forName("com.mysql.cj.jdbc.Driver");  
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","1234");  
    stmt = conn.createStatement();
    rs=stmt.executeQuery("select * from login where username='"+u+"'");
    if(!rs.next()){ stmt.executeUpdate("insert into login values('"+u+"','"+p+"')");
            clearText();
            JOptionPane.showMessageDialog(null,"Welcome to RentDex "+u+"! To continue please login with the credentials that you have provided.");
            }
    else{
        clearText();
       throw new Exception("Sorry this username is taken"); 
    }
} catch (Exception ex) {
	System.out.println(ex);
	JOptionPane.showMessageDialog(null,ex.getMessage());
    clearText();
    
}
			}
			
		});
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 26));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		panel_3_1.setBackground(new Color(128, 0, 128));
		panel_3_1.setBounds(165, 453, 179, 55);
		panel_1.add(panel_3_1);
		
		JButton btnSignUp = new JButton("Login");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u=T1.getText();
                p=String.valueOf(P1.getPassword()); 
                
try {
	Class.forName("com.mysql.cj.jdbc.Driver");  
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","1234");  
    stmt = conn.createStatement();
    rs = stmt.executeQuery("select * from login where username='"+u+"'");// TODO add your handling code here:
    clearText();
    if(!rs.next()|| !rs.getString("username").equals(u)){ 
        
        throw new Exception("This username is not present in the database");}
    else if(!p.equals(rs.getString("password")))throw new Exception("Your password is incorrect");
    else {
    	JOptionPane.showMessageDialog(null,"Welcome back "+u+"!");
    F2 f2=new F2();
    f2.getframe().setVisible(true);
    conn.close();
    stmt.close();
    rs.close();
    
    frame.dispose();
    
    }
} catch (Exception ex) {
	JOptionPane.showMessageDialog(null,ex.getMessage());
}
			}
		});
		btnSignUp.setFont(new Font("Agency FB", Font.BOLD, 26));
		btnSignUp.setBounds(12, 10, 157, 34);
		panel_3_1.add(btnSignUp);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		panel_3_2.setBackground(new Color(128, 0, 128));
		panel_3_2.setBounds(165, 531, 179, 55);
		panel_1.add(panel_3_2);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setToolTipText("\r\n");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Agency FB", Font.BOLD, 26));
		btnExit.setBounds(12, 10, 157, 34);
		panel_3_2.add(btnExit);
		frame.setBounds(100, 100, 939, 776);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}