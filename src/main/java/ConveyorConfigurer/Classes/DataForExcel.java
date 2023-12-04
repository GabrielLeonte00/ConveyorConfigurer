package ConveyorConfigurer.Classes;

import java.awt.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JPanel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ConveyorConfigurer.Classes.Components.Curve_roller_conveyor;
import ConveyorConfigurer.Classes.Components.Motorized_roller_conveyor;

public class DataForExcel {

	private static JPanel drawingPanel;

	public static void initialize(JPanel drawingPanel) {
		DataForExcel.drawingPanel = drawingPanel;
	}

	public static void test() {
		Component[] components = drawingPanel.getComponents();

		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Oviso Robotics Equipment List");

			String[] headerColumns = { "Items#", "Type code", "Description of Commodity", "QTY", "Length", "Width",
					"Speed", "Inlet height", "Outlet height", "Zone", "Angle", "Row", "Roller pitch",
					"Driven card type", "Driven card qty", "Driven qty", "Motor direction", "Motor brand",
					"Motor Voltage", "Motor Power", "Brake", "Total Amount in Euro" };

			Row header = sheet.createRow(0);
			header.setHeightInPoints(30);

			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.GOLD.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setAlignment(HorizontalAlignment.CENTER);
			headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			headerStyle.setWrapText(true);
			headerStyle.setBorderBottom(BorderStyle.THIN);
			headerStyle.setBorderRight(BorderStyle.THIN);
			headerStyle.setBorderLeft(BorderStyle.THIN);
			XSSFFont font = ((XSSFWorkbook) workbook).createFont();
			font.setFontName("Calibri");
			font.setFontHeight(10);
			font.setBold(true);
			headerStyle.setFont(font);

			Cell headerCell = header.createCell(0);
			headerCell.setCellValue(headerColumns[0]);
			headerCell.setCellStyle(headerStyle);
			sheet.setAutoFilter(new CellRangeAddress(0, 0, 0, headerColumns.length));
			sheet.autoSizeColumn(0);

			for (int i = 1; i < headerColumns.length; i++) {
				headerCell = header.createCell(i);
				headerCell.setCellValue(headerColumns[i]);
				headerCell.setCellStyle(headerStyle);
				sheet.autoSizeColumn(i);
			}

			String[] headerColumnsType = { "[-]", "[-]", "[-]", "[pcs]", "[mm]", "[mm]", "[mm]", "[mm]", "[mm]", "[mm]",
					"[°]", "[pcs]", "[mm]", "[-]", "[pcs]", "[pcs]", "[R/L]", "[-]", "[-]", "[kW]", "[-]", "" };

			Row headerType = sheet.createRow(1);
			headerType.setHeightInPoints(15);

			CellStyle headerTypeStyle = workbook.createCellStyle();
			headerTypeStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			headerTypeStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerTypeStyle.setAlignment(HorizontalAlignment.CENTER);
			headerTypeStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			headerTypeStyle.setBorderBottom(BorderStyle.THIN);
			headerTypeStyle.setBorderRight(BorderStyle.THIN);
			headerTypeStyle.setBorderLeft(BorderStyle.THIN);
			XSSFFont font2 = ((XSSFWorkbook) workbook).createFont();
			font2.setFontName("Calibri");
			font2.setFontHeight(9);
			font2.setBold(false);
			headerTypeStyle.setFont(font2);

			Cell headerTypeCell = headerType.createCell(0);
			headerTypeCell.setCellValue(headerColumnsType[0]);
			headerTypeCell.setCellStyle(headerTypeStyle);

			for (int i = 1; i < headerColumnsType.length; i++) {
				headerTypeCell = headerType.createCell(i);
				headerTypeCell.setCellValue(headerColumnsType[i]);
				headerTypeCell.setCellStyle(headerTypeStyle);
			}

			CellStyle valuesStyle = workbook.createCellStyle();
			valuesStyle.setAlignment(HorizontalAlignment.CENTER);
			valuesStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			valuesStyle.setFont(font2);

			CellStyle valuesStyleDescription = workbook.createCellStyle();
			valuesStyleDescription.setAlignment(HorizontalAlignment.LEFT);
			valuesStyleDescription.setVerticalAlignment(VerticalAlignment.CENTER);

			int nextRow = 2;
			//
			for (Component component : components) {

				String[] dataForExcel = getComponentValues(component);
				Row values = sheet.createRow(nextRow);
				nextRow++;
				Cell valuesCell = values.createCell(0);
				valuesCell.setCellValue(dataForExcel[0]);
				valuesCell.setCellStyle(valuesStyle);
				for (int i = 1; i < dataForExcel.length; i++) {
					valuesCell = values.createCell(i);
					try {
						int numericValue = Integer.parseInt(dataForExcel[i]);
						valuesCell.setCellValue(numericValue);
					} catch (NumberFormatException e) {
						valuesCell.setCellValue(dataForExcel[i]);
					}
					if (i == 2)
						valuesCell.setCellStyle(valuesStyleDescription);
					else
						valuesCell.setCellStyle(valuesStyle);

					sheet.autoSizeColumn(i);
				}
			}

			//

			File currDir = new File(".");
			String path = currDir.getAbsolutePath();
			String fileLocation = path.substring(0, path.length() - 1) + "tempExcel.xlsx";

			FileOutputStream outputStream = new FileOutputStream(fileLocation);
			workbook.write(outputStream);
			workbook.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static String[] getComponentValues(Component component) {
		if (component instanceof Motorized_roller_conveyor)
			return ((Motorized_roller_conveyor) component).getDataForExcel();
		if (component instanceof Curve_roller_conveyor)
			return ((Curve_roller_conveyor) component).getDataForExcel();
		return null;
	}

}
