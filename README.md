# Statistics Console App

A Java console application that calculates statistical measures (Mean, Median, Mode) using Object-Oriented Programming concepts.

## 📋 Table of Contents
- [Features](#features)
- [OOP Concepts](#oop-concepts)
- [Installation](#installation)
- [Usage](#usage)
- [Program Structure](#program-structure)
- [Examples](#examples)
- [Contributing](#contributing)

## ✨ Features

- **Interactive Console Interface**: User-friendly menu-driven application
- **Statistical Calculations**: 
  - Mean (Arithmetic Average)
  - Median (Middle Value)
  - Mode (Most Frequent Value)
- **Data Management**: Add, display, and clear numbers
- **Input Validation**: Handles invalid inputs gracefully
- **Single File Solution**: Complete program in one Java file

## 🎯 OOP Concepts Implemented

### 1. **Interface**
- `StatOperation` interface defines the contract with `calculate()` method
- Ensures consistent behavior across all calculator classes

### 2. **Encapsulation**
- `StatisticsCalculator` class encapsulates the data list
- Private data members with controlled public access methods

### 3. **Implementation/Inheritance**
- `MeanCalculator`, `MedianCalculator`, `ModeCalculator` implement `StatOperation`
- Each class provides specific implementation of `calculate()` method

### 4. **Polymorphism**
- Same interface (`StatOperation`) with different behaviors
- Runtime method selection based on object type
- Demonstrated in `calculateAndDisplay()` method

## 🚀 Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal

### Steps
1. **Clone the repository**:
   ```bash
   git clone https://github.com/YOUR_USERNAME/statistics-console-app.git
   cd statistics-console-app
   ```

2. **Compile the program**:
   ```bash
   javac StatisticsConsoleApp.java
   ```

3. **Run the application**:
   ```bash
   java StatisticsConsoleApp
   ```

## 📖 Usage

### Main Menu Options
1. **Input Numbers** - Add numbers to your dataset
2. **Display Current Data** - View all entered numbers
3. **Calculate Statistics** - Choose specific calculation or all
4. **Clear Data** - Remove all numbers from dataset
5. **Exit** - Close the application

### Statistics Menu Options
1. **Calculate Mean** - Arithmetic average
2. **Calculate Median** - Middle value when sorted
3. **Calculate Mode** - Most frequently occurring value
4. **Calculate All** - Display all three statistics

## 🏗️ Program Structure

```
StatisticsConsoleApp.java
├── StatOperation (Interface)
│   └── calculate() method
├── StatisticsCalculator (Data Management)
│   ├── addNumber()
│   ├── getDataList()
│   ├── displayData()
│   └── clearData()
├── MeanCalculator (implements StatOperation)
├── MedianCalculator (implements StatOperation)
├── ModeCalculator (implements StatOperation)
└── StatisticsConsoleApp (Main Class)
    └── Interactive console interface
```

## 💡 Examples

### Sample Run
```
=== Statistics Console App ===
Calculate Mean, Median, and Mode of numbers

--- Menu ---
1. Input Numbers
2. Display Current Data
3. Calculate Statistics
4. Clear Data
5. Exit
Enter your choice (1-5): 1

Enter numbers (type 'done' when finished):
Enter number: 10
Added: 10.0
Enter number: 20
Added: 20.0
Enter number: 30
Added: 30.0
Enter number: 20
Added: 20.0
Enter number: done
Numbers added successfully!

--- Menu ---
1. Input Numbers
2. Display Current Data
3. Calculate Statistics
4. Clear Data
5. Exit
Enter your choice (1-5): 3

--- Statistics Menu ---
1. Calculate Mean
2. Calculate Median
3. Calculate Mode
4. Calculate All
Enter your choice (1-4): 4

--- All Statistics ---
Data: 10.0, 20.0, 30.0, 20.0
Mean: 20.0
Median: 20.0
Mode: 20.0
```

### Statistical Formulas Used

- **Mean**: `Sum of all numbers ÷ Count of numbers`
- **Median**: 
  - Odd count: Middle value in sorted list
  - Even count: Average of two middle values
- **Mode**: Number that appears most frequently

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

Created as an educational project demonstrating basic Object-Oriented Programming concepts in Java.

---

**Note**: This application uses basic Java concepts and avoids advanced features, making it perfect for learning OOP fundamentals.
