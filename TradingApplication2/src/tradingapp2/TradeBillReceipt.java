package tradingapp2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tradingapp2.Printer;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;

public class TradeBillReceipt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextArea receiptArea;
	
	String Product1;
	String Product2;
	String Product3;
	String Product4;
	String Product5;
	String Product6;
	String Product7;
	String Product8;
	String Product9;
	String Product10;
	
	String Qty1;
	String Qty2;
	String Qty3;
	String Qty4;
	String Qty5;
	String Qty6;
	String Qty7;
	String Qty8;
	String Qty9;
	String Qty10;
	
	String Mrp1;
	String Mrp2;
	String Mrp3;
	String Mrp4;
	String Mrp5;
	String Mrp6;
	String Mrp7;
	String Mrp8;
	String Mrp9;
	String Mrp10;
	
	String Rate1;
	String Rate2;
	String Rate3;
	String Rate4;
	String Rate5;
	String Rate6;
	String Rate7;
	String Rate8;
	String Rate9;
	String Rate10;
	
	String Value1;
	String Value2;
	String Value3;
	String Value4;
	String Value5;
	String Value6;
	String Value7;
	String Value8;
	String Value9;
	String Value10;
	
	String date;
	
	String billNo;
	
	String companyName;
	
	String user;
	
	String grandTotal;
	
	String totalQty;
	
	String p1;
	String p2;
	String p3;
	String p4;
	String p5;
	String p6;
	String p7;
	String p8;
	String p9;
	String p10;

	/**
	 * Launch the application.
	 */
	
	TradeReceiptPojo trp;
	
	public TradeBillReceipt(TradeReceiptPojo trp) {
		
		this.trp =trp;
		
		Product1 = trp.getComboBox1();
		Product2 = trp.getComboBox2();
		Product3 = trp.getComboBox3();
		Product4 = trp.getComboBox4();
		Product5 = trp.getComboBox5();
		Product6 = trp.getComboBox6();
		Product7 = trp.getComboBox7();
		Product8 = trp.getComboBox8();
		Product9 = trp.getComboBox9();
		Product10 = trp.getComboBox10();
		
		Qty1 = trp.getTextFieldForQty1();
		Qty2 = trp.getTextFieldForQty2();
		Qty3 = trp.getTextFieldForQty3();
		Qty4 = trp.getTextFieldForQty4();
		Qty5 = trp.getTextFieldForQty5();
		Qty6 = trp.getTextFieldForQty6();
		Qty7 = trp.getTextFieldForQty7();
		Qty8 = trp.getTextFieldForQty8();
		Qty9 = trp.getTextFieldForQty9();
		Qty10 = trp.getTextFieldForQty10();
		
		Mrp1 = trp.getTextFieldForMrp1();
		Mrp2 = trp.getTextFieldForMrp2();
		Mrp3 = trp.getTextFieldForMrp3();
		Mrp4 = trp.getTextFieldForMrp4();
		Mrp5 = trp.getTextFieldForMrp5();
		Mrp6 = trp.getTextFieldForMrp6();
		Mrp7 = trp.getTextFieldForMrp7();
		Mrp8 = trp.getTextFieldForMrp8();
		Mrp9 = trp.getTextFieldForMrp9();
		Mrp10 = trp.getTextFieldForMrp10();
		
		Rate1 = trp.getTextFieldForRate1();
		Rate2 = trp.getTextFieldForRate2();
		Rate3 = trp.getTextFieldForRate3();
		Rate4 = trp.getTextFieldForRate4();
		Rate5 = trp.getTextFieldForRate5();
		Rate6 = trp.getTextFieldForRate6();
		Rate7 = trp.getTextFieldForRate7();
		Rate8 = trp.getTextFieldForRate8();
		Rate9 = trp.getTextFieldForRate9();
		Rate10 = trp.getTextFieldForRate10();
		
		Value1 = trp.getTextFieldForValue1();
		Value2 = trp.getTextFieldForValue2();
		Value3 = trp.getTextFieldForValue3();
		Value4 = trp.getTextFieldForValue4();
		Value5 = trp.getTextFieldForValue5();
		Value6 = trp.getTextFieldForValue6();
		Value7 = trp.getTextFieldForValue7();
		Value8 = trp.getTextFieldForValue8();
		Value9 = trp.getTextFieldForValue9();
		Value10 = trp.getTextFieldForValue10();
		
		billNo = trp.getTextFieldBillNo();
		
		date = trp.getTextFieldDate();
		
		companyName = trp.getLabelTitle1();
		
		user = trp.getTextFieldTo();
		
		grandTotal = trp.getTextFieldGrandTotal();
		
		totalQty = trp.getTextFieldTotalQty();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(475, 5, 587, 696);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PrinterJob pJob = PrinterJob.getPrinterJob();
				
				PageFormat preFormat = pJob.defaultPage();
				
				preFormat.setOrientation(PageFormat.PORTRAIT);
				
				PageFormat postFormat = pJob.pageDialog(preFormat);
				
				if(preFormat != postFormat){
					
					 pJob.setPrintable(new Printer(receiptArea), postFormat);
					 
					 if(pJob.printDialog()){
						 
						 try {
							 
							pJob.print();
						
						 } catch (PrinterException e1) {
							
							e1.printStackTrace();
							
						}
						 
					 }
					
				}
				
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPrint.setBounds(10, 122, 89, 23);
		contentPane.add(btnPrint);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TradeGstBill tgb = new TradeGstBill();
				
				tgb.setVisible(true);
				
				dispose();
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(10, 184, 89, 23);
		contentPane.add(btnBack);
		
		if(Product1.length()>=10)
		{
			p1 = Product1.substring(0,9);
		}
		else
		{
			p1 = Product1;
		}
		if(Product2.length()>=10)
		{
			p2 = Product2.substring(0,9);
		}
		else
		{
			p2 = Product2;
		}
		if(Product3.length()>=10)
		{
			p3 = Product3.substring(0,9);
		}
		else
		{
			p3 = Product3;
		}
		if(Product4.length()>=10)
		{
			p4 = Product4.substring(0,9);
		}
		else
		{
			p4 = Product4;
		}
		if(Product5.length()>=10)
		{
			p5 = Product5.substring(0,9);
		}
		else
		{
			p5 = Product5;
		}
		if(Product6.length()>=10)
		{
			p6 = Product6.substring(0,9);
		}
		else
		{
			p6 = Product6;
		}
		if(Product7.length()>=10)
		{
			p7 = Product7.substring(0,9);
		}
		else
		{
			p7 = Product7;
		}
		if(Product8.length()>=10)
		{
			p8 = Product8.substring(0,9);
		}
		else
		{
			p8 = Product8;
		}
		if(Product9.length()>=10)
		{
			p9 = Product9.substring(0,9);
		}
		else
		{
			p9 = Product9;
		}
		if(Product10.length()>=10)
		{
			p10 = Product10.substring(0,9);
		}
		else
		{
			p10 = Product10;
		}
		
		receiptArea = new JTextArea();
		receiptArea.setBounds(156, 11, 405, 635);
		
		if(p1.equals("     -") && p2.equals("     -") && p3.equals("     -") && p4.equals("     -") && p5.equals("     -") && p6.equals("     -") && p7.equals("     -") && p8.equals("     -") && p9.equals("     -") && p10.equals("     -")){
		receiptArea.append("\n"+
							"\t                          ESTIMATION\n"+
							"\n"+
							"  Estimation No: "+billNo+
							"\t                                     Date: "+date+
							"\n  Cust Name: "+user+
							"\n========================================================= \n"+
							" PRODUCT\tMRP\tCOST\tQTY\tAMT   "+
							"\n========================================================= \n"+
							"\n"+
							"\n========================================================= \n"+
							"                                                                                           NET AMT        "+grandTotal+
							"\n========================================================= \n"+
							" TOTAL ITEMS     :"+totalQty+"\n"+
							"                                                  THANKS VISIT AGAIN!"
							);
		}else if(!p1.equals("     -") && p2.equals("     -") && p3.equals("     -") && p4.equals("     -") && p5.equals("     -") && p6.equals("     -") && p7.equals("     -") && p8.equals("     -") && p9.equals("     -") && p10.equals("     -")){
			receiptArea.append("\n"+
					"\t                          ESTIMATION\n"+
					"\n"+
					"  Estimation No: "+billNo+
					"\t                                     Date: "+date+
					"\n  Cust Name: "+user+
					"\n========================================================= \n"+
					" PRODUCT\tMRP\tCOST\tQTY\tAMT   "+
					"\n========================================================= \n"+
					" "+p1+"\t "+Mrp1+"\t "+Rate1+"\t "+Qty1+"\t"+Value1+" "+
					"\n========================================================= \n"+
					"                                                                                           NET AMT        "+grandTotal+
					"\n========================================================= \n"+
					" TOTAL ITEMS     :"+totalQty+"\n"+
					"                                                  THANKS VISIT AGAIN!"
					);
		}else if(!p1.equals("     -") && !p2.equals("     -") && p3.equals("     -") && p4.equals("     -") && p5.equals("     -") && p6.equals("     -") && p7.equals("     -") && p8.equals("     -") && p9.equals("     -") && p10.equals("     -")){
			receiptArea.append("\n"+
					"\t                          ESTIMATION\n"+
					"\n"+
					"  Estimation No: "+billNo+
					"\t                                     Date: "+date+
					"\n  Cust Name: "+user+
					"\n========================================================= \n"+
					" PRODUCT\tMRP\tCOST\tQTY\tAMT   "+
					"\n========================================================= \n"+
					" "+p1+"\t "+Mrp1+"\t "+Rate1+"\t "+Qty1+"\t"+Value1+"\n"+
					" "+p2+"\t "+Mrp2+"\t "+Rate2+"\t "+Qty2+"\t"+Value2+" "+
					"\n========================================================= \n"+
					"                                                                                           NET AMT        "+grandTotal+
					"\n========================================================= \n"+
					" TOTAL ITEMS     :"+totalQty+"\n"+
					"                                                  THANKS VISIT AGAIN!"
					);
		}else if(!p1.equals("     -") && !p2.equals("     -") && !p3.equals("     -") && p4.equals("     -") && p5.equals("     -") && p6.equals("     -") && p7.equals("     -") && p8.equals("     -") && p9.equals("     -") && p10.equals("     -")){
			receiptArea.append("\n"+
					"\t                          ESTIMATION\n"+
					"\n"+
					"  Estimation No: "+billNo+
					"\t                                     Date: "+date+
					"\n  Cust Name: "+user+
					"\n========================================================= \n"+
					" PRODUCT\tMRP\tCOST\tQTY\tAMT   "+
					"\n========================================================= \n"+
					" "+p1+"\t "+Mrp1+"\t "+Rate1+"\t "+Qty1+"\t"+Value1+"\n"+
					" "+p2+"\t "+Mrp2+"\t "+Rate2+"\t "+Qty2+"\t"+Value2+"\n"+
					" "+p3+"\t "+Mrp3+"\t "+Rate3+"\t "+Qty3+"\t"+Value3+" "+
					"\n========================================================= \n"+
					"                                                                                           NET AMT        "+grandTotal+
					"\n========================================================= \n"+
					" TOTAL ITEMS     :"+totalQty+"\n"+
					"                                                  THANKS VISIT AGAIN!"
					);
		}else if(!p1.equals("     -") && !p2.equals("     -") && !p3.equals("     -") && !p4.equals("     -") && p5.equals("     -") && p6.equals("     -") && p7.equals("     -") && p8.equals("     -") && p9.equals("     -") && p10.equals("     -")){
			receiptArea.append("\n"+
					"\t                          ESTIMATION\n"+
					"\n"+
					"  Estimation No: "+billNo+
					"\t                                     Date: "+date+
					"\n  Cust Name: "+user+
					"\n========================================================= \n"+
					" PRODUCT\tMRP\tCOST\tQTY\tAMT   "+
					"\n========================================================= \n"+
					" "+p1+"\t "+Mrp1+"\t "+Rate1+"\t "+Qty1+"\t"+Value1+"\n"+
					" "+p2+"\t "+Mrp2+"\t "+Rate2+"\t "+Qty2+"\t"+Value2+"\n"+
					" "+p3+"\t "+Mrp3+"\t "+Rate3+"\t "+Qty3+"\t"+Value3+"\n"+
					" "+p4+"\t "+Mrp4+"\t "+Rate4+"\t "+Qty4+"\t"+Value4+" "+
					"\n========================================================= \n"+
					"                                                                                           NET AMT        "+grandTotal+
					"\n========================================================= \n"+
					" TOTAL ITEMS     :"+totalQty+"\n"+
					"                                                  THANKS VISIT AGAIN!"
					);
		}else if(!p1.equals("     -") && !p2.equals("     -") && !p3.equals("     -") && !p4.equals("     -") && !p5.equals("     -") && p6.equals("     -") && p7.equals("     -") && p8.equals("     -") && p9.equals("     -") && p10.equals("     -")){
			receiptArea.append("\n"+
					"\t                          ESTIMATION\n"+
					"\n"+
					"  Estimation No: "+billNo+
					"\t                                     Date: "+date+
					"\n  Cust Name: "+user+
					"\n========================================================= \n"+
					" PRODUCT\tMRP\tCOST\tQTY\tAMT   "+
					"\n========================================================= \n"+
					" "+p1+"\t "+Mrp1+"\t "+Rate1+"\t "+Qty1+"\t"+Value1+"\n"+
					" "+p2+"\t "+Mrp2+"\t "+Rate2+"\t "+Qty2+"\t"+Value2+"\n"+
					" "+p3+"\t "+Mrp3+"\t "+Rate3+"\t "+Qty3+"\t"+Value3+"\n"+
					" "+p4+"\t "+Mrp4+"\t "+Rate4+"\t "+Qty4+"\t"+Value4+"\n"+
					" "+p5+"\t "+Mrp5+"\t "+Rate5+"\t "+Qty5+"\t"+Value5+" "+
					"\n========================================================= \n"+
					"                                                                                           NET AMT        "+grandTotal+
					"\n========================================================= \n"+
					" TOTAL ITEMS     :"+totalQty+"\n"+
					"                                                  THANKS VISIT AGAIN!"
					);
		}else if(!p1.equals("     -") && !p2.equals("     -") && !p3.equals("     -") && !p4.equals("     -") && !p5.equals("     -") && !p6.equals("     -") && p7.equals("     -") && p8.equals("     -") && p9.equals("     -") && p10.equals("     -")){
			receiptArea.append("\n"+
					"\t                          ESTIMATION\n"+
					"\n"+
					"  Estimation No: "+billNo+
					"\t                                     Date: "+date+
					"\n  Cust Name: "+user+
					"\n========================================================= \n"+
					" PRODUCT\tMRP\tCOST\tQTY\tAMT   "+
					"\n========================================================= \n"+
					" "+p1+"\t "+Mrp1+"\t "+Rate1+"\t "+Qty1+"\t"+Value1+"\n"+
					" "+p2+"\t "+Mrp2+"\t "+Rate2+"\t "+Qty2+"\t"+Value2+"\n"+
					" "+p3+"\t "+Mrp3+"\t "+Rate3+"\t "+Qty3+"\t"+Value3+"\n"+
					" "+p4+"\t "+Mrp4+"\t "+Rate4+"\t "+Qty4+"\t"+Value4+"\n"+
					" "+p5+"\t "+Mrp5+"\t "+Rate5+"\t "+Qty5+"\t"+Value5+"\n"+
					" "+p6+"\t "+Mrp6+"\t "+Rate6+"\t "+Qty6+"\t"+Value6+" "+
					"\n========================================================= \n"+
					"                                                                                           NET AMT        "+grandTotal+
					"\n========================================================= \n"+
					" TOTAL ITEMS     :"+totalQty+"\n"+
					"                                                  THANKS VISIT AGAIN!"
					);
		}else if(!p1.equals("     -") && !p2.equals("     -") && !p3.equals("     -") && !p4.equals("     -") && !p5.equals("     -") && !p6.equals("     -") && !p7.equals("     -") && p8.equals("     -") && p9.equals("     -") && p10.equals("     -")){
			receiptArea.append("\n"+
					"\t                          ESTIMATION\n"+
					"\n"+
					"  Estimation No: "+billNo+
					"\t                                     Date: "+date+
					"\n  Cust Name: "+user+
					"\n========================================================= \n"+
					" PRODUCT\tMRP\tCOST\tQTY\tAMT   "+
					"\n========================================================= \n"+
					" "+p1+"\t "+Mrp1+"\t "+Rate1+"\t "+Qty1+"\t"+Value1+"\n"+
					" "+p2+"\t "+Mrp2+"\t "+Rate2+"\t "+Qty2+"\t"+Value2+"\n"+
					" "+p3+"\t "+Mrp3+"\t "+Rate3+"\t "+Qty3+"\t"+Value3+"\n"+
					" "+p4+"\t "+Mrp4+"\t "+Rate4+"\t "+Qty4+"\t"+Value4+"\n"+
					" "+p5+"\t "+Mrp5+"\t "+Rate5+"\t "+Qty5+"\t"+Value5+"\n"+
					" "+p6+"\t "+Mrp6+"\t "+Rate6+"\t "+Qty6+"\t"+Value6+"\n"+
					" "+p7+"\t "+Mrp7+"\t "+Rate7+"\t "+Qty7+"\t"+Value7+" "+
					"\n========================================================= \n"+
					"                                                                                           NET AMT        "+grandTotal+
					"\n========================================================= \n"+
					" TOTAL ITEMS     :"+totalQty+"\n"+
					"                                                  THANKS VISIT AGAIN!"
					);
		}else if(!p1.equals("     -") && !p2.equals("     -") && !p3.equals("     -") && !p4.equals("     -") && !p5.equals("     -") && !p6.equals("     -") && !p7.equals("     -") && !p8.equals("     -") && p9.equals("     -") && p10.equals("     -")){
			receiptArea.append("\n"+
					"\t                          ESTIMATION\n"+
					"\n"+
					"  Estimation No: "+billNo+
					"\t                                     Date: "+date+
					"\n  Cust Name: "+user+
					"\n========================================================= \n"+
					" PRODUCT\tMRP\tCOST\tQTY\tAMT   "+
					"\n========================================================= \n"+
					" "+p1+"\t "+Mrp1+"\t "+Rate1+"\t "+Qty1+"\t"+Value1+"\n"+
					" "+p2+"\t "+Mrp2+"\t "+Rate2+"\t "+Qty2+"\t"+Value2+"\n"+
					" "+p3+"\t "+Mrp3+"\t "+Rate3+"\t "+Qty3+"\t"+Value3+"\n"+
					" "+p4+"\t "+Mrp4+"\t "+Rate4+"\t "+Qty4+"\t"+Value4+"\n"+
					" "+p5+"\t "+Mrp5+"\t "+Rate5+"\t "+Qty5+"\t"+Value5+"\n"+
					" "+p6+"\t "+Mrp6+"\t "+Rate6+"\t "+Qty6+"\t"+Value6+"\n"+
					" "+p7+"\t "+Mrp7+"\t "+Rate7+"\t "+Qty7+"\t"+Value7+"\n"+
					" "+p8+"\t "+Mrp8+"\t "+Rate8+"\t "+Qty8+"\t"+Value8+" "+
					"\n========================================================= \n"+
					"                                                                                           NET AMT        "+grandTotal+
					"\n========================================================= \n"+
					" TOTAL ITEMS     :"+totalQty+"\n"+
					"                                                  THANKS VISIT AGAIN!"
					);
		}else if(!p1.equals("     -") && !p2.equals("     -") && !p3.equals("     -") && !p4.equals("     -") && !p5.equals("     -") && !p6.equals("     -") && !p7.equals("     -") && !p8.equals("     -") && !p9.equals("     -") && p10.equals("     -")){
			receiptArea.append("\n"+
					"\t                          ESTIMATION\n"+
					"\n"+
					"  Estimation No: "+billNo+
					"\t                                     Date: "+date+
					"\n  Cust Name: "+user+
					"\n========================================================= \n"+
					" PRODUCT\tMRP\tCOST\tQTY\tAMT   "+
					"\n========================================================= \n"+
					" "+p1+"\t "+Mrp1+"\t "+Rate1+"\t "+Qty1+"\t"+Value1+"\n"+
					" "+p2+"\t "+Mrp2+"\t "+Rate2+"\t "+Qty2+"\t"+Value2+"\n"+
					" "+p3+"\t "+Mrp3+"\t "+Rate3+"\t "+Qty3+"\t"+Value3+"\n"+
					" "+p4+"\t "+Mrp4+"\t "+Rate4+"\t "+Qty4+"\t"+Value4+"\n"+
					" "+p5+"\t "+Mrp5+"\t "+Rate5+"\t "+Qty5+"\t"+Value5+"\n"+
					" "+p6+"\t "+Mrp6+"\t "+Rate6+"\t "+Qty6+"\t"+Value6+"\n"+
					" "+p7+"\t "+Mrp7+"\t "+Rate7+"\t "+Qty7+"\t"+Value7+"\n"+
					" "+p8+"\t "+Mrp8+"\t "+Rate8+"\t "+Qty8+"\t"+Value8+"\n"+
					" "+p9+"\t "+Mrp9+"\t "+Rate9+"\t "+Qty9+"\t"+Value9+" "+
					"\n========================================================= \n"+
					"                                                                                           NET AMT        "+grandTotal+
					"\n========================================================= \n"+
					" TOTAL ITEMS     :"+totalQty+"\n"+
					"                                                  THANKS VISIT AGAIN!"
					);
		}else{
		
		receiptArea.append("\n"+
				"\t                          ESTIMATION\n"+
				"\n"+
				"  Estimation No: "+billNo+
				"\t                                     Date: "+date+
				"\n  Cust Name: "+user+
				"\n========================================================= \n"+
				" PRODUCT\tMRP\tCOST\tQTY\tAMT   "+
				"\n========================================================= \n"+
				" "+p1+"\t "+Mrp1+"\t "+Rate1+"\t "+Qty1+"\t"+Value1+"\n"+
				" "+p2+"\t "+Mrp2+"\t "+Rate2+"\t "+Qty2+"\t"+Value2+"\n"+
				" "+p3+"\t "+Mrp3+"\t "+Rate3+"\t "+Qty3+"\t"+Value3+"\n"+
				" "+p4+"\t "+Mrp4+"\t "+Rate4+"\t "+Qty4+"\t"+Value4+"\n"+
				" "+p5+"\t "+Mrp5+"\t "+Rate5+"\t "+Qty5+"\t"+Value5+"\n"+
				" "+p6+"\t "+Mrp6+"\t "+Rate6+"\t "+Qty6+"\t"+Value6+"\n"+
				" "+p7+"\t "+Mrp7+"\t "+Rate7+"\t "+Qty7+"\t"+Value7+"\n"+
				" "+p8+"\t "+Mrp8+"\t "+Rate8+"\t "+Qty8+"\t"+Value8+"\n"+
				" "+p9+"\t "+Mrp9+"\t "+Rate9+"\t "+Qty9+"\t"+Value9+"\n"+
				" "+p10+"\t "+Mrp10+"\t "+Rate10+"\t "+Qty10+"\t"+Value10+" "+
				"\n========================================================= \n"+
				"                                                                                           NET AMT        "+grandTotal+
				"\n========================================================= \n"+
				" TOTAL ITEMS     :"+totalQty+"\n"+
				"                                                  THANKS VISIT AGAIN!"
				);
		}
		
		contentPane.add(receiptArea);
		
	}
}
