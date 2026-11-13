import java.util.Scanner;

public class Main implements java.awt.event.ActionListener {

    Scanner sc = new Scanner(System.in);

    public void actionPerformed(java.awt.event.ActionEvent e) {

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Currency (USD/EUR): ");
        String currency = sc.next();

        double rate = currency.equalsIgnoreCase("USD")
                    ? 0.012 : 0.011;

        System.out.printf("Converted Amount: %.2f%n",
                          amount * rate);
    }

    public static void main(String[] args) {

        Main obj = new Main();

        // Simulates button click
        obj.actionPerformed(null);
    }
}
