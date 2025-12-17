public class ProfitLossAnalysisMain {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   Profit/Loss Graph Analysis System");
        System.out.println("========================================");
        
        try {
            // Read graph data from user
            GraphData graphData = UserInputHandler.readGraphData();
            
            // Check if data is empty
            if (graphData.isEmpty()) {
                System.out.println("\nNo data entered. Exiting...");
                return;
            }
            
            // Calculate results
            double avgProfit = ProfitLossCalculator.calculateAverageProfit(graphData);
            double avgLoss = ProfitLossCalculator.calculateAverageLoss(graphData);
            double totalProfit = ProfitLossCalculator.calculateTotalProfit(graphData);
            double totalLoss = ProfitLossCalculator.calculateTotalLoss(graphData);
            double netProfitLoss = ProfitLossCalculator.calculateNetProfitLoss(graphData);
            
            // Display results
            System.out.println("\n========================================");
            System.out.println("           ANALYSIS RESULTS");
            System.out.println("========================================");
            
            System.out.println("\nProfit Summary:");
            System.out.println("  Number of profit entries: " + graphData.getProfitCount());
            System.out.println("  Total Profit: $" + String.format("%.2f", totalProfit));
            System.out.println("  Average Profit: $" + String.format("%.2f", avgProfit));
            
            System.out.println("\nLoss Summary:");
            System.out.println("  Number of loss entries: " + graphData.getLossCount());
            System.out.println("  Total Loss: $" + String.format("%.2f", totalLoss));
            System.out.println("  Average Loss: $" + String.format("%.2f", avgLoss));
            
            System.out.println("\nNet Result:");
            if (netProfitLoss >= 0) {
                System.out.println("  Net Profit: $" + String.format("%.2f", netProfitLoss));
            } else {
                System.out.println("  Net Loss: $" + String.format("%.2f", Math.abs(netProfitLoss)));
            }
            
            System.out.println("\n========================================");
            
        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close scanner
            UserInputHandler.closeScanner();
        }
    }
}
