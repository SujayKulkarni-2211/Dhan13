// src/Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter type of item (medicine/consumable): ");
        String itemType = scanner.nextLine().trim();

        System.out.println("Enter Batch ID: ");
        String batchID = scanner.nextLine().trim();

        System.out.println("Enter Expiry Date (YYYY-MM-DD): ");
        String expiryDate = scanner.nextLine().trim();

        System.out.println("Enter Supplier Name: ");
        String supplierName = scanner.nextLine().trim();

        if (itemType.equalsIgnoreCase("medicine")) {
            Medicine medicine = new Medicine(batchID, expiryDate, supplierName);

            // Gather data for each factor
            System.out.println("Enter Potency (%): ");
            medicine.setPotency(scanner.nextDouble());

            System.out.println("Enter Purity (%): ");
            medicine.setPurity(scanner.nextDouble());

            System.out.println("Is there Microbial Contamination? (true/false): ");
            medicine.setMicrobialContamination(scanner.nextBoolean());

            System.out.println("Enter Dissolution Rate (%): ");
            medicine.setDissolutionRate(scanner.nextDouble());

            System.out.println("Enter Disintegration Time (minutes): ");
            medicine.setDisintegrationTime(scanner.nextDouble());

            System.out.println("Enter pH Level: ");
            medicine.setPHLevel(scanner.nextDouble());

            System.out.println("Is Packaging Integrity intact? (true/false): ");
            medicine.setPackagingIntegrity(scanner.nextBoolean());

            System.out.println("Is Label Accuracy correct? (true/false): ");
            medicine.setLabelAccuracy(scanner.nextBoolean());

            System.out.println("Does it meet Regulatory Compliance? (true/false): ");
            medicine.setRegulatoryCompliance(scanner.nextBoolean());

            System.out.println("Enter Storage Temperature (°C): ");
            medicine.setStorageTemperature(scanner.nextDouble());

            System.out.println("Is Active Ingredient Quality high? (true/false): ");
            medicine.setActiveIngredientQuality(scanner.nextBoolean());

            System.out.println("Enter Manufacturer Certification (e.g., Certified/Non-Certified): ");
            scanner.nextLine(); // Consume newline
            medicine.setManufacturerCertification(scanner.nextLine().trim());

            System.out.println("Is it Sterile? (true/false): ");
            medicine.setSterility(scanner.nextBoolean());

            // Display and perform quality checks
            medicine.displayInfo();
            medicine.performQualityCheck();
        } else {
            System.out.println("Currently, only 'medicine' items are supported for quality check.");
        }

        scanner.close();
    }
}
