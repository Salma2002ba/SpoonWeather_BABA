package com.example.spoon;
public class WeatherAdvisor {
    public static void main(String[] args) {
        int temperature = 15;
        if (!(temperature > 25)) {
            System.out.println("It's a cool day. Dress warmly.");
        } else {
            System.out.println("It's a hot day. Wear light clothes.");
        }
        String weather = "cloudy";
        if (!(weather.equals("sunny"))) {
            System.out.println("The sky is not clear. Keep an umbrella just in case.");
        } else {
            System.out.println("It's sunny outside. Don't forget your sunglasses!");
        }
        boolean isWindy = true;
        if (!(isWindy)) {
            System.out.println("No wind today. Enjoy a calm day.");
        } else {
            System.out.println("It's windy outside. Hold on to your hat!");
        }
        boolean isRaining = false;
        if (!(isRaining)) {
            System.out.println("No rain today. You can leave your umbrella at home.");
        } else {
            System.out.println("It's raining. Wear a raincoat and take an umbrella.");
        }
    }
}