package Day_38;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon
{

    public static void main (String[] args)
    {

        WebDriver driver= new ChromeDriver();
        driver.get("https://www.amazon.com");

    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("laptop");
    driver.findElement(By.xpath("//div[@id='sac-suggestion-row-1']")).click();
    String title = driver.findElement(By.xpath("//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']")).getText();

    if (title.equals("laptop"))
    {
        System.out.println("Title is matched");
    }
    else
    {
        System.out.println("Title is not matched");
    }

    }

}
