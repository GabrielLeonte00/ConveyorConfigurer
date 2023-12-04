package ConveyorConfigurer.Classes.Components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

public class Curve_roller_conveyor extends JLabel {

	private static final long serialVersionUID = 1L;
	private String title, H, V, P;
	private int preScaleWidth;
	private int interWidth;
	private int angle;
	private BufferedImage component;
	private String Component_name, Type_code;
	private String[] excelData = new String[22];

	public Curve_roller_conveyor(String H, String V, String title, int preScaleWidth, int interWidth, int angle) {
		super();
		this.H = H;
		this.V = V;
		this.title = title;
		this.preScaleWidth = preScaleWidth;
		this.interWidth = interWidth;
		this.angle = angle;
		Component_name = "Curve roller conveyor";
		Type_code = "G5303A";
		P = "72";
		createComponent();
		populateData();
	}

	void populateData() {
		excelData[0] = title;
		excelData[1] = Type_code;
		excelData[2] = Component_name;
		excelData[3] = "1";
		excelData[4] = "0";
		excelData[5] = Integer.toString(interWidth);
		excelData[6] = V;
		excelData[7] = H;
		excelData[10] = Integer.toString(angle);
		// excelData[12] = P;
	}

	public String[] getDataForExcel() {
		return excelData;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(component, 0, 0, this);
	}

	void createComponent() {
		component = new BufferedImage(preScaleWidth, preScaleWidth, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = component.createGraphics();

		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.scale(0.5, 0.5); // scale by 0.5wh
		g2d.setStroke(new BasicStroke(2.0f)); // Set the border thickness;
		int radius = preScaleWidth;
		g2d.setColor(Color.WHITE);
		drawCenteredArc(g2d, preScaleWidth - radius / 2, preScaleWidth - radius / 2, radius, angle);
		radius = radius - 35;
		drawCenteredArc(g2d, preScaleWidth - radius / 2, preScaleWidth - radius / 2, radius, angle);
		g2d.setColor(Color.RED);
		radius = radius - interWidth / 2; // for width 617+70
		drawCenteredArc(g2d, preScaleWidth - radius / 2, preScaleWidth - radius / 2, radius, angle);
		g2d.setColor(Color.WHITE);
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
		g2d.setFont(font);
		g2d.setColor(Color.GREEN);
		g2d.drawString("H = " + H, interWidth / 2 + 75, preScaleWidth - 150);
		g2d.setColor(Color.BLUE);
		g2d.drawString("V = " + V, interWidth / 2 + 75, preScaleWidth - 125);
		g2d.setColor(Color.CYAN);
		g2d.drawString("P = " + P, interWidth / 2 + 75, preScaleWidth - 100);

		// Set the font size
		font = new Font("Arial", Font.PLAIN, 30); // Change the font name and size as needed
		g2d.setFont(font);
		// AddText
		g2d.setColor(Color.MAGENTA);
		g2d.drawString(title, interWidth / 2 + 75, preScaleWidth - 60);

		g2d.dispose();
	}

	public void drawCenteredArc(Graphics2D g2d, int x, int y, int r, int angle) {
		x = x - (r / 2);
		y = y - (r / 2);
		g2d.drawArc(x, y, 2 * r, 2 * r, 180 - angle, 90);
	}

}
