package ConveyorConfigurer.Classes.NewProjectGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import ConveyorConfigurer.Classes.Components.Degree_transfer_module;
import ConveyorConfigurer.Classes.Components.Motorized_roller_conveyor;
import ConveyorConfigurer.Classes.GUI.NewProjectGUI;

public class ComboBoxActionListeners{

	protected static final NewProjectGUI NeWProjectGUI = null;
	private JComboBox<String> comboBoxType, comboBoxWidth, comboBoxLenght, comboBoxPitch, comboBoxSide, comboBoxNo_MDR,
			comboBoxAngle;

	/**
	 * Constructor for ComboBoxActionListeners
	 * 
	 * @param comboBoxType
	 * @param comboBoxWidth
	 * @param comboBoxLenght
	 * @param comboBoxPitch
	 * @param comboBoxSide
	 * @param comboBoxNo_MDR
	 */
	public ComboBoxActionListeners(JComboBox<String> comboBoxType, JComboBox<String> comboBoxWidth,
			JComboBox<String> comboBoxLenght, JComboBox<String> comboBoxPitch, JComboBox<String> comboBoxSide,
			JComboBox<String> comboBoxNo_MDR, JComboBox<String> comboBoxAngle) {
		this.comboBoxType = comboBoxType;
		this.comboBoxWidth = comboBoxWidth;
		this.comboBoxLenght = comboBoxLenght;
		this.comboBoxPitch = comboBoxPitch;
		this.comboBoxSide = comboBoxSide;
		this.comboBoxNo_MDR = comboBoxNo_MDR;
		this.comboBoxAngle = comboBoxAngle;
		addActions();
	}

	/**
	 * Initializer for JComboBoxes from NewProjectGUI
	 */
	private void addActions() {
		comboBoxType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewProjectGUI.setType(comboBoxType.getSelectedIndex());

				switch (NewProjectGUI.getNewType()) {
				case 0:
					System.out.println("Motorized roller conveyor");
					NewProjectGUI.setVisibleSettings_MotorizeRollerConveyor();
					break;

				case 1:
					System.out.println("Gravity roller conveyor");
					break;

				case 2:
					System.out.println("90 degree transfer module");
					NewProjectGUI.setVisibleSettings_DegreeTransferModule();
					break;

				case 3:
					System.out.println("Merge conveyor");
					break;

				case 4:
					System.out.println("Curve roller conveyor");
					break;

				case 5:
					System.out.println("Skew roller conveyor");
					break;

				case 6:
					System.out.println("Diverter");
					break;
				}

			}
		});

		comboBoxWidth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewProjectGUI.setWidth(Integer.valueOf((String) comboBoxWidth.getSelectedItem()));
			}
		});

		comboBoxLenght.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewProjectGUI.setLength(Integer.valueOf((String) comboBoxLenght.getSelectedItem()));
			}
		});

		comboBoxPitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewProjectGUI.setPitch((String) comboBoxPitch.getSelectedItem());
			}
		});

		comboBoxSide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewProjectGUI.setSide(comboBoxSide.getSelectedIndex());
			}
		});

		comboBoxNo_MDR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewProjectGUI.setNo_MDR(Integer.valueOf((String) comboBoxNo_MDR.getSelectedItem()));
			}
		});
		
		comboBoxAngle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewProjectGUI.setAngle(Integer.valueOf((String) comboBoxAngle.getSelectedItem()));
			}
		});
	}

}
