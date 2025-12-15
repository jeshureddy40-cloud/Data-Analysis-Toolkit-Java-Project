import java.io.*;
import java.util.*;

public class CSVDataset {

    private Map<String, double[]> data = new HashMap<>();

    // Constructor – reads CSV file
    public CSVDataset(String fileName) throws DataException {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            // Read header row
            String headerLine = br.readLine();
            if (headerLine == null) {
                throw new DataException("CSV file is empty");
            }

            // Read and normalize headers
            String[] headers = headerLine.split(",");
            int colCount = headers.length;

            List<List<Double>> columns = new ArrayList<>();
            for (int i = 0; i < colCount; i++) {
                columns.add(new ArrayList<>());
                headers[i] = headers[i].trim().toUpperCase(); // 🔥 FIX
            }

            // Read data rows
            String line;
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue; // ignore empty lines

                String[] values = line.split(",");

                if (values.length != colCount) {
                    throw new DataException("Malformed CSV row: " + line);
                }

                for (int i = 0; i < colCount; i++) {
                    columns.get(i).add(
                            Double.parseDouble(values[i].trim()) // 🔥 FIX
                    );
                }
            }

            // Convert lists to arrays
            for (int i = 0; i < colCount; i++) {
                double[] arr = columns.get(i)
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .toArray();
                data.put(headers[i], arr);
            }

        } catch (FileNotFoundException e) {
            throw new DataException("CSV file not found: " + fileName);
        } catch (IOException e) {
            throw new DataException("Error reading CSV file");
        } catch (NumberFormatException e) {
            throw new DataException("Non-numeric value found in CSV");
        }
    }

    // Return column data
    public double[] getColumn(String columnName) throws DataException {

        columnName = columnName.trim().toUpperCase(); // 🔥 FIX

        if (!data.containsKey(columnName)) {
            throw new DataException(
                    "Column not found: " + columnName +
                            " | Available columns: " + data.keySet()
            );
        }

        return data.get(columnName);
    }
}
