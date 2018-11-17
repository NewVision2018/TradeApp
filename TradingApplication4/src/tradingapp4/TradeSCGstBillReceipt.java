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

public class TradeSCGstBillReceipt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	
	public TradeSCGstBillReceipt(TradeReceiptPojo trp) {
		
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
		
		String sg1 = trp.getTextFieldForSGst1();
		String sg2 = trp.getTextFieldForSGst2();
		String sg3 = trp.getTextFieldForSGst3();
		String sg4 = trp.getTextFieldForSGst4();
		String sg5 = trp.getTextFieldForSGst5();
		String sg6 = trp.getTextFieldForSGst6();
		String sg7 = trp.getTextFieldForSGst7();
		String sg8 = trp.getTextFieldForSGst8();
		String sg9 = trp.getTextFieldForSGst9();
		String sg10 = trp.getTextFieldForSGst10();
		
		String sa1 = trp.getTextFieldForSAmt1();
		String sa2 = trp.getTextFieldForSAmt2();
		String sa3 = trp.getTextFieldForSAmt3();
		String sa4 = trp.getTextFieldForSAmt4();
		String sa5 = trp.getTextFieldForSAmt5();
		String sa6 = trp.getTextFieldForSAmt6();
		String sa7 = trp.getTextFieldForSAmt7();
		String sa8 = trp.getTextFieldForSAmt8();
		String sa9 = trp.getTextFieldForSAmt9();
		String sa10 = trp.getTextFieldForSAmt10();
		
		String cg1 = trp.getTextFieldForCGst1();
		String cg2 = trp.getTextFieldForCGst2();
		String cg3 = trp.getTextFieldForCGst3();
		String cg4 = trp.getTextFieldForCGst4();
		String cg5 = trp.getTextFieldForCGst5();
		String cg6 = trp.getTextFieldForCGst6();
		String cg7 = trp.getTextFieldForCGst7();
		String cg8 = trp.getTextFieldForCGst8();
		String cg9 = trp.getTextFieldForCGst9();
		String cg10 = trp.getTextFieldForCGst10();
		
		String ca1 = trp.getTextFieldForCAmt1();
		String ca2 = trp.getTextFieldForCAmt2();
		String ca3 = trp.getTextFieldForCAmt3();
		String ca4 = trp.getTextFieldForCAmt4();
		String ca5 = trp.getTextFieldForCAmt5();
		String ca6 = trp.getTextFieldForCAmt6();
		String ca7 = trp.getTextFieldForCAmt7();
		String ca8 = trp.getTextFieldForCAmt8();
		String ca9 = trp.getTextFieldForCAmt9();
		String ca10 = trp.getTextFieldForCAmt10();
		
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
		
		String[] columns1 = new String[]{"SL","DESCRIPTION","IMEI","HSN","Qty","RATE","%SGST","SGST AMT","%CGST","CGST AMT","VALUE"};
		
		Object[][] rows1 = new Object[][]{
			{"1",c1,"",h1,q1,r1,sg1,sa1,cg1,ca1,v1},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"2",c2,"",h2,q2,r2,sg2,sa2,cg2,ca2,v2},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"3",c3,"",h3,q3,r3,sg3,sa3,cg3,ca3,v3},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""},
			{"","","","","","","","","","",""}
			/*{"4",c4,"",h4,q4,r4,sg4,sa4,cg4,ca4,v4},
			{"5",c5,"",h5,q5,r5,sg5,sa5,cg5,ca5,v5},
			{"6",c6,"",h6,q6,r6,sg6,sa6,cg6,ca6,v6},
			{"7",c7,"",h7,q7,r7,sg7,sa7,cg7,ca7,v7},
			{"8",c8,"",h8,q8,r8,sg8,sa8,cg8,ca8,v8},
			{"9",c9,"",h9,q9,r9,sg9,sa9,cg9,ca9,v9},
			{"10",c10,"",h10,q10,r10,sg10,sa10,cg10,ca10,v10}*/
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
		
		String v = trp.getTextFieldTValue();
		String s = trp.getTextFieldSGst();
		String g = trp.getTextFieldCGst();
		
		String[] columns2 = new String[]{"TAX%","T.VALUE","SGST","CGST"};
		
		Object[][] rows2 = new Object[][]{
			{"       28%",va1,SG1,CG1},
			{"       18%",va2,SG2,CG2},
			{"       12%",va3,SG3,CG3},
			{"       5%",va4,SG4,CG4},
			{"       0%",va5,SG5,CG5},
			{"       Total",v,s,g}
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
		textArea_9.append("   "+trp.getLabelTitle2());
		textArea_9.append("\n");
		textArea_9.append("\n");
		textArea_9.append("   "+trp.getLabelTitle3());
		textArea_9.setBackground(Color.WHITE);
		
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
		textArea_8.setWrapStyleWord(true);
		textArea_8.setLineWrap(true);
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
