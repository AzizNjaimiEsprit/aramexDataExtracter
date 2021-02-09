package sample.models;

public class Item {
    private String name;
    private String email;

    public Item(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Item{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}
