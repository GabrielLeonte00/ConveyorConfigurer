package ConveyorConfigurer.Classes.Components;

import javax.swing.*;

import org.bouncycastle.util.Arrays;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;

public class Motorized_roller_conveyor extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String H, V, P;
	private int No_MDR, side;
	private int preScaleWidth, preScaleHeight;
	private String title;
	private BufferedImage component;
	private String Component_name, Type_code;
	private String[] excelData = new String[22];

	/**
	 * Constructor for the Motorized roller conveyor component
	 * 
	 * @param H              The height of the conveyor
	 * @param V              The speed of the conveyor
	 * @param P              The roller pitch of the conveyor
	 * @param title          Title of the component
	 * @param No_MDR         The number of MDR
	 * @param side           The side of the poly vee
	 * @param preScaleWidth  The prescaled width of the component
	 * @param preScaleHeigth The prescaled heigth of the component
	 */
	public Motorized_roller_conveyor(String H, String V, String P, String title, int No_MDR, int side,
			int preScaleWidth, int preScaleHeigth) {
		super();
		this.H = H;
		this.V = V;
		this.P = P;
		this.title = title;
		this.No_MDR = No_MDR;
		this.side = side;
		this.preScaleHeight = preScaleHeigth;
		this.preScaleWidth = preScaleWidth;
		Component_name = "Motorized roller conveyor";
		Type_code = "G5301A";
		Arrays.fill(excelData, "");
		createComponent();
		populateData();
	}

	void populateData() {
		excelData[0] = title;
		excelData[1] = Type_code;
		excelData[2] = Component_name;
		excelData[3] = "1";
		excelData[4] = Integer.toString(preScaleWidth);
		excelData[5] = Integer.toString(preScaleHeight - 70);
		excelData[6] = V;
		excelData[7] = H;
		excelData[12] = P;
		excelData[15] = Integer.toString(No_MDR);
		if (side == 0)
			excelData[16] = "L";
		else
			excelData[16] = "R";
	}
	
	public String[] getDataForExcel() {
		return excelData;
	}

	/**
	 * The new composition of the JPanel
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(component, 0, 0, this);

	}

	void createComponent() {
		component = new BufferedImage(preScaleWidth, preScaleHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = component.createGraphics();

		g2d.scale(0.5, 0.5); // scale by 0.5

		Stroke originalStroke = g2d.getStroke(); // Set the stroke to a thicker line
		g2d.setStroke(new BasicStroke(1.0f)); // Set the border thickness

		// Draw the rectangle border
		g2d.setColor(Color.WHITE);
		g2d.drawRect(7, 0, preScaleWidth - 15, preScaleHeight - 1);

		// Draw the first horizontal line above the border
		g2d.setStroke(originalStroke); // Restore the original stroke
		int yAboveBorder = 35;
		g2d.drawLine(7, yAboveBorder, preScaleWidth - 8, yAboveBorder);

		// Draw the horizontal line in the center
		g2d.setColor(Color.RED);
		int yCenter = preScaleHeight / 2;
		g2d.drawLine(7, yCenter, preScaleWidth - 8, yCenter);

		// Draw arrow
		drawArrow(g2d, 80, yCenter);
		g2d.setColor(Color.WHITE);

		// Draw the second horizontal line below the border
		int yBelowBorder = preScaleHeight - 35;
		g2d.drawLine(7, yBelowBorder, preScaleWidth - 8, yBelowBorder);

		// Draw small "X" at the intersection points
		drawIntersectionCircle(g2d, 7, yCenter); // Left side
		drawIntersectionCircle(g2d, preScaleWidth - 8, yCenter); // Right side

		// Draw small circles
		int distanceBetweenCircles = 10;
		drawSmallCircles(g2d, 20, yAboveBorder - 20, 3, distanceBetweenCircles);
		drawSmallCircles(g2d, preScaleWidth - 60, yAboveBorder - 20, 3, distanceBetweenCircles);
		drawSmallCircles(g2d, 20, yBelowBorder + 13, 3, distanceBetweenCircles);
		drawSmallCircles(g2d, preScaleWidth - 60, yBelowBorder + 13, 3, distanceBetweenCircles);

		// Draw poly vee
		drawRollers(g2d, yBelowBorder, yAboveBorder);
		drawBar(g2d, 0, yBelowBorder, yAboveBorder);
		drawBar(g2d, preScaleWidth - 80, yBelowBorder, yAboveBorder);

		// Add the text on the component
		Font font = new Font("Arial", Font.PLAIN, 20);
		g2d.setFont(font);
		g2d.setColor(Color.GREEN);
		g2d.drawString("H = " + H, 90, yCenter + 50);
		g2d.setColor(Color.BLUE);
		g2d.drawString("V = " + V, 90, yCenter + 75);
		g2d.setColor(Color.CYAN);
		g2d.drawString("P = " + P, 90, yCenter + 100);
		font = new Font("Arial", Font.PLAIN, 30);
		// Add title of component
		g2d.setFont(font);
		g2d.setColor(Color.MAGENTA);
		g2d.drawString(title, 90, yCenter - 50);

		g2d.dispose();
	}

	/**
	 * Draw function for the intersection between the middle line and the left/right
	 * border
	 * 
	 * @param g2d
	 * @param x
	 * @param y
	 */
	private void drawIntersectionCircle(Graphics2D g2d, int x, int y) {
		int circleSize = 12; // Adjust the size of the circle as needed
		int xSize = 7; // Adjust the size of the "X" relative to the circle size

		// Draw the circle
		g2d.setColor(Color.WHITE); // Set the color for the circle
		g2d.drawOval(x - circleSize / 2, y - circleSize / 2, circleSize, circleSize);

		// Draw the "X" inside the circle
		g2d.drawLine(x - xSize, y - xSize, x + xSize, y + xSize); // Draw diagonal line from top-left to bottom-right
		g2d.drawLine(x - xSize, y + xSize, x + xSize, y - xSize); // Draw diagonal line from bottom-left to top-right
	}

	/**
	 * Draw function for the small circles next to the poly vee bars
	 * 
	 * @param g2d
	 * @param x
	 * @param y
	 * @param count
	 * @param distance
	 */
	private void drawSmallCircles(Graphics2D g2d, int x, int y, int count, int distance) {
		int circleSize = 7; // Adjust the size of the small circles as needed

		for (int i = 0; i < count; i++) {
			g2d.setColor(Color.WHITE); // Set the color for the small circles
			g2d.drawOval(x + i * (circleSize + distance), y, circleSize, circleSize);
		}
	}

	/**
	 * Draw function for the poly vee bars
	 * 
	 * @param g2d
	 * @param x
	 * @param y1
	 * @param y2
	 */
	private void drawBar(Graphics2D g2d, int x, int y1, int y2) {
		int yBelowBorder = y1;
		int yAboveBorder = y2;
		int previousPiece = 0;
		if (side == 0) {
			g2d.drawRect(33 + x, yAboveBorder, 14, 3);
			previousPiece = previousPiece + 3;// first rectangle
			g2d.drawRect(29 + x, yAboveBorder + previousPiece, 22, 17);
			previousPiece = previousPiece + 17;// the zigzag rectangle
			drawZigzag(g2d, 29 + x, yAboveBorder + previousPiece - 17, 22, 17);// left zigzag
			drawZigzag(g2d, 48 + x, yAboveBorder + previousPiece - 17, 22, 17);// right zigzag
			g2d.drawRect(27 + x, yAboveBorder + previousPiece, 26, 3);
			previousPiece = previousPiece + 3;// second rectangle
			g2d.drawRect(25 + x, yAboveBorder + previousPiece, 30, yBelowBorder - 65);
			previousPiece = previousPiece + yBelowBorder - 65;// draw the long bar
			g2d.drawRect(27 + x, yAboveBorder + previousPiece, 26, 3);
			previousPiece = previousPiece + 3;// third rectangle
			g2d.drawRect(30 + x, yAboveBorder + previousPiece, 20, 3);
			previousPiece = previousPiece + 3;// fourth rectangle
		} else {
			g2d.drawRect(30 + x, yAboveBorder, 20, 3);
			previousPiece = previousPiece + 3;// first rectangle
			g2d.drawRect(27 + x, yAboveBorder + previousPiece, 26, 3);
			previousPiece = previousPiece + 3;// second rectangle
			g2d.drawRect(25 + x, yAboveBorder + previousPiece, 30, yBelowBorder - 65);
			previousPiece = previousPiece + yBelowBorder - 65;// draw the long bar
			g2d.drawRect(27 + x, yAboveBorder + previousPiece, 26, 3);
			previousPiece = previousPiece + 3;// fourth rectangle
			g2d.drawRect(29 + x, yAboveBorder + previousPiece, 22, 17);
			previousPiece = previousPiece + 17;// the zigzag rectangle
			drawZigzag(g2d, 29 + x, yAboveBorder + previousPiece - 17, 22, 17);// left zigzag
			drawZigzag(g2d, 48 + x, yAboveBorder + previousPiece - 17, 22, 17);// right zigzag
			g2d.drawRect(33 + x, yAboveBorder + previousPiece, 14, 3);
			previousPiece = previousPiece + 3;// last rectangle
		}
	}

	/**
	 * Draw function for the zigzag on one of the pieces of the poly vee
	 * 
	 * @param g2d
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	private static void drawZigzag(Graphics2D g2d, int x, int y, int width, int height) {
		Path2D path = new Path2D.Float();

		int zigzagWidth = 3; // smaller zigzag width
		int zigzagHeight = 2; // smaller zigzag height

		for (int i = 0; i < height / zigzagHeight; i++) {
			if (i % 2 == 0) {
				path.moveTo(x, y + i * zigzagHeight);
				path.lineTo(x + zigzagWidth, y + (i + 1) * zigzagHeight);
			} else {
				path.moveTo(x + zigzagWidth, y + i * zigzagHeight);
				path.lineTo(x, y + (i + 1) * zigzagHeight);
			}
		}

		g2d.draw(path);
	}

	/**
	 * Draw function for the arrow on the middle line
	 * 
	 * @param g2d
	 * @param x
	 * @param y
	 */
	private void drawArrow(Graphics2D g2d, int x, int y) {
		// Create a GeneralPath object to represent the path
		GeneralPath path = new GeneralPath();
		// Move to the starting point of the path
		path.moveTo(x, y);
		// Draw a line to points
		path.lineTo(x, y - 7);
		path.lineTo(x + 60, y - 7);
		path.lineTo(x + 60, y - 15);
		path.lineTo(x + 120, y);
		path.lineTo(x + 60, y + 15);
		path.lineTo(x + 60, y + 7);
		path.lineTo(x, y + 7);
		// Close the path to connect the last and first points
		path.closePath();
		// Set the color for the path
		g2d.setColor(Color.YELLOW);
		// Draw the path
		g2d.draw(path);
	}

	/**
	 * Draw function for the rollers of the poly vee
	 * 
	 * @param g2d
	 * @param x
	 * @param y
	 * @param nr
	 */
	private void drawCircle(Graphics2D g2d, int x, int y, int nr) {
		int centerX = x;
		int centerY = y;
		int radius = 10;

		// Draw the circle
		g2d.setColor(Color.WHITE);
		g2d.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

		// Draw the border
		g2d.setColor(Color.WHITE); // Border color
		g2d.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

		// Calculate angles for the four equal parts
		double angle1 = 0;
		double angle2 = Math.PI / 2;
		double angle3 = Math.PI;
		double angle4 = 3 * Math.PI / 2;

		// Define the arc for the transparent parts
		g2d.setColor(new Color(0, 0, 0, 0)); // Transparent color
		g2d.fillArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius, (int) Math.toDegrees(angle1),
				(int) Math.toDegrees(angle2 - angle1));
		g2d.fillArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius, (int) Math.toDegrees(angle3),
				(int) Math.toDegrees(angle4 - angle3));

		// Define the arc for the filled parts
		g2d.setColor(Color.WHITE); // Filled color
		g2d.fillArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius, (int) Math.toDegrees(angle2),
				(int) Math.toDegrees(angle3 - angle2));
		g2d.fillArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius, (int) Math.toDegrees(angle4),
				(int) Math.toDegrees(angle1 + 2 * Math.PI - angle4));
	}

	/**
	 * Draw function for poly vee rollers using the previous drawCircle function
	 * 
	 * @param g2d
	 * @param yBelowBorder
	 * @param yAboveBorder
	 */
	private void drawRollers(Graphics2D g2d, int yBelowBorder, int yAboveBorder) {
		int auxY;
		if (side == 0)
			auxY = yAboveBorder + 10;
		else
			auxY = yBelowBorder - 10;
		if (No_MDR == 1)
			drawCircle(g2d, preScaleWidth / 4, auxY, 2);
		else if (No_MDR == 2) {
			drawCircle(g2d, preScaleWidth / 4, auxY, 2);
			drawCircle(g2d, 3 * preScaleWidth / 4, auxY, 2);
		} else if (No_MDR == 3) {
			drawCircle(g2d, preScaleWidth / 4, auxY, 2);
			drawCircle(g2d, preScaleWidth / 2, auxY, 2);
			drawCircle(g2d, 3 * preScaleWidth / 4, auxY, 2);
		} else if (No_MDR == 4) {
			drawCircle(g2d, preScaleWidth / 4, auxY, 2);
			drawCircle(g2d, 2 * preScaleWidth / 5, auxY, 2);
			drawCircle(g2d, 3 * preScaleWidth / 5, auxY, 2);
			drawCircle(g2d, 3 * preScaleWidth / 4, auxY, 2);
		}
	}

}
