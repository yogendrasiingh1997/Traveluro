package DDT;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class excelUtils {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static XSSFCellStyle style;

    public static int getRowCount(String xlFile, String xlSheet) throws IOException {
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();

        return rowCount;
    }

    public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException
    {
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        row = ws.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();

        return cellCount;
    }

    public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException
    {
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        row = ws.getRow(rowNum);
        cell = row.getCell(colNum);


        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = "";
        }

        wb.close();
        fi.close();
        return data;
    }

    public static void setCellData(String xlFile, String xlSheet,int rowNum, int column, String data ) throws IOException
    {

        fi= new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        row = ws.getRow(rowNum);

        cell = row.getCell(column);
        cell.setCellValue(data);

        fi.close();

        fo= new FileOutputStream(xlFile);
        wb.write(fo);
        wb.close();
        fo.close();
    }

    public static void fillGreenColor(String xlFile, String xlSheet,int rowNum, int column) throws IOException {
        fi= new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        row= ws.getRow(rowNum);
        cell = row.getCell(column);

        style=wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        fi.close();

        fo= new FileOutputStream(xlFile);
        wb.write(fo);
        wb.close();
        fo.close();
    }

    public static void fillRedColor(String xlFile, String xlSheet,int rowNum, int column) throws IOException {
        fi= new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        row= ws.getRow(rowNum);
        cell = row.getCell(column);

        style=wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        fi.close();

        fo= new FileOutputStream(xlFile);
        wb.write(fo);
        wb.close();
        fo.close();
    }

}