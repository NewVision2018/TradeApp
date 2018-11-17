package tradingapp3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import tradingapp3.TradeReceiptPojo;

public class TradeSCGstBillReceipt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	
	String[] description;
	List<String> hsn;
	List<String> quantity;
	List<String> rate;
	List<String> sGst;
	List<String> sAmt;
	List<String> cGst;
	List<String> cAmt;
	List<String> value;
	
	DefaultTableModel dtm;
	
	TradeReceiptPojo trp;
	private JTable table_2;
	
	public TradeSCGstBillReceipt(TradeReceiptPojo trp) {
		
		this.trp = trp;
		
		setTitle("TAX INVOICE CASH/CREDIT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 35, 925, 675);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 234, 889, 183);
		contentPane.add(scrollPane);
		
		description = trp.getComboBox();
		
		hsn = trp.getTextFieldForHsn();
		
		quantity = trp.getTextFieldForQty();
		
		rate = trp.getTextFieldForRate();
		
		sGst = trp.getTextFieldForSGst();
		
		sAmt = trp.getTextFieldForSAmt();
		
		cGst = trp.getTextFieldForCGst();
		
		cAmt = trp.getTextFieldForCAmt();
		
		value = trp.getTextFieldForValue();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		dtm = new DefaultTableModel();
		
		table.setModel(dtm);
		
		dtm.addColumn("DESCRIPTION");
		dtm.addColumn("HSN");
		dtm.addColumn("QTY");
		dtm.addColumn("RATE");
		dtm.addColumn("%SGST");
		dtm.addColumn("SGST AMT");
		dtm.addColumn("%CGST");
		dtm.addColumn("CGST AMT");
		dtm.addColumn("VALUE");
		
		int i;
		
		for(i=0; i<description.length; i++){
			
		Vector<Object> v = new Vector<Object>();	
			
		v.add(description[i]);
		v.add(hsn.get(i));
		v.add(quantity.get(i));
		v.add(rate.get(i));
		v.add(sGst.get(i));
		v.add(sAmt.get(i));
		v.add(cGst.get(i));
		v.add(cAmt.get(i));
		v.add(value.get(i));
		
		dtm.addRow(v);
		
		}
		
		/*String[] columns1 = new String[]{"SL","DESCRIPTION","HSN","Qty","RATE","%SGST","SGST AMT","%CGST","CGST AMT","VALUE"};
		
		Object[][] rows1 = new Object[][]{
			{"1",c1,h1,q1,r1,sg1,sa1,cg1,ca1,v1},
			{"2",c2,h2,q2,r2,sg2,sa2,cg2,ca2,v2},
			{"3",c3,h3,q3,r3,sg3,sa3,cg3,ca3,v3},
			{"4",c4,h4,q4,r4,sg4,sa4,cg4,ca4,v4},
			{"5",c5,h5,q5,r5,sg5,sa5,cg5,ca5,v5},
			{"6",c6,h6,q6,r6,sg6,sa6,cg6,ca6,v6},
			{"7",c7,h7,q7,r7,sg7,sa7,cg7,ca7,v7},
			{"8",c8,h8,q8,r8,sg8,sa8,cg8,ca8,v8},
			{"9",c9,h9,q9,r9,sg9,sa9,cg9,ca9,v9},
			{"10",c10,h10,q10,r10,sg10,sa10,cg10,ca10,v10}
			};*/
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 471, 330, 119);
		contentPane.add(scrollPane_1);
		
		String va1 = trp.getTextFieldTValue1();
		String va2 = trp.getTextFieldTValue2();
		String va3 = trp.getTextFieldTValue3();
		String va4 = trp.getTextFieldTValue4();
		String va5 = trp.getTextFieldTValue5();
		
		String SG1 = trp.getTextFieldSGst1();
		String SG2 = trp.getTextFieldSGst2();
		String SG3 = trp.getTextFieldSGst3();
		String SG4 = trp.getTextFieldSGst4();
		String SG5 = trp.getTextFieldSGst5();
		
		String CG1 = trp.getTextFieldCGst1();
		String CG2 = trp.getTextFieldCGst2();
		String CG3 = trp.getTextFieldCGst3();
		String CG4 = trp.getTextFieldCGst4();
		String CG5 = trp.getTextFieldCGst5();
		
		String tv = trp.getTextFieldTValue();
		String s = trp.getTextFieldSGst();
		String g = trp.getTextFieldCGst();
		
		String[] columns2 = new String[]{"TAX%","T.VALUE","SGST","CGST"};
		
		Object[][] rows2 = new Object[][]{
			{"       28%",va1,SG1,CG1},
			{"       18%",va2,SG2,CG2},
			{"       12%",va3,SG3,CG3},
			{"       5%",va4,SG4,CG4},
			{"       0%",va5,SG5,CG5},
			{"       Total",tv,s,g}
		};
		
		table_1 = new JTable(rows2, columns2);
		scrollPane_1.setViewportView(table_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 208, 889, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 428, 889, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(516, 61, 2, 125);
		contentPane.add(separator_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.append("   To  :    "+trp.getTextFieldTo());
		textArea.append("\n");
		textArea.append(" -------------------------------------------------------------------------------- ");
		textArea.append("\n");
		textArea.append(trp.getTextAreaAddress());
		//textArea.append("\n");
		textArea.append("\n");
		textArea.append(" -------------------------------------------------------------------------------- ");
		textArea.append("\n");
		textArea.append("   GSTIN  :    "+trp.getTextFieldGstin());
		textArea.setBounds(528, 81, 371, 103);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_1.setBackground(Color.WHITE);
		textArea_1.append("   "+trp.getLabelTitle1());
		textArea_1.append("\n");
		textArea_1.append("\n");
		textArea_1.append("   "+trp.getLabelTitle2());
		textArea_1.append("\n");
		textArea_1.append("\n");
		textArea_1.append("   "+trp.getLabelTitle3());
		textArea_1.setBounds(10, 61, 496, 84);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_2.setBackground(Color.WHITE);
		textArea_2.append("   BILL NO  :  "+trp.getTextFieldBillNo());
		textArea_2.setBounds(10, 164, 173, 22);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_3.setBackground(Color.WHITE);
		textArea_3.append("   DATE  :  "+trp.getTextFieldDate());
		textArea_3.setBounds(299, 164, 173, 22);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_4.setBackground(Color.WHITE);
		textArea_4.append("   TOTAL QTY  :  "+trp.getTextFieldTotalQty());
		textArea_4.setBounds(472, 441, 179, 22);
		contentPane.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_5.setBackground(Color.WHITE);
		textArea_5.append("   SUB TOTAL  :  "+trp.getTextFieldSubTotal());
		textArea_5.setBounds(690, 441, 179, 22);
		contentPane.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_6.setBackground(Color.WHITE);
		textArea_6.append("   GRAND TOTAL  :  "+trp.getTextFieldGrandTotal());
		textArea_6.setBounds(690, 493, 179, 22);
		contentPane.add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setLineWrap(true);
		textArea_7.setWrapStyleWord(true);
		textArea_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textArea_7.setBackground(Color.WHITE);
		textArea_7.append("");
		textArea_7.append(trp.lblNumberToWord);
		textArea_7.setBounds(528, 535, 371, 22);
		contentPane.add(textArea_7);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setWrapStyleWord(true);
		textArea_8.setLineWrap(true);
		textArea_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_8.setBackground(Color.WHITE);
		textArea_8.append(trp.companySignature);
		textArea_8.setBounds(668, 568, 231, 22);
		contentPane.add(textArea_8);
		
		JLabel lblTaxSummary = new JLabel("TAX SUMMARY");
		lblTaxSummary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTaxSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxSummary.setBounds(118, 441, 93, 14);
		contentPane.add(lblTaxSummary);
		
		JButton btnPrint = new JButton("");
		btnPrint.setBackground(Color.WHITE);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PrinterJob pJob = PrinterJob.getPrinterJob();
				
				PageFormat preFormat = pJob.defaultPage();
				
				preFormat.setOrientation(PageFormat.LANDSCAPE);
				
				PageFormat postFormat = pJob.pageDialog(preFormat);
				
				if(preFormat != postFormat){
					
					 pJob.setPrintable(new Printer(contentPane), postFormat);
					 
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
		btnPrint.setBounds(432, 603, 40, 9);
		contentPane.add(btnPrint);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = trp.getTextFieldTo().toString();
				String gstNo = trp.getTextFieldGstin().toString();
				
				TradeGstType tgb = new TradeGstType(name, gstNo);
				
				tgb.setVisible(true);
				
				dispose();
				
			}
		});
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(488, 603, 40, 9);
		contentPane.add(btnBack);
		
		JLabel lblTaxInvoice = new JLabel("TAX INVOICE");
		lblTaxInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxInvoice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTaxInvoice.setBounds(410, 11, 108, 14);
		contentPane.add(lblTaxInvoice);
		
		JLabel lblCashcredit = new JLabel("( CASH/CREDIT )");
		lblCashcredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCashcredit.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCashcredit.setBounds(410, 36, 108, 14);
		contentPane.add(lblCashcredit);
		
	}
}
