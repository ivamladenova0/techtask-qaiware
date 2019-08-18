package utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static HSSFWorkbook workbook;
    public static HSSFSheet worksheet;
    public static DataFormatter formatter = new DataFormatter();

    public Object[][] ReadExcelSheet(String fileLocation, String sheetName) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(fileLocation);
        workbook = new HSSFWorkbook(fileInputStream);
        worksheet = workbook.getSheet(sheetName);
        HSSFRow row = worksheet.getRow(0);
        int rowNum = worksheet.getPhysicalNumberOfRows();
        int colNum = row.getLastCellNum();

        Object Data[][] = new Object[rowNum - 1][colNum];

        for (int i = 0; i < rowNum - 1; i++) {
            HSSFRow currentRow = worksheet.getRow(i + 1);

            for (int j = 0; j < colNum; j++) {
                if (row == null)
                    Data[i][j] = "";
                else {
                    HSSFCell cell = currentRow.getCell(j);
                    if (cell == null)
                        Data[i][j] = "";
                    else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value;
                    }
                }
            }

        }
        return Data;
    }
}