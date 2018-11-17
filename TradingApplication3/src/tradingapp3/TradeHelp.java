package tradingapp3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TradeHelp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradeHelp frame = new TradeHelp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String selectedName = "";
	String selectedGstn = "";

	/**
	 * Create the frame.
	 */
	public TradeHelp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Trade Application Help");
		setBounds(450, 100, 450, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 407);
		textArea.append("\n\t            TRADE APPLICATION GUIDE \n\n\n");
		textArea.append("     Customer Details      :\n\n");
		textArea.append("       1. NAME                     :   Name of the customer.\n");
		textArea.append("       2. GST NO                 :   GST No of the customer.\n");
		textArea.append("       3. SAVE                      :   Saves the customer in the database.\n");
		textArea.append("       4. S                             :   Searches for already visited customer.\n\n\n");
		textArea.append("     GST Returns               :\n\n");
		textArea.append("       1. BILL STORE          :   Can export excel with customer and bill data.\n");
		textArea.append("       2. S/C TAX STORE    :   Can export excel with s/c tax data.\n");
		textArea.append("       3. I TAX STORE          :   Can export excel with i tax data.\n\n\n");
		textArea.append("     Bill Zone                       :\n\n");
		textArea.append("       1. CGST/SGST          :   Navigates to cgst/sgst billing screen.\n");
		textArea.append("       2. IGST                        :   Navigates to igst billing screen.");
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Back To Application");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TradeGstType tgt = new TradeGstType(selectedName, selectedGstn);
				
				tgt.setVisible(true);
				
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(238, 429, 186, 23);
		contentPane.add(btnNewButton);
	}
}
