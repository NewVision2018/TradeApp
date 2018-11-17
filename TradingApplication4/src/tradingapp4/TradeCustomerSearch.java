package tradingapp4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TradeCustomerSearch extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradeCustomerSearch frame = new TradeCustomerSearch();
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
	
	String searchText;
    private JTable table;
    
    String selectedName;
    String selectedGstn;
	
	public void refreshTable(){
		
		try{
			
			String query = "SELECT NAME, GSTN FROM Users WHERE NAME LIKE '"+searchText+"%'";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			rs.close();
			pst.close();
			
		}catch(Exception e1){
			
			e1.printStackTrace();
			
		}
		
	}
	
	public TradeCustomerSearch(String searchText) {
		
		this.searchText=searchText;
		
		setTitle("Customer Search");
		
		con = SQLiteConnection.sqliteDbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 341);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 224);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
					
					int row = table.getSelectedRow();
					
					String name = (table.getModel().getValueAt(row, 0)).toString();
					
					String query = "SELECT NAME, GSTN FROM Users WHERE NAME='"+name+"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						
						selectedName = rs.getString("NAME");
						selectedGstn = rs.getString("GSTN");
						
					}
					
					rs.close();
					pst.close();
					
					if(!selectedName.equals("") && !selectedGstn.equals("")){
						
						TradeGstType tgt = new TradeGstType(selectedName, selectedGstn);
						
						tgt.setVisible(true);
						
						dispose();
						
					}
					
				}catch(Exception e1){
					
					e1.printStackTrace();
					
				}
				
			}
		});
		table.setBackground(new Color(0, 255, 255));
		scrollPane.setViewportView(table);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TradeGstType tgt = new TradeGstType(selectedName, selectedGstn);
				
				tgt.setVisible(true);
				
				dispose();
				
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnHome.setBounds(335, 268, 89, 23);
		contentPane.add(btnHome);
		
		refreshTable();
		
	}
}
