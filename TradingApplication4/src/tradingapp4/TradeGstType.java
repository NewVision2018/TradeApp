package tradingapp4;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class TradeGstType extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldForName;
	private JTextField textFieldGstNo;
	JLabel lblTimeStamp;
	JButton btnCsgst;
	JButton btnIgst;
	
	String searchText;
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public String adminGstNo = "";

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradeGstType frame = new TradeGstType();
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
	
public String getBillNo(){
	
	int billNo = 0;
	String billNum = "";
		
		try{
			
			String query = "SELECT COUNT (*) FROM Users";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				
				billNo = rs.getInt(1);
				
				billNo = billNo +1;
				
				billNum = Integer.toString(billNo);
				
			}
			
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		return billNum;
		
	}

	String selectedName = ""; 
	String selectedGstn = "";
	
	public TradeGstType(String selectedName, String selectedGstn) {
		
		setTitle("Customer Details");
		
		con = SQLiteConnection.sqliteDbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 521);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(579, 47, 2, 424);
		contentPane.add(separator);
		
		JLabel lblName = new JLabel("NAME      :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(53, 119, 83, 14);
		contentPane.add(lblName);
		
		JLabel lblGstNo = new JLabel("GST NO   :");
		lblGstNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGstNo.setBounds(53, 161, 83, 14);
		contentPane.add(lblGstNo);
		
		textFieldForName = new JTextField();
		textFieldForName.setBounds(160, 118, 300, 20);
		textFieldForName.setText(selectedName);
		contentPane.add(textFieldForName);
		textFieldForName.setColumns(10);
		
		textFieldGstNo = new JTextField();
		/*textFieldGstNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if(textFieldGstNo.getText().length()==15){
				
				try{
					
					String query = "SELECT * FROM Company";
					
					pst = con.prepareStatement(query);
					
					rs = pst.executeQuery();
					
					while(rs.next()){
						
						adminGstNo = rs.getString("COMPANY_GSTIN").toString();
						
					}
					
					pst.close();
					rs.close();
					
					if(textFieldGstNo.getText().substring(0, 2).equals(adminGstNo.substring(0, 2))){
						
						btnCsgst.setEnabled(true);
						btnIgst.setEnabled(false);
						
					}else if(!textFieldGstNo.getText().substring(0, 2).equals(adminGstNo.substring(0, 2))){
						
						btnCsgst.setEnabled(false);
						btnIgst.setEnabled(true);
						
					}
					
				}catch(Exception e){
					
					e.printStackTrace();
					
				}
				
			}
			}
		});*/
		textFieldGstNo.setColumns(10);
		textFieldGstNo.setBounds(160, 160, 300, 20);
		textFieldGstNo.setText(selectedGstn);
		contentPane.add(textFieldGstNo);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBackground(UIManager.getColor("Button.background"));
		btnSave.setForeground(Color.BLUE);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String billNo = (String) getBillNo();
				
		//		if(textFieldGstNo.getText().length()==15){

				try{
					
					String query = "INSERT INTO Users(BILL_NO,NAME,GSTN,DATE,TAXABLE_VAL,CGST,SGST,IGST,TOTAL_AMT) VALUES (?,?,?,?,?,?,?,?,?)";
					
					pst = con.prepareStatement(query);
					
					pst.setString(1, billNo);
					pst.setString(2, textFieldForName.getText());
					pst.setString(3, textFieldGstNo.getText());
					pst.setString(4, "");
					pst.setString(5, "");
					pst.setString(6, "");
					pst.setString(7, "");
					pst.setString(8, "");
					pst.setString(9, "");
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "User Data Saved");
					
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
	/*		}else{
				
				JOptionPane.showMessageDialog(null, "GST NO should consists of 15 characters");
				
			}*/
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(258, 212, 89, 23);
		contentPane.add(btnSave);
		
		/*btnCsgst = new JButton("CGST/SGST");
		btnCsgst.setForeground(new Color(128, 0, 128));
		btnCsgst.setBackground(UIManager.getColor("Button.background"));
		btnCsgst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textFieldForName.getText().toString();
				String gstNo = textFieldGstNo.getText().toString();
				
				TradeSCGstBill tscgb = new TradeSCGstBill(name, gstNo);
				
				tscgb.setVisible(true);
				
				dispose();
				
			}
		});
		btnCsgst.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCsgst.setBounds(644, 121, 121, 23);
		btnCsgst.setEnabled(true);
		contentPane.add(btnCsgst);
		
		btnIgst = new JButton("IGST");
		btnIgst.setForeground(new Color(128, 0, 128));
		btnIgst.setBackground(UIManager.getColor("Button.background"));
		btnIgst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textFieldForName.getText().toString();
				String gstNo = textFieldGstNo.getText().toString();
				
				TradeIGstBill tigb = new TradeIGstBill(name, gstNo);
				
				tigb.setVisible(true);
				
				dispose();
				
			}
		});
		btnIgst.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIgst.setBounds(644, 179, 121, 23);
		btnIgst.setEnabled(false);
		contentPane.add(btnIgst);*/
		
		JButton btnReset = new JButton("RESET");
		btnReset.setForeground(Color.RED);
		btnReset.setBackground(UIManager.getColor("Button.background"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				textFieldForName.setText("");
				textFieldGstNo.setText("");
				
				btnCsgst.setEnabled(true);
				btnIgst.setEnabled(false);
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(658, 420, 89, 23);
		contentPane.add(btnReset);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(590, 393, 223, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(10, 287, 559, 2);
		contentPane.add(separator_2);
		
		JButton btnStore = new JButton("BILL STORE");
		btnStore.setForeground(new Color(0, 128, 128));
		btnStore.setBackground(UIManager.getColor("Button.background"));
		btnStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TradeBillExcelReport tber = new TradeBillExcelReport();
				
				tber.setVisible(true);
				
				dispose();
				
			}
		});
		btnStore.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStore.setBounds(326, 337, 157, 23);
		contentPane.add(btnStore);
		
		JButton btnSCTaxStore = new JButton("S/C TAX STORE");
		btnSCTaxStore.setForeground(new Color(0, 128, 128));
		btnSCTaxStore.setBackground(UIManager.getColor("Button.background"));
		btnSCTaxStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TradeSCTaxExcelReport tter = new TradeSCTaxExcelReport();
				
				tter.setVisible(true);
				
				dispose();
				
			}
		});
		btnSCTaxStore.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSCTaxStore.setBounds(326, 383, 157, 23);
		contentPane.add(btnSCTaxStore);
		
		JButton btnCustomerSearch = new JButton("s");
		btnCustomerSearch.setBackground(UIManager.getColor("Button.background"));
		btnCustomerSearch.setForeground(Color.BLUE);
		btnCustomerSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	searchText = textFieldForName.getText().substring(0,1);
				
				searchText = textFieldForName.getText().toString();
				
				if(!searchText.equals("")){
				
				TradeCustomerSearch tcs = new TradeCustomerSearch(searchText);
				
				tcs.setVisible(true);
				
				dispose();
				
				}
				
			}
		});
		btnCustomerSearch.setToolTipText("Search For Customer");
		btnCustomerSearch.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnCustomerSearch.setBounds(488, 121, 46, 16);
		contentPane.add(btnCustomerSearch);
		
		JButton btnITaxStore = new JButton("I TAX STORE");
		btnITaxStore.setForeground(new Color(0, 128, 128));
		btnITaxStore.setBackground(UIManager.getColor("Button.background"));
		btnITaxStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TradeITaxExcelReport tter = new TradeITaxExcelReport();
				
				tter.setVisible(true);
				
				dispose();
				
			}
		});
		btnITaxStore.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnITaxStore.setBounds(326, 430, 157, 23);
		contentPane.add(btnITaxStore);
		
		JLabel lblCustomerDetails = new JLabel("Customer Details :");
		lblCustomerDetails.setBackground(Color.WHITE);
		lblCustomerDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerDetails.setForeground(new Color(0, 0, 0));
		lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerDetails.setBounds(10, 53, 183, 23);
		contentPane.add(lblCustomerDetails);
		
		JLabel lblGstReturns = new JLabel("GST Returns :");
		lblGstReturns.setHorizontalAlignment(SwingConstants.CENTER);
		lblGstReturns.setForeground(Color.BLACK);
		lblGstReturns.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGstReturns.setBackground(Color.WHITE);
		lblGstReturns.setBounds(10, 321, 157, 23);
		contentPane.add(lblGstReturns);
		
		JLabel lblBilling = new JLabel("Bill Zone :");
		lblBilling.setHorizontalAlignment(SwingConstants.CENTER);
		lblBilling.setForeground(Color.BLACK);
		lblBilling.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBilling.setBackground(Color.WHITE);
		lblBilling.setBounds(589, 53, 114, 23);
		contentPane.add(lblBilling);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(589, 248, 223, 2);
		contentPane.add(separator_3);
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TradeHelp th = new TradeHelp();
				
				th.setVisible(true);
				
				dispose();
				
			}
		});
		btnHelp.setForeground(new Color(255, 0, 255));
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHelp.setBounds(658, 274, 89, 23);
		contentPane.add(btnHelp);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(590, 321, 223, 2);
		contentPane.add(separator_4);
		
		JButton btnBackup = new JButton("BACKUP");
		btnBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				databaseBackUp();
				
			}
		});
		btnBackup.setForeground(new Color(255, 140, 0));
		btnBackup.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBackup.setBounds(644, 348, 114, 23);
		contentPane.add(btnBackup);
		
		lblTimeStamp = new JLabel("");
		lblTimeStamp.setForeground(new Color(199, 21, 133));
		lblTimeStamp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTimeStamp.setBounds(670, 11, 143, 14);
		getClock();
		contentPane.add(lblTimeStamp);
		
		JRadioButton rdbtnSCGst = new JRadioButton(" SGST/CGST");
		rdbtnSCGst.setSelected(true);
		rdbtnSCGst.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnSCGst.setBounds(644, 96, 114, 23);
		contentPane.add(rdbtnSCGst);
		
		JRadioButton rdbtnIgst = new JRadioButton("      IGST");
		rdbtnIgst.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnIgst.setBounds(644, 136, 114, 23);
		contentPane.add(rdbtnIgst);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnSCGst);
		bg.add(rdbtnIgst);
		
		JButton btnBill = new JButton("BILL");
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnSCGst.isSelected()){
					
					String name = textFieldForName.getText().toString();
					String gstNo = textFieldGstNo.getText().toString();
					
					TradeSCGstBill tscgb = new TradeSCGstBill(name, gstNo);
					
					tscgb.setVisible(true);
					
					dispose();
					
				}
				
				if(rdbtnIgst.isSelected()){
					
					String name = textFieldForName.getText().toString();
					String gstNo = textFieldGstNo.getText().toString();
					
					TradeIGstBill tigb = new TradeIGstBill(name, gstNo);
					
					tigb.setVisible(true);
					
					dispose();
					
				}
				
			}
		});
		btnBill.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBill.setBounds(658, 190, 89, 23);
		contentPane.add(btnBill);
		
		ActionListener listerner = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				getClock();
			}	
		};
		
		Timer timer = new Timer(1000, listerner);
		timer.setRepeats(true);
		timer.setInitialDelay(0);
		timer.setCoalesce(true);
		timer.start();
		
	}
	
	public void databaseBackUp(){
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		File sourceFile = new File("C:\\TradeApp\\STORE\\TradeMarket.sqlite");
		File destinationFile = new File("C:\\TradeAppBackUp\\TradeMarket.sqlite");
		
		try {
			
			inputStream = new FileInputStream(sourceFile);
			outputStream = new FileOutputStream(destinationFile);
			
			byte[] buffer = new byte[1024];
			
			int length;
			
			while((length = inputStream.read(buffer)) > 0){
				
				outputStream.write(buffer, 0, length);
				
			}
			
			inputStream.close();
			outputStream.close();
			
			JOptionPane.showMessageDialog(null, "Database backup saved in C Drive - TradeAppBackUp");
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		
		}
		
	}
	
	public void getClock(){
		
		lblTimeStamp.setText(DateFormat.getDateTimeInstance().format(new Date()));
		
	}
}
