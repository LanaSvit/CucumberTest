import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@smoke",
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-report.html",
                "json:target/cucumber-reports/cucumber.json"},
        features = "src/test/resources/features/",
        glue = {"steps"}
)
public class SmokeTestCasesRunner extends AbstractTestNGCucumberTests {
}