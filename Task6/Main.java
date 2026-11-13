import java.util.*;

class Registration {
    String studentId;
    String studentName;
    String email;
    String eventName;

    Registration(String studentId, String studentName, String email, String eventName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.eventName = eventName;
    }
}

class EventRegistrationService {
    private final List<String> events = Arrays.asList(
        "Cultural Fest",
        "Dance Competition",
        "Singing Competition",
        "Drama"
    );
    private final List<Registration> registrations = new ArrayList<>();

    public List<String> getEvents() {
        return events;
    }

    public String registerStudent(String studentId, String studentName, String email, int eventChoice) {
        if (studentId == null || studentId.trim().isEmpty()) {
            return "Error: Student ID is required.";
        }
        if (studentName == null || studentName.trim().isEmpty()) {
            return "Error: Student Name is required.";
        }
        if (email == null || !email.trim().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            return "Error: Invalid email format.";
        }
        if (eventChoice < 1 || eventChoice > events.size()) {
            return "Error: Invalid event selection.";
        }

        String selectedEvent = events.get(eventChoice - 1);

        // Duplicate check (studentId + eventName)
        for (Registration r : registrations) {
            if (r.studentId.equalsIgnoreCase(studentId.trim()) && r.eventName.equals(selectedEvent)) {
                return "Error: Student " + studentId.trim() + " is already registered for " + selectedEvent + ".";
            }
        }

        registrations.add(new Registration(studentId.trim(), studentName.trim(), email.trim(), selectedEvent));
        return "Registration successful for " + selectedEvent + "!";
    }

    public List<Registration> getFilteredRegistrations(int filterChoice) {
        if (filterChoice == 0) {
            return new ArrayList<>(registrations);
        }
        String targetEvent = events.get(filterChoice - 1);
        List<Registration> filtered = new ArrayList<>();
        for (Registration r : registrations) {
            if (r.eventName.equals(targetEvent)) {
                filtered.add(r);
            }
        }
        return filtered;
    }

    public String exportCSV() {
        if (registrations.isEmpty()) {
            return "No registrations available to export.";
        }
        StringBuilder sb = new StringBuilder("Student ID,Name,Email,Event\n");
        for (Registration r : registrations) {
            sb.append(String.format("\"%s\",\"%s\",\"%s\",\"%s\"\n",
                    r.studentId, r.studentName, r.email, r.eventName));
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventRegistrationService service = new EventRegistrationService();

        while (true) {
            System.out.println("\n=== CAMPUS EVENT REGISTRATION SYSTEM ===");
            System.out.println("1. Student Registration");
            System.out.println("2. Committee: View / Filter Registrations");
            System.out.println("3. Committee: Export Registrations (CSV)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String choiceInput = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Enter a number from 1 to 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    List<String> events = service.getEvents();
                    System.out.println("Select Event:");
                    for (int i = 0; i < events.size(); i++) {
                        System.out.println("  " + (i + 1) + ". " + events.get(i));
                    }
                    System.out.print("Enter Event Number: ");
                    int eventNum;
                    try {
                        eventNum = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Enter a valid event number.");
                        break;
                    }

                    String result = service.registerStudent(id, name, email, eventNum);
                    System.out.println("\nResult: " + result);
                    break;

                case 2:
                    List<String> filterEvents = service.getEvents();
                    System.out.println("\nFilter by Event:");
                    System.out.println("  0. All Events");
                    for (int i = 0; i < filterEvents.size(); i++) {
                        System.out.println("  " + (i + 1) + ". " + filterEvents.get(i));
                    }
                    System.out.print("Enter Filter Option: ");
                    int filterNum;
                    try {
                        filterNum = Integer.parseInt(sc.nextLine().trim());
                        if (filterNum < 0 || filterNum > filterEvents.size()) {
                            System.out.println("Invalid filter option.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                        break;
                    }

                    List<Registration> list = service.getFilteredRegistrations(filterNum);
                    System.out.println("\n---------------------------------------------------------------------");
                    System.out.printf("%-15s | %-18s | %-22s | %-15s%n", "Student ID", "Name", "Email", "Event");
                    System.out.println("---------------------------------------------------------------------");
                    if (list.isEmpty()) {
                        System.out.println("No registrations found.");
                    } else {
                        for (Registration r : list) {
                            System.out.printf("%-15s | %-18s | %-22s | %-15s%n",
                                    r.studentId, r.studentName, r.email, r.eventName);
                        }
                    }
                    System.out.println("---------------------------------------------------------------------");
                    break;

                case 3:
                    System.out.println("\n--- CSV EXPORT OUTPUT ---");
                    System.out.println(service.exportCSV());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Select 1-4.");
            }
        }
    }
}
