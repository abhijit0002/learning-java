import java.util.*;
import simplebillingsystem.Bill;
import simplebillingsystem.Item
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bill bill = new Bill();

        System.out.println("====== Simple Billing System ======");

        while (true) {
            System.out.print("\nEnter Item Name: ");
            String name = sc.next();

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            System.out.print("Enter Price per Unit: ");
            double price = sc.nextDouble();

            bill.addItem(new Item(name, qty, price));

            System.out.print("Add more items? (yes/no): ");
            String choice = sc.next().toLowerCase();

            if (choice.equals("no")) {
                break;
            }
        }

        bill.printBill();
        sc.close();
    }
}
