package ge.aversiclinic.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {
    private static ExtentReports extent;
    private static ThreadLocal <ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getExtentReports(){

        if (extent == null){
            String reportPath = System.getProperty("user.dir") + "/report/TestReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName("Automation project report");
            sparkReporter.config().setDocumentTitle("Test Report");
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Environment", "Production");
            extent.setSystemInfo("Tester", "Anano Bukvaidze");
        }
        return extent;
    }

    //რეპორტში ქმნის ტესტ, გადაცემული ტესტქეისის სახელით
    public static ExtentTest createTest(String testName){

        ExtentTest extentTest = getExtentReports().createTest(testName);
        test.set(extentTest);

        return extentTest;
    }

    public static ExtentTest getTest(){
        return test.get();
    }

    //ფუნქცია ეშვება ტესტ სუითის ბოლოს და წერს ინფორმაციას რეპორტში
    public static void flushReports(){
        if (extent != null){
            extent.flush();
        }
    }

}
