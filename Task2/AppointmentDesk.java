import java.util.Scanner;
class AppointmentService {
    public String bookAppointment(
            String patientId,
            String department,
            String doctor,
            String timeSlot) {
        if (patientId == null || patientId.trim().isEmpty()) {
            return "Invalid Patient ID";
        }
        if (department == null || department.trim().isEmpty()) {
            return "Select Department";
        }
        if (doctor == null || doctor.trim().isEmpty()) {
            return "Select Doctor";
        }
        if (timeSlot == null || timeSlot.trim().isEmpty()) {
            return "Select Time Slot";
        }
        return "Appointment Booked Successfully";
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentService service =
                new AppointmentService();
        System.out.print("Enter Patient ID: ");
        String patientId = sc.nextLine();
        System.out.print("Enter Department: ");
        String department = sc.nextLine();
        System.out.print("Enter Doctor: ");
        String doctor = sc.nextLine();
        System.out.print("Enter Time Slot: ");
        String timeSlot = sc.nextLine();
        String result = service.bookAppointment(
                patientId,
                department,
                doctor,
                timeSlot);
        System.out.println("\nResult: " + result);
        sc.close();
    }
}
