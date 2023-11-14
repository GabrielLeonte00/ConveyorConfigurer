package ConveyorConfigurer.Classes.GUI.NewProjectGUI_ActionButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import ConveyorConfigurer.Classes.GUI.NewProjectGUI;

public class ComboBoxActionListeners {

	private JComboBox<String> comboBoxType, comboBoxWidth, comboBoxLenght, comboBoxPitch, comboBoxSide, comboBoxNo_MDR;

	/**
	 * Constructor for ComboBoxActionListeners
	 * @param comboBoxType
	 * @param comboBoxWidth
	 * @param comboBoxLenght
	 * @param comboBoxPitch
	 * @param comboBoxSide
	 * @param comboBoxNo_MDR
	 */
	public ComboBoxActionListeners(JComboBox<String> comboBoxType, JComboBox<String> comboBoxWidth,
			JComboBox<String> comboBoxLenght, JComboBox<String> comboBoxPitch, JComboBox<String> comboBoxSide,
			JComboBox<String> comboBoxNo_MDR) {
		this.comboBoxType = comboBoxType;
		this.comboBoxWidth = comboBoxWidth;
		this.comboBoxLenght = comboBoxLenght;
		this.comboBoxPitch = comboBoxPitch;
		this.comboBoxSide = comboBoxSide;
		this.comboBoxNo_MDR = comboBoxNo_MDR;
		addActions();
	}

	/**
	 * Initializer for JComboBoxes from NewProjectGUI
	 */
	private void addActions() {
		comboBoxType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewProjectGUI.setType(comboBoxType.getSelectedIndex());
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
	}

}
