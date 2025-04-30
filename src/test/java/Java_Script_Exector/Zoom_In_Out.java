package Java_Script_Exector;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zoom_In_Out {
    public  static  void main (String[] args){

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.traveluro.com");
        driver.manage().window().maximize();


        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='67%'");



}}
