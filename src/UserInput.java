import java.util.Scanner;

public class UserInput {

    private static Scanner sc = new Scanner(System.in);

    // Get CSV file path or name
    public static String getCSVFile() {
        System.out.print("Enter CSV file name or full path: ");
        return sc.nextLine().trim();
    }

    // Get operation type (normalized)
    public static String getOperation() {
        System.out.print(
                "Enter operation " +
                        "(mean / median / mode / variance / covariance / correlation / compare / filter): "
        );
        return sc.nextLine().trim().toLowerCase(); // 🔥 FIX
    }

    // Get column name (normalized)
    public static String getColumn() {
        System.out.print("Enter ONE column name (A / B / C / D): ");
        return sc.nextLine().trim().toUpperCase(); // 🔥 FIX
    }

    // Get threshold value for filter
    public static double getThreshold() {
        System.out.print("Enter threshold value: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input. Enter a numeric value: ");
            sc.next();
        }
        double value = sc.nextDouble();
        sc.nextLine(); // clear buffer
        return value;
    }
}
