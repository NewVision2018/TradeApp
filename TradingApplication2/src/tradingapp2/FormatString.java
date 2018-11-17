package tradingapp2;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class FormatString extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String string= null;
	
	public FormatString(String string) {

		this.string = string;
		
	}
	
	public String drawString(Graphics g){
		
		Graphics2D g1 = (Graphics2D) g;
		
		g1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		g1.drawString(string, 40, 50);
		
		return string;
		
	}

}
