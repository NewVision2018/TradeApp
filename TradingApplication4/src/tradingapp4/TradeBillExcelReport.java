package tradingapp4;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import tradingapp4.SQLiteConnection;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TradeBillExcelReport extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	Connection con = null;
	
	String toDate = "";
	String fromDate = "";
	
	String dummyName = "";
	String dummyGstn = "";
	
	String billNoSelected = "";
	String nameSelected = "";
	String gstnSelected = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradeBillExcelReport frame = new TradeBillExcelReport();
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
	
	public void refreshTable(){
		
		try{
			
			String query = "SELECT BILL_NO, NAME, GSTN, DATE, TAXABLE_VAL, CGST, SGST, IGST, TOTAL_AMT FROM Users ORDER BY DATE ASC";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			rs.close();
			pst.close();
			
		}catch(Exception e1){
			
			e1.printStackTrace();
			
		}
		
	}
	
	public TradeBillExcelReport() {
		
		setTitle("Bill Collection Store");
		
		con = SQLiteConnection.sqliteDbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 890, 591);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(166, 50, 154, 20);
		contentPane.add(dateChooser1);
		
		JDateChooser dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(443, 50, 154, 20);
		contentPane.add(dateChooser2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 184, 854, 357);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
					
					int row = table.getSelectedRow();
					
					String billNo = (table.getModel().getValueAt(row, 0)).toString();
					
					String query = "SELECT * FROM Users WHERE BILL_NO='"+billNo+"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						
						billNoSelected = rs.getString("BILL_NO");
						nameSelected = rs.getString("NAME");
						gstnSelected = rs.getString("GSTN");
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblFromDate = new JLabel("FROM DATE :");
		lblFromDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFromDate.setBounds(35, 50, 110, 14);
		contentPane.add(lblFromDate);
		
		JLabel lblToDate = new JLabel("TO DATE :");
		lblToDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblToDate.setBounds(348, 50, 85, 14);
		contentPane.add(lblToDate);
		
		JButton btnCheck = new JButton("CHECK");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Date fromDates = dateChooser1.getDate();
				Date toDates = dateChooser2.getDate();
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				
				if(fromDates != null && toDates != null){
					
					toDate = df.format(toDates).toString();
					fromDate = df.format(fromDates).toString();
					
				}
				
				if(toDate.equals("") && fromDate.equals("")){
					
					refreshTable();
					
				}else{
				
				try{
					
					String query = "SELECT BILL_NO, NAME, GSTN, DATE, TAXABLE_VAL, CGST, SGST, IGST, TOTAL_AMT FROM Users WHERE DATE BETWEEN '"+fromDate+"' AND '"+toDate+"' ORDER BY DATE ASC";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					pst.close();
					
				}catch(Exception e){
					
					e.printStackTrace();
					
				}
				
				}
				
			}
		});
		btnCheck.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCheck.setBounds(733, 25, 99, 23);
		contentPane.add(btnCheck);
		
		JButton btnExport = new JButton("EXPORT");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String from = fromDate.replace("/", "-");
					String to = toDate.replace("/", "-");
					
					String fileName = "Store "+from+" To "+to+".xlsx";
					
					XSSFWorkbook workbook = new XSSFWorkbook();
					
					XSSFSheet sheet = workbook.createSheet("Bill Store");
					
					XSSFRow rowHead = sheet.createRow((short) 0);
					
					rowHead.createCell((short) 0).setCellValue("Bill No");
					rowHead.createCell((short) 1).setCellValue("NAME");
					rowHead.createCell((short) 2).setCellValue("GSTN");
					rowHead.createCell((short) 3).setCellValue("DATE");
					rowHead.createCell((short) 4).setCellValue("TAXABLE VAL");
					rowHead.createCell((short) 5).setCellValue("CGST");
					rowHead.createCell((short) 6).setCellValue("SGST");
					rowHead.createCell((short) 7).setCellValue("IGST");
					rowHead.createCell((short) 8).setCellValue("TOTAL AMT");
					
					String query = "SELECT BILL_NO, NAME, GSTN, DATE, TAXABLE_VAL, CGST, SGST, IGST, TOTAL_AMT FROM Users WHERE DATE BETWEEN '"+fromDate+"' AND '"+toDate+"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					int i = 1;
					
					while(rs.next()){
						
						XSSFRow row = sheet.createRow((short) i);
						
						row.createCell((short) 0).setCellValue(rs.getString("BILL_NO"));
						row.createCell((short) 1).setCellValue(rs.getString("NAME"));
						row.createCell((short) 2).setCellValue(rs.getString("GSTN"));
						row.createCell((short) 3).setCellValue(rs.getString("DATE"));
						row.createCell((short) 4).setCellValue(rs.getString("TAXABLE_VAL"));
						row.createCell((short) 5).setCellValue(rs.getString("CGST"));
						row.createCell((short) 6).setCellValue(rs.getString("SGST"));
						row.createCell((short) 7).setCellValue(rs.getString("IGST"));
						row.createCell((short) 8).setCellValue(rs.getString("TOTAL_AMT"));
						
						i++;
						
					}
					
					FileOutputStream fos = new FileOutputStream(new File("C:/TradeApp/EXPORTBILL/"+fileName+""));
					
				//	FileOutputStream fos = new FileOutputStream(fileName);
					
					workbook.write(fos);
					
					fos.close();
					
					JOptionPane.showMessageDialog(null, "Excel Exported To C Drive - TradeApp - EXPORTBILL");
					
					pst.close();
					rs.close();
					
				}catch(Exception e){
					
					e.printStackTrace();
					
				}
				
			}
		});
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExport.setBounds(733, 79, 99, 23);
		contentPane.add(btnExport);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TradeGstType tgt = new TradeGstType(dummyName, dummyGstn);
				
				tgt.setVisible(true);
				
				dispose();
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(733, 131, 99, 23);
		contentPane.add(btnBack);
		
		JButton btnDel = new JButton("DEL ?");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to delete selected record?");
				
				if(confirm == 0){
				
				if(!billNoSelected.equals("") && !nameSelected.equals("") && !gstnSelected.equals("")){
					
					try{
						
						String query = "DELETE FROM Users WHERE BILL_NO='"+billNoSelected+"' AND NAME='"+nameSelected+"' AND GSTN='"+gstnSelected+"'";
						
						PreparedStatement pst = con.prepareStatement(query);
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Record deleted");
						
						pst.close();
						
						refreshTable();
						
					}catch(Exception e){
						
						e.printStackTrace();
						
					}
					
				}else{
					
					JOptionPane.showMessageDialog(null, "No record selected");
					
				}
				
				}else{
					
					JOptionPane.showMessageDialog(null, "Deletion cancelled");
					
				}
				
			}
		});
		btnDel.setBackground(Color.RED);
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDel.setBounds(42, 133, 85, 23);
		contentPane.add(btnDel);
		
		refreshTable();
		
	}
}
