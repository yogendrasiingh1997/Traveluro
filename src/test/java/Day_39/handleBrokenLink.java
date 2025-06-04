package Day_39;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class handleBrokenLink {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.traveluro.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> link= driver.findElements(By.tagName("a"));
        System.out.println("Total link: " + link.size());

        int noOfBrokenLink=0;

        for(WebElement linkElements: link)
        {
            String hrefValue= linkElements.getAttribute("href");
            if(hrefValue==null || hrefValue.isEmpty())
            {
                System.out.println("href value null or empty so not possible to check link");
                continue;
            }

            try {
                URL linkUrl = new URL(hrefValue);// convert href value from string to url

                HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection(); //open connection to the server
                connection.connect(); //connect to the server and send request to the server

                if (connection.getResponseCode() >= 400) {
                    System.out.println( hrefValue + "==> + Broken link");
                    noOfBrokenLink++;
                } else {
                    System.out.println(hrefValue + "==>Not a broken link");
                }
            }
            catch (Exception ignored)
            {

            }
        }

        System.out.println("no of broken link" + noOfBrokenLink);
    }
}
