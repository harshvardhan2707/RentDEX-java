//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//
//public class lol {
//
//	private JFrame frame;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					lol window = new lol();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public lol() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//
//}

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class F2 {
	static Connection conn;static Statement stmt;static ResultSet rs;static String u,p;
	private static JFrame frame;private JComboBox R1,R2,R3,R4;private String a1,a2,a3,a4;
private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					F2 window = new F2();
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
	public F2() {
		initialize();
	}
	public String setText(String x){
	    return x;
	}
	public static JFrame getframe() {
		return frame;
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void updateTable() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","1234");  
	        stmt = conn.createStatement();
			if(R2.getSelectedIndex()!=-1) {
				System.out.println("select type,area as 'area(sq. ft)',price as 'price(negotiable)',name,phno from rent where "+changeTable(R1.getSelectedItem().toString(),R2.getSelectedItem().toString(),R3.getSelectedItem().toString(),R4.getSelectedItem().toString()));
			rs=stmt.executeQuery("select type,area as 'area(sq. ft)',price as 'price(negotiable)',name,phno from rent where "+changeTable(R1.getSelectedItem().toString(),R2.getSelectedItem().toString(),R3.getSelectedItem().toString(),R4.getSelectedItem().toString()));
					}
			else {System.out.println("select type,area as 'area(sq. ft)',price as 'price(negotiable)',name,phno from rent where "+changeTable(R1.getSelectedItem().toString(),"Any City",R3.getSelectedItem().toString(),R4.getSelectedItem().toString()));
				rs=stmt.executeQuery("select type,area as 'area(sq. ft)',price as 'price(negotiable)',name,phno from rent where "+changeTable(R1.getSelectedItem().toString(),"Any City",R3.getSelectedItem().toString(),R4.getSelectedItem().toString()));
			
			}
			
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			model.setRowCount(0);
	        while(rs.next()) {
	        model.addRow(new Object[] {rs.getString("type"),rs.getDouble("area(sq. ft)"),rs.getDouble("price(negotiable)"),rs.getString("name"),rs.getString("phno")});
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private String changeTable(String a,String b,String c,String d) {
		
		if(b.equals("Any City"))b="";
		else b="and city='"+b+"' ";
		
		if(d.equals("Any price"))d="";
		else {
			if(d.contains("-")) {
			d=d.replace("-", " and ");
			d=" between "+d;
			}
		d="and price"+d;
			
		}
		if(c.equals("Any area")) {c="";
		if(d.length()>0 && a.equals("Any State")) d=d.substring(4);
		}
		else {
			if(c.contains("-")) {
			c=c.replace("-", " and ");
			c=" between "+c;
			}
		c="and area"+c+" ";
			
		}
		if(a.equals("Any State")) {a="";
		if(c.length()>0) c=c.substring(4);
		}
		else a="state='"+a+"' ";
		if((a+b+c+d).equals("")) return "price>0";
		return a+b+c+d;
		
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 0, 102));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(153, 102, 153));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBounds(10, 10, 1032, 55);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel L1 = new JLabel("Welcome "+Login_page.u+"!");
		L1.setForeground(new Color(255, 255, 255));
		L1.setFont(new Font("Agency FB", Font.BOLD, 40));
		L1.setBounds(10, 10, 1012, 35);
		panel.add(L1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBackground(new Color(153, 102, 153));
		panel_1.setBounds(10, 75, 1032, 102);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 248, 82);
		panel_2.setBackground(new Color(153, 102, 153));
		panel_2.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("State");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Virtual Rot", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 0, 238, 32);
		panel_2.add(lblNewLabel_1);
		
		R1 = new JComboBox();
		
		R1.setForeground(new Color(0, 0, 0));
		R1.setBackground(new Color(204, 204, 204));
		R1.setFont(new Font("Agency FB", Font.BOLD, 25));
		
		
//		R1.setModel(new DefaultComboBoxModel(new String[] {"", "Delhi", "Uttar Pradesh", "Maharashtra", "Rajasthan"}));
		R1.setBounds(0, 34, 238, 48);
		panel_2.add(R1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(265, 10, 248, 82);
		panel_2_1.setBorder(null);
		panel_2_1.setBackground(new Color(153, 102, 153));
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("city");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Virtual Rot", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(0, 0, 238, 32);
		panel_2_1.add(lblNewLabel_1_1);
		
		R2 = new JComboBox();
		if(R2.getSelectedIndex()!=-1) {
		R2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println("kjakjd");
				updateTable();
			}
		});}
		else {
			System.out.println("Hello");
		}
		
//		R2.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				try {
//				DefaultTableModel model=(DefaultTableModel)table.getModel();
//				model.setRowCount(0);
//				rs=stmt.executeQuery("select type,area as 'area(sq. ft)',price as 'price(negotiable)',emailid from rent where "+changeTable(R1.getSelectedItem().toString(),R2.getSelectedItem().toString(),R3.getSelectedItem().toString(),R4.getSelectedItem().toString()));
//		        while(rs.next()) {
//		        model.addRow(new Object[] {rs.getString("type"),rs.getDouble("area(sq. ft)"),rs.getDouble("price(negotiable)"),rs.getString("emailid")});
//		        }}
//		        catch(Exception e1) {
//		        	e1.printStackTrace();
//		        }
//			}
//		});
		R2.setForeground(Color.BLACK);
		R2.setFont(new Font("Agency FB", Font.BOLD, 25));
		R2.setBackground(new Color(204, 204, 204));
		R2.setBounds(0, 34, 238, 48);
		panel_2_1.add(R2);
		R2.setEnabled(false);
		
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(519, 10, 248, 82);
		panel_2_2.setBorder(null);
		panel_2_2.setBackground(new Color(153, 102, 153));
		panel_1.add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("area");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Virtual Rot", Font.BOLD, 30));
		lblNewLabel_1_2.setBounds(0, 0, 238, 32);
		panel_2_2.add(lblNewLabel_1_2);
		
		R3 = new JComboBox();
		R3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				updateTable();
			}
		});
		R3.setModel(new DefaultComboBoxModel(new String[] {"Any area", "<1000", "1000-1250", "1250-1500", "1500-1750", "1750-2000", ">2000"}));
		R3.setForeground(Color.BLACK);
		R3.setFont(new Font("Agency FB", Font.BOLD, 25));
		R3.setBackground(new Color(204, 204, 204));
		R3.setBounds(0, 34, 238, 48);
		panel_2_2.add(R3);
		
		JLabel lblNewLabel_1_3 = new JLabel("price");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Virtual Rot", Font.BOLD, 30));
		lblNewLabel_1_3.setBounds(784, 10, 238, 32);
		panel_1.add(lblNewLabel_1_3);
		
		R4 = new JComboBox();
		R4.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
		R4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				updateTable();
			}
		});
		R4.setModel(new DefaultComboBoxModel(new String[] {"Any price", "<10000", "10000-20000", "20000-30000", "30000-40000", ">40000"}));
		R4.setForeground(Color.BLACK);
		R4.setFont(new Font("Agency FB", Font.BOLD, 25));
		R4.setBackground(new Color(204, 204, 204));
		R4.setBounds(777, 44, 238, 48);
		panel_1.add(R4);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(10, 730, 151, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSignOut = new JButton("SIGN OUT");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_page p=new Login_page();
				p.getframe().setVisible(true);
				frame.dispose();
			}
		});
		btnSignOut.setBackground(new Color(204, 204, 204));
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnSignOut.setBounds(858, 729, 185, 29);
		frame.getContentPane().add(btnSignOut);
		frame.setBounds(100, 100, 1067, 824);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","1234");  
	        stmt = conn.createStatement();  
			rs=stmt.executeQuery("select distinct state from rent");
			R1.addItem("Any State");
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 222, 1033, 423);
			frame.getContentPane().add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setToolTipText("Select any row and click on more information to get the details");
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row=table.getSelectedRow();
					int column=table.getSelectedColumn();
					
				}
			});
			table.setFont(new Font("Tahoma", Font.BOLD, 17));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Type", "Area (sq. ft)", "Price(in rupees)", "Name", "Phno"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, Object.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				@Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			}
			
			
				
			
				);
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			
			JButton btnNewButton_1 = new JButton("More information\r\n");
			btnNewButton_1.setToolTipText("Click after selecting a row from table above");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row=table.getSelectedRow();
					int column=table.getSelectedColumn();
					if(row==-1 || column==-1)JOptionPane.showMessageDialog(null, "Please select a value from table");
					else {
						try {
						rs= stmt.executeQuery("select * from rent where phno='"+table.getValueAt(row, 4)+"'");
						System.out.println(table.getValueAt(row,0).toString()+table.getValueAt(row,1).toString()+table.getValueAt(row,2).toString()+table.getValueAt(row,3).toString());
					Frame_3_new f=new Frame_3_new();
					frame.setVisible(false);
					f.getframe().setVisible(true);
						}
						catch(Exception e1) {
							e1.printStackTrace();
						}
				}
				}});
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 27));
			btnNewButton_1.setBounds(633, 655, 316, 48);
			frame.getContentPane().add(btnNewButton_1);
			
			while(rs.next()) {
				R1.addItem(rs.getString("state"));
			}
			R1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(R1.getSelectedItem().toString().equals("Any State")) R2.setEnabled(false);
					else R2.setEnabled(true);
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","1234");  
				        stmt = conn.createStatement();
						rs=stmt.executeQuery("select distinct city from rent where state='"+R1.getSelectedItem()+"'");
						R2.removeAllItems();
						R2.addItem("Any City");
						while(rs.next())R2.addItem(rs.getString("city"));
						updateTable();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","1234");  
	        stmt = conn.createStatement();
	        rs=stmt.executeQuery("select type,area as 'area(sq. ft)',price as 'price(negotiable)',name,phno from rent");
	        DefaultTableModel model=(DefaultTableModel)table.getModel();
	        model.setRowCount(0);
	        while(rs.next()) {
	        model.addRow(new Object[] {rs.getString("type"),rs.getDouble("area(sq. ft)"),rs.getDouble("price(negotiable)"),rs.getString("name"),rs.getString("phno")});
	        }
	        
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
        
	}
}

