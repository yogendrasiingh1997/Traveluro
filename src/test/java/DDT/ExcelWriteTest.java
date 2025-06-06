package DDT;

import java.io.IOException;

public class ExcelWriteTest
{
        public static void main(String[] args) throws IOException {
            String filePath = System.getProperty("user.dir") + "\\TestData\\CitData.xlsx";
            String sheetName = "Sheet1";
            int rowNum = 1;  // Excel row 2 (0-indexed)
            int colNum = 6;  // Excel column G (0-indexed)

            // Try writing to the cell
            try {
                excelUtils.setCellData(filePath, sheetName, rowNum, colNum, "Test Passed");
                System.out.println("Data written successfully.");
            } catch (Exception e) {
                System.out.println("Error writing to Excel: " + e.getMessage());
                e.printStackTrace();
            }
        }
}

