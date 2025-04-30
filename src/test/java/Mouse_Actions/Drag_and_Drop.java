package Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class Drag_and_Drop {
public static void main(String[] args) throws InterruptedException {


    WebDriver driver= new ChromeDriver();
    Actions act= new Actions(driver);
    driver.get("https://demoqa.com/droppable");
    driver.manage().window().maximize();
    Thread.sleep(5000);

    WebElement source= driver.findElement(By.xpath("//div[@id='draggable']"));
    WebElement target = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));

    act.dragAndDrop(source,target).perform();

    driver.close();






    }
}
