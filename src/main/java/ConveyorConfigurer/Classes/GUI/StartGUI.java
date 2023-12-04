package ConveyorConfigurer.Classes.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;

import ConveyorConfigurer.Classes.StartGUI_ActionButtons;

public class StartGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame frame;
	private JButton btnNew, btnAbout, btnExit;

	/**
	 * Create the application.
	 */
	public StartGUI() {
		initialize();
		new StartGUI_ActionButtons(btnNew, btnAbout, btnExit);
	}
	
	/**
	 * Getter for the main GUI frame
	 * @return
	 */
	public static JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Conveyor Configurer");
		frame.setBounds(100, 100, 300, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		btnNew = new JButton("New");
		btnNew.setBounds(58, 127, 168, 70);
		btnNew.setFocusPainted(false);
		frame.getContentPane().add(btnNew);

		btnAbout = new JButton("About");
		btnAbout.setBounds(58, 220, 168, 70);
		btnAbout.setFocusPainted(false);
		frame.getContentPane().add(btnAbout);

		btnExit = new JButton("Exit");
		btnExit.setBounds(58, 313, 168, 70);
		btnExit.setFocusPainted(false);
		frame.getContentPane().add(btnExit);

	}

}
