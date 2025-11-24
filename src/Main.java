import java.util.Scanner;

/**
 * GROUP PET GROOMING SALON
 * Members: Lumbera Casey-Ann, Gutierrez Lovely Joy, Comia Althea Marie
 * Main Entry point for the Console Application.
 */
public class Main {
    private static SalonManager manager = new SalonManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        manager.addStaff(new Staff("Casey (Rec)", "Receptionist"));
        manager.addStaff(new Staff("Lovely (Gro)", "Groomer"));
        manager.addStaff(new Staff("Althea (Ast)", "Grooming Assistant"));

        clearScreen();
        System.out.println("=========================================");
        System.out.println("   WELCOME TO THE PET GROOMING SALON     ");
        System.out.println("=========================================");
        waitForEnter();

        boolean running = true;
        while (running) {
            clearScreen();
            System.out.println("=========================================");
            System.out.println("             MAIN MENU                   ");
            System.out.println("=========================================");
            System.out.println("1. Book New Appointment (Step 1)");
            System.out.println("2. View Active Appointments");
            System.out.println("3. Process Appointment (Manage Workflow)");
            System.out.println("4. Exit");
            System.out.println("=========================================");
            System.out.print("Select an option: ");

            int choice = validateIntInput();

            switch (choice) {
                case 1:
                    bookAppointment();
                    break;
                case 2:
                    clearScreen();
                    manager.displayAppointments();
                    waitForEnter();
                    break;
                case 3:
                    processFlow();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
                    waitForEnter();
            }
        }
    }

    private static void bookAppointment() {
        clearScreen();
        System.out.println("--- STEP 1: APPOINTMENT & SCHEDULING ---");
        System.out.print("Enter Client Name: ");
        String clientName = scanner.nextLine();

        System.out.print("Enter Pet Name: ");
        String petName = scanner.nextLine();

        System.out.print("Enter Pet Breed: ");
        String breed = scanner.nextLine();

        System.out.print("Service Type (Full Grooming/Bath/Nail Trim): ");
        String service = scanner.nextLine();

        Client client = new Client(clientName);
        Pet pet = new Pet(petName, breed);

        manager.createAppointment(client, pet, service);
        System.out.println("\nSUCCESS: Appointment booked successfully!");
        waitForEnter();
    }

    private static void processFlow() {
        clearScreen();
        manager.displayAppointments();
        System.out.println("\n-----------------------------------------");
        System.out.print("Enter Appointment ID to process (or 0 to cancel): ");
        int id = validateIntInput();

        if (id == 0) return;

        Appointment apt = manager.getAppointment(id);
        if (apt == null) {
            System.out.println("Error: Appointment not found.");
            waitForEnter();
            return;
        }

        // Enter the sub-menu for this specific appointment
        boolean processing = true;
        while (processing) {
            clearScreen();
            // Display Header Info
            System.out.println("=========================================");
            System.out.println("       PROCESSING APPOINTMENT #" + apt.getId());
            System.out.println("=========================================");
            System.out.printf(" Client : %-20s \n", apt.getClient().getName());
            System.out.printf(" Pet    : %-20s \n", apt.getPet().getName() + " (" + apt.getPet().getBreed() + ")");
            System.out.printf(" Service: %-20s \n", apt.getServiceType());
            System.out.println("-----------------------------------------");
            System.out.println(" Progress: " + apt.getProgressBar());
            System.out.println(" Status  : Step " + apt.getCurrentStep() + " of 16");
            System.out.println("=========================================");

            if (apt.isComplete()) {
                System.out.println("\n This appointment is fully completed and ready for archiving.");
                System.out.println("\n[0] Back to Main Menu");
            } else {
                System.out.println("\n[1] Advance to Next Step");
                System.out.println("[2] Fast-Track (Complete All Remaining Steps)");
                System.out.println("[0] Back to Main Menu");
            }
            System.out.print("\nSelect option: ");

            int choice = validateIntInput();
            switch (choice) {
                case 1:
                    if (!apt.isComplete()) {
                        clearScreen();
                        apt.advanceStep();
                        waitForEnter();
                    } else {
                        System.out.println("Already finished!");
                        waitForEnter();
                    }
                    break;
                case 2:
                    if (!apt.isComplete()) {
                        clearScreen();
                        while(!apt.isComplete()) {
                            apt.advanceStep();
                            // Small delay to make the "fast track" look cool
                            try { Thread.sleep(500); } catch (Exception e) {}
                        }
                        waitForEnter();
                    }
                    break;
                case 0:
                    processing = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Helper to prevent scanner skipping lines
    private static int validateIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }

    // Helper to clear console (Works in most standard terminals)
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Helper to pause execution
    private static void waitForEnter() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}