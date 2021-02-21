package com.mass.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

/**
 * Runner for Cucumber tests.
 * 
 * Specifies various Cucumber options like where to find feature files and step
 * definitions.
 * 
 * Good reference: https://testingneeds.wordpress.com/tag/cucumberoptions/
 *
 * Without the "glue" and "features" options, it automatically finds all
 * .feature and step definitions on the classpath.
 * 
 * Useful Tutorials:
 * 
 * * https://automationpanda.com/2017/10/24/cucumber-jvm-for-java/
 */

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber/test.html", "rerun:target/failedrerun.txt","junit:target/cucumber.xml"},tags ="@nightly", glue =
{"com.mass.cucumber.steps"} ,features={"src/test/resources/feature/Test.feature"} 
)

public class CucumberRunner {
	
	
}
