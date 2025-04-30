package Day_46;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Extent_Report_Manger implements ITestListener

{
    String timestamp= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    public ExtentSparkReporter sparkReporter; //UI of the report
    public ExtentReports extent; //populate common info on the report
    public ExtentTest test; //creating test cases entries in the report and update status of test case method
    public String report= "C://Users//ADMIN//Desktop/report//myreport" + timestamp+ ".html";

public void onStart(ITestContext context)
{
   // String report_path= "C://Users//ADMIN//Desktop/report//";
    sparkReporter= new ExtentSparkReporter(report);
    sparkReporter.config().setDocumentTitle("Automation Report");
    sparkReporter.config().setReportName("Functional Report");
    sparkReporter.config().setTheme(Theme.DARK);

    extent= new ExtentReports();
    extent.attachReporter(sparkReporter);
    extent.setSystemInfo("Computer name", "LocalHost");
    extent.setSystemInfo("Environment", "Prod");
    extent.setSystemInfo("Tester name", "Yogendra");
    extent.setSystemInfo("OS", "Windows");
    extent.setSystemInfo("Browser", "Chrome");

}

    public void onTestSuccess(ITestResult result)
    {
        test=extent.createTest(result.getName()); //create a new entry in table
        test.log(Status.PASS, "Test case passed is: "+ result.getName());  //update status p/f/s
    }

    public void onTestFailure(ITestResult result)
    {
        test=extent.createTest(result.getName()); //create a new entry in table
        test.log(Status.PASS, "Test case failed is: "+ result.getName());  //update status p/f/s
        test.log(Status.FAIL, "Test case failed cause is: "+ result.getThrowable());

       //// Get WebDriver from BaseClass
        Object testInstance= result.getInstance();
        WebDriver driver= ((listeners) testInstance).getDriver();

        //Take screenshot
        String screenshotPath= takeScreenshot(driver, result.getName());

    }

    //Screenshot method
    private String takeScreenshot(WebDriver driver, String testName)
    {
        String path="C://Users//ADMIN//Desktop//Screenshot/"+ testName+  "_"+timestamp+".png";

        TakesScreenshot ts= (TakesScreenshot) driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        File target= new File(path);

        source.renameTo(target);


        return path;
    }


    public void onTestSkipped(ITestResult result)
    {
        test=extent.createTest(result.getName()); //create a new entry in table
        test.log(Status.SKIP, "Test case skip is: "+ result.getName());  //update status p/f/s
    }

    public void onFinish(ITestContext context)
    {
        extent.flush();
    }














}
