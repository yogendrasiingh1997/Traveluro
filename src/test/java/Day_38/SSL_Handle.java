package Day_38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SSL_Handle {
    public  static  void main (String[] args){



        ChromeOptions options= new ChromeOptions();
        options.setAcceptInsecureCerts(true); //accept ssl certificate
        WebDriver driver=new ChromeDriver(options);

        driver.get("https://self-signed.badssl.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        System.out.println(driver.getTitle());





}}