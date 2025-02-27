package ge.aversiclinic.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

    //ყოველი ტესტის გაშვებისას ვლოგავთ ინფორმაციას, თუ რომელი ტესტ მეთოდი გაეშვა
    @Override
    public void onTestStart(ITestResult result){
        //სტრინგ ტიპის ცვლადში ვინახავთ მეთოდის სახელს
        String testName = result.getMethod().getMethodName();

        //ტესტს ვქმნით რეპორტში მიმდინარე ტესტ მეთოდის სახელით
        ReportManager.createTest(testName);

        //კონსოლში ვლოგავთ ტესტქეისის დაწყებას
        System.out.println("Test Started: " + result.getName());
    }

    //ყოველ ჯერზე როცა ტესტქეისის სტატუსია საქსესი, რეპორტში ვლოგავთ ამ ინფორმაციას, ასევე ვბეჭდავთ კონსოლში
    @Override
    public void onTestSuccess(ITestResult result){
        //რეპორტში ტესტ ქეისს ვანიჭებთ pass სტატუსს
        ReportManager.getTest().pass("Test Passed");

        //ვბეჭდავთ ტესტ საქსესს კონსოლში
        System.out.println("Test Success: " + result.getName());
    }

    //როცა ტესტქეისი ფეილდება, რეპორტში ვლოგავთ ამ ინფორმაციას, ასევე ვბეჭდავთ კონსოლში
    @Override
    public void onTestFailure(ITestResult result){
        //რეპორტში აღნიშნულ ტესტქეისს ვანიჭებთ Failed სტატუსს
        ReportManager.getTest().fail("Test Failed");
        System.out.println("Test Failure: " + result.getName());
    }

    //ტესტ სუითის დასაწყისს ვბეჭდავთ კონსოლში, თუ რომელი სუითი დაიწყო
    @Override
    public void onStart(ITestContext context){
        System.out.println("Suite Started: " + context.getName());
    }

    //ტესტ სუითის დასასრულს ვბეჭდავთ კონსოლში, თუ რომელი სუითი დამთავრდა
    @Override
    public void onFinish(ITestContext context){
        System.out.println("Suite Finished: " + context.getName());

        //ვწერთ ყველა შედეგს რეპორტში
        ReportManager.flushReports();
    }
}

