package com.contentTest.Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com.contentTest.Features/ResourcesAndMenu.feature",
		glue= {"src/test/java/com.contentTest.StepDefinitions/ResourcesStepDef.java"},
		format={"pretty","html:test-outout"}
		)
		
		
		public class TestRunner {
}

