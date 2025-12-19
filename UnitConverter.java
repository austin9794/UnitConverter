package unitconverter;

import java.util.Scanner;

public class UnitConverter {

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose conversion:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Kilograms to Pounds");

        int choice = scanner.nextInt();
        System.out.print("Enter value: ");
        double value = scanner.nextDouble();

        