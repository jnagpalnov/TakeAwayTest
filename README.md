# TakeAwayTest
<p>Scenarios Automated:</p>
<ul><li>Craete the list before every test run</li>
<li>Update the list</li>
  <li>Add items, update items and remove items from the created list</li>
  <li>Clear the list</li>
   <li>Verify error while creating and updating list without mandatory parameters</li>
   <li>Verify unauthorized error while creating and updating list without proper authorization.</li>
   <li>Removing the created list after every test run</li>
   
</ul>
<h3>Programming Language and Automation Tools</h3>
<ul><li>Programming Language:<b>Java(jdk 1.8)</b></li>
  <li> Build Tool: Maven</li>
  <li> <b>rest-assured 3.3.0</b></li>
  <li> Cucumber-java:6.2.2</li>
  <li>Trivago cluecumber-report-plugin:1.4.2</li>
  <li> IDE: IntelliJ IDEA 2019.3</li>
</ul>
<h3>Folder Structure Overview</h3>
<p>The major components of this projects are:</p>
   <ul>
  <li>src/main/java/stepdefinitions/steps.java: Contains all the code for verifying the themoviedb <b>list</b> api</li>
  <li>src/test/resources/features/MovieDatabaseList.feature: Containing all the test scenarios</li>
  <li>src/test/java/runner/CucumberTestRunner: Junit test runner class</li>
  <li>src/test/resources/features/CentralData.Properties: Containing <b>BaseUri, version,api_key and authorization token.</b></li>
  <li>Target/generated-report: Contains generated html report</li>
  </ul>
  <h3>Running Cucumber Tests:</h3>
  
  <ul>
    <li> Import the project as a maven Project in IDE such as InteliJ IDEA</li>
    <li> If you want to use your own api_key and authorization token then update that in "src/test/resources/CentralData.properties" file else skip this step</li>
 <li><b>Run the "src/test/java/runner/CucumberTestRunner.java" class</b></li>
  </ul>
  <a href="https://ibb.co/CzRthfj"><img src="https://i.ibb.co/L8VPn3T/Screenshot-2020-07-29-at-00-08-53.png" alt="Screenshot-2020-07-29-at-00-08-53" border="0"></a>
 <h3> Cucumber Html output:</h3>
 <p> After running the tests, execute the maven goal <b> mvn cluecumber-report:reporting</b> and it will generate a HTML output report "index.html" under <b>"target/generated-report"</b> folder.</p>
<img src="https://i.ibb.co/W27JgQL/Screenshot-2020-07-29-at-00-14-30.png" alt="Screenshot-2020-07-29-at-00-14-30" border="0">
<img src="https://i.ibb.co/pZm64TS/Screenshot-2020-07-29-at-00-14-35.png" alt="Screenshot-2020-07-29-at-00-14-35" border="0">
