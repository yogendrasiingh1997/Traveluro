package DDT;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class citBank
{
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
        driver.manage().window().maximize();
        Thread.sleep(10000);

        ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='67%'");
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 250)");

        String filePath= System.getProperty("user.dir")+ "\\TestData\\CitData.xlsx";

        int totalRows= excelUtils.getRowCount(filePath,"Sheet1");
        int totalCell=excelUtils.getCellCount(filePath,"Sheet1",1);
        System.out.println("Total row: "+ totalRows);
        System.out.println("Total cell: "+ totalCell);

        for (int i= 1; i<=totalRows; i++)
        {
            //Read data from excel

            String deposit= excelUtils.getCellData(filePath,"Sheet1",i,0);
            String months= excelUtils.getCellData(filePath,"Sheet1",i,1);
            String roi= excelUtils.getCellData(filePath,"Sheet1",i,2);
            //String compounding= excelUtils.getCellData(filePath,"Sheet1",i,3);
            String exp_total= excelUtils.getCellData(filePath,"Sheet1",i,4);


            //Pass the above data into application

            WebElement input =driver.findElement(By.xpath("//input[@id='mat-input-0']"));
            input.click();
            input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            input.sendKeys(Keys.DELETE);
            input.sendKeys(deposit);

            WebElement input1 = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
            input1.click();
            input1.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            input1.sendKeys(Keys.DELETE);
            input1.sendKeys(months);


            WebElement input2=driver.findElement(By.xpath("//input[@id='mat-input-2']"));
            input2.click();
            input2.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            input2.sendKeys(Keys.DELETE);
            input2.sendKeys(roi);;


            driver.findElement(By.xpath("//button[@id='CIT-chart-submit']//div[@class='mdc-button__ripple']")).click();

            //Validation

            String act_totalValue= driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();

            double actual = Double.parseDouble(act_totalValue.replace("$", "").replace(",", "").trim());
            double expected = Double.parseDouble(exp_total.replace("$", "").replace(",", "").trim());

            if(expected==actual)
            {
                System.out.println("Test Passed");
                excelUtils.setCellData(filePath,"Sheet1",i,6,"Passed");
                excelUtils.fillGreenColor(filePath,"Sheet1",i,6);
            }
            else
            {
                System.out.println("Test failed");
                excelUtils.setCellData(filePath,"Sheet1",i,6,"Failed");
                excelUtils.fillRedColor(filePath,"Sheet1",i,6);
            }

        }
        driver.quit();

    }
}
