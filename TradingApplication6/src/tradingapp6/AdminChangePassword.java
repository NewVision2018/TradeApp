package tradingapp6;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminChangePassword extends JFrame {

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
					AdminChangePassword frame = new AdminChangePassword();
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
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JPasswordField passwordFieldForCurrentPassword;
	private JPasswordField passwordFieldForNewPassword;
	private JPasswordField passwordFieldForConfirmPassword;
	
	public AdminChangePassword() {
		setTitle("Change Password");
		con = SQLiteConnection.sqliteDbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCurrentPassword = new JLabel("Current Password   :");
		lblCurrentPassword.setForeground(new Color(255, 0, 0));
		lblCurrentPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCurrentPassword.setBounds(44, 32, 159, 14);
		contentPane.add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password         :");
		lblNewPassword.setForeground(Color.RED);
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewPassword.setBounds(44, 75, 159, 14);
		contentPane.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password   :");
		lblConfirmPassword.setForeground(Color.RED);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConfirmPassword.setBounds(44, 114, 159, 14);
		contentPane.add(lblConfirmPassword);
		
		passwordFieldForCurrentPassword = new JPasswordField();
		passwordFieldForCurrentPassword.setBounds(213, 31, 177, 20);
		contentPane.add(passwordFieldForCurrentPassword);
		
		passwordFieldForNewPassword = new JPasswordField();
		passwordFieldForNewPassword.setBounds(213, 74, 177, 20);
		contentPane.add(passwordFieldForNewPassword);
		
		passwordFieldForConfirmPassword = new JPasswordField();
		passwordFieldForConfirmPassword.setBounds(213, 113, 177, 20);
		contentPane.add(passwordFieldForConfirmPassword);
		
		JButton btnChange = new JButton("CHANGE");
		btnChange.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation" })
			public void actionPerformed(ActionEvent arg0) {
				
				String currentPassword = passwordFieldForCurrentPassword.getText();
				String newPassword = passwordFieldForNewPassword.getText();
				String confirmPassword = passwordFieldForConfirmPassword.getText();
				
				try {
					
					String checkPassword = null;
					String AdminUser = null;
					
					String query = "SELECT * FROM Admin";
					
					pst = con.prepareStatement(query);
					
					rs = pst.executeQuery();
					
					while(rs.next()){
						
						checkPassword = rs.getString("PASSWORD");
						AdminUser = rs.getString("USERNAME");
						
						if(checkPassword.trim().equals(currentPassword.trim()) && newPassword.trim().equals(confirmPassword.trim()) && !currentPassword.trim().equals(newPassword.trim())){
							
							String queryUpdate = "UPDATE Admin SET PASSWORD = '" + newPassword + "' WHERE USERNAME = '" + AdminUser + "'";
							
							pst.close();
							rs.close();
							
							pst = con.prepareStatement(queryUpdate);
							
							pst.execute();
							
							pst.close();
							
							String message = "New password for admin updated successfully";
							
							JOptionPane.showMessageDialog(null, message);
							
						}
						else if(!checkPassword.trim().equals(currentPassword.trim())){
							
							String message = "Entered current password doesn't match with actual password";
							
							JOptionPane.showMessageDialog(null, message);
							
						}
						else if(!newPassword.trim().equals(confirmPassword.trim())){
							
							String message = "Entered new password doesn't match with confirm password";
							
							JOptionPane.showMessageDialog(null, message);
							
						}else if(currentPassword.trim().equals(newPassword.trim())){
							
							String message = "Entered current password and new password should not be same";
							
							JOptionPane.showMessageDialog(null, message);
							
						}
						
					}
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, e);
				
				}
				
			}
		});
		btnChange.setForeground(new Color(51, 0, 153));
		btnChange.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChange.setBounds(256, 162, 89, 23);
		contentPane.add(btnChange);
	}
}
