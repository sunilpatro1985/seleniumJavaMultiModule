### Selenium Java Multi-Module Framework  
This repository demonstrates a robust, scalable Multi-Module Maven Architecture for automated UI testing. It separates core framework utilities from specific test implementations, allowing multiple consumer projects to share the same underlying logic.

### 🚀 Tech Stack  
Language: Java
Automation Tool: Selenium WebDriver
Test Runner: TestNG
Build Tool: Maven (Multi-Module)
Design Pattern: Page Object Model (POM) & Singleton Pattern
Reporting: Extent Reports / TestNG Reports  
  
### 🏗 Project Architecture  
The project is divided into a parent-child module structure to promote reusability and clean separation of concerns:

### 1. `framework` (Core Module)
This is the **Common Utils** engine. It contains the base logic that all consumer modules inherit:
* **Driver Management:** Singleton implementation for thread-safe WebDriver instantiation.
* **Base Page:** Common Selenium wrappers (explicit waits, element handling and actions).
* **Utils:** Excel readers (Apache POI), JSON parsers, extent report manager and screenshot capture logic.
* **Base Test** holds the testNG annotations to launch the browser url, set up the extent report and attach screenshot on failure etc.

### 2. Consumer Modules
These modules depend on the `framework` module to execute specific business logic:
* **`cp` :** Specific test suites and page objects for the CP application.
* **`dp1`:** Specific test suites and page objects for the DP1 application.
* **`dp2`:** Specific test suites and page objects for the DP2 application.
  
Note - Each child module will have it's own page object classes and test classes
  
### 📂 Folder Structure
```text
.
├── framework/           # Core utilities and base classes
├── cp/                  # Consumer Module (Tests for CP)
├── dp1/                 # Consumer Module (Tests for DP1)
├── dp2/                 # Consumer Module (Tests for DP2)
├── pom.xml              # Parent POM (Aggregator & Dependency management)
├── testng.xml           # Main execution suite
└── test_data.xlsx       # External data source
└── urls.json            # JSON file for each module URLs
```

### 🔧 Installation & Setup
Prerequisites
JDK 11 or higher
Maven installed
  
Build the Project  
Since this is a multi-module project, install the core framework module first or build from the root:
```  
mvn clean install -DskipTests
```
  
### You can run a specific module by using the flag -pl (project list), 
```
mvn test -pl cp -Dmodule="cp" -Dbrowser="chrome"
```

Another way to trigger the child module tests, is to create testng.xml specific to each child module with parameter tag
```dp2_testng.xml
<parameter name="module" value="dp2"/>
```
  
**App.java**  takes the default values for each variable if no mvn command line parameter (-Dmodule=dp2 or -Dbrowser=chrome) are provided, this is required to launch specific module app urls
**BaseTest.java** takes the parameter values either from **testng.xml** **parameter** section or **App.java**
  
### 📊 Reporting & Logs
Screenshots: Automatically captured on failure and stored in the /screenshot folder.
Logs: Detailed execution logs are available in the /logs directory.
Reports: Refresh the /reports folder after execution to view the HTML test results.
  
### 💡 Key Features
Reusability: The framework module ensures code isn't duplicated across cp, dp1, and dp2.

Scalability: Adding a new consumer module (e.g., dp3) takes minutes.

Parallel Execution: Configured via testng.xml for faster feedback loops.

Data Driven: Built-in support for Excel and JSON data sources.
