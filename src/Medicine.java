// src/Medicine.java
public class Medicine extends SupplyItem {
    private double potency;
    private double purity;
    private double dissolutionRate;
    private double disintegrationTime;
    private double pHLevel;
    private String storageCondition; // e.g., "Room Temperature"
    private boolean microbialContamination;
    private boolean packagingIntegrity;
    private boolean labelAccuracy;
    private boolean regulatoryCompliance;
    private boolean activeIngredientQuality;
    private boolean chemicalStability; // New parameter
    private String batchID; // New parameter

    public Medicine(String batchID, String expiryDate, String supplierName) {
        super(batchID, expiryDate, supplierName);
    }

    // Setter methods for each attribute
    public void setPotency(double potency) { this.potency = potency; }
    public void setPurity(double purity) { this.purity = purity; }
    public void setDissolutionRate(double dissolutionRate) { this.dissolutionRate = dissolutionRate; }
    public void setDisintegrationTime(double disintegrationTime) { this.disintegrationTime = disintegrationTime; }
    public void setPHLevel(double pHLevel) { this.pHLevel = pHLevel; }
    public void setStorageCondition(String storageCondition) { this.storageCondition = storageCondition; }
    public void setMicrobialContamination(boolean microbialContamination) { this.microbialContamination = microbialContamination; }
    public void setPackagingIntegrity(boolean packagingIntegrity) { this.packagingIntegrity = packagingIntegrity; }
    public void setLabelAccuracy(boolean labelAccuracy) { this.labelAccuracy = labelAccuracy; }
    public void setRegulatoryCompliance(boolean regulatoryCompliance) { this.regulatoryCompliance = regulatoryCompliance; }
    public void setActiveIngredientQuality(boolean activeIngredientQuality) { this.activeIngredientQuality = activeIngredientQuality; }
    public void setChemicalStability(boolean chemicalStability) { this.chemicalStability = chemicalStability; }
    public void setbatchID(String batchID) { this.batchID = batchID; }

    // Getter methods for each attribute (needed for UI class to access attributes)
    public double getPotency() { return potency; }
    public double getPurity() { return purity; }
    public double getDissolutionRate() { return dissolutionRate; }
    public double getDisintegrationTime() { return disintegrationTime; }
    public double getPHLevel() { return pHLevel; }
    public String getStorageCondition() { return storageCondition; }
    public boolean isMicrobialContamination() { return microbialContamination; }
    public boolean isPackagingIntegrity() { return packagingIntegrity; }
    public boolean isLabelAccuracy() { return labelAccuracy; }
    public boolean isRegulatoryCompliance() { return regulatoryCompliance; }
    public boolean isActiveIngredientQuality() { return activeIngredientQuality; }
    public boolean isChemicalStability() { return chemicalStability; }
    public String getbatchID() { return batchID; }

    @Override
    public boolean performQualityCheck() {
        System.out.println("Performing quality check for Medicine...");

        boolean isValid = true; // Assume valid unless checks fail

        // Check each parameter and print results
        if (potency < 90.0 || potency > 110.0) {
            System.out.println("Potency: Fail");
            isValid = false;
        } else {
            System.out.println("Potency: Pass");
        }

        if (purity < 99.0) {
            System.out.println("Purity: Fail");
            isValid = false;
        } else {
            System.out.println("Purity: Pass");
        }

        if (dissolutionRate < 70.0) {
            System.out.println("Dissolution Rate: Fail");
            isValid = false;
        } else {
            System.out.println("Dissolution Rate: Pass");
        }

        if (disintegrationTime > 30.0) {
            System.out.println("Disintegration Time: Fail");
            isValid = false;
        } else {
            System.out.println("Disintegration Time: Pass");
        }

        if (pHLevel < 5.5 || pHLevel > 8.0) {
            System.out.println("pH Level: Fail");
            isValid = false;
        } else {
            System.out.println("pH Level: Pass");
        }

        if (packagingIntegrity) {
            System.out.println("Packaging Integrity: Pass");
        } else {
            System.out.println("Packaging Integrity: Fail");
            isValid = false;
        }

        if (labelAccuracy) {
            System.out.println("Label Accuracy: Pass");
        } else {
            System.out.println("Label Accuracy: Fail");
            isValid = false;
        }

        if (regulatoryCompliance) {
            System.out.println("Regulatory Compliance: Pass");
        } else {
            System.out.println("Regulatory Compliance: Fail");
            isValid = false;
        }

        if (storageCondition.equalsIgnoreCase("Room Temperature")) {
            System.out.println("Storage Condition: Pass");
        } else {
            System.out.println("Storage Condition: Fail");
            isValid = false;
        }

        // New parameter checks
        if (chemicalStability) {
            System.out.println("Chemical Stability: Pass");
        } else {
            System.out.println("Chemical Stability: Fail");
            isValid = false;
        }

        if (activeIngredientQuality) {
            System.out.println("Active Ingredient Quality: Pass");
        } else {
            System.out.println("Active Ingredient Quality: Fail");
            isValid = false;
        }

        return isValid; 
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Batch Number: " + batchID); 
        System.out.println("Potency: " + potency);
        System.out.println("Purity: " + purity);
        System.out.println("Dissolution Rate: " + dissolutionRate);
        System.out.println("Disintegration Time: " + disintegrationTime);
        System.out.println("pH Level: " + pHLevel);
        System.out.println("Storage Condition: " + storageCondition);
        System.out.println("Microbial Contamination: " + (microbialContamination ? "Yes" : "No"));
        System.out.println("Packaging Integrity: " + (packagingIntegrity ? "Intact" : "Damaged"));
        System.out.println("Label Accuracy: " + (labelAccuracy ? "Accurate" : "Inaccurate"));
        System.out.println("Regulatory Compliance: " + (regulatoryCompliance ? "Compliant" : "Non-Compliant"));
        System.out.println("Active Ingredient Quality: " + (activeIngredientQuality ? "High" : "Low"));
        System.out.println("Chemical Stability: " + (chemicalStability ? "Stable" : "Unstable"));
    }
}
