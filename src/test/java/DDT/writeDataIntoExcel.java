package DDT;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class writeDataIntoExcel
{
    public static void main (String[] args) throws IOException {
        FileOutputStream file= new FileOutputStream(System.getProperty("user.dir")+ "\\TestData\\myFile.xlsx");

        XSSFWorkbook workbook= new XSSFWorkbook();

        XSSFSheet sheet =workbook.createSheet("Sheet1");

        XSSFRow row1= sheet.createRow(0);
        row1.createCell(0).setCellValue("Welcome");
        row1.createCell(1).setCellValue("to");
        row1.createCell(2).setCellValue("Empire");

        XSSFRow row2= sheet.createRow(1);
        row2.createCell(0).setCellValue("pubg");
        row2.createCell(1).setCellValue("to");
        row2.createCell(2).setCellValue("World");

        XSSFRow row3= sheet.createRow(2);
        row3.createCell(0).setCellValue("pubg");
        row3.createCell(1).setCellValue("to");
        row3.createCell(2).setCellValue("World");

        workbook.write(file);
        workbook.close();
        file.close();

        System.out.println("File is created");
        




    }
}
