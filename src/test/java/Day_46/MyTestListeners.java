package Day_46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListeners implements ITestListener {

    public void onStart(ITestContext context)
    {
        System.out.println("test execution is started...");
    }

    public void onTestStart(ITestResult result)
    {
        System.out.println("test started");
    }


    public void onTestSuccess(ITestResult result)
    {
        System.out.println("test success");
    }

    public void onTestFailure(ITestResult result)
    {
        System.out.println("test failed");
    }

    public void onTestSkipped(ITestResult result)
    {
        System.out.println("test skip");
    }

    public void onFinish(ITestContext context)
    {
        System.out.println("test execution is completed");
    }
}
