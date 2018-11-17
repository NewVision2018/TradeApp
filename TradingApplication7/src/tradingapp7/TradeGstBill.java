package tradingapp7;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import java.awt.Image;

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
	DefaultTableModel dtm;
	private JComboBox<String> comboBox1;
	private JComboBox<String> comboBox2;
	private JLabel lblQty;
	private JLabel lblRate;
	private JLabel lblValue;
	private JTextField textFieldForQty1;
	private JTextField textFieldForRate1;
	private JTextField textFieldForValue1;
	private JTextField textFieldTo;
	private JTextArea textAreaAddress;
	private JLabel lblGstin;
	private JTextField textFieldGstin;
	private JTextField textFieldSubTotal;
	private JTextField textFieldTotalQty;
	private JLabel lblSubTotal;
	private JLabel lblTotalQty;
	private JTextField textFieldGrandTotal;
	private JLabel lblGrandTotal;
	private JLabel lblCustNo;
	private JTextField textFieldCustNo;
	private JLabel lblNewLabel;
	private JTextField textFieldDate;
	private JLabel lblNumberToWord;
	private JLabel lblForTraders;
	private JTextField textFieldForSearch1;
	private JTextField textFieldForMrp1;
	private JLabel lblCompanyName;
	private JTable table;
	private JButton btnRemove;
	private JSeparator separator4;
	private JSeparator separator5;
	private JLabel lblGst;
	private JLabel labelDiscount;
	private JLabel labelGst;
	private JTextField textFieldDiscount;
	private JTextField textFieldGst;
	private JLabel labelDiscountPercentage;
	private JLabel labelPer;
	private JTextField textFieldDiscountPercentage;
	private JLabel lblSgst;
	private JLabel lblCgst;
	private JTextField textFieldSgst;
	private JTextField textFieldCgst;
	private JCheckBox checkBoxGst;
	private JCheckBox checkBoxDisc;
	// JLabel lblCompanyAddress;
	// JLabel lblCompanyGstin;
	private String companyName = "";
	private String companyAddress = "";
	private String companyGstin = "";

	private JButton btnReceipt;
	private JButton btnReset;
	private JButton btnSaveUser;
	private JTextField textFieldBillNo;
	private JLabel lblBillNo;

	public int count;
	private double gstPercentage = 0;
	private JSeparator separator;
	private JLabel lblPaymentMethod;

	public void clearValues() {

		comboBox1.removeAllItems();

		textFieldForQty1.setText("1");

		textFieldForRate1.setText("0");

		textFieldForMrp1.setText("0");

		textFieldForValue1.setText("0");

		textFieldForSearch1.setText("");

	}

	public void resetData() {

		comboBox1.removeAllItems();

		textFieldForQty1.setText("1");

		textFieldForRate1.setText("0");

		textFieldForMrp1.setText("0");

		textFieldForValue1.setText("0");

		textFieldTo.setText("");

		textAreaAddress.setText("");

		textFieldGstin.setText("");

		textFieldSubTotal.setText("0.0");

		textFieldTotalQty.setText("0");

		textFieldDiscountPercentage.setText("0");

		textFieldDiscount.setText("0.0");

		textFieldCgst.setText("0.0");

		textFieldSgst.setText("0.0");

		textFieldGst.setText("0.0");

		textFieldGrandTotal.setText("0.0");

		textFieldCustNo.setText("1");

		// textFieldDate.setText("");

		textFieldForSearch1.setText("");

		checkBoxGst.setSelected(false);

		checkBoxDisc.setSelected(false);

		textFieldBillNo.setText("");

		btnSaveUser.setEnabled(true);

		btnReceipt.setEnabled(false);

		btnReset.setEnabled(false);

		count--;

	}

	public Integer totalQuantity() {

		Integer totalQuantity = 0;

		int rowCount = (Integer) dtm.getRowCount();

		int i;

		for (i = 0; i < rowCount; i++) {

			Object qtyValue = dtm.getValueAt(i, 1);

			int qtyVal = Integer.parseInt(qtyValue.toString());

			totalQuantity = totalQuantity + qtyVal;

		}

		return totalQuantity;

	}

	public Double totalValue() {

		Double totalValue = 0.0;

		int rowCount = (Integer) dtm.getRowCount();

		int i;

		for (i = 0; i < rowCount; i++) {

			Object value = dtm.getValueAt(i, 4);

			Double val = Double.parseDouble(value.toString());

			totalValue = totalValue + val;

		}

		return totalValue;

	}

	public void getCompanyDetails() {

		try {

			String query = "SELECT * FROM Company";

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				companyName = rs.getString("COMPANY_NAME");
				companyAddress = rs.getString("COMPANY_ADDRESS");
				companyGstin = rs.getString("COMPANY_GSTIN");

				lblCompanyName.setText(companyName);
				// lblCompanyAddress.setText(companyAddress);
				// lblCompanyGstin.setText(companyGstin);
				lblForTraders.setText(companyName);

			}

			rs.close();
			pst.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);

		}

	}

	public void getCurrentDate() {

		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		Calendar c = Calendar.getInstance();

		String date = (df.format(c.getTime())).toString();

		textFieldDate.setText(date);

	}

	public void getCustNo() {

		try {

			String query = "SELECT COUNT (*) FROM Users WHERE GSTIN=?";

			PreparedStatement pst = con.prepareStatement(query);

			if (textFieldGstin.getText() != null) {
				pst.setString(1, textFieldGstin.getText());
			} else {
				pst.setString(1, "");
			}

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				int custNo = rs.getInt(1);

				custNo = custNo + 1;

				String custNum = Integer.toString(custNo);

				textFieldCustNo.setText(custNum);

			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);

		}

	}

	public void fillComboBox() {

		try {

			String query = "SELECT * FROM PaymentGateway";

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			comboBox2.addItem("--SELECT--");

			while (rs.next()) {

				comboBox2.addItem(rs.getString("PAYMENTMETHOD"));

			}

			rs.close();
			pst.close();

		} catch (Exception e1) {

			e1.printStackTrace();

		}

	}

	public TradeGstBill() {

		setTitle("TAX INVOICE CASH/CREDIT");
		con = SQLiteConnection.sqliteDbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator1 = new JSeparator();
		separator1.setForeground(new Color(0, 0, 0));
		separator1.setBounds(10, 143, 876, 2);
		contentPane.add(separator1);

		JSeparator separator2 = new JSeparator();
		separator2.setBackground(new Color(0, 0, 0));
		separator2.setBounds(10, 507, 876, 2);
		contentPane.add(separator2);

		JSeparator separator3 = new JSeparator();
		separator3.setBackground(new Color(0, 0, 0));
		separator3.setOrientation(SwingConstants.VERTICAL);
		separator3.setBounds(359, 5, 2, 127);
		contentPane.add(separator3);

		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(908, 543, 432, 2);
		contentPane.add(separator);

		lblPaymentMethod = new JLabel("PAYMENT METHOD :");
		lblPaymentMethod.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPaymentMethod.setBounds(961, 578, 192, 14);
		contentPane.add(lblPaymentMethod);

		comboBox2 = new JComboBox<String>();
		comboBox2.setBackground(Color.WHITE);
		comboBox2.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox2.setBounds(1009, 649, 248, 20);
		contentPane.add(comboBox2);

		comboBox1 = new JComboBox<String>();
		comboBox1.addItem("     -");
		comboBox1.setBackground(Color.WHITE);
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String query = "SELECT * FROM Products WHERE DESCRIPTION=?";

					PreparedStatement pst = con.prepareStatement(query);

					pst.setString(1, (String) comboBox1.getSelectedItem());

					ResultSet rs = pst.executeQuery();

					while (rs.next()) {

						textFieldForRate1.setText(rs.getString("RATE"));

					}

					String qty1 = textFieldForQty1.getText();
					String rate1 = textFieldForRate1.getText();

					Double qty_1 = Double.parseDouble(qty1);
					Double rate_1 = Double.parseDouble(rate1);

					Double mulQtyRate1 = (qty_1 * rate_1);

					String value1 = String.format("%.2f", mulQtyRate1);

					textFieldForValue1.setText(value1);

					rs.close();
					pst.close();

				} catch (Exception e1) {

					e1.printStackTrace();

				}

			}
		});
		comboBox1.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox1.setBounds(10, 197, 199, 20);
		contentPane.add(comboBox1);

		JLabel lblDescription = new JLabel("PRODUCTS");
		lblDescription.setBackground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(43, 156, 135, 14);
		contentPane.add(lblDescription);

		lblQty = new JLabel("QTY");
		lblQty.setHorizontalAlignment(SwingConstants.CENTER);
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQty.setBackground(Color.WHITE);
		lblQty.setBounds(242, 156, 119, 14);
		contentPane.add(lblQty);

		lblRate = new JLabel("RATE");
		lblRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRate.setBackground(Color.WHITE);
		lblRate.setBounds(495, 156, 119, 14);
		contentPane.add(lblRate);

		lblValue = new JLabel("VALUE");
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValue.setBackground(Color.WHITE);
		lblValue.setBounds(624, 156, 110, 14);
		contentPane.add(lblValue);

		textFieldForQty1 = new JTextField();
		textFieldForQty1.setBackground(Color.WHITE);
		textFieldForQty1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForQty1.setText("1");

		textFieldForQty1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				try {

					String qty1 = textFieldForQty1.getText();
					String rate1 = textFieldForRate1.getText();

					Double qty_1 = Double.parseDouble(qty1);
					Double rate_1 = Double.parseDouble(rate1);

					Double mulQtyRate1 = (qty_1 * rate_1);

					String value1 = String.format("%.2f", mulQtyRate1);

					textFieldForValue1.setText(value1);

				} catch (Exception ex) {
					// ex.printStackTrace();
				}

			}
		});
		textFieldForQty1.setBounds(263, 197, 86, 20);
		contentPane.add(textFieldForQty1);
		textFieldForQty1.setColumns(10);

		textFieldForMrp1 = new JTextField();
		textFieldForMrp1.setBackground(Color.WHITE);
		textFieldForMrp1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForMrp1.setBounds(386, 197, 86, 20);
		contentPane.add(textFieldForMrp1);
		textFieldForMrp1.setColumns(10);
		textFieldForMrp1.setText("0");

		textFieldForRate1 = new JTextField();
		textFieldForRate1.setBackground(Color.WHITE);
		textFieldForRate1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForRate1.setBounds(513, 197, 86, 20);
		contentPane.add(textFieldForRate1);
		textFieldForRate1.setColumns(10);
		textFieldForRate1.setText("0");

		textFieldForValue1 = new JTextField();
		textFieldForValue1.setBackground(Color.WHITE);
		textFieldForValue1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForValue1.setBounds(636, 197, 86, 20);
		contentPane.add(textFieldForValue1);
		textFieldForValue1.setColumns(10);
		textFieldForValue1.setText("0");

		JLabel lblTo = new JLabel("TO :");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTo.setBounds(386, 22, 56, 14);
		contentPane.add(lblTo);

		textFieldTo = new JTextField();
		textFieldTo.setBackground(Color.WHITE);
		textFieldTo.setBounds(498, 21, 371, 20);
		contentPane.add(textFieldTo);
		textFieldTo.setColumns(10);

		textAreaAddress = new JTextArea();
		textAreaAddress.setBackground(Color.WHITE);
		textAreaAddress.setBounds(457, 47, 412, 59);
		contentPane.add(textAreaAddress);

		lblGstin = new JLabel("GSTIN/MOBILE :");
		lblGstin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGstin.setBounds(371, 118, 132, 14);
		contentPane.add(lblGstin);

		textFieldGstin = new JTextField();
		textFieldGstin.setBackground(Color.WHITE);
		textFieldGstin.setBounds(513, 117, 259, 20);
		contentPane.add(textFieldGstin);
		textFieldGstin.setColumns(10);

		textFieldSubTotal = new JTextField();
		textFieldSubTotal.setBackground(Color.WHITE);
		textFieldSubTotal.setText("0.0");
		textFieldSubTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSubTotal.setBounds(679, 520, 135, 20);
		contentPane.add(textFieldSubTotal);
		textFieldSubTotal.setColumns(10);

		textFieldTotalQty = new JTextField();
		textFieldTotalQty.setBackground(Color.WHITE);
		textFieldTotalQty.setText("0");
		textFieldTotalQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldTotalQty.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalQty.setColumns(10);
		textFieldTotalQty.setBounds(155, 520, 135, 20);
		contentPane.add(textFieldTotalQty);

		lblSubTotal = new JLabel("SUB TOTAL");
		lblSubTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSubTotal.setBounds(513, 523, 86, 17);
		contentPane.add(lblSubTotal);

		lblTotalQty = new JLabel("TOTAL QTY");
		lblTotalQty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalQty.setBounds(20, 523, 86, 14);
		contentPane.add(lblTotalQty);

		textFieldGrandTotal = new JTextField();
		textFieldGrandTotal.setText("0.0");
		textFieldGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldGrandTotal.setBackground(Color.WHITE);
		textFieldGrandTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGrandTotal.setBounds(679, 630, 135, 23);
		contentPane.add(textFieldGrandTotal);
		textFieldGrandTotal.setColumns(10);

		lblGrandTotal = new JLabel("GRAND TOTAL :");
		lblGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGrandTotal.setBounds(513, 625, 135, 32);
		contentPane.add(lblGrandTotal);

		lblCustNo = new JLabel("CUSTOMER NO :");
		lblCustNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustNo.setBounds(20, 84, 132, 14);
		contentPane.add(lblCustNo);

		textFieldCustNo = new JTextField("");
		textFieldCustNo.setBackground(Color.WHITE);
		textFieldCustNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCustNo.setBounds(189, 81, 148, 20);
		contentPane.add(textFieldCustNo);
		textFieldCustNo.setColumns(10);

		textFieldBillNo = new JTextField();
		textFieldBillNo.setBounds(189, 112, 148, 20);
		contentPane.add(textFieldBillNo);
		textFieldBillNo.setColumns(10);

		lblBillNo = new JLabel("BILL NO:");
		lblBillNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBillNo.setBounds(30, 118, 101, 14);
		contentPane.add(lblBillNo);

		lblNewLabel = new JLabel("DATE :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(30, 53, 125, 20);
		contentPane.add(lblNewLabel);

		textFieldDate = new JTextField();
		textFieldDate.setBackground(Color.WHITE);
		textFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldDate.setBounds(189, 53, 148, 20);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);

		lblCompanyName = new JLabel("");
		lblCompanyName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCompanyName.setBounds(10, 22, 266, 20);
		contentPane.add(lblCompanyName);

		btnSaveUser = new JButton("SAVE");
		btnSaveUser.setEnabled(true);
		btnSaveUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSaveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textFieldGstin.getText() != null && !textFieldGstin.getText().equalsIgnoreCase("")) {

					getCustNo();

					try {

						String query = "INSERT INTO Users(BILL_NO, NAME, DATE, GSTIN) VALUES (?, ?, ?, ?)";

						PreparedStatement pst = con.prepareStatement(query);

						pst.setString(1, textFieldCustNo.getText());
						// pst.setString(1, textFieldBillNo.getText());
						pst.setString(2, textFieldTo.getText());
						pst.setString(3, textFieldDate.getText());
						pst.setString(4, textFieldGstin.getText());

						pst.execute();

						JOptionPane.showMessageDialog(null, "User Data Saved");

						pst.close();

					} catch (Exception e) {

						e.printStackTrace();

					}

				} else {

					JOptionPane.showMessageDialog(null, "User Data Cannot be saved without GSTIN / Mobile number");

				}

				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

				String date = df.format(new Date());

				int count = 0;

				try {

					String query = "SELECT COUNT(*) AS COUNT FROM Today";

					PreparedStatement pst = con.prepareStatement(query);

					ResultSet rs = pst.executeQuery();

					while (rs.next()) {

						count = rs.getInt("COUNT");

					}

					rs.close();

					pst.close();

				} catch (Exception e) {

					e.printStackTrace();

				}

				if (count == 0) {

					try {

						String insertQuery = "INSERT INTO Today(SNO,DATE,COUNT) VALUES (?, ?, ?)";

						PreparedStatement insertPst = con.prepareStatement(insertQuery);

						insertPst.setString(2, date);
						insertPst.setInt(3, 1);

						insertPst.execute();

						insertPst.close();

					} catch (Exception e) {

						e.printStackTrace();

					}

				} else {

					String dbDate = "";

					int dbCount = 0;

					try {

						String query = "SELECT * FROM Today ORDER BY SNO DESC LIMIT 1";

						PreparedStatement pst = con.prepareStatement(query);

						ResultSet rs = pst.executeQuery();

						while (rs.next()) {

							dbDate = rs.getString("DATE");

							dbCount = rs.getInt("COUNT");

						}

						rs.close();

						pst.close();

					} catch (Exception e) {

						e.printStackTrace();

					}

					if (dbDate.equalsIgnoreCase(date)) {

						try {

							String updateQuery = "UPDATE Today SET COUNT = ? WHERE DATE = ?";

							PreparedStatement updatePst = con.prepareStatement(updateQuery);

							updatePst.setInt(1, dbCount + 1);

							updatePst.setString(2, date);

							updatePst.execute();

							updatePst.close();

						} catch (Exception e) {

							e.printStackTrace();

						}

					} else {

						try {

							String deleteQuery = "DELETE FROM Today";

							PreparedStatement deletePst = con.prepareStatement(deleteQuery);

							deletePst.execute();

							deletePst.close();

						} catch (Exception e) {

							e.printStackTrace();

						}

						try {

							String insertQuery = "INSERT INTO Today(SNO,DATE,COUNT) VALUES (?, ?, ?)";

							PreparedStatement insertPst = con.prepareStatement(insertQuery);

							insertPst.setString(2, date);
							insertPst.setInt(3, 1);

							insertPst.execute();

							insertPst.close();

						} catch (Exception e) {

							e.printStackTrace();

						}

					}

				}
				
				int countValue = 0;
				
				try {

					String query = "SELECT * FROM Today ORDER BY SNO DESC  LIMIT 1";

					PreparedStatement pst = con.prepareStatement(query);

					ResultSet rs = pst.executeQuery();

					while (rs.next()) {

						countValue = rs.getInt("COUNT");

					}

					rs.close();

					pst.close();

				} catch (Exception e) {

					e.printStackTrace();

				}

				String orderCount = String.valueOf(countValue);

				String mobile = null;

				if (textFieldGstin.getText() != null) {
					mobile = textFieldGstin.getText();
				} else {
					mobile = "";
				}

				String billNum = date + "-" + mobile + "-" + orderCount;

				textFieldBillNo.setText(billNum);

				btnSaveUser.setEnabled(false);
				btnReceipt.setEnabled(true);
				btnReset.setEnabled(true);

			}
		});
		// Image img = new
		// ImageIcon(this.getClass().getResource("/save-icon.png")).getImage();
		// btnSaveUser.setIcon(new ImageIcon(img));
		btnSaveUser.setBounds(803, 117, 66, 15);
		contentPane.add(btnSaveUser);

		lblNumberToWord = new JLabel("");
		lblNumberToWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberToWord.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumberToWord.setBounds(424, 668, 350, 20);
		contentPane.add(lblNumberToWord);

		Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());

		Long numberToWord_ = (new Double(numToWord_).longValue());

		String numberToWord = (String) EnglishNumberToWords.numberToWords(numberToWord_);

		lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));

		lblForTraders = new JLabel("");
		lblForTraders.setHorizontalAlignment(SwingConstants.CENTER);
		lblForTraders.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblForTraders.setBounds(498, 699, 278, 20);
		contentPane.add(lblForTraders);

		textFieldForSearch1 = new JTextField();
		textFieldForSearch1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				try {

					comboBox1.removeAllItems();

					String query = "SELECT DESCRIPTION FROM Products WHERE DESCRIPTION LIKE '"
							+ textFieldForSearch1.getText() + "%'";

					PreparedStatement pst = con.prepareStatement(query);

					ResultSet rs = pst.executeQuery();

					while (rs.next()) {

						comboBox1.addItem(rs.getString("DESCRIPTION"));

					}

					rs.close();
					pst.close();

				} catch (Exception e1) {

					e1.printStackTrace();

				}

			}
		});
		textFieldForSearch1.setBackground(Color.WHITE);
		textFieldForSearch1.setBounds(219, 197, 38, 20);
		contentPane.add(textFieldForSearch1);
		textFieldForSearch1.setColumns(10);

		btnReset = new JButton("RESET");
		btnReset.setEnabled(false);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					String query = "DELETE FROM Users WHERE GSTIN=? AND BILL_NO=?";

					PreparedStatement pst = con.prepareStatement(query);

					pst.setString(1, textFieldGstin.getText());
					pst.setString(2, textFieldCustNo.getText());

					pst.execute();

					pst.close();

				} catch (Exception e) {

					e.printStackTrace();

				}
				
				String dbDate = "";

				int dbCount = 0;

				try {

					String query = "SELECT * FROM Today ORDER BY SNO DESC LIMIT 1";

					PreparedStatement pst = con.prepareStatement(query);

					ResultSet rs = pst.executeQuery();

					while (rs.next()) {

						dbDate = rs.getString("DATE");

						dbCount = rs.getInt("COUNT");

					}

					rs.close();

					pst.close();

				} catch (Exception e) {

					e.printStackTrace();

				}
				
				try {

					String updateQuery = "UPDATE Today SET COUNT = ? WHERE DATE = ?";

					PreparedStatement updatePst = con.prepareStatement(updateQuery);

					updatePst.setInt(1, dbCount - 1);

					updatePst.setString(2, dbDate);

					updatePst.execute();

					updatePst.close();

				} catch (Exception e) {

					e.printStackTrace();

				}

				resetData();

			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(155, 663, 102, 20);
		contentPane.add(btnReset);

		btnReceipt = new JButton("RECEIPT");
		btnReceipt.setEnabled(false);
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TradeReceiptPojo trp = new TradeReceiptPojo();

				trp.resetValues();

				int rowCount = (Integer) dtm.getRowCount();

				int i;

				String[] comboBox = new String[rowCount];

				List<String> textFieldForQty = new ArrayList<String>();

				List<String> textFieldForRate = new ArrayList<String>();

				List<String> textFieldForMrp = new ArrayList<String>();

				List<String> textFieldForValue = new ArrayList<String>();

				for (i = 0; i < rowCount; i++) {

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

				trp.setTextFieldCustNo(textFieldCustNo.getText().toString());
				trp.setTextFieldDate(textFieldDate.getText().toString());

				trp.setLabelTitle1(lblCompanyName.getText().toString());
				// trp.setLabelTitle2(lblCompanyAddress.getText().toString());
				// trp.setLabelTitle3(lblCompanyGstin.getText().toString());

				trp.setLblNumberToWord(lblNumberToWord.getText().toString());

				trp.setCompanySignature(lblForTraders.getText().toString());

				trp.setTextFieldDiscount(textFieldDiscount.getText().toString());
				trp.setTextFieldGst(textFieldGst.getText().toString());
				trp.setCompanyName(companyName);
				trp.setCompanyAddress(companyAddress);
				trp.setCompanyGstIn(companyGstin);
				trp.setCustMobile(textFieldGstin.getText());
				trp.setTextFieldBillNo(textFieldBillNo.getText());
				trp.setPaymentMethod((String) comboBox2.getSelectedItem());
				trp.setGstPercentage(String.valueOf(gstPercentage));
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
		lblMrp.setBounds(366, 156, 119, 14);
		contentPane.add(lblMrp);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 236, 714, 246);
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

				Integer totalQty = (Integer) totalQuantity();

				String totalQuantity = String.valueOf(totalQty);

				textFieldTotalQty.setText(totalQuantity);

				Double totalVal = (Double) totalValue();

				String totalValue = String.format("%.3f", totalVal);

				textFieldSubTotal.setText(totalValue);

				Double discVal = Double.parseDouble(textFieldDiscount.getText());

				Double gstVal = Double.parseDouble(textFieldGst.getText());

				Double grandVal = totalVal + discVal + gstVal;

				String grandValue = String.format("%.3f", grandVal);

				textFieldGrandTotal.setText(grandValue);

				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());

				Long numberToWord_ = (new Double(numToWord_).longValue());

				String numberToWord = (String) EnglishNumberToWords.numberToWords(numberToWord_);

				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));

			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(769, 195, 84, 23);
		contentPane.add(btnAdd);

		btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();

				dtm.removeRow(row);

				Integer totalQty = (Integer) totalQuantity();

				String totalQuantity = String.valueOf(totalQty);

				textFieldTotalQty.setText(totalQuantity);

				Double totalVal = (Double) totalValue();

				String totalValue = String.format("%.3f", totalVal);

				textFieldSubTotal.setText(totalValue);

				Double discVal = Double.parseDouble(textFieldDiscount.getText());

				Double gstVal = Double.parseDouble(textFieldGst.getText());

				Double grandVal = totalVal + discVal + gstVal;

				String grandValue = String.format("%.3f", grandVal);

				textFieldGrandTotal.setText(grandValue);

				Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());

				Long numberToWord_ = (new Double(numToWord_).longValue());

				String numberToWord = (String) EnglishNumberToWords.numberToWords(numberToWord_);

				lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));

			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemove.setBounds(769, 252, 84, 23);
		contentPane.add(btnRemove);

		separator4 = new JSeparator();
		separator4.setForeground(new Color(0, 0, 0));
		separator4.setOrientation(SwingConstants.VERTICAL);
		separator4.setBounds(896, 11, 2, 708);
		contentPane.add(separator4);

		separator5 = new JSeparator();
		separator5.setForeground(Color.BLACK);
		separator5.setBounds(908, 209, 432, 2);
		contentPane.add(separator5);

		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setBackground(Color.WHITE);
		lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscount.setBounds(925, 24, 119, 14);
		contentPane.add(lblDiscount);

		lblGst = new JLabel("GST Calculation");
		lblGst.setBackground(Color.WHITE);
		lblGst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGst.setHorizontalAlignment(SwingConstants.CENTER);
		lblGst.setBounds(925, 254, 171, 14);
		contentPane.add(lblGst);

		labelDiscount = new JLabel("AFTER DISCOUNT");
		labelDiscount.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelDiscount.setBounds(513, 562, 135, 17);
		contentPane.add(labelDiscount);

		labelGst = new JLabel("GST");
		labelGst.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelGst.setBounds(513, 597, 86, 17);
		contentPane.add(labelGst);

		textFieldDiscount = new JTextField();
		textFieldDiscount.setText("0.0");
		textFieldDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDiscount.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldDiscount.setColumns(10);
		textFieldDiscount.setBackground(Color.WHITE);
		textFieldDiscount.setBounds(679, 560, 135, 20);
		contentPane.add(textFieldDiscount);

		textFieldGst = new JTextField();
		textFieldGst.setText("0.0");
		textFieldGst.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGst.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldGst.setColumns(10);
		textFieldGst.setBackground(Color.WHITE);
		textFieldGst.setBounds(679, 595, 135, 20);
		contentPane.add(textFieldGst);

		labelDiscountPercentage = new JLabel("Discount Percentage : ");
		labelDiscountPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		labelDiscountPercentage.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelDiscountPercentage.setBackground(Color.WHITE);
		labelDiscountPercentage.setBounds(961, 96, 180, 28);
		contentPane.add(labelDiscountPercentage);

		labelPer = new JLabel("%");
		labelPer.setHorizontalAlignment(SwingConstants.CENTER);
		labelPer.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPer.setBackground(Color.WHITE);
		labelPer.setBounds(1217, 99, 20, 23);
		contentPane.add(labelPer);

		textFieldDiscountPercentage = new JTextField();
		textFieldDiscountPercentage.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				if (!textFieldDiscountPercentage.getText().equalsIgnoreCase("")) {

					String discountCap = "";

					try {

						String query = "SELECT * FROM Manipulations";

						PreparedStatement pst = con.prepareStatement(query);

						ResultSet rs = pst.executeQuery();

						while (rs.next()) {

							discountCap = rs.getString("DISCOUNT");

						}

						rs.close();
						pst.close();

					} catch (Exception ex) {
						ex.printStackTrace();
					}

					Integer totalQty = (Integer) totalQuantity();

					String totalQuantity = String.valueOf(totalQty);

					textFieldTotalQty.setText(totalQuantity);

					Double totalVal = (Double) totalValue();

					String totalValue = String.format("%.3f", totalVal);

					textFieldSubTotal.setText(totalValue);

					String subTotal = textFieldSubTotal.getText();
					String discPer = textFieldDiscountPercentage.getText();

					Double subTotal_1 = Double.parseDouble(subTotal);
					int discPer_1 = Integer.parseInt(discPer);

					Double disc_val = (subTotal_1 / 100) * discPer_1;

					Double disc_1 = 0.0;

					if (Double.parseDouble(discountCap) >= disc_val) {

						disc_1 = subTotal_1 - disc_val;

					} else {

						disc_1 = subTotal_1 - Double.parseDouble(discountCap);

					}

					String disc = String.format("%.3f", disc_1);

					textFieldDiscount.setText(disc);

					Double discVal = Double.parseDouble(textFieldDiscount.getText());

					Double gstVal = Double.parseDouble(textFieldGst.getText());

					Double grandVal = 0.0;

					if (totalVal - disc_1 == 0) {

						grandVal = totalVal + gstVal;

					} else {

						grandVal = discVal + gstVal;

					}

					String grandValue = String.format("%.3f", grandVal);

					textFieldGrandTotal.setText(grandValue);

					Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());

					Long numberToWord_ = (new Double(numToWord_).longValue());

					String numberToWord = (String) EnglishNumberToWords.numberToWords(numberToWord_);

					lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));

				}

			}
		});
		textFieldDiscountPercentage.setText("0");
		textFieldDiscountPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDiscountPercentage.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldDiscountPercentage.setBackground(Color.WHITE);
		textFieldDiscountPercentage.setBounds(1151, 97, 56, 30);
		textFieldDiscountPercentage.setEnabled(false);
		contentPane.add(textFieldDiscountPercentage);
		textFieldDiscountPercentage.setColumns(10);

		lblSgst = new JLabel("SGST : ");
		lblSgst.setHorizontalAlignment(SwingConstants.CENTER);
		lblSgst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSgst.setBackground(Color.WHITE);
		lblSgst.setBounds(961, 367, 180, 28);
		contentPane.add(lblSgst);

		lblCgst = new JLabel("CGST : ");
		lblCgst.setHorizontalAlignment(SwingConstants.CENTER);
		lblCgst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCgst.setBackground(Color.WHITE);
		lblCgst.setBounds(961, 467, 180, 28);
		contentPane.add(lblCgst);

		textFieldSgst = new JTextField();
		textFieldSgst.setText("0.0");
		textFieldSgst.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSgst.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldSgst.setBackground(Color.WHITE);
		textFieldSgst.setColumns(10);
		textFieldSgst.setBounds(1166, 367, 93, 30);
		textFieldSgst.setEnabled(false);
		contentPane.add(textFieldSgst);

		textFieldCgst = new JTextField();
		textFieldCgst.setText("0.0");
		textFieldCgst.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCgst.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldCgst.setBackground(Color.WHITE);
		textFieldCgst.setColumns(10);
		textFieldCgst.setBounds(1166, 467, 93, 30);
		textFieldCgst.setEnabled(false);
		contentPane.add(textFieldCgst);

		checkBoxGst = new JCheckBox("");
		checkBoxGst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				boolean checked = checkBoxGst.isSelected();

				if (checked) {

					textFieldSgst.setEnabled(true);
					textFieldCgst.setEnabled(true);

					Double subVal = Double.parseDouble(textFieldSubTotal.getText());
					Double discVal = Double.parseDouble(textFieldDiscount.getText());

					String query = "SELECT * FROM Manipulations";
					try {
						PreparedStatement pst = con.prepareStatement(query);

						ResultSet rs = pst.executeQuery();

						while (rs.next()) {

							gstPercentage = rs.getInt("GST");

						}

					} catch (Exception e) {
						e.printStackTrace();
					}
					// Double gstVal = (subVal/100)*(2.5);
					Double gstVal = (subVal / 100) * (gstPercentage / 2);

					textFieldSgst.setText(String.format("%.3f", gstVal));
					textFieldCgst.setText(String.format("%.3f", gstVal));

					Double gstValue = gstVal * 2;

					textFieldGst.setText(String.format("%.3f", gstValue));

					Double grandVal = 0.0;

					if (subVal - discVal == 0 || subVal - discVal == subVal) {
						grandVal = subVal + gstValue;
					} else if (subVal - discVal > 0) {
						grandVal = discVal + gstValue;
					}

					String grandValue = String.format("%.3f", grandVal);

					textFieldGrandTotal.setText(grandValue);

					Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());

					Long numberToWord_ = (new Double(numToWord_).longValue());

					String numberToWord = (String) EnglishNumberToWords.numberToWords(numberToWord_);

					lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));

				} else {

					Double subVal = Double.parseDouble(textFieldSubTotal.getText());
					Double discVal = Double.parseDouble(textFieldDiscount.getText());

					Double gstVal = 0.0;

					textFieldSgst.setText(String.format("%.3f", gstVal));
					textFieldCgst.setText(String.format("%.3f", gstVal));

					textFieldSgst.setEnabled(false);
					textFieldCgst.setEnabled(false);

					Double gstValue = gstVal * 2;

					textFieldGst.setText(String.format("%.3f", gstValue));

					Double grandVal = 0.0;

					if (subVal - discVal == 0 || subVal - discVal == subVal) {
						grandVal = subVal + gstValue;
					} else if (subVal - discVal > 0) {
						grandVal = discVal + gstValue;
					}

					String grandValue = String.format("%.3f", grandVal);

					textFieldGrandTotal.setText(grandValue);

					Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());

					Long numberToWord_ = (new Double(numToWord_).longValue());

					String numberToWord = (String) EnglishNumberToWords.numberToWords(numberToWord_);

					lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));

				}

			}
		});
		checkBoxGst.setBounds(1239, 252, 20, 23);
		contentPane.add(checkBoxGst);

		checkBoxDisc = new JCheckBox("");
		checkBoxDisc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				boolean checked = checkBoxDisc.isSelected();

				if (checked) {

					textFieldDiscountPercentage.setEnabled(true);

				} else {

					textFieldDiscountPercentage.setText("0");
					textFieldDiscountPercentage.setEnabled(false);

					Double subVal = Double.parseDouble(textFieldSubTotal.getText());
					textFieldDiscount.setText(String.format("%.3f", subVal));

					Double gstValue = Double.parseDouble(textFieldGst.getText());

					Double grandVal = subVal + gstValue;

					String grandValue = String.format("%.3f", grandVal);

					textFieldGrandTotal.setText(grandValue);

					Double numToWord_ = Double.parseDouble(textFieldGrandTotal.getText());

					Long numberToWord_ = (new Double(numToWord_).longValue());

					String numberToWord = (String) EnglishNumberToWords.numberToWords(numberToWord_);

					lblNumberToWord.setText(numberToWord.toString().concat(" ONLY"));

				}

			}

		});
		checkBoxDisc.setBounds(1239, 20, 20, 23);
		contentPane.add(checkBoxDisc);

		getCompanyDetails();

		getCurrentDate();

		getCustNo();

		fillComboBox();

	}
}
