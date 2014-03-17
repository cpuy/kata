package colin.kata.primefactors.acceptance.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "html:target/cucumber-html-report" })
public class RunCukesTest {
}