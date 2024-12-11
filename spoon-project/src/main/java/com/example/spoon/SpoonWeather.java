package com.example.spoon;

import spoon.Launcher;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtIf;

public class SpoonWeather {
    public static void main(String[] args) {
        // Let's start the Spoon transformation process!
        System.out.println("========== SPOON TRANSFORMATION STARTED ==========");

        // 1. Configuring Spoon
        Launcher launcher = new Launcher();

        // 2. Adding the source file to parse
        launcher.addInputResource("src/test/java/com/example/spoon/WeatherAdvisor.java");

        // 3. Setting up the environment
        // Note: Auto-imports will make the code look cleaner after transformation.
        launcher.getEnvironment().setAutoImports(true);
        // Note: NoClasspath mode ensures Spoon doesn't crash if some dependencies are missing.
        launcher.getEnvironment().setNoClasspath(true);

        // 4. Adding a processor to transform "if" blocks
        launcher.addProcessor(new AbstractProcessor<CtIf>() {
            @Override
            public void process(CtIf ctIf) {
                // Here comes the magic: let's invert the condition and swap the blocks!
                if (ctIf.getElseStatement() != null) {
                    // Inverting the condition
                    String invertedCondition = "!(" + ctIf.getCondition().toString() + ")";
                    ctIf.setCondition(getFactory().Code().createCodeSnippetExpression(invertedCondition));

                    // Swapping "then" and "else" blocks
                    var thenBlock = ctIf.getThenStatement();
                    ctIf.setThenStatement(ctIf.getElseStatement());
                    ctIf.setElseStatement(thenBlock);
                }
            }
        });

        // 5. Launching the transformations
        launcher.run();

        // 6. Saving the transformed version
        launcher.setSourceOutputDirectory("spooned");
        // The prettyprint feature ensures the output looks nice and readable.
        launcher.prettyprint();

        // Transformation is done!)
        System.out.println("========== SPOON TRANSFORMATION COMPLETED ==========");
    }
}
