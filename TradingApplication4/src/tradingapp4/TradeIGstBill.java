package tradingapp4;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

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

public class TradeIGstBill extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	 JComboBox<String> comboBox2;
	 JComboBox<String> comboBox3;
	 JComboBox<String> comboBox4;
	 JComboBox<String> comboBox5;
	 JComboBox<String> comboBox6;
	 JComboBox<String> comboBox7;
	 JComboBox<String> comboBox8;
	 JComboBox<String> comboBox9;
	 JComboBox<String> comboBox10;
	 JLabel lblHsn;
	 JLabel lblQty;
	 JLabel lblRate;
	 JLabel lbligst;
	 JLabel lblAmt1;
	 JLabel lblValue;
	 JTextField textFieldForHsn1;
	 JTextField textFieldForHsn2;
	 JTextField textFieldForHsn3;
	 JTextField textFieldForHsn4;
	 JTextField textFieldForHsn5;
	 JTextField textFieldForHsn6;
	 JTextField textFieldForHsn7;
	 JTextField textFieldForHsn8;
	 JTextField textFieldForHsn9;
	 JTextField textFieldForHsn10;
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
	 JTextField textFieldForIGst1;
	 JTextField textFieldForIGst2;
	 JTextField textFieldForIGst3;
	 JTextField textFieldForIGst4;
	 JTextField textFieldForIGst5;
	 JTextField textFieldForIGst6;
	 JTextField textFieldForIGst7;
	 JTextField textFieldForIGst8;
	 JTextField textFieldForIGst9;
	 JTextField textFieldForIGst10;
	 JTextField textFieldForIAmt1;
	 JTextField textFieldForIAmt2;
	 JTextField textFieldForIAmt3;
	 JTextField textFieldForIAmt4;
	 JTextField textFieldForIAmt5;
	 JTextField textFieldForIAmt6;
	 JTextField textFieldForIAmt7;
	 JTextField textFieldForIAmt8;
	 JTextField textFieldForIAmt9;
	 JTextField textFieldForIAmt10;
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
	 JTextField textFieldForSearch2;
	 JTextField textFieldForSearch3;
	 JTextField textFieldForSearch4;
	 JTextField textFieldForSearch5;
	 JTextField textFieldForSearch6;
	 JTextField textFieldForSearch7;
	 JTextField textFieldForSearch8;
	 JTextField textFieldForSearch9;
	 JTextField textFieldForSearch10;
	 
	 JLabel lblCompanyName;
	 JLabel lblCompanyAddress;
	 JLabel lblCompanyGstin;
	
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
		
		textFieldForHsn1.setText("0");
		textFieldForHsn2.setText("0");
		textFieldForHsn3.setText("0");
		textFieldForHsn4.setText("0");
		textFieldForHsn5.setText("0");
		textFieldForHsn6.setText("0");
		textFieldForHsn7.setText("0");
		textFieldForHsn8.setText("0");
		textFieldForHsn9.setText("0");
		textFieldForHsn10.setText("0");
		
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
		
		textFieldForIGst1.setText("0");
		textFieldForIGst2.setText("0");
		textFieldForIGst3.setText("0");
		textFieldForIGst4.setText("0");
		textFieldForIGst5.setText("0");
		textFieldForIGst6.setText("0");
		textFieldForIGst7.setText("0");
		textFieldForIGst8.setText("0");
		textFieldForIGst9.setText("0");
		textFieldForIGst10.setText("0");
		
		textFieldForIAmt1.setText("0");
		textFieldForIAmt2.setText("0");
		textFieldForIAmt3.setText("0");
		textFieldForIAmt4.setText("0");
		textFieldForIAmt5.setText("0");
		textFieldForIAmt6.setText("0");
		textFieldForIAmt7.setText("0");
		textFieldForIAmt8.setText("0");
		textFieldForIAmt9.setText("0");
		textFieldForIAmt10.setText("0");
		
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
		
		textFieldTo.setText(name);
		textAreaAddress.setText("");
		textFieldGstin.setText(gstNo);
		
		textFieldSubTotal.setText("0");
		textFieldTotalQty.setText("0");
		textFieldGrandTotal.setText("0");
		
		textFieldBillNo.setText("");
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
	
	public void taxSummary(){
		
		Double qty1 = Double.parseDouble(textFieldForQty1.getText());
		Double qty2 = Double.parseDouble(textFieldForQty2.getText());
		Double qty3 = Double.parseDouble(textFieldForQty3.getText());
		Double qty4 = Double.parseDouble(textFieldForQty4.getText());
		Double qty5 = Double.parseDouble(textFieldForQty5.getText());
		Double qty6 = Double.parseDouble(textFieldForQty6.getText());
		Double qty7 = Double.parseDouble(textFieldForQty7.getText());
		Double qty8 = Double.parseDouble(textFieldForQty8.getText());
		Double qty9 = Double.parseDouble(textFieldForQty9.getText());
		Double qty10 = Double.parseDouble(textFieldForQty10.getText());
		
		Double rate1 = Double.parseDouble(textFieldForRate1.getText());
		Double rate2 = Double.parseDouble(textFieldForRate2.getText());
		Double rate3 = Double.parseDouble(textFieldForRate3.getText());
		Double rate4 = Double.parseDouble(textFieldForRate4.getText());
		Double rate5 = Double.parseDouble(textFieldForRate5.getText());
		Double rate6 = Double.parseDouble(textFieldForRate6.getText());
		Double rate7 = Double.parseDouble(textFieldForRate7.getText());
		Double rate8 = Double.parseDouble(textFieldForRate8.getText());
		Double rate9 = Double.parseDouble(textFieldForRate9.getText());
		Double rate10 = Double.parseDouble(textFieldForRate10.getText());
		
		Double mulQtyRate1 = (qty1*rate1);
		Double mulQtyRate2 = (qty2*rate2);
		Double mulQtyRate3 = (qty3*rate3);
		Double mulQtyRate4 = (qty4*rate4);
		Double mulQtyRate5 = (qty5*rate5);
		Double mulQtyRate6 = (qty6*rate6);
		Double mulQtyRate7 = (qty7*rate7);
		Double mulQtyRate8 = (qty8*rate8);
		Double mulQtyRate9 = (qty9*rate9);
		Double mulQtyRate10 = (qty10*rate10);
		
		Double gst1 = (Double.parseDouble(textFieldForIGst1.getText()));
		Double gst2 = (Double.parseDouble(textFieldForIGst2.getText()));
		Double gst3 = (Double.parseDouble(textFieldForIGst3.getText()));
		Double gst4 = (Double.parseDouble(textFieldForIGst4.getText()));
		Double gst5 = (Double.parseDouble(textFieldForIGst5.getText()));
		Double gst6 = (Double.parseDouble(textFieldForIGst6.getText()));
		Double gst7 = (Double.parseDouble(textFieldForIGst7.getText()));
		Double gst8 = (Double.parseDouble(textFieldForIGst8.getText()));
		Double gst9 = (Double.parseDouble(textFieldForIGst9.getText()));
		Double gst10 = (Double.parseDouble(textFieldForIGst10.getText()));
		
		Double iAmt1 = Double.parseDouble(textFieldForIAmt1.getText());
		Double iAmt2 = Double.parseDouble(textFieldForIAmt2.getText());
		Double iAmt3 = Double.parseDouble(textFieldForIAmt3.getText());
		Double iAmt4 = Double.parseDouble(textFieldForIAmt4.getText());
		Double iAmt5 = Double.parseDouble(textFieldForIAmt5.getText());
		Double iAmt6 = Double.parseDouble(textFieldForIAmt6.getText());
		Double iAmt7 = Double.parseDouble(textFieldForIAmt7.getText());
		Double iAmt8 = Double.parseDouble(textFieldForIAmt8.getText());
		Double iAmt9 = Double.parseDouble(textFieldForIAmt9.getText());
		Double iAmt10 = Double.parseDouble(textFieldForIAmt10.getText());
		
		Double gst[] = {gst1,gst2,gst3,gst4,gst5,gst6,gst7,gst8,gst9,gst10};
		
		Double tValue[] = {mulQtyRate1, mulQtyRate2, mulQtyRate3, mulQtyRate4, mulQtyRate5, mulQtyRate6, mulQtyRate7, mulQtyRate8, mulQtyRate9, mulQtyRate10};
		
		Double IGst[] = {iAmt1, iAmt2, iAmt3, iAmt4, iAmt5, iAmt6, iAmt7, iAmt8, iAmt9, iAmt10};
		
		int i = 0;
		
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
		
		for(i=0; i<gst.length; i++){
			
			if(gst[i]==28){
				
				tValueTemp1 = tValueTemp1 + tValue[i];
				iGstTemp1 = iGstTemp1 + IGst[i];
				
			}else if(gst[i]==18){
				
				tValueTemp2 = tValueTemp2 + tValue[i];
				iGstTemp2 = iGstTemp2 + IGst[i];
				
			}else if(gst[i]==12){
				
				tValueTemp3 = tValueTemp3 + tValue[i];
				iGstTemp3 = iGstTemp3 + IGst[i];
				
			}else if(gst[i]==5){
				
				tValueTemp4 = tValueTemp4 + tValue[i];
				iGstTemp4 = iGstTemp4 + IGst[i];
				
			}else if(gst[i]==0){
				
				tValueTemp5 = tValueTemp5 + tValue[i];
				iGstTemp5 = iGstTemp5 + IGst[i];
				
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
				
				String billNum = Integer.toString(billNo);
				
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
						
						textFieldForHsn2.setText(rs.getString("HSN"));
						textFieldForRate2.setText(rs.getString("RATE"));
						
						String gst2 = rs.getString("GST");
						
						Double gst_2 = Double.parseDouble(gst2);
						
						String igst2 = Double.toString(gst_2);
						
						textFieldForIGst2.setText(igst2);
						
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
						
						textFieldForHsn3.setText(rs.getString("HSN"));
						textFieldForRate3.setText(rs.getString("RATE"));
						
						String gst3 = rs.getString("GST");
						
						Double gst_3 = Double.parseDouble(gst3);
						
						String igst3 = Double.toString(gst_3);
						
						textFieldForIGst3.setText(igst3);
						
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
						
						textFieldForHsn4.setText(rs.getString("HSN"));
						textFieldForRate4.setText(rs.getString("RATE"));
						
						String gst4 = rs.getString("GST");
						
						Double gst_4 = Double.parseDouble(gst4);
						
						String igst4 = Double.toString(gst_4);
						
						textFieldForIGst4.setText(igst4);
						
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
						
						textFieldForHsn5.setText(rs.getString("HSN"));
						textFieldForRate5.setText(rs.getString("RATE"));
						
						String gst5 = rs.getString("GST");
						
						Double gst_5 = Double.parseDouble(gst5);
						
						String igst5 = Double.toString(gst_5);
						
						textFieldForIGst5.setText(igst5);
					
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
						
						textFieldForHsn6.setText(rs.getString("HSN"));
						textFieldForRate6.setText(rs.getString("RATE"));
						
						String gst6 = rs.getString("GST");
						
						Double gst_6 = Double.parseDouble(gst6);
						
						String igst6 = Double.toString(gst_6);
					
						textFieldForIGst6.setText(igst6);
									
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
						
						textFieldForHsn7.setText(rs.getString("HSN"));
						textFieldForRate7.setText(rs.getString("RATE"));
						
						String gst7 = rs.getString("GST");
						
						Double gst_7 = Double.parseDouble(gst7);
						
						String igst7 = Double.toString(gst_7);
						
						textFieldForIGst7.setText(igst7);
						
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
						
						textFieldForHsn8.setText(rs.getString("HSN"));
						textFieldForRate8.setText(rs.getString("RATE"));
						
						String gst8 = rs.getString("GST");
						
						Double gst_8 = Double.parseDouble(gst8);
						
						String igst8 = Double.toString(gst_8);
					
						textFieldForIGst8.setText(igst8);
						
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
						
						textFieldForHsn9.setText(rs.getString("HSN"));
						textFieldForRate9.setText(rs.getString("RATE"));
						
						String gst9 = rs.getString("GST");
						
						Double gst_9 = Double.parseDouble(gst9);
						
						String igst9 = Double.toString(gst_9);
						
						textFieldForIGst9.setText(igst9);
						
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
						
						textFieldForHsn10.setText(rs.getString("HSN"));
						textFieldForRate10.setText(rs.getString("RATE"));
						
						String gst10 = rs.getString("GST");
						
						Double gst_10 = Double.parseDouble(gst10);
						
						String igst10 = Double.toString(gst_10);
						
						textFieldForIGst10.setText(igst10);
						
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
		lblHsn.setBounds(201, 156, 135, 14);
		contentPane.add(lblHsn);
		
		lblQty = new JLabel("QTY");
		lblQty.setHorizontalAlignment(SwingConstants.CENTER);
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQty.setBackground(Color.WHITE);
		lblQty.setBounds(378, 156, 119, 14);
		contentPane.add(lblQty);
		
		lblRate = new JLabel("RATE");
		lblRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRate.setBackground(Color.WHITE);
		lblRate.setBounds(547, 156, 119, 14);
		contentPane.add(lblRate);
		
		lbligst = new JLabel("%IGST");
		lbligst.setHorizontalAlignment(SwingConstants.CENTER);
		lbligst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbligst.setBackground(Color.WHITE);
		lbligst.setBounds(719, 156, 101, 14);
		contentPane.add(lbligst);
		
		lblAmt1 = new JLabel("IGST AMT");
		lblAmt1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmt1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAmt1.setBackground(Color.WHITE);
		lblAmt1.setBounds(878, 156, 101, 14);
		contentPane.add(lblAmt1);
		
		lblValue = new JLabel("VALUE");
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValue.setBackground(Color.WHITE);
		lblValue.setBounds(1064, 156, 110, 14);
		contentPane.add(lblValue);
		
		textFieldForHsn1 = new JTextField();
		textFieldForHsn1.setBackground(Color.WHITE);
		textFieldForHsn1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn1.setBounds(215, 197, 110, 20);
		contentPane.add(textFieldForHsn1);
		textFieldForHsn1.setColumns(10);
		
		textFieldForHsn2 = new JTextField();
		textFieldForHsn2.setBackground(Color.WHITE);
		textFieldForHsn2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn2.setColumns(10);
		textFieldForHsn2.setBounds(215, 228, 110, 20);
		contentPane.add(textFieldForHsn2);
		
		textFieldForHsn3 = new JTextField();
		textFieldForHsn3.setBackground(Color.WHITE);
		textFieldForHsn3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn3.setColumns(10);
		textFieldForHsn3.setBounds(215, 259, 110, 20);
		contentPane.add(textFieldForHsn3);
		
		textFieldForHsn4 = new JTextField();
		textFieldForHsn4.setBackground(Color.WHITE);
		textFieldForHsn4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn4.setColumns(10);
		textFieldForHsn4.setBounds(215, 290, 110, 20);
		contentPane.add(textFieldForHsn4);
		
		textFieldForHsn5 = new JTextField();
		textFieldForHsn5.setBackground(Color.WHITE);
		textFieldForHsn5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn5.setColumns(10);
		textFieldForHsn5.setBounds(215, 321, 110, 20);
		contentPane.add(textFieldForHsn5);
		
		textFieldForHsn6 = new JTextField();
		textFieldForHsn6.setBackground(Color.WHITE);
		textFieldForHsn6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn6.setColumns(10);
		textFieldForHsn6.setBounds(215, 352, 110, 20);
		contentPane.add(textFieldForHsn6);
		
		textFieldForHsn7 = new JTextField();
		textFieldForHsn7.setBackground(Color.WHITE);
		textFieldForHsn7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn7.setColumns(10);
		textFieldForHsn7.setBounds(215, 383, 110, 20);
		contentPane.add(textFieldForHsn7);
		
		textFieldForHsn8 = new JTextField();
		textFieldForHsn8.setBackground(Color.WHITE);
		textFieldForHsn8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn8.setColumns(10);
		textFieldForHsn8.setBounds(215, 414, 110, 20);
		contentPane.add(textFieldForHsn8);
		
		textFieldForHsn9 = new JTextField();
		textFieldForHsn9.setBackground(Color.WHITE);
		textFieldForHsn9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn9.setColumns(10);
		textFieldForHsn9.setBounds(215, 445, 110, 20);
		contentPane.add(textFieldForHsn9);
		
		textFieldForHsn10 = new JTextField();
		textFieldForHsn10.setBackground(Color.WHITE);
		textFieldForHsn10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn10.setColumns(10);
		textFieldForHsn10.setBounds(215, 476, 110, 20);
		contentPane.add(textFieldForHsn10);
		
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
		textFieldForQty1.setBounds(403, 197, 86, 20);
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
				String igst2 = textFieldForIGst2.getText();
				
				Double qty_2 = Double.parseDouble(qty2);
				Double rate_2 = Double.parseDouble(rate2);
				Double igst_2 = Double.parseDouble(igst2);
				
				Double mulQtyRate2 = (qty_2*rate_2);
				
				Double i_amt_2 = (igst_2/100)*mulQtyRate2;
				
				Double sum2 = mulQtyRate2 + i_amt_2;  
				
				String i_amt2 = String.format("%.2f", i_amt_2);
				String value2 = String.format("%.3f", sum2);
				
				textFieldForIAmt2.setText(i_amt2);
				textFieldForValue2.setText(value2);
				
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
		textFieldForQty2.setColumns(10);
		textFieldForQty2.setBounds(403, 228, 86, 20);
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
				String igst3 = textFieldForIGst3.getText();
				
				Double qty_3 = Double.parseDouble(qty3);
				Double rate_3 = Double.parseDouble(rate3);
				Double igst_3 = Double.parseDouble(igst3);
				
				Double mulQtyRate3 = (qty_3*rate_3);
				
				Double i_amt_3 = (igst_3/100)*mulQtyRate3;
				
				Double sum3 = mulQtyRate3 + i_amt_3;  
				
				String i_amt3 = String.format("%.2f", i_amt_3);
				String value3 = String.format("%.3f", sum3);
				
				textFieldForIAmt3.setText(i_amt3);
				textFieldForValue3.setText(value3);
				
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
		textFieldForQty3.setColumns(10);
		textFieldForQty3.setBounds(403, 259, 86, 20);
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
				String igst4 = textFieldForIGst4.getText();
				
				Double qty_4 = Double.parseDouble(qty4);
				Double rate_4 = Double.parseDouble(rate4);
				Double igst_4 = Double.parseDouble(igst4);
				
				Double mulQtyRate4 = (qty_4*rate_4);
				
				Double i_amt_4 = (igst_4/100)*mulQtyRate4;
				
				Double sum4 = mulQtyRate4 + i_amt_4;  
				
				String i_amt4 = String.format("%.2f", i_amt_4);
				String value4 = String.format("%.3f", sum4);
				
				textFieldForIAmt4.setText(i_amt4);
				textFieldForValue4.setText(value4);
				
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
		textFieldForQty4.setColumns(10);
		textFieldForQty4.setBounds(403, 290, 86, 20);
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
				String igst5 = textFieldForIGst5.getText();
				
				Double qty_5 = Double.parseDouble(qty5);
				Double rate_5 = Double.parseDouble(rate5);
				Double igst_5 = Double.parseDouble(igst5);
				
				Double mulQtyRate5 = (qty_5*rate_5);
				
				Double i_amt_5 = (igst_5/100)*mulQtyRate5;
				
				Double sum5 = mulQtyRate5 + i_amt_5;  
				
				String i_amt5 = String.format("%.2f", i_amt_5);
				String value5 = String.format("%.3f", sum5);
				
				textFieldForIAmt5.setText(i_amt5);
				textFieldForValue5.setText(value5);
				
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
		textFieldForQty5.setColumns(10);
		textFieldForQty5.setBounds(403, 321, 86, 20);
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
				String igst6 = textFieldForIGst6.getText();
				
				Double qty_6 = Double.parseDouble(qty6);
				Double rate_6 = Double.parseDouble(rate6);
				Double igst_6 = Double.parseDouble(igst6);
				
				Double mulQtyRate6 = (qty_6*rate_6);
				
				Double i_amt_6 = (igst_6/100)*mulQtyRate6;
				
				Double sum6 = mulQtyRate6 + i_amt_6;  
				
				String i_amt6 = String.format("%.2f", i_amt_6);
				String value6 = String.format("%.3f", sum6);
				
				textFieldForIAmt6.setText(i_amt6);
				textFieldForValue6.setText(value6);
				
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
		textFieldForQty6.setColumns(10);
		textFieldForQty6.setBounds(403, 352, 86, 20);
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
				String igst7 = textFieldForIGst7.getText();
				
				Double qty_7 = Double.parseDouble(qty7);
				Double rate_7 = Double.parseDouble(rate7);
				Double igst_7 = Double.parseDouble(igst7);
				
				Double mulQtyRate7 = (qty_7*rate_7);
				
				Double i_amt_7 = (igst_7/100)*mulQtyRate7;
				
				Double sum7 = mulQtyRate7 + i_amt_7;  
				
				String i_amt7 = String.format("%.2f", i_amt_7);
				String value7 = String.format("%.3f", sum7);
				
				textFieldForIAmt7.setText(i_amt7);
				textFieldForValue7.setText(value7);
				
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
		textFieldForQty7.setColumns(10);
		textFieldForQty7.setBounds(403, 383, 86, 20);
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
				String igst8 = textFieldForIGst8.getText();
				
				Double qty_8 = Double.parseDouble(qty8);
				Double rate_8 = Double.parseDouble(rate8);
				Double igst_8 = Double.parseDouble(igst8);
				
				Double mulQtyRate8 = (qty_8*rate_8);
				
				Double i_amt_8 = (igst_8/100)*mulQtyRate8;
				
				Double sum8 = mulQtyRate8 + i_amt_8;  
				
				String i_amt8 = String.format("%.2f", i_amt_8);
				String value8 = String.format("%.3f", sum8);
				
				textFieldForIAmt8.setText(i_amt8);
				textFieldForValue8.setText(value8);
				
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
		textFieldForQty8.setColumns(10);
		textFieldForQty8.setBounds(403, 414, 86, 20);
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
				String igst9 = textFieldForIGst9.getText();
				
				Double qty_9 = Double.parseDouble(qty9);
				Double rate_9 = Double.parseDouble(rate9);
				Double igst_9 = Double.parseDouble(igst9);
				
				Double mulQtyRate9 = (qty_9*rate_9);
				
				Double i_amt_9 = (igst_9/100)*mulQtyRate9;
				
				Double sum9 = mulQtyRate9 + i_amt_9;  
				
				String i_amt9 = String.format("%.2f", i_amt_9);
				String value9 = String.format("%.3f", sum9);
				
				textFieldForIAmt9.setText(i_amt9);
				textFieldForValue9.setText(value9);
				
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
		textFieldForQty9.setColumns(10);
		textFieldForQty9.setBounds(403, 445, 86, 20);
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
				String igst10 = textFieldForIGst10.getText();
				
				Double qty_10 = Double.parseDouble(qty10);
				Double rate_10 = Double.parseDouble(rate10);
				Double igst_10 = Double.parseDouble(igst10);
				
				Double mulQtyRate10 = (qty_10*rate_10);
				
				Double i_amt_10 = (igst_10/100)*mulQtyRate10;
				
				Double sum10 = mulQtyRate10 + i_amt_10;  
				
				String i_amt10 = String.format("%.2f", i_amt_10);
				String value10 = String.format("%.3f", sum10);
				
				textFieldForIAmt10.setText(i_amt10);
				textFieldForValue10.setText(value10);
				
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
		textFieldForQty10.setColumns(10);
		textFieldForQty10.setBounds(403, 476, 86, 20);
		contentPane.add(textFieldForQty10);
		
		textFieldForRate1 = new JTextField();
		textFieldForRate1.setBackground(Color.WHITE);
		textFieldForRate1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate1.setBounds(568, 197, 86, 20);
		contentPane.add(textFieldForRate1);
		textFieldForRate1.setColumns(10);
		textFieldForRate1.setText("0");
		
		textFieldForRate2 = new JTextField();
		textFieldForRate2.setBackground(Color.WHITE);
		textFieldForRate2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate2.setColumns(10);
		textFieldForRate2.setBounds(568, 228, 86, 20);
		contentPane.add(textFieldForRate2);
		textFieldForRate2.setText("0");
		
		textFieldForRate3 = new JTextField();
		textFieldForRate3.setBackground(Color.WHITE);
		textFieldForRate3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate3.setColumns(10);
		textFieldForRate3.setBounds(568, 259, 86, 20);
		contentPane.add(textFieldForRate3);
		textFieldForRate3.setText("0");
		
		textFieldForRate4 = new JTextField();
		textFieldForRate4.setBackground(Color.WHITE);
		textFieldForRate4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate4.setColumns(10);
		textFieldForRate4.setBounds(568, 290, 86, 20);
		contentPane.add(textFieldForRate4);
		textFieldForRate4.setText("0");
		
		textFieldForRate5 = new JTextField();
		textFieldForRate5.setBackground(Color.WHITE);
		textFieldForRate5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate5.setColumns(10);
		textFieldForRate5.setBounds(568, 321, 86, 20);
		contentPane.add(textFieldForRate5);
		textFieldForRate5.setText("0");
		
		textFieldForRate6 = new JTextField();
		textFieldForRate6.setBackground(Color.WHITE);
		textFieldForRate6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate6.setColumns(10);
		textFieldForRate6.setBounds(568, 352, 86, 20);
		contentPane.add(textFieldForRate6);
		textFieldForRate6.setText("0");
		
		textFieldForRate7 = new JTextField();
		textFieldForRate7.setBackground(Color.WHITE);
		textFieldForRate7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate7.setColumns(10);
		textFieldForRate7.setBounds(568, 383, 86, 20);
		contentPane.add(textFieldForRate7);
		textFieldForRate7.setText("0");
		
		textFieldForRate8 = new JTextField();
		textFieldForRate8.setBackground(Color.WHITE);
		textFieldForRate8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate8.setColumns(10);
		textFieldForRate8.setBounds(568, 414, 86, 20);
		contentPane.add(textFieldForRate8);
		textFieldForRate8.setText("0");
		
		textFieldForRate9 = new JTextField();
		textFieldForRate9.setBackground(Color.WHITE);
		textFieldForRate9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate9.setColumns(10);
		textFieldForRate9.setBounds(568, 445, 86, 20);
		contentPane.add(textFieldForRate9);
		textFieldForRate9.setText("0");
		
		textFieldForRate10 = new JTextField();
		textFieldForRate10.setBackground(Color.WHITE);
		textFieldForRate10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate10.setColumns(10);
		textFieldForRate10.setBounds(568, 476, 86, 20);
		contentPane.add(textFieldForRate10);
		textFieldForRate10.setText("0");
		
		textFieldForIGst1 = new JTextField();
		textFieldForIGst1.setBackground(Color.WHITE);
		textFieldForIGst1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIGst1.setBounds(734, 197, 86, 20);
		contentPane.add(textFieldForIGst1);
		textFieldForIGst1.setColumns(10);
		textFieldForIGst1.setText("0");
		
		textFieldForIGst2 = new JTextField();
		textFieldForIGst2.setBackground(Color.WHITE);
		textFieldForIGst2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIGst2.setColumns(10);
		textFieldForIGst2.setBounds(734, 228, 86, 20);
		contentPane.add(textFieldForIGst2);
		textFieldForIGst2.setText("0");
		
		textFieldForIGst3 = new JTextField();
		textFieldForIGst3.setBackground(Color.WHITE);
		textFieldForIGst3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIGst3.setColumns(10);
		textFieldForIGst3.setBounds(734, 259, 86, 20);
		contentPane.add(textFieldForIGst3);
		textFieldForIGst3.setText("0");
		
		textFieldForIGst4 = new JTextField();
		textFieldForIGst4.setBackground(Color.WHITE);
		textFieldForIGst4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIGst4.setColumns(10);
		textFieldForIGst4.setBounds(734, 290, 86, 20);
		contentPane.add(textFieldForIGst4);
		textFieldForIGst4.setText("0");
		
		textFieldForIGst5 = new JTextField();
		textFieldForIGst5.setBackground(Color.WHITE);
		textFieldForIGst5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIGst5.setColumns(10);
		textFieldForIGst5.setBounds(734, 321, 86, 20);
		contentPane.add(textFieldForIGst5);
		textFieldForIGst5.setText("0");
		
		textFieldForIGst6 = new JTextField();
		textFieldForIGst6.setBackground(Color.WHITE);
		textFieldForIGst6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIGst6.setColumns(10);
		textFieldForIGst6.setBounds(734, 352, 86, 20);
		contentPane.add(textFieldForIGst6);
		textFieldForIGst6.setText("0");
		
		textFieldForIGst7 = new JTextField();
		textFieldForIGst7.setBackground(Color.WHITE);
		textFieldForIGst7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIGst7.setColumns(10);
		textFieldForIGst7.setBounds(734, 383, 86, 20);
		contentPane.add(textFieldForIGst7);
		textFieldForIGst7.setText("0");
		
		textFieldForIGst8 = new JTextField();
		textFieldForIGst8.setBackground(Color.WHITE);
		textFieldForIGst8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIGst8.setColumns(10);
		textFieldForIGst8.setBounds(734, 414, 86, 20);
		contentPane.add(textFieldForIGst8);
		textFieldForIGst8.setText("0");
		
		textFieldForIGst9 = new JTextField();
		textFieldForIGst9.setBackground(Color.WHITE);
		textFieldForIGst9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIGst9.setColumns(10);
		textFieldForIGst9.setBounds(734, 445, 86, 20);
		contentPane.add(textFieldForIGst9);
		textFieldForIGst9.setText("0");
		
		textFieldForIGst10 = new JTextField();
		textFieldForIGst10.setBackground(Color.WHITE);
		textFieldForIGst10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIGst10.setColumns(10);
		textFieldForIGst10.setBounds(734, 476, 86, 20);
		contentPane.add(textFieldForIGst10);
		textFieldForIGst10.setText("0");
		
		textFieldForIAmt1 = new JTextField();
		textFieldForIAmt1.setBackground(Color.WHITE);
		textFieldForIAmt1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIAmt1.setBounds(893, 197, 86, 20);
		contentPane.add(textFieldForIAmt1);
		textFieldForIAmt1.setColumns(10);
		textFieldForIAmt1.setText("0");
		
		textFieldForIAmt2 = new JTextField();
		textFieldForIAmt2.setBackground(Color.WHITE);
		textFieldForIAmt2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIAmt2.setColumns(10);
		textFieldForIAmt2.setBounds(893, 228, 86, 20);
		contentPane.add(textFieldForIAmt2);
		textFieldForIAmt2.setText("0");
		
		textFieldForIAmt3 = new JTextField();
		textFieldForIAmt3.setBackground(Color.WHITE);
		textFieldForIAmt3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIAmt3.setColumns(10);
		textFieldForIAmt3.setBounds(893, 259, 86, 20);
		contentPane.add(textFieldForIAmt3);
		textFieldForIAmt3.setText("0");
		
		textFieldForIAmt4 = new JTextField();
		textFieldForIAmt4.setBackground(Color.WHITE);
		textFieldForIAmt4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIAmt4.setColumns(10);
		textFieldForIAmt4.setBounds(893, 290, 86, 20);
		contentPane.add(textFieldForIAmt4);
		textFieldForIAmt4.setText("0");
		
		textFieldForIAmt5 = new JTextField();
		textFieldForIAmt5.setBackground(Color.WHITE);
		textFieldForIAmt5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIAmt5.setColumns(10);
		textFieldForIAmt5.setBounds(893, 321, 86, 20);
		contentPane.add(textFieldForIAmt5);
		textFieldForIAmt5.setText("0");
		
		textFieldForIAmt6 = new JTextField();
		textFieldForIAmt6.setBackground(Color.WHITE);
		textFieldForIAmt6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIAmt6.setColumns(10);
		textFieldForIAmt6.setBounds(893, 352, 86, 20);
		contentPane.add(textFieldForIAmt6);
		textFieldForIAmt6.setText("0");
		
		textFieldForIAmt7 = new JTextField();
		textFieldForIAmt7.setBackground(Color.WHITE);
		textFieldForIAmt7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIAmt7.setColumns(10);
		textFieldForIAmt7.setBounds(893, 383, 86, 20);
		contentPane.add(textFieldForIAmt7);
		textFieldForIAmt7.setText("0");
		
		textFieldForIAmt8 = new JTextField();
		textFieldForIAmt8.setBackground(Color.WHITE);
		textFieldForIAmt8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIAmt8.setColumns(10);
		textFieldForIAmt8.setBounds(893, 414, 86, 20);
		contentPane.add(textFieldForIAmt8);
		textFieldForIAmt8.setText("0");
		
		textFieldForIAmt9 = new JTextField();
		textFieldForIAmt9.setBackground(Color.WHITE);
		textFieldForIAmt9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIAmt9.setColumns(10);
		textFieldForIAmt9.setBounds(893, 445, 86, 20);
		contentPane.add(textFieldForIAmt9);
		textFieldForIAmt9.setText("0");
		
		textFieldForIAmt10 = new JTextField();
		textFieldForIAmt10.setBackground(Color.WHITE);
		textFieldForIAmt10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForIAmt10.setColumns(10);
		textFieldForIAmt10.setBounds(893, 476, 86, 20);
		contentPane.add(textFieldForIAmt10);
		textFieldForIAmt10.setText("0");
		
		textFieldForValue1 = new JTextField();
		textFieldForValue1.setBackground(Color.WHITE);
		textFieldForValue1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue1.setBounds(1088, 197, 86, 20);
		contentPane.add(textFieldForValue1);
		textFieldForValue1.setColumns(10);
		textFieldForValue1.setText("0");
		
		textFieldForValue2 = new JTextField();
		textFieldForValue2.setBackground(Color.WHITE);
		textFieldForValue2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue2.setColumns(10);
		textFieldForValue2.setBounds(1088, 228, 86, 20);
		contentPane.add(textFieldForValue2);
		textFieldForValue2.setText("0");
		
		textFieldForValue3 = new JTextField();
		textFieldForValue3.setBackground(Color.WHITE);
		textFieldForValue3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue3.setColumns(10);
		textFieldForValue3.setBounds(1088, 259, 86, 20);
		contentPane.add(textFieldForValue3);
		textFieldForValue3.setText("0");
		
		textFieldForValue4 = new JTextField();
		textFieldForValue4.setBackground(Color.WHITE);
		textFieldForValue4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue4.setColumns(10);
		textFieldForValue4.setBounds(1088, 290, 86, 20);
		contentPane.add(textFieldForValue4);
		textFieldForValue4.setText("0");
		
		textFieldForValue5 = new JTextField();
		textFieldForValue5.setBackground(Color.WHITE);
		textFieldForValue5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue5.setColumns(10);
		textFieldForValue5.setBounds(1088, 321, 86, 20);
		contentPane.add(textFieldForValue5);
		textFieldForValue5.setText("0");
		
		textFieldForValue6 = new JTextField();
		textFieldForValue6.setBackground(Color.WHITE);
		textFieldForValue6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue6.setColumns(10);
		textFieldForValue6.setBounds(1088, 352, 86, 20);
		contentPane.add(textFieldForValue6);
		textFieldForValue6.setText("0");
		
		textFieldForValue7 = new JTextField();
		textFieldForValue7.setBackground(Color.WHITE);
		textFieldForValue7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue7.setColumns(10);
		textFieldForValue7.setBounds(1088, 383, 86, 20);
		contentPane.add(textFieldForValue7);
		textFieldForValue7.setText("0");
		
		textFieldForValue8 = new JTextField();
		textFieldForValue8.setBackground(Color.WHITE);
		textFieldForValue8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue8.setColumns(10);
		textFieldForValue8.setBounds(1088, 414, 86, 20);
		contentPane.add(textFieldForValue8);
		textFieldForValue8.setText("0");
		
		textFieldForValue9 = new JTextField();
		textFieldForValue9.setBackground(Color.WHITE);
		textFieldForValue9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue9.setColumns(10);
		textFieldForValue9.setBounds(1088, 445, 86, 20);
		contentPane.add(textFieldForValue9);
		textFieldForValue9.setText("0");
		
		textFieldForValue10 = new JTextField();
		textFieldForValue10.setBackground(Color.WHITE);
		textFieldForValue10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue10.setColumns(10);
		textFieldForValue10.setBounds(1088, 476, 86, 20);
		contentPane.add(textFieldForValue10);
		textFieldForValue10.setText("0");
		
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
		
		textFieldBillNo = new JTextField("");
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
		
		Integer totalQty = (Integer)totalQuantity();
		
		String totalQuantity = String.valueOf(totalQty);
		
		textFieldTotalQty.setText(totalQuantity);
		
		Double totalVal = (Double)totalValue();
		
		String totalValue = String.format("%.3f", totalVal);
		
		textFieldSubTotal.setText(totalValue);
		
		textFieldGrandTotal.setText((textFieldSubTotal.getText()).toString());
		
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
		btnSnapShot.setBounds(259, 557, 124, 20);
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
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateUserData();
				
				updateTaxData();
				
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
				
				trp.setTextFieldForHsn1(textFieldForHsn1.getText().toString());
				trp.setTextFieldForHsn2(textFieldForHsn2.getText().toString());
				trp.setTextFieldForHsn3(textFieldForHsn3.getText().toString());
				trp.setTextFieldForHsn4(textFieldForHsn4.getText().toString());
				trp.setTextFieldForHsn5(textFieldForHsn5.getText().toString());
				trp.setTextFieldForHsn6(textFieldForHsn6.getText().toString());
				trp.setTextFieldForHsn7(textFieldForHsn7.getText().toString());
				trp.setTextFieldForHsn8(textFieldForHsn8.getText().toString());
				trp.setTextFieldForHsn9(textFieldForHsn9.getText().toString());
				trp.setTextFieldForHsn10(textFieldForHsn10.getText().toString());
				
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
				
				trp.setTextFieldForIGst1(textFieldForIGst1.getText().toString());
				trp.setTextFieldForIGst2(textFieldForIGst2.getText().toString());
				trp.setTextFieldForIGst3(textFieldForIGst3.getText().toString());
				trp.setTextFieldForIGst4(textFieldForIGst4.getText().toString());
				trp.setTextFieldForIGst5(textFieldForIGst5.getText().toString());
				trp.setTextFieldForIGst6(textFieldForIGst6.getText().toString());
				trp.setTextFieldForIGst7(textFieldForIGst7.getText().toString());
				trp.setTextFieldForIGst8(textFieldForIGst8.getText().toString());
				trp.setTextFieldForIGst9(textFieldForIGst9.getText().toString());
				trp.setTextFieldForIGst10(textFieldForIGst10.getText().toString());
				
				trp.setTextFieldForIAmt1(textFieldForIAmt1.getText().toString());
				trp.setTextFieldForIAmt2(textFieldForIAmt2.getText().toString());
				trp.setTextFieldForIAmt3(textFieldForIAmt3.getText().toString());
				trp.setTextFieldForIAmt4(textFieldForIAmt4.getText().toString());
				trp.setTextFieldForIAmt5(textFieldForIAmt5.getText().toString());
				trp.setTextFieldForIAmt6(textFieldForIAmt6.getText().toString());
				trp.setTextFieldForIAmt7(textFieldForIAmt7.getText().toString());
				trp.setTextFieldForIAmt8(textFieldForIAmt8.getText().toString());
				trp.setTextFieldForIAmt9(textFieldForIAmt9.getText().toString());
				trp.setTextFieldForIAmt10(textFieldForIAmt10.getText().toString());
				
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
		btnReceipt.setBounds(259, 643, 124, 20);
		contentPane.add(btnReceipt);
		
		btnSaveAsPdf = new JButton("Save As Pdf");
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
					
					tableBill.addCell(comboBox1.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn1.getText());
					tableBill.addCell(textFieldForQty1.getText());
					tableBill.addCell(textFieldForRate1.getText());
					tableBill.addCell(textFieldForIGst1.getText());
					tableBill.addCell(textFieldForIAmt1.getText());
					tableBill.addCell(textFieldForValue1.getText());
					
					
					tableBill.addCell(comboBox2.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn2.getText());
					tableBill.addCell(textFieldForQty2.getText());
					tableBill.addCell(textFieldForRate2.getText());
					tableBill.addCell(textFieldForIGst2.getText());
					tableBill.addCell(textFieldForIAmt2.getText());
					tableBill.addCell(textFieldForValue2.getText());
					
					
					tableBill.addCell(comboBox3.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn3.getText());
					tableBill.addCell(textFieldForQty3.getText());
					tableBill.addCell(textFieldForRate3.getText());
					tableBill.addCell(textFieldForIGst3.getText());
					tableBill.addCell(textFieldForIAmt3.getText());
					tableBill.addCell(textFieldForValue3.getText());
					
					
					tableBill.addCell(comboBox4.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn4.getText());
					tableBill.addCell(textFieldForQty4.getText());
					tableBill.addCell(textFieldForRate4.getText());
					tableBill.addCell(textFieldForIGst4.getText());
					tableBill.addCell(textFieldForIAmt5.getText());
					tableBill.addCell(textFieldForValue4.getText());
					
					
					tableBill.addCell(comboBox5.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn5.getText());
					tableBill.addCell(textFieldForQty5.getText());
					tableBill.addCell(textFieldForRate5.getText());
					tableBill.addCell(textFieldForIGst5.getText());
					tableBill.addCell(textFieldForIAmt5.getText());
					tableBill.addCell(textFieldForValue5.getText());
					
					
					tableBill.addCell(comboBox6.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn6.getText());
					tableBill.addCell(textFieldForQty6.getText());
					tableBill.addCell(textFieldForRate6.getText());
					tableBill.addCell(textFieldForIGst6.getText());
					tableBill.addCell(textFieldForIAmt6.getText());
					tableBill.addCell(textFieldForValue6.getText());
					
					
					tableBill.addCell(comboBox7.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn7.getText());
					tableBill.addCell(textFieldForQty7.getText());
					tableBill.addCell(textFieldForIGst7.getText());
					tableBill.addCell(textFieldForIAmt7.getText());
					tableBill.addCell(textFieldForValue7.getText());
					
					
					tableBill.addCell(comboBox8.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn8.getText());
					tableBill.addCell(textFieldForQty8.getText());
					tableBill.addCell(textFieldForRate8.getText());
					tableBill.addCell(textFieldForIGst8.getText());
					tableBill.addCell(textFieldForIAmt8.getText());
					tableBill.addCell(textFieldForValue8.getText());
					
					
					tableBill.addCell(comboBox9.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn9.getText());
					tableBill.addCell(textFieldForQty9.getText());
					tableBill.addCell(textFieldForRate9.getText());
					tableBill.addCell(textFieldForIGst9.getText());
					tableBill.addCell(textFieldForIAmt9.getText());
					tableBill.addCell(textFieldForValue9.getText());
					
					
					tableBill.addCell(comboBox10.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn10.getText());
					tableBill.addCell(textFieldForQty10.getText());
					tableBill.addCell(textFieldForRate10.getText());
					tableBill.addCell(textFieldForIGst10.getText());
					tableBill.addCell(textFieldForIAmt10.getText());
					tableBill.addCell(textFieldForValue10.getText());
					
					
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
		btnSaveAsPdf.setBounds(259, 599, 124, 23);
		contentPane.add(btnSaveAsPdf);
		
		taxSummary();
		
		getCompanyDetails();
		
		getCurrentDate();
		
		getBillNo();
		
	}
} 
