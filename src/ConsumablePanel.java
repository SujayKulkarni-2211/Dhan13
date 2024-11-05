import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.*;
import javax.swing.text.*;

public class ConsumablePanel extends JPanel {
    private JTextField batchNumberField, expiryDateField, materialTypeField, tensileStrengthField;
    private JTextField elasticityField, absorbencyField, nonToxicityField, biocompatibilityField;
    private JTextField degradationResistanceField, packagingIntegrityField, labelAccuracyField;
    private JCheckBox sterilizationCheck, regulatoryCheck;
    private JTextPane resultArea;

    public ConsumablePanel() {
        setLayout(new BorderLayout(20, 20));

        // Create title panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Dhan13 - Consumables");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel taglineLabel = new JLabel("Ensuring Quality in Healthcare");
        taglineLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        taglineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        titlePanel.add(titleLabel);
        titlePanel.add(taglineLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Main panel for input fields
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        // Initialize fields
        batchNumberField = new JTextField();
        expiryDateField = new JTextField();
        materialTypeField = new JTextField();
        tensileStrengthField = new JTextField();
        elasticityField = new JTextField();
        absorbencyField = new JTextField();
        nonToxicityField = new JTextField();
        biocompatibilityField = new JTextField();
        degradationResistanceField = new JTextField();
        packagingIntegrityField = new JTextField();
        labelAccuracyField = new JTextField();
        
        sterilizationCheck = new JCheckBox("Sterilization Validated");
        regulatoryCheck = new JCheckBox("Regulatory Compliant");

        // Add fields to input panel
        inputPanel.add(new JLabel("Batch Number:"));
        inputPanel.add(batchNumberField);
        inputPanel.add(new JLabel("Expiry Date (YYYY-MM-DD):"));
        inputPanel.add(expiryDateField);
        inputPanel.add(new JLabel("Material Type:"));
        inputPanel.add(materialTypeField);
        inputPanel.add(new JLabel("Tensile Strength (N):"));
        inputPanel.add(tensileStrengthField);
        inputPanel.add(new JLabel("Elasticity (%):"));
        inputPanel.add(elasticityField);
        inputPanel.add(new JLabel("Absorbency (ml):"));
        inputPanel.add(absorbencyField);
        inputPanel.add(new JLabel("Non-Toxicity:"));
        inputPanel.add(nonToxicityField);
        inputPanel.add(new JLabel("Biocompatibility:"));
        inputPanel.add(biocompatibilityField);
        inputPanel.add(new JLabel("Resistance to Degradation:"));
        inputPanel.add(degradationResistanceField);
        inputPanel.add(new JLabel("Packaging Integrity:"));
        inputPanel.add(packagingIntegrityField);
        inputPanel.add(sterilizationCheck);
        inputPanel.add(regulatoryCheck);
        inputPanel.add(new JLabel("Label Accuracy:"));
        inputPanel.add(labelAccuracyField);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> handleSubmit());
        buttonPanel.add(submitButton);

        JButton uploadButton = new JButton("Upload CSV");
        uploadButton.addActionListener(e -> handleCSVUpload());
        buttonPanel.add(uploadButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);

        // Result area
        resultArea = new JTextPane();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Batch Status Summary"));
        add(scrollPane, BorderLayout.SOUTH);
    }

    private boolean isValidExpiryDate(String expiryDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(expiryDate, formatter);
            return date.isAfter(LocalDate.now()); // Check if the date is in the future
        } catch (DateTimeParseException e) {
            return false; // Return false for invalid format
        }
    }

    private void handleSubmit() {
        try {
            String batchNumber = batchNumberField.getText().trim();
            String expiryDate = expiryDateField.getText().trim();
            String materialType = materialTypeField.getText().trim();
            double tensileStrength = Double.parseDouble(tensileStrengthField.getText().trim());
            double elasticity = Double.parseDouble(elasticityField.getText().trim());
            double absorbency = Double.parseDouble(absorbencyField.getText().trim());
            double nonToxicity = Double.parseDouble(nonToxicityField.getText().trim());
            double biocompatibility = Double.parseDouble(biocompatibilityField.getText().trim());
            double degradationResistance = Double.parseDouble(degradationResistanceField.getText().trim());
            String packagingIntegrity = packagingIntegrityField.getText().trim();
            String labelAccuracy = labelAccuracyField.getText().trim();
            boolean sterilizationValidated = sterilizationCheck.isSelected();
            boolean regulatoryCompliant = regulatoryCheck.isSelected();

            // Validate expiry date first
            if (!isValidExpiryDate(expiryDate)) {
                appendToResultArea("Invalid expiry date. Please use YYYY-MM-DD format and ensure the date is in the future.", Color.RED);
                return; // Stop further processing if the date is invalid
            }

            // Here you would create your Consumable object and set properties
            Consumable consumable = new Consumable(batchNumber, expiryDate, materialType);
            consumable.setTensileStrength(tensileStrength);
            consumable.setElasticity(elasticity);
            consumable.setAbsorbency(absorbency);
            consumable.setNonToxicity(nonToxicity);
            consumable.setBiocompatibility(biocompatibility);
            consumable.setResistanceToDegradation(degradationResistance);
            consumable.setPackagingIntegrity(packagingIntegrity);
            consumable.setLabelAccuracy(labelAccuracy);
            consumable.setSterilizationValidated(sterilizationValidated);
            consumable.setRegulatoryCompliant(regulatoryCompliant);

            evaluateAndDisplay(consumable);

        } catch (NumberFormatException ex) {
            appendToResultArea("Please enter valid numerical values.", Color.RED);
        }
    }

    private void handleCSVUpload() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
    
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                resultArea.setText(""); // Clear previous results in result area
                
                // Skip the header line
                br.readLine(); // This line skips the header
                
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length >= 13) {
                        String batchNumber = data[0].trim();
                        String expiryDate = data[1].trim();
                        String materialType = data[2].trim();
                        double tensileStrength = Double.parseDouble(data[3].trim());
                        double elasticity = Double.parseDouble(data[4].trim());
                        double absorbency = Double.parseDouble(data[5].trim());
                        double nonToxicity = Double.parseDouble(data[6].trim());
                        double biocompatibility = Double.parseDouble(data[7].trim());
                        double degradationResistance = Double.parseDouble(data[8].trim());
                        String packagingIntegrity = data[9].trim();
                        String labelAccuracy = data[10].trim();
                        boolean sterilization = Boolean.parseBoolean(data[11].trim());
                        boolean regulatory = Boolean.parseBoolean(data[12].trim());

                        // Create the consumable object and validate
                        Consumable consumable = new Consumable(batchNumber, expiryDate, materialType);
                        consumable.setTensileStrength(tensileStrength);
                        consumable.setElasticity(elasticity);
                        consumable.setAbsorbency(absorbency);
                        consumable.setNonToxicity(nonToxicity);
                        consumable.setBiocompatibility(biocompatibility);
                        consumable.setResistanceToDegradation(degradationResistance);
                        consumable.setPackagingIntegrity(packagingIntegrity);
                        consumable.setLabelAccuracy(labelAccuracy);
                        consumable.setSterilizationValidated(sterilization);
                        consumable.setRegulatoryCompliant(regulatory);

                        evaluateAndDisplay(consumable);
                    } else {
                        appendToResultArea("Invalid entry in CSV. Must contain 13 fields.", Color.RED);
                    }
                }
            } catch (IOException | NumberFormatException e) {
                appendToResultArea("Error reading CSV: " + e.getMessage(), Color.RED);
            }
        }
    }

    private void evaluateAndDisplay(Consumable consumable) {
        // Evaluate each parameter
        boolean expiryValid = isValidExpiryDate(consumable.getExpiryDate());
        boolean tensileStrengthPass = consumable.getTensileStrength() >= 100; // Set your actual lower limit
        boolean elasticityPass = consumable.getElasticity() >= 40; // Set your actual lower limit
        boolean absorbencyPass = consumable.getAbsorbency() >= 10; // Set your actual lower limit
        boolean nonToxicityPass = consumable.getNonToxicity() >= 90; // Set a threshold if needed
        boolean biocompatibilityPass = consumable.getBiocompatibility() >= 90;
        boolean degradationResistancePass = consumable.getResistanceToDegradation() >= 70;
        boolean packagingPass = consumable.getPackagingIntegrity() != null && !consumable.getPackagingIntegrity().isEmpty();
        boolean labelAccuracyPass = consumable.getLabelAccuracy() != null && !consumable.getLabelAccuracy().isEmpty();
        boolean sterilizationPass = consumable.isSterilizationValidated();
        boolean regulatoryPass = consumable.isRegulatoryCompliant();
    
        // Determine status based on conditions
        String status;
        Color color;
    
        if (!expiryValid || !sterilizationPass || !regulatoryPass || !tensileStrengthPass || !elasticityPass ||
            !absorbencyPass || !nonToxicityPass || !biocompatibilityPass || !degradationResistancePass) {
            // Critical failure in one or more fields
            status = "Red (Failed)";
            color = Color.RED;
        } else if (!packagingPass || !labelAccuracyPass) {
            // Non-critical issues in packaging or labeling
            status = "Orange (Needs Attention)";
            color = Color.ORANGE;
        } else {
            // All parameters are within acceptable ranges
            status = "Green (Approved)";
            color = Color.GREEN;
        }
    
        // Display the evaluation results
        appendToResultArea("Batch ID: " + consumable.getBatchNumber() + ", Status: " + status, color);
    }
            
    private void appendToResultArea(String message, Color color) {
        StyledDocument doc = resultArea.getStyledDocument();
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setForeground(attrs, color);
        try {
            doc.insertString(doc.getLength(), message + "\n", attrs);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
