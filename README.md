Framework for Appium Tests
===================

### Requirements

- Android Emulator (or physical device)

### How do I run tests?

- To run the tests, execute the following Maven command ('site' is for generating the Allure report):

        mvn clean verify site
        
- If verify isn't required, this command can be executed:
        
        mvn test site
        
- If you want to specify a specific platform (Android Emulator by default):

        mvn clean verify site -Dplatform=androidAppLocal
                
- If you want to specify a specific platform, platform name, platform version and device name:

        mvn clean verify site -Dplatform=androidAppLocal -Dplatform.name=Android -Dplatorm.version=9 -Ddevice.name=Nexus_5X_API_28
                
### Reporting

The framework will generate reports after executing the tests. These reports consist of Allure and Surefire reports.
They can be found at the following locations:
        
        /target/allure-results (json format)
        /target/site (HTML report)
        /target/surefire-reports

### Improvements for when project size increases

- Add support for iOS devices
- Connect to a grid (like Sauce Labs)
- Implement better logging (plugin, screenshots, etc.)
- Implement parallel execution (in batches) when number of tests increase
- Start making use of Util classes, to reuse as much code as possible
- Implement BDD approach (optional)
- Not possible with the example app, but adding proper Ids to all elements would make testing more efficient and stable