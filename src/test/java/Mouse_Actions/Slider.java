package Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {
    public static void main (String[] args){

        WebDriver driver= new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/sliders/#Range");
        driver.manage().window().maximize();

        Actions act= new Actions(driver);
        //frame swtich
        WebElement frame= driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame lazyloaded']"));
        driver.switchTo().frame(frame);

        WebElement minslider= driver.findElement(By.xpath("//span[1]"));

        System.out.println("Default Location of min slider "+ minslider.getLocation()); //(101, 47)

        act.dragAndDropBy(minslider,-50,47).perform();

        System.out.println("new Location of min slider "+ minslider.getLocation());













    }
}
