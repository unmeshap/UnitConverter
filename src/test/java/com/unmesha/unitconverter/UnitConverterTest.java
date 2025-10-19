package com.unmesha.unitconverter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitConverterTest {

    // Temperature Conversion Tests
    @Test
    void testCelsiusToFahrenheit() {
        double result = UnitConverter.convertTemperature(100, "celsius", "fahrenheit");
        assertEquals(212.0, result);
    }

    @Test
    void testFahrenheitToCelsius() {
        double result = UnitConverter.convertTemperature(100, "fahrenheit", "celsius");
        assertEquals(37.8, result);
    }

    @Test
    void testKelvinToRankine() {
        double result = UnitConverter.convertTemperature(0, "kelvin", "rankine");
        assertEquals(0.0, result);
    }

    // Volume Conversion Tests
    @Test
    void testVolumeLitersToGallons() {
        double result = UnitConverter.convertVolume(3.7854, "liters", "gallons");
        assertEquals(1.0, result);
    }

    @Test
    void testCupsToTablespoons() {
        double result = UnitConverter.convertVolume(1, "cups", "tablespoons");
        assertEquals(16.0, result);
    }

    // Grading Tests
    @Test
    void testGradeCorrectTemperature() {
        String grade = UnitConverter.gradeResponse(100, "celsius", "fahrenheit", 212);
        assertEquals("correct", grade);
    }

    @Test
    void testGradeIncorrectTemperature() {
        String grade = UnitConverter.gradeResponse(0, "celsius", "fahrenheit", 100);
        assertEquals("incorrect", grade);
    }

    @Test
    void testGradeInvalidUnit() {
        String grade = UnitConverter.gradeResponse(10, "meters", "liters", 10);
        assertEquals("invalid", grade);
    }

    @Test
    void testGradeCorrectVolume() {
        String grade = UnitConverter.gradeResponse(3.7854, "liters", "gallons", 1);
        assertEquals("correct", grade);
    }

    @Test
    void testGradeIncorrectVolume() {
        String grade = UnitConverter.gradeResponse(1, "cups", "tablespoons", 10);
        assertEquals("incorrect", grade);
    }
}
