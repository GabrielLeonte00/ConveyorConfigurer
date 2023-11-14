package ConveyorConfigurer.Classes.GUI.NewProjectGUI_ActionButtons;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import ConveyorConfigurer.Classes.GUI.NewProjectGUI;

public class ExportButton {

	private JButton btnExport;
	
	public ExportButton(JButton btnExport) {
		this.btnExport = btnExport;
		initialize();
	}

	private void initialize() {
		btnExport.addActionListener(e -> exportPanelAsImage());
	}

	private void exportPanelAsImage() {
        try {
            BufferedImage image = new BufferedImage(NewProjectGUI.getDrawingPanel().getWidth(), NewProjectGUI.getDrawingPanel().getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            NewProjectGUI.getDrawingPanel().printAll(graphics2D);
            graphics2D.dispose();

            File outputFile = new File("testExport.png");
            ImageIO.write(image, "png", outputFile);

            JOptionPane.showMessageDialog(NewProjectGUI.getFrame(), "Panel image exported successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(NewProjectGUI.getFrame(), "Error exporting panel image.");
        }
    }
	
}
