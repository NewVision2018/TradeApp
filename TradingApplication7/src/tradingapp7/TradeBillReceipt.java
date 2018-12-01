package tradingapp7;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tradingapp7.Printer;

import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JTextArea;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class TradeBillReceipt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextArea receiptArea;

	String date;

	String custNo;

	String companyName;

	String user;

	String grandTotal;

	String totalQty;

	String address;

	String subTotal;

	String discount;

	String gst;

	String companyAddress;

	String companyGstIn;

	String[] addressValues;

	String custMobile;

	String[] product;
	List<String> quantity;
	List<String> mrp;
	List<String> rate;
	List<String> value;

	String billNo;

	String paymentMethod;

	String gstPercentage;

	/**
	 * Launch the application.
	 */

	TradeReceiptPojo trp;

	public TradeBillReceipt(TradeReceiptPojo trp) {

		this.trp = trp;

		product = trp.getComboBox();

		quantity = trp.getTextFieldForQty();

		mrp = trp.getTextFieldForMrp();

		rate = trp.getTextFieldForRate();

		value = trp.getTextFieldForValue();

		custNo = trp.getTextFieldCustNo();

		date = trp.getTextFieldDate();

		companyName = trp.getLabelTitle1();

		user = trp.getTextFieldTo();

		grandTotal = trp.getTextFieldGrandTotal();

		totalQty = trp.getTextFieldTotalQty();

		address = trp.getTextAreaAddress();

		subTotal = trp.getTextFieldSubTotal();

		if (Double.valueOf(trp.getTextFieldDiscount()) != 0.0)
			discount = String.format(
					"%.3f",
					Double.valueOf(trp.getTextFieldSubTotal())
							- Double.valueOf(trp.getTextFieldDiscount()));
		else
			discount = "0.0";

		gst = trp.getTextFieldGst();

		companyAddress = trp.getCompanyAddress();

		companyGstIn = trp.getCompanyGstIn();

		addressValues = companyAddress.split(",");

		custMobile = trp.getCustMobile();

		paymentMethod = trp.getPaymentMethod();

		billNo = trp.getTextFieldBillNo();

		gstPercentage = trp.getGstPercentage();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(475, 0, 587, 768);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					Robot robot = new Robot();

					// Rectangle rectangle = new Rectangle(158, 13, 405, 707);

					Rectangle rectangle = new Rectangle(167, 45, 400, 670);

					BufferedImage billImage = robot
							.createScreenCapture(rectangle);

					String date = trp.getTextFieldDate();

					date = date.substring(0, date.indexOf(" "));

					String filePath = "C:/TradeApp/EXPORTBILL/" + date;

					File file = new File(filePath);

					file.mkdir();

					filePath = filePath + "/" + billNo + ".pdf";

					FileOutputStream fout = new FileOutputStream(filePath);

					Document document = new Document();

					PdfWriter writer = PdfWriter.getInstance(document, fout);

					document.open();

					Image image = Image.getInstance(billImage, null);

					Paragraph paragraph1 = new Paragraph("Merchant Copy");

					paragraph1.setAlignment(Paragraph.ALIGN_CENTER);

					document.add(paragraph1);

					document.add(image);

					Paragraph paragraph = new Paragraph(" ");

					document.add(paragraph);

					document.add(paragraph);

					document.add(paragraph);

					Paragraph paragraph2 = new Paragraph("Customer Copy");

					paragraph2.setAlignment(Paragraph.ALIGN_CENTER);

					document.add(paragraph2);

					document.add(image);

					document.close();

					fout.close();

					JOptionPane.showMessageDialog(null, "Bill Saved as PDF in "
							+ filePath);

				} catch (Exception e) {
					e.printStackTrace();
				}

				PrinterJob pJob = PrinterJob.getPrinterJob();

				PageFormat preFormat = pJob.defaultPage();

				preFormat.setOrientation(PageFormat.PORTRAIT);

				PageFormat postFormat = pJob.pageDialog(preFormat);

				if (preFormat != postFormat) {

					pJob.setPrintable(new Printer(receiptArea), postFormat);

					if (pJob.printDialog()) {

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

		// int i;
		//
		// for (i = 0; i < product.length; i++) {
		//
		// if (product[i].length() >= 10) {
		// product[i] = product[i].substring(0, 9);
		// } else {
		// product[i] = product[i];
		// }
		//
		// }

		receiptArea = new JTextArea();
		receiptArea.setBounds(156, 11, 405, 707);
		receiptArea
				.append("\n"
						+ "\t                              FUDOSPOT \n"
						+ "\t                      Little Place Big Taste\n"
						+ "\n"
						+ "  Cust No: "
						+ custNo
						+ "\t                                               Date: "
						+ date
						+ "\n  Bill No: "
						+ billNo
						+ "\n  Cust Name: "
						+ user
						+ "\n  Cust Address: "
						+ address
						+ "\n  Payment Method: "
						+ paymentMethod
						+ "\n========================================================= \n"
						+ " PRODUCT\t\tCOST\tQTY\tAMT   "
						+ "\n========================================================= \n");

		int a;

		for (a = 0; a < product.length; a++) {
			String str = null;
			String str1 = null;
			if (product[a].length() >= 10) {
				str1 = product[a].substring(10, product[a].length());
				str = product[a].substring(0, 9);
			} else {
				str = product[a];
			}
			receiptArea.append(" " + str + "\t\t " + rate.get(a) + "\t "
					+ quantity.get(a) + "\t" + value.get(a) + "\n");
			if (product[a].length() >= 10) {
				receiptArea.append(" " + str1 + "\n");
			}
		}

		if (Double.parseDouble(discount) > 0.0) {
			receiptArea
					.append("\n========================================================= \n"
							+ "                                                                                           Sub Total      "
							+ subTotal
							+ "\n                                                                                           Discount       - "
							+ discount
							+ "\n                                                                                           GST("
							+ gstPercentage
							+ "%)   + "
							+ gst
							+ "\n========================================================= "
							+ "\n                                                                                           NET AMT       "
							+ grandTotal
							+ "\n========================================================= \n"
							+ " TOTAL ITEMS     :"
							+ totalQty
							+ "\n"
							+ "                                                  "
							+ addressValues[0]
							+ "\n"
							+ "                                        "
							+ addressValues[1]
							+ "\n"
							+ "                                                       "
							+ addressValues[2]
							+ "\n"
							+ "                                                    "
							+ companyGstIn
							+ "\n"
							+ "                                             THANKS VISIT AGAIN!");

		} else {
			receiptArea
					.append("\n========================================================= \n"
							+ "                                                                                           Sub Total      "
							+ subTotal
							+ "\n                                                                                           GST("
							+ gstPercentage
							+ "%)   + "
							+ gst
							+ "\n========================================================= "
							+ "\n                                                                                           NET AMT       "
							+ grandTotal
							+ "\n========================================================= \n"
							+ " TOTAL ITEMS     :"
							+ totalQty
							+ "\n"
							+ "                                                  "
							+ addressValues[0]
							+ "\n"
							+ "                                        "
							+ addressValues[1]
							+ "\n"
							+ "                                                       "
							+ addressValues[2]
							+ "\n"
							+ "                                                    "
							+ companyGstIn
							+ "\n"
							+ "                                             THANKS VISIT AGAIN!");

		}

		contentPane.add(receiptArea);

	}
}
