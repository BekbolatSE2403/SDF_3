package main;

// This is what our app expects - a simple temperature converter
public interface UnitConverter {
    double convert(double value);
    String getSourceUnit();
    String getTargetUnit();
}
