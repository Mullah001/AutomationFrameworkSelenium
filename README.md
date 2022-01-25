
# Automation Framework
## OVERVIEW
The Framework is designed to automate the QA processes for different projects developed at Synavos Solutions. As for now It is covering two major domains i.e. WEB and API Testing.
The Framework is a Maven Project and follows the POM(Page Object Model) design pattern.
## PRE-REQUISITES
1. Java JDK (required 1.8 or later)
    * [Java](https://www.guru99.com/install-java.html "How to install Java")
2. Maven
    * [Maven](https://devwithus.com/install-maven-windows/ "How to install Maven")
3. IDE either Eclipse or Intellij(Community)
    * [Eclipse](https://www.guru99.com/install-eclipse-java.html "Install Eclipse")
    * [Intellij](https://www.thecoderworld.com/how-to-install-intellij-idea-for-java-developers/ "Install Intellij")

## ENVIRONMENT VARIABLES
1. JAVA_HOME
    * [Java_Home](https://www.ibm.com/docs/en/b2b-integrator/5.2?topic=installation-setting-java-variables-in-windows "Set Java_Home")
2. MAVEN_HOME
    * [Maven_Home](https://www.tutorialspoint.com/maven/maven_environment_setup.htm "Set Maven_Home")
3. M2_HOME
    * [M2_Home](https://www.tutorialspoint.com/maven/maven_environment_setup.htm "Set M2_Home")

After setting Environment Variables your “Environment Variables” should look like this:


You can verify the Java and Maven Installation:
1. Open “Command Prompt”
2. For Java type “java -version” and press Enter key
3. For Maven type “mvn -version” and press Enter key
4. Path Variable in Both User Variables and System Variables should contain the path to the bin directories of the Java and Maven, something like the following:


## PROJECT STRUCTURE
### Folders
  * drivers
  * Inputs
  * reports
  * screenshots
  * src
  * target
  * pom.xml
  * testng.xml

  #### 1. drivers:
  This folder contains drivers files, which will be used to run the selenium webdriver instance.

  #### 2. Inputs:
  This folder contains the properties files which will be used for configurations, Environment variables.
  
  Property files will contain the values in Key/Value Pairs. E.g. you can see in the below screenshot ServerURL for the Api is defined as “ServerURL” key, and it’s value is “https://reqres.in/”. 

  #### 3. reports:
  As the name suggests it will contain all the reports for the tests run. File Names are formatted the following way: 
> “AutomationReport -{year}_{month}_{day}_{hours(24h)}_{minutes}_{seconds}_{milliseconds}”

  #### 4. screenshots:
  This folder will contain the screenshots of the tests. File Names are formatted as the following:

> “{MethodName} - {year}_{month}_{day}_{hours(24h)}_{minutes}_{seconds}_{milliseconds}”

  #### 5. src:
  The src directory contains all java files and is a placeholder for other java files.This directory contains two major folders:
   * Main (It contains all the files except the “test” files)
   * Test (It contains only the “test” files)

  #### 6. target:
  This directory contains the compiled test files and different configurations, we will not be using this folder.

  #### 7. pom.xml:
  This file holds all the information about the Compiler, Dependencies, Build, Project Details.

  #### 8. testng.xml:
  This File contains all the details of the test classes, groups, listeners and Any parameters.

### Packages
  #### 1. main:
  This Package has the following Folders:
  
  * ApiConfigs
  * EndPoints
  * Params
  * data
  * pageEvents
  * pageObjects
  * utils
  * 
  #### 2. test:
  * BaseTest
  * Test Classes

### ApiConfigs - EndPoints:
  All the Endpoints for the particular Module or Feature are defined in this folder. Suggested Interface for the Endpoint files so that the values of the EndPoints cannot be changed in other classes. By Default Variables of interface are final.

  Format recommended: Add EP at the end so that you know that this is an endpoint when using

  For Example
 > DemoEP: “listUsersEP”

### ApiConfigs - Params:
  This package contains the parameters if needed for the API Endpoint. The parameters should be in <Key><value> pairs. E.g “page” is the key, and it has value “2”. Currently, using Map<String, String> with HashMap. This will contain the values in key value pairs.

  It is compulsory to use PARAMS as a postfix for the name of the Interface.

  For Example:
 > DemoPARAMS - It has one parameter value
  
  * Key: page	 
  * Value: 2
  
You can find the parameters from the complete url of the request made to API.
  
If you have the following URL then you can divide the complete url as follows
  
  https://reqres.in/api/users?page=2

  URL or ServerURL = https://reqres.in

  EndPoint =/api/users

  Params = page=2

### data:
  
This package has the data for the test cases. 
  
Recommended to use “Data” in the interface name postfix to avoid confusion.
  
For Example:
  
 > DemoData: This interface has all the data variables required to perform the test.
  
  Like: userNameLogin field has the information of the UserName for logIn screen.

### pageEvents:

This package will contain the Classes which will have all the events which will be used for testing the feature or page.

Recommended to use “Events” postfix in the class name for clarification

For Example:

 > DemoPageEvents: It has all the events in Methods form which will be used to test the Demo page.

  Like: TypeUserNameLogin() Method, which will type the userName on the login screen. 

  It will take the userName value from the DemoData and Location of the userName field from the DemoPageElements Interface.

### pageObjects:

  This package will contain the Classes which will have all the locators of the page or feature which need to be tested.

  > Recommended to use “Elements” postfix in the class name for clarification

  For Example:

  > DemoPageElements: It has all the locators for the Demo page.

  Like: userNameLogin variable has the Locator as XPath of the userName field.

### utils:

  This package contains all the utility classes which will help in making the execution of tests easy.

#### 1. CommonMethods:
  As the name suggests it will contain all the common methods which can be used for any kind of help. 

  Like: TakeScreenshot() Method: It will take the screenshot and will need a single parameter of MethodName.

#### 2. Constants:

  This Interface will have all the constants for the project. You can use this interface for the environment variables.

> Like: BaseURL. 

#### 3. FetchElement:

  This class is used to fetch the Web element for the given locator.

#### 4. Locator:

  This is an Enum, This is used for defining the different locators used in selenium.

> Like: ID, XPath

#### 5. PropertyFilesReader:

  This class reads the property files and has different methods for different property elements or files.

#### 6. RetryAnalyzer:

  This class implements the IRetryAnalyzer Interface and will help in retrying the failed tests. You can set the number of retryCount from the Constants Class.

#### 7. RetryListener:

  This listener class is responsible for calling the RetryAnalyzer class which then will help in retrying the failed test.

#### 8. SuiteListener:

  This listener class has different methods for helping in running the tests.

  > Like: onTestFailure Method is helpful when a test fails, we can use this method to take screenshots.

### test - BaseTest:

  As the name suggests this class is the Base of all our tests classes.

  It will be used to initialize the driver and reports.
