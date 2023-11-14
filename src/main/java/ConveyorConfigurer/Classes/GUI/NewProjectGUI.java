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

import ConveyorConfigurer.Classes.GUI.NewProjectGUI_ActionButtons.ComboBoxActionListeners;

public class NewProjectGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private static JPanel drawingPanel;
	private JPanel previewPanel;
	private JTextField textFieldHeight;
	private JTextField textFieldSpeed;
	private JTextField textFieldLengthNow;
	private JTextField textFieldWidthNow;
	private int drawingWidth, drawingLength;
	private JComboBox<String> comboBoxType, comboBoxWidth, comboBoxLenght, comboBoxPitch, comboBoxSide, comboBoxNo_MDR;

	private static int type, width, length;
	private static String pitch;
	private static int side, no_MDR;

	/**
	 * Constructor for the new project GUI
	 */
	public NewProjectGUI() {
		initialize();
		initializeValues();
		new ComboBoxActionListeners(comboBoxType, comboBoxWidth, comboBoxLenght, comboBoxPitch, comboBoxSide,
				comboBoxNo_MDR);
	}

	/**
	 * Getter for the main GUI frame
	 * 
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
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

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 310, 707);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textFieldHeight = new JTextField();
		textFieldHeight.setText("700");
		textFieldHeight.setColumns(10);
		textFieldHeight.setBounds(165, 626, 135, 20);
		panel.add(textFieldHeight);

		textFieldSpeed = new JTextField();
		textFieldSpeed.setText("30");
		textFieldSpeed.setColumns(10);
		textFieldSpeed.setBounds(165, 595, 135, 20);
		panel.add(textFieldSpeed);

		comboBoxType = new JComboBox<String>();
		comboBoxType.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Motorized roller conveyor", "Gravity roller conveyor", "90 degree transfer module",
						"Merge conveyor", "Curve roller conveyor", "Skew roller conveyor", "Diverter" }));
		comboBoxType.setBounds(10, 128, 290, 40);
		panel.add(comboBoxType);

		comboBoxWidth = new JComboBox<String>();
		comboBoxWidth
				.setModel(new DefaultComboBoxModel<String>(new String[] { "417", "517", "617", "717", "817", "917" }));
		comboBoxWidth.setBounds(165, 430, 135, 22);
		panel.add(comboBoxWidth);

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
		panel.add(comboBoxLenght);

		comboBoxPitch = new JComboBox<String>();
		comboBoxPitch.setModel(new DefaultComboBoxModel<String>(new String[] { "60", "90", "120" }));
		comboBoxPitch.setBounds(165, 496, 135, 22);
		panel.add(comboBoxPitch);

		comboBoxSide = new JComboBox<String>();
		comboBoxSide.setModel(new DefaultComboBoxModel<String>(new String[] { "Left", "Right" }));
		comboBoxSide.setSelectedIndex(1);
		comboBoxSide.setBounds(165, 529, 135, 22);
		panel.add(comboBoxSide);

		comboBoxNo_MDR = new JComboBox<String>();
		comboBoxNo_MDR.setModel(new DefaultComboBoxModel<String>(new String[] { "1", "2", "3", "4" }));
		comboBoxNo_MDR.setBounds(165, 562, 135, 22);
		panel.add(comboBoxNo_MDR);

		JLabel lblWidth = new JLabel("Width");
		lblWidth.setBounds(10, 430, 135, 22);
		panel.add(lblWidth);

		JLabel lblLength = new JLabel("Length");
		lblLength.setBounds(10, 463, 135, 22);
		panel.add(lblLength);

		JLabel lblRollerPitch = new JLabel("Roller pitch");
		lblRollerPitch.setBounds(10, 496, 135, 22);
		panel.add(lblRollerPitch);

		JLabel lblPolyVeeSide = new JLabel("Poly vee side");
		lblPolyVeeSide.setBounds(10, 529, 135, 22);
		panel.add(lblPolyVeeSide);

		JLabel lblNoOfMdr = new JLabel("No. of MDR");
		lblNoOfMdr.setBounds(10, 562, 135, 22);
		panel.add(lblNoOfMdr);

		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(10, 594, 135, 22);
		panel.add(lblSpeed);

		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(10, 626, 135, 22);
		panel.add(lblHeight);

		JButton btnExport = new JButton("Export");
		btnExport.setBounds(10, 0, 290, 40);
		panel.add(btnExport);

		JButton btnAddComponent = new JButton("Add component");
		btnAddComponent.setBounds(10, 657, 290, 40);
		panel.add(btnAddComponent);

		JButton btnExtLength = new JButton("Extend Length");
		btnExtLength.setBounds(10, 51, 135, 40);
		panel.add(btnExtLength);

		JButton btnExtWidth = new JButton("Extend Width");
		btnExtWidth.setBounds(165, 51, 135, 40);
		panel.add(btnExtWidth);

		previewPanel = new JPanel();
		previewPanel.setBackground(Color.BLACK);
		previewPanel.setBounds(10, 179, 290, 240);
		panel.add(previewPanel);
		previewPanel.setLayout(null);

		textFieldLengthNow = new JTextField();
		textFieldLengthNow.setEditable(false);
		textFieldLengthNow.setBounds(10, 97, 135, 20);
		panel.add(textFieldLengthNow);
		textFieldLengthNow.setColumns(10);

		textFieldWidthNow = new JTextField();
		textFieldWidthNow.setEditable(false);
		textFieldWidthNow.setColumns(10);
		textFieldWidthNow.setBounds(165, 97, 135, 20);
		panel.add(textFieldWidthNow);

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
	}

	/**
	 * Setter for the constant type
	 * @param newValue New value for type
	 */
	public static void setType(int newValue) {
		type = newValue;
		System.out.println(type);
	}

	/**
	 * Setter for the constant width
	 * @param newValue New value for width
	 */
	public static void setWidth(int newValue) {
		width = newValue;
		System.out.println(width);
	}

	/**
	 * Setter for the constant length
	 * @param newValue New value for length
	 */
	public static void setLength(int newValue) {
		length = newValue;
		System.out.println(length);
	}

	/**
	 * Setter for the constant pitch
	 * @param newString New value for pitch
	 */
	public static void setPitch(String newString) {
		pitch = newString;
		System.out.println(pitch);
	}

	/**
	 * Setter for the constant no_MDR
	 * @param newValue New value for no_MDR
	 */
	public static void setNo_MDR(int newValue) {
		no_MDR = newValue;
		System.out.println(no_MDR);
	}

	/**
	 * Setter for the constant side
	 * @param newValue New value for side
	 */
	public static void setSide(int newValue) {
		side = newValue;
		System.out.println(side);
	}

}
