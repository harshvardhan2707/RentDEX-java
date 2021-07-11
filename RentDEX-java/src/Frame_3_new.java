import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//public class Frame_3 extends JFrame {
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
//					Frame_3 frame = new Frame_3();
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
//	public Frame_3() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//	}
//
//}
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Frame_3_new{
static ResultSet rs;private Apart_info a;
	private JFrame frame;
	private JTextField name;
	private JTextField phno;
	private JTextField email;
	private JComboBox R1;
	private JLabel Label;private JPanel panel_4;
	private ArrayList<GenImage> images=new ArrayList<GenImage>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Frame_3_new window = new Frame_3_new();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public Frame_3_new() {
		
		initialize();
	}
	public JFrame getframe() {
		return frame;
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			if(F2.rs.next()) {
			a=new Apart_info(F2.rs.getString(1),F2.rs.getString(2),F2.rs.getString(3),F2.rs.getString(4),F2.rs.getString(5),F2.rs.getDouble(6),F2.rs.getDouble(7),F2.rs.getString(8));}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 0, 128));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(283, 10, 548, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome "+Login_page.u+"!");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(10, 10, 528, 30);
		panel.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(80, 86, 957, 131);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea txtrHey = new JTextArea();
		txtrHey.setEditable(false);
		txtrHey.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 20));
		txtrHey.setText("Type of flat - "+a.getType()+"\nRent per month - "+a.getPrice()+"\nArea in sq ft - "+a.getArea());
		txtrHey.setBackground(new Color(153, 102, 153));
		txtrHey.setBounds(10, 10, 466, 111);
		panel_2.add(txtrHey);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 20));
		textArea.setText("State - "+a.getState()+"\nCity - "+a.getCity());
		textArea.setBackground(new Color(153, 102, 153));
		textArea.setBounds(486, 10, 461, 111);
		panel_2.add(textArea);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_3.setBounds(80, 248, 228, 60);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		R1 = new JComboBox();
		
		R1.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
		R1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
//				for(GenImage x:a.getImages()) {
//					Label.setIcon(x.getModifiedImage(R1.getSelectedItem().toString()));
//				}
				try {
					for(GenImage x:images) {
						if(x.getModifiedImage(R1.getSelectedItem().toString())!=null) {
						Label.setIcon(x.getModifiedImage(R1.getSelectedItem().toString()));
						Label.setPreferredSize(new Dimension(x.getWidth(),346));
						panel_4.setSize(x.getWidth()+20,366);
						}
					}}
					catch(Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
		R1.setBounds(10, 10, 208, 40);
		panel_3.add(R1);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(153, 102, 153));
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_4.setBounds(379, 248, 658, 366);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		Label = new JLabel("");
		Label.setToolTipText("Images of the "+a.getType()+" will be displayed here");
		Label.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		Label.setBounds(10, 10, 638, 346);
		
		
		panel_4.add(Label,"push, align center");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(169, 169, 169));
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_6.setBounds(80, 624, 829, 124);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(153, 102, 153));
		panel_7.setBounds(10, 10, 809, 104);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(20, 10, 172, 34);
		panel_7.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Phone no.");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblNewLabel_2_1.setBounds(299, 10, 172, 34);
		panel_7.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblNewLabel_2_2.setBounds(574, 10, 172, 34);
		panel_7.add(lblNewLabel_2_2);
		
		name = new JTextField();
		name.setToolTipText("Name of the owner");
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		name.setText(a.getContact_info().getName());
		name.setEditable(false);
		name.setBounds(10, 54, 218, 40);
		panel_7.add(name);
		name.setColumns(10);
		
		phno = new JTextField();
		phno.setToolTipText("Phone number of the owner");
		phno.setText(a.getContact_info().getPhone_no());
		phno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phno.setEditable(false);
		phno.setColumns(10);
		phno.setBounds(285, 54, 218, 40);
		panel_7.add(phno);
		
		email = new JTextField();
		email.setToolTipText("Email address of the owner");
		email.setText(a.getContact_info().getEmail_id());
		email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		email.setEditable(false);
		email.setColumns(10);
		email.setBounds(529, 54, 259, 40);
		panel_7.add(email);
		
		JLabel lblNewLabel = new JLabel("For more information , ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(80, 533, 255, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contact below");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 23));
		lblNewLabel_1.setBounds(47, 570, 228, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(192, 192, 192));
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_8.setBounds(919, 624, 118, 124);
		frame.getContentPane().add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(153, 102, 153));
		panel_9.setBounds(10, 10, 98, 104);
		panel_8.add(panel_9);
		panel_9.setLayout(null);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setToolTipText("Exits the program");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F2.getframe().setVisible(true);
				frame.dispose();
				
				
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 22));
		btnNewButton.setBounds(10, 10, 78, 84);
		panel_9.add(btnNewButton);
		frame.setBounds(100, 100, 1127, 805);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			F2.rs=F2.stmt.executeQuery("select name,location from images where phno='"+a.getContact_info().getPhone_no()+"'");
			System.out.println("select name,location from images where phno='"+a.getContact_info().getPhone_no()+"'");
			while(F2.rs.next()) {
				System.out.println(F2.rs.getString("name")+" "+F2.rs.getString("location"));
				images.add(new GenImage(F2.rs.getString(1),F2.rs.getString(2)));
			}
			for(GenImage x:images) {
				R1.addItem(x.getS());
			}
			R1.setSelectedIndex(0);
			R1.setToolTipText("Select any of the following options to see the image of the same");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
