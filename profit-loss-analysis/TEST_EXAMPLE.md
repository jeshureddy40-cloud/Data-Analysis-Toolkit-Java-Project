# Test Example - Profit/Loss Calculator

## Sample Graph Input Data

This document shows how to test the Profit/Loss Calculator with sample graph data.

## Test Scenario: Monthly Business Analysis

### Graph Data Points:

**Profit Values (in dollars):**
- Month 1: $1500
- Month 2: $2000
- Month 3: $1800
- Month 4: $2200
- Month 5: $1900

**Loss Values (in dollars):**
- Month 1: $800
- Month 2: $600
- Month 3: $750

---

## How to Run the Test

### Step 1: Compile the Program
```bash
cd profit-loss-analysis/src
javac *.java
```

### Step 2: Run the Program
```bash
java ProfitLossAnalysisMain
```

### Step 3: Enter the Test Data

When prompted, enter the following:

```
Enter number of profit entries: 5
Enter profit value #1: 1500
Enter profit value #2: 2000
Enter profit value #3: 1800
Enter profit value #4: 2200
Enter profit value #5: 1900

Enter number of loss entries: 3
Enter loss value #1: 800
Enter loss value #2: 600
Enter loss value #3: 750
```

---

## Expected Output

```
========================================
   Profit/Loss Graph Analysis System
========================================

=== Profit/Loss Graph Data Input ===
Enter number of profit entries: 5
Enter profit value #1: 1500
Enter profit value #2: 2000
Enter profit value #3: 1800
Enter profit value #4: 2200
Enter profit value #5: 1900
Enter number of loss entries: 3
Enter loss value #1: 800
Enter loss value #2: 600
Enter loss value #3: 750

========================================
           ANALYSIS RESULTS
========================================

Profit Summary:
  Number of profit entries: 5
  Total Profit: $9400.00
  Average Profit: $1880.00

Loss Summary:
  Number of loss entries: 3
  Total Loss: $2150.00
  Average Loss: $716.67

Net Result:
  Net Profit: $7250.00

========================================
```

---

## Manual Calculation Verification

### Profit Calculations:
- **Sum**: 1500 + 2000 + 1800 + 2200 + 1900 = **$9400**
- **Average**: 9400 ÷ 5 = **$1880.00**

### Loss Calculations:
- **Sum**: 800 + 600 + 750 = **$2150**
- **Average**: 2150 ÷ 3 = **$716.67**

### Net Calculation:
- **Net Profit/Loss**: 9400 - 2150 = **$7250.00** (Profit)

✅ **All calculations are correct!**

---

## Additional Test Cases

### Test Case 2: Small Business Scenario

**Input:**
- Profits: 500, 750, 600
- Losses: 400, 300

**Expected Results:**
- Total Profit: $1850.00
- Average Profit: $616.67
- Total Loss: $700.00
- Average Loss: $350.00
- Net Profit: $1150.00

### Test Case 3: Loss-Heavy Scenario

**Input:**
- Profits: 1000, 1200
- Losses: 1500, 1800, 1000

**Expected Results:**
- Total Profit: $2200.00
- Average Profit: $1100.00
- Total Loss: $4300.00
- Average Loss: $1433.33
- Net Loss: $2100.00

### Test Case 4: Edge Case - No Losses

**Input:**
- Profits: 2000, 2500, 3000
- Losses: (none, enter 0)

**Expected Results:**
- Total Profit: $7500.00
- Average Profit: $2500.00
- Total Loss: $0.00
- Average Loss: $0.00
- Net Profit: $7500.00

---

## Graph Visualization (Conceptual)

```
Month 1: Profit=$1500 | Loss=$800  → Net: +$700
Month 2: Profit=$2000 | Loss=$600  → Net: +$1400
Month 3: Profit=$1800 | Loss=$750  → Net: +$1050
Month 4: Profit=$2200 | Loss=$0    → Net: +$2200
Month 5: Profit=$1900 | Loss=$0    → Net: +$1900

Overall Net: +$7250 (Profit)
```

---

## Testing Validation Features

### Test Negative Input Handling:

Try entering a negative profit:
```
Enter profit value #1: -500
```

**Expected Behavior:**
```
Error: Profit value cannot be negative
(Program should retry and ask for the value again)
```

### Test Non-Numeric Input:

Try entering text:
```
Enter profit value #1: abc
```

**Expected Behavior:**
```
Invalid input. Enter a numeric value: 
(Program should retry and ask for valid input)
```

---

## Conclusion

The Profit/Loss Calculator successfully:
- ✅ Accepts multiple profit and loss values
- ✅ Calculates correct averages
- ✅ Computes accurate totals
- ✅ Determines net profit or loss
- ✅ Validates input data
- ✅ Formats output clearly

The program is working correctly with the test data!
