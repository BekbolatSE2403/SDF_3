package main;

// Our main app - it only knows about the simple UnitConverter interface
public class TemperatureApp {

    public static void main(String[] args) {
        System.out.println("🌡️ Simple Temperature Converter with Adapter Pattern\n");

        // Create adapters for different conversions
        UnitConverter celsiusToFahrenheit = new TemperatureAdapter("C", "F");
        UnitConverter fahrenheitToCelsius = new TemperatureAdapter("F", "C");

        // Test some conversions
        System.out.println("=== Celsius to Fahrenheit ===");
        testConversion(celsiusToFahrenheit, 0);    // Water freezing
        testConversion(celsiusToFahrenheit, 100);  // Water boiling
        testConversion(celsiusToFahrenheit, 25);   // Room temperature

        System.out.println("=== Fahrenheit to Celsius ===");
        testConversion(fahrenheitToCelsius, 32);   // Water freezing
        testConversion(fahrenheitToCelsius, 212);  // Water boiling
        testConversion(fahrenheitToCelsius, 77);   // Room temperature

        // Show the adapter in action
        TemperatureAdapter adapter = (TemperatureAdapter) celsiusToFahrenheit;
        System.out.println("\n🔧 Adapter Details: " + adapter.getConversionDescription());
    }

    // This method works with ANY UnitConverter - it doesn't know about the adapter
    public static void testConversion(UnitConverter converter, double value) {
        double result = converter.convert(value);
        System.out.printf("%.1f°%s = %.1f°%s\n",
                value, converter.getSourceUnit(),
                result, converter.getTargetUnit());
    }
}
