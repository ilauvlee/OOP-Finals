public class Appointment {
    private int id;
    private Client client;
    private Pet pet;
    private String serviceType;
    private int currentStep; // Tracks steps 1 to 16

    public Appointment(int id, Client client, Pet pet, String serviceType) {
        this.id = id;
        this.client = client;
        this.pet = pet;
        this.serviceType = serviceType;
        this.currentStep = 1; // Starts at Step 1 (Booking)
    }

    public void advanceStep() {
        currentStep++;
        printStepDetails();
    }

    public int getId() { return id; }
    public Client getClient() { return client; }
    public Pet getPet() { return pet; }
    public String getServiceType() { return serviceType; }
    public int getCurrentStep() { return currentStep; }

    // Helper to check if finished
    public boolean isComplete() {
        return currentStep >= 16;
    }

    // Generates a visual progress bar string
    public String getProgressBar() {
        StringBuilder bar = new StringBuilder("[");
        int total = 16;
        for (int i = 1; i <= total; i++) {
            if (i <= currentStep) bar.append("■"); // Completed step char
            else bar.append("-"); // Pending step char
        }
        bar.append("]");
        return bar.toString();
    }

    // This method maps the logic from your specific requirements to code
    private void printStepDetails() {
        System.out.println("_________________________________________");
        System.out.println("   >>> PROCESSING STEP " + currentStep + " <<<");
        System.out.println("_________________________________________");

        String action = "";
        String detail = "";
        String area = "";

        switch (currentStep) {
            case 2:
                action = "Check-in & Registration";
                detail = "Owner filling out health forms.";
                area = "Reception Area | STAFF: Front Desk Officer";
                break;
            case 3:
                action = "Pet Assessment";
                detail = "Examining skin, coat, and checking for fleas.";
                area = "Assessment Area | STAFF: Groomer / Vet Assistant";
                break;
            case 4:
                action = "Pre-Grooming Preparation";
                detail = "Brushing to remove mats before bath.";
                area = "Preparation Area | STAFF: Bather";
                break;
            case 5:
                action = "Bathing";
                detail = "Washing with shampoo and conditioner.";
                area = "Bathing Area | STAFF: Bather";
                break;
            case 6:
                action = "Drying & Brushing";
                detail = "Towel dry and blow dry.";
                area = "Drying Area | STAFF: Grooming Assistant";
                break;
            case 7:
                action = "Hair Trimming & Styling";
                detail = "Cutting fur according to breed standard.";
                area = "Styling Area | STAFF: Professional Groomer";
                break;
            case 8:
                action = "Nail Trimming & Filing";
                detail = "Clipping nails and applying paw balm.";
                area = "Finishing Table | STAFF: Assistant Groomer";
                break;
            case 9:
                action = "Ear & Eye Cleaning";
                detail = "Wiping eyes and cleaning wax.";
                area = "Grooming Table | STAFF: Groomer";
                break;
            case 10:
                action = "Additional Care Services";
                detail = "Teeth brushing and perfume spray.";
                area = "Finishing Area | STAFF: Assistant";
                break;
            case 11:
                action = "Final Styling & Inspection";
                detail = "Final quality check.";
                area = "Grooming Area | STAFF: Stylist";
                break;
            case 12:
                action = "Holding / Waiting";
                detail = "Pet placed in sanitized cage with water.";
                area = "Holding Area | STAFF: Grooming Assistant";
                break;
            case 13:
                action = "Owner Notification";
                detail = "Calling owner for pickup.";
                area = "Reception | STAFF: Receptionist";
                break;
            case 14:
                action = "Payment & Feedback";
                detail = "Processing payment and loyalty rewards.";
                area = "Front Desk | STAFF: Cashier";
                break;
            case 15:
                action = "Cleaning & Sanitation";
                detail = "Disinfecting tools and table.";
                area = "All Areas | STAFF: Cleaning Staff";
                break;
            case 16:
                action = "Record Keeping";
                detail = "Saving client history to database.";
                area = "Office | STAFF: Manager";
                break;
        }

        System.out.println(" ACTION : " + action);
        System.out.println(" DETAIL : " + detail);
        System.out.println(" AREA   : " + area);
        System.out.println("_________________________________________");

        if (currentStep == 16) {
            System.out.println("\n      *** SERVICE COMPLETE *** ");
        }
    }
}