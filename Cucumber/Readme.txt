selenium-cucumber-java-maven
selenium-cucumber : Automation Testing Using Java

selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. It enables you to write and execute automated 
acceptance/unit tests. It is cross-platform, open source and free. Automate your test cases with minimal coding.

Documentation
Installation
Predefined steps
Download a Framework
Maven - 

Framework Architecture
Cucumber
	|
	|_src/main/java
	|	|_com.mass.cucumber.impl
	|	|	|_UtilHelper.java
	|	|	|
	|	|_com.mass.cucumber.pageObject
	|	|	|_ApplicationText.java
	|	|	|_Problem1PageObject.java
	|	|	|
	|	|_com.mass.cucumber.steps
	|		|_Problem1Test
	|		|
	|_src/main/resources
	|_src/test/java
	|	|_com.mass.cucumber.runner
	|	|	|_CucumberRunner
	|	|	|
	|_src/test/resources
	|	|_features
	|	|	|_Problem1.feature
	|_configFile
	|   |_config.properties 
    |   |_log4j.properties	
	    
src/test/resources - consit feature folder which used for containing all features files.
config File- use for properties file or test data file
src/test/java - conssit 1 package and only CucumberRunner class
src/main/java/ - this onsist 3 packages for Utility classes, PageObject classes and for Steps 

Writing a test
The cucumber features goes in the features library and should have the ".feature" extension.

You can start out by looking at features/Problem1.feature. You can extend this feature or make your own features using some of the predefined steps that comes
with selenium-cucumber.

Predefined steps
By using predefined steps you can automate your test cases more quickly, more efficiently and without much coding.

Running test
Go to com.mass.cucumber.runner package an run the CucumberRunner file or run feature files. 
or
Go to your project directory from terminal and hit following commands
mvn test (defualt will run on local firefox browser)
mvn test "-Dbrowser=chrome" (to use any other browser)
mvn test -Dcucumber.options="classpath:features/Problem1.feature" to run specific feature.
mvn test -Dcucumber.options="–-plugin html:target/result-html" to generate a HTML report.
mvn test -Dcucumber.options="–-plugin json:target/result-json" to generate a JSON report.