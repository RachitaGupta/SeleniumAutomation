# SeleniumAutomation
This project is writeen to create a universal tester or a load tester using Selenium. The input to the code are 2 files config.txt and an xml file
config.txt has the
  1.URL of the web application
  2.xml file
xml file contains the test cases.
DOMParser reads from the xml file all the test cases and then parse it to the selenium WebDriver.
The Webdriver runs the application using the test cases.

This is written for simple HTML pages, where the flow of execution depends on the test cases.
The user can store multiple test cases at once.
