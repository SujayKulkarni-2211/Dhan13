// src/Consumable.java
public class Consumable extends SupplyItem {
    private boolean isSterile;

    public Consumable(String batchID, String expiryDate, String supplierName, boolean isSterile) {
        super(batchID, expiryDate, supplierName);
        this.isSterile = isSterile;
    }

    @Override
    public void performQualityCheck() {
        System.out.println("Performing quality check for Consumable...");
        if (isSterile) {
            System.out.println("Item is sterile.");
        } else {
            System.out.println("Item is not sterile!");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sterility: " + (isSterile ? "Sterile" : "Non-Sterile"));
    }
}
