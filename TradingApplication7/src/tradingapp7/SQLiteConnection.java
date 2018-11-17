package tradingapp7;

import java.sql.*;
import javax.swing.*;

public class SQLiteConnection {
	
	Connection con = null;
	
	public static Connection sqliteDbConnector(){
		
		try{
			
			Class.forName("org.sqlite.JDBC");
			
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\TradeApp\\STORE\\TradeMarket.sqlite");
			
		//	JOptionPane.showMessageDialog(null, "sqlite connection success");
			
			return con;
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
			return null;
			
		}
		
	}

}
