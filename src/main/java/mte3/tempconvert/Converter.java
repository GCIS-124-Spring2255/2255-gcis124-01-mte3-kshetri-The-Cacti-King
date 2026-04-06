// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 1
// Filename: Converter.java (inside tempconvert package)

package mte3.tempconvert;
import java.util.Scanner;

public class Converter {
    
    private static class CelsiusToFahrenheit implements TempConvert {
        @Override
        public double convert(double temp) {    return temp * 9.0 / 5.0 + 32;    }
        
    } // CelciusToFahrenheit closed

    public static void main(String[] args) {
        
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter temperature (for conversion): ");
            Double in = scanner.nextDouble();
            // (part 1) conversion from C to F
            System.out.println("C to F: " + new CelsiusToFahrenheit().convert(in));
            // (part 2) conversion from F to C
            TempConvert f2c = new TempConvert() {
                @Override
                public double convert(double temp) {
                    return (temp - 32) * 5 / 9;
                }
            };
            System.out.println("F to C: " + f2c.convert(in));
            // (part 3) conversion from F to K
            TempConvert f2k = (a) -> (a - 32) * 5 / 9 + 273.15;
            System.out.println("F to K: " + f2k.convert(in));
        }  // try { } block closed

    } // main () method closed

} // Converter { } class closed