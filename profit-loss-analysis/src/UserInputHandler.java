import java.util.Scanner;

public class UserInputHandler {
    private static Scanner scanner = new Scanner(System.in);
    
    // Get number of profit entries from user
    public static int getProfitCount() {
        System.out.print("Enter number of profit entries: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        int count = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        return count;
    }
    
    // Get number of loss entries from user
    public static int getLossCount() {
        System.out.print("Enter number of loss entries: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        int count = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        return count;
    }
    
    // Get a single profit value
    public static double getProfitValue(int index) {
        System.out.print("Enter profit value #" + (index + 1) + ": ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter a numeric value: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer
        return value;
    }
    
    // Get a single loss value
    public static double getLossValue(int index) {
        System.out.print("Enter loss value #" + (index + 1) + ": ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter a numeric value: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer
        return value;
    }
    
    // Read all graph data from user
    public static GraphData readGraphData() {
        GraphData data = new GraphData();
        
        System.out.println("\n=== Profit/Loss Graph Data Input ===");
        
        // Read profit values
        int profitCount = getProfitCount();
        for (int i = 0; i < profitCount; i++) {
            try {
                double value = getProfitValue(i);
                data.addProfit(value);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                i--; // Retry this entry
            }
        }
        
        // Read loss values
        int lossCount = getLossCount();
        for (int i = 0; i < lossCount; i++) {
            try {
                double value = getLossValue(i);
                data.addLoss(value);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                i--; // Retry this entry
            }
        }
        
        return data;
    }
    
    // Close scanner
    public static void closeScanner() {
        scanner.close();
    }
}
