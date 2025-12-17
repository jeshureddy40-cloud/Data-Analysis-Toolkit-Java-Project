import java.util.List;

public class ProfitLossCalculator {
    
    // Calculate average profit
    public static double calculateAverageProfit(GraphData data) {
        List<Double> profits = data.getProfitValues();
        
        if (profits.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (double value : profits) {
            sum += value;
        }
        
        return sum / profits.size();
    }
    
    // Calculate average loss
    public static double calculateAverageLoss(GraphData data) {
        List<Double> losses = data.getLossValues();
        
        if (losses.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (double value : losses) {
            sum += value;
        }
        
        return sum / losses.size();
    }
    
    // Calculate total profit
    public static double calculateTotalProfit(GraphData data) {
        List<Double> profits = data.getProfitValues();
        double sum = 0.0;
        
        for (double value : profits) {
            sum += value;
        }
        
        return sum;
    }
    
    // Calculate total loss
    public static double calculateTotalLoss(GraphData data) {
        List<Double> losses = data.getLossValues();
        double sum = 0.0;
        
        for (double value : losses) {
            sum += value;
        }
        
        return sum;
    }
    
    // Calculate net profit/loss (profit - loss)
    public static double calculateNetProfitLoss(GraphData data) {
        return calculateTotalProfit(data) - calculateTotalLoss(data);
    }
}
