import java.util.ArrayList;
import java.util.List;

public class SalonManager {
    private List<Appointment> appointments;
    private List<Staff> staffList;
    private int idCounter = 1;

    public SalonManager() {
        this.appointments = new ArrayList<>();
        this.staffList = new ArrayList<>();
    }

    public void addStaff(Staff s) {
        staffList.add(s);
    }

    public void createAppointment(Client client, Pet pet, String serviceType) {
        Appointment newApt = new Appointment(idCounter++, client, pet, serviceType);
        appointments.add(newApt);
    }

    public Appointment getAppointment(int id) {
        for (Appointment apt : appointments) {
            if (apt.getId() == id) {
                return apt;
            }
        }
        return null;
    }

    public void displayAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No active appointments.");
        } else {
            System.out.println("\n--- Current Appointments ---");
            System.out.printf("%-5s %-15s %-15s %-20s %-10s%n", "ID", "Owner", "Pet", "Service", "Status");
            for (Appointment apt : appointments) {
                System.out.printf("%-5d %-15s %-15s %-20s Step %d/16%n",
                        apt.getId(),
                        apt.getClient().getName(),
                        apt.getPet().getName(),
                        apt.getServiceType(),
                        apt.getCurrentStep());
            }
        }
    }
}