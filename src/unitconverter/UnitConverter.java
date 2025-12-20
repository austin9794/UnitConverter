package unitconverter;

import java.util.Scanner;

public class UnitConverter {

    public static void run(Scanner scanner) {
         boolean running = true;

         while (running) {
            System.out.println("\n=== Unit Converter ===");
            System.out.println("1. Temperature Conversion");
            System.out.println("2. Weight Conversion");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

             int choice = scanner.nextInt();

             switch (choice) {
                case 1:
                    convertTemperature(scanner);
                    break;
                case 2:
                    convertWeight(scanner);
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
             }
            }
        }

        private static void convertTemperature(Scanner scanner) {
        System.out.print("Enter Celsius: ");
        double c = scanner.nextDouble();
        double f = (c * 9 / 5) + 32;
        System.out.println("Fahrenheit: " + f);
        }

        