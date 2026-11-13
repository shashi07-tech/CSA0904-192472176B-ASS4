import java.util.Scanner;
class LibraryService {
    public String searchBook(String bookName) {
        if (bookName == null || bookName.trim().isEmpty()) {
            return "Enter a book name";
        }
        return "Search Result\n"
                + "Book: " + bookName
                + "\nStatus: Available";
    }
    public String reserveBook(String bookName) {
        if (bookName == null || bookName.trim().isEmpty()) {
            return "No book selected";
        }
        return "Book reserved successfully";
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryService service =
                new LibraryService();
        System.out.print("Enter Book Name: ");
        String bookName = sc.nextLine();
        String result =
                service.searchBook(bookName);
        System.out.println("\n" + result);
        System.out.print("\nDo you want to reserve the book? (yes/no): ");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println(
                    service.reserveBook(bookName));
        } else {
            System.out.println(
                    "Book was not reserved.");
        }
        sc.close();
    }
}
