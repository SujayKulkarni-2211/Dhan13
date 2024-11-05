public class Consumable {
    private String batchNumber;
    private String expiryDate;
    private String materialType;
    private double tensileStrength;
    private double elasticity;
    private double absorbency;
    private double nonToxicity;
    private double biocompatibility;
    private double resistanceToDegradation;
    private String packagingIntegrity;
    private String labelAccuracy;
    private boolean sterilizationValidated;
    private boolean regulatoryCompliant;

    public Consumable(String batchNumber, String expiryDate, String materialType) {
        this.batchNumber = batchNumber;
        this.expiryDate = expiryDate;
        this.materialType = materialType;
    }

    // Getters and Setters
    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public double getTensileStrength() {
        return tensileStrength;
    }

    public void setTensileStrength(double tensileStrength) {
        this.tensileStrength = tensileStrength;
    }

    public double getElasticity() {
        return elasticity;
    }

    public void setElasticity(double elasticity) {
        this.elasticity = elasticity;
    }

    public double getAbsorbency() {
        return absorbency;
    }

    public void setAbsorbency(double absorbency) {
        this.absorbency = absorbency;
    }

    public double getNonToxicity() {
        return nonToxicity;
    }

    public void setNonToxicity(double nonToxicity) {
        this.nonToxicity = nonToxicity;
    }

    public double getBiocompatibility() {
        return biocompatibility;
    }

    public void setBiocompatibility(double biocompatibility) {
        this.biocompatibility = biocompatibility;
    }

    public double getResistanceToDegradation() {
        return resistanceToDegradation;
    }

    public void setResistanceToDegradation(double resistanceToDegradation) {
        this.resistanceToDegradation = resistanceToDegradation;
    }

    public String getPackagingIntegrity() {
        return packagingIntegrity;
    }

    public void setPackagingIntegrity(String packagingIntegrity) {
        this.packagingIntegrity = packagingIntegrity;
    }

    public String getLabelAccuracy() {
        return labelAccuracy;
    }

    public void setLabelAccuracy(String labelAccuracy) {
        this.labelAccuracy = labelAccuracy;
    }

    public boolean isSterilizationValidated() {
        return sterilizationValidated;
    }

    public void setSterilizationValidated(boolean sterilizationValidated) {
        this.sterilizationValidated = sterilizationValidated;
    }

    public boolean isRegulatoryCompliant() {
        return regulatoryCompliant;
    }

    public void setRegulatoryCompliant(boolean regulatoryCompliant) {
        this.regulatoryCompliant = regulatoryCompliant;
    }

    // Additional validation methods can be added here if needed
}
