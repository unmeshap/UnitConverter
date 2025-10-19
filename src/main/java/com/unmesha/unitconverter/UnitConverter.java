package com.unmesha.unitconverter;
import java.util.*;

public class UnitConverter {
    private static final Set<String> TEMP_UNITS = new HashSet<>(Arrays.asList("kelvin", "celsius", "fahrenheit", "rankine"));

    private static final Map<String, Double> VOLUME_CONVERSION = new HashMap<String, Double>() {{
        put("liters", 28.32);
        put("tablespoons", 1914.9);
        put("cubic-inches", 1728.0);
        put("cups", 119.68);
        put("cubic-feet", 1.0);
        put("gallons", 7.48);
    }};

    public static String gradeResponse(double value, String fromUnit, String toUnit, double studentResponse) {
        double answer;
        if (TEMP_UNITS.contains(fromUnit) && TEMP_UNITS.contains(toUnit)) {
            answer = convertTemperature(value, fromUnit, toUnit);
        } else if (VOLUME_CONVERSION.containsKey(fromUnit) && VOLUME_CONVERSION.containsKey(toUnit)) {
            answer = convertVolume(value, fromUnit, toUnit);
        } else {
            return "invalid";
        }

        if (answer == Math.round(studentResponse * 10.0) / 10.0) {
            return "correct";
        } else {
            return "incorrect";
        }
    }

    public static double convertTemperature(double value, String fromUnit, String toUnit) {
        double kelvin = toKelvin(value, fromUnit);
        double converted = fromKelvin(kelvin, toUnit);
        return Math.round(converted * 10.0) / 10.0;
    }

    public static double convertVolume(double value, String fromUnit, String toUnit) {
        double converted = (VOLUME_CONVERSION.get(toUnit)/VOLUME_CONVERSION.get(fromUnit)) * value;
        return Math.round(converted * 10.0) / 10.0;
    }

    private static double toKelvin(double value, String fromUnit) {
        switch (fromUnit) {
            case "kelvin":
                return value;
            case "celsius":
                return value + 273.15;
            case "fahrenheit":
                return (value + 459.67) * 5 / 9;
            case "rankine":
                return value * 5 / 9;
            default:
                throw new IllegalArgumentException("Unsupported temperature unit: " + fromUnit);
        }
    }

    private static double fromKelvin(double kelvin, String toUnit) {
        switch (toUnit) {
            case "kelvin":
                return kelvin;
            case "celsius":
                return kelvin - 273.15;
            case "fahrenheit":
                return kelvin * 9 / 5 - 459.67;
            case "rankine":
                return kelvin * 9 / 5;
            default:
                throw new IllegalArgumentException("Unsupported temperature unit: " + toUnit);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input numerical value: ");
        double value = sc.nextDouble();

        System.out.print("Enter input unit of measure: ");
        String fromUnit = sc.next().toLowerCase();

        System.out.print("Enter target unit of measure: ");
        String toUnit = sc.next().toLowerCase();

        System.out.print("Enter student's response: ");

        String result = sc.hasNextDouble() ? gradeResponse(value, fromUnit, toUnit, sc.nextDouble()) : "invalid";
        System.out.println("Result: " + result);

        sc.close();
    }
}