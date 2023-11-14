package ConveyorConfigurer.Classes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumericDocumentFilter extends DocumentFilter {
	private int maxLength;

	public NumericDocumentFilter(int maxLength) {
		this.maxLength = maxLength;
	}

	@Override
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
			throws BadLocationException {
		if (isValidInsertion(fb, offset, string)) {
			super.insertString(fb, offset, string, attr);
		}
	}

	@Override
	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
			throws BadLocationException {
		if (isValidReplacement(fb, offset, length, text)) {
			super.replace(fb, offset, length, text, attrs);
		}
	}

	private boolean isValidInsertion(FilterBypass fb, int offset, String string) throws BadLocationException {
		String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());

		return isNumeric(string) && (currentText.length() + string.length() <= maxLength);
	}

	private boolean isValidReplacement(FilterBypass fb, int offset, int length, String text)
			throws BadLocationException {
		String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
		String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
		return isNumeric(text) && (newText.length() <= maxLength);
	}

	private boolean isNumeric(String text) {
		return text.matches("\\d*");
	}
}
