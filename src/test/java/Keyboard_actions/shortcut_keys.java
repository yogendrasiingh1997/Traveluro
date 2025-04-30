package Keyboard_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class shortcut_keys {
    public static void main (String[] args){


        WebDriver driver= new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Yogendra");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("Yogendra@abc.com");

        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("ahmedabad");

        Actions act= new Actions(driver);

        //ctrl a
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        //ctrl c
        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

        //Tab
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        //ctrl v
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();









    }
}
