# Appium_java_automation_framework
# Introduction
This UI automation testing framework uses appium 2 tool as automation tool and JAVA as base language. We have adopted the cucumber BDD framework structure so that the tests can be easily understandable and readable with no technical knowledge. Maven is the build configuration tool used in the framework. Tests reports are generated at the end of test execution with detailed information about each scenario and steps. We are using the POM (Page Object Model) approach, but we call Screen instead of Page, which will provide an isolated space to store and manage test elements. So that we can easily adjust OR add new tests quite easily and quickly

# Getting Started
1. Set ANDROID_HOME (Can be found in Android Studio) and JAVA_HOME path in windows OR mac respectively
2. Install Node.js/NPM
3. Install Appium using npm (cmd/terminal)

        npm install -g Appium 

4. Install required drivers of Appium(cmd/terminal)

        appium driver install uiautomator2 

        appium driver install xcuitest 

5. Open the repository on IntelliJ

6. Open POM.xml file on home directory and load the dependencies

7. Right click on POM.xml file and load maven dependencies

# Execute Test
1. Start Appium server through cmd/terminal

        appium 

2. For Android “USB debugging should be enabled” and run command “adb devices” to check connected device

        Right click on Runner.java file at Src/Test/Java/runner/RunnerTest.java and select RUN 

3. Execution will be started and run status will be displayed in real time. After test execution HTML reports are generated at reports/test-reports/{date-time}/cucumber-html-reports

## NOTE:
Framework is configured to run tests only for Android environment. Will need to adjust a few things in the framework and minimal setup is needed for iOS execution in the local machine. Which can be done quickly(We need mac for iOS automation)