// src/Consumable.java
public class Consumable extends SupplyItem {
    private boolean isSterile;

    public Consumable(String batchID, String expiryDate, String supplierName, boolean isSterile) {
        super(batchID, expiryDate, supplierName);
        this.isSterile = isSterile;
    }

    @Override
    public boolean performQualityCheck() {
        System.out.println("Performing quality check for Consumable...");
        return isSterile; // Return true if sterile
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sterility: " + (isSterile ? "Sterile" : "Non-Sterile"));
    }
}
