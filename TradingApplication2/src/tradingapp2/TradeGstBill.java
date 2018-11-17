package tradingapp2;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

public class TradeGstBill extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradeGstBill frame = new TradeGstBill();
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
	 JComboBox<String> comboBox1;
	 JComboBox<String> comboBox2;
	 JComboBox<String> comboBox3;
	 JComboBox<String> comboBox4;
	 JComboBox<String> comboBox5;
	 JComboBox<String> comboBox6;
	 JComboBox<String> comboBox7;
	 JComboBox<String> comboBox8;
	 JComboBox<String> comboBox9;
	 JComboBox<String> comboBox10;
	 JLabel lblQty;
	 JLabel lblRate;
	 JLabel lblValue;
	 JTextField textFieldForQty1;
	 JTextField textFieldForQty2;
	 JTextField textFieldForQty3;
	 JTextField textFieldForQty4;
	 JTextField textFieldForQty5;
	 JTextField textFieldForQty6;
	 JTextField textFieldForQty7;
	 JTextField textFieldForQty8;
	 JTextField textFieldForQty9;
	 JTextField textFieldForQty10;
	 JTextField textFieldForRate1;
	 JTextField textFieldForRate2;
	 JTextField textFieldForRate3;
	 JTextField textFieldForRate4;
	 JTextField textFieldForRate5;
	 JTextField textFieldForRate6;
	 JTextField textFieldForRate7;
	 JTextField textFieldForRate8;
	 JTextField textFieldForRate9;
	 JTextField textFieldForRate10;
	 JTextField textFieldForValue1;
	 JTextField textFieldForValue2;
	 JTextField textFieldForValue3;
	 JTextField textFieldForValue4;
	 JTextField textFieldForValue5;
	 JTextField textFieldForValue6;
	 JTextField textFieldForValue7;
	 JTextField textFieldForValue8;
	 JTextField textFieldForValue9;
	 JTextField textFieldForValue10;
	 JTextField textFieldTo;
	 JTextArea textAreaAddress;
	 JLabel lblGstin;
	 JTextField textFieldGstin;
	 JTextField textFieldSubTotal;
	 JTextField textFieldTotalQty;
	 JLabel lblSubTotal;
	 JLabel lblTotalQty;
	 JTextField textFieldGrandTotal;
	 JLabel lblGrandTotal;
	 JLabel lblBillNo;
	 JTextField textFieldBillNo;
	 JLabel lblNewLabel;
	 JTextField textFieldDate;
	 JLabel lblNumberToWord;
	 JLabel lblForTraders;
	 
	 JTextField textFieldForSearch1;
	 JTextField textFieldForSearch2;
	 JTextField textFieldForSearch3;
	 JTextField textFieldForSearch4;
	 JTextField textFieldForSearch5;
	 JTextField textFieldForSearch6;
	 JTextField textFieldForSearch7;
	 JTextField textFieldForSearch8;
	 JTextField textFieldForSearch9;
	 JTextField textFieldForSearch10;
	 
	 JTextField textFieldForMrp1;
	 JTextField textFieldForMrp2;
	 JTextField textFieldForMrp3;
	 JTextField textFieldForMrp4;
	 JTextField textFieldForMrp5;
	 JTextField textFieldForMrp6;
	 JTextField textFieldForMrp7;
	 JTextField textFieldForMrp8;
	 JTextField textFieldForMrp9;
	 JTextField textFieldForMrp10;
	 
	 JLabel lblCompanyName;
//	 JLabel lblCompanyAddress;
//	 JLabel lblCompanyGstin;
	
	public void resetData(){
		
		comboBox1.removeAllItems();
		comboBox2.removeAllItems();
		comboBox3.removeAllItems();
		comboBox4.removeAllItems();
		comboBox5.removeAllItems();
		comboBox6.removeAllItems();
		comboBox7.removeAllItems();
		comboBox8.removeAllItems();
		comboBox9.removeAllItems();
		comboBox10.removeAllItems();
		
		textFieldForQty1.setText("0");
		textFieldForQty2.setText("0");
		textFieldForQty3.setText("0");
		textFieldForQty4.setText("0");
		textFieldForQty5.setText("0");
		textFieldForQty6.setText("0");
		textFieldForQty7.setText("0");
		textFieldForQty8.setText("0");
		textFieldForQty9.setText("0");
		textFieldForQty10.setText("0");
		
		textFieldForRate1.setText("0");
		textFieldForRate2.setText("0");
		textFieldForRate3.setText("0");
		textFieldForRate4.setText("0");
		textFieldForRate5.setText("0");
		textFieldForRate6.setText("0");
		textFieldForRate7.setText("0");
		textFieldForRate8.setText("0");
		textFieldForRate9.setText("0");
		textFieldForRate10.setText("0");
		
		textFieldForMrp1.setText("0");
		textFieldForMrp2.setText("0");
		textFieldForMrp3.setText("0");
		textFieldForMrp4.setText("0");
		textFieldForMrp5.setText("0");
		textFieldForMrp6.setText("0");
		textFieldForMrp7.setText("0");
		textFieldForMrp8.setText("0");
		textFieldForMrp9.setText("0");
		textFieldForMrp10.setText("0");
		
		textFieldForValue1.setText("0");
		textFieldForValue2.setText("0");
		textFieldForValue3.setText("0");
		textFieldForValue4.setText("0");
		textFieldForValue5.setText("0");
		textFieldForValue6.setText("0");
		textFieldForValue7.setText("0");
		textFieldForValue8.setText("0");
		textFieldForValue9.setText("0");
		textFieldForValue10.setText("0");
		
		textFieldTo.setText("");
		textAreaAddress.setText("");
		textFieldGstin.setText("");
		
		textFieldSubTotal.setText("0");
		textFieldTotalQty.setText("0");
		textFieldGrandTotal.setText("0");
		
		textFieldBillNo.setText("");
		textFieldDate.setText("");
		
		textFieldForSearch1.setText("");
		textFieldForSearch2.setText("");
		textFieldForSearch3.setText("");
		textFieldForSearch4.setText("");
		textFieldForSearch5.setText("");
		textFieldForSearch6.setText("");
		textFieldForSearch7.setText("");
		textFieldForSearch8.setText("");
		textFieldForSearch9.setText("");
		textFieldForSearch10.setText("");
		
	}
	
	public Integer totalQuantity(){
		
		Integer totalQuantity = 0; 
		
		Integer qty1 = Integer.parseInt((textFieldForQty1.getText()).toString());
		Integer qty2 = Integer.parseInt((textFieldForQty2.getText()).toString());
		Integer qty3 = Integer.parseInt((textFieldForQty3.getText()).toString());
		Integer qty4 = Integer.parseInt((textFieldForQty4.getText()).toString());
		Integer qty5 = Integer.parseInt((textFieldForQty5.getText()).toString());
		Integer qty6 = Integer.parseInt((textFieldForQty6.getText()).toString());
		Integer qty7 = Integer.parseInt((textFieldForQty7.getText()).toString());
		Integer qty8 = Integer.parseInt((textFieldForQty8.getText()).toString());
		Integer qty9 = Integer.parseInt((textFieldForQty9.getText()).toString());
		Integer qty10 = Integer.parseInt((textFieldForQty10.getText()).toString());
		
		totalQuantity = (qty1 + qty2 +qty3 + qty4 + qty5 + qty6 + qty7 + qty8 + qty9 + qty10);
		
		return totalQuantity;
		
	}
	
	public Double totalValue(){
		
		Double totalValue = 0.0;
		
		Double value1 = Double.parseDouble((textFieldForValue1.getText()).toString());
		Double value2 = Double.parseDouble((textFieldForValue2.getText()).toString());
		Double value3 = Double.parseDouble((textFieldForValue3.getText()).toString());
		Double value4 = Double.parseDouble((textFieldForValue4.getText()).toString());
		Double value5 = Double.parseDouble((textFieldForValue5.getText()).toString());
		Double value6 = Double.parseDouble((textFieldForValue6.getText()).toString());
		Double value7 = Double.parseDouble((textFieldForValue7.getText()).toString());
		Double value8 = Double.parseDouble((textFieldForValue8.getText()).toString());
		Double value9 = Double.parseDouble((textFieldForValue9.getText()).toString());
		Double value10 = Double.parseDouble((textFieldForValue10.getText()).toString());
		
		totalValue = (value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9 + value10);
		
		return totalValue;
		
	}
	
	public void getCompanyDetails(){
		
		try{
			
			String companyName = null;
			//String companyAddress = null;
			//String companyGstin = null;
		
			String query = "SELECT * FROM Company";
		
			PreparedStatement pst = con.prepareStatement(query);
		
			ResultSet rs = pst.executeQuery();
		
			while(rs.next()){
			
				companyName = rs.getString("COMPANY_NAME");
				//companyAddress = rs.getString("COMPANY_ADDRESS");
				//companyGstin = rs.getString("COMPANY_GSTIN");
				
				lblCompanyName.setText(companyName);
				//lblCompanyAddress.setText(companyAddress);
				//lblCompanyGstin.setText(companyGstin);
				
				lblForTraders.setText(companyName);
			
				}
			
			rs.close();
		    pst.close();
		
			}
			catch(Exception e){
			
				JOptionPane.showMessageDialog(null, e);
			
			}
		
	}
	
	public void getCurrentDate(){
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar c = Calendar.getInstance();
		
		String date = (df.format(c.getTime())).toString();
		
		textFieldDate.setText(date);
		
	}
	
	public void getBillNo(){
		
		try{
			
			String query = "SELECT COUNT (*) FROM Users";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				
				int billNo = rs.getInt(1);
				
				billNo = billNo + 1;
				
				String billNum = Integer.toString(billNo);
				
				textFieldBillNo.setText(billNum);
				
			}
			
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
		}
		
	}
	
	public TradeGstBill() {
		setTitle("TAX INVOICE CASH/CREDIT");
		con = SQLiteConnection.sqliteDbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 15, 790, 732);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(new Color(0, 0, 0));
		separator1.setBounds(10, 143, 769, 2);
		contentPane.add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBackground(new Color(0, 0, 0));
		separator2.setBounds(10, 507, 769, 2);
		contentPane.add(separator2);
		
		JSeparator separator3 = new JSeparator();
		separator3.setBackground(new Color(0, 0, 0));
		separator3.setOrientation(SwingConstants.VERTICAL);
		separator3.setBounds(301, 11, 2, 127);
		contentPane.add(separator3);
		
		comboBox1 = new JComboBox<String>();
		comboBox1.addItem("     -");
		comboBox1.setBackground(Color.WHITE);
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "SELECT * FROM Products WHERE DESCRIPTION=?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, (String)comboBox1.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
					
						textFieldForRate1.setText(rs.getString("RATE"));
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		comboBox1.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox1.setBounds(10, 197, 135, 20);
		contentPane.add(comboBox1);
		
		comboBox2 = new JComboBox<String>();
		comboBox2.addItem("     -");
		comboBox2.setBackground(Color.WHITE);
		comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "SELECT * FROM Products WHERE DESCRIPTION=?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, (String)comboBox2.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						
						textFieldForRate2.setText(rs.getString("RATE"));
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		comboBox2.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox2.setBounds(10, 228, 135, 20);
		contentPane.add(comboBox2);
		
		comboBox3 = new JComboBox<String>();
		comboBox3.addItem("     -");
		comboBox3.setBackground(Color.WHITE);
		comboBox3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "SELECT * FROM Products WHERE DESCRIPTION=?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, (String)comboBox3.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						
						textFieldForRate3.setText(rs.getString("RATE"));
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		comboBox3.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox3.setBounds(10, 259, 135, 20);
		contentPane.add(comboBox3);
		
		comboBox4 = new JComboBox<String>();
		comboBox4.addItem("     -");
		comboBox4.setBackground(Color.WHITE);
		comboBox4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "SELECT * FROM Products WHERE DESCRIPTION=?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, (String)comboBox4.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						
						textFieldForRate4.setText(rs.getString("RATE"));
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		comboBox4.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox4.setBounds(10, 290, 135, 20);
		contentPane.add(comboBox4);
		
		comboBox5 = new JComboBox<String>();
		comboBox5.addItem("     -");
		comboBox5.setBackground(Color.WHITE);
		comboBox5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "SELECT * FROM Products WHERE DESCRIPTION=?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, (String)comboBox5.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						
						textFieldForRate5.setText(rs.getString("RATE"));
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		comboBox5.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox5.setBounds(10, 321, 135, 20);
		contentPane.add(comboBox5);
		
		comboBox6 = new JComboBox<String>();
		comboBox6.addItem("     -");
		comboBox6.setBackground(Color.WHITE);
		comboBox6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "SELECT * FROM Products WHERE DESCRIPTION=?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, (String)comboBox6.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){

						textFieldForRate6.setText(rs.getString("RATE"));
					
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		comboBox6.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox6.setBounds(10, 352, 135, 20);
		contentPane.add(comboBox6);
		
		comboBox7 = new JComboBox<String>();
		comboBox7.addItem("     -");
		comboBox7.setBackground(Color.WHITE);
		comboBox7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "SELECT * FROM Products WHERE DESCRIPTION=?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, (String)comboBox7.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						
						textFieldForRate7.setText(rs.getString("RATE"));
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		comboBox7.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox7.setBounds(10, 383, 135, 20);
		contentPane.add(comboBox7);
		
		comboBox8 = new JComboBox<String>();
		comboBox8.addItem("     -");
		comboBox8.setBackground(Color.WHITE);
		comboBox8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "SELECT * FROM Products WHERE DESCRIPTION=?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, (String)comboBox8.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						
						textFieldForRate8.setText(rs.getString("RATE"));
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		comboBox8.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox8.setBounds(10, 414, 135, 20);
		contentPane.add(comboBox8);
		
		comboBox9 = new JComboBox<String>();
		comboBox9.addItem("     -");
		comboBox9.setBackground(Color.WHITE);
		comboBox9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "SELECT * FROM Products WHERE DESCRIPTION=?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, (String)comboBox9.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){

						textFieldForRate9.setText(rs.getString("RATE"));
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		comboBox9.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox9.setBounds(10, 445, 135, 20);
		contentPane.add(comboBox9);
		
		comboBox10 = new JComboBox<String>();
		comboBox10.addItem("     -");
		comboBox10.setBackground(Color.WHITE);
		comboBox10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String query = "SELECT * FROM Products WHERE DESCRIPTION=?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, (String)comboBox10.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						
						textFieldForRate10.setText(rs.getString("RATE"));
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		comboBox10.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox10.setBounds(10, 476, 135, 20);
		contentPane.add(comboBox10);
		
		JLabel lblDescription = new JLabel("PRODUCTS");
		lblDescription.setBackground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(10, 156, 135, 14);
		contentPane.add(lblDescription);
		
		lblQty = new JLabel("QTY");
		lblQty.setHorizontalAlignment(SwingConstants.CENTER);
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQty.setBackground(Color.WHITE);
		lblQty.setBounds(194, 156, 119, 14);
		contentPane.add(lblQty);
		
		lblRate = new JLabel("RATE");
		lblRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRate.setBackground(Color.WHITE);
		lblRate.setBounds(435, 156, 119, 14);
		contentPane.add(lblRate);
		
		lblValue = new JLabel("VALUE");
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValue.setBackground(Color.WHITE);
		lblValue.setBounds(564, 156, 110, 14);
		contentPane.add(lblValue);
		
		textFieldForQty1 = new JTextField();
		textFieldForQty1.setBackground(Color.WHITE);
		textFieldForQty1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForQty1.setText("0");
		textFieldForQty1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String qty1 = textFieldForQty1.getText();
				String rate1 = textFieldForRate1.getText();
				
				Double qty_1 = Double.parseDouble(qty1);
				Double rate_1 = Double.parseDouble(rate1);
				
				Double mulQtyRate1 = (qty_1*rate_1);  
				
				String value1 = String.format("%.2f", mulQtyRate1);
				
				textFieldForValue1.setText(value1);
				
				Integer totalQty = (Integer)totalQuantity();
				
				String totalQuantity = String.valueOf(totalQty);
				
				textFieldTotalQty.setText(totalQuantity);
				
				Double totalVal = (Double)totalValue();
				
				String totalValue = String.format("%.2f", totalVal);
				
				textFieldSubTotal.setText(totalValue);
				
				textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
				
				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
				
				Long numberToWord_ = (new Double(numToWord_).longValue());
				
				String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
				
				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
				
			}
		});
		textFieldForQty1.setBounds(217, 197, 86, 20);
		contentPane.add(textFieldForQty1);
		textFieldForQty1.setColumns(10);
		
		textFieldForQty2 = new JTextField();
		textFieldForQty2.setBackground(Color.WHITE);
		textFieldForQty2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForQty2.setText("0");
		textFieldForQty2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String qty2 = textFieldForQty2.getText();
				String rate2 = textFieldForRate2.getText();
				
				Double qty_2 = Double.parseDouble(qty2);
				Double rate_2 = Double.parseDouble(rate2);
				
				Double mulQtyRate2 = (qty_2*rate_2);
				
				String value2 = String.format("%.2f", mulQtyRate2);
				
				textFieldForValue2.setText(value2);
				
				Integer totalQty = (Integer)totalQuantity();
				
				String totalQuantity = String.valueOf(totalQty);
				
				textFieldTotalQty.setText(totalQuantity);
				
				Double totalVal = (Double)totalValue();
				
				String totalValue = String.format("%.2f", totalVal);
				
				textFieldSubTotal.setText(totalValue);
				
				textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
				
				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
				
				Long numberToWord_ = (new Double(numToWord_).longValue());
				
				String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
				
				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
				
			}
		});
		textFieldForQty2.setColumns(10);
		textFieldForQty2.setBounds(217, 228, 86, 20);
		contentPane.add(textFieldForQty2);
		
		textFieldForQty3 = new JTextField();
		textFieldForQty3.setBackground(Color.WHITE);
		textFieldForQty3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForQty3.setText("0");
		textFieldForQty3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String qty3 = textFieldForQty3.getText();
				String rate3 = textFieldForRate3.getText();
				
				Double qty_3 = Double.parseDouble(qty3);
				Double rate_3 = Double.parseDouble(rate3);
				
				Double mulQtyRate3 = (qty_3*rate_3);
				
				String value3 = String.format("%.2f", mulQtyRate3);
				
				textFieldForValue3.setText(value3);
				
				Integer totalQty = (Integer)totalQuantity();
				
				String totalQuantity = String.valueOf(totalQty);
				
				textFieldTotalQty.setText(totalQuantity);
				
				Double totalVal = (Double)totalValue();
				
				String totalValue = String.format("%.2f", totalVal);
				
				textFieldSubTotal.setText(totalValue);
				
				textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
				
				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
				
				Long numberToWord_ = (new Double(numToWord_).longValue());
				
				String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
				
				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
				
			}
		});
		textFieldForQty3.setColumns(10);
		textFieldForQty3.setBounds(217, 259, 86, 20);
		contentPane.add(textFieldForQty3);
		
		textFieldForQty4 = new JTextField();
		textFieldForQty4.setBackground(Color.WHITE);
		textFieldForQty4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForQty4.setText("0");
		textFieldForQty4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String qty4 = textFieldForQty4.getText();
				String rate4 = textFieldForRate4.getText();
				
				Double qty_4 = Double.parseDouble(qty4);
				Double rate_4 = Double.parseDouble(rate4);
				
				Double mulQtyRate4 = (qty_4*rate_4);
				
				String value4 = String.format("%.2f", mulQtyRate4);
				
				textFieldForValue4.setText(value4);
				
				Integer totalQty = (Integer)totalQuantity();
				
				String totalQuantity = String.valueOf(totalQty);
				
				textFieldTotalQty.setText(totalQuantity);
				
				Double totalVal = (Double)totalValue();
				
				String totalValue = String.format("%.2f", totalVal);
				
				textFieldSubTotal.setText(totalValue);
				
				textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
				
				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
				
				Long numberToWord_ = (new Double(numToWord_).longValue());
				
				String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
				
				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
				
			}
		});
		textFieldForQty4.setColumns(10);
		textFieldForQty4.setBounds(217, 290, 86, 20);
		contentPane.add(textFieldForQty4);
		
		textFieldForQty5 = new JTextField();
		textFieldForQty5.setBackground(Color.WHITE);
		textFieldForQty5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForQty5.setText("0");
		textFieldForQty5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String qty5 = textFieldForQty5.getText();
				String rate5 = textFieldForRate5.getText();
				
				Double qty_5 = Double.parseDouble(qty5);
				Double rate_5 = Double.parseDouble(rate5);
				
				Double mulQtyRate5 = (qty_5*rate_5);
				
				String value5 = String.format("%.2f", mulQtyRate5);
				
				textFieldForValue5.setText(value5);
				
				Integer totalQty = (Integer)totalQuantity();
				
				String totalQuantity = String.valueOf(totalQty);
				
				textFieldTotalQty.setText(totalQuantity);
				
				Double totalVal = (Double)totalValue();
				
				String totalValue = String.format("%.2f", totalVal);
				
				textFieldSubTotal.setText(totalValue);
				
				textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
				
				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
				
				Long numberToWord_ = (new Double(numToWord_).longValue());
				
				String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
				
				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
					
			}
		});
		textFieldForQty5.setColumns(10);
		textFieldForQty5.setBounds(217, 321, 86, 20);
		contentPane.add(textFieldForQty5);
		
		textFieldForQty6 = new JTextField();
		textFieldForQty6.setBackground(Color.WHITE);
		textFieldForQty6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForQty6.setText("0");
		textFieldForQty6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String qty6 = textFieldForQty6.getText();
				String rate6 = textFieldForRate6.getText();
				
				Double qty_6 = Double.parseDouble(qty6);
				Double rate_6 = Double.parseDouble(rate6);
				
				Double mulQtyRate6 = (qty_6*rate_6);
				
				String value6 = String.format("%.2f", mulQtyRate6);
				
				textFieldForValue6.setText(value6);
				
				Integer totalQty = (Integer)totalQuantity();
				
				String totalQuantity = String.valueOf(totalQty);
				
				textFieldTotalQty.setText(totalQuantity);
				
				Double totalVal = (Double)totalValue();
				
				String totalValue = String.format("%.2f", totalVal);
				
				textFieldSubTotal.setText(totalValue);
				
				textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
				
				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
				
				Long numberToWord_ = (new Double(numToWord_).longValue());
				
				String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
				
				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
				
			}
		});
		textFieldForQty6.setColumns(10);
		textFieldForQty6.setBounds(217, 352, 86, 20);
		contentPane.add(textFieldForQty6);
		
		textFieldForQty7 = new JTextField();
		textFieldForQty7.setBackground(Color.WHITE);
		textFieldForQty7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForQty7.setText("0");
		textFieldForQty7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String qty7 = textFieldForQty7.getText();
				String rate7 = textFieldForRate7.getText();
				
				Double qty_7 = Double.parseDouble(qty7);
				Double rate_7 = Double.parseDouble(rate7);
				
				Double mulQtyRate7 = (qty_7*rate_7);
				
				String value7 = String.format("%.2f", mulQtyRate7);
				
				textFieldForValue7.setText(value7);
				
				Integer totalQty = (Integer)totalQuantity();
				
				String totalQuantity = String.valueOf(totalQty);
				
				textFieldTotalQty.setText(totalQuantity);
				
				Double totalVal = (Double)totalValue();
				
				String totalValue = String.format("%.2f", totalVal);
				
				textFieldSubTotal.setText(totalValue);
				
				textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
				
				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
				
				Long numberToWord_ = (new Double(numToWord_).longValue());
				
				String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
				
				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
				
			}
		});
		textFieldForQty7.setColumns(10);
		textFieldForQty7.setBounds(217, 383, 86, 20);
		contentPane.add(textFieldForQty7);
		
		textFieldForQty8 = new JTextField();
		textFieldForQty8.setBackground(Color.WHITE);
		textFieldForQty8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForQty8.setText("0");
		textFieldForQty8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String qty8 = textFieldForQty8.getText();
				String rate8 = textFieldForRate8.getText();
				
				Double qty_8 = Double.parseDouble(qty8);
				Double rate_8 = Double.parseDouble(rate8);
				
				Double mulQtyRate8 = (qty_8*rate_8);
				
				String value8 = String.format("%.2f", mulQtyRate8);
				
				textFieldForValue8.setText(value8);
				
				Integer totalQty = (Integer)totalQuantity();
				
				String totalQuantity = String.valueOf(totalQty);
				
				textFieldTotalQty.setText(totalQuantity);
				
				Double totalVal = (Double)totalValue();
				
				String totalValue = String.format("%.2f", totalVal);
				
				textFieldSubTotal.setText(totalValue);
				
				textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
				
				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
				
				Long numberToWord_ = (new Double(numToWord_).longValue());
				
				String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
				
				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
				
			}
		});
		textFieldForQty8.setColumns(10);
		textFieldForQty8.setBounds(217, 414, 86, 20);
		contentPane.add(textFieldForQty8);
		
		textFieldForQty9 = new JTextField();
		textFieldForQty9.setBackground(Color.WHITE);
		textFieldForQty9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForQty9.setText("0");
		textFieldForQty9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String qty9 = textFieldForQty9.getText();
				String rate9 = textFieldForRate9.getText();
				
				Double qty_9 = Double.parseDouble(qty9);
				Double rate_9 = Double.parseDouble(rate9);
				
				Double mulQtyRate9 = (qty_9*rate_9);
				
				String value9 = String.format("%.2f", mulQtyRate9);
				
				textFieldForValue9.setText(value9);
				
				Integer totalQty = (Integer)totalQuantity();
				
				String totalQuantity = String.valueOf(totalQty);
				
				textFieldTotalQty.setText(totalQuantity);
				
				Double totalVal = (Double)totalValue();
				
				String totalValue = String.format("%.2f", totalVal);
				
				textFieldSubTotal.setText(totalValue);
				
				textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
				
				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
				
				Long numberToWord_ = (new Double(numToWord_).longValue());
				
				String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
				
				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
				
			}
		});
		textFieldForQty9.setColumns(10);
		textFieldForQty9.setBounds(217, 445, 86, 20);
		contentPane.add(textFieldForQty9);
		
		textFieldForQty10 = new JTextField();
		textFieldForQty10.setBackground(Color.WHITE);
		textFieldForQty10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForQty10.setText("0");
		textFieldForQty10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String qty10 = textFieldForQty10.getText();
				String rate10 = textFieldForRate10.getText();
				
				Double qty_10 = Double.parseDouble(qty10);
				Double rate_10 = Double.parseDouble(rate10);
				
				Double mulQtyRate10 = (qty_10*rate_10);
				
				String value10 = String.format("%.2f", mulQtyRate10);
				
				textFieldForValue10.setText(value10);
				
				Integer totalQty = (Integer)totalQuantity();
				
				String totalQuantity = String.valueOf(totalQty);
				
				textFieldTotalQty.setText(totalQuantity);
				
				Double totalVal = (Double)totalValue();
				
				String totalValue = String.format("%.2f", totalVal);
				
				textFieldSubTotal.setText(totalValue);
				
				textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
				
				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
				
				Long numberToWord_ = (new Double(numToWord_).longValue());
				
				String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
				
				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
		
			}
		});
		textFieldForQty10.setColumns(10);
		textFieldForQty10.setBounds(217, 476, 86, 20);
		contentPane.add(textFieldForQty10);
		
		textFieldForMrp1 = new JTextField();
		textFieldForMrp1.setBackground(Color.WHITE);
		textFieldForMrp1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForMrp1.setBounds(334, 197, 86, 20);
		contentPane.add(textFieldForMrp1);
		textFieldForMrp1.setColumns(10);
		textFieldForMrp1.setText("0");
		
		textFieldForMrp2 = new JTextField();
		textFieldForMrp2.setBackground(Color.WHITE);
		textFieldForMrp2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForMrp2.setColumns(10);
		textFieldForMrp2.setBounds(334, 228, 86, 20);
		contentPane.add(textFieldForMrp2);
		textFieldForMrp2.setText("0");
		
		textFieldForMrp3 = new JTextField();
		textFieldForMrp3.setBackground(Color.WHITE);
		textFieldForMrp3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForMrp3.setColumns(10);
		textFieldForMrp3.setBounds(334, 259, 86, 20);
		contentPane.add(textFieldForMrp3);
		textFieldForMrp3.setText("0");
		
		textFieldForMrp4 = new JTextField();
		textFieldForMrp4.setBackground(Color.WHITE);
		textFieldForMrp4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForMrp4.setColumns(10);
		textFieldForMrp4.setBounds(334, 290, 86, 20);
		contentPane.add(textFieldForMrp4);
		textFieldForMrp4.setText("0");
		
		textFieldForMrp5 = new JTextField();
		textFieldForMrp5.setBackground(Color.WHITE);
		textFieldForMrp5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForMrp5.setColumns(10);
		textFieldForMrp5.setBounds(334, 321, 86, 20);
		contentPane.add(textFieldForMrp5);
		textFieldForMrp5.setText("0");
		
		textFieldForMrp6 = new JTextField();
		textFieldForMrp6.setBackground(Color.WHITE);
		textFieldForMrp6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForMrp6.setColumns(10);
		textFieldForMrp6.setBounds(334, 352, 86, 20);
		contentPane.add(textFieldForMrp6);
		textFieldForMrp6.setText("0");
		
		textFieldForMrp7 = new JTextField();
		textFieldForMrp7.setBackground(Color.WHITE);
		textFieldForMrp7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForMrp7.setColumns(10);
		textFieldForMrp7.setBounds(334, 383, 86, 20);
		contentPane.add(textFieldForMrp7);
		textFieldForMrp7.setText("0");
		
		textFieldForMrp8 = new JTextField();
		textFieldForMrp8.setBackground(Color.WHITE);
		textFieldForMrp8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForMrp8.setColumns(10);
		textFieldForMrp8.setBounds(334, 414, 86, 20);
		contentPane.add(textFieldForMrp8);
		textFieldForMrp8.setText("0");
		
		textFieldForMrp9 = new JTextField();
		textFieldForMrp9.setBackground(Color.WHITE);
		textFieldForMrp9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForMrp9.setColumns(10);
		textFieldForMrp9.setBounds(334, 445, 86, 20);
		contentPane.add(textFieldForMrp9);
		textFieldForMrp9.setText("0");
		
		textFieldForMrp10 = new JTextField();
		textFieldForMrp10.setBackground(Color.WHITE);
		textFieldForMrp10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForMrp10.setColumns(10);
		textFieldForMrp10.setBounds(334, 476, 86, 20);
		contentPane.add(textFieldForMrp10);
		textFieldForMrp10.setText("0");
		
		textFieldForRate1 = new JTextField();
		textFieldForRate1.setBackground(Color.WHITE);
		textFieldForRate1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate1.setBounds(447, 197, 86, 20);
		contentPane.add(textFieldForRate1);
		textFieldForRate1.setColumns(10);
		textFieldForRate1.setText("0");
		
		textFieldForRate2 = new JTextField();
		textFieldForRate2.setBackground(Color.WHITE);
		textFieldForRate2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate2.setColumns(10);
		textFieldForRate2.setBounds(447, 228, 86, 20);
		contentPane.add(textFieldForRate2);
		textFieldForRate2.setText("0");
		
		textFieldForRate3 = new JTextField();
		textFieldForRate3.setBackground(Color.WHITE);
		textFieldForRate3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate3.setColumns(10);
		textFieldForRate3.setBounds(447, 259, 86, 20);
		contentPane.add(textFieldForRate3);
		textFieldForRate3.setText("0");
		
		textFieldForRate4 = new JTextField();
		textFieldForRate4.setBackground(Color.WHITE);
		textFieldForRate4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate4.setColumns(10);
		textFieldForRate4.setBounds(447, 290, 86, 20);
		contentPane.add(textFieldForRate4);
		textFieldForRate4.setText("0");
		
		textFieldForRate5 = new JTextField();
		textFieldForRate5.setBackground(Color.WHITE);
		textFieldForRate5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate5.setColumns(10);
		textFieldForRate5.setBounds(447, 321, 86, 20);
		contentPane.add(textFieldForRate5);
		textFieldForRate5.setText("0");
		
		textFieldForRate6 = new JTextField();
		textFieldForRate6.setBackground(Color.WHITE);
		textFieldForRate6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate6.setColumns(10);
		textFieldForRate6.setBounds(447, 352, 86, 20);
		contentPane.add(textFieldForRate6);
		textFieldForRate6.setText("0");
		
		textFieldForRate7 = new JTextField();
		textFieldForRate7.setBackground(Color.WHITE);
		textFieldForRate7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate7.setColumns(10);
		textFieldForRate7.setBounds(447, 383, 86, 20);
		contentPane.add(textFieldForRate7);
		textFieldForRate7.setText("0");
		
		textFieldForRate8 = new JTextField();
		textFieldForRate8.setBackground(Color.WHITE);
		textFieldForRate8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate8.setColumns(10);
		textFieldForRate8.setBounds(447, 414, 86, 20);
		contentPane.add(textFieldForRate8);
		textFieldForRate8.setText("0");
		
		textFieldForRate9 = new JTextField();
		textFieldForRate9.setBackground(Color.WHITE);
		textFieldForRate9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate9.setColumns(10);
		textFieldForRate9.setBounds(447, 445, 86, 20);
		contentPane.add(textFieldForRate9);
		textFieldForRate9.setText("0");
		
		textFieldForRate10 = new JTextField();
		textFieldForRate10.setBackground(Color.WHITE);
		textFieldForRate10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate10.setColumns(10);
		textFieldForRate10.setBounds(447, 476, 86, 20);
		contentPane.add(textFieldForRate10);
		textFieldForRate10.setText("0");
		
		textFieldForValue1 = new JTextField();
		textFieldForValue1.setBackground(Color.WHITE);
		textFieldForValue1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue1.setBounds(576, 197, 86, 20);
		contentPane.add(textFieldForValue1);
		textFieldForValue1.setColumns(10);
		textFieldForValue1.setText("0");
		
		textFieldForValue2 = new JTextField();
		textFieldForValue2.setBackground(Color.WHITE);
		textFieldForValue2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue2.setColumns(10);
		textFieldForValue2.setBounds(576, 228, 86, 20);
		contentPane.add(textFieldForValue2);
		textFieldForValue2.setText("0");
		
		textFieldForValue3 = new JTextField();
		textFieldForValue3.setBackground(Color.WHITE);
		textFieldForValue3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue3.setColumns(10);
		textFieldForValue3.setBounds(576, 259, 86, 20);
		contentPane.add(textFieldForValue3);
		textFieldForValue3.setText("0");
		
		textFieldForValue4 = new JTextField();
		textFieldForValue4.setBackground(Color.WHITE);
		textFieldForValue4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue4.setColumns(10);
		textFieldForValue4.setBounds(576, 290, 86, 20);
		contentPane.add(textFieldForValue4);
		textFieldForValue4.setText("0");
		
		textFieldForValue5 = new JTextField();
		textFieldForValue5.setBackground(Color.WHITE);
		textFieldForValue5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue5.setColumns(10);
		textFieldForValue5.setBounds(576, 321, 86, 20);
		contentPane.add(textFieldForValue5);
		textFieldForValue5.setText("0");
		
		textFieldForValue6 = new JTextField();
		textFieldForValue6.setBackground(Color.WHITE);
		textFieldForValue6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue6.setColumns(10);
		textFieldForValue6.setBounds(576, 352, 86, 20);
		contentPane.add(textFieldForValue6);
		textFieldForValue6.setText("0");
		
		textFieldForValue7 = new JTextField();
		textFieldForValue7.setBackground(Color.WHITE);
		textFieldForValue7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue7.setColumns(10);
		textFieldForValue7.setBounds(576, 383, 86, 20);
		contentPane.add(textFieldForValue7);
		textFieldForValue7.setText("0");
		
		textFieldForValue8 = new JTextField();
		textFieldForValue8.setBackground(Color.WHITE);
		textFieldForValue8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue8.setColumns(10);
		textFieldForValue8.setBounds(576, 414, 86, 20);
		contentPane.add(textFieldForValue8);
		textFieldForValue8.setText("0");
		
		textFieldForValue9 = new JTextField();
		textFieldForValue9.setBackground(Color.WHITE);
		textFieldForValue9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue9.setColumns(10);
		textFieldForValue9.setBounds(576, 445, 86, 20);
		contentPane.add(textFieldForValue9);
		textFieldForValue9.setText("0");
		
		textFieldForValue10 = new JTextField();
		textFieldForValue10.setBackground(Color.WHITE);
		textFieldForValue10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue10.setColumns(10);
		textFieldForValue10.setBounds(576, 476, 86, 20);
		contentPane.add(textFieldForValue10);
		textFieldForValue10.setText("0");
		
		JLabel lblTo = new JLabel("TO :");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTo.setBounds(334, 22, 56, 14);
		contentPane.add(lblTo);
		
		textFieldTo = new JTextField();
		textFieldTo.setBackground(Color.WHITE);
		textFieldTo.setBounds(375, 21, 371, 20);
		contentPane.add(textFieldTo);
		textFieldTo.setColumns(10);
		
		textAreaAddress = new JTextArea();
		textAreaAddress.setBackground(Color.WHITE);
		textAreaAddress.setBounds(334, 47, 412, 59);
		contentPane.add(textAreaAddress);
		
		lblGstin = new JLabel("GSTIN :");
		lblGstin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGstin.setBounds(334, 118, 71, 14);
		contentPane.add(lblGstin);
		
		textFieldGstin = new JTextField();
		textFieldGstin.setBackground(Color.WHITE);
		textFieldGstin.setBounds(401, 117, 259, 20);
		contentPane.add(textFieldGstin);
		textFieldGstin.setColumns(10);
		
		textFieldSubTotal = new JTextField();
		textFieldSubTotal.setBackground(Color.WHITE);
		textFieldSubTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSubTotal.setBounds(637, 520, 135, 20);
		contentPane.add(textFieldSubTotal);
		textFieldSubTotal.setColumns(10);
		
		textFieldTotalQty = new JTextField();
		textFieldTotalQty.setBackground(Color.WHITE);
		textFieldTotalQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldTotalQty.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalQty.setColumns(10);
		textFieldTotalQty.setBounds(380, 520, 135, 20);
		contentPane.add(textFieldTotalQty);
		
		lblSubTotal = new JLabel("SUB TOTAL");
		lblSubTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSubTotal.setBounds(541, 522, 86, 14);
		contentPane.add(lblSubTotal);
		
		lblTotalQty = new JLabel("TOTAL QTY");
		lblTotalQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalQty.setBounds(284, 520, 86, 14);
		contentPane.add(lblTotalQty);
		
		textFieldGrandTotal = new JTextField();
		textFieldGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldGrandTotal.setBackground(Color.WHITE);
		textFieldGrandTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGrandTotal.setBounds(662, 573, 110, 35);
		contentPane.add(textFieldGrandTotal);
		textFieldGrandTotal.setColumns(10);
		
		lblGrandTotal = new JLabel("GRAND TOTAL :");
		lblGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGrandTotal.setBounds(519, 574, 135, 32);
		contentPane.add(lblGrandTotal);
		
		lblBillNo = new JLabel("BILL NO :");
		lblBillNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBillNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBillNo.setBounds(10, 118, 86, 14);
		contentPane.add(lblBillNo);
		
		textFieldBillNo = new JTextField("");
		textFieldBillNo.setBackground(Color.WHITE);
		textFieldBillNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldBillNo.setBounds(106, 117, 148, 20);
		contentPane.add(textFieldBillNo);
		textFieldBillNo.setColumns(10);
		
		lblNewLabel = new JLabel("DATE :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 86, 56, 20);
		contentPane.add(lblNewLabel);
		
		textFieldDate = new JTextField();
		textFieldDate.setBackground(Color.WHITE);
		textFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldDate.setBounds(106, 86, 148, 20);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		lblCompanyName = new JLabel("");
		lblCompanyName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCompanyName.setBounds(10, 34, 266, 20);
		contentPane.add(lblCompanyName);
		
	//	fillComboBox();
		
		Integer totalQty = (Integer)totalQuantity();
		
		String totalQuantity = String.valueOf(totalQty);
		
		textFieldTotalQty.setText(totalQuantity);
		
		Double totalVal = (Double)totalValue();
		
		String totalValue = String.format("%.3f", totalVal);
		
		textFieldSubTotal.setText(totalValue);
		
		textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
		
		JButton btnSaveUser = new JButton("Save");
		btnSaveUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSaveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				getBillNo();
				
				try{
					
					String query = "INSERT INTO Users(S_NO, NAME, ADDRESS, GSTIN) VALUES (?, ?, ?,?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, textFieldBillNo.getText());
					pst.setString(2, textFieldTo.getText());
					pst.setString(3, textAreaAddress.getText());
					pst.setString(4, textFieldGstin.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "User Data Saved");
					
					pst.close();
					
				}catch (Exception e) {
					
					e.printStackTrace();
					
				}
				
			}
		});
//		Image img = new ImageIcon(this.getClass().getResource("/save-icon.png")).getImage();
//		btnSaveUser.setIcon(new ImageIcon(img));
		btnSaveUser.setBounds(680, 120, 66, 15);
		contentPane.add(btnSaveUser);
		
		lblNumberToWord = new JLabel("");
		lblNumberToWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberToWord.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumberToWord.setBounds(422, 632, 350, 20);
		contentPane.add(lblNumberToWord);
		
		Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
		
		Long numberToWord_ = (new Double(numToWord_).longValue());
		
		String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
		
		lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
		
		lblForTraders = new JLabel("");
		lblForTraders.setHorizontalAlignment(SwingConstants.CENTER);
		lblForTraders.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblForTraders.setBounds(494, 663, 278, 20);
		contentPane.add(lblForTraders);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PrinterJob pJob = PrinterJob.getPrinterJob();
				
				PageFormat preFormat = pJob.defaultPage();
				
				preFormat.setOrientation(PageFormat.LANDSCAPE);
				
				PageFormat postFormat = pJob.pageDialog(preFormat);
				
				if(preFormat != postFormat){
					
					 pJob.setPrintable(new Printer(contentPane), postFormat);
					 
					 if(pJob.printDialog()){
						 
						 try {
							 
							pJob.print();
						
						 } catch (PrinterException e) {
							
							e.printStackTrace();
							
						}
						 
					 }
					
				}
				
			}
		});
//		Image img1 = new ImageIcon(this.getClass().getResource("/print-icon.png")).getImage();
//		btnPrint.setIcon(new ImageIcon(img1));
		btnPrint.setBounds(19, 573, 77, 20);
		contentPane.add(btnPrint);
		
		JButton btnSnapShot = new JButton("Snap");
		btnSnapShot.setFont(new Font("Tahoma", Font.BOLD, 15));
//		Image img2 = new ImageIcon(this.getClass().getResource("/screenshot-icon.png")).getImage();
//		btnSnapShot.setIcon(new ImageIcon(img2));
		btnSnapShot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Robot robot = new Robot();
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
					
					Rectangle rectangle = new Rectangle(dimension);
					
					BufferedImage img = robot.createScreenCapture(rectangle);
					
					ImageIO.write(img, "jpg", new File("C:/AppImages/screen.jpg"));
					
					JOptionPane.showMessageDialog(null, "Snapshot taken");
					
				} catch (AWTException | IOException e) {
					
					e.printStackTrace();
				
				}
				
			}
		});
		btnSnapShot.setBounds(20, 531, 77, 20);
		contentPane.add(btnSnapShot);
		
		textFieldForSearch1 = new JTextField();
		textFieldForSearch1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					
					comboBox1.removeAllItems();
					
					String query = "SELECT DESCRIPTION FROM Products WHERE DESCRIPTION LIKE '"+textFieldForSearch1.getText()+"%'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
					
					comboBox1.addItem(rs.getString("DESCRIPTION"));
					
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		textFieldForSearch1.setBackground(Color.WHITE);
		textFieldForSearch1.setBounds(155, 197, 20, 20);
		contentPane.add(textFieldForSearch1);
		textFieldForSearch1.setColumns(10);
		
		textFieldForSearch2 = new JTextField();
		textFieldForSearch2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					
					comboBox2.removeAllItems();
					
					String query = "SELECT DESCRIPTION FROM Products WHERE DESCRIPTION LIKE '"+textFieldForSearch2.getText()+"%'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
					
					comboBox2.addItem(rs.getString("DESCRIPTION"));
					
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		textFieldForSearch2.setBackground(Color.WHITE);
		textFieldForSearch2.setColumns(10);
		textFieldForSearch2.setBounds(155, 228, 20, 20);
		contentPane.add(textFieldForSearch2);
		
		textFieldForSearch3 = new JTextField();
		textFieldForSearch3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					
					comboBox3.removeAllItems();
					
					String query = "SELECT DESCRIPTION FROM Products WHERE DESCRIPTION LIKE '"+textFieldForSearch3.getText()+"%'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
					
					comboBox3.addItem(rs.getString("DESCRIPTION"));
					
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		textFieldForSearch3.setBackground(Color.WHITE);
		textFieldForSearch3.setColumns(10);
		textFieldForSearch3.setBounds(155, 259, 20, 20);
		contentPane.add(textFieldForSearch3);
		
		textFieldForSearch4 = new JTextField();
		textFieldForSearch4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					
					comboBox4.removeAllItems();
					
					String query = "SELECT DESCRIPTION FROM Products WHERE DESCRIPTION LIKE '"+textFieldForSearch4.getText()+"%'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
					
					comboBox4.addItem(rs.getString("DESCRIPTION"));
					
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		textFieldForSearch4.setBackground(Color.WHITE);
		textFieldForSearch4.setColumns(10);
		textFieldForSearch4.setBounds(155, 290, 20, 20);
		contentPane.add(textFieldForSearch4);
		
		textFieldForSearch5 = new JTextField();
		textFieldForSearch5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					
					comboBox5.removeAllItems();
					
					String query = "SELECT DESCRIPTION FROM Products WHERE DESCRIPTION LIKE '"+textFieldForSearch5.getText()+"%'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
					
					comboBox5.addItem(rs.getString("DESCRIPTION"));
					
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		textFieldForSearch5.setBackground(Color.WHITE);
		textFieldForSearch5.setColumns(10);
		textFieldForSearch5.setBounds(155, 321, 20, 20);
		contentPane.add(textFieldForSearch5);
		
		textFieldForSearch6 = new JTextField();
		textFieldForSearch6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					
					comboBox6.removeAllItems();
					
					String query = "SELECT DESCRIPTION FROM Products WHERE DESCRIPTION LIKE '"+textFieldForSearch6.getText()+"%'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
					
					comboBox6.addItem(rs.getString("DESCRIPTION"));
					
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		textFieldForSearch6.setBackground(Color.WHITE);
		textFieldForSearch6.setColumns(10);
		textFieldForSearch6.setBounds(155, 352, 20, 20);
		contentPane.add(textFieldForSearch6);
		
		textFieldForSearch7 = new JTextField();
		textFieldForSearch7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					
					comboBox7.removeAllItems();
					
					String query = "SELECT DESCRIPTION FROM Products WHERE DESCRIPTION LIKE '"+textFieldForSearch7.getText()+"%'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
					
					comboBox7.addItem(rs.getString("DESCRIPTION"));
					
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		textFieldForSearch7.setBackground(Color.WHITE);
		textFieldForSearch7.setColumns(10);
		textFieldForSearch7.setBounds(155, 383, 20, 20);
		contentPane.add(textFieldForSearch7);
		
		textFieldForSearch8 = new JTextField();
		textFieldForSearch8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					
					comboBox8.removeAllItems();
					
					String query = "SELECT DESCRIPTION FROM Products WHERE DESCRIPTION LIKE '"+textFieldForSearch8.getText()+"%'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
					
					comboBox8.addItem(rs.getString("DESCRIPTION"));
					
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		textFieldForSearch8.setBackground(Color.WHITE);
		textFieldForSearch8.setColumns(10);
		textFieldForSearch8.setBounds(155, 414, 20, 20);
		contentPane.add(textFieldForSearch8);
		
		textFieldForSearch9 = new JTextField();
		textFieldForSearch9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					
					comboBox9.removeAllItems();
					
					String query = "SELECT DESCRIPTION FROM Products WHERE DESCRIPTION LIKE '"+textFieldForSearch9.getText()+"%'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
					
					comboBox9.addItem(rs.getString("DESCRIPTION"));
					
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		textFieldForSearch9.setBackground(Color.WHITE);
		textFieldForSearch9.setColumns(10);
		textFieldForSearch9.setBounds(155, 445, 20, 20);
		contentPane.add(textFieldForSearch9);
		
		textFieldForSearch10 = new JTextField();
		textFieldForSearch10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					
					comboBox10.removeAllItems();
					
					String query = "SELECT DESCRIPTION FROM Products WHERE DESCRIPTION LIKE '"+textFieldForSearch10.getText()+"%'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
					
					comboBox10.addItem(rs.getString("DESCRIPTION"));
					
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		textFieldForSearch10.setBackground(Color.WHITE);
		textFieldForSearch10.setColumns(10);
		textFieldForSearch10.setBounds(155, 476, 20, 20);
		contentPane.add(textFieldForSearch10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				resetData();
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(19, 610, 77, 20);
		contentPane.add(btnReset);
		
		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TradeReceiptPojo trp = new TradeReceiptPojo();
				
				trp.resetValues();
				
				trp.setComboBox1(comboBox1.getSelectedItem().toString());
				trp.setComboBox2(comboBox2.getSelectedItem().toString());
				trp.setComboBox3(comboBox3.getSelectedItem().toString());
				trp.setComboBox4(comboBox4.getSelectedItem().toString());
				trp.setComboBox5(comboBox5.getSelectedItem().toString());
				trp.setComboBox6(comboBox6.getSelectedItem().toString());
				trp.setComboBox7(comboBox7.getSelectedItem().toString());
				trp.setComboBox8(comboBox8.getSelectedItem().toString());
				trp.setComboBox9(comboBox9.getSelectedItem().toString());
				trp.setComboBox10(comboBox10.getSelectedItem().toString());
				
				trp.setTextFieldForQty1(textFieldForQty1.getText().toString());
				trp.setTextFieldForQty2(textFieldForQty2.getText().toString());
				trp.setTextFieldForQty3(textFieldForQty3.getText().toString());
				trp.setTextFieldForQty4(textFieldForQty4.getText().toString());
				trp.setTextFieldForQty5(textFieldForQty5.getText().toString());
				trp.setTextFieldForQty6(textFieldForQty6.getText().toString());
				trp.setTextFieldForQty7(textFieldForQty7.getText().toString());
				trp.setTextFieldForQty8(textFieldForQty8.getText().toString());
				trp.setTextFieldForQty9(textFieldForQty9.getText().toString());
				trp.setTextFieldForQty10(textFieldForQty10	.getText().toString());
				
				trp.setTextFieldForRate1(textFieldForRate1.getText().toString());
				trp.setTextFieldForRate2(textFieldForRate2.getText().toString());
				trp.setTextFieldForRate3(textFieldForRate3.getText().toString());
				trp.setTextFieldForRate4(textFieldForRate4.getText().toString());
				trp.setTextFieldForRate5(textFieldForRate5.getText().toString());
				trp.setTextFieldForRate6(textFieldForRate6.getText().toString());
				trp.setTextFieldForRate7(textFieldForRate7.getText().toString());
				trp.setTextFieldForRate8(textFieldForRate8.getText().toString());
				trp.setTextFieldForRate9(textFieldForRate9.getText().toString());
				trp.setTextFieldForRate10(textFieldForRate10.getText().toString());
				
				trp.setTextFieldForMrp1(textFieldForMrp1.getText().toString());
				trp.setTextFieldForMrp2(textFieldForMrp2.getText().toString());
				trp.setTextFieldForMrp3(textFieldForMrp3.getText().toString());
				trp.setTextFieldForMrp4(textFieldForMrp4.getText().toString());
				trp.setTextFieldForMrp5(textFieldForMrp5.getText().toString());
				trp.setTextFieldForMrp6(textFieldForMrp6.getText().toString());
				trp.setTextFieldForMrp7(textFieldForMrp7.getText().toString());
				trp.setTextFieldForMrp8(textFieldForMrp8.getText().toString());
				trp.setTextFieldForMrp9(textFieldForMrp9.getText().toString());
				trp.setTextFieldForMrp10(textFieldForMrp10.getText().toString());
				
				trp.setTextFieldForValue1(textFieldForValue1.getText().toString());
				trp.setTextFieldForValue2(textFieldForValue2.getText().toString());
				trp.setTextFieldForValue3(textFieldForValue3.getText().toString());
				trp.setTextFieldForValue4(textFieldForValue4.getText().toString());
				trp.setTextFieldForValue5(textFieldForValue5.getText().toString());
				trp.setTextFieldForValue6(textFieldForValue6.getText().toString());
				trp.setTextFieldForValue7(textFieldForValue7.getText().toString());
				trp.setTextFieldForValue8(textFieldForValue8.getText().toString());
				trp.setTextFieldForValue9(textFieldForValue9.getText().toString());
				trp.setTextFieldForValue10(textFieldForValue10.getText().toString());
				
				trp.setTextFieldTo(textFieldTo.getText().toString());
				trp.setTextAreaAddress(textAreaAddress.getText().toString());
				trp.setTextFieldGstin(textFieldGstin.getText().toString());
				
				trp.setTextFieldSubTotal(textFieldSubTotal.getText().toString());
				trp.setTextFieldTotalQty(textFieldTotalQty.getText().toString());
				trp.setTextFieldGrandTotal(textFieldGrandTotal.getText().toString());
				
				trp.setTextFieldBillNo(textFieldBillNo.getText().toString());
				trp.setTextFieldDate(textFieldDate.getText().toString());
				
				trp.setLabelTitle1(lblCompanyName.getText().toString());
			//	trp.setLabelTitle2(lblCompanyAddress.getText().toString());
			//	trp.setLabelTitle3(lblCompanyGstin.getText().toString());
				
				trp.setLblNumberToWord(lblNumberToWord.getText().toString());
				
				trp.setCompanySignature(lblForTraders.getText().toString());
				
				TradeBillReceipt tbr = new TradeBillReceipt(trp);
				
				tbr.setVisible(true);
				
				dispose();
				
			}
		});
		btnReceipt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReceipt.setBounds(20, 663, 101, 20);
		contentPane.add(btnReceipt);
		
		JLabel lblMrp = new JLabel("MRP");
		lblMrp.setHorizontalAlignment(SwingConstants.CENTER);
		lblMrp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMrp.setBackground(Color.WHITE);
		lblMrp.setBounds(323, 156, 119, 14);
		contentPane.add(lblMrp);
		
		getCompanyDetails();
		
		getCurrentDate();
		
		getBillNo();
		
	}
} 
