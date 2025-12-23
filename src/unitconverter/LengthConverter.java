package unitconverter;

public class LengthConverter {

    public static double metersToKilometers(double m) {
        return m / 1000;
    }

    public static double kilometersToMeters(double km) {
        return km * 1000;
    }

    public static double centimetersToMeters(double cm) {
        return cm / 100;
    }

    public static double metersToCentimeters(double m) {
        return m * 100;
    }
}
