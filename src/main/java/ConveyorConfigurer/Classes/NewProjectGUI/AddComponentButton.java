package ConveyorConfigurer.Classes.NewProjectGUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import ConveyorConfigurer.Classes.Components.Curve_roller_conveyor;
import ConveyorConfigurer.Classes.Components.Motorized_roller_conveyor;
import ConveyorConfigurer.Classes.GUI.NewProjectGUI;

public class AddComponentButton {

	private JButton btnAddComponent;

	/**
	 * Constructor for AddComponentButton
	 * 
	 * @param btnExport
	 */
	public AddComponentButton(JButton btnAddComponent) {
		this.btnAddComponent = btnAddComponent;
		btnAddComponent.addActionListener(e -> addComponent());
	}

	private void addComponent() {
		int auxWidth = NewProjectGUI.getNewWidth() + 70;
		int auxWidthDegree = auxWidth + 790;
		int auxLength = NewProjectGUI.getNewLength();
		int no_MDR = NewProjectGUI.getNewno_MDR();
		int side = NewProjectGUI.getNewSide();
		int angle = NewProjectGUI.getAngle();
		String pitch = NewProjectGUI.getNewPitch();
		String height = NewProjectGUI.getFieldHeight();
		String speed = NewProjectGUI.getFieldSpeed();
		String title = NewProjectGUI.getFieldTitle();

		switch (NewProjectGUI.getNewType()) {
		case 0:
			// System.out.println("Motorized roller conveyor");
			Motorized_roller_conveyor newComponent0 = new Motorized_roller_conveyor(height, speed, pitch, title, no_MDR,
					side, auxLength, auxWidth);
			newComponent0.setSize(auxLength / 2 + 1, auxWidth / 2 + 1); // scale by 0.5
			// newComponent.setSize(auxLength, auxWidth);
			newComponent0.setLocation(20, 20);
			newComponent0.setHorizontalAlignment(SwingConstants.CENTER);

			newComponent0.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (SwingUtilities.isLeftMouseButton(e)) {
						newComponent0.getParent().setComponentZOrder(newComponent0, 0); // Bring the button to the front
					}
					if (SwingUtilities.isRightMouseButton(e)) {
						showPopupMenuComponent(e.getComponent(), e.getX(), e.getY());
					}
				}
			});

			newComponent0.addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					if (SwingUtilities.isLeftMouseButton(e)) {
						int x = e.getX() + newComponent0.getX() - e.getComponent().getWidth() / 2;
						int y = e.getY() + newComponent0.getY() - e.getComponent().getHeight() / 2;
						if (x > 0 && x < NewProjectGUI.getDrawingPanel().getWidth() - e.getComponent().getWidth()
								&& y > 0
								&& y < NewProjectGUI.getDrawingPanel().getHeight() - e.getComponent().getHeight())
							newComponent0.setLocation(x, y);
					}
				}
			});

			NewProjectGUI.getDrawingPanel().add(newComponent0);

			break;

		case 1:
			System.out.println("Gravity roller conveyor");
			break;

		case 2:
			System.out.println("90 degree transfer module");
			break;

		case 3:
			System.out.println("Merge conveyor");
			break;

		case 4:
			// System.out.println("Curve roller conveyor");

			Curve_roller_conveyor newComponent2 = new Curve_roller_conveyor(height, speed, title, auxWidthDegree,
					auxWidth - 70, angle);
			// newComponent.setSize(auxWidth90Degree, auxWidth90Degree);
			newComponent2.setSize(auxWidthDegree / 2 + 1, auxWidthDegree / 2 + 1);
			// newComponent.setSize(auxLength, auxWidth);
			newComponent2.setLocation(20, 20);
			newComponent2.setHorizontalAlignment(SwingConstants.CENTER);

			newComponent2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (SwingUtilities.isLeftMouseButton(e)) {
						newComponent2.getParent().setComponentZOrder(newComponent2, 0); // Bring the button to the front
					}
					if (SwingUtilities.isRightMouseButton(e)) {
						showPopupMenuComponent(e.getComponent(), e.getX(), e.getY());
					}
				}
			});

			newComponent2.addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					if (SwingUtilities.isLeftMouseButton(e)) {
						int x = e.getX() + newComponent2.getX() - e.getComponent().getWidth() / 2;
						int y = e.getY() + newComponent2.getY() - e.getComponent().getHeight() / 2;
						if (x > 0 && x < NewProjectGUI.getDrawingPanel().getWidth() - e.getComponent().getWidth()
								&& y > 0
								&& y < NewProjectGUI.getDrawingPanel().getHeight() - e.getComponent().getHeight())
							newComponent2.setLocation(x, y);
					}
				}
			});

			NewProjectGUI.getDrawingPanel().add(newComponent2);

			break;

		case 5:
			System.out.println("Skew roller conveyor");
			break;

		case 6:
			System.out.println("Diverter");
			break;
		}

		NewProjectGUI.getDrawingPanel().revalidate();
		NewProjectGUI.getDrawingPanel().repaint();
	}

	private static void showPopupMenuComponent(Component component, int x, int y) {
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem menuItemRemove = new JMenuItem("Remove");
		JMenuItem menuItemRotate = new JMenuItem("Rotate");

		menuItemRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewProjectGUI.getDrawingPanel().remove(component);
				NewProjectGUI.getDrawingPanel().revalidate();
				NewProjectGUI.getDrawingPanel().repaint();
			}
		});

		menuItemRotate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		popupMenu.add(menuItemRemove);
		popupMenu.add(menuItemRotate);

		popupMenu.show(component, x, y);

	}

}
