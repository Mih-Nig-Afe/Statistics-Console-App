import java.util.*;

/**
 * Interface for statistical operations
 * Defines the contract for all statistical calculators
 */
interface StatOperation {
    double calculate();
}

/**
 * Main class that encapsulates the data list
 * Provides methods to manage the statistical data
 */
class StatisticsCalculator {
    private List<Double> dataList;
    
    public StatisticsCalculator() {
        this.dataList = new ArrayList<>();
    }
    
    public void addNumber(double number) {
        dataList.add(number);
    }
    
    public List<Double> getDataList() {
        return new ArrayList<>(dataList);
    }
    
    public int getSize() {
        return dataList.size();
    }
    
    public boolean isEmpty() {
        return dataList.isEmpty();
    }
    
    public void clearData() {
        dataList.clear();
    }
    
    public void displayData() {
        if (isEmpty()) {
            System.out.println("No data available.");
            return;
        }
        
        System.out.print("Data: ");
        for (int i = 0; i < dataList.size(); i++) {
            System.out.print(dataList.get(i));
            if (i < dataList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

/**
 * Calculator class for computing the mean (average)
 * Implements StatOperation interface
 */
class MeanCalculator implements StatOperation {
    private List<Double> data;
    
    public MeanCalculator(List<Double> data) {
        this.data = data;
    }
    
    @Override
    public double calculate() {
        if (data == null || data.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (double number : data) {
            sum += number;
        }
        
        return sum / data.size();
    }
}

/**
 * Calculator class for computing the median
 * Implements StatOperation interface
 */
class MedianCalculator implements StatOperation {
    private List<Double> data;
    
    public MedianCalculator(List<Double> data) {
        this.data = data;
    }
    
    @Override
    public double calculate() {
        if (data == null || data.isEmpty()) {
            return 0.0;
        }
        
        List<Double> sortedData = new ArrayList<>(data);
        Collections.sort(sortedData);
        
        int size = sortedData.size();
        
        if (size % 2 == 1) {
            return sortedData.get(size / 2);
        } else {
            int middleIndex1 = size / 2 - 1;
            int middleIndex2 = size / 2;
            return (sortedData.get(middleIndex1) + sortedData.get(middleIndex2)) / 2.0;
        }
    }
}

/**
 * Calculator class for computing the mode
 * Implements StatOperation interface
 */
class ModeCalculator implements StatOperation {
    private List<Double> data;
    
    public ModeCalculator(List<Double> data) {
        this.data = data;
    }
    
    @Override
    public double calculate() {
        if (data == null || data.isEmpty()) {
            return 0.0;
        }
        
        Map<Double, Integer> frequencyMap = new HashMap<>();
        for (double number : data) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }
        
        double mode = data.get(0);
        int maxFrequency = 0;
        
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mode = entry.getKey();
            }
        }
        
        return mode;
    }
}

/**
 * Main application class for the Statistics Console App
 * Demonstrates polymorphism through StatOperation interface
 */
public class StatisticsConsoleApp {
    private StatisticsCalculator calculator;
    private Scanner scanner;
    
    public StatisticsConsoleApp() {
        this.calculator = new StatisticsCalculator();
        this.scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        StatisticsConsoleApp app = new StatisticsConsoleApp();
        app.run();
    }
    
    public void run() {
        System.out.println("=== Statistics Console App ===");
        System.out.println("Calculate Mean, Median, and Mode of numbers");
        System.out.println();
        
        while (true) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    inputNumbers();
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    calculateStatistic();
                    break;
                case 4:
                    clearData();
                    break;
                case 5:
                    System.out.println("Thank you for using Statistics Console App!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
    
    private void displayMenu() {
        System.out.println("--- Menu ---");
        System.out.println("1. Input Numbers");
        System.out.println("2. Display Current Data");
        System.out.println("3. Calculate Statistics");
        System.out.println("4. Clear Data");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }
    
    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void inputNumbers() {
        System.out.println("Enter numbers (type 'done' when finished):");
        
        while (true) {
            System.out.print("Enter number: ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            
            try {
                double number = Double.parseDouble(input);
                calculator.addNumber(number);
                System.out.println("Added: " + number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
        
        System.out.println("Numbers added successfully!");
    }
    
    private void displayData() {
        System.out.println("--- Current Data ---");
        calculator.displayData();
        System.out.println("Total numbers: " + calculator.getSize());
    }
    
    private void calculateStatistic() {
        if (calculator.isEmpty()) {
            System.out.println("No data available. Please input numbers first.");
            return;
        }
        
        System.out.println("--- Statistics Menu ---");
        System.out.println("1. Calculate Mean");
        System.out.println("2. Calculate Median");
        System.out.println("3. Calculate Mode");
        System.out.println("4. Calculate All");
        System.out.print("Enter your choice (1-4): ");
        
        int choice = getChoice();
        
        switch (choice) {
            case 1:
                calculateAndDisplay(new MeanCalculator(calculator.getDataList()), "Mean");
                break;
            case 2:
                calculateAndDisplay(new MedianCalculator(calculator.getDataList()), "Median");
                break;
            case 3:
                calculateAndDisplay(new ModeCalculator(calculator.getDataList()), "Mode");
                break;
            case 4:
                calculateAll();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private void calculateAndDisplay(StatOperation operation, String name) {
        double result = operation.calculate();
        System.out.println(name + ": " + result);
    }
    
    private void calculateAll() {
        System.out.println("--- All Statistics ---");
        calculator.displayData();
        
        StatOperation meanCalc = new MeanCalculator(calculator.getDataList());
        StatOperation medianCalc = new MedianCalculator(calculator.getDataList());
        StatOperation modeCalc = new ModeCalculator(calculator.getDataList());
        
        System.out.println("Mean: " + meanCalc.calculate());
        System.out.println("Median: " + medianCalc.calculate());
        System.out.println("Mode: " + modeCalc.calculate());
    }
    
    private void clearData() {
        calculator.clearData();
        System.out.println("All data cleared.");
    }
}
