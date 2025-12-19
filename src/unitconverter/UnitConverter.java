package unitconverter;

import java.util.Scanner;

public class UnitConverter {

    public static void run(Scanner scanner) {
        System.out.println("Welcome to Unit Converter");

        System.out.println("Choose conversion:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Kilograms to Pounds");

        int choice = scanner.nextInt();
        System.out.print("Enter value: ");
        double value = scanner.nextDouble();

        Converter converter;

        if (choice == 1) {
            converter = new TemperatureConverter();
        } else {
            converter = new WeightConverter();
        }

        double result = converter.convert(value);
        System.out.println("Result: " + result);
    }
}