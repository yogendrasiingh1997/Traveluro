package Java_Script_Exector;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll_Page {
public  static  void main (String[] args){

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.traveluro.com");
        driver.manage().window().maximize();

    JavascriptExecutor js=(JavascriptExecutor) driver;

    //scroll down the page by pixel
    //js.executeScript("window.scrollBy(0,1000)", "");
    //System.out.println(js.executeScript("return window.pageYOffset;"));



    //scroll down the page till the element is visible
    WebElement sub= driver.findElement(By.xpath("//input[@name='btnSubscribe']"));

    js.executeScript("arguments[0].scrollIntoView();", sub);
    //System.out.println(js.executeScript("return window.pageYOffset;"));











    }
}
