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
		int auxLength = NewProjectGUI.getNewLength();
		int no_MDR = NewProjectGUI.getNewno_MDR();
		int side = NewProjectGUI.getNewSide();
		String pitch = NewProjectGUI.getNewPitch();
		String height = NewProjectGUI.getFieldHeight();
		String speed = NewProjectGUI.getFieldSpeed();
		Motorized_roller_conveyor newComponent = new Motorized_roller_conveyor(height, pitch, speed, no_MDR, side,
				auxLength, auxWidth);
		// newComponent.setSize(auxLength/2+1, auxWidth/2+1); //scale by 0.5
		newComponent.setSize(auxLength, auxWidth);
		newComponent.setLocation(20, 20);
		newComponent.setHorizontalAlignment(SwingConstants.CENTER);

		newComponent.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					newComponent.getParent().setComponentZOrder(newComponent, 0); // Bring the button to the front
				}
				if (SwingUtilities.isRightMouseButton(e)) {
					showPopupMenuComponent(e.getComponent(), e.getX(), e.getY());
				}
			}
		});

		newComponent.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					int x = e.getX() + newComponent.getX() - e.getComponent().getWidth() / 2;
					int y = e.getY() + newComponent.getY() - e.getComponent().getHeight() / 2;
					if (x > 0 && x < NewProjectGUI.getDrawingPanel().getWidth() - e.getComponent().getWidth() && y > 0
							&& y < NewProjectGUI.getDrawingPanel().getHeight() - e.getComponent().getHeight())
						newComponent.setLocation(x, y);
				}
			}
		});

		NewProjectGUI.getDrawingPanel().add(newComponent);
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
