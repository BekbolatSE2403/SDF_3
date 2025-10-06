package main;

// This adapter makes the old library work with our new system
public class TemperatureAdapter implements UnitConverter {
    private LegacyTemperature oldLibrary;
    private String sourceUnit;
    private String targetUnit;

    public TemperatureAdapter(String sourceUnit, String targetUnit) {
        this.oldLibrary = new LegacyTemperature();
        this.sourceUnit = sourceUnit;
        this.targetUnit = targetUnit;
    }

    @Override
    public double convert(double value) {
        // Adapter translates between the old and new interfaces
        String result = oldLibrary.calculateTemperature(value, sourceUnit, targetUnit);
        return Double.parseDouble(result);
    }

    @Override
    public String getSourceUnit() {
        return sourceUnit;
    }

    @Override
    public String getTargetUnit() {
        return targetUnit;
    }

    // Bonus: We can add helpful methods the old library didn't have
    public String getConversionDescription() {
        return "Converting from " + sourceUnit + " to " + targetUnit;
    }
}
