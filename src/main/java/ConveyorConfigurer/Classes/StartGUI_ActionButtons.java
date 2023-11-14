package ConveyorConfigurer.Classes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import ConveyorConfigurer.Classes.GUI.NewProjectGUI;

public class StartGUI_ActionButtons{

	private JFrame frame;
	private JButton btnNew, btnAbout, btnExit;
	
	public StartGUI_ActionButtons(JFrame frame, JButton btnNew, JButton btnAbout, JButton btnExit) {
		this.frame = frame;
		this.btnNew = btnNew;
		this.btnAbout = btnAbout;
		this.btnExit = btnExit;
		addAction_btnNew();
		addAction_btnAbout();
		addAction_btnExit();
	}

	private void addAction_btnExit() {
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
	}

	private void addAction_btnAbout() {
		btnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Not yet implemented");
			}
		});
	}

	private void addAction_btnNew() {
		btnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frame.setVisible(false);
				NewProjectGUI createWindow = new NewProjectGUI();
				createWindow.getFrame().setVisible(true);
			}
		});
	}
	
	

}