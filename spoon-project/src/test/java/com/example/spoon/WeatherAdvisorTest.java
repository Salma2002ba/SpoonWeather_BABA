package com.example.spoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherAdvisorTest {

    @Test
    public void testOriginalAndTransformedBehaviors() {
        // Step 1: Capture the standard output for the original version.
        // This will allow us to compare its behavior with the transformed version.
        ByteArrayOutputStream originalOutput = new ByteArrayOutputStream();
        PrintStream originalStream = new PrintStream(originalOutput);

        // Step 2: Capture the standard output for the transformed version.
        ByteArrayOutputStream transformedOutput = new ByteArrayOutputStream();
        PrintStream transformedStream = new PrintStream(transformedOutput);

        // Step 3: Save the old standard output.
        // We'll restore it later to ensure everything is clean.
        PrintStream oldOut = System.out;

        try {
            // Redirect the output to test the original version.
            System.setOut(originalStream);
            WeatherAdvisor.main(new String[]{}); // Execute the original version.

            // Redirect the output to test the transformed version.
            System.setOut(transformedStream);

            // Step 4: Load the transformed class from the "spooned" directory.
            // Make sure the transformed file is in the correct directory.
            Class<?> transformedClass = Class.forName("com.example.spoon.WeatherAdvisor");
            transformedClass.getMethod("main", String[].class).invoke(null, (Object) new String[]{}); // Execute the transformed version.

        } catch (Exception e) {
            // Catch any exceptions and print the stack trace.
            // This is important for debugging if something goes wrong.
            e.printStackTrace();
        } finally {
            // Step 5: Restore the standard output.
            System.setOut(oldOut);
        }

        // Step 6: Print the outputs of both versions to the console.
        // This is for manual verification if needed.
        System.out.println("Original Version Output:");
        System.out.println(originalOutput.toString()); // Print original output.

        System.out.println("Transformed Version Output:");
        System.out.println(transformedOutput.toString()); // Print transformed output.

        // Step 7: Compare the outputs of the original and transformed versions.
        // They should match perfectly if the transformation is correct.
        assertEquals(originalOutput.toString(), transformedOutput.toString(),
                "The outputs of the original and transformed versions should match!");
    }
}
