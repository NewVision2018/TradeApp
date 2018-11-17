package tradingapp6;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class TradeDataAccess extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradeDataAccess frame = new TradeDataAccess();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	Connection con = null;
	private JTextField textFieldForSNo;
	private JTextField textFieldForDescription;
	private JTextField textFieldForRate;
	private JComboBox<String> comboBoxDropDown;
	private JTextField textFieldSearch;
	private JComboBox<String> comboBoxSelection;
	private JTextField textFieldGst;
	private JTextField textFieldForPayment;
	private JTextField textFieldForDiscount;
	
	private JComboBox<String> comboBoxForPayment;
	
	public void refreshTable(){
		
		try{
			
			String query = "SELECT S_NO, DESCRIPTION, RATE FROM Products";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			rs.close();
			pst.close();
			
		}catch(Exception e1){
			
			e1.printStackTrace();
			
		}
		
	}
	
	public void fillComboBox(){
		
		try{
			
			String query = "SELECT * FROM Products";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			comboBoxDropDown.addItem("--SELECT--");
			
			while(rs.next()){
				
				comboBoxDropDown.addItem(rs.getString("DESCRIPTION"));
				
			}
			
			rs.close();
			pst.close();
			
		}catch(Exception e1){
			
			e1.printStackTrace();
			
		}
		
	}
	
	public void fillComboBoxForPayment(){
		
		comboBoxForPayment.removeAllItems();
		
		try{
			
			String query = "SELECT * FROM PaymentGateway";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			comboBoxForPayment.addItem("--SELECT--");
			
			while(rs.next()){
				
				comboBoxForPayment.addItem(rs.getString("PAYMENTMETHOD"));
				
			}
			
			rs.close();
			pst.close();
			
		}catch(Exception e1){
			
			e1.printStackTrace();
			
		}
		
	}
	
	public void fillGst(){
		
		try{
			
			String query = "SELECT * FROM Manipulations";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				
				textFieldGst.setText(rs.getString("GST"));
				
			}
			
			rs.close();
			pst.close();
			
		}catch(Exception e1){
			
			e1.printStackTrace();
			
		}
		
	}
	
	public void fillDiscount(){
		
		try{
			
			String query = "SELECT * FROM Manipulations";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				
				textFieldForDiscount.setText(rs.getString("DISCOUNT"));
				
			}
			
			rs.close();
			pst.close();
			
		}catch(Exception e1){
			
			e1.printStackTrace();
			
		}
		
	}
	
	public TradeDataAccess() {
		setTitle("Items Management");
		con = SQLiteConnection.sqliteDbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(658, 124, 651, 485);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(204, 255, 204));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
					
					int row = table.getSelectedRow();
					
					String S_NO_ = (table.getModel().getValueAt(row, 0)).toString();
					
					String query = "SELECT * FROM Products WHERE S_NO='"+S_NO_+"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						
						textFieldForSNo.setText(rs.getString("S_NO"));
						textFieldForDescription.setText(rs.getString("DESCRIPTION"));
						textFieldForRate.setText(rs.getString("RATE"));
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblSNo = new JLabel("S.NO :");
		lblSNo.setBounds(28, 129, 59, 14);
		lblSNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblSNo);
		
		JLabel lblDescription = new JLabel("DESCRIPTION :");
		lblDescription.setBounds(28, 183, 120, 14);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblDescription);
		
		JLabel lblRate = new JLabel("RATE :");
		lblRate.setBounds(28, 239, 59, 14);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblRate);
		
		textFieldForSNo = new JTextField();
		textFieldForSNo.setBounds(166, 126, 156, 20);
		textFieldForSNo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(textFieldForSNo);
		textFieldForSNo.setColumns(10);
		
		textFieldForDescription = new JTextField();
		textFieldForDescription.setBounds(166, 180, 156, 20);
		textFieldForDescription.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(textFieldForDescription);
		textFieldForDescription.setColumns(10);
		
		textFieldForRate = new JTextField();
		textFieldForRate.setBounds(166, 236, 156, 20);
		textFieldForRate.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(textFieldForRate);
		textFieldForRate.setColumns(10);
		
		JLabel lblGst = new JLabel("GST:");
		lblGst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGst.setBounds(28, 656, 59, 14);
		contentPane.add(lblGst);
		
		textFieldGst = new JTextField();
		textFieldGst.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldGst.setBounds(166, 655, 156, 20);
		contentPane.add(textFieldGst);
		textFieldGst.setColumns(10);
		
		JButton btnAddGst = new JButton("UPDATE");
		btnAddGst.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddGst.setBounds(424, 652, 110, 23);
		btnAddGst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "UPDATE Manipulations SET GST='"+textFieldGst.getText()+"' WHERE SNO='"+"1"+"'";
					
					PreparedStatement pst = con.prepareStatement(query);
									
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Gst Value Updated");
					
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		contentPane.add(btnAddGst);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(424, 125, 110, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "INSERT INTO Products(S_NO, DESCRIPTION, HSN, RATE, GST) VALUES (?, ?, 12345, ?, 0)";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, textFieldForSNo.getText());
					pst.setString(2, textFieldForDescription.getText());
					pst.setString(3, textFieldForRate.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Product Data Added");
					
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
				refreshTable();
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(424, 179, 110, 23);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "UPDATE Products SET S_NO='"+textFieldForSNo.getText()+"', DESCRIPTION='"+textFieldForDescription.getText()+"', RATE='"+textFieldForRate.getText()+"' WHERE S_NO='"+textFieldForSNo.getText()+"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Product Data Updated");
					
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
				refreshTable();
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(424, 235, 110, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "DELETE FROM Products WHERE S_NO='"+textFieldForSNo.getText()+"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Product Data Deleted");
					
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
				refreshTable();
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnDelete);
		
		comboBoxDropDown = new JComboBox<String>();
		comboBoxDropDown.setBounds(213, 36, 156, 23);
		comboBoxDropDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String query = "SELECT * FROM Products WHERE DESCRIPTION=?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, (String)comboBoxDropDown.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						
						textFieldForSNo.setText(rs.getString("S_NO"));
						textFieldForDescription.setText(rs.getString("DESCRIPTION"));
						textFieldForRate.setText(rs.getString("RATE"));
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		comboBoxDropDown.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(comboBoxDropDown);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try{
					
					String selection = (String)comboBoxSelection.getSelectedItem();
					
					String query = "SELECT S_NO, DESCRIPTION, RATE FROM Products WHERE "+selection+" LIKE '"+textFieldSearch.getText()+"%'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
				//	pst.setString(1, textFieldSearch.getText());
					
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		textFieldSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldSearch.setBounds(1128, 37, 181, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		comboBoxSelection = new JComboBox<String>();
		comboBoxSelection.setModel(new DefaultComboBoxModel<String>(new String[] {"S_NO", "DESCRIPTION", "RATE"}));
		comboBoxSelection.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxSelection.setBounds(658, 37, 169, 20);
		contentPane.add(comboBoxSelection);
		
		JButton btnGstCalculation = new JButton("GST CALCULATION");
		btnGstCalculation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*TradeGstBill tgb = new TradeGstBill();
				
				tgb.setVisible(true);
				
				dispose();*/
				
				JOptionPane.showMessageDialog(null, "GST CALCULATION : Please Run Bill/Receipt Generating Application, Thank You!");
				
			}
		});
		btnGstCalculation.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGstCalculation.setBounds(1036, 652, 181, 23);
		contentPane.add(btnGstCalculation);
		
		JLabel lblPayment = new JLabel("PAYMENT :");
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPayment.setBounds(28, 353, 83, 14);
		contentPane.add(lblPayment);
		
		textFieldForPayment = new JTextField();
		textFieldForPayment.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForPayment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldForPayment.setColumns(10);
		textFieldForPayment.setBounds(166, 350, 156, 20);
		contentPane.add(textFieldForPayment);
		
		JButton buttonForAddPayment = new JButton("ADD");
		buttonForAddPayment.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonForAddPayment.setBounds(424, 349, 110, 23);
		buttonForAddPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "INSERT INTO PaymentGateway(SNO,PAYMENTMETHOD) VALUES (?,?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(2, textFieldForPayment.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Payment Method Data Added");
					
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
				refreshTable();
				fillComboBoxForPayment();
				
			}
		});
		contentPane.add(buttonForAddPayment);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 296, 521, 2);
		contentPane.add(separator);
		
		comboBoxForPayment = new JComboBox<String>();
		comboBoxForPayment.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxForPayment.setBounds(166, 401, 156, 23);
		contentPane.add(comboBoxForPayment);
		
		JButton buttonForPaymentDelete = new JButton("DELETE");
		buttonForPaymentDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonForPaymentDelete.setBounds(424, 401, 110, 23);
		buttonForPaymentDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "DELETE FROM PaymentGateway WHERE PAYMENTMETHOD='"+(String)comboBoxForPayment.getSelectedItem()+"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Payment Method Data Deleted");
					
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
				refreshTable();
				fillComboBoxForPayment();
				
			}
		});
		contentPane.add(buttonForPaymentDelete);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 474, 513, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(28, 596, 513, 2);
		contentPane.add(separator_2);
		
		JLabel labelDiscount = new JLabel("DISCOUNT :");
		labelDiscount.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelDiscount.setBounds(28, 529, 104, 14);
		contentPane.add(labelDiscount);
		
		textFieldForDiscount = new JTextField();
		textFieldForDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForDiscount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldForDiscount.setColumns(10);
		textFieldForDiscount.setBounds(166, 528, 156, 20);
		contentPane.add(textFieldForDiscount);
		
		JButton buttonForDiscount = new JButton("UPDATE");
		buttonForDiscount.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonForDiscount.setBounds(424, 525, 110, 23);
		buttonForDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "UPDATE Manipulations SET DISCOUNT='"+textFieldForDiscount.getText()+"' WHERE SNO='"+"1"+"'";
					
					PreparedStatement pst = con.prepareStatement(query);
									
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Discount Value Updated");
					
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		contentPane.add(buttonForDiscount);
		
		refreshTable();
		fillComboBox();
		fillDiscount();
		fillGst();
		
		fillComboBoxForPayment();
		
	}
}
