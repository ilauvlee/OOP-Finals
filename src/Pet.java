public class Pet {
    private String name;
    private String breed;
    private String healthNotes;

    public Pet(String name, String breed) {
        this.name = name;
        this.breed = breed;
        this.healthNotes = "None";
    }

    public String getName() { return name; }
    public String getBreed() { return breed; }

    public void setHealthNotes(String notes) {
        this.healthNotes = notes;
    }
}