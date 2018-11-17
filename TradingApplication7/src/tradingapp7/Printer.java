package tradingapp7;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class Printer implements Printable {
	
	final Component component;
	
	public Printer(Component component){
		
		this.component = component;
		
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		
		if(pageIndex>0){
			
			return Printable.NO_SUCH_PAGE;
			
		}
		
		// get the bounds of the component
		
		Dimension dim = component.getSize();
		
		double cHeight = dim.getHeight();
		
		double cWidth = dim.getWidth();
		
		// get the bounds of the printable area
		
		double pHeight = pageFormat.getImageableHeight();
		
		double pWidth = pageFormat.getImageableWidth();
		
		
		double pXStart = pageFormat.getImageableX();
		
		double pYStart = pageFormat.getImageableY();
		
		double xRatio = pWidth/cWidth;
		
		double yRatio = pHeight/cHeight;
		
		Graphics2D g1 = (Graphics2D) graphics;
		
		g1.translate(pXStart, pYStart);
		
		g1.scale(xRatio, yRatio);
		
		component.paint(g1);
 		
		return Printable.PAGE_EXISTS;
	
	}

}
