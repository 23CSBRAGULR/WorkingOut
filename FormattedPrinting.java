package WorkingOut;

public class FormattedPrinting {
    public static void main(String[] args) {
        System.out.printf("%-15s %-10s %-10s %-10s%n", "Item", "Qty", "Price", "Total");
        System.out.println("--------------------------------------------------------");

        System.out.printf("%-15s %-10d %-10.2f %-10.2f%n", "Para", 2, 1.5, 3.0);
        System.out.printf("%-15s %-10d %-10.2f %-10.2f%n", "Amoxicillin", 1, 3.0, 3.0);
    }
}