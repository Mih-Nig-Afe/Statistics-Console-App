# Technical Documentation

## Architecture Overview

The Statistics Console App follows a clean Object-Oriented design pattern with clear separation of concerns.

## Class Diagram

```
┌─────────────────┐
│  StatOperation  │ (Interface)
│                 │
│ + calculate()   │
└─────────────────┘
         △
         │ implements
    ┌────┴────┬────────────┬─────────────┐
    │         │            │             │
┌───▽───┐ ┌──▽──┐ ┌───────▽────┐ ┌──────▽──────┐
│ Mean  │ │Mode │ │   Median   │ │Statistics   │
│Calc   │ │Calc │ │    Calc    │ │Calculator   │
└───────┘ └─────┘ └────────────┘ └─────────────┘
                                        △
                                        │ uses
                              ┌─────────▽─────────┐
                              │StatisticsConsole  │
                              │       App         │
                              └───────────────────┘
```

## Detailed Class Documentation

### StatOperation Interface
```java
public interface StatOperation {
    double calculate();
}
```
**Purpose**: Defines the contract for all statistical operations
**Methods**: 
- `calculate()`: Returns the calculated statistical value

### StatisticsCalculator Class
**Purpose**: Manages the dataset and provides data operations
**Key Methods**:
- `addNumber(double)`: Adds a number to the dataset
- `getDataList()`: Returns a copy of the data list
- `displayData()`: Prints all numbers in the dataset
- `clearData()`: Removes all data from the dataset
- `isEmpty()`: Checks if dataset is empty
- `getSize()`: Returns the number of elements

### MeanCalculator Class
**Purpose**: Calculates the arithmetic mean (average)
**Algorithm**: 
```
Mean = (Sum of all numbers) / (Count of numbers)
```
**Implementation**: Uses enhanced for-loop for summation

### MedianCalculator Class
**Purpose**: Calculates the median (middle value)
**Algorithm**:
- Sort the dataset
- If odd count: return middle element
- If even count: return average of two middle elements
**Implementation**: Uses `Collections.sort()` for sorting

### ModeCalculator Class
**Purpose**: Calculates the mode (most frequent value)
**Algorithm**:
- Count frequency of each number using HashMap
- Find the number with maximum frequency
**Implementation**: Uses `HashMap<Double, Integer>` for frequency counting

### StatisticsConsoleApp Class
**Purpose**: Main application class with user interface
**Key Features**:
- Menu-driven console interface
- Input validation and error handling
- Polymorphic method calls
- User-friendly prompts and messages

## Design Patterns Used

### 1. Strategy Pattern
- `StatOperation` interface defines the strategy
- Different calculator classes implement different strategies
- Context (`StatisticsConsoleApp`) uses strategies polymorphically

### 2. Encapsulation Pattern
- `StatisticsCalculator` encapsulates data management
- Private data members with public accessor methods
- Data integrity maintained through controlled access

## Error Handling

### Input Validation
- **Invalid Menu Choice**: Returns -1, displays error message
- **Invalid Number Format**: Catches `NumberFormatException`, prompts retry
- **Empty Dataset**: Checks before calculations, displays appropriate message

### Defensive Programming
- Null checks in calculator classes
- Copy constructors to prevent external modification
- Graceful handling of edge cases (empty lists, single elements)

## Performance Considerations

### Time Complexity
- **Mean Calculation**: O(n) - single pass through data
- **Median Calculation**: O(n log n) - due to sorting
- **Mode Calculation**: O(n) - single pass with HashMap

### Space Complexity
- **Data Storage**: O(n) - stores all input numbers
- **Median Calculation**: O(n) - creates sorted copy
- **Mode Calculation**: O(n) - HashMap for frequency counting

## Testing Strategy

### Manual Testing Scenarios
1. **Empty Dataset**: Test calculations with no data
2. **Single Element**: Test with one number
3. **Even/Odd Count**: Test median calculation
4. **Duplicate Values**: Test mode calculation
5. **Invalid Input**: Test error handling
6. **Large Numbers**: Test with various number ranges

### Test Cases
```java
// Test Data: [1, 2, 3, 4, 5, 3, 3]
// Expected Results:
// Mean: 3.0
// Median: 3.0
// Mode: 3.0
```

## Future Enhancements

### Possible Improvements
1. **File I/O**: Load/save datasets from files
2. **Additional Statistics**: Standard deviation, variance, range
3. **Data Visualization**: Simple ASCII charts
4. **Multiple Modes**: Handle datasets with multiple modes
5. **Decimal Precision**: Configurable decimal places
6. **Data Validation**: Range checking, outlier detection

### Code Quality Improvements
1. **Unit Tests**: JUnit test cases
2. **Logging**: Add logging framework
3. **Configuration**: External configuration file
4. **Internationalization**: Multi-language support

## Compilation and Deployment

### Build Process
```bash
# Compile
javac StatisticsConsoleApp.java

# Run
java StatisticsConsoleApp

# Clean (remove class files)
rm *.class
```

### System Requirements
- **Java Version**: JDK 8 or higher
- **Memory**: Minimal (< 10MB)
- **Platform**: Cross-platform (Windows, macOS, Linux)

## Code Style Guidelines

### Naming Conventions
- **Classes**: PascalCase (e.g., `StatisticsCalculator`)
- **Methods**: camelCase (e.g., `calculateMean`)
- **Variables**: camelCase (e.g., `dataList`)
- **Constants**: UPPER_SNAKE_CASE

### Documentation Standards
- **Class Comments**: Purpose and responsibility
- **Method Comments**: Parameters, return values, behavior
- **Inline Comments**: Complex logic explanation

This documentation provides a comprehensive technical overview of the Statistics Console App architecture and implementation details.
