package ConveyorConfigurer.Classes;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumericDocumentFilter_maxNumber extends DocumentFilter {
	private static final int MAX_LENGTH = 3;

	@Override
	public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
		if (isNumeric(text)) {
			String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
			if (isValidNumeric(newStr)) {
				super.insertString(fb, offset, text, attr);
			} else {
				showWarningDialog();
			}
		} else {
			showWarningDialog();
		}
	}

	@Override
	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
			throws BadLocationException {
		if (isNumeric(text)) {
			String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()).substring(0, offset) + text
					+ fb.getDocument().getText(offset + length, fb.getDocument().getLength() - offset - length);
			if (isValidNumeric(newStr)) {
				super.replace(fb, offset, length, text, attrs);
			} else {
				showWarningDialog();
			}
		} else {
			showWarningDialog();
		}
	}

	private void showWarningDialog() {
		JOptionPane.showMessageDialog(null, "Please enter a valid numeric value equal or bellow 120.", "Warning",
				JOptionPane.WARNING_MESSAGE);
	}

	private boolean isNumeric(String str) {
		return str.matches("\\d*");
	}

	private boolean isValidNumeric(String str) {
		return isNumeric(str) && Integer.parseInt(str) <= 120 && str.length() <= MAX_LENGTH;
	}
}
