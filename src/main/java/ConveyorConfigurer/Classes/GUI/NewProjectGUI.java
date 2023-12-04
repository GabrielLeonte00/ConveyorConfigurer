package ConveyorConfigurer.Classes.GUI;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

import ConveyorConfigurer.Classes.DataForExcel;
import ConveyorConfigurer.Classes.NumericDocumentFilter;
import ConveyorConfigurer.Classes.NumericDocumentFilter_maxNumber;
import ConveyorConfigurer.Classes.NewProjectGUI.AddComponentButton;
import ConveyorConfigurer.Classes.NewProjectGUI.ComboBoxActionListeners;
import ConveyorConfigurer.Classes.NewProjectGUI.ExportButton;
import ConveyorConfigurer.Classes.NewProjectGUI.ExtendButtons;

public class NewProjectGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JFrame frame;
	private static JPanel drawingPanel, settingsPanel;
	private JPanel previewPanel;

	private static int type, width, length;
	private static String pitch;
	private static int side, no_MDR;
	private static int angle;

	private JButton btnExport, btnAddComponent, btnExtLength, btnExtWidth;
	private int drawingWidth, drawingLength;

	private JLabel lblSpeed, lblHeight, lblWidth;
	private static JTextField textFieldHeight, textFieldSpeed, textFieldTitle;
	private JTextField textFieldLengthNow, textFieldWidthNow;

	private JComboBox<String> comboBoxType, comboBoxWidth;

	private static JLabel lblLength, lblAngle, lblRollerPitch, lblPolyVeeSide, lblNoOfMdr;
	private static JComboBox<String> comboBoxLenght, comboBoxPitch, comboBoxSide, comboBoxNo_MDR, comboBoxAngle;

	/**
	 * Constructor for the new project GUI
	 */
	public NewProjectGUI() {
		initialize();
		initializeValues();
		
		new ComboBoxActionListeners(comboBoxType, comboBoxWidth, comboBoxLenght, comboBoxPitch, comboBoxSide,
				comboBoxNo_MDR, comboBoxAngle);
		new ExportButton(btnExport);
		new ExtendButtons(btnExtLength, btnExtWidth, drawingLength, drawingWidth, textFieldLengthNow,
				textFieldWidthNow);
		new AddComponentButton(btnAddComponent);
		DataForExcel.initialize(drawingPanel);
	}

	/**
	 * Getter for the main GUI frame
	 * 
	 * @return
	 */
	public static JFrame getFrame() {
		return frame;
	}

	/**
	 * Getter for the panel in which we create the schema
	 * 
	 * @return
	 */
	public static JPanel getDrawingPanel() {
		return drawingPanel;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1560, 760);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		settingsPanel = new JPanel();
		settingsPanel.setBounds(10, 11, 310, 707);
		frame.getContentPane().add(settingsPanel);
		settingsPanel.setLayout(null);

		textFieldTitle = new JTextField();
		textFieldTitle.setText("A0010");
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(165, 399, 135, 20);
		settingsPanel.add(textFieldTitle);
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 398, 135, 22);
		settingsPanel.add(lblTitle);

		textFieldHeight = new JTextField();
		textFieldHeight.setText("700");
		textFieldHeight.setColumns(10);
		textFieldHeight.setBounds(165, 626, 135, 20);
		AbstractDocument documentHeight = (AbstractDocument) textFieldHeight.getDocument();
		documentHeight.setDocumentFilter(new NumericDocumentFilter(7));
		settingsPanel.add(textFieldHeight);

		lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(10, 594, 135, 22);
		settingsPanel.add(lblSpeed);
		textFieldSpeed = new JTextField();
		textFieldSpeed.setText("30");
		textFieldSpeed.setColumns(10);
		textFieldSpeed.setBounds(165, 595, 135, 20);
		AbstractDocument documentSpeed = (AbstractDocument) textFieldSpeed.getDocument();
		documentSpeed.setDocumentFilter(new NumericDocumentFilter_maxNumber());
		settingsPanel.add(textFieldSpeed);

		lblHeight = new JLabel("Height");
		lblHeight.setBounds(10, 626, 135, 22);
		settingsPanel.add(lblHeight);
		comboBoxType = new JComboBox<String>();
		comboBoxType.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Motorized roller conveyor", "Gravity roller conveyor", "90 degree transfer module",
						"Merge conveyor", "Curve roller conveyor", "Skew roller conveyor", "Diverter" }));
		comboBoxType.setBounds(10, 128, 290, 40);
		settingsPanel.add(comboBoxType);

		lblWidth = new JLabel("Width");
		lblWidth.setBounds(10, 430, 135, 22);
		settingsPanel.add(lblWidth);
		comboBoxWidth = new JComboBox<String>();
		comboBoxWidth
				.setModel(new DefaultComboBoxModel<String>(new String[] { "417", "517", "617", "717", "817", "917" }));
		comboBoxWidth.setBounds(165, 430, 135, 22);
		settingsPanel.add(comboBoxWidth);

		lblLength = new JLabel("Length");
		lblLength.setBounds(10, 463, 135, 22);
		settingsPanel.add(lblLength);
		comboBoxLenght = new JComboBox<String>();
		comboBoxLenght.setModel(new DefaultComboBoxModel<String>(new String[] { "360", "390", "420", "450", "480",
				"510", "540", "570", "600", "630", "660", "690", "720", "750", "780", "810", "840", "870", "900", "930",
				"960", "990", "1020", "1050", "1080", "1110", "1140", "1170", "1200", "1230", "1260", "1290", "1320",
				"1350", "1380", "1410", "1440", "1470", "1500", "1530", "1560", "1590", "1620", "1650", "1680", "1710",
				"1740", "1770", "1800", "1830", "1860", "1890", "1920", "1950", "1980", "2010", "2040", "2070", "2100",
				"2130", "2160", "2190", "2220", "2250", "2280", "2310", "2340", "2370", "2400", "2430", "2460", "2490",
				"2520", "2550", "2580", "2610", "2640", "2670", "2700", "2730", "2760", "2790", "2820", "2850",
				"2880" }));
		comboBoxLenght.setBounds(165, 463, 135, 22);
		settingsPanel.add(comboBoxLenght);

		lblAngle = new JLabel("Angle");
		lblAngle.setBounds(10, 463, 135, 22);
		lblAngle.setVisible(false);
		settingsPanel.add(lblAngle);
		comboBoxAngle = new JComboBox<String>();
		comboBoxAngle.setModel(new DefaultComboBoxModel<String>(new String[] { "30", "45", "60", "90" }));
		comboBoxAngle.setSelectedIndex(3);
		comboBoxAngle.setBounds(165, 463, 135, 22);
		comboBoxAngle.setVisible(false);
		settingsPanel.add(comboBoxAngle);

		lblRollerPitch = new JLabel("Roller pitch");
		lblRollerPitch.setBounds(10, 496, 135, 22);
		settingsPanel.add(lblRollerPitch);
		comboBoxPitch = new JComboBox<String>();
		comboBoxPitch.setModel(new DefaultComboBoxModel<String>(new String[] { "60", "90", "120" }));
		comboBoxPitch.setBounds(165, 496, 135, 22);
		settingsPanel.add(comboBoxPitch);

		lblPolyVeeSide = new JLabel("Poly vee side");
		lblPolyVeeSide.setBounds(10, 529, 135, 22);
		settingsPanel.add(lblPolyVeeSide);
		comboBoxSide = new JComboBox<String>();
		comboBoxSide.setModel(new DefaultComboBoxModel<String>(new String[] { "Left", "Right" }));
		comboBoxSide.setSelectedIndex(1);
		comboBoxSide.setBounds(165, 529, 135, 22);
		settingsPanel.add(comboBoxSide);

		lblNoOfMdr = new JLabel("No. of MDR");
		lblNoOfMdr.setBounds(10, 562, 135, 22);
		settingsPanel.add(lblNoOfMdr);
		comboBoxNo_MDR = new JComboBox<String>();
		comboBoxNo_MDR.setModel(new DefaultComboBoxModel<String>(new String[] { "1", "2", "3", "4" }));
		comboBoxNo_MDR.setBounds(165, 562, 135, 22);
		settingsPanel.add(comboBoxNo_MDR);

		btnExport = new JButton("Export");
		btnExport.setBounds(10, 0, 290, 40);
		settingsPanel.add(btnExport);

		btnAddComponent = new JButton("Add component");
		btnAddComponent.setBounds(10, 657, 290, 40);
		settingsPanel.add(btnAddComponent);

		btnExtLength = new JButton("Extend Length");
		btnExtLength.setBounds(10, 51, 135, 40);
		settingsPanel.add(btnExtLength);

		btnExtWidth = new JButton("Extend Width");
		btnExtWidth.setBounds(165, 51, 135, 40);
		settingsPanel.add(btnExtWidth);

		previewPanel = new JPanel();
		previewPanel.setBackground(Color.BLACK);
		previewPanel.setBounds(10, 179, 290, 209);
		settingsPanel.add(previewPanel);
		previewPanel.setLayout(null);

		textFieldLengthNow = new JTextField();
		textFieldLengthNow.setEditable(false);
		textFieldLengthNow.setBounds(10, 97, 135, 20);
		settingsPanel.add(textFieldLengthNow);
		textFieldLengthNow.setColumns(10);

		textFieldWidthNow = new JTextField();
		textFieldWidthNow.setEditable(false);
		textFieldWidthNow.setColumns(10);
		textFieldWidthNow.setBounds(165, 97, 135, 20);
		settingsPanel.add(textFieldWidthNow);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(330, 11, 1200, 700);
		frame.getContentPane().add(scrollPane);

		drawingPanel = new JPanel();
		scrollPane.setViewportView(drawingPanel);
		drawingPanel.setBackground(Color.BLACK);
		drawingPanel.setLayout(null);
		drawingWidth = scrollPane.getHeight();
		drawingLength = scrollPane.getWidth();
		textFieldLengthNow.setText(String.valueOf(drawingLength));
		textFieldWidthNow.setText(String.valueOf(drawingWidth));

	}

	/**
	 * Initialize the values for the components
	 */
	private void initializeValues() {
		type = comboBoxType.getSelectedIndex();
		width = Integer.valueOf((String) comboBoxWidth.getSelectedItem());
		length = Integer.valueOf((String) comboBoxLenght.getSelectedItem());
		pitch = (String) comboBoxPitch.getSelectedItem();
		side = comboBoxSide.getSelectedIndex();
		no_MDR = Integer.valueOf((String) comboBoxNo_MDR.getSelectedItem());
		angle = Integer.valueOf((String) comboBoxAngle.getSelectedItem());
	}

	/**
	 * Setter for the constant type
	 * 
	 * @param newValue New value for type
	 */
	public static void setType(int newValue) {
		type = newValue;
	}

	/**
	 * Setter for the constant width
	 * 
	 * @param newValue New value for width
	 */
	public static void setWidth(int newValue) {
		width = newValue;
	}

	/**
	 * Setter for the constant length
	 * 
	 * @param newValue New value for length
	 */
	public static void setLength(int newValue) {
		length = newValue;
	}

	/**
	 * Setter for the constant pitch
	 * 
	 * @param newString New value for pitch
	 */
	public static void setPitch(String newString) {
		pitch = newString;
	}

	/**
	 * Setter for the constant no_MDR
	 * 
	 * @param newValue New value for no_MDR
	 */
	public static void setNo_MDR(int newValue) {
		no_MDR = newValue;
	}

	/**
	 * Setter for the constant side
	 * 
	 * @param newValue New value for side
	 */
	public static void setSide(int newValue) {
		side = newValue;
	}

	/**
	 * Setter for the constant angle
	 * 
	 * @param newValue New value for angle
	 */
	public static void setAngle(int newValue) {
		angle = newValue;
	}

	/**
	 * Getter for the type of the component
	 * 
	 * @return The integer value of the selected type in the comboBoxType
	 */
	public static int getNewType() {
		return type;
	}

	/**
	 * Getter for the component's width
	 * 
	 * @return The integer value of the selected width in the comboBoxWidth
	 */
	public static int getNewWidth() {
		return width;
	}

	/**
	 * Getter for the component's length
	 * 
	 * @return The integer value of the selected length in the comboBoxLength
	 */
	public static int getNewLength() {
		return length;
	}

	/**
	 * Getter for the component's roller pitch
	 * 
	 * @return The string value of the selected pitch in the comboBoxPitch
	 */
	public static String getNewPitch() {
		return pitch;
	}

	/**
	 * Getter for the component's number of MDR
	 * 
	 * @return The integer value of the selected number of MDR in the comboBoxNo_MDR
	 */
	public static int getNewno_MDR() {
		return no_MDR;
	}

	/**
	 * Getter for the componenet's poly vee side
	 * 
	 * @return The integer value of the selected side of the poly vee in the
	 *         comboBoxSide
	 */
	public static int getNewSide() {
		return side;
	}

	/**
	 * Getter for the selected angle
	 * 
	 * @return The integer value of the selected angle in the comboBoxAngle
	 */
	public static int getAngle() {
		return angle;
	}

	/**
	 * Getter for the selected angle
	 * 
	 * @return The integer value of the selected angle in the comboBoxAngle
	 */
	public static String getFieldTitle() {
		return textFieldTitle.getText();
	}

	public static String getFieldHeight() {
		return textFieldHeight.getText();
	}

	public static String getFieldSpeed() {
		return textFieldSpeed.getText();
	}

	public static void setVisibleSettings_MotorizeRollerConveyor() {
		comboBoxLenght.setVisible(true);
		lblLength.setVisible(true);
		comboBoxPitch.setVisible(true);
		lblRollerPitch.setVisible(true);
		comboBoxSide.setVisible(true);
		lblPolyVeeSide.setVisible(true);
		comboBoxNo_MDR.setVisible(true);
		lblNoOfMdr.setVisible(true);

		comboBoxAngle.setVisible(false);
		lblAngle.setVisible(false);

		settingsPanel.revalidate();
	}

	public static void setVisibleSettings_CurveRollerConveyor() {
		comboBoxLenght.setVisible(false);
		lblLength.setVisible(false);
		comboBoxPitch.setVisible(false);
		lblRollerPitch.setVisible(false);
		comboBoxSide.setVisible(false);
		lblPolyVeeSide.setVisible(false);
		comboBoxNo_MDR.setVisible(false);
		lblNoOfMdr.setVisible(false);

		comboBoxAngle.setVisible(true);
		lblAngle.setVisible(true);

		settingsPanel.revalidate();
		settingsPanel.repaint();
	}
}
