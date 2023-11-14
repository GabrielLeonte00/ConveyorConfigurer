package ConveyorConfigurer.Classes.NewProjectGUI;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import ConveyorConfigurer.Classes.GUI.NewProjectGUI;

public class ExtendButtons {

	private JButton btnExtLength, btnExtWidth;
	private int drawingWidth, drawingLength;
	private JTextField textFieldLengthNow, textFieldWidthNow;

	/**
	 * Constructor for ExtendButtons
	 * @param btnExtLength
	 * @param btnExtWidth
	 * @param drawingLength
	 * @param drawingWidth
	 * @param textFieldLengthNow
	 * @param textFieldWidthNow
	 */
	public ExtendButtons(JButton btnExtLength, JButton btnExtWidth, int drawingLength, int drawingWidth,
			JTextField textFieldLengthNow, JTextField textFieldWidthNow) {
		this.btnExtLength = btnExtLength;
		this.btnExtWidth = btnExtWidth;
		this.drawingLength = drawingLength;
		this.drawingWidth = drawingWidth;
		this.textFieldLengthNow = textFieldLengthNow;
		this.textFieldWidthNow = textFieldWidthNow;
		initialize();
	}

	/**
	 * Add action listeners to the extend buttons
	 */
	private void initialize() {
		btnExtLength.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int auxWidth = NewProjectGUI.getDrawingPanel().getWidth() + 100;
				NewProjectGUI.getDrawingPanel()
						.setPreferredSize(new Dimension(auxWidth, NewProjectGUI.getDrawingPanel().getHeight()));
				NewProjectGUI.getDrawingPanel().revalidate();
				drawingLength = drawingLength + 100;
				textFieldLengthNow.setText(String.valueOf(drawingLength));
			}
		});

		btnExtWidth.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int auxHeight = NewProjectGUI.getDrawingPanel().getHeight() + 100;
				NewProjectGUI.getDrawingPanel()
						.setPreferredSize(new Dimension(NewProjectGUI.getDrawingPanel().getWidth(), auxHeight));
				NewProjectGUI.getDrawingPanel().revalidate();
				drawingWidth = drawingWidth + 100;
				textFieldWidthNow.setText(String.valueOf(drawingWidth));
			}
		});
	}

}
