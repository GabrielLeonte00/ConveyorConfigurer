package ConveyorConfigurer.Classes.Components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Degree_transfer_module extends JLabel{

	private static final long serialVersionUID = 1L;
	private String title, H, V, P;
	private int preScaleWidth;
	private int interWidth;
	private int angle;

	public Degree_transfer_module(String H, String V, int preScaleWidth, int interWidth, int angle) {
		super();
		this.H = H;
		this.V = V;
		this.preScaleWidth = preScaleWidth;
		this.interWidth = interWidth;
		this.angle = angle;
		title = "A0090";
		P = "72";
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		setBackground(Color.DARK_GRAY);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.scale(0.5, 0.5); // scale by 0.5wh
		g2d.setStroke(new BasicStroke(2.0f)); // Set the border thickness;
		int radius = preScaleWidth;
		g.setColor(Color.WHITE);
		drawCenteredArc(g2d, preScaleWidth - radius / 2, preScaleWidth - radius / 2, radius, angle);
		radius = radius - 35;
		drawCenteredArc(g2d, preScaleWidth - radius / 2, preScaleWidth - radius / 2, radius, angle);
		g.setColor(Color.RED);
		radius = radius - interWidth / 2; // for width 617+70
		drawCenteredArc(g2d, preScaleWidth - radius / 2, preScaleWidth - radius / 2, radius, angle);
		g.setColor(Color.WHITE);
		radius = 790;
		drawCenteredArc(g2d, preScaleWidth - radius / 2, preScaleWidth - radius / 2, radius, angle);
		radius = 790 + 35;
		drawCenteredArc(g2d, preScaleWidth - radius / 2, preScaleWidth - radius / 2, radius, angle);

		double radianAngle = Math.toRadians(angle);
		int x1 = (int) (preScaleWidth - preScaleWidth * Math.cos(radianAngle));
		int y1 = (int) (preScaleWidth - preScaleWidth * Math.sin(radianAngle));
		int x2 = (int) (preScaleWidth - 790 * Math.cos(radianAngle));
		int y2 = (int) (preScaleWidth - 790 * Math.sin(radianAngle));
		g2d.drawLine(x1, y1, x2, y2);

		g2d.drawLine(0, preScaleWidth, preScaleWidth - 790, preScaleWidth);
		
		// Set the font size
		Font font = new Font("Arial", Font.PLAIN, 20); // Change the font name and size as needed
        g.setFont(font);
        g.setColor(Color.GREEN);
        g.drawString("H = "+H, interWidth/2+75, preScaleWidth-150);
        g.setColor(Color.BLUE);
        g.drawString("V = "+V, interWidth/2+75, preScaleWidth-125);
        g.setColor(Color.CYAN);
        g.drawString("P = "+P, interWidth/2+75, preScaleWidth-100);
        
        // Set the font size
        font = new Font("Arial", Font.PLAIN, 30); // Change the font name and size as needed
        g.setFont(font);
        //AddText
        g.setColor(Color.MAGENTA);
    	g.drawString(title, interWidth/2+75, preScaleWidth-60);
		 
		g2d.dispose();

	}

	public void drawCenteredArc(Graphics2D g2d, int x, int y, int r, int angle) {
		x = x - (r / 2);
		y = y - (r / 2);
		g2d.drawArc(x, y, 2 * r, 2 * r, 180 - angle, 90);
	}
	
}
