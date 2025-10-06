package main;

// Imagine this is from an old library - it has the functionality but weird interface
public class LegacyTemperature {

    // Old method with weird parameter names and return type
    public String calculateTemperature(double inputTemp, String inputType, String outputType) {
        if (inputType.equals("C") && outputType.equals("F")) {
            return String.valueOf((inputTemp * 9/5) + 32);
        } else if (inputType.equals("F") && outputType.equals("C")) {
            return String.valueOf((inputTemp - 32) * 5/9);
        }
        return "0.0"; // Default return
    }

    // Another weird method we don't really need
    public boolean checkIfSupported(String type) {
        return type.equals("C") || type.equals("F");
    }
}