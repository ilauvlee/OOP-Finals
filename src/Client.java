public class Client {
    private String name;
    private String phoneNumber;

    public Client(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}