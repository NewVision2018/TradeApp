package tradingapp1;

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
	private JTextField textFieldForHsn;
	private JTextField textFieldForRate;
	private JTextField textFieldForGst;
	private JComboBox<String> comboBoxDropDown;
	private JTextField textFieldSearch;
	private JComboBox<String> comboBoxSelection;
	
	public void refreshTable(){
		
		try{
			
			String query = "SELECT S_NO, DESCRIPTION, HSN, RATE, GST FROM Products";
			
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
	
	public TradeDataAccess() {
		setTitle("Items Management");
		con = SQLiteConnection.sqliteDbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(185, 110, 1000, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 92, 651, 358);
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
						textFieldForHsn.setText(rs.getString("HSN"));
						textFieldForRate.setText(rs.getString("RATE"));
						textFieldForGst.setText(rs.getString("GST"));
						
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
		lblSNo.setBounds(10, 91, 59, 14);
		lblSNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblSNo);
		
		JLabel lblDescription = new JLabel("DESCRIPTION :");
		lblDescription.setBounds(10, 129, 120, 14);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblDescription);
		
		JLabel lblHsn = new JLabel("HSN :");
		lblHsn.setBounds(10, 166, 46, 14);
		lblHsn.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblHsn);
		
		JLabel lblRate = new JLabel("RATE :");
		lblRate.setBounds(10, 202, 59, 14);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblRate);
		
		JLabel lblGst = new JLabel("GST :");
		lblGst.setBounds(10, 238, 46, 14);
		lblGst.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblGst);
		
		textFieldForSNo = new JTextField();
		textFieldForSNo.setBounds(136, 90, 156, 20);
		textFieldForSNo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(textFieldForSNo);
		textFieldForSNo.setColumns(10);
		
		textFieldForDescription = new JTextField();
		textFieldForDescription.setBounds(136, 128, 156, 20);
		textFieldForDescription.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(textFieldForDescription);
		textFieldForDescription.setColumns(10);
		
		textFieldForHsn = new JTextField();
		textFieldForHsn.setBounds(136, 165, 156, 20);
		textFieldForHsn.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(textFieldForHsn);
		textFieldForHsn.setColumns(10);
		
		textFieldForRate = new JTextField();
		textFieldForRate.setBounds(136, 201, 156, 20);
		textFieldForRate.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(textFieldForRate);
		textFieldForRate.setColumns(10);
		
		textFieldForGst = new JTextField();
		textFieldForGst.setBounds(136, 237, 156, 20);
		textFieldForGst.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForGst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(textFieldForGst);
		textFieldForGst.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(95, 298, 110, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "INSERT INTO Products(S_NO, DESCRIPTION, HSN, RATE, GST) VALUES (?, ?, ?, ?, ?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, textFieldForSNo.getText());
					pst.setString(2, textFieldForDescription.getText());
					pst.setString(3, textFieldForHsn.getText());
					pst.setString(4, textFieldForRate.getText());
					pst.setString(5, textFieldForGst.getText());
					
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
		btnUpdate.setBounds(95, 348, 110, 23);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "UPDATE Products SET S_NO='"+textFieldForSNo.getText()+"', DESCRIPTION='"+textFieldForDescription.getText()+"', HSN='"+textFieldForHsn.getText()+"', RATE='"+textFieldForRate.getText()+"', GST='"+textFieldForGst.getText()+"' WHERE S_NO='"+textFieldForSNo.getText()+"'";
					
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
		btnDelete.setBounds(95, 394, 110, 23);
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
		comboBoxDropDown.setBounds(49, 24, 156, 23);
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
						textFieldForHsn.setText(rs.getString("HSN"));
						textFieldForRate.setText(rs.getString("RATE"));
						textFieldForGst.setText(rs.getString("GST"));
						
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
					
					String query = "SELECT S_NO, DESCRIPTION, HSN, RATE, GST FROM Products WHERE "+selection+" LIKE '"+textFieldSearch.getText()+"%'";
					
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
		textFieldSearch.setBounds(740, 25, 181, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		comboBoxSelection = new JComboBox<String>();
		comboBoxSelection.setModel(new DefaultComboBoxModel<String>(new String[] {"S_NO", "DESCRIPTION", "HSN", "RATE", "GST"}));
		comboBoxSelection.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxSelection.setBounds(371, 25, 169, 20);
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
		btnGstCalculation.setBounds(740, 461, 181, 23);
		contentPane.add(btnGstCalculation);
		
		refreshTable();
		fillComboBox();
		
	}
}
