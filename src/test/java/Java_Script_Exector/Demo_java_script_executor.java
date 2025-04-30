package Java_Script_Exector;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_java_script_executor {
public static void main (String[] args){

    WebDriver driver=new ChromeDriver();
    driver.get("https://www.traveluro.com");
    driver.manage().window().maximize();

    WebElement search= driver.findElement(By.xpath("//input[@id='myInput']"));

    //pass data into input field, alternative of send key
    JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("arguments[0].setAttribute('value','Paris')",search);

    //click action
    WebElement loginbtn= driver.findElement(By.xpath("//a[@class='clickable'][normalize-space()='Login']"));
    js.executeScript("arguments[0].click()",loginbtn);

















}
}
