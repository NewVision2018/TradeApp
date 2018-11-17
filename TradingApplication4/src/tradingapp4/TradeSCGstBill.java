package tradingapp4;

import java.awt.AWTException;
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
	 JComboBox<String> comboBox2;
	 JComboBox<String> comboBox3;
	 JComboBox<String> comboBox4;
	 JComboBox<String> comboBox5;
	 JComboBox<String> comboBox6;
	 JComboBox<String> comboBox7;
	 JComboBox<String> comboBox8;
	 JComboBox<String> comboBox9;
	 JComboBox<String> comboBox10;
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
	 JTextField textFieldForSGst1;
	 JTextField textFieldForSGst2;
	 JTextField textFieldForSGst3;
	 JTextField textFieldForSGst4;
	 JTextField textFieldForSGst5;
	 JTextField textFieldForSGst6;
	 JTextField textFieldForSGst7;
	 JTextField textFieldForSGst8;
	 JTextField textFieldForSGst9;
	 JTextField textFieldForSGst10;
	 JTextField textFieldForSAmt1;
	 JTextField textFieldForSAmt2;
	 JTextField textFieldForSAmt3;
	 JTextField textFieldForSAmt4;
	 JTextField textFieldForSAmt5;
	 JTextField textFieldForSAmt6;
	 JTextField textFieldForSAmt7;
	 JTextField textFieldForSAmt8;
	 JTextField textFieldForSAmt9;
	 JTextField textFieldForSAmt10;
	 JTextField textFieldForCGst1;
	 JTextField textFieldForCGst2;
	 JTextField textFieldForCGst3;
	 JTextField textFieldForCGst4;
	 JTextField textFieldForCGst5;
	 JTextField textFieldForCGst6;
	 JTextField textFieldForCGst7;
	 JTextField textFieldForCGst8;
	 JTextField textFieldForCGst9;
	 JTextField textFieldForCGst10;
	 JTextField textFieldForCAmt1;
	 JTextField textFieldForCAmt2;
	 JTextField textFieldForCAmt3;
	 JTextField textFieldForCAmt4;
	 JTextField textFieldForCAmt5;
	 JTextField textFieldForCAmt6;
	 JTextField textFieldForCAmt7;
	 JTextField textFieldForCAmt8;
	 JTextField textFieldForCAmt9;
	 JTextField textFieldForCAmt10;
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
	 
	 JLabel label0;
	 JLabel label5;
	 JLabel label12;
	 JLabel label18;
	 JLabel label28;
	
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
		
		textFieldForSGst1.setText("0");
		textFieldForSGst2.setText("0");
		textFieldForSGst3.setText("0");
		textFieldForSGst4.setText("0");
		textFieldForSGst5.setText("0");
		textFieldForSGst6.setText("0");
		textFieldForSGst7.setText("0");
		textFieldForSGst8.setText("0");
		textFieldForSGst9.setText("0");
		textFieldForSGst10.setText("0");
		
		textFieldForSAmt1.setText("0");
		textFieldForSAmt2.setText("0");
		textFieldForSAmt3.setText("0");
		textFieldForSAmt4.setText("0");
		textFieldForSAmt5.setText("0");
		textFieldForSAmt6.setText("0");
		textFieldForSAmt7.setText("0");
		textFieldForSAmt8.setText("0");
		textFieldForSAmt9.setText("0");
		textFieldForSAmt10.setText("0");
		
		textFieldForCGst1.setText("0");
		textFieldForCGst2.setText("0");
		textFieldForCGst3.setText("0");
		textFieldForCGst4.setText("0");
		textFieldForCGst5.setText("0");
		textFieldForCGst6.setText("0");
		textFieldForCGst7.setText("0");
		textFieldForCGst8.setText("0");
		textFieldForCGst9.setText("0");
		textFieldForCGst10.setText("0");
		
		textFieldForCAmt1.setText("0");
		textFieldForCAmt2.setText("0");
		textFieldForCAmt3.setText("0");
		textFieldForCAmt4.setText("0");
		textFieldForCAmt5.setText("0");
		textFieldForCAmt6.setText("0");
		textFieldForCAmt7.setText("0");
		textFieldForCAmt8.setText("0");
		textFieldForCAmt9.setText("0");
		textFieldForCAmt10.setText("0");
		
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
				
			//	billNo = billNo +1;
				
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
	
	public TradeSCGstBill(String name, String gstNo) {
		
		this.name = name;
		this.gstNo = gstNo;
		
		setTitle("TAX INVOICE CASH/CREDIT");
		con = SQLiteConnection.sqliteDbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(85, 5, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
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
						
						Double sgst_2 = (gst_2)/2;
						
						Double cgst_2 = (gst_2)/2;
						
						String sgst2 = Double.toString(sgst_2);
						
						String cgst2 = Double.toString(cgst_2);
						
						textFieldForSGst2.setText(sgst2);
						textFieldForCGst2.setText(cgst2);
						
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
						
						Double sgst_3 = (gst_3)/2;
						
						Double cgst_3 = (gst_3)/2;
						
						String sgst3 = Double.toString(sgst_3);
						
						String cgst3 = Double.toString(cgst_3);
						
						textFieldForSGst3.setText(sgst3);
						textFieldForCGst3.setText(cgst3);
						
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
						
						Double sgst_4 = (gst_4)/2;
						
						Double cgst_4 = (gst_4)/2;
						
						String sgst4 = Double.toString(sgst_4);
						
						String cgst4 = Double.toString(cgst_4);
						
						textFieldForSGst4.setText(sgst4);
						textFieldForCGst4.setText(cgst4);
						
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
						
						Double sgst_5 = (gst_5)/2;
						
						Double cgst_5 = (gst_5)/2;
						
						String sgst5 = Double.toString(sgst_5);
						
						String cgst5 = Double.toString(cgst_5);
						
						textFieldForSGst5.setText(sgst5);
						textFieldForCGst5.setText(cgst5);
						
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
						
						Double sgst_6 = (gst_6)/2;
						
						Double cgst_6 = (gst_6)/2;
						
						String sgst6 = Double.toString(sgst_6);
						
						String cgst6 = Double.toString(cgst_6);
						
						textFieldForSGst6.setText(sgst6);
						textFieldForCGst6.setText(cgst6);
						
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
						
						Double sgst_7 = (gst_7)/2;
						
						Double cgst_7 = (gst_7)/2;
						
						String sgst7 = Double.toString(sgst_7);
						
						String cgst7 = Double.toString(cgst_7);
						
						textFieldForSGst7.setText(sgst7);
						textFieldForCGst7.setText(cgst7);
						
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
						
						Double sgst_8 = (gst_8)/2;
						
						Double cgst_8 = (gst_8)/2;
						
						String sgst8 = Double.toString(sgst_8);
						
						String cgst8 = Double.toString(cgst_8);
						
						textFieldForSGst8.setText(sgst8);
						textFieldForCGst8.setText(cgst8);
						
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
						
						Double sgst_9 = (gst_9)/2;
						
						Double cgst_9 = (gst_9)/2;
						
						String sgst9 = Double.toString(sgst_9);
						
						String cgst9 = Double.toString(cgst_9);
						
						textFieldForSGst9.setText(sgst9);
						textFieldForCGst9.setText(cgst9);
						
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
						
						Double sgst_10 = (gst_10)/2;
						
						Double cgst_10 = (gst_10)/2;
						
						String sgst10 = Double.toString(sgst_10);
						
						String cgst10 = Double.toString(cgst_10);
						
						textFieldForSGst10.setText(sgst10);
						textFieldForCGst10.setText(cgst10);
						
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
		lblHsn.setBounds(201, 156, 135, 14);
		contentPane.add(lblHsn);
		
		lblQty = new JLabel("QTY");
		lblQty.setHorizontalAlignment(SwingConstants.CENTER);
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQty.setBackground(Color.WHITE);
		lblQty.setBounds(334, 156, 119, 14);
		contentPane.add(lblQty);
		
		lblRate = new JLabel("RATE");
		lblRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRate.setBackground(Color.WHITE);
		lblRate.setBounds(464, 156, 119, 14);
		contentPane.add(lblRate);
		
		lblsgst = new JLabel("%SGST");
		lblsgst.setHorizontalAlignment(SwingConstants.CENTER);
		lblsgst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblsgst.setBackground(Color.WHITE);
		lblsgst.setBounds(593, 156, 101, 14);
		contentPane.add(lblsgst);
		
		lblAmt1 = new JLabel("SGST AMT");
		lblAmt1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmt1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAmt1.setBackground(Color.WHITE);
		lblAmt1.setBounds(704, 156, 101, 14);
		contentPane.add(lblAmt1);
		
		lblcgst = new JLabel("%CGST");
		lblcgst.setHorizontalAlignment(SwingConstants.CENTER);
		lblcgst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcgst.setBackground(Color.WHITE);
		lblcgst.setBounds(824, 156, 101, 14);
		contentPane.add(lblcgst);
		
		lblAmt2 = new JLabel("CGST AMT");
		lblAmt2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmt2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAmt2.setBackground(Color.WHITE);
		lblAmt2.setBounds(935, 156, 101, 14);
		contentPane.add(lblAmt2);
		
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
		textFieldForQty1.setBounds(355, 197, 86, 20);
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
				String sgst2 = textFieldForSGst2.getText();
				String cgst2 = textFieldForCGst2.getText();
				
				Double qty_2 = Double.parseDouble(qty2);
				Double rate_2 = Double.parseDouble(rate2);
				Double sgst_2 = Double.parseDouble(sgst2);
				Double cgst_2 = Double.parseDouble(cgst2);
				
				Double mulQtyRate2 = (qty_2*rate_2);
				
				Double s_amt_2 = (sgst_2/100)*mulQtyRate2;
				Double c_amt_2 = (cgst_2/100)*mulQtyRate2;
				
				Double sum2 = mulQtyRate2 + s_amt_2 + c_amt_2;  
				
				String s_amt2 = String.format("%.2f", s_amt_2);
				String c_amt2 = String.format("%.2f", c_amt_2);
				String value2 = String.format("%.2f", sum2);
				
				textFieldForSAmt2.setText(s_amt2);
				textFieldForCAmt2.setText(c_amt2);
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
		textFieldForQty2.setBounds(355, 228, 86, 20);
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
				String sgst3 = textFieldForSGst3.getText();
				String cgst3 = textFieldForCGst3.getText();
				
				Double qty_3 = Double.parseDouble(qty3);
				Double rate_3 = Double.parseDouble(rate3);
				Double sgst_3 = Double.parseDouble(sgst3);
				Double cgst_3 = Double.parseDouble(cgst3);
				
				Double mulQtyRate3 = (qty_3*rate_3);
				
				Double s_amt_3 = (sgst_3/100)*mulQtyRate3;
				Double c_amt_3 = (cgst_3/100)*mulQtyRate3;
				
				Double sum3 = mulQtyRate3 + s_amt_3 + c_amt_3;  
				
				String s_amt3 = String.format("%.2f", s_amt_3);
				String c_amt3 = String.format("%.2f", c_amt_3);
				String value3 = String.format("%.2f", sum3);
				
				textFieldForSAmt3.setText(s_amt3);
				textFieldForCAmt3.setText(c_amt3);
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
		textFieldForQty3.setBounds(355, 259, 86, 20);
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
				String sgst4 = textFieldForSGst4.getText();
				String cgst4 = textFieldForCGst4.getText();
				
				Double qty_4 = Double.parseDouble(qty4);
				Double rate_4 = Double.parseDouble(rate4);
				Double sgst_4 = Double.parseDouble(sgst4);
				Double cgst_4 = Double.parseDouble(cgst4);
				
				Double mulQtyRate4 = (qty_4*rate_4);
				
				Double s_amt_4 = (sgst_4/100)*mulQtyRate4;
				Double c_amt_4 = (cgst_4/100)*mulQtyRate4;
				
				Double sum4 = mulQtyRate4 + s_amt_4 + c_amt_4;  
				
				String s_amt4 = String.format("%.2f", s_amt_4);
				String c_amt4 = String.format("%.2f", c_amt_4);
				String value4 = String.format("%.2f", sum4);
				
				textFieldForSAmt4.setText(s_amt4);
				textFieldForCAmt4.setText(c_amt4);
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
		textFieldForQty4.setBounds(355, 290, 86, 20);
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
				String sgst5 = textFieldForSGst5.getText();
				String cgst5 = textFieldForCGst5.getText();
				
				Double qty_5 = Double.parseDouble(qty5);
				Double rate_5 = Double.parseDouble(rate5);
				Double sgst_5 = Double.parseDouble(sgst5);
				Double cgst_5 = Double.parseDouble(cgst5);
				
				Double mulQtyRate5 = (qty_5*rate_5);
				
				Double s_amt_5 = (sgst_5/100)*mulQtyRate5;
				Double c_amt_5 = (cgst_5/100)*mulQtyRate5;
				
				Double sum5 = mulQtyRate5 + s_amt_5 + c_amt_5;  
				
				String s_amt5 = String.format("%.2f", s_amt_5);
				String c_amt5 = String.format("%.2f", c_amt_5);
				String value5 = String.format("%.2f", sum5);
				
				textFieldForSAmt5.setText(s_amt5);
				textFieldForCAmt5.setText(c_amt5);
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
		textFieldForQty5.setBounds(355, 321, 86, 20);
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
				String sgst6 = textFieldForSGst6.getText();
				String cgst6 = textFieldForCGst6.getText();
				
				Double qty_6 = Double.parseDouble(qty6);
				Double rate_6 = Double.parseDouble(rate6);
				Double sgst_6 = Double.parseDouble(sgst6);
				Double cgst_6 = Double.parseDouble(cgst6);
				
				Double mulQtyRate6 = (qty_6*rate_6);
				
				Double s_amt_6 = (sgst_6/100)*mulQtyRate6;
				Double c_amt_6 = (cgst_6/100)*mulQtyRate6;
				
				Double sum6 = mulQtyRate6 + s_amt_6 + c_amt_6;  
				
				String s_amt6 = String.format("%.2f", s_amt_6);
				String c_amt6 = String.format("%.2f", c_amt_6);
				String value6 = String.format("%.2f", sum6);
				
				textFieldForSAmt6.setText(s_amt6);
				textFieldForCAmt6.setText(c_amt6);
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
		textFieldForQty6.setBounds(355, 352, 86, 20);
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
				String sgst7 = textFieldForSGst7.getText();
				String cgst7 = textFieldForCGst7.getText();
				
				Double qty_7 = Double.parseDouble(qty7);
				Double rate_7 = Double.parseDouble(rate7);
				Double sgst_7 = Double.parseDouble(sgst7);
				Double cgst_7 = Double.parseDouble(cgst7);
				
				Double mulQtyRate7 = (qty_7*rate_7);
				
				Double s_amt_7 = (sgst_7/100)*mulQtyRate7;
				Double c_amt_7 = (cgst_7/100)*mulQtyRate7;
				
				Double sum7 = mulQtyRate7 + s_amt_7 + c_amt_7;  
				
				String s_amt7 = String.format("%.2f", s_amt_7);
				String c_amt7 = String.format("%.2f", c_amt_7);
				String value7 = String.format("%.2f", sum7);
				
				textFieldForSAmt7.setText(s_amt7);
				textFieldForCAmt7.setText(c_amt7);
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
		textFieldForQty7.setBounds(355, 383, 86, 20);
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
				String sgst8 = textFieldForSGst8.getText();
				String cgst8 = textFieldForCGst8.getText();
				
				Double qty_8 = Double.parseDouble(qty8);
				Double rate_8 = Double.parseDouble(rate8);
				Double sgst_8 = Double.parseDouble(sgst8);
				Double cgst_8 = Double.parseDouble(cgst8);
				
				Double mulQtyRate8 = (qty_8*rate_8);
				
				Double s_amt_8 = (sgst_8/100)*mulQtyRate8;
				Double c_amt_8 = (cgst_8/100)*mulQtyRate8;
				
				Double sum8 = mulQtyRate8 + s_amt_8 + c_amt_8;  
				
				String s_amt8 = String.format("%.2f", s_amt_8);
				String c_amt8 = String.format("%.2f", c_amt_8);
				String value8 = String.format("%.2f", sum8);
				
				textFieldForSAmt8.setText(s_amt8);
				textFieldForCAmt8.setText(c_amt8);
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
		textFieldForQty8.setBounds(355, 414, 86, 20);
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
				String sgst9 = textFieldForSGst9.getText();
				String cgst9 = textFieldForCGst9.getText();
				
				Double qty_9 = Double.parseDouble(qty9);
				Double rate_9 = Double.parseDouble(rate9);
				Double sgst_9 = Double.parseDouble(sgst9);
				Double cgst_9 = Double.parseDouble(cgst9);
				
				Double mulQtyRate9 = (qty_9*rate_9);
				
				Double s_amt_9 = (sgst_9/100)*mulQtyRate9;
				Double c_amt_9 = (cgst_9/100)*mulQtyRate9;
				
				Double sum9 = mulQtyRate9 + s_amt_9 + c_amt_9;  
				
				String s_amt9 = String.format("%.2f", s_amt_9);
				String c_amt9 = String.format("%.2f", c_amt_9);
				String value9 = String.format("%.2f", sum9);
				
				textFieldForSAmt9.setText(s_amt9);
				textFieldForCAmt9.setText(c_amt9);
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
		textFieldForQty9.setBounds(355, 445, 86, 20);
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
				String sgst10 = textFieldForSGst10.getText();
				String cgst10 = textFieldForCGst10.getText();
				
				Double qty_10 = Double.parseDouble(qty10);
				Double rate_10 = Double.parseDouble(rate10);
				Double sgst_10 = Double.parseDouble(sgst10);
				Double cgst_10 = Double.parseDouble(cgst10);
				
				Double mulQtyRate10 = (qty_10*rate_10);
				
				Double s_amt_10 = (sgst_10/100)*mulQtyRate10;
				Double c_amt_10 = (cgst_10/100)*mulQtyRate10;
				
				Double sum10 = mulQtyRate10 + s_amt_10 + c_amt_10;  
				
				String s_amt10 = String.format("%.2f", s_amt_10);
				String c_amt10 = String.format("%.2f", c_amt_10);
				String value10 = String.format("%.2f", sum10);
				
				textFieldForSAmt10.setText(s_amt10);
				textFieldForCAmt10.setText(c_amt10);
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
		textFieldForQty10.setBounds(355, 476, 86, 20);
		contentPane.add(textFieldForQty10);
		
		textFieldForRate1 = new JTextField();
		textFieldForRate1.setBackground(Color.WHITE);
		textFieldForRate1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate1.setBounds(484, 197, 86, 20);
		contentPane.add(textFieldForRate1);
		textFieldForRate1.setColumns(10);
		textFieldForRate1.setText("0");
		
		textFieldForRate2 = new JTextField();
		textFieldForRate2.setBackground(Color.WHITE);
		textFieldForRate2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate2.setColumns(10);
		textFieldForRate2.setBounds(484, 228, 86, 20);
		contentPane.add(textFieldForRate2);
		textFieldForRate2.setText("0");
		
		textFieldForRate3 = new JTextField();
		textFieldForRate3.setBackground(Color.WHITE);
		textFieldForRate3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate3.setColumns(10);
		textFieldForRate3.setBounds(484, 259, 86, 20);
		contentPane.add(textFieldForRate3);
		textFieldForRate3.setText("0");
		
		textFieldForRate4 = new JTextField();
		textFieldForRate4.setBackground(Color.WHITE);
		textFieldForRate4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate4.setColumns(10);
		textFieldForRate4.setBounds(484, 290, 86, 20);
		contentPane.add(textFieldForRate4);
		textFieldForRate4.setText("0");
		
		textFieldForRate5 = new JTextField();
		textFieldForRate5.setBackground(Color.WHITE);
		textFieldForRate5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate5.setColumns(10);
		textFieldForRate5.setBounds(484, 321, 86, 20);
		contentPane.add(textFieldForRate5);
		textFieldForRate5.setText("0");
		
		textFieldForRate6 = new JTextField();
		textFieldForRate6.setBackground(Color.WHITE);
		textFieldForRate6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate6.setColumns(10);
		textFieldForRate6.setBounds(484, 352, 86, 20);
		contentPane.add(textFieldForRate6);
		textFieldForRate6.setText("0");
		
		textFieldForRate7 = new JTextField();
		textFieldForRate7.setBackground(Color.WHITE);
		textFieldForRate7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate7.setColumns(10);
		textFieldForRate7.setBounds(484, 383, 86, 20);
		contentPane.add(textFieldForRate7);
		textFieldForRate7.setText("0");
		
		textFieldForRate8 = new JTextField();
		textFieldForRate8.setBackground(Color.WHITE);
		textFieldForRate8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate8.setColumns(10);
		textFieldForRate8.setBounds(484, 414, 86, 20);
		contentPane.add(textFieldForRate8);
		textFieldForRate8.setText("0");
		
		textFieldForRate9 = new JTextField();
		textFieldForRate9.setBackground(Color.WHITE);
		textFieldForRate9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate9.setColumns(10);
		textFieldForRate9.setBounds(484, 445, 86, 20);
		contentPane.add(textFieldForRate9);
		textFieldForRate9.setText("0");
		
		textFieldForRate10 = new JTextField();
		textFieldForRate10.setBackground(Color.WHITE);
		textFieldForRate10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate10.setColumns(10);
		textFieldForRate10.setBounds(484, 476, 86, 20);
		contentPane.add(textFieldForRate10);
		textFieldForRate10.setText("0");
		
		textFieldForSGst1 = new JTextField();
		textFieldForSGst1.setBackground(Color.WHITE);
		textFieldForSGst1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSGst1.setBounds(605, 197, 86, 20);
		contentPane.add(textFieldForSGst1);
		textFieldForSGst1.setColumns(10);
		textFieldForSGst1.setText("0");
		
		textFieldForSGst2 = new JTextField();
		textFieldForSGst2.setBackground(Color.WHITE);
		textFieldForSGst2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSGst2.setColumns(10);
		textFieldForSGst2.setBounds(605, 228, 86, 20);
		contentPane.add(textFieldForSGst2);
		textFieldForSGst2.setText("0");
		
		textFieldForSGst3 = new JTextField();
		textFieldForSGst3.setBackground(Color.WHITE);
		textFieldForSGst3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSGst3.setColumns(10);
		textFieldForSGst3.setBounds(605, 259, 86, 20);
		contentPane.add(textFieldForSGst3);
		textFieldForSGst3.setText("0");
		
		textFieldForSGst4 = new JTextField();
		textFieldForSGst4.setBackground(Color.WHITE);
		textFieldForSGst4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSGst4.setColumns(10);
		textFieldForSGst4.setBounds(605, 290, 86, 20);
		contentPane.add(textFieldForSGst4);
		textFieldForSGst4.setText("0");
		
		textFieldForSGst5 = new JTextField();
		textFieldForSGst5.setBackground(Color.WHITE);
		textFieldForSGst5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSGst5.setColumns(10);
		textFieldForSGst5.setBounds(605, 321, 86, 20);
		contentPane.add(textFieldForSGst5);
		textFieldForSGst5.setText("0");
		
		textFieldForSGst6 = new JTextField();
		textFieldForSGst6.setBackground(Color.WHITE);
		textFieldForSGst6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSGst6.setColumns(10);
		textFieldForSGst6.setBounds(605, 352, 86, 20);
		contentPane.add(textFieldForSGst6);
		textFieldForSGst6.setText("0");
		
		textFieldForSGst7 = new JTextField();
		textFieldForSGst7.setBackground(Color.WHITE);
		textFieldForSGst7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSGst7.setColumns(10);
		textFieldForSGst7.setBounds(605, 383, 86, 20);
		contentPane.add(textFieldForSGst7);
		textFieldForSGst7.setText("0");
		
		textFieldForSGst8 = new JTextField();
		textFieldForSGst8.setBackground(Color.WHITE);
		textFieldForSGst8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSGst8.setColumns(10);
		textFieldForSGst8.setBounds(605, 414, 86, 20);
		contentPane.add(textFieldForSGst8);
		textFieldForSGst8.setText("0");
		
		textFieldForSGst9 = new JTextField();
		textFieldForSGst9.setBackground(Color.WHITE);
		textFieldForSGst9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSGst9.setColumns(10);
		textFieldForSGst9.setBounds(605, 445, 86, 20);
		contentPane.add(textFieldForSGst9);
		textFieldForSGst9.setText("0");
		
		textFieldForSGst10 = new JTextField();
		textFieldForSGst10.setBackground(Color.WHITE);
		textFieldForSGst10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSGst10.setColumns(10);
		textFieldForSGst10.setBounds(605, 476, 86, 20);
		contentPane.add(textFieldForSGst10);
		textFieldForSGst10.setText("0");
		
		textFieldForSAmt1 = new JTextField();
		textFieldForSAmt1.setBackground(Color.WHITE);
		textFieldForSAmt1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSAmt1.setBounds(704, 197, 86, 20);
		contentPane.add(textFieldForSAmt1);
		textFieldForSAmt1.setColumns(10);
		textFieldForSAmt1.setText("0");
		
		textFieldForSAmt2 = new JTextField();
		textFieldForSAmt2.setBackground(Color.WHITE);
		textFieldForSAmt2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSAmt2.setColumns(10);
		textFieldForSAmt2.setBounds(704, 228, 86, 20);
		contentPane.add(textFieldForSAmt2);
		textFieldForSAmt2.setText("0");
		
		textFieldForSAmt3 = new JTextField();
		textFieldForSAmt3.setBackground(Color.WHITE);
		textFieldForSAmt3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSAmt3.setColumns(10);
		textFieldForSAmt3.setBounds(704, 259, 86, 20);
		contentPane.add(textFieldForSAmt3);
		textFieldForSAmt3.setText("0");
		
		textFieldForSAmt4 = new JTextField();
		textFieldForSAmt4.setBackground(Color.WHITE);
		textFieldForSAmt4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSAmt4.setColumns(10);
		textFieldForSAmt4.setBounds(704, 290, 86, 20);
		contentPane.add(textFieldForSAmt4);
		textFieldForSAmt4.setText("0");
		
		textFieldForSAmt5 = new JTextField();
		textFieldForSAmt5.setBackground(Color.WHITE);
		textFieldForSAmt5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSAmt5.setColumns(10);
		textFieldForSAmt5.setBounds(704, 321, 86, 20);
		contentPane.add(textFieldForSAmt5);
		textFieldForSAmt5.setText("0");
		
		textFieldForSAmt6 = new JTextField();
		textFieldForSAmt6.setBackground(Color.WHITE);
		textFieldForSAmt6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSAmt6.setColumns(10);
		textFieldForSAmt6.setBounds(704, 352, 86, 20);
		contentPane.add(textFieldForSAmt6);
		textFieldForSAmt6.setText("0");
		
		textFieldForSAmt7 = new JTextField();
		textFieldForSAmt7.setBackground(Color.WHITE);
		textFieldForSAmt7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSAmt7.setColumns(10);
		textFieldForSAmt7.setBounds(704, 383, 86, 20);
		contentPane.add(textFieldForSAmt7);
		textFieldForSAmt7.setText("0");
		
		textFieldForSAmt8 = new JTextField();
		textFieldForSAmt8.setBackground(Color.WHITE);
		textFieldForSAmt8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSAmt8.setColumns(10);
		textFieldForSAmt8.setBounds(704, 414, 86, 20);
		contentPane.add(textFieldForSAmt8);
		textFieldForSAmt8.setText("0");
		
		textFieldForSAmt9 = new JTextField();
		textFieldForSAmt9.setBackground(Color.WHITE);
		textFieldForSAmt9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSAmt9.setColumns(10);
		textFieldForSAmt9.setBounds(704, 445, 86, 20);
		contentPane.add(textFieldForSAmt9);
		textFieldForSAmt9.setText("0");
		
		textFieldForSAmt10 = new JTextField();
		textFieldForSAmt10.setBackground(Color.WHITE);
		textFieldForSAmt10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForSAmt10.setColumns(10);
		textFieldForSAmt10.setBounds(704, 476, 86, 20);
		contentPane.add(textFieldForSAmt10);
		textFieldForSAmt10.setText("0");
		
		textFieldForCGst1 = new JTextField();
		textFieldForCGst1.setBackground(Color.WHITE);
		textFieldForCGst1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCGst1.setBounds(824, 197, 86, 20);
		contentPane.add(textFieldForCGst1);
		textFieldForCGst1.setColumns(10);
		textFieldForCGst1.setText("0");
		
		textFieldForCGst2 = new JTextField();
		textFieldForCGst2.setBackground(Color.WHITE);
		textFieldForCGst2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCGst2.setColumns(10);
		textFieldForCGst2.setBounds(824, 228, 86, 20);
		contentPane.add(textFieldForCGst2);
		textFieldForCGst2.setText("0");
		
		textFieldForCGst3 = new JTextField();
		textFieldForCGst3.setBackground(Color.WHITE);
		textFieldForCGst3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCGst3.setColumns(10);
		textFieldForCGst3.setBounds(824, 259, 86, 20);
		contentPane.add(textFieldForCGst3);
		textFieldForCGst3.setText("0");
		
		textFieldForCGst4 = new JTextField();
		textFieldForCGst4.setBackground(Color.WHITE);
		textFieldForCGst4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCGst4.setColumns(10);
		textFieldForCGst4.setBounds(824, 290, 86, 20);
		contentPane.add(textFieldForCGst4);
		textFieldForCGst4.setText("0");
		
		textFieldForCGst5 = new JTextField();
		textFieldForCGst5.setBackground(Color.WHITE);
		textFieldForCGst5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCGst5.setColumns(10);
		textFieldForCGst5.setBounds(824, 321, 86, 20);
		contentPane.add(textFieldForCGst5);
		textFieldForCGst5.setText("0");
		
		textFieldForCGst6 = new JTextField();
		textFieldForCGst6.setBackground(Color.WHITE);
		textFieldForCGst6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCGst6.setColumns(10);
		textFieldForCGst6.setBounds(824, 352, 86, 20);
		contentPane.add(textFieldForCGst6);
		textFieldForCGst6.setText("0");
		
		textFieldForCGst7 = new JTextField();
		textFieldForCGst7.setBackground(Color.WHITE);
		textFieldForCGst7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCGst7.setColumns(10);
		textFieldForCGst7.setBounds(824, 383, 86, 20);
		contentPane.add(textFieldForCGst7);
		textFieldForCGst7.setText("0");
		
		textFieldForCGst8 = new JTextField();
		textFieldForCGst8.setBackground(Color.WHITE);
		textFieldForCGst8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCGst8.setColumns(10);
		textFieldForCGst8.setBounds(824, 414, 86, 20);
		contentPane.add(textFieldForCGst8);
		textFieldForCGst8.setText("0");
		
		textFieldForCGst9 = new JTextField();
		textFieldForCGst9.setBackground(Color.WHITE);
		textFieldForCGst9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCGst9.setColumns(10);
		textFieldForCGst9.setBounds(824, 445, 86, 20);
		contentPane.add(textFieldForCGst9);
		textFieldForCGst9.setText("0");
		
		textFieldForCGst10 = new JTextField();
		textFieldForCGst10.setBackground(Color.WHITE);
		textFieldForCGst10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCGst10.setColumns(10);
		textFieldForCGst10.setBounds(824, 476, 86, 20);
		contentPane.add(textFieldForCGst10);
		textFieldForCGst10.setText("0");
		
		textFieldForCAmt1 = new JTextField();
		textFieldForCAmt1.setBackground(Color.WHITE);
		textFieldForCAmt1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCAmt1.setBounds(935, 197, 86, 20);
		contentPane.add(textFieldForCAmt1);
		textFieldForCAmt1.setColumns(10);
		textFieldForCAmt1.setText("0");
		
		textFieldForCAmt2 = new JTextField();
		textFieldForCAmt2.setBackground(Color.WHITE);
		textFieldForCAmt2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCAmt2.setColumns(10);
		textFieldForCAmt2.setBounds(935, 228, 86, 20);
		contentPane.add(textFieldForCAmt2);
		textFieldForCAmt2.setText("0");
		
		textFieldForCAmt3 = new JTextField();
		textFieldForCAmt3.setBackground(Color.WHITE);
		textFieldForCAmt3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCAmt3.setColumns(10);
		textFieldForCAmt3.setBounds(935, 259, 86, 20);
		contentPane.add(textFieldForCAmt3);
		textFieldForCAmt3.setText("0");
		
		textFieldForCAmt4 = new JTextField();
		textFieldForCAmt4.setBackground(Color.WHITE);
		textFieldForCAmt4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCAmt4.setColumns(10);
		textFieldForCAmt4.setBounds(935, 290, 86, 20);
		contentPane.add(textFieldForCAmt4);
		textFieldForCAmt4.setText("0");
		
		textFieldForCAmt5 = new JTextField();
		textFieldForCAmt5.setBackground(Color.WHITE);
		textFieldForCAmt5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCAmt5.setColumns(10);
		textFieldForCAmt5.setBounds(935, 321, 86, 20);
		contentPane.add(textFieldForCAmt5);
		textFieldForCAmt5.setText("0");
		
		textFieldForCAmt6 = new JTextField();
		textFieldForCAmt6.setBackground(Color.WHITE);
		textFieldForCAmt6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCAmt6.setColumns(10);
		textFieldForCAmt6.setBounds(935, 352, 86, 20);
		contentPane.add(textFieldForCAmt6);
		textFieldForCAmt6.setText("0");
		
		textFieldForCAmt7 = new JTextField();
		textFieldForCAmt7.setBackground(Color.WHITE);
		textFieldForCAmt7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCAmt7.setColumns(10);
		textFieldForCAmt7.setBounds(935, 383, 86, 20);
		contentPane.add(textFieldForCAmt7);
		textFieldForCAmt7.setText("0");
		
		textFieldForCAmt8 = new JTextField();
		textFieldForCAmt8.setBackground(Color.WHITE);
		textFieldForCAmt8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCAmt8.setColumns(10);
		textFieldForCAmt8.setBounds(935, 414, 86, 20);
		contentPane.add(textFieldForCAmt8);
		textFieldForCAmt8.setText("0");
		
		textFieldForCAmt9 = new JTextField();
		textFieldForCAmt9.setBackground(Color.WHITE);
		textFieldForCAmt9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCAmt9.setColumns(10);
		textFieldForCAmt9.setBounds(935, 445, 86, 20);
		contentPane.add(textFieldForCAmt9);
		textFieldForCAmt9.setText("0");
		
		textFieldForCAmt10 = new JTextField();
		textFieldForCAmt10.setBackground(Color.WHITE);
		textFieldForCAmt10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForCAmt10.setColumns(10);
		textFieldForCAmt10.setBounds(935, 476, 86, 20);
		contentPane.add(textFieldForCAmt10);
		textFieldForCAmt10.setText("0");
		
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
		btnSnapShot.setBounds(314, 557, 127, 20);
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
		btnReset.setBounds(776, 663, 77, 20);
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
				
				trp.setTextFieldForSGst1(textFieldForSGst1.getText().toString());
				trp.setTextFieldForSGst2(textFieldForSGst2.getText().toString());
				trp.setTextFieldForSGst3(textFieldForSGst3.getText().toString());
				trp.setTextFieldForSGst4(textFieldForSGst4.getText().toString());
				trp.setTextFieldForSGst5(textFieldForSGst5.getText().toString());
				trp.setTextFieldForSGst6(textFieldForSGst6.getText().toString());
				trp.setTextFieldForSGst7(textFieldForSGst7.getText().toString());
				trp.setTextFieldForSGst8(textFieldForSGst8.getText().toString());
				trp.setTextFieldForSGst9(textFieldForSGst9.getText().toString());
				trp.setTextFieldForSGst10(textFieldForSGst10.getText().toString());
				
				trp.setTextFieldForSAmt1(textFieldForSAmt1.getText().toString());
				trp.setTextFieldForSAmt2(textFieldForSAmt2.getText().toString());
				trp.setTextFieldForSAmt3(textFieldForSAmt3.getText().toString());
				trp.setTextFieldForSAmt4(textFieldForSAmt4.getText().toString());
				trp.setTextFieldForSAmt5(textFieldForSAmt5.getText().toString());
				trp.setTextFieldForSAmt6(textFieldForSAmt6.getText().toString());
				trp.setTextFieldForSAmt7(textFieldForSAmt7.getText().toString());
				trp.setTextFieldForSAmt8(textFieldForSAmt8.getText().toString());
				trp.setTextFieldForSAmt9(textFieldForSAmt9.getText().toString());
				trp.setTextFieldForSAmt10(textFieldForSAmt10.getText().toString());
				
				trp.setTextFieldForCGst1(textFieldForCGst1.getText().toString());
				trp.setTextFieldForCGst2(textFieldForCGst2.getText().toString());
				trp.setTextFieldForCGst3(textFieldForCGst3.getText().toString());
				trp.setTextFieldForCGst4(textFieldForCGst4.getText().toString());
				trp.setTextFieldForCGst5(textFieldForCGst5.getText().toString());
				trp.setTextFieldForCGst6(textFieldForCGst6.getText().toString());
				trp.setTextFieldForCGst7(textFieldForCGst7.getText().toString());
				trp.setTextFieldForCGst8(textFieldForCGst8.getText().toString());
				trp.setTextFieldForCGst9(textFieldForCGst9.getText().toString());
				trp.setTextFieldForCGst10(textFieldForCGst10.getText().toString());
				
				trp.setTextFieldForCAmt1(textFieldForCAmt1.getText().toString());
				trp.setTextFieldForCAmt2(textFieldForCAmt2.getText().toString());
				trp.setTextFieldForCAmt3(textFieldForCAmt3.getText().toString());
				trp.setTextFieldForCAmt4(textFieldForCAmt4.getText().toString());
				trp.setTextFieldForCAmt5(textFieldForCAmt5.getText().toString());
				trp.setTextFieldForCAmt6(textFieldForCAmt6.getText().toString());
				trp.setTextFieldForCAmt7(textFieldForCAmt7.getText().toString());
				trp.setTextFieldForCAmt8(textFieldForCAmt8.getText().toString());
				trp.setTextFieldForCAmt9(textFieldForCAmt9.getText().toString());
				trp.setTextFieldForCAmt10(textFieldForCAmt10.getText().toString());
				
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
		btnReceipt.setBounds(314, 643, 127, 20);
		contentPane.add(btnReceipt);
		
		JButton btnSaveAsPdf = new JButton("Save As Pdf");
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
					
					tableBill.addCell(comboBox1.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn1.getText());
					tableBill.addCell(textFieldForQty1.getText());
					tableBill.addCell(textFieldForRate1.getText());
					tableBill.addCell(textFieldForSGst1.getText());
					tableBill.addCell(textFieldForSAmt1.getText());
					tableBill.addCell(textFieldForCGst1.getText());
					tableBill.addCell(textFieldForCAmt1.getText());
					tableBill.addCell(textFieldForValue1.getText());
					
					
					tableBill.addCell(comboBox2.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn2.getText());
					tableBill.addCell(textFieldForQty2.getText());
					tableBill.addCell(textFieldForRate2.getText());
					tableBill.addCell(textFieldForSGst2.getText());
					tableBill.addCell(textFieldForSAmt2.getText());
					tableBill.addCell(textFieldForCGst2.getText());
					tableBill.addCell(textFieldForCAmt2.getText());
					tableBill.addCell(textFieldForValue2.getText());
					
					
					tableBill.addCell(comboBox3.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn3.getText());
					tableBill.addCell(textFieldForQty3.getText());
					tableBill.addCell(textFieldForRate3.getText());
					tableBill.addCell(textFieldForSGst3.getText());
					tableBill.addCell(textFieldForSAmt3.getText());
					tableBill.addCell(textFieldForCGst3.getText());
					tableBill.addCell(textFieldForCAmt3.getText());
					tableBill.addCell(textFieldForValue3.getText());
					
					
					tableBill.addCell(comboBox4.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn4.getText());
					tableBill.addCell(textFieldForQty4.getText());
					tableBill.addCell(textFieldForRate4.getText());
					tableBill.addCell(textFieldForSGst4.getText());
					tableBill.addCell(textFieldForSAmt4.getText());
					tableBill.addCell(textFieldForCGst4.getText());
					tableBill.addCell(textFieldForCAmt4.getText());
					tableBill.addCell(textFieldForValue4.getText());
					
					
					tableBill.addCell(comboBox5.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn5.getText());
					tableBill.addCell(textFieldForQty5.getText());
					tableBill.addCell(textFieldForRate5.getText());
					tableBill.addCell(textFieldForSGst5.getText());
					tableBill.addCell(textFieldForSAmt5.getText());
					tableBill.addCell(textFieldForCGst5.getText());
					tableBill.addCell(textFieldForCAmt5.getText());
					tableBill.addCell(textFieldForValue5.getText());
					
					
					tableBill.addCell(comboBox6.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn6.getText());
					tableBill.addCell(textFieldForQty6.getText());
					tableBill.addCell(textFieldForRate6.getText());
					tableBill.addCell(textFieldForSGst6.getText());
					tableBill.addCell(textFieldForSAmt6.getText());
					tableBill.addCell(textFieldForCGst6.getText());
					tableBill.addCell(textFieldForCAmt6.getText());
					tableBill.addCell(textFieldForValue6.getText());
					
					
					tableBill.addCell(comboBox7.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn7.getText());
					tableBill.addCell(textFieldForQty7.getText());
					tableBill.addCell(textFieldForRate7.getText());
					tableBill.addCell(textFieldForSGst7.getText());
					tableBill.addCell(textFieldForSAmt7.getText());
					tableBill.addCell(textFieldForCGst7.getText());
					tableBill.addCell(textFieldForCAmt7.getText());
					tableBill.addCell(textFieldForValue7.getText());
					
					
					tableBill.addCell(comboBox8.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn8.getText());
					tableBill.addCell(textFieldForQty8.getText());
					tableBill.addCell(textFieldForRate8.getText());
					tableBill.addCell(textFieldForSGst8.getText());
					tableBill.addCell(textFieldForSAmt8.getText());
					tableBill.addCell(textFieldForCGst8.getText());
					tableBill.addCell(textFieldForCAmt8.getText());
					tableBill.addCell(textFieldForValue8.getText());
					
					
					tableBill.addCell(comboBox9.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn9.getText());
					tableBill.addCell(textFieldForQty9.getText());
					tableBill.addCell(textFieldForRate9.getText());
					tableBill.addCell(textFieldForSGst9.getText());
					tableBill.addCell(textFieldForSAmt9.getText());
					tableBill.addCell(textFieldForCGst9.getText());
					tableBill.addCell(textFieldForCAmt9.getText());
					tableBill.addCell(textFieldForValue9.getText());
					
					
					tableBill.addCell(comboBox10.getSelectedItem().toString());
					tableBill.addCell(textFieldForHsn10.getText());
					tableBill.addCell(textFieldForQty10.getText());
					tableBill.addCell(textFieldForRate10.getText());
					tableBill.addCell(textFieldForSGst10.getText());
					tableBill.addCell(textFieldForSAmt10.getText());
					tableBill.addCell(textFieldForCGst10.getText());
					tableBill.addCell(textFieldForCAmt10.getText());
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
		btnSaveAsPdf.setBounds(314, 599, 127, 23);
		contentPane.add(btnSaveAsPdf);
		
		taxSummary();
		
		getCompanyDetails();
		
		getCurrentDate();
		
		getBillNo();
		
	}
} 
