package unitconverter;

import java.util.Scanner;


public class UnitConverter {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Unit Converter ===");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Kilograms to Pounds");
        System.out.println("4. Pounds to Kilograms");

        System.out.print("Choose an option: ");
        int choice = input.nextInt();

        System.out.print("Enter value: ");
        double value = input.nextDouble();

        double result;

        switch (choice) {
            case 1:
                result = Converter.celsiusToFahrenheit(value);
                break;
            case 2:
                result = Converter.fahrenheitToCelsius(value);
                break;    
            case 3:
                result = Converter.kgToPounds(value);
                break;
            case 4:
                result = Converter.poundsToKg(value);
                break;
            default:
                System.out.println("Invalid option.");
                input.close();
                return;
        }

        System.out.println("Result: " + result);
        input.close();
    }

}
