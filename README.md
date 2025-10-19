# Unit Converter Grading System

This is a tool for science teachers to automatically grade students’ unit conversion answers.  
It supports temperature conversions between **Kelvin, Celsius, Fahrenheit, and Rankine**, and volume conversions between **liters, tablespoons, cubic-inches, cups, cubic-feet, and gallons**.  

The program checks if a student’s answer is correct to the **tenths place**, and outputs `correct`, `incorrect`, or `invalid`.

You’ll be prompted to enter:

Enter input numerical value:
Enter input unit of measure:
Enter target unit of measure:
Enter student's response:

And a result will be returned


Example:

Enter input numerical value: 100
Enter input unit of measure: celsius
Enter target unit of measure: fahrenheit
Enter student's response: 212
Result: correct


## Features

- Convert between common **temperature** and **volume** units  
- Grade student responses instantly  
- CLI interface for manual testing  
- Written in pure Java 11  
- Includes **JUnit 5 tests** for accuracy  
- Maven-based build and test management


## Requirements

- Java 11
- Maven 3.8.8+


## Installation & Setup

### Clone the repository ###
git clone https://github.com/unmeshap/UnitConverter.git


## Running Tests

This project includes JUnit 5 test cases to verify correctness of both temperature and volume conversions.

To run all tests:
mvn clean test


## Continuous Integration / Deployment

This project uses **GitHub Actions** to automatically build and test the code on every push to the `main` branch and on pull requests.  

- Maven build and JUnit tests are run automatically  
- Compiled JAR is uploaded as an artifact after successful builds  
- Ensures code quality and helps reviewers validate changes before merging


## Future Improvements (Prioritized Development Tasks)
1. Improve Input Validation: Add checks for invalid units, non-numeric input, or missing fields, and provide clear error messages instead of generic “invalid” responses.
2. Enhance Unit Testing: Add test cases for all combinations of units.
3. Add Cache: Have a map that stores all the previous coversions so that re-calculations can be avoided.
4. Implement Dynamic Unit Mapping: Replace hardcoded conversions with a configuration-based system (example: JSON) to make it easy to add new units without code changes.
5. Support Unit Aliases: Allow flexible inputs (example: “C” and “°C” for “celsius”) to make the program more user-friendly.