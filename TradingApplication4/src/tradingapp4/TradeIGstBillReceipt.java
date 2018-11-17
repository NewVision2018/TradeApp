package tradingapp4;

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
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class TradeIGstBillReceipt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	
	public TradeIGstBillReceipt(TradeReceiptPojo trp) {
		
		setTitle("TAX INVOICE CASH/CREDIT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 5, 1225, 755);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 221, 1189, 265);
		contentPane.add(scrollPane);
		
		String c1 = trp.getComboBox1();
		String c2 = trp.getComboBox2();
		String c3 = trp.getComboBox3();
		String c4 = trp.getComboBox4();
		String c5 = trp.getComboBox5();
		String c6 = trp.getComboBox6();
		String c7 = trp.getComboBox7();
		String c8 = trp.getComboBox8();
		String c9 = trp.getComboBox9();
		String c10 = trp.getComboBox10();
		
		String h1 = trp.getTextFieldForHsn1();
		String h2 = trp.getTextFieldForHsn2();
		String h3 = trp.getTextFieldForHsn3();
		String h4 = trp.getTextFieldForHsn4();
		String h5 = trp.getTextFieldForHsn5();
		String h6 = trp.getTextFieldForHsn6();
		String h7 = trp.getTextFieldForHsn7();
		String h8 = trp.getTextFieldForHsn8();
		String h9 = trp.getTextFieldForHsn9();
		String h10 = trp.getTextFieldForHsn10();
		
		String q1 = trp.getTextFieldForQty1();
		String q2 = trp.getTextFieldForQty2();
		String q3 = trp.getTextFieldForQty3();
		String q4 = trp.getTextFieldForQty4();
		String q5 = trp.getTextFieldForQty5();
		String q6 = trp.getTextFieldForQty6();
		String q7 = trp.getTextFieldForQty7();
		String q8 = trp.getTextFieldForQty8();
		String q9 = trp.getTextFieldForQty9();
		String q10 = trp.getTextFieldForQty10();
		
		String r1 = trp.getTextFieldForRate1();
		String r2 = trp.getTextFieldForRate2();
		String r3 = trp.getTextFieldForRate3();
		String r4 = trp.getTextFieldForRate4();
		String r5 = trp.getTextFieldForRate5();
		String r6 = trp.getTextFieldForRate6();
		String r7 = trp.getTextFieldForRate7();
		String r8 = trp.getTextFieldForRate8();
		String r9 = trp.getTextFieldForRate9();
		String r10 = trp.getTextFieldForRate10();
		
		String ig1 = trp.getTextFieldForIGst1();
		String ig2 = trp.getTextFieldForIGst2();
		String ig3 = trp.getTextFieldForIGst3();
		String ig4 = trp.getTextFieldForIGst4();
		String ig5 = trp.getTextFieldForIGst5();
		String ig6 = trp.getTextFieldForIGst6();
		String ig7 = trp.getTextFieldForIGst7();
		String ig8 = trp.getTextFieldForIGst8();
		String ig9 = trp.getTextFieldForIGst9();
		String ig10 = trp.getTextFieldForIGst10();
		
		String ia1 = trp.getTextFieldForIAmt1();
		String ia2 = trp.getTextFieldForIAmt2();
		String ia3 = trp.getTextFieldForIAmt3();
		String ia4 = trp.getTextFieldForIAmt4();
		String ia5 = trp.getTextFieldForIAmt5();
		String ia6 = trp.getTextFieldForIAmt6();
		String ia7 = trp.getTextFieldForIAmt7();
		String ia8 = trp.getTextFieldForIAmt8();
		String ia9 = trp.getTextFieldForIAmt9();
		String ia10 = trp.getTextFieldForIAmt10();
		
		String v1 = trp.getTextFieldForValue1();
		String v2 = trp.getTextFieldForValue2();
		String v3 = trp.getTextFieldForValue3();
		String v4 = trp.getTextFieldForValue4();
		String v5 = trp.getTextFieldForValue5();
		String v6 = trp.getTextFieldForValue6();
		String v7 = trp.getTextFieldForValue7();
		String v8 = trp.getTextFieldForValue8();
		String v9 = trp.getTextFieldForValue9();
		String v10 = trp.getTextFieldForValue10();
		
		String[] columns1 = new String[]{"SL","DESCRIPTION","IMEI","HSN","Qty","RATE","%IGST","IGST AMT","VALUE"};
		
		Object[][] rows1 = new Object[][]{
			{"1",c1,"",h1,q1,r1,ig1,ia1,v1},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"2",c2,"",h2,q2,r2,ig2,ia2,v2},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"3",c3,"",h3,q3,r3,ig3,ia3,v3},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""}
			/*{"4",c4,h4,q4,r4,ig4,ia4,v4},
			{"5",c5,h5,q5,r5,ig5,ia5,v5},
			{"6",c6,h6,q6,r6,ig6,ia6,v6},
			{"7",c7,h7,q7,r7,ig7,ia7,v7},
			{"8",c8,h8,q8,r8,ig8,ia8,v8},
			{"9",c9,h9,q9,r9,ig9,ia9,v9},
			{"10",c10,h10,q10,r10,ig10,ia10,v10}*/
			};
		
		table = new JTable(rows1, columns1);
		scrollPane.setViewportView(table);
		
		/*JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 565, 351, 125);
		contentPane.add(scrollPane_1);
		
		String va1 = trp.getTextFieldTValue1();
		String va2 = trp.getTextFieldTValue2();
		String va3 = trp.getTextFieldTValue3();
		String va4 = trp.getTextFieldTValue4();
		String va5 = trp.getTextFieldTValue5();
		
		String IG1 = trp.getTextFieldIGst1();
		String IG2 = trp.getTextFieldIGst2();
		String IG3 = trp.getTextFieldIGst3();
		String IG4 = trp.getTextFieldIGst4();
		String IG5 = trp.getTextFieldIGst5();
		
		String v = trp.getTextFieldTValue();
		String i = trp.getTextFieldIGst();
		
		String[] columns2 = new String[]{"TAX%","T.VALUE","IGST"};
		
		Object[][] rows2 = new Object[][]{
			{"       28%",va1,IG1},
			{"       18%",va2,IG2},
			{"       12%",va3,IG3},
			{"       5%",va4,IG4},
			{"       0%",va5,IG5},
			{"       Total",v,i}
		};
		
		table_1 = new JTable(rows2, columns2);
		scrollPane_1.setViewportView(table_1);*/
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 208, 1189, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 497, 1189, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(649, 72, 2, 125);
		contentPane.add(separator_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.append("   To  :    "+trp.getTextFieldTo());
		textArea.append("\n");
		textArea.append("  ");
		textArea.append("\n");
		textArea.append("   "+trp.getTextAreaAddress());
		//textArea.append("\n");
		textArea.append("\n");
		textArea.append("  ");
		textArea.append("\n");
		textArea.append("   GSTIN  :    "+trp.getTextFieldGstin());
		textArea.setBounds(715, 80, 484, 103);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textArea_1.setBackground(Color.WHITE);
		textArea_1.append("   "+trp.getLabelTitle1());
		textArea_1.setBounds(10, 61, 549, 31);
		contentPane.add(textArea_1);
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_9.setBackground(Color.WHITE);
		textArea_9.append("   "+trp.getLabelTitle2());
		textArea_9.append("\n");
		textArea_9.append("\n");
		textArea_9.append("   "+trp.getLabelTitle3());
		textArea_9.setBounds(10, 103, 549, 50);
		contentPane.add(textArea_9);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_2.setBackground(Color.WHITE);
		textArea_2.append("   INVOICE  :  "+trp.getTextFieldBillNo());
		textArea_2.setBounds(10, 164, 173, 22);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_3.setBackground(Color.WHITE);
		textArea_3.append("   DATE  :  "+trp.getTextFieldDate());
		textArea_3.setBounds(404, 164, 173, 22);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_4.setBackground(Color.WHITE);
		textArea_4.append("   TOTAL QTY  :  "+trp.getTextFieldTotalQty());
		textArea_4.setBounds(629, 510, 179, 22);
		contentPane.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_5.setBackground(Color.WHITE);
		textArea_5.append("   SUB TOTAL  :  "+trp.getTextFieldSubTotal());
		textArea_5.setBounds(1003, 510, 179, 22);
		contentPane.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_6.setBackground(Color.WHITE);
		textArea_6.append("   GRAND TOTAL  :  "+trp.getTextFieldGrandTotal());
		textArea_6.setBounds(1003, 543, 179, 22);
		contentPane.add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setLineWrap(true);
		textArea_7.setWrapStyleWord(true);
		textArea_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textArea_7.setBackground(Color.WHITE);
		textArea_7.append("");
		textArea_7.append(trp.lblNumberToWord);
		textArea_7.setBounds(715, 583, 467, 31);
		contentPane.add(textArea_7);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setLineWrap(true);
		textArea_8.setWrapStyleWord(true);
		textArea_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_8.setBackground(Color.WHITE);
		textArea_8.append(trp.companySignature);
		textArea_8.setBounds(776, 631, 406, 22);
		contentPane.add(textArea_8);
		
		/*JLabel lblTaxSummary = new JLabel("TAX SUMMARY");
		lblTaxSummary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTaxSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxSummary.setBounds(117, 540, 93, 14);
		contentPane.add(lblTaxSummary);*/
		
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
		btnPrint.setBounds(504, 676, 40, 9);
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
		btnBack.setBounds(571, 676, 40, 9);
		contentPane.add(btnBack);
		
		JLabel lblTaxInvoice = new JLabel("TAX INVOICE");
		lblTaxInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxInvoice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTaxInvoice.setBounds(571, 11, 108, 14);
		contentPane.add(lblTaxInvoice);
		
		JLabel lblCashcredit = new JLabel("( CASH/CREDIT )");
		lblCashcredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCashcredit.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCashcredit.setBounds(571, 36, 108, 14);
		contentPane.add(lblCashcredit);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 572, 473, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setBounds(0, 0, 473, 81);
		panel.add(textArea_10);
		textArea_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textArea_10.setBackground(Color.WHITE);
		textArea_10.append("1. All disputes are subject to --------- Jurisdiction.");
		textArea_10.append("\n");
		textArea_10.append("2. Goods once sold can not be taken back or exchanged.");
		textArea_10.append("\n");
		textArea_10.append("3. Service & Repair contact respective service centers.");
		
		JLabel lblTermsAndConditions = new JLabel("Terms & Conditions :");
		lblTermsAndConditions.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTermsAndConditions.setBounds(26, 547, 157, 14);
		contentPane.add(lblTermsAndConditions);
		
	}
}
