# Spoon Project

This project demonstrates how to use the **Spoon** library for code transformation, specifically focusing on transforming `if` conditions and converting `for` loops to `while` loops.

**Created by Salma BABA**  


## Requirements

Before running the project, ensure you have the following installed:

- **Java** (JDK 11 or higher)
- **Maven** (for building and running the project)
- **Spoon** library (automatically included via Maven)



## Setup Instructions

1. **Clone the Repository**:
    - Clone the repository to your local machine:
    ```bash
    git clone https://github.com/Salma2002ba/SpoonWeather_BABA.git
    cd SpoonWeather_BABA
    

2. **Install Dependencies**:
    - Navigate to the project root directory and install all dependencies using Maven:
    ```bash
    mvn clean compile
    

3. **Run the Transformation**:
    - Execute the Spoon transformation to process the code in `WeatherAdvisor.java` and output the transformed version:
    ```bash
    mvn exec:java -Dexec.mainClass="com.example.spoon.SpoonWeather"
    

    **Expected Console Output**:
    
    ========== SPOON TRANSFORMATION STARTED ==========
    ========== SPOON TRANSFORMATION COMPLETED ==========
    

4. **Run Tests**:
    - After performing the transformation, run the tests to compare the original and transformed versions. The tests will check if the behavior remains consistent.
    ```bash
    mvn test
    

    **Sample Test Output**:
    ```
    Original Version Output:
    It's a cool day. Dress warmly.
    The sky is not clear. Keep an umbrella just in case.
    It's windy outside. Hold on to your hat!
    No rain today. You can leave your umbrella at home.

    Transformed Version Output:
    It's a cool day. Dress warmly.
    The sky is not clear. Keep an umbrella just in case.
    It's windy outside. Hold on to your hat!
    No rain today. You can leave your umbrella at home.

    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
    ```



## How It Works

1. **Transformation**:
    - This project uses Spoon to analyze and transform Java code. It focuses on:
        - Inverting the condition in `if` statements and swapping their `then` and `else` blocks.
        - Converting `for` loops into `while` loops for educational purposes.

2. **Testing**:
    - The test suite compares the outputs of the original and transformed versions of the code to ensure functionality is preserved.



## Troubleshooting

- **SLF4J Warning**:
    - You may encounter a warning related to SLF4J:
    ```
    SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
    ```
    - This is a known issue with the SLF4J logger. It does not affect the Spoon transformation's functionality and can be safely ignored.

- **Transformation Errors**:
    - If the transformation fails, check:
        - The Java file paths in your project.
        - The syntax of the `WeatherAdvisor.java` code, ensuring it follows standard conventions.



## Project Structure

- **Source Code**:
    - `src/main/java/com/example/spoon/SpoonWeather.java`: Contains the logic for performing the transformations.

- **Tests**:
    - `test/java/com/example/spoon/WeatherAdvisor.java`: The original code to be transformed.
    - `test/java/com/example/spoon/WeatherAdvisorTest.java`: Tests comparing the outputs of the original and transformed code.

- **Build Artifacts**:
    - `target/`: Compiled files and the generated transformed files.

- **Transformed Code**:
    - `spooned/`: Contains the transformed code generated by Spoon.





- **Author**: Salma BABA
- **Email**: salma2002ba@gmail.com
- **Linkedin**: www.linkedin.com/in/salma-baba-353aaa200
- **GitHub**: [Salma2002ba](https://github.com/Salma2002ba)