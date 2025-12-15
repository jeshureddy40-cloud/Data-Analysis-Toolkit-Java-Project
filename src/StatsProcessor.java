import java.util.*;
import java.util.stream.*;

public class StatsProcessor {

    // Mean
    public static double mean(double[] data) {
        if (data == null || data.length == 0)
            throw new IllegalArgumentException("Empty data array");
        return Arrays.stream(data).average().orElse(0);
    }

    // Median
    public static double median(double[] data) {
        if (data == null || data.length == 0)
            throw new IllegalArgumentException("Empty data array");

        double[] copy = data.clone();
        Arrays.sort(copy);
        int n = copy.length;

        return (n % 2 == 0)
                ? (copy[n / 2] + copy[n / 2 - 1]) / 2.0
                : copy[n / 2];
    }

    // Mode (returns first most frequent value)
    public static double mode(double[] data) {
        if (data == null || data.length == 0)
            throw new IllegalArgumentException("Empty data array");

        Map<Double, Long> freq =
                Arrays.stream(data).boxed()
                        .collect(Collectors.groupingBy(
                                x -> x, Collectors.counting()));

        return freq.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    // Variance (population variance)
    public static double variance(double[] data) {
        if (data == null || data.length == 0)
            throw new IllegalArgumentException("Empty data array");

        double m = mean(data);
        return Arrays.stream(data)
                .map(x -> (x - m) * (x - m))
                .average().orElse(0);
    }

    // Covariance
    public static double covariance(double[] x, double[] y) {
        if (x == null || y == null || x.length == 0 || y.length == 0)
            throw new IllegalArgumentException("Empty data array");

        if (x.length != y.length)
            throw new IllegalArgumentException("Array lengths must be equal");

        double mx = mean(x);
        double my = mean(y);

        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += (x[i] - mx) * (y[i] - my);
        }
        return sum / x.length;
    }

    // Correlation
    public static double correlation(double[] x, double[] y) {
        double varX = variance(x);
        double varY = variance(y);

        if (varX == 0 || varY == 0)
            throw new IllegalArgumentException("Cannot compute correlation (zero variance)");

        return covariance(x, y) / Math.sqrt(varX * varY);
    }

    // Filter values greater than threshold
    public static double[] filter(double[] data, double threshold) {
        if (data == null)
            throw new IllegalArgumentException("Data array is null");

        return Arrays.stream(data)
                .filter(x -> x > threshold)
                .toArray();
    }
}
