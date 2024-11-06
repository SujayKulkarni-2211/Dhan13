//src/Consumablepanel.java

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.*;
import javax.swing.text.*;

public class ConsumablePanel extends JPanel {
    private JTextField batchIDField, expiryDateField, supplierNameField, materialTypeField, tensileStrengthField;
    private JTextField elasticityField, absorbencyField, nonToxicityField, biocompatibilityField;
    private JTextField degradationResistanceField, packagingIntegrityField, labelAccuracyField;
    private JCheckBox sterilizationCheck, regulatoryCheck;
    private JTextPane resultArea;

    public ConsumablePanel() {
        setLayout(new BorderLayout(20, 20));


        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Dhan13 - Consumables");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel taglineLabel = new JLabel("Health is Wealth! No Compromise on Health!");
        taglineLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        taglineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        titlePanel.add(titleLabel);
        titlePanel.add(taglineLabel);
        add(titlePanel, BorderLayout.NORTH);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));


        batchIDField = new JTextField();
        expiryDateField = new JTextField();
        supplierNameField = new JTextField();
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


        inputPanel.add(new JLabel("Batch Number:"));
        inputPanel.add(batchIDField);
        inputPanel.add(new JLabel("Expiry Date (YYYY-MM-DD):"));
        inputPanel.add(expiryDateField);
        inputPanel.add(new JLabel("Supplier Name:"));
        inputPanel.add(supplierNameField);
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

       
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> handleSubmit());
        buttonPanel.add(submitButton);

        JButton uploadButton = new JButton("Upload CSV");
        uploadButton.addActionListener(e -> handleCSVUpload());
        buttonPanel.add(uploadButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);


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
            return date.isAfter(LocalDate.now()); 
        } catch (DateTimeParseException e) {
            return false; 
        }
    }
    private void handleSubmit() {
        try {
            String batchID = batchIDField.getText().trim();
            String expiryDate = expiryDateField.getText().trim();
            String supplierName = supplierNameField.getText().trim();
            String materialType = materialTypeField.getText().trim();
            
           
            double tensileStrength = parseDoubleSafely(tensileStrengthField.getText().trim());
            double elasticity = parseDoubleSafely(elasticityField.getText().trim());
            double absorbency = parseDoubleSafely(absorbencyField.getText().trim());
            double nonToxicity = parseDoubleSafely(nonToxicityField.getText().trim());
            double biocompatibility = parseDoubleSafely(biocompatibilityField.getText().trim());
            double degradationResistance = parseDoubleSafely(degradationResistanceField.getText().trim());
            
            String packagingIntegrity = packagingIntegrityField.getText().trim();
            String labelAccuracy = labelAccuracyField.getText().trim();
            
            boolean sterilizationValidated = sterilizationCheck.isSelected();
            boolean regulatoryCompliant = regulatoryCheck.isSelected();
    

            if (!isValidExpiryDate(expiryDate)) {
                appendToResultArea("Invalid expiry date. Please use YYYY-MM-DD format and ensure the date is in the future.", Color.RED);
                return; 
            }
    
            Consumable consumable = new Consumable(batchID, expiryDate, supplierName, materialType);
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
            consumable.displayInfo();
    
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
                resultArea.setText("");
                
                br.readLine(); 
    
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length >= 14) { 
                        String batchID = data[0].trim();
                        String expiryDate = data[1].trim();
                        String materialType = data[2].trim();
                        String supplierName = data[3].trim();
    

                        double tensileStrength = parseDoubleSafely(data[4].trim());
                        double elasticity = parseDoubleSafely(data[5].trim());
                        double absorbency = parseDoubleSafely(data[6].trim());
                        double nonToxicity = parseDoubleSafely(data[7].trim());
                        double biocompatibility = parseDoubleSafely(data[8].trim());
                        double degradationResistance = parseDoubleSafely(data[9].trim());
    
                        
                        String packagingIntegrity = data[10].trim();
                        String labelAccuracy = data[11].trim();
                        

                        boolean sterilization = parseBooleanSafely(data[12].trim());
                        boolean regulatory = parseBooleanSafely(data[13].trim());
    

                        Consumable consumable = new Consumable(batchID, expiryDate, supplierName, materialType);
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
                        consumable.displayInfo();
    
                        evaluateAndDisplay(consumable);
                    } else {
                        appendToResultArea("Skipping line due to missing data: " + line, Color.RED);
                    }
                }
            } catch (IOException e) {
                appendToResultArea("Error reading CSV: " + e.getMessage(), Color.RED);
            }
        }
    }
    
    // Helper function to parse numeric fields safely (only try to parse if the field is meant to be a number)
    private double parseDoubleSafely(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0; 
        }
    }
    
    // Helper function to parse boolean fields safely (only try to parse if the field is meant to be a boolean)
    private boolean parseBooleanSafely(String value) {
        return value != null && value.trim().equalsIgnoreCase("true");
    }
    
    


    private void evaluateAndDisplay(Consumable consumable) {
      
        boolean expiryValid = isValidExpiryDate(consumable.getExpiryDate());
        boolean tensileStrengthPass = consumable.getTensileStrength() >= 100; 
        boolean elasticityPass = consumable.getElasticity() >= 40; 
        boolean absorbencyPass = consumable.getAbsorbency() >= 10; 
        boolean nonToxicityPass = consumable.getNonToxicity() >= 90; 
        boolean biocompatibilityPass = consumable.getBiocompatibility() >= 90;
        boolean degradationResistancePass = consumable.getResistanceToDegradation() >= 70;
        boolean packagingPass = consumable.getPackagingIntegrity() != null && consumable.getPackagingIntegrity().equalsIgnoreCase("good");
        boolean labelAccuracyPass = consumable.getLabelAccuracy() != null && consumable.getLabelAccuracy().equalsIgnoreCase("good");
        boolean sterilizationPass = consumable.isSterilizationValidated();
        boolean regulatoryPass = consumable.isRegulatoryCompliant();
    

        String status;
        Color color;
    
        if (!expiryValid || !sterilizationPass || !regulatoryPass || !tensileStrengthPass || !elasticityPass ||
            !absorbencyPass || !nonToxicityPass || !biocompatibilityPass || !degradationResistancePass) {
            
            status = "Red (Reject it! Disapproved!)";
            color = Color.RED;
        } else if (!packagingPass || !labelAccuracyPass) {
           
            status = "Orange (Needs Attention)";
            color = Color.ORANGE;
        } else {
            
            status = "Green (Approved)";
            color = Color.GREEN;
        }
    
        
        appendToResultArea("Batch ID: " + consumable.getBatchID() + ", Status: " + status, color);
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
