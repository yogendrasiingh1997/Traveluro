package Day_38;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class ScreenShot {
    public  static  void main (String[] args){

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.traveluro.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='67%'");



        //Full page screenshot

        TakesScreenshot ts= (TakesScreenshot) driver;

        File sourcefile= ts.getScreenshotAs(OutputType.FILE);
        File targetfile= new File("C:\\Users\\ADMIN\\Desktop\\Screenshot\\fullpage.png");

        sourcefile.renameTo(targetfile);   //copy sourcefile to target file


        //Specific are ss

       WebElement top_destination= driver.findElement(By.xpath("//div[contains(@class,'wow fadeInUp musement-destination-desktop')]//div[@class='col-lg-12']"));

        File sourcefile1=top_destination.getScreenshotAs(OutputType.FILE);
        File targetfile1= new File("C:\\Users\\ADMIN\\Desktop\\Screenshot\\topdestination.png");
        sourcefile1.renameTo(targetfile1);   //copy sourcefile to target file







}}

