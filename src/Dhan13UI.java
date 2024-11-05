import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

public class Dhan13UI extends JFrame {
    private JTextField batchIDField, expiryDateField, supplierNameField, potencyField, purityField, dissolutionRateField;
    private JTextField disintegrationTimeField, pHField, storageConditionField;
    private JCheckBox microbialCheck, packagingCheck, regulatoryCheck, labelAccuracyCheck;
    private JTextPane resultArea; // Changed to JTextPane

    public Dhan13UI() {
        setTitle("Dhan13 Health Evaluation");
        setLayout(new BorderLayout(20, 20));

        // Create a title panel for the title and tagline
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Dhan13");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32)); // Title font
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel taglineLabel = new JLabel("Health is Wealth");
        taglineLabel.setFont(new Font("Arial", Font.ITALIC, 20)); // Tagline font
        taglineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        titlePanel.add(titleLabel);
        titlePanel.add(taglineLabel);

        // Add title panel to the top of the frame
        add(titlePanel, BorderLayout.NORTH);

        // Main panel for input fields and buttons
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5)); // Panel for input fields

        // Initialize fields for parameters
        batchIDField = new JTextField();
        expiryDateField = new JTextField();
        supplierNameField = new JTextField();
        potencyField = new JTextField();
        purityField = new JTextField();
        dissolutionRateField = new JTextField();
        disintegrationTimeField = new JTextField();
        pHField = new JTextField();
        storageConditionField = new JTextField();

        microbialCheck = new JCheckBox("Microbial Contamination");
        packagingCheck = new JCheckBox("Packaging Integrity");
        regulatoryCheck = new JCheckBox("Regulatory Compliance");
        labelAccuracyCheck = new JCheckBox("Label Accuracy");

        // Add fields and labels to input panel
        inputPanel.add(new JLabel("Batch ID:"));
        inputPanel.add(batchIDField);
        inputPanel.add(new JLabel("Expiry Date (YYYY-MM-DD):"));
        inputPanel.add(expiryDateField);
        inputPanel.add(new JLabel("Supplier Name:"));
        inputPanel.add(supplierNameField);
        inputPanel.add(new JLabel("Potency (%):"));
        inputPanel.add(potencyField);
        inputPanel.add(new JLabel("Purity (%):"));
        inputPanel.add(purityField);
        inputPanel.add(new JLabel("Dissolution Rate:"));
        inputPanel.add(dissolutionRateField);
        inputPanel.add(new JLabel("Disintegration Time (minutes):"));
        inputPanel.add(disintegrationTimeField);
        inputPanel.add(new JLabel("pH Level:"));
        inputPanel.add(pHField);
        inputPanel.add(new JLabel("Storage Condition:"));
        inputPanel.add(storageConditionField);
        inputPanel.add(microbialCheck);
        inputPanel.add(packagingCheck);
        inputPanel.add(regulatoryCheck);
        inputPanel.add(labelAccuracyCheck);

        mainPanel.add(inputPanel, BorderLayout.CENTER); // Add input panel to main panel

        // Add buttons for submit and CSV upload
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> handleSubmit());
        buttonPanel.add(submitButton);

        JButton uploadButton = new JButton("Upload CSV");
        uploadButton.addActionListener(e -> handleCSVUpload());
        buttonPanel.add(uploadButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Add button panel to main panel

        // Add main panel to the center of the frame
        add(mainPanel, BorderLayout.CENTER);

        // Set up the result area with JTextPane
        resultArea = new JTextPane(); // Changed to JTextPane
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Batch Status Summary"));
        add(scrollPane, BorderLayout.SOUTH); // Move the result area to the bottom

        setSize(600, 600); // Adjusted size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void handleSubmit() {
        try {
            String batchID = batchIDField.getText().trim();
            String expiryDate = expiryDateField.getText().trim();
            String supplierName = supplierNameField.getText().trim();
            double potency = Double.parseDouble(potencyField.getText().trim());
            double purity = Double.parseDouble(purityField.getText().trim());
            double dissolutionRate = Double.parseDouble(dissolutionRateField.getText().trim());
            double disintegrationTime = Double.parseDouble(disintegrationTimeField.getText().trim());
            double pH = Double.parseDouble(pHField.getText().trim());
            String storageCondition = storageConditionField.getText().trim();
            boolean microbial = microbialCheck.isSelected();
            boolean packaging = packagingCheck.isSelected();
            boolean regulatory = regulatoryCheck.isSelected();
            boolean labelAccuracy = labelAccuracyCheck.isSelected();

            Medicine medicine = new Medicine(batchID, expiryDate, supplierName);
            medicine.setPotency(potency);
            medicine.setPurity(purity);
            medicine.setDissolutionRate(dissolutionRate);
            medicine.setDisintegrationTime(disintegrationTime);
            medicine.setPHLevel(pH);
            medicine.setStorageCondition(storageCondition);
            medicine.setMicrobialContamination(microbial);
            medicine.setPackagingIntegrity(packaging);
            medicine.setRegulatoryCompliance(regulatory);
            medicine.setLabelAccuracy(labelAccuracy);

            evaluateAndDisplay(medicine);

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
                        String batchID = data[0].trim();
                        String expiryDate = data[1].trim();
                        String supplierName = data[2].trim();
                        double potency = Double.parseDouble(data[3].trim());
                        double purity = Double.parseDouble(data[4].trim());
                        double dissolutionRate = Double.parseDouble(data[5].trim());
                        double disintegrationTime = Double.parseDouble(data[6].trim());
                        double pH = Double.parseDouble(data[7].trim());
                        String storageCondition = data[8].trim();
                        boolean microbial = Boolean.parseBoolean(data[9].trim());
                        boolean packaging = Boolean.parseBoolean(data[10].trim());
                        boolean regulatory = Boolean.parseBoolean(data[11].trim());
                        boolean labelAccuracy = Boolean.parseBoolean(data[12].trim());
    
                        Medicine medicine = new Medicine(batchID, expiryDate, supplierName);
                        medicine.setPotency(potency);
                        medicine.setPurity(purity);
                        medicine.setDissolutionRate(dissolutionRate);
                        medicine.setDisintegrationTime(disintegrationTime);
                        medicine.setPHLevel(pH);
                        medicine.setStorageCondition(storageCondition);
                        medicine.setMicrobialContamination(microbial);
                        medicine.setPackagingIntegrity(packaging);
                        medicine.setRegulatoryCompliance(regulatory);
                        medicine.setLabelAccuracy(labelAccuracy);
    
                        evaluateAndDisplay(medicine); // Evaluate each record
                    } else {
                        appendToResultArea("Skipping invalid line: " + line, Color.ORANGE);
                    }
                }
            } catch (IOException e) {
                appendToResultArea("Error reading file: " + e.getMessage(), Color.RED);
            } catch (NumberFormatException ex) {
                appendToResultArea("Error parsing number: " + ex.getMessage(), Color.RED);
            }
        }
    }
    
    private void evaluateAndDisplay(Medicine medicine) {
        // Evaluate each parameter
        boolean potencyPass = medicine.getPotency() >= 95 && medicine.getPotency() <= 105;
        boolean purityPass = medicine.getPurity() >= 98 && medicine.getPurity() <= 102;
        boolean dissolutionRatePass = medicine.getDissolutionRate() >= 80;
        boolean disintegrationTimePass = medicine.getDisintegrationTime() <= 30;
        boolean pHPass = medicine.getPHLevel() >= 5 && medicine.getPHLevel() <= 7;
        boolean microbialPass = !medicine.isMicrobialContamination();
        boolean packagingPass = medicine.isPackagingIntegrity();
        boolean regulatoryPass = medicine.isRegulatoryCompliance();
        boolean labelAccuracyPass = medicine.isLabelAccuracy();

        // Determine the status and color
        String status;
        Color color;

        if (!potencyPass || !purityPass || !dissolutionRatePass || !disintegrationTimePass ||
            !pHPass || !microbialPass || !packagingPass || !regulatoryPass || !labelAccuracyPass) {
            status = "Red (Failed)";
            color = Color.RED;
        } else if (!packagingPass || !labelAccuracyPass) {
            status = "Orange (Needs Attention)";
            color = Color.ORANGE;
        } else {
            status = "Green (Approved)";
            color = Color.GREEN;
        }

        // Display the evaluation results
        appendToResultArea("Batch ID: " + medicine.getBatchID() + ", Status: " + status, color);
    }

    private void appendToResultArea(String text, Color color) {
        try {
            StyledDocument doc = resultArea.getStyledDocument();
            Style style = resultArea.addStyle("Style", null);
            StyleConstants.setForeground(style, color);
            doc.insertString(doc.getLength(), text + "\n", style);
            resultArea.setCaretPosition(doc.getLength()); // Auto-scroll to the end
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Dhan13UI::new);
    }
}

