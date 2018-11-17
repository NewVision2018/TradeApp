package tradingapp5;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	 
	 JLabel lblQty;
	 JLabel lblRate;
	 JLabel lblValue;
	 
	 JTextField textFieldForQty1;
	 JTextField textFieldForRate1;
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
	 JLabel lblForTraders;
	 
	 JTextField textFieldForSearch1;
	 
	 JTextField textFieldForMrp1;
	 
	 JLabel lblCompanyName;
	 
	 DefaultTableModel dtm;
	 
	 private JTable table;
	 private JButton btnRemove;
	 
//	 JLabel lblCompanyAddress;
//	 JLabel lblCompanyGstin;
	 
	public void clearValues(){
	 
	 	comboBox1.removeAllItems();
		
		textFieldForQty1.setText("0");
		
		textFieldForRate1.setText("0");
		
		textFieldForMrp1.setText("0");
		
		textFieldForValue1.setText("0"); 
		
		textFieldForSearch1.setText("");
		
	}
	
	public void resetData(){
		
		comboBox1.removeAllItems();
		
		textFieldForQty1.setText("0");
		
		textFieldForRate1.setText("0");
		
		textFieldForMrp1.setText("0");
		
		textFieldForValue1.setText("0");
		
		textFieldTo.setText("");
		textAreaAddress.setText("");
		textFieldGstin.setText("");
		
		textFieldSubTotal.setText("0");
		textFieldTotalQty.setText("0");
		textFieldGrandTotal.setText("0");
		
		textFieldBillNo.setText("");
		textFieldDate.setText("");
		
		textFieldForSearch1.setText("");
		
	}
	
	public Integer totalQuantity(){
		
		Integer totalQuantity = 0; 
		
		int rowCount = (Integer)dtm.getRowCount();
		
		int i;
		
		for(i=0; i<rowCount; i++){
			
			Object qtyValue = dtm.getValueAt(i, 1);
			
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
			
			Object value = dtm.getValueAt(i, 4);
			
			Double val = Double.parseDouble(value.toString());
			
			totalValue = totalValue + val;
			
		}
		
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
				
			}
		});
		textFieldForQty1.setBounds(217, 197, 86, 20);
		contentPane.add(textFieldForQty1);
		textFieldForQty1.setColumns(10);
		
		textFieldForMrp1 = new JTextField();
		textFieldForMrp1.setBackground(Color.WHITE);
		textFieldForMrp1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForMrp1.setBounds(334, 197, 86, 20);
		contentPane.add(textFieldForMrp1);
		textFieldForMrp1.setColumns(10);
		textFieldForMrp1.setText("0");
		
		textFieldForRate1 = new JTextField();
		textFieldForRate1.setBackground(Color.WHITE);
		textFieldForRate1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate1.setBounds(447, 197, 86, 20);
		contentPane.add(textFieldForRate1);
		textFieldForRate1.setColumns(10);
		textFieldForRate1.setText("0");
		
		textFieldForValue1 = new JTextField();
		textFieldForValue1.setBackground(Color.WHITE);
		textFieldForValue1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue1.setBounds(576, 197, 86, 20);
		contentPane.add(textFieldForValue1);
		textFieldForValue1.setColumns(10);
		textFieldForValue1.setText("0");
		
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
		textFieldGrandTotal.setText("0.0");
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
		
		JButton btnSaveUser = new JButton("SAVE");
		btnSaveUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSaveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				getBillNo();
				
				try{
					
					String query = "INSERT INTO Users(BILL_NO, NAME, DATE, GSTIN, TOTAL_QTY, GRAND_TOTAL) VALUES (?, ?, ?, ?, ?, ?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, textFieldBillNo.getText());
					pst.setString(2, textFieldTo.getText());
					pst.setString(3, textFieldDate.getText());
					pst.setString(4, textFieldGstin.getText());
					pst.setString(5, textFieldTotalQty.getText());
					pst.setString(6, textFieldGrandTotal.getText());
					
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
		btnPrint.setBounds(19, 573, 77, 20);
		contentPane.add(btnPrint);*/
		
		/*JButton btnSnapShot = new JButton("Snap");
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
		contentPane.add(btnSnapShot);*/
		
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
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				resetData();
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(19, 610, 102, 20);
		contentPane.add(btnReset);
		
		JButton btnReceipt = new JButton("RECEIPT");
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TradeReceiptPojo trp = new TradeReceiptPojo();
				
				trp.resetValues();
				
				int rowCount = (Integer)dtm.getRowCount();
				
				int i;
				
				String[] comboBox = new String[rowCount];
				
				List<String> textFieldForQty = new ArrayList<String>();
				
				List<String> textFieldForRate = new ArrayList<String>();
				
				List<String> textFieldForMrp = new ArrayList<String>();
				
				List<String> textFieldForValue = new ArrayList<String>();
				
				for(i=0; i<rowCount; i++){
					
					Object oProduct = dtm.getValueAt(i, 0);
					Object oQuantity = dtm.getValueAt(i, 1);
					Object oMrp = dtm.getValueAt(i, 2);
					Object oRate = dtm.getValueAt(i, 3);
					Object oValue = dtm.getValueAt(i, 4);
					
					String product = oProduct.toString();
					String quantity = oQuantity.toString();
					String mrp = oMrp.toString();
					String rate = oRate.toString();
					String value = oValue.toString();
					
					comboBox[i] = product;
					textFieldForQty.add(quantity);
					textFieldForMrp.add(mrp);
					textFieldForRate.add(rate);
					textFieldForValue.add(value);
					
				}
				
				trp.setComboBox(comboBox);
				
				trp.setTextFieldForQty(textFieldForQty);
				
				trp.setTextFieldForRate(textFieldForRate);
				
				trp.setTextFieldForMrp(textFieldForMrp);
				
				trp.setTextFieldForValue(textFieldForValue);
				
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 652, 246);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.GREEN);
		scrollPane.setViewportView(table);
		
		dtm = new DefaultTableModel();
		
		table.setModel(dtm);
		
		dtm.addColumn("Products");
		dtm.addColumn("Qty");
		dtm.addColumn("Mrp");
		dtm.addColumn("Rate");
		dtm.addColumn("Value");
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Vector<Object> v = new Vector<Object>();
				
				v.add(comboBox1.getSelectedItem().toString());
				v.add(textFieldForQty1.getText());
				v.add(textFieldForMrp1.getText());
				v.add(textFieldForRate1.getText());
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
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(680, 196, 84, 23);
		contentPane.add(btnAdd);
		
		btnRemove = new JButton("REMOVE");
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
				
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemove.setBounds(680, 355, 84, 23);
		contentPane.add(btnRemove);
		
		JButton btnExport = new JButton("EXPORT");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TradeBillExcelReport tber = new TradeBillExcelReport();
				
				tber.setVisible(true);
				
				dispose();
				
			}
		});
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExport.setBounds(19, 551, 102, 20);
		contentPane.add(btnExport);
		
		getCompanyDetails();
		
		getCurrentDate();
		
		getBillNo();
		
	}
} 
