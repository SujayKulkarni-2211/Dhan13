// src/DataProcessor.java
public class DataProcessor {
    private String batchID;
    private String expiryDate;
    private String supplierName;

    // Constructor
    public DataProcessor(String batchID, String expiryDate, String supplierName) {
        this.batchID = batchID;
        this.expiryDate = expiryDate;
        this.supplierName = supplierName;
    }

    // Method to simulate processing the data
    public void process() {
        System.out.println("Processing the following data:");
        System.out.println("Batch ID: " + batchID);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Supplier Name: " + supplierName);
    }
}
