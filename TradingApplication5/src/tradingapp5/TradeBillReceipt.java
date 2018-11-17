package tradingapp5;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tradingapp5.Printer;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Iterator;
import java.util.List;
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
	
	String date;
	
	String billNo;
	
	String companyName;
	
	String user;
	
	String grandTotal;
	
	String totalQty;
	
	String[] product;
	List<String> quantity;
	List<String> mrp;
	List<String> rate;
	List<String> value;

	/**
	 * Launch the application.
	 */
	
	TradeReceiptPojo trp;
	
	public TradeBillReceipt(TradeReceiptPojo trp) {
		
		this.trp =trp;
		
		product = trp.getComboBox();
		
		quantity = trp.getTextFieldForQty();
		
		mrp = trp.getTextFieldForMrp();
		
		rate = trp.getTextFieldForRate();
		
		value = trp.getTextFieldForValue();
		
		billNo = trp.getTextFieldBillNo();
		
		date = trp.getTextFieldDate();
		
		companyName = trp.getLabelTitle1();
		
		user = trp.getTextFieldTo();
		
		grandTotal = trp.getTextFieldGrandTotal();
		
		totalQty = trp.getTextFieldTotalQty();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(475, 0, 587, 768);
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
		btnPrint.setBounds(10, 295, 89, 23);
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
		btnBack.setBounds(10, 346, 89, 23);
		contentPane.add(btnBack);
		
		int i;
		
		for(i=0; i<product.length; i++){
		
		if(product[i].length()>=10)
		{
			product[i] = product[i].substring(0,9);
		}
		else
		{
			product[i] = product[i];
		}
		
		}
		
		receiptArea = new JTextArea();
		receiptArea.setBounds(156, 11, 405, 707);
		receiptArea.append("\n"+
				"\t                          ESTIMATION\n"+
				"\n"+
				"  Estimation No: "+billNo+
				"\t                                     Date: "+date+
				"\n  Cust Name: "+user+
				"\n========================================================= \n"+
				" PRODUCT\tMRP\tCOST\tQTY\tAMT   "+
				"\n========================================================= \n");
				
				int a;
		
				for(a=0; a<product.length; a++){
				
		receiptArea.append(" "+product[a]+"\t "+mrp.get(a)+"\t "+rate.get(a)+"\t "+quantity.get(a)+"\t"+value.get(a)+"\n");
				
				}		
				
		receiptArea.append("\n========================================================= \n"+
				"                                                                                           NET AMT        "+grandTotal+
				"\n========================================================= \n"+
				" TOTAL ITEMS     :"+totalQty+"\n"+
				"                                                  THANKS VISIT AGAIN!"
				);
		contentPane.add(receiptArea);
		
	}
}
