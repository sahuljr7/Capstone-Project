package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {

    // 🔹 Reads complete Excel data (skips header row)
    public static List<String[]> getExcelData(String filePath, String sheetName) {
        List<String[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rows = sheet.iterator();
            if (rows.hasNext()) rows.next(); // skip header row

            while (rows.hasNext()) {
                Row row = rows.next();
                String username = getCellValue(row.getCell(0));
                String password = getCellValue(row.getCell(1));
                String expected = getCellValue(row.getCell(2));
                data.add(new String[]{username, password, expected});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // 🔹 Get row count (including header)
    public static int getRowCount(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            return sheet.getPhysicalNumberOfRows();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 🔹 Get column count (from header row)
    public static int getColCount(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            return headerRow.getPhysicalNumberOfCells();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 🔹 Get single cell data
    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            if (row != null) {
                return getCellValue(row.getCell(colNum));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    // 🔹 Utility: Convert any cell type to String
    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell).trim();
    }
}
