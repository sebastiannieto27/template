package co.com.core.commons.reports;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;

public class ExcelReportUtil {
	
	private static final Logger logger = Logger.getLogger(ExcelReportUtil.class);
	
	/**
	 * Creates the files headers
	 * @param headers
	 * @param sheet
	 * @param rowPos
	 * @return
	 */
	public static HSSFRow createFileHead(List<String> headers, HSSFSheet sheet, int rowPos) {
		HSSFRow rowhead = sheet.createRow((short)rowPos);
        
		int colCounter = 0;
		
		if(headers!=null && headers.size()>0) {
			for(String head : headers) {
				rowhead.createCell(colCounter).setCellValue(head);
				colCounter++;
			}
		}
        
        return rowhead;
	}
	
	public static Font crateFileFontStyle(HSSFWorkbook workbook, short color, String type, int size, boolean bold, boolean italic) {
		Font font = workbook.createFont();
        font.setFontHeightInPoints((short)size);
        font.setFontName(type);
        font.setItalic(italic);
        font.setBold(bold);
        font.setColor(color);
        return font;
	}
}
