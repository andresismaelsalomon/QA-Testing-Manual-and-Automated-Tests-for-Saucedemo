
# QA-Testing-Manual-and-Automated-Tests-for-Saucedemo

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Structure](#structure)
- [Testing Approach in Order](testing-approach-in-order)
- [Test Coverage](#test-coverage)
- [Technologies and Tools](#technologies-and-tools)

## Installation

Clone it with the following command:

```bash
  git clone https://github.com/andresismaelsalomon/QA-Testing-Manual-and-Automated-Tests-for-Saucedemo.git
```
Open it on your preferred IDE.

## Usage
The tests must be executed from a testng suite.

### Examples
Right click a TESTNG xml file and click "Run '..\test-ng.xml" or "Run '..\test-ng.xml' with coverage

![App Screenshot](https://i.ibb.co/9NmR3XV/image-2023-06-23-115956149.png)


## Structure

The tests suites on the suites folder have been categorized by functionality.

```
├───.idea
├───src
│   ├───main
│   │   ├───java
│   │   └───resources
│   └───test
│       ├───java
│       │   └───chromedriver_win32
│       └───suites
└───Test Documentation
```

## Testing Approach in Order
### 1-Exploration Testing
### 2-Created a [Test Plan Document](https://docs.google.com/document/d/1Ozv6cBnQcj46x3ZbeHRY0MpNEzB3CNhZqKwZlHKhM4Y/edit?usp=sharing)
In which I outlined the test approach (functional testing) the format of the test deliverables, the activities and schedule, the test entry and exit criteria, execution and completion.
### 3-Created a [Test Specification Document](https://docs.google.com/document/d/1q09rINQcMKxeFBHA6A8vW0IJGkoZEyeML788kfZuUeo/edit?usp=sharing).
### 4-Created a [Test Case Execution Document](https://docs.google.com/spreadsheets/d/18yagvCzcSEiaJCmZx5Hme_5UevKPKi6j5KArg_1f7Cc/edit?usp=sharing).
It's a google sheets file (.xlsx) following the standard written on the Test Specification Document.
### 5-Execution of the tests
Manually.
### 6-Documentation of the actual test results
On the Test Cases (.xlsx) document(Look point number 4).
### 7-Automation
Done with TestNG, Selenium and ChromeDriver by making each area it's own test suite and making each test execute a WebDriver extended from the BasePageTest Class.

## Test Coverage
The idea was to cover the main functionalities of the website.
By doing exploration testing I found that the main areas are:
**User Authentication,Product Listing,Cart Management and Checkout Flow**

## Technologies and Tools
### TestNG, Selenium and ChromeDriver
