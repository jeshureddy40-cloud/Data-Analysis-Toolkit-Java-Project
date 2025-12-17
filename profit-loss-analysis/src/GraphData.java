import java.util.ArrayList;
import java.util.List;

public class GraphData {
    private List<Double> profitValues;
    private List<Double> lossValues;
    
    // Constructor
    public GraphData() {
        this.profitValues = new ArrayList<>();
        this.lossValues = new ArrayList<>();
    }
    
    // Add profit value
    public void addProfit(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Profit value cannot be negative");
        }
        profitValues.add(value);
    }
    
    // Add loss value (stored as positive number for easier calculation)
    public void addLoss(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Loss value should be entered as positive number");
        }
        lossValues.add(value);
    }
    
    // Get all profit values
    public List<Double> getProfitValues() {
        return new ArrayList<>(profitValues);
    }
    
    // Get all loss values
    public List<Double> getLossValues() {
        return new ArrayList<>(lossValues);
    }
    
    // Get profit count
    public int getProfitCount() {
        return profitValues.size();
    }
    
    // Get loss count
    public int getLossCount() {
        return lossValues.size();
    }
    
    // Check if data is empty
    public boolean isEmpty() {
        return profitValues.isEmpty() && lossValues.isEmpty();
    }
}
