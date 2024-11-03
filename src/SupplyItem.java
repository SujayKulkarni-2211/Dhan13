// src/SupplyItem.java
public abstract class SupplyItem {
    private String batchID;
    private String expiryDate;
    private String supplierName;

    public SupplyItem(String batchID, String expiryDate, String supplierName) {
        this.batchID = batchID;
        this.expiryDate = expiryDate;
        this.supplierName = supplierName;
    }

    public String getBatchID() { return batchID; }
    public String getExpiryDate() { return expiryDate; }
    public String getSupplierName() { return supplierName; }

    public abstract void performQualityCheck();

    public void displayInfo() {
        System.out.println("Batch ID: " + batchID);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Supplier Name: " + supplierName);
    }
}
