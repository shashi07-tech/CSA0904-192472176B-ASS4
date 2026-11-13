import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> points =
                new ArrayList<>();
        System.out.print("Enter number of mouse clicks: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print(
                    "Enter X coordinate: ");
            int x = sc.nextInt();
            System.out.print(
                    "Enter Y coordinate: ");
            int y = sc.nextInt();
            points.add(
                    "(" + x + ", " + y + ")");
        }
        System.out.println(
                "\nTotal Clicks: "
                + points.size());
        System.out.println(
                "Clicked Points:");
        for (String point : points) {
            System.out.println(point);
        }
        sc.close();
    }
}
