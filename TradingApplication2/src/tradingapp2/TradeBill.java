package tradingapp2;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TradeBill {

	private JFrame frmEstoreTradingSoftware;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradeBill window = new TradeBill();
					window.frmEstoreTradingSoftware.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField textFieldForUserName;
	private JPasswordField passwordFieldForPassword;

	/**
	 * Create the application.
	 */
	public TradeBill() {
		initialize();
		
		con = SQLiteConnection.sqliteDbConnector();
		
		JOptionPane.showMessageDialog(null, "Database connection success");
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmEstoreTradingSoftware = new JFrame();
		frmEstoreTradingSoftware.getContentPane().setBackground(new Color(204, 153, 255));
		frmEstoreTradingSoftware.setFont(new Font("Dialog", Font.BOLD, 15));
		frmEstoreTradingSoftware.setTitle("eStore Trading Software");
		frmEstoreTradingSoftware.setBounds(400, 250, 560, 275);
		frmEstoreTradingSoftware.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEstoreTradingSoftware.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(215, 50, 100, 27);
		frmEstoreTradingSoftware.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password   :");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(215, 96, 90, 27);
		frmEstoreTradingSoftware.getContentPane().add(lblPassword);
		
		textFieldForUserName = new JTextField();
		textFieldForUserName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldForUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldForUserName.setBounds(336, 55, 152, 20);
		frmEstoreTradingSoftware.getContentPane().add(textFieldForUserName);
		textFieldForUserName.setColumns(10);
		
		passwordFieldForPassword = new JPasswordField();
		passwordFieldForPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordFieldForPassword.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldForPassword.setBounds(336, 101, 152, 20);
		frmEstoreTradingSoftware.getContentPane().add(passwordFieldForPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.GREEN);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String query = "SELECT * FROM Admin WHERE USERNAME=? AND PASSWORD=?";
					
					pst = con.prepareStatement(query);
					
					pst.setString(1, textFieldForUserName.getText());
					pst.setString(2, passwordFieldForPassword.getText());
					
					rs = pst.executeQuery();
					
					int count=0;
					
					while(rs.next()){
						count=count+1;
					}
					
					if(count==1){
						
						JOptionPane.showMessageDialog(textFieldForUserName, "User name and password matches");
						
						frmEstoreTradingSoftware.dispose();
						
						TradeGstBill tda = new TradeGstBill();
						
						tda.setVisible(true);
						
					}else if(count>1){
						
						JOptionPane.showMessageDialog(textFieldForUserName, "Duplicated user name and password");
						
					}else{
						
						JOptionPane.showMessageDialog(textFieldForUserName, "User name or password incorrect");
						
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(null, e);
					
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(301, 163, 100, 27);
		frmEstoreTradingSoftware.getContentPane().add(btnLogin);
		
		JLabel lblImageIcon = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/shop-icon.png")).getImage();
		lblImageIcon.setIcon(new ImageIcon(img));
		lblImageIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageIcon.setBounds(28, 30, 166, 179);
		frmEstoreTradingSoftware.getContentPane().add(lblImageIcon);
		
		JLabel lblCopyRights = new JLabel("@CopyRights : New Vision");
		lblCopyRights.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCopyRights.setBounds(382, 211, 152, 14);
		frmEstoreTradingSoftware.getContentPane().add(lblCopyRights);
	}
}
