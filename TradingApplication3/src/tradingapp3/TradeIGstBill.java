package tradingapp3;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.SystemColor;

public class TradeIGstBill extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradeIGstBill frame = new TradeIGstBill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	
	Connection con = null;
	 JComboBox<String> comboBox1;
	 JLabel lblHsn;
	 JLabel lblQty;
	 JLabel lblRate;
	 JLabel lbligst;
	 JLabel lblAmt1;
	 JLabel lblValue;
	 JTextField textFieldForHsn1;
	 JTextField textFieldForQty1;
	 JTextField textFieldForRate1;
	 JTextField textFieldForIGst1;
	 JTextField textFieldForIAmt1;
	 JTextField textFieldForValue1;
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
	 JLabel lblForRaviTraders;
	 JTextField textFieldTValue1;
	 JTextField textFieldTValue2;
	 JTextField textFieldTValue3;
	 JTextField textFieldTValue4;
	 JTextField textFieldTValue5;
	 JTextField textFieldIGst1;
	 JTextField textFieldIGst2;
	 JTextField textFieldIGst3;
	 JTextField textFieldIGst4;
	 JTextField textFieldIGst5;
	 JTextField textFieldTValue;
	 JTextField textFieldIGst;
	 JLabel lblTotal;
	 JTextField textFieldForSearch1;
	 
	 JLabel lblCompanyName;
	 JLabel lblCompanyAddress;
	 JLabel lblCompanyGstin;
	
	 DefaultTableModel dtm;
	 
	public void clearValues(){
		 
		 	comboBox1.removeAllItems();
		 	
		 	textFieldForHsn1.setText("0");
			
			textFieldForQty1.setText("0");
			
			textFieldForRate1.setText("0");
			
			textFieldForIGst1.setText("0");
			
			textFieldForIAmt1.setText("0");
			
			textFieldForValue1.setText("0"); 
			
			textFieldForSearch1.setText("");
			
	}
	 
	public void resetData(){
		
		comboBox1.removeAllItems();
		
		textFieldForHsn1.setText("0");
		
		textFieldForQty1.setText("0");
		
		textFieldForRate1.setText("0");
		
		textFieldForIGst1.setText("0");
		
		textFieldForIAmt1.setText("0");
		
		textFieldForValue1.setText("0");
		
		textFieldTo.setText(name);
		textAreaAddress.setText("");
		textFieldGstin.setText(gstNo);
		
		textFieldSubTotal.setText("0");
		textFieldTotalQty.setText("0");
		textFieldGrandTotal.setText("0");
		
		textFieldBillNo.setText("RT ");
		textFieldDate.setText("");
		
		textFieldTValue1.setText("0");
		textFieldTValue2.setText("0");
		textFieldTValue3.setText("0");
		textFieldTValue4.setText("0");
		textFieldTValue5.setText("0");
		
		textFieldIGst1.setText("0");
		textFieldIGst2.setText("0");
		textFieldIGst3.setText("0");
		textFieldIGst4.setText("0");
		textFieldIGst5.setText("0");
		
		textFieldTValue.setText("0");
		textFieldIGst.setText("0");
		
		textFieldForSearch1.setText("");
		
	}
	
	/*public void fillComboBox(){
		
		try{
			
			String query = "SELECT * FROM Products";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			comboBox1.addItem("--SELECT--");
			comboBox2.addItem("--SELECT--");
			comboBox3.addItem("--SELECT--");
			comboBox4.addItem("--SELECT--");
			comboBox5.addItem("--SELECT--");
			comboBox6.addItem("--SELECT--");
			comboBox7.addItem("--SELECT--");
			comboBox8.addItem("--SELECT--");
			comboBox9.addItem("--SELECT--");
			comboBox10.addItem("--SELECT--");
			
			while(rs.next()){
				
				comboBox1.addItem(rs.getString("DESCRIPTION"));
				comboBox2.addItem(rs.getString("DESCRIPTION"));
				comboBox3.addItem(rs.getString("DESCRIPTION"));
				comboBox4.addItem(rs.getString("DESCRIPTION"));
				comboBox5.addItem(rs.getString("DESCRIPTION"));
				comboBox6.addItem(rs.getString("DESCRIPTION"));
				comboBox7.addItem(rs.getString("DESCRIPTION"));
				comboBox8.addItem(rs.getString("DESCRIPTION"));
				comboBox9.addItem(rs.getString("DESCRIPTION"));
				comboBox10.addItem(rs.getString("DESCRIPTION"));
				
			}
			
			rs.close();
			pst.close();
			
		}catch(Exception e1){
			
			e1.printStackTrace();
			
		}
		
	}*/
	
	public Integer totalQuantity(){
		
		Integer totalQuantity = 0; 
		
		int rowCount = (Integer)dtm.getRowCount();
		
		int i;
		
		for(i=0; i<rowCount; i++){
			
			Object qtyValue = dtm.getValueAt(i, 2);
			
			int qtyVal = Integer.parseInt(qtyValue.toString());
			
			totalQuantity = totalQuantity + qtyVal;
			
		}
		
		return totalQuantity;
		
	}
	
	public Double totalValue(){
		
		Double totalValue = 0.0;
		
		int rowCount = (Integer)dtm.getRowCount();
		
		int i;
		
		for(i=0; i<rowCount; i++){
			
			Object value = dtm.getValueAt(i, 6);
			
			Double val = Double.parseDouble(value.toString());
			
			totalValue = totalValue + val;
			
		}
		
		return totalValue;
		
	}
	
	public void taxSummary(){
		
		Double Gst[] = {};
		Double tValue[] = {};
		Double IGst[] = {};
		
		int rowCount = (Integer)dtm.getRowCount();
		
		Gst = new Double[rowCount];
		tValue = new Double[rowCount];
		IGst = new Double[rowCount];
		
		int i;
		
		for(i=0; i<rowCount; i++){
			
			Object oQty = dtm.getValueAt(i, 2);
			
			Double qty = Double.parseDouble(oQty.toString());
			
			Object oRate = dtm.getValueAt(i, 3);
			
			Double rate = Double.parseDouble(oRate.toString());
			
			Double mulQtyRate = (qty*rate);
			
			Object oIGst = dtm.getValueAt(i, 4);
			
			Double iGst = Double.parseDouble(oIGst.toString());
			
			Double gst = iGst;
			
			Object oIAmt = dtm.getValueAt(i, 5);
			
			Double iAmt = Double.parseDouble(oIAmt.toString());
			
			Gst[i] = gst;
			
			tValue[i] = mulQtyRate;
			
			IGst[i] = iAmt;
			
		}
		
		int a = 0;
		
		Double tValueTemp1 = 0.0;
		Double iGstTemp1 = 0.0;
		
		Double tValueTemp2 = 0.0;
		Double iGstTemp2 = 0.0;
		
		Double tValueTemp3 = 0.0;
		Double iGstTemp3 = 0.0;
		
		Double tValueTemp4 = 0.0;
		Double iGstTemp4 = 0.0;
		
		Double tValueTemp5 = 0.0;
		Double iGstTemp5 = 0.0;
		
		for(a=0; a<Gst.length; a++){
			
			if(Gst[a]==28){
				
				tValueTemp1 = tValueTemp1 + tValue[a];
				iGstTemp1 = iGstTemp1 + IGst[a];
				
			}else if(Gst[a]==18){
				
				tValueTemp2 = tValueTemp2 + tValue[a];
				iGstTemp2 = iGstTemp2 + IGst[a];
				
			}else if(Gst[a]==12){
				
				tValueTemp3 = tValueTemp3 + tValue[a];
				iGstTemp3 = iGstTemp3 + IGst[a];
				
			}else if(Gst[a]==5){
				
				tValueTemp4 = tValueTemp4 + tValue[a];
				iGstTemp4 = iGstTemp4 + IGst[a];
				
			}else if(Gst[a]==0){
				
				tValueTemp5 = tValueTemp5 + tValue[a];
				iGstTemp5 = iGstTemp5 + IGst[a];
				
			}
			
		}
		
		String tValueTemp_1 = String.format("%.2f", tValueTemp1);
		String tValueTemp_2 = String.format("%.2f", tValueTemp2);
		String tValueTemp_3 = String.format("%.2f", tValueTemp3);
		String tValueTemp_4 = String.format("%.2f", tValueTemp4);
		String tValueTemp_5 = String.format("%.2f", tValueTemp5);
		
		String iGstTemp_1 =String.format("%.2f", iGstTemp1);
		String iGstTemp_2 =String.format("%.2f", iGstTemp2);
		String iGstTemp_3 =String.format("%.2f", iGstTemp3);
		String iGstTemp_4 =String.format("%.2f", iGstTemp4);
		String iGstTemp_5 =String.format("%.2f", iGstTemp5);
		
		textFieldTValue1.setText(tValueTemp_1);
		textFieldTValue2.setText(tValueTemp_2);
		textFieldTValue3.setText(tValueTemp_3);
		textFieldTValue4.setText(tValueTemp_4);
		textFieldTValue5.setText(tValueTemp_5);
		
		textFieldIGst1.setText(iGstTemp_1);
		textFieldIGst2.setText(iGstTemp_2);
		textFieldIGst3.setText(iGstTemp_3);
		textFieldIGst4.setText(iGstTemp_4);
		textFieldIGst5.setText(iGstTemp_5);
		
		Double tValueC = 0.0;
		
		Double tValue1 = Double.parseDouble((textFieldTValue1.getText()).toString());
		Double tValue2 = Double.parseDouble((textFieldTValue2.getText()).toString());
		Double tValue3 = Double.parseDouble((textFieldTValue3.getText()).toString());
		Double tValue4 = Double.parseDouble((textFieldTValue4.getText()).toString());
		Double tValue5 = Double.parseDouble((textFieldTValue5.getText()).toString());
		
		tValueC = (tValue1 + tValue2 + tValue3 + tValue4 + tValue5);
		
		String tVal = String.format("%.2f", tValueC);
		
		textFieldTValue.setText(tVal);
		
		Double iGst = 0.0;
		
		Double iGst1 = Double.parseDouble((textFieldIGst1.getText()).toString());
		Double iGst2 = Double.parseDouble((textFieldIGst2.getText()).toString());
		Double iGst3 = Double.parseDouble((textFieldIGst3.getText()).toString());
		Double iGst4 = Double.parseDouble((textFieldIGst4.getText()).toString());
		Double iGst5 = Double.parseDouble((textFieldIGst5.getText()).toString());
		
		iGst = (iGst1 + iGst2 + iGst3 + iGst4 + iGst5);
		
		String IGstC = String.format("%.2f", iGst);
		
		textFieldIGst.setText(IGstC);
		
	}
	
	public void getCompanyDetails(){
		
		try{
			
			String companyName = null;
			String companyAddress = null;
			String companyGstin = null;
		
			String query = "SELECT * FROM Company";
		
			PreparedStatement pst = con.prepareStatement(query);
		
			ResultSet rs = pst.executeQuery();
		
			while(rs.next()){
			
				companyName = rs.getString("COMPANY_NAME");
				companyAddress = rs.getString("COMPANY_ADDRESS");
				companyGstin = rs.getString("COMPANY_GSTIN");
				
				lblCompanyName.setText(companyName);
				lblCompanyAddress.setText(companyAddress);
				lblCompanyGstin.setText(companyGstin);
				
				lblForRaviTraders.setText(companyName);
			
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
				
				//billNo = billNo + 1;
				
				String billNum = "RT " + Integer.toString(billNo);
				
				textFieldBillNo.setText(billNum);
				
			}
			
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
		}
		
	}
	
	public void updateUserData(){
		
		getBillNo();
		
		try{
			
			String query = "UPDATE Users SET DATE = ?, TAXABLE_VAL = ?, IGST = ?, TOTAL_AMT = ? WHERE BILL_NO = ? AND GSTN = ?";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, textFieldDate.getText());
			pst.setString(2, textFieldTValue.getText());
			pst.setString(3, textFieldIGst.getText());
			pst.setString(4, textFieldGrandTotal.getText());
			pst.setString(5, textFieldBillNo.getText());
			pst.setString(6, textFieldGstin.getText());
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "User Data Saved");
			
			pst.close();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void updateTaxData(){
		
		getBillNo();
		
		try{
			
			String query = "INSERT INTO TaxISummary(BILL_NO,NAME,GSTN,DATE,SALE_5,GST_5,SALE_12,GST_12,SALE_18,GST_18,SALE_28,GST_28) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, textFieldBillNo.getText());
			pst.setString(2, textFieldTo.getText());
			pst.setString(3, textFieldGstin.getText());
			pst.setString(4, textFieldDate.getText());
			pst.setString(5, textFieldTValue4.getText());
			pst.setString(6, textFieldIGst4.getText());
			pst.setString(7, textFieldTValue3.getText());
			pst.setString(8, textFieldIGst3.getText());
			pst.setString(9, textFieldTValue2.getText());
			pst.setString(10, textFieldIGst2.getText());
			pst.setString(11, textFieldTValue1.getText());
			pst.setString(12, textFieldIGst1.getText());
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Tax Data Updated");
			
			pst.close();
			
		}catch (Exception e1) {
			
			e1.printStackTrace();
			
		}
		
	}
	
	String name = "";
	String gstNo = "";
	private JButton btnSaveAsPdf;
	
	private JButton btnUpdateb;
	
	public TradeIGstBill(String name, String gstNo) {
		
		this.name = name;
		this.gstNo =gstNo;
		
		setTitle("TAX INVOICE CASH/CREDIT");
		con = SQLiteConnection.sqliteDbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(85, 5, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(new Color(0, 0, 0));
		separator1.setBounds(10, 143, 1164, 2);
		contentPane.add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBackground(new Color(0, 0, 0));
		separator2.setBounds(10, 507, 1164, 2);
		contentPane.add(separator2);
		
		JSeparator separator3 = new JSeparator();
		separator3.setBackground(new Color(0, 0, 0));
		separator3.setOrientation(SwingConstants.VERTICAL);
		separator3.setBounds(664, 11, 2, 134);
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
						
						textFieldForHsn1.setText(rs.getString("HSN"));
						textFieldForRate1.setText(rs.getString("RATE"));
						
						String gst1 = rs.getString("GST");
						
						Double gst_1 = Double.parseDouble(gst1);
						
						String igst1 = Double.toString(gst_1);
						
						textFieldForIGst1.setText(igst1);
						
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
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setBackground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(10, 156, 135, 14);
		contentPane.add(lblDescription);
		
		lblHsn = new JLabel("HSN");
		lblHsn.setHorizontalAlignment(SwingConstants.CENTER);
		lblHsn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHsn.setBackground(Color.WHITE);
		lblHsn.setBounds(202, 156, 135, 14);
		contentPane.add(lblHsn);
		
		lblQty = new JLabel("QTY");
		lblQty.setHorizontalAlignment(SwingConstants.CENTER);
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQty.setBackground(Color.WHITE);
		lblQty.setBounds(336, 156, 119, 14);
		contentPane.add(lblQty);
		
		lblRate = new JLabel("RATE");
		lblRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRate.setBackground(Color.WHITE);
		lblRate.setBounds(435, 156, 119, 14);
		contentPane.add(lblRate);
		
		lbligst = new JLabel("%IGST");
		lbligst.setHorizontalAlignment(SwingConstants.CENTER);
		lbligst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbligst.setBackground(Color.WHITE);
		lbligst.setBounds(550, 156, 101, 14);
		contentPane.add(lbligst);
		
		lblAmt1 = new JLabel("IGST AMT");
		lblAmt1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmt1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAmt1.setBackground(Color.WHITE);
		lblAmt1.setBounds(665, 156, 101, 14);
		contentPane.add(lblAmt1);
		
		lblValue = new JLabel("VALUE");
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValue.setBackground(Color.WHITE);
		lblValue.setBounds(806, 156, 110, 14);
		contentPane.add(lblValue);
		
		textFieldForHsn1 = new JTextField();
		textFieldForHsn1.setBackground(Color.WHITE);
		textFieldForHsn1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn1.setBounds(215, 197, 110, 20);
		contentPane.add(textFieldForHsn1);
		textFieldForHsn1.setColumns(10);
		
		textFieldForQty1 = new JTextField();
		textFieldForQty1.setBackground(Color.WHITE);
		textFieldForQty1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForQty1.setText("0");
		textFieldForQty1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String qty1 = textFieldForQty1.getText();
				String rate1 = textFieldForRate1.getText();
				String igst1 = textFieldForIGst1.getText();
				
				Double qty_1 = Double.parseDouble(qty1);
				Double rate_1 = Double.parseDouble(rate1);
				Double igst_1 = Double.parseDouble(igst1);
				
				Double mulQtyRate1 = (qty_1*rate_1);
				
				Double i_amt_1 = (igst_1/100)*mulQtyRate1;
				
				Double sum1 = mulQtyRate1 + i_amt_1;  
				
				String i_amt1 = String.format("%.2f", i_amt_1);
				String value1 = String.format("%.3f", sum1);
				
				textFieldForIAmt1.setText(i_amt1);
				textFieldForValue1.setText(value1);
				
			}
		});
		textFieldForQty1.setBounds(349, 197, 86, 20);
		contentPane.add(textFieldForQty1);
		textFieldForQty1.setColumns(10);
		
		textFieldForRate1 = new JTextField();
		textFieldForRate1.setBackground(Color.WHITE);
		textFieldForRate1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate1.setBounds(454, 197, 86, 20);
		contentPane.add(textFieldForRate1);
		textFieldForRate1.setColumns(10);
		textFieldForRate1.setText("0");
		
		textFieldForIGst1 = new JTextField();
		textFieldForIGst1.setBackground(Color.WHITE);
		textFieldForIGst1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIGst1.setBounds(562, 197, 86, 20);
		contentPane.add(textFieldForIGst1);
		textFieldForIGst1.setColumns(10);
		textFieldForIGst1.setText("0");
		
		textFieldForIAmt1 = new JTextField();
		textFieldForIAmt1.setBackground(Color.WHITE);
		textFieldForIAmt1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIAmt1.setBounds(676, 197, 86, 20);
		contentPane.add(textFieldForIAmt1);
		textFieldForIAmt1.setColumns(10);
		textFieldForIAmt1.setText("0");
		
		textFieldForValue1 = new JTextField();
		textFieldForValue1.setBackground(Color.WHITE);
		textFieldForValue1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue1.setBounds(824, 197, 86, 20);
		contentPane.add(textFieldForValue1);
		textFieldForValue1.setColumns(10);
		textFieldForValue1.setText("0");
		
		JLabel lblTo = new JLabel("TO :");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTo.setBounds(676, 22, 56, 14);
		contentPane.add(lblTo);
		
		textFieldTo = new JTextField();
		textFieldTo.setBackground(Color.WHITE);
		textFieldTo.setBounds(742, 21, 432, 20);
		textFieldTo.setText(name);
		contentPane.add(textFieldTo);
		textFieldTo.setColumns(10);
		
		textAreaAddress = new JTextArea();
		textAreaAddress.setBackground(Color.WHITE);
		textAreaAddress.setBounds(676, 47, 498, 59);
		contentPane.add(textAreaAddress);
		
		lblGstin = new JLabel("GSTIN :");
		lblGstin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGstin.setBounds(676, 118, 71, 14);
		contentPane.add(lblGstin);
		
		textFieldGstin = new JTextField();
		textFieldGstin.setBackground(Color.WHITE);
		textFieldGstin.setBounds(757, 117, 318, 20);
		textFieldGstin.setText(gstNo);
		contentPane.add(textFieldGstin);
		textFieldGstin.setColumns(10);
		
		textFieldSubTotal = new JTextField();
		textFieldSubTotal.setBackground(Color.WHITE);
		textFieldSubTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSubTotal.setBounds(1039, 519, 135, 20);
		contentPane.add(textFieldSubTotal);
		textFieldSubTotal.setColumns(10);
		
		textFieldTotalQty = new JTextField();
		textFieldTotalQty.setBackground(Color.WHITE);
		textFieldTotalQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldTotalQty.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalQty.setColumns(10);
		textFieldTotalQty.setBounds(776, 519, 135, 20);
		contentPane.add(textFieldTotalQty);
		
		lblSubTotal = new JLabel("SUB TOTAL");
		lblSubTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSubTotal.setBounds(935, 520, 86, 14);
		contentPane.add(lblSubTotal);
		
		lblTotalQty = new JLabel("TOTAL QTY");
		lblTotalQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalQty.setBounds(680, 520, 86, 14);
		contentPane.add(lblTotalQty);
		
		textFieldGrandTotal = new JTextField();
		textFieldGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldGrandTotal.setBackground(Color.WHITE);
		textFieldGrandTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGrandTotal.setBounds(1064, 573, 110, 35);
		textFieldGrandTotal.setText("0.0");
		contentPane.add(textFieldGrandTotal);
		textFieldGrandTotal.setColumns(10);
		
		lblGrandTotal = new JLabel("GRAND TOTAL :");
		lblGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGrandTotal.setBounds(910, 572, 135, 32);
		contentPane.add(lblGrandTotal);
		
		lblBillNo = new JLabel("BILL NO :");
		lblBillNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBillNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBillNo.setBounds(10, 118, 86, 14);
		contentPane.add(lblBillNo);
		
		textFieldBillNo = new JTextField("RT ");
		textFieldBillNo.setBackground(Color.WHITE);
		textFieldBillNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldBillNo.setBounds(106, 117, 148, 20);
		contentPane.add(textFieldBillNo);
		textFieldBillNo.setColumns(10);
		
		lblNewLabel = new JLabel("DATE :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(415, 118, 63, 14);
		contentPane.add(lblNewLabel);
		
		textFieldDate = new JTextField();
		textFieldDate.setBackground(Color.WHITE);
		textFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldDate.setBounds(488, 117, 166, 20);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		lblCompanyName = new JLabel("");
		lblCompanyName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCompanyName.setBounds(10, 11, 362, 20);
		contentPane.add(lblCompanyName);
		
		lblCompanyAddress = new JLabel("");
		lblCompanyAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCompanyAddress.setBounds(10, 42, 487, 20);
		contentPane.add(lblCompanyAddress);
		
		lblCompanyGstin = new JLabel("");
		lblCompanyGstin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyGstin.setBounds(10, 73, 362, 20);
		contentPane.add(lblCompanyGstin);
		
	//	fillComboBox();
		
		/*Integer totalQty = (Integer)totalQuantity();
		
		String totalQuantity = String.valueOf(totalQty);
		
		textFieldTotalQty.setText(totalQuantity);
		
		Double totalVal = (Double)totalValue();
		
		String totalValue = String.format("%.3f", totalVal);
		
		textFieldSubTotal.setText(totalValue);
		
		textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());*/
		
		/*JButton btnSaveUser = new JButton("Update A");
		btnSaveUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSaveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				getBillNo();
				
				try{
					
					String query = "UPDATE Users SET DATE = ?, TAXABLE_VAL = ?, IGST = ?, TOTAL_AMT = ? WHERE BILL_NO = ? AND GSTN = ?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, textFieldDate.getText());
					pst.setString(2, textFieldTValue.getText());
					pst.setString(3, textFieldIGst.getText());
					pst.setString(4, textFieldGrandTotal.getText());
					pst.setString(5, textFieldBillNo.getText());
					pst.setString(6, textFieldGstin.getText());
					
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
		btnSaveUser.setBounds(444, 600, 110, 20);
		contentPane.add(btnSaveUser);*/
		
		/*btnUpdateb = new JButton("Update B");
		btnUpdateb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getBillNo();
				
				try{
					
					String query = "INSERT INTO TaxISummary(BILL_NO,NAME,GSTN,DATE,SALE_5,GST_5,SALE_12,GST_12,SALE_18,GST_18,SALE_28,GST_28) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, textFieldBillNo.getText());
					pst.setString(2, textFieldTo.getText());
					pst.setString(3, textFieldGstin.getText());
					pst.setString(4, textFieldDate.getText());
					pst.setString(5, textFieldTValue4.getText());
					pst.setString(6, textFieldIGst4.getText());
					pst.setString(7, textFieldTValue3.getText());
					pst.setString(8, textFieldIGst3.getText());
					pst.setString(9, textFieldTValue2.getText());
					pst.setString(10, textFieldIGst2.getText());
					pst.setString(11, textFieldTValue1.getText());
					pst.setString(12, textFieldIGst1.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Tax Data Updated");
					
					pst.close();
					
				}catch (Exception e1) {
					
					e1.printStackTrace();
					
				}
				
			}
		});
		btnUpdateb.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateb.setBounds(605, 600, 110, 20);
		contentPane.add(btnUpdateb);*/
		
		lblNumberToWord = new JLabel("");
		lblNumberToWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberToWord.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumberToWord.setBounds(824, 632, 350, 20);
		contentPane.add(lblNumberToWord);
		
		Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
		
		Long numberToWord_ = (new Double(numToWord_).longValue());
		
		String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
		
		lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
		
		lblForRaviTraders = new JLabel("");
		lblForRaviTraders.setHorizontalAlignment(SwingConstants.CENTER);
		lblForRaviTraders.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblForRaviTraders.setBounds(866, 663, 278, 20);
		contentPane.add(lblForRaviTraders);
		
		JLabel lblTaxSummary = new JLabel("TAX SUMMARY");
		lblTaxSummary.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTaxSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxSummary.setBounds(72, 522, 124, 14);
		contentPane.add(lblTaxSummary);
		
		JLabel lbltax = new JLabel("%Tax");
		lbltax.setHorizontalAlignment(SwingConstants.CENTER);
		lbltax.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltax.setBounds(10, 540, 46, 14);
		contentPane.add(lbltax);
		
		JLabel lblTvalue = new JLabel("T.Value");
		lblTvalue.setHorizontalAlignment(SwingConstants.CENTER);
		lblTvalue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTvalue.setBounds(81, 540, 46, 14);
		contentPane.add(lblTvalue);
		
		JLabel lblIgst = new JLabel("IGST");
		lblIgst.setHorizontalAlignment(SwingConstants.CENTER);
		lblIgst.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIgst.setBounds(150, 540, 46, 14);
		contentPane.add(lblIgst);
		
		textFieldTValue1 = new JTextField();
		textFieldTValue1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTValue1.setBackground(Color.WHITE);
		textFieldTValue1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldTValue1.setColumns(10);
		textFieldTValue1.setBounds(81, 562, 46, 14);
		textFieldTValue1.setText("0");
		contentPane.add(textFieldTValue1);
		
		textFieldTValue2 = new JTextField();
		textFieldTValue2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTValue2.setBackground(Color.WHITE);
		textFieldTValue2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldTValue2.setColumns(10);
		textFieldTValue2.setBounds(81, 582, 46, 14);
		textFieldTValue2.setText("0");
		contentPane.add(textFieldTValue2);
		
		textFieldTValue3 = new JTextField();
		textFieldTValue3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTValue3.setBackground(Color.WHITE);
		textFieldTValue3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldTValue3.setColumns(10);
		textFieldTValue3.setBounds(81, 605, 46, 14);
		textFieldTValue3.setText("0");
		contentPane.add(textFieldTValue3);
		
		textFieldTValue4 = new JTextField();
		textFieldTValue4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTValue4.setBackground(Color.WHITE);
		textFieldTValue4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldTValue4.setColumns(10);
		textFieldTValue4.setBounds(81, 630, 46, 14);
		textFieldTValue4.setText("0");
		contentPane.add(textFieldTValue4);
		
		textFieldTValue5 = new JTextField();
		textFieldTValue5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTValue5.setBackground(Color.WHITE);
		textFieldTValue5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldTValue5.setColumns(10);
		textFieldTValue5.setBounds(81, 648, 46, 14);
		textFieldTValue5.setText("0");
		contentPane.add(textFieldTValue5);
		
		textFieldIGst1 = new JTextField();
		textFieldIGst1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIGst1.setBackground(Color.WHITE);
		textFieldIGst1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldIGst1.setColumns(10);
		textFieldIGst1.setBounds(150, 562, 46, 14);
		textFieldIGst1.setText("0");
		contentPane.add(textFieldIGst1);
		
		textFieldIGst2 = new JTextField();
		textFieldIGst2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIGst2.setBackground(Color.WHITE);
		textFieldIGst2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldIGst2.setColumns(10);
		textFieldIGst2.setBounds(150, 582, 46, 14);
		textFieldIGst2.setText("0");
		contentPane.add(textFieldIGst2);
		
		textFieldIGst3 = new JTextField();
		textFieldIGst3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIGst3.setBackground(Color.WHITE);
		textFieldIGst3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldIGst3.setColumns(10);
		textFieldIGst3.setBounds(150, 605, 46, 14);
		textFieldIGst3.setText("0");
		contentPane.add(textFieldIGst3);
		
		textFieldIGst4 = new JTextField();
		textFieldIGst4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIGst4.setBackground(Color.WHITE);
		textFieldIGst4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldIGst4.setColumns(10);
		textFieldIGst4.setBounds(150, 630, 46, 14);
		textFieldIGst4.setText("0");
		contentPane.add(textFieldIGst4);
		
		textFieldIGst5 = new JTextField();
		textFieldIGst5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIGst5.setBackground(Color.WHITE);
		textFieldIGst5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldIGst5.setColumns(10);
		textFieldIGst5.setBounds(150, 648, 46, 14);
		textFieldIGst5.setText("0");
		contentPane.add(textFieldIGst5);
		
		textFieldTValue = new JTextField();
		textFieldTValue.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTValue.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldTValue.setColumns(10);
		textFieldTValue.setBackground(Color.WHITE);
		textFieldTValue.setBounds(81, 669, 46, 18);
		contentPane.add(textFieldTValue);
		
		textFieldIGst = new JTextField();
		textFieldIGst.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIGst.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldIGst.setColumns(10);
		textFieldIGst.setBackground(Color.WHITE);
		textFieldIGst.setBounds(150, 669, 46, 18);
		contentPane.add(textFieldIGst);
		
		lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotal.setBounds(10, 668, 46, 19);
		contentPane.add(lblTotal);
		
		/*JButton btnPrint = new JButton("Print");
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
		btnPrint.setBounds(326, 588, 77, 20);
		contentPane.add(btnPrint);*/
		
		JLabel label28 = new JLabel("28%");
		label28.setHorizontalAlignment(SwingConstants.CENTER);
		label28.setFont(new Font("Tahoma", Font.BOLD, 11));
		label28.setBounds(10, 562, 46, 14);
		contentPane.add(label28);
		
		JLabel label18 = new JLabel("18%");
		label18.setHorizontalAlignment(SwingConstants.CENTER);
		label18.setFont(new Font("Tahoma", Font.BOLD, 11));
		label18.setBounds(10, 585, 46, 14);
		contentPane.add(label18);
		
		JLabel label12 = new JLabel("12%");
		label12.setHorizontalAlignment(SwingConstants.CENTER);
		label12.setFont(new Font("Tahoma", Font.BOLD, 11));
		label12.setBounds(10, 605, 46, 14);
		contentPane.add(label12);
		
		JLabel label5 = new JLabel("5%");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label5.setBounds(10, 630, 46, 14);
		contentPane.add(label5);
		
		JLabel label0 = new JLabel("0%");
		label0.setHorizontalAlignment(SwingConstants.CENTER);
		label0.setFont(new Font("Tahoma", Font.BOLD, 11));
		label0.setBounds(10, 648, 46, 14);
		contentPane.add(label0);
		
		JButton btnSnapShot = new JButton("Snap");
		btnSnapShot.setBackground(UIManager.getColor("Button.background"));
		btnSnapShot.setForeground(Color.BLUE);
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
					
					ImageIO.write(img, "jpg", new File("C:/TradeApp/AppImages/screen.jpg"));
					
					JOptionPane.showMessageDialog(null, "Snapshot taken C Drive - TradeApp - AppImages");
					
				} catch (AWTException | IOException e) {
					
					e.printStackTrace();
				
				}
				
			}
		});
		btnSnapShot.setBounds(284, 557, 124, 20);
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
		
		/*JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				resetData();
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(791, 662, 77, 23);
		contentPane.add(btnReset);*/
		
		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.setBackground(UIManager.getColor("Button.background"));
		btnReceipt.setForeground(Color.BLUE);
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateUserData();
				updateTaxData();
				
				TradeReceiptPojo trp = new TradeReceiptPojo();
				
				trp.resetValues();
				
				int rowCount = (Integer)dtm.getRowCount();
				
				int i;
				
				String[] comboBox = new String[rowCount];
				
				List<String> textFieldForHsn = new ArrayList<String>();
				
				List<String> textFieldForQty = new ArrayList<String>();
				
				List<String> textFieldForRate = new ArrayList<String>();
				
				List<String> textFieldForIGst = new ArrayList<String>();
				
				List<String> textFieldForIAmt = new ArrayList<String>();
				
				List<String> textFieldForValue = new ArrayList<String>();
				
				for(i=0; i<rowCount; i++){
					
					Object oDescription = dtm.getValueAt(i, 0);
					Object oHsn = dtm.getValueAt(i, 1);
					Object oQuantity = dtm.getValueAt(i, 2);
					Object oRate = dtm.getValueAt(i, 3);
					Object oIGst = dtm.getValueAt(i, 4);
					Object oIAmt = dtm.getValueAt(i, 5);
					Object oValue = dtm.getValueAt(i, 6);
					
					
					String description = oDescription.toString();
					String hsn = oHsn.toString();
					String quantity = oQuantity.toString();
					String rate = oRate.toString();
					String iGst = oIGst.toString();
					String iAmt = oIAmt.toString();
					String value = oValue.toString();
					
					comboBox[i] = description;
					textFieldForHsn.add(hsn);
					textFieldForQty.add(quantity);
					textFieldForRate.add(rate);
					textFieldForIGst.add(iGst);
					textFieldForIAmt.add(iAmt);
					textFieldForValue.add(value);
					
				}
				
				trp.setComboBox(comboBox);
				
				trp.setTextFieldForHsn(textFieldForHsn);
				
				trp.setTextFieldForQty(textFieldForQty);
				
				trp.setTextFieldForRate(textFieldForRate);
				
				trp.setTextFieldForIGst(textFieldForIGst);
				
				trp.setTextFieldForIAmt(textFieldForIAmt);
				
				trp.setTextFieldForValue(textFieldForValue);
				
				trp.setTextFieldTo(textFieldTo.getText().toString());
				trp.setTextAreaAddress(textAreaAddress.getText().toString());
				trp.setTextFieldGstin(textFieldGstin.getText().toString());
				
				trp.setTextFieldSubTotal(textFieldSubTotal.getText().toString());
				trp.setTextFieldTotalQty(textFieldTotalQty.getText().toString());
				trp.setTextFieldGrandTotal(textFieldGrandTotal.getText().toString());
				
				trp.setTextFieldBillNo(textFieldBillNo.getText().toString());
				trp.setTextFieldDate(textFieldDate.getText().toString());
				
				trp.setTextFieldTValue1(textFieldTValue1.getText().toString());
				trp.setTextFieldTValue2(textFieldTValue2.getText().toString());
				trp.setTextFieldTValue3(textFieldTValue3.getText().toString());
				trp.setTextFieldTValue4(textFieldTValue4.getText().toString());
				trp.setTextFieldTValue5(textFieldTValue5.getText().toString());
				
				trp.setTextFieldIGst1(textFieldIGst1.getText().toString());
				trp.setTextFieldIGst2(textFieldIGst2.getText().toString());
				trp.setTextFieldIGst3(textFieldIGst3.getText().toString());
				trp.setTextFieldIGst4(textFieldIGst4.getText().toString());
				trp.setTextFieldIGst5(textFieldIGst5.getText().toString());
				
				trp.setTextFieldTValue(textFieldTValue.getText().toString());
				trp.setTextFieldIGst(textFieldIGst.getText().toString());
				
				trp.setLabelTitle1(lblCompanyName.getText().toString());
				trp.setLabelTitle2(lblCompanyAddress.getText().toString());
				trp.setLabelTitle3(lblCompanyGstin.getText().toString());
				
				trp.setLblNumberToWord(lblNumberToWord.getText().toString());
				
				trp.setCompanySignature(lblForRaviTraders.getText().toString());
				
				TradeIGstBillReceipt tbr = new TradeIGstBillReceipt(trp);
				
				tbr.setVisible(true);
				
				dispose();
				
			}
		});
		btnReceipt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReceipt.setBounds(284, 643, 124, 20);
		contentPane.add(btnReceipt);
		
		btnSaveAsPdf = new JButton("Save As Pdf");
		btnSaveAsPdf.setBackground(UIManager.getColor("Button.background"));
		btnSaveAsPdf.setForeground(Color.BLUE);
		btnSaveAsPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String billNo = textFieldBillNo.getText();
				
			try {
					
					Document document = new Document(PageSize.A4.rotate());
					
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File("C:/TradeApp/PDFSTORE/"+billNo+".pdf")));
					
					document.open();
					
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					document.add(new Paragraph(lblCompanyName.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN)));
					document.add(new Paragraph(lblCompanyAddress.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN)));
					document.add(new Paragraph(lblCompanyGstin.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN)));
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					document.add(new Paragraph(lblBillNo.getText()+" : "+textFieldBillNo.getText()));
					document.add(new Paragraph(lblNewLabel.getText()+" : "+textFieldDate.getText()));
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					document.add(new Paragraph(lblTo.getText()+" : "+textFieldTo.getText()));
					document.add(new Paragraph(textAreaAddress.getText()));
					document.add(new Paragraph(lblGstin.getText()+" : "+textFieldGstin.getText()));
					
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					document.add(new Paragraph("==============================================================================================="));
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					
					document.add(new Paragraph("PRODUCTS SESSION : ", FontFactory.getFont(FontFactory.TIMES_ROMAN)));
					
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					
					PdfPTable tableBill = new PdfPTable(7);
					
					tableBill.addCell("PRODUCT");
					tableBill.addCell("HSN");
					tableBill.addCell("QTY");
					tableBill.addCell("RATE");
					tableBill.addCell("IGST");
					tableBill.addCell("IGST AMT");
					tableBill.addCell("VALUE");
					
					int rowCount = (Integer)dtm.getRowCount();
					
					int i;
					
					for(i=0; i<rowCount; i++){
						
						Object oDescription = dtm.getValueAt(i, 0);
						Object oHsn = dtm.getValueAt(i, 1);
						Object oQuantity = dtm.getValueAt(i, 2);
						Object oRate = dtm.getValueAt(i, 3);
						Object oIGst = dtm.getValueAt(i, 4);
						Object oIAmt = dtm.getValueAt(i, 5);
						Object oValue = dtm.getValueAt(i, 6);
						
						
						String description = oDescription.toString();
						String hsn = oHsn.toString();
						String quantity = oQuantity.toString();
						String rate = oRate.toString();
						String iGst = oIGst.toString();
						String iAmt = oIAmt.toString();
						String value = oValue.toString();
					
						tableBill.addCell(description);
						tableBill.addCell(hsn);
						tableBill.addCell(quantity);
						tableBill.addCell(rate);
						tableBill.addCell(iGst);
						tableBill.addCell(iAmt);
						tableBill.addCell(value);
						
					}
					
					document.add(tableBill);
					
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					document.add(new Paragraph("==============================================================================================="));
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					
					document.add(new Paragraph(lblTotalQty.getText()+" : "+textFieldTotalQty.getText()));
					document.add(new Paragraph(lblSubTotal.getText()+" : "+textFieldSubTotal.getText()));
					document.add(new Paragraph(lblGrandTotal.getText()+" : "+textFieldGrandTotal.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN)));
					document.add(new Paragraph(lblNumberToWord.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN)));
					document.add(new Paragraph(lblForRaviTraders.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN)));
					
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					document.add(new Paragraph("==============================================================================================="));
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					
					document.add(new Paragraph("TAX SUMMARY : ", FontFactory.getFont(FontFactory.TIMES_ROMAN)));
					
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					
					PdfPTable tableSummary = new PdfPTable(3);
					
					tableSummary.addCell("TAX");
					tableSummary.addCell("T VALUE");
					tableSummary.addCell("IGST");
					
					tableSummary.addCell(label28.getText());
					tableSummary.addCell(textFieldTValue1.getText());
					tableSummary.addCell(textFieldIGst1.getText());
					
					tableSummary.addCell(label18.getText());
					tableSummary.addCell(textFieldTValue2.getText());
					tableSummary.addCell(textFieldIGst2.getText());
					
					tableSummary.addCell(label12.getText());
					tableSummary.addCell(textFieldTValue3.getText());
					tableSummary.addCell(textFieldIGst3.getText());
					
					tableSummary.addCell(label5.getText());
					tableSummary.addCell(textFieldTValue4.getText());
					tableSummary.addCell(textFieldIGst4.getText());
					
					tableSummary.addCell(label0.getText());
					tableSummary.addCell(textFieldTValue5.getText());
					tableSummary.addCell(textFieldIGst5.getText());
					
					tableSummary.addCell(lblTotal.getText());
					tableSummary.addCell(textFieldTValue.getText());
					tableSummary.addCell(textFieldIGst.getText());
					
					
					document.add(tableSummary);
					
					document.close();
					
					JOptionPane.showMessageDialog(null, "PDF Saved C Drive - TradeApp - PDFSTORE");
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (DocumentException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnSaveAsPdf.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSaveAsPdf.setBounds(284, 599, 124, 23);
		contentPane.add(btnSaveAsPdf);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(UIManager.getColor("Button.background"));
		btnAdd.setForeground(Color.BLUE);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vector<Object> v = new Vector<Object>();
				
				v.add(comboBox1.getSelectedItem().toString());
				v.add(textFieldForHsn1.getText());
				v.add(textFieldForQty1.getText());
				v.add(textFieldForRate1.getText());
				v.add(textFieldForIGst1.getText());
				v.add(textFieldForIAmt1.getText());
				v.add(textFieldForValue1.getText());
				
				dtm.addRow(v);
				
				clearValues();
				
				Integer totalQty = (Integer)totalQuantity();
				
				String totalQuantity = String.valueOf(totalQty);
				
				textFieldTotalQty.setText(totalQuantity);
				
				Double totalVal = (Double)totalValue();
				
				String totalValue = String.format("%.3f", totalVal);
				
				textFieldSubTotal.setText(totalValue);
				
				textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
				
				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
				
				Long numberToWord_ = (new Double(numToWord_).longValue());
				
				String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
				
				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
				
				taxSummary();
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(1064, 196, 110, 20);
		contentPane.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(UIManager.getColor("Button.background"));
		btnRemove.setForeground(Color.BLUE);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				
				dtm.removeRow(row);
				
				Integer totalQty = (Integer)totalQuantity();
				
				String totalQuantity = String.valueOf(totalQty);
				
				textFieldTotalQty.setText(totalQuantity);
				
				Double totalVal = (Double)totalValue();
				
				String totalValue = String.format("%.3f", totalVal);
				
				textFieldSubTotal.setText(totalValue);
				
				textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
				
				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());
				
				Long numberToWord_ = (new Double(numToWord_).longValue());
				
				String numberToWord = (String)EnglishNumberToWords.numberToWords(numberToWord_);
				
				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));
				
				taxSummary();
				
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRemove.setBounds(1064, 348, 110, 20);
		contentPane.add(btnRemove);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 240, 986, 252);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.GREEN);
		scrollPane.setViewportView(table);
		
		dtm = new DefaultTableModel();
		
		table.setModel(dtm);
		
		dtm.addColumn("Description");
		dtm.addColumn("Hsn");
		dtm.addColumn("Qty");
		dtm.addColumn("Rate");
		dtm.addColumn("IGst");
		dtm.addColumn("IAmt");
		dtm.addColumn("Value");
		
		taxSummary();
		
		getCompanyDetails();
		
		getCurrentDate();
		
		getBillNo();
		
	}
} 
