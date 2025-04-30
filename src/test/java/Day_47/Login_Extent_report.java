package Day_47;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Login_Extent_report implements ITestListener
{
    String timestamp= new SimpleDateFormat("yyyy-MM-DD-HH-mm-ss").format(new Date());
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext context)
    {
        sparkReporter= new ExtentSparkReporter("C://Users//ADMIN//Desktop/report//loginreport" + timestamp+ ".html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Login Test");
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
        test=extent.createTest(result.getName());
        test.log(Status.PASS, "Test is passed:" + result.getName());
    }

    public void onTestFailure(ITestResult result)
    {
        test= extent.createTest(result.getName());
        test.log(Status.FAIL, "Test is failed:" + result.getName());
        test.log(Status.FAIL, "Test failed cause:" + result.getThrowable());
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
