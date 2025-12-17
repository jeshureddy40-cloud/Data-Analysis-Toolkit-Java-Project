# Profit/Loss Graph Analysis System

A Java application that reads profit and loss graph data from users and calculates average profit and loss values.

## Project Structure

```
profit-loss-analysis/
└── src/
    ├── GraphData.java              # Stores profit/loss values
    ├── ProfitLossCalculator.java   # Calculates averages and totals
    ├── UserInputHandler.java       # Handles user input
    └── ProfitLossAnalysisMain.java # Main program entry point
```

## Features

- **User Input**: Accept multiple profit and loss values from the user
- **Data Validation**: Ensures only positive numbers are entered
- **Average Calculation**: Calculates average profit and average loss
- **Total Calculation**: Computes total profit and total loss
- **Net Result**: Shows net profit or loss (profit - loss)
- **Clean Output**: Formatted results with clear summaries

## Classes

### 1. GraphData.java
Stores profit and loss values separately:
- `addProfit(double value)` - Add a profit entry
- `addLoss(double value)` - Add a loss entry
- `getProfitValues()` - Get all profit values
- `getLossValues()` - Get all loss values

### 2. ProfitLossCalculator.java
Performs calculations:
- `calculateAverageProfit(GraphData data)` - Average of all profits
- `calculateAverageLoss(GraphData data)` - Average of all losses
- `calculateTotalProfit(GraphData data)` - Sum of all profits
- `calculateTotalLoss(GraphData data)` - Sum of all losses
- `calculateNetProfitLoss(GraphData data)` - Net result (profit - loss)

### 3. UserInputHandler.java
Handles all user interactions:
- `readGraphData()` - Main method to collect all data
- `getProfitCount()` - Ask how many profit entries
- `getLossCount()` - Ask how many loss entries
- `getProfitValue(int index)` - Get individual profit value
- `getLossValue(int index)` - Get individual loss value

### 4. ProfitLossAnalysisMain.java
Main program that:
1. Collects data from user
2. Performs calculations
3. Displays formatted results

## How to Run

### Compilation
```bash
cd profit-loss-analysis/src
javac *.java
```

### Execution
```bash
java ProfitLossAnalysisMain
```

## Example Usage

```
========================================
   Profit/Loss Graph Analysis System
========================================

=== Profit/Loss Graph Data Input ===
Enter number of profit entries: 3
Enter profit value #1: 1500
Enter profit value #2: 2000
Enter profit value #3: 1800
Enter number of loss entries: 2
Enter loss value #1: 800
Enter loss value #2: 600

========================================
           ANALYSIS RESULTS
========================================

Profit Summary:
  Number of profit entries: 3
  Total Profit: $5300.00
  Average Profit: $1766.67

Loss Summary:
  Number of loss entries: 2
  Total Loss: $1400.00
  Average Loss: $700.00

Net Result:
  Net Profit: $3900.00

========================================
```

## Key Features Similar to Original Project

This project follows the same design patterns as the original Data Analysis Toolkit:
- Modular class structure
- Separation of concerns (data, calculations, I/O)
- Input validation
- Exception handling
- Clean, formatted output
- Similar naming conventions

## Differences from Original

1. **Focus**: Analyzes profit/loss graphs instead of CSV datasets
2. **Input Method**: Direct user input instead of file reading
3. **Calculations**: Average profit/loss instead of statistical operations
4. **Data Structure**: Lists instead of arrays/HashMaps

## Author

Created as a companion project to the Data Analysis Toolkit.
