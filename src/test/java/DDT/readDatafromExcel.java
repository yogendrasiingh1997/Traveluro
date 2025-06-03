package DDT;

//Excel file --> Workbook --> Sheets --> Row --> cells

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class readDatafromExcel
{
    public static void main(String [] args) throws IOException {
        //FileInputStream file= new FileInputStream("C:\\Users\\ADMIN\\IdeaProjects\\Traveluro\\TestData\\login_Data.xlsx");


        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\login_Data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);


        XSSFSheet sheet=workbook.getSheet("LoginData");                 //XSSFSheet sheet=workbook.getSheetAt(0);

       int totalRows = sheet.getLastRowNum();

       int totalCells= sheet.getRow(1).getLastCellNum();

        System.out.println("Total number of rows: " + totalRows);
        System.out.println("Total number of cells: " + totalCells);

        for(int r=0; r<=totalRows; r++)
        {
            XSSFRow currentRow= sheet.getRow(r);

            for(int c=0; c<totalCells; c++)
            {
                XSSFCell cell= currentRow.getCell(c);
                System.out.println(cell.toString());
            }
        }

        workbook.close();
        file.close();



    }
}
