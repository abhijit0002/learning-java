package simplebillingsystem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Bill {
    private static int billCounter = 1000;
    private int billNumber;
    private String dateTime;
    private List<Item> items;

    private final double GST_RATE = 0.18;

    public Bill() {
        billNumber = billCounter++;
        items = new ArrayList<>();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        dateTime = LocalDateTime.now().format(dtf);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double getSubTotal() {
        double sum = 0;
        for (Item item : items) {
            sum += item.getTotal();
        }
        return sum;
    }

    public double getGstAmount() {
        return getSubTotal() * GST_RATE;
    }

    public double getGrandTotal() {
        return getSubTotal() + getGstAmount();
    }

    public void printBill() {
        System.out.println("\n============== BILL ==============");
        System.out.println("Bill No: " + billNumber);
        System.out.println("Date & Time: " + dateTime);
        System.out.println("----------------------------------");

        for (Item item : items) {
            System.out.println(item);
        }

        System.out.println("----------------------------------");
        System.out.println("SUB TOTAL: " + getSubTotal());
        System.out.println("GST (18%): " + getGstAmount());
        System.out.println("GRAND TOTAL: " + getGrandTotal());
        System.out.println("==================================");
    }
}
