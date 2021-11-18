# TestingRegiojetFrontEnd

This is project for FrontEnd testing
Using: IntelliJ, language level: Java 11, Selenium, Selenide, Chromium driver, JUnit

How to make it work:

In case of absence Chromium driver, you have to download it from source for particular OS: https://chromedriver.chromium.org/downloads,
then run exe/exec to install it.

Structure:

In  main/java are: packages pages, steppages, utils and TestBaseModel.java
- package Pages - representing tested screen (contains methods, xpaths)
- package StepPages - representing tested screen, where should be tester 'glue' methods from page(s) into one step.
- package Utils - contains Utils.java where are some useful methods
- TestbaseModel.java - contains methods for setuping environment for testing

In test/java is single test SearchTest.java:
- SearchTest.java - contains 3 testing scenarios (select fastest arrival route, select shortest traveling time route, select route with lowest price)



