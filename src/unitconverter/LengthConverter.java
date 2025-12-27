package unitconverter;

public class LengthConverter {

    // meters ↔ feet
    public static double metersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double feetToMeters(double feet) {
        return feet / 3.28084;
    }
}

