import java.util.Scanner;

public class Main {

    interface ConverterListener {
        void actionPerformed();
    }

    public static void main(String[] args) {

        ConverterListener listener = () -> {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            System.out.print(
                "Enter Currency (USD/EUR): ");

            String currency = sc.next();

            double rate =
                currency.equalsIgnoreCase("USD")
                ? 0.012 : 0.011;

            System.out.printf(
                "Converted Amount: %.2f%n",
                amount * rate);
        };

        // Simulates event
        listener.actionPerformed();
    }
}
