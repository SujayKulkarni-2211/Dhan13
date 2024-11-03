// src/Medicine.java
public class Medicine extends SupplyItem {
    private double potency;
    private double purity;
    private boolean microbialContamination;
    private double dissolutionRate;
    private double disintegrationTime;
    private double pHLevel;
    private boolean packagingIntegrity;
    private boolean labelAccuracy;
    private boolean regulatoryCompliance;
    private double storageTemperature;
    private boolean activeIngredientQuality;
    private String manufacturerCertification;
    private boolean sterility;

    public Medicine(String batchID, String expiryDate, String supplierName) {
        super(batchID, expiryDate, supplierName);
    }

    // Setter methods for each attribute
    public void setPotency(double potency) { this.potency = potency; }
    public void setPurity(double purity) { this.purity = purity; }
    public void setMicrobialContamination(boolean microbialContamination) { this.microbialContamination = microbialContamination; }
    public void setDissolutionRate(double dissolutionRate) { this.dissolutionRate = dissolutionRate; }
    public void setDisintegrationTime(double disintegrationTime) { this.disintegrationTime = disintegrationTime; }
    public void setPHLevel(double pHLevel) { this.pHLevel = pHLevel; }
    public void setPackagingIntegrity(boolean packagingIntegrity) { this.packagingIntegrity = packagingIntegrity; }
    public void setLabelAccuracy(boolean labelAccuracy) { this.labelAccuracy = labelAccuracy; }
    public void setRegulatoryCompliance(boolean regulatoryCompliance) { this.regulatoryCompliance = regulatoryCompliance; }
    public void setStorageTemperature(double storageTemperature) { this.storageTemperature = storageTemperature; }
    public void setActiveIngredientQuality(boolean activeIngredientQuality) { this.activeIngredientQuality = activeIngredientQuality; }
    public void setManufacturerCertification(String manufacturerCertification) { this.manufacturerCertification = manufacturerCertification; }
    public void setSterility(boolean sterility) { this.sterility = sterility; }

    @Override
    public void performQualityCheck() {
        System.out.println("Performing quality check for Medicine...");

        // Sample checks for each factor
        if (potency >= 90.0 && potency <= 110.0) {
            System.out.println("Potency: Pass");
        } else {
            System.out.println("Potency: Fail");
        }

        if (purity >= 99.0) {
            System.out.println("Purity: Pass");
        } else {
            System.out.println("Purity: Fail");
        }

        if (!microbialContamination) {
            System.out.println("Microbial Contamination: Pass");
        } else {
            System.out.println("Microbial Contamination: Fail");
        }

        if (dissolutionRate >= 70.0) {
            System.out.println("Dissolution Rate: Pass");
        } else {
            System.out.println("Dissolution Rate: Fail");
        }

        if (disintegrationTime <= 30.0) {
            System.out.println("Disintegration Time: Pass");
        } else {
            System.out.println("Disintegration Time: Fail");
        }

        if (pHLevel >= 5.5 && pHLevel <= 8.0) {
            System.out.println("pH Level: Pass");
        } else {
            System.out.println("pH Level: Fail");
        }

        if (packagingIntegrity) {
            System.out.println("Packaging Integrity: Pass");
        } else {
            System.out.println("Packaging Integrity: Fail");
        }

        if (labelAccuracy) {
            System.out.println("Label Accuracy: Pass");
        } else {
            System.out.println("Label Accuracy: Fail");
        }

        if (regulatoryCompliance) {
            System.out.println("Regulatory Compliance: Pass");
        } else {
            System.out.println("Regulatory Compliance: Fail");
        }

        if (storageTemperature >= 15.0 && storageTemperature <= 25.0) {
            System.out.println("Storage Temperature: Pass");
        } else {
            System.out.println("Storage Temperature: Fail");
        }

        if (activeIngredientQuality) {
            System.out.println("Active Ingredient Quality: Pass");
        } else {
            System.out.println("Active Ingredient Quality: Fail");
        }

        if (manufacturerCertification.equals("Certified")) {
            System.out.println("Manufacturer Certification: Pass");
        } else {
            System.out.println("Manufacturer Certification: Fail");
        }

        if (sterility) {
            System.out.println("Sterility: Pass");
        } else {
            System.out.println("Sterility: Fail");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Potency: " + potency);
        System.out.println("Purity: " + purity);
        System.out.println("Microbial Contamination: " + (microbialContamination ? "Yes" : "No"));
        System.out.println("Dissolution Rate: " + dissolutionRate);
        System.out.println("Disintegration Time: " + disintegrationTime);
        System.out.println("pH Level: " + pHLevel);
        System.out.println("Packaging Integrity: " + (packagingIntegrity ? "Intact" : "Damaged"));
        System.out.println("Label Accuracy: " + (labelAccuracy ? "Accurate" : "Inaccurate"));
        System.out.println("Regulatory Compliance: " + (regulatoryCompliance ? "Compliant" : "Non-Compliant"));
        System.out.println("Storage Temperature: " + storageTemperature + "°C");
        System.out.println("Active Ingredient Quality: " + (activeIngredientQuality ? "High" : "Low"));
        System.out.println("Manufacturer Certification: " + manufacturerCertification);
        System.out.println("Sterility: " + (sterility ? "Sterile" : "Non-Sterile"));
    }
}
