public class Staff {
    private String name;
    private String role; // e.g., Groomer, Receptionist, Bather

    public Staff(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() { return name; }
    public String getRole() { return role; }

    @Override
    public String toString() {
        return name + " (" + role + ")";
    }
}