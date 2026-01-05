package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"KingsleyGate.StepDef", "TestComponents"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}



// // src\test\java\Runner\TestRunner.java
// package Runner;

// import io.cucumber.testng.AbstractTestNGCucumberTests;
// import io.cucumber.testng.CucumberOptions;
// import org.testng.annotations.DataProvider;
// import org.testng.annotations.Listeners;

// import UtilityFile.RetryListener;

// @CucumberOptions(
//         features = "src/test/resources/Features/Registation.feature",
//         glue = {"KingsleyGate.StepDef","TestComponents"},
//         plugin = {
//                 "pretty",
//                 "json:target/cucumber-report.json",
//                 "rerun:target/failed_scenarios.txt", 
//                 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//         },
//        // tags = "@AccountOverViewInfo",
        
//         //tags = "(@AccountOverViewInfo or @Smoke) and not @regression"
//         monochrome = false,
//         dryRun = false
// )
// @Listeners({RetryListener.class})
// public class TestRunner extends AbstractTestNGCucumberTests 
// {
//     @DataProvider
//     public Object[][] scenario() 
//     {
//         return super.scenarios();
//     }
// }
