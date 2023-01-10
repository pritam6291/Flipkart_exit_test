I am using flipkart website where I have checked the different functionlaities via Automation. This website has been tested with the help of some tools and frameworks.
also i have used Selenium , java, testng,Maven  to write our test cases.


Selenium Webdriver
#Requirements
In order to utilise this project you need to create a Maven project in Eclipse IDE

Maven 3
Chrome and Chromedriver (UI tests use Chrome by default, can be changed in config)
Java 1.8
 In this maven project you have to setup the project after that create some maven dependencies in POM.xl file
through maven repository.After that installed those dependencies in our project and use it.

Also i have used the selenium jars in this project in order to run these test cases so first you have to download these jars in after that copy these jars in our project liberaries which is present inside in build path.

for generating extent report you have to add the dependency in order to make a report so go to google and download extent report dependency and copy these dependencyin POM.xml
## Concept Included

Parallel test runs
Dependency injection
Page Object pattern
Common web page interaction methods
Externalised test configuration
Commonly used test utility classes
Simple security tests
## Extent Reporting//Report



•  I have also used to Integrate the test suit   with Jenkins and GitHub for CI/CD part.For integration through jenkings you need to install the jenkins 
	and performed some operations.



Reporting
Reports for each module are written into their respective /target directories after a successful run


i am putting failed screenshots in seperate folder name of the folder is screenshot.




This Project is also able to run through BatchFile.