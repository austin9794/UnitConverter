package unitconverter;

public class WeightConverter implements Converter {

    @Override
    public double convert(double kg) {
        return kg * 2.20462;
    }

    @Override
    public String getDescription() {
        return "Kilograms to Pounds";
    }
}

