import java.io.File;

public class Main {

    public static void main(String[] args) {

        try {
            // 1. Get user inputs
            String csvFile = UserInput.getCSVFile();
            String operation = UserInput.getOperation().toLowerCase();

            // 🔥 FIX 1: Handle CSV path automatically
            File f = new File(csvFile);
            if (!f.exists()) {
                csvFile = "src/" + csvFile;   // try inside src folder
            }

            // 2. Load dataset
            CSVDataset dataset = new CSVDataset(csvFile);

            String result = "";

            // 3. Operations requiring two columns
            if (operation.equals("covariance") ||
                    operation.equals("correlation") ||
                    operation.equals("compare")) {

                String col1 = UserInput.getColumn();
                String col2 = UserInput.getColumn();

                double[] data1 = dataset.getColumn(col1);
                double[] data2 = dataset.getColumn(col2);

                if (operation.equals("covariance")) {
                    result = "Covariance = " +
                            StatsProcessor.covariance(data1, data2);

                } else if (operation.equals("correlation")) {
                    result = "Correlation = " +
                            StatsProcessor.correlation(data1, data2);

                } else {
                    result = "Mean Comparison = " +
                            StatsProcessor.mean(data1) +
                            " vs " +
                            StatsProcessor.mean(data2);
                }

            }
            // 4. Operations requiring single column
            else {

                String column = UserInput.getColumn();
                double[] data = dataset.getColumn(column);

                switch (operation) {

                    case "mean":
                        result = "Mean = " + StatsProcessor.mean(data);
                        break;

                    case "median":
                        result = "Median = " + StatsProcessor.median(data);
                        break;

                    case "mode":
                        result = "Mode = " + StatsProcessor.mode(data);
                        break;

                    case "variance":
                        result = "Variance = " + StatsProcessor.variance(data);
                        break;

                    case "filter":
                        double threshold = UserInput.getThreshold();
                        result = "Filtered Values = " +
                                java.util.Arrays.toString(
                                        StatsProcessor.filter(data, threshold));
                        break;

                    default:
                        result = "Invalid Operation";
                }
            }

            // 5. Write output to file
            FileOutput.write(result);

            // 🔥 FIX 2: ALSO SHOW OUTPUT IN CONSOLE
            System.out.println("RESULT:");
            System.out.println(result);

        } catch (DataException e) {
            System.out.println("Data Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}
