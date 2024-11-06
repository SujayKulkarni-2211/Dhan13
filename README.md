# Dhan13

## Project Overview
**Dhan13** (Digital Health Assurance Network 13) is a quality assurance system designed to test and monitor the quality of medicines and consumables received in hospitals. Inspired by **Dhanvanthri**, the Hindu god of health and medicine, Dhan13 embodies the commitment to ensuring comprehensive health safety. The '13' signifies the thirteen critical parameters evaluated for each item, promoting an efficient, reliable, and structured approach to quality assurance in healthcare.

### Problem Statement
Healthcare facilities often face challenges related to manual quality checks of medical supplies, which can be prone to errors and inconsistencies. Dhan13 assists in addressing this issue by supporting quality control processes and ensuring that only safe and compliant products are used, thereby minimizing risks to patients.

### Key Features
1. **Data Entry Module**:
   - **Manual Entry**: Staff can input batch details through a form interface.
   - **CSV Upload**: Bulk data entry is supported through CSV file uploads.
   - **Validation**: Inputs are validated for completeness, with errors highlighted.

2. **Quality Testing Module**:
   - **Custom Checks**: Each item undergoes checks across multiple critical parameters specific to its type (medicine or consumable).
   - **Result Logging**: Results are displayed in the UI and logged to the console.

3. **Compliance Verification Module**:
   - **Regulatory Compliance**: Supports checks for adherence to defined standards.
   - **Basic Validation**: Highlights items that do not meet quality requirements for review.

4. **Notification System**:
   - **Alerts**: Generates alerts for any batch that fails quality checks.

5. **Monitoring Dashboard**:
   - **Batch Overview**: Displays the status of each batch.
   - **Search and Filter Options**: Allows filtering and searching for specific batches.

## Implementation and OOP Principles
Dhan13 is designed with a strong adherence to the four pillars of Object-Oriented Programming (OOP):

### 1. Encapsulation
- Private fields ensure data integrity for parameters such as `batchID`, `expiryDate`, `potency`, and `materialType`.
- Getter and setter methods provide controlled access.

### 2. Polymorphism
- Overridden methods, including `displayInfo()`, facilitate customized output for medicines and consumables.

### 3. Abstraction
- Interfaces define abstract methods for quality assessment, ensuring flexibility for future extensions.

### 4. Inheritance
- The `SupplyItem` class serves as a base for `Medicine` and `Consumable`, promoting code reuse and maintaining an organized hierarchy.

## Code Structure
### Main Components
- **`SupplyItem` Class**: A base class containing shared properties like `batchID`, `expiryDate`, and `supplierName`.
- **`Medicine` Class**: Extends `SupplyItem` and adds specific parameters and checks for medicines.
- **`Consumable` Class**: Extends `SupplyItem` and includes fields like `materialType`, `tensileStrength`, `elasticity`, etc.
- **`ConsumablePanel` and `MedicinePanel`**: UI panels for data entry and interaction.
- **`Dhan13UI`**: The main user interface integrating different modules and displaying the results.

### Key Methods
- **`displayInfo()` in `Consumable` and `Medicine`**: Prints the details of the items to the console for validation.
- **`evaluateAndDisplay()` in `ConsumablePanel`**: Evaluates quality checks and updates the UI with results.

## How to Run the Project
1. **Compile the Code**:
   ```bash
   javac *.java
   ```
2. **Run the Main Class**:
   ```bash
   java Dhan13UI
   ```

## Usage
1. **Manual Entry**: Input batch details directly into the form and submit.
2. **CSV Upload**: Upload a CSV file with batch data for processing.
3. **Review Results**: View the status of each batch in the console and UI.

## Future Enhancements
- Integration with external databases for better data management.
- Enhanced analytics with advanced reporting options.

## Contact
For more information or to contribute to this project, please refer to the GitHub repository or contact the project team.

---
**Copyright Notice**

© 2024 Sujay V Kulkarni and Mitesh K. All rights reserved.

Dhan13 provides a structured approach to healthcare quality control, assisting in the verification of medical supplies to enhance safety and efficiency in hospital management.

