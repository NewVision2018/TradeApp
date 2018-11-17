package tradingapp3;

import java.awt.AWTException;
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

public class TradeSCGstBill extends JFrame {

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
					TradeSCGstBill frame = new TradeSCGstBill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	*//**
	 * Create the frame.
	 */
	
	Connection con = null;
	 JComboBox<String> comboBox1;
	 JLabel lblDescription;
	 JLabel lblHsn;
	 JLabel lblQty;
	 JLabel lblRate;
	 JLabel lblsgst;
	 JLabel lblAmt1;
	 JLabel lblcgst;
	 JLabel lblAmt2;
	 JLabel lblValue;
	 JTextField textFieldForHsn1;
	 JTextField textFieldForQty1;
	 JTextField textFieldForRate1;
	 JTextField textFieldForSGst1;
	 JTextField textFieldForSAmt1;
	 JTextField textFieldForCGst1;
	 JTextField textFieldForCAmt1;
	 JTextField textFieldForValue1;
	 JLabel lblTo;
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
	 JTextField textFieldSGst1;
	 JTextField textFieldSGst2;
	 JTextField textFieldSGst3;
	 JTextField textFieldSGst4;
	 JTextField textFieldSGst5;
	 JTextField textFieldCGst1;
	 JTextField textFieldCGst2;
	 JTextField textFieldCGst3;
	 JTextField textFieldCGst4;
	 JTextField textFieldCGst5;
	 JTextField textFieldTValue;
	 JTextField textFieldSGst;
	 JTextField textFieldCGst;
	 JLabel lblTotal;
	 JTextField textFieldForSearch1;
	 
	 JLabel lblCompanyName;
	 JLabel lblCompanyAddress;
	 JLabel lblCompanyGstin;
	 
	 JLabel label0;
	 JLabel label5;
	 JLabel label12;
	 JLabel label18;
	 JLabel label28;
	 
	 DefaultTableModel dtm;
	 
	 public void clearValues(){
		 
		 	comboBox1.removeAllItems();
		 	
		 	textFieldForHsn1.setText("0");
			
			textFieldForQty1.setText("0");
			
			textFieldForRate1.setText("0");
			
			textFieldForSGst1.setText("0");
			
			textFieldForSAmt1.setText("0");
			
			textFieldForCGst1.setText("0");
			
			textFieldForCAmt1.setText("0");
			
			textFieldForValue1.setText("0"); 
			
			textFieldForSearch1.setText("");
			
		}
	
	public void resetData(){
		
		comboBox1.removeAllItems();
		
		textFieldForHsn1.setText("0");
		
		textFieldForQty1.setText("0");
		
		textFieldForRate1.setText("0");
		
		textFieldForSGst1.setText("0");
		
		textFieldForSAmt1.setText("0");
		
		textFieldForCGst1.setText("0");
		
		textFieldForCAmt1.setText("0");
		
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
		
		textFieldSGst1.setText("0");
		textFieldSGst2.setText("0");
		textFieldSGst3.setText("0");
		textFieldSGst4.setText("0");
		textFieldSGst5.setText("0");
		
		textFieldCGst1.setText("0");
		textFieldCGst2.setText("0");
		textFieldCGst3.setText("0");
		textFieldCGst4.setText("0");
		textFieldCGst5.setText("0");
		
		textFieldTValue.setText("0");
		textFieldSGst.setText("0");
		textFieldCGst.setText("0");
		
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
			
			Object value = dtm.getValueAt(i, 8);
			
			Double val = Double.parseDouble(value.toString());
			
			totalValue = totalValue + val;
			
		}
		
		return totalValue;
		
	}
	
	public void taxSummary(){
		
		Double Gst[] = {};
		Double tValue[] = {};
		Double SGst[] = {};
		Double CGst[] = {};
		
		int rowCount = (Integer)dtm.getRowCount();
		
		Gst = new Double[rowCount];
		tValue = new Double[rowCount];
		SGst = new Double[rowCount];
		CGst = new Double[rowCount];
		
		int i;
		
		for(i=0; i<rowCount; i++){
			
			Object oQty = dtm.getValueAt(i, 2);
			
			Double qty = Double.parseDouble(oQty.toString());
			
			Object oRate = dtm.getValueAt(i, 3);
			
			Double rate = Double.parseDouble(oRate.toString());
			
			Double mulQtyRate = (qty*rate);
			
			Object oSGst = dtm.getValueAt(i, 4);
			
			Double sGst = Double.parseDouble(oSGst.toString());
			
			Object oCGst = dtm.getValueAt(i, 6);
			
			Double cGst = Double.parseDouble(oCGst.toString());
			
			Double gst = sGst + cGst;
			
			Object oSAmt = dtm.getValueAt(i, 5);
			
			Double sAmt = Double.parseDouble(oSAmt.toString());
			
			Object oCAmt = dtm.getValueAt(i, 7);
			
			Double cAmt = Double.parseDouble(oCAmt.toString());
			
			Gst[i] = gst;
			
			tValue[i] = mulQtyRate;
			
			SGst[i] = sAmt;
			
			CGst[i] = cAmt;
			
		}
		
		int a = 0;
		
		Double tValueTemp1 = 0.0;
		Double sGstTemp1 = 0.0;
		Double cGstTemp1 = 0.0;
		
		Double tValueTemp2 = 0.0;
		Double sGstTemp2 = 0.0;
		Double cGstTemp2 = 0.0;
		
		Double tValueTemp3 = 0.0;
		Double sGstTemp3 = 0.0;
		Double cGstTemp3 = 0.0;
		
		Double tValueTemp4 = 0.0;
		Double sGstTemp4 = 0.0;
		Double cGstTemp4 = 0.0;
		
		Double tValueTemp5 = 0.0;
		Double sGstTemp5 = 0.0;
		Double cGstTemp5 = 0.0;
		
		for(a=0; a<Gst.length; a++){
			
			if(Gst[a]==28){
				
				tValueTemp1 = tValueTemp1 + tValue[a];
				sGstTemp1 = sGstTemp1 + SGst[a];
				cGstTemp1 = cGstTemp1 + CGst[a];
				
			}else if(Gst[a]==18){
				
				tValueTemp2 = tValueTemp2 + tValue[a];
				sGstTemp2 = sGstTemp2 + SGst[a];
				cGstTemp2 = cGstTemp2 + CGst[a];
				
			}else if(Gst[a]==12){
				
				tValueTemp3 = tValueTemp3 + tValue[a];
				sGstTemp3 = sGstTemp3 + SGst[a];
				cGstTemp3 = cGstTemp3 + CGst[a];
				
			}else if(Gst[a]==5){
				
				tValueTemp4 = tValueTemp4 + tValue[a];
				sGstTemp4 = sGstTemp4 + SGst[a];
				cGstTemp4 = cGstTemp4 + CGst[a];
				
			}else if(Gst[a]==0){
				
				tValueTemp5 = tValueTemp5 + tValue[a];
				sGstTemp5 = sGstTemp5 + SGst[a];
				cGstTemp5 = cGstTemp5 + CGst[a];
				
			}
			
		}
		
		String tValueTemp_1 = String.format("%.2f", tValueTemp1);
		String tValueTemp_2 = String.format("%.2f", tValueTemp2);
		String tValueTemp_3 = String.format("%.2f", tValueTemp3);
		String tValueTemp_4 = String.format("%.2f", tValueTemp4);
		String tValueTemp_5 = String.format("%.2f", tValueTemp5);
		
		String sGstTemp_1 =String.format("%.2f", sGstTemp1);
		String sGstTemp_2 =String.format("%.2f", sGstTemp2);
		String sGstTemp_3 =String.format("%.2f", sGstTemp3);
		String sGstTemp_4 =String.format("%.2f", sGstTemp4);
		String sGstTemp_5 =String.format("%.2f", sGstTemp5);
		
		String cGstTemp_1 =String.format("%.2f", cGstTemp1);
		String cGstTemp_2 =String.format("%.2f", cGstTemp2);
		String cGstTemp_3 =String.format("%.2f", cGstTemp3);
		String cGstTemp_4 =String.format("%.2f", cGstTemp4);
		String cGstTemp_5 =String.format("%.2f", cGstTemp5);
		
		textFieldTValue1.setText(tValueTemp_1);
		textFieldTValue2.setText(tValueTemp_2);
		textFieldTValue3.setText(tValueTemp_3);
		textFieldTValue4.setText(tValueTemp_4);
		textFieldTValue5.setText(tValueTemp_5);
		
		textFieldSGst1.setText(sGstTemp_1);
		textFieldSGst2.setText(sGstTemp_2);
		textFieldSGst3.setText(sGstTemp_3);
		textFieldSGst4.setText(sGstTemp_4);
		textFieldSGst5.setText(sGstTemp_5);
		
		textFieldCGst1.setText(cGstTemp_1);
		textFieldCGst2.setText(cGstTemp_2);
		textFieldCGst3.setText(cGstTemp_3);
		textFieldCGst4.setText(cGstTemp_4);
		textFieldCGst5.setText(cGstTemp_5);
		
		Double tValueC = 0.0;
		
		Double tValue1 = Double.parseDouble((textFieldTValue1.getText()).toString());
		Double tValue2 = Double.parseDouble((textFieldTValue2.getText()).toString());
		Double tValue3 = Double.parseDouble((textFieldTValue3.getText()).toString());
		Double tValue4 = Double.parseDouble((textFieldTValue4.getText()).toString());
		Double tValue5 = Double.parseDouble((textFieldTValue5.getText()).toString());
		
		tValueC = (tValue1 + tValue2 + tValue3 + tValue4 + tValue5);
		
		String tVal = String.format("%.2f", tValueC);
		
		textFieldTValue.setText(tVal);
		
		Double sGst = 0.0;
		
		Double sGst1 = Double.parseDouble((textFieldSGst1.getText()).toString());
		Double sGst2 = Double.parseDouble((textFieldSGst2.getText()).toString());
		Double sGst3 = Double.parseDouble((textFieldSGst3.getText()).toString());
		Double sGst4 = Double.parseDouble((textFieldSGst4.getText()).toString());
		Double sGst5 = Double.parseDouble((textFieldSGst5.getText()).toString());
		
		sGst = (sGst1 + sGst2 + sGst3 + sGst4 + sGst5);
		
		String SGstC = String.format("%.2f", sGst);
		
		textFieldSGst.setText(SGstC);
		
		Double cGst = 0.0;
		
		Double cGst1 = Double.parseDouble((textFieldCGst1.getText()).toString());
		Double cGst2 = Double.parseDouble((textFieldCGst2.getText()).toString());
		Double cGst3 = Double.parseDouble((textFieldCGst3.getText()).toString());
		Double cGst4 = Double.parseDouble((textFieldCGst4.getText()).toString());
		Double cGst5 = Double.parseDouble((textFieldCGst5.getText()).toString());
		
		cGst = (cGst1 + cGst2 + cGst3 + cGst4 + cGst5);
		
		String CGstC = String.format("%.2f", cGst);
		
		textFieldCGst.setText(CGstC);
		
		/*
		
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
		
		Double gst1 = (Double.parseDouble(textFieldForSGst1.getText()))+(Double.parseDouble(textFieldForCGst1.getText()));
		Double gst2 = (Double.parseDouble(textFieldForSGst2.getText()))+(Double.parseDouble(textFieldForCGst2.getText()));
		Double gst3 = (Double.parseDouble(textFieldForSGst3.getText()))+(Double.parseDouble(textFieldForCGst3.getText()));
		Double gst4 = (Double.parseDouble(textFieldForSGst4.getText()))+(Double.parseDouble(textFieldForCGst4.getText()));
		Double gst5 = (Double.parseDouble(textFieldForSGst5.getText()))+(Double.parseDouble(textFieldForCGst5.getText()));
		Double gst6 = (Double.parseDouble(textFieldForSGst6.getText()))+(Double.parseDouble(textFieldForCGst6.getText()));
		Double gst7 = (Double.parseDouble(textFieldForSGst7.getText()))+(Double.parseDouble(textFieldForCGst7.getText()));
		Double gst8 = (Double.parseDouble(textFieldForSGst8.getText()))+(Double.parseDouble(textFieldForCGst8.getText()));
		Double gst9 = (Double.parseDouble(textFieldForSGst9.getText()))+(Double.parseDouble(textFieldForCGst9.getText()));
		Double gst10 = (Double.parseDouble(textFieldForSGst10.getText()))+(Double.parseDouble(textFieldForCGst10.getText()));
		
		Double sAmt1 = Double.parseDouble(textFieldForSAmt1.getText());
		Double sAmt2 = Double.parseDouble(textFieldForSAmt2.getText());
		Double sAmt3 = Double.parseDouble(textFieldForSAmt3.getText());
		Double sAmt4 = Double.parseDouble(textFieldForSAmt4.getText());
		Double sAmt5 = Double.parseDouble(textFieldForSAmt5.getText());
		Double sAmt6 = Double.parseDouble(textFieldForSAmt6.getText());
		Double sAmt7 = Double.parseDouble(textFieldForSAmt7.getText());
		Double sAmt8 = Double.parseDouble(textFieldForSAmt8.getText());
		Double sAmt9 = Double.parseDouble(textFieldForSAmt9.getText());
		Double sAmt10 = Double.parseDouble(textFieldForSAmt10.getText());
		
		Double cAmt1 = Double.parseDouble(textFieldForCAmt1.getText());
		Double cAmt2 = Double.parseDouble(textFieldForCAmt2.getText());
		Double cAmt3 = Double.parseDouble(textFieldForCAmt3.getText());
		Double cAmt4 = Double.parseDouble(textFieldForCAmt4.getText());
		Double cAmt5 = Double.parseDouble(textFieldForCAmt5.getText());
		Double cAmt6 = Double.parseDouble(textFieldForCAmt6.getText());
		Double cAmt7 = Double.parseDouble(textFieldForCAmt7.getText());
		Double cAmt8 = Double.parseDouble(textFieldForCAmt8.getText());
		Double cAmt9 = Double.parseDouble(textFieldForCAmt9.getText());
		Double cAmt10 = Double.parseDouble(textFieldForCAmt10.getText());
		
		Double gst[] = {gst1,gst2,gst3,gst4,gst5,gst6,gst7,gst8,gst9,gst10};
		
		Double tValue[] = {mulQtyRate1, mulQtyRate2, mulQtyRate3, mulQtyRate4, mulQtyRate5, mulQtyRate6, mulQtyRate7, mulQtyRate8, mulQtyRate9, mulQtyRate10};
		
		Double SGst[] = {sAmt1, sAmt2, sAmt3, sAmt4, sAmt5, sAmt6, sAmt7, sAmt8, sAmt9, sAmt10};
		
		Double CGst[] = {cAmt1, cAmt2, cAmt3, cAmt4, cAmt5, cAmt6, cAmt7, cAmt8, cAmt9, cAmt10};
		
		int i = 0;
		
		Double tValueTemp1 = 0.0;
		Double sGstTemp1 = 0.0;
		Double cGstTemp1 = 0.0;
		
		Double tValueTemp2 = 0.0;
		Double sGstTemp2 = 0.0;
		Double cGstTemp2 = 0.0;
		
		Double tValueTemp3 = 0.0;
		Double sGstTemp3 = 0.0;
		Double cGstTemp3 = 0.0;
		
		Double tValueTemp4 = 0.0;
		Double sGstTemp4 = 0.0;
		Double cGstTemp4 = 0.0;
		
		Double tValueTemp5 = 0.0;
		Double sGstTemp5 = 0.0;
		Double cGstTemp5 = 0.0;
		
		for(i=0; i<gst.length; i++){
			
			if(gst[i]==28){
				
				tValueTemp1 = tValueTemp1 + tValue[i];
				sGstTemp1 = sGstTemp1 + SGst[i];
				cGstTemp1 = cGstTemp1 + CGst[i];
				
			}else if(gst[i]==18){
				
				tValueTemp2 = tValueTemp2 + tValue[i];
				sGstTemp2 = sGstTemp2 + SGst[i];
				cGstTemp2 = cGstTemp2 + CGst[i];
				
			}else if(gst[i]==12){
				
				tValueTemp3 = tValueTemp3 + tValue[i];
				sGstTemp3 = sGstTemp3 + SGst[i];
				cGstTemp3 = cGstTemp3 + CGst[i];
				
			}else if(gst[i]==5){
				
				tValueTemp4 = tValueTemp4 + tValue[i];
				sGstTemp4 = sGstTemp4 + SGst[i];
				cGstTemp4 = cGstTemp4 + CGst[i];
				
			}else if(gst[i]==0){
				
				tValueTemp5 = tValueTemp5 + tValue[i];
				sGstTemp5 = sGstTemp5 + SGst[i];
				cGstTemp5 = cGstTemp5 + CGst[i];
				
			}
			
		}
		
		String tValueTemp_1 = String.format("%.2f", tValueTemp1);
		String tValueTemp_2 = String.format("%.2f", tValueTemp2);
		String tValueTemp_3 = String.format("%.2f", tValueTemp3);
		String tValueTemp_4 = String.format("%.2f", tValueTemp4);
		String tValueTemp_5 = String.format("%.2f", tValueTemp5);
		
		String sGstTemp_1 =String.format("%.2f", sGstTemp1);
		String sGstTemp_2 =String.format("%.2f", sGstTemp2);
		String sGstTemp_3 =String.format("%.2f", sGstTemp3);
		String sGstTemp_4 =String.format("%.2f", sGstTemp4);
		String sGstTemp_5 =String.format("%.2f", sGstTemp5);
		
		String cGstTemp_1 =String.format("%.2f", cGstTemp1);
		String cGstTemp_2 =String.format("%.2f", cGstTemp2);
		String cGstTemp_3 =String.format("%.2f", cGstTemp3);
		String cGstTemp_4 =String.format("%.2f", cGstTemp4);
		String cGstTemp_5 =String.format("%.2f", cGstTemp5);
		
		textFieldTValue1.setText(tValueTemp_1);
		textFieldTValue2.setText(tValueTemp_2);
		textFieldTValue3.setText(tValueTemp_3);
		textFieldTValue4.setText(tValueTemp_4);
		textFieldTValue5.setText(tValueTemp_5);
		
		textFieldSGst1.setText(sGstTemp_1);
		textFieldSGst2.setText(sGstTemp_2);
		textFieldSGst3.setText(sGstTemp_3);
		textFieldSGst4.setText(sGstTemp_4);
		textFieldSGst5.setText(sGstTemp_5);
		
		textFieldCGst1.setText(cGstTemp_1);
		textFieldCGst2.setText(cGstTemp_2);
		textFieldCGst3.setText(cGstTemp_3);
		textFieldCGst4.setText(cGstTemp_4);
		textFieldCGst5.setText(cGstTemp_5);
		
		Double tValueC = 0.0;
		
		Double tValue1 = Double.parseDouble((textFieldTValue1.getText()).toString());
		Double tValue2 = Double.parseDouble((textFieldTValue2.getText()).toString());
		Double tValue3 = Double.parseDouble((textFieldTValue3.getText()).toString());
		Double tValue4 = Double.parseDouble((textFieldTValue4.getText()).toString());
		Double tValue5 = Double.parseDouble((textFieldTValue5.getText()).toString());
		
		tValueC = (tValue1 + tValue2 + tValue3 + tValue4 + tValue5);
		
		String tVal = String.format("%.2f", tValueC);
		
		textFieldTValue.setText(tVal);
		
		Double sGst = 0.0;
		
		Double sGst1 = Double.parseDouble((textFieldSGst1.getText()).toString());
		Double sGst2 = Double.parseDouble((textFieldSGst2.getText()).toString());
		Double sGst3 = Double.parseDouble((textFieldSGst3.getText()).toString());
		Double sGst4 = Double.parseDouble((textFieldSGst4.getText()).toString());
		Double sGst5 = Double.parseDouble((textFieldSGst5.getText()).toString());
		
		sGst = (sGst1 + sGst2 + sGst3 + sGst4 + sGst5);
		
		String SGstC = String.format("%.2f", sGst);
		
		textFieldSGst.setText(SGstC);
		
		Double cGst = 0.0;
		
		Double cGst1 = Double.parseDouble((textFieldCGst1.getText()).toString());
		Double cGst2 = Double.parseDouble((textFieldCGst2.getText()).toString());
		Double cGst3 = Double.parseDouble((textFieldCGst3.getText()).toString());
		Double cGst4 = Double.parseDouble((textFieldCGst4.getText()).toString());
		Double cGst5 = Double.parseDouble((textFieldCGst5.getText()).toString());
		
		cGst = (cGst1 + cGst2 + cGst3 + cGst4 + cGst5);
		
		String CGstC = String.format("%.2f", cGst);
		
		textFieldCGst.setText(CGstC);
		
	*/}
	
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
				
			//	billNo = billNo +1;
				
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
			
			String query = "UPDATE Users SET DATE = ?, TAXABLE_VAL = ?, CGST = ?, SGST = ?, TOTAL_AMT = ? WHERE BILL_NO = ? AND GSTN = ?";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, textFieldDate.getText());
			pst.setString(2, textFieldTValue.getText());
			pst.setString(3, textFieldCGst.getText());
			pst.setString(4, textFieldSGst.getText());
			pst.setString(5, textFieldGrandTotal.getText());
			pst.setString(6, textFieldBillNo.getText());
			pst.setString(7, textFieldGstin.getText());
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "User Data Updated");
			
			pst.close();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void updateTaxData(){
		
		getBillNo();
		
		try{
			
			String query = "INSERT INTO TaxSummary(BILL_NO,NAME,GSTN,DATE,SALE_5,SGST_2_5,CGST_2_5,SALE_12,SGST_6,CGST_6,SALE_18,SGST_9,CGST_9,SALE_28,SGST_14,CGST_14) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, textFieldBillNo.getText());
			pst.setString(2, textFieldTo.getText());
			pst.setString(3, textFieldGstin.getText());
			pst.setString(4, textFieldDate.getText());
			pst.setString(5, textFieldTValue4.getText());
			pst.setString(6, textFieldSGst4.getText());
			pst.setString(7, textFieldCGst4.getText());
			pst.setString(8, textFieldTValue3.getText());
			pst.setString(9, textFieldSGst3.getText());
			pst.setString(10, textFieldCGst3.getText());
			pst.setString(11, textFieldTValue2.getText());
			pst.setString(12, textFieldSGst2.getText());
			pst.setString(13, textFieldCGst2.getText());
			pst.setString(14, textFieldTValue1.getText());
			pst.setString(15, textFieldSGst1.getText());
			pst.setString(16, textFieldCGst1.getText());
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Tax Data Updated");
			
			pst.close();
			
		}catch (Exception e1) {
			
			e1.printStackTrace();
			
		}
		
	}
	
	String name = "";
	
	String gstNo = "";
	private JButton btnUpdateb;
	private JTable table;
	
	public TradeSCGstBill(String name, String gstNo) {
		
		this.name = name;
		this.gstNo = gstNo;
		
		setTitle("TAX INVOICE CASH/CREDIT");
		con = SQLiteConnection.sqliteDbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(85, 5, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
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
						
						Double sgst_1 = (gst_1)/2;
						
						Double cgst_1 = (gst_1)/2;
						
						String sgst1 = Double.toString(sgst_1);
						
						String cgst1 = Double.toString(cgst_1);
						
						textFieldForSGst1.setText(sgst1);
						textFieldForCGst1.setText(cgst1);
						
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
		
		lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setBackground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(10, 156, 135, 14);
		contentPane.add(lblDescription);
		
		lblHsn = new JLabel("HSN");
		lblHsn.setHorizontalAlignment(SwingConstants.CENTER);
		lblHsn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHsn.setBackground(Color.WHITE);
		lblHsn.setBounds(168, 156, 135, 14);
		contentPane.add(lblHsn);
		
		lblQty = new JLabel("QTY");
		lblQty.setHorizontalAlignment(SwingConstants.CENTER);
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQty.setBackground(Color.WHITE);
		lblQty.setBounds(291, 156, 119, 14);
		contentPane.add(lblQty);
		
		lblRate = new JLabel("RATE");
		lblRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRate.setBackground(Color.WHITE);
		lblRate.setBounds(378, 156, 119, 14);
		contentPane.add(lblRate);
		
		lblsgst = new JLabel("%SGST");
		lblsgst.setHorizontalAlignment(SwingConstants.CENTER);
		lblsgst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblsgst.setBackground(Color.WHITE);
		lblsgst.setBounds(488, 156, 101, 14);
		contentPane.add(lblsgst);
		
		lblAmt1 = new JLabel("SGST AMT");
		lblAmt1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmt1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAmt1.setBackground(Color.WHITE);
		lblAmt1.setBounds(599, 156, 101, 14);
		contentPane.add(lblAmt1);
		
		lblcgst = new JLabel("%CGST");
		lblcgst.setHorizontalAlignment(SwingConstants.CENTER);
		lblcgst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcgst.setBackground(Color.WHITE);
		lblcgst.setBounds(701, 156, 101, 14);
		contentPane.add(lblcgst);
		
		lblAmt2 = new JLabel("CGST AMT");
		lblAmt2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmt2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAmt2.setBackground(Color.WHITE);
		lblAmt2.setBounds(786, 156, 101, 14);
		contentPane.add(lblAmt2);
		
		lblValue = new JLabel("VALUE");
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValue.setBackground(Color.WHITE);
		lblValue.setBounds(897, 156, 110, 14);
		contentPane.add(lblValue);
		
		textFieldForHsn1 = new JTextField();
		textFieldForHsn1.setBackground(Color.WHITE);
		textFieldForHsn1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForHsn1.setBounds(185, 197, 110, 20);
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
				String sgst1 = textFieldForSGst1.getText();
				String cgst1 = textFieldForCGst1.getText();
				
				Double qty_1 = Double.parseDouble(qty1);
				Double rate_1 = Double.parseDouble(rate1);
				Double sgst_1 = Double.parseDouble(sgst1);
				Double cgst_1 = Double.parseDouble(cgst1);
				
				Double mulQtyRate1 = (qty_1*rate_1);
				
				Double s_amt_1 = (sgst_1/100)*mulQtyRate1;
				Double c_amt_1 = (cgst_1/100)*mulQtyRate1;
				
				Double sum1 = mulQtyRate1 + s_amt_1 + c_amt_1;  
				
				String s_amt1 = String.format("%.2f", s_amt_1);
				String c_amt1 = String.format("%.2f", c_amt_1);
				String value1 = String.format("%.3f", sum1);
				
				textFieldForSAmt1.setText(s_amt1);
				textFieldForCAmt1.setText(c_amt1);
				textFieldForValue1.setText(value1);
				
			}
		});
		textFieldForQty1.setBounds(305, 197, 86, 20);
		contentPane.add(textFieldForQty1);
		textFieldForQty1.setColumns(10);
		
		textFieldForRate1 = new JTextField();
		textFieldForRate1.setBackground(Color.WHITE);
		textFieldForRate1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate1.setBounds(401, 197, 86, 20);
		contentPane.add(textFieldForRate1);
		textFieldForRate1.setColumns(10);
		textFieldForRate1.setText("0");
		
		textFieldForSGst1 = new JTextField();
		textFieldForSGst1.setBackground(Color.WHITE);
		textFieldForSGst1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSGst1.setBounds(497, 197, 86, 20);
		contentPane.add(textFieldForSGst1);
		textFieldForSGst1.setColumns(10);
		textFieldForSGst1.setText("0");
		
		textFieldForSAmt1 = new JTextField();
		textFieldForSAmt1.setBackground(Color.WHITE);
		textFieldForSAmt1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSAmt1.setBounds(605, 197, 86, 20);
		contentPane.add(textFieldForSAmt1);
		textFieldForSAmt1.setColumns(10);
		textFieldForSAmt1.setText("0");
		
		textFieldForCGst1 = new JTextField();
		textFieldForCGst1.setBackground(Color.WHITE);
		textFieldForCGst1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCGst1.setBounds(701, 197, 86, 20);
		contentPane.add(textFieldForCGst1);
		textFieldForCGst1.setColumns(10);
		textFieldForCGst1.setText("0");
		
		textFieldForCAmt1 = new JTextField();
		textFieldForCAmt1.setBackground(Color.WHITE);
		textFieldForCAmt1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCAmt1.setBounds(797, 197, 86, 20);
		contentPane.add(textFieldForCAmt1);
		textFieldForCAmt1.setColumns(10);
		textFieldForCAmt1.setText("0");
		
		textFieldForValue1 = new JTextField();
		textFieldForValue1.setBackground(Color.WHITE);
		textFieldForValue1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue1.setBounds(910, 197, 86, 20);
		contentPane.add(textFieldForValue1);
		textFieldForValue1.setColumns(10);
		textFieldForValue1.setText("0");
		
		lblTo = new JLabel("TO :");
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
		textFieldGstin.setBounds(757, 117, 327, 20);
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
		textFieldGrandTotal.setText("0.0");
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
					
					String query = "UPDATE Users SET DATE = ?, TAXABLE_VAL = ?, CGST = ?, SGST = ?, TOTAL_AMT = ? WHERE BILL_NO = ? AND GSTN = ?";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, textFieldDate.getText());
					pst.setString(2, textFieldTValue.getText());
					pst.setString(3, textFieldCGst.getText());
					pst.setString(4, textFieldSGst.getText());
					pst.setString(5, textFieldGrandTotal.getText());
					pst.setString(6, textFieldBillNo.getText());
					pst.setString(7, textFieldGstin.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "User Data Updated");
					
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
		
		JLabel lblSgst = new JLabel("SGST");
		lblSgst.setHorizontalAlignment(SwingConstants.CENTER);
		lblSgst.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSgst.setBounds(150, 540, 46, 14);
		contentPane.add(lblSgst);
		
		JLabel lblCgst = new JLabel("CGST");
		lblCgst.setHorizontalAlignment(SwingConstants.CENTER);
		lblCgst.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCgst.setBounds(218, 540, 46, 14);
		contentPane.add(lblCgst);
		
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
		
		textFieldSGst1 = new JTextField();
		textFieldSGst1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSGst1.setBackground(Color.WHITE);
		textFieldSGst1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldSGst1.setColumns(10);
		textFieldSGst1.setBounds(150, 562, 46, 14);
		textFieldSGst1.setText("0");
		contentPane.add(textFieldSGst1);
		
		textFieldSGst2 = new JTextField();
		textFieldSGst2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSGst2.setBackground(Color.WHITE);
		textFieldSGst2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldSGst2.setColumns(10);
		textFieldSGst2.setBounds(150, 582, 46, 14);
		textFieldSGst2.setText("0");
		contentPane.add(textFieldSGst2);
		
		textFieldSGst3 = new JTextField();
		textFieldSGst3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSGst3.setBackground(Color.WHITE);
		textFieldSGst3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldSGst3.setColumns(10);
		textFieldSGst3.setBounds(150, 605, 46, 14);
		textFieldSGst3.setText("0");
		contentPane.add(textFieldSGst3);
		
		textFieldSGst4 = new JTextField();
		textFieldSGst4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSGst4.setBackground(Color.WHITE);
		textFieldSGst4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldSGst4.setColumns(10);
		textFieldSGst4.setBounds(150, 630, 46, 14);
		textFieldSGst4.setText("0");
		contentPane.add(textFieldSGst4);
		
		textFieldSGst5 = new JTextField();
		textFieldSGst5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSGst5.setBackground(Color.WHITE);
		textFieldSGst5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldSGst5.setColumns(10);
		textFieldSGst5.setBounds(150, 648, 46, 14);
		textFieldSGst5.setText("0");
		contentPane.add(textFieldSGst5);
		
		textFieldCGst1 = new JTextField();
		textFieldCGst1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCGst1.setBackground(Color.WHITE);
		textFieldCGst1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldCGst1.setColumns(10);
		textFieldCGst1.setBounds(218, 562, 46, 14);
		textFieldCGst1.setText("0");
		contentPane.add(textFieldCGst1);
		
		textFieldCGst2 = new JTextField();
		textFieldCGst2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCGst2.setBackground(Color.WHITE);
		textFieldCGst2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldCGst2.setColumns(10);
		textFieldCGst2.setBounds(218, 582, 46, 14);
		textFieldCGst2.setText("0");
		contentPane.add(textFieldCGst2);
		
		textFieldCGst3 = new JTextField();
		textFieldCGst3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCGst3.setBackground(Color.WHITE);
		textFieldCGst3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldCGst3.setColumns(10);
		textFieldCGst3.setBounds(218, 605, 46, 14);
		textFieldCGst3.setText("0");
		contentPane.add(textFieldCGst3);
		
		textFieldCGst4 = new JTextField();
		textFieldCGst4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCGst4.setBackground(Color.WHITE);
		textFieldCGst4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldCGst4.setColumns(10);
		textFieldCGst4.setBounds(218, 630, 46, 14);
		textFieldCGst4.setText("0");
		contentPane.add(textFieldCGst4);
		
		textFieldCGst5 = new JTextField();
		textFieldCGst5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCGst5.setBackground(Color.WHITE);
		textFieldCGst5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldCGst5.setColumns(10);
		textFieldCGst5.setBounds(218, 648, 46, 14);
		textFieldCGst5.setText("0");
		contentPane.add(textFieldCGst5);
		
		textFieldTValue = new JTextField();
		textFieldTValue.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTValue.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldTValue.setColumns(10);
		textFieldTValue.setBackground(Color.WHITE);
		textFieldTValue.setBounds(81, 669, 46, 18);
		contentPane.add(textFieldTValue);
		
		textFieldSGst = new JTextField();
		textFieldSGst.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSGst.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldSGst.setColumns(10);
		textFieldSGst.setBackground(Color.WHITE);
		textFieldSGst.setBounds(150, 669, 46, 18);
		contentPane.add(textFieldSGst);
		
		textFieldCGst = new JTextField();
		textFieldCGst.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCGst.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldCGst.setColumns(10);
		textFieldCGst.setBackground(Color.WHITE);
		textFieldCGst.setBounds(218, 669, 46, 18);
		contentPane.add(textFieldCGst);
		
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
		
		label28 = new JLabel("28%");
		label28.setHorizontalAlignment(SwingConstants.CENTER);
		label28.setFont(new Font("Tahoma", Font.BOLD, 11));
		label28.setBounds(10, 562, 46, 14);
		contentPane.add(label28);
		
		label18 = new JLabel("18%");
		label18.setHorizontalAlignment(SwingConstants.CENTER);
		label18.setFont(new Font("Tahoma", Font.BOLD, 11));
		label18.setBounds(10, 585, 46, 14);
		contentPane.add(label18);
		
		label12 = new JLabel("12%");
		label12.setHorizontalAlignment(SwingConstants.CENTER);
		label12.setFont(new Font("Tahoma", Font.BOLD, 11));
		label12.setBounds(10, 605, 46, 14);
		contentPane.add(label12);
		
		label5 = new JLabel("5%");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label5.setBounds(10, 630, 46, 14);
		contentPane.add(label5);
		
		label0 = new JLabel("0%");
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
				
				String screen = textFieldBillNo.getText();
				
				try {
					
					Robot robot = new Robot();
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
					
					Rectangle rectangle = new Rectangle(dimension);
					
					BufferedImage img = robot.createScreenCapture(rectangle);
					
					ImageIO.write(img, "jpg", new File("C:/TradeApp/AppImages/"+screen+".jpg"));
					
					JOptionPane.showMessageDialog(null, "Snapshot taken C Drive - TradeApp - AppImages");
					
				} catch (AWTException | IOException e) {
					
					e.printStackTrace();
				
				}
				
			}
		});
		btnSnapShot.setBounds(367, 557, 130, 20);
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
		btnReset.setBounds(776, 663, 77, 20);
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
				
				List<String> textFieldForSGst = new ArrayList<String>();
				
				List<String> textFieldForSAmt = new ArrayList<String>();
				
				List<String> textFieldForCGst = new ArrayList<String>();
				
				List<String> textFieldForCAmt = new ArrayList<String>();
				
				List<String> textFieldForValue = new ArrayList<String>();
				
				for(i=0; i<rowCount; i++){
					
					Object oDescription = dtm.getValueAt(i, 0);
					Object oHsn = dtm.getValueAt(i, 1);
					Object oQuantity = dtm.getValueAt(i, 2);
					Object oRate = dtm.getValueAt(i, 3);
					Object oSGst = dtm.getValueAt(i, 4);
					Object oSAmt = dtm.getValueAt(i, 5);
					Object oCGst = dtm.getValueAt(i, 6);
					Object oCAmt = dtm.getValueAt(i, 7);
					Object oValue = dtm.getValueAt(i, 8);
					
					
					String description = oDescription.toString();
					String hsn = oHsn.toString();
					String quantity = oQuantity.toString();
					String rate = oRate.toString();
					String sGst = oSGst.toString();
					String sAmt = oSAmt.toString();
					String cGst = oCGst.toString();
					String cAmt = oCAmt.toString();
					String value = oValue.toString();
					
					comboBox[i] = description;
					textFieldForHsn.add(hsn);
					textFieldForQty.add(quantity);
					textFieldForRate.add(rate);
					textFieldForSGst.add(sGst);
					textFieldForSAmt.add(sAmt);
					textFieldForCGst.add(cGst);
					textFieldForCAmt.add(cAmt);
					textFieldForValue.add(value);
					
				}
				
				trp.setComboBox(comboBox);
				
				trp.setTextFieldForHsn(textFieldForHsn);
				
				trp.setTextFieldForQty(textFieldForQty);
				
				trp.setTextFieldForRate(textFieldForRate);
				
				trp.setTextFieldForSGst(textFieldForSGst);
				
				trp.setTextFieldForSAmt(textFieldForSAmt);
				
				trp.setTextFieldForCGst(textFieldForCGst);
				
				trp.setTextFieldForCAmt(textFieldForCAmt);
				
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
				
				trp.setTextFieldSGst1(textFieldSGst1.getText().toString());
				trp.setTextFieldSGst2(textFieldSGst2.getText().toString());
				trp.setTextFieldSGst3(textFieldSGst3.getText().toString());
				trp.setTextFieldSGst4(textFieldSGst4.getText().toString());
				trp.setTextFieldSGst5(textFieldSGst5.getText().toString());
				
				trp.setTextFieldCGst1(textFieldCGst1.getText().toString());
				trp.setTextFieldCGst2(textFieldCGst2.getText().toString());
				trp.setTextFieldCGst3(textFieldCGst3.getText().toString());
				trp.setTextFieldCGst4(textFieldCGst4.getText().toString());
				trp.setTextFieldCGst5(textFieldCGst5.getText().toString());
				
				trp.setTextFieldTValue(textFieldTValue.getText().toString());
				trp.setTextFieldSGst(textFieldSGst.getText().toString());
				trp.setTextFieldCGst(textFieldCGst.getText().toString());
				
				trp.setLabelTitle1(lblCompanyName.getText().toString());
				trp.setLabelTitle2(lblCompanyAddress.getText().toString());
				trp.setLabelTitle3(lblCompanyGstin.getText().toString());
				
				trp.setLblNumberToWord(lblNumberToWord.getText().toString());
				
				trp.setCompanySignature(lblForRaviTraders.getText().toString());
				
				TradeSCGstBillReceipt tbr = new TradeSCGstBillReceipt(trp);
				
				tbr.setVisible(true);
				
				dispose();
				
			}
		});
		btnReceipt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReceipt.setBounds(367, 643, 130, 20);
		contentPane.add(btnReceipt);
		
		JButton btnSaveAsPdf = new JButton("Save As Pdf");
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
					
					PdfPTable tableBill = new PdfPTable(9);
					
					tableBill.addCell("PRODUCT");
					tableBill.addCell("HSN");
					tableBill.addCell("QTY");
					tableBill.addCell("RATE");
					tableBill.addCell("SGST");
					tableBill.addCell("SGST AMT");
					tableBill.addCell("CGST");
					tableBill.addCell("CGST AMT");
					tableBill.addCell("VALUE");
					
					int rowCount = (Integer)dtm.getRowCount();
					
					int i;
					
					for(i=0; i<rowCount; i++){
						
						Object oDescription = dtm.getValueAt(i, 0);
						Object oHsn = dtm.getValueAt(i, 1);
						Object oQuantity = dtm.getValueAt(i, 2);
						Object oRate = dtm.getValueAt(i, 3);
						Object oSGst = dtm.getValueAt(i, 4);
						Object oSAmt = dtm.getValueAt(i, 5);
						Object oCGst = dtm.getValueAt(i, 6);
						Object oCAmt = dtm.getValueAt(i, 7);
						Object oValue = dtm.getValueAt(i, 8);
						
						
						String description = oDescription.toString();
						String hsn = oHsn.toString();
						String quantity = oQuantity.toString();
						String rate = oRate.toString();
						String sGst = oSGst.toString();
						String sAmt = oSAmt.toString();
						String cGst = oCGst.toString();
						String cAmt = oCAmt.toString();
						String value = oValue.toString();
					
						tableBill.addCell(description);
						tableBill.addCell(hsn);
						tableBill.addCell(quantity);
						tableBill.addCell(rate);
						tableBill.addCell(sGst);
						tableBill.addCell(sAmt);
						tableBill.addCell(cGst);
						tableBill.addCell(cAmt);
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
					
					PdfPTable tableSummary = new PdfPTable(4);
					
					tableSummary.addCell("TAX");
					tableSummary.addCell("T VALUE");
					tableSummary.addCell("SGST");
					tableSummary.addCell("CGST");
					
					tableSummary.addCell(label28.getText());
					tableSummary.addCell(textFieldTValue1.getText());
					tableSummary.addCell(textFieldSGst1.getText());
					tableSummary.addCell(textFieldCGst1.getText());
					
					tableSummary.addCell(label18.getText());
					tableSummary.addCell(textFieldTValue2.getText());
					tableSummary.addCell(textFieldSGst2.getText());
					tableSummary.addCell(textFieldCGst2.getText());
					
					tableSummary.addCell(label12.getText());
					tableSummary.addCell(textFieldTValue3.getText());
					tableSummary.addCell(textFieldSGst3.getText());
					tableSummary.addCell(textFieldCGst3.getText());
					
					tableSummary.addCell(label5.getText());
					tableSummary.addCell(textFieldTValue4.getText());
					tableSummary.addCell(textFieldSGst4.getText());
					tableSummary.addCell(textFieldCGst4.getText());
					
					tableSummary.addCell(label0.getText());
					tableSummary.addCell(textFieldTValue5.getText());
					tableSummary.addCell(textFieldSGst5.getText());
					tableSummary.addCell(textFieldCGst5.getText());
					
					tableSummary.addCell(lblTotal.getText());
					tableSummary.addCell(textFieldTValue.getText());
					tableSummary.addCell(textFieldSGst.getText());
					tableSummary.addCell(textFieldCGst.getText());
					
					
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
		btnSaveAsPdf.setBounds(367, 599, 130, 23);
		contentPane.add(btnSaveAsPdf);
		
		/*btnUpdateb = new JButton("Update B");
		btnUpdateb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getBillNo();
				
				try{
					
					String query = "INSERT INTO TaxSummary(BILL_NO,NAME,GSTN,DATE,SALE_5,SGST_2_5,CGST_2_5,SALE_12,SGST_6,CGST_6,SALE_18,SGST_9,CGST_9,SALE_28,SGST_14,CGST_14) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, textFieldBillNo.getText());
					pst.setString(2, textFieldTo.getText());
					pst.setString(3, textFieldGstin.getText());
					pst.setString(4, textFieldDate.getText());
					pst.setString(5, textFieldTValue4.getText());
					pst.setString(6, textFieldSGst4.getText());
					pst.setString(7, textFieldCGst4.getText());
					pst.setString(8, textFieldTValue3.getText());
					pst.setString(9, textFieldSGst3.getText());
					pst.setString(10, textFieldCGst3.getText());
					pst.setString(11, textFieldTValue2.getText());
					pst.setString(12, textFieldSGst2.getText());
					pst.setString(13, textFieldCGst2.getText());
					pst.setString(14, textFieldTValue1.getText());
					pst.setString(15, textFieldSGst1.getText());
					pst.setString(16, textFieldCGst1.getText());
					
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
				v.add(textFieldForSGst1.getText());
				v.add(textFieldForSAmt1.getText());
				v.add(textFieldForCGst1.getText());
				v.add(textFieldForCAmt1.getText());
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
		dtm.addColumn("SGst");
		dtm.addColumn("SAmt");
		dtm.addColumn("CGst");
		dtm.addColumn("CAmt");
		dtm.addColumn("Value");
		
		taxSummary();
		
		getCompanyDetails();
		
		getCurrentDate();
		
		getBillNo();
		
	}
} 
