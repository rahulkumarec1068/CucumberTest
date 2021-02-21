$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature/Test.feature");
formatter.feature({
  "name": "As a User I want to validate Total Balance is the Sum of Individul Balance",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Perform a Test to validate the total balance matches the sum of the values",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.step({
  "name": "User navigate to url \"https://www.exercise1.com/values\"",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User is on problem#1 Page",
  "keyword": "When "
});
formatter.match({
  "location": "App.user_is_on_Registration_Page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User verify the right count of values appear on the screen",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User verify the values on the screen are greater than 0",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User verify the total balance is correct based on the values listed on the screen",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User verify the values are formatted as currencies",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User verify the total balance matches the sum of the values",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});