package phonebook.entity;

public class Contact {
    private String name;
    private String number;

    public Contact () {}

    public Contact (String name, String number) {
        setName(name);
        setNumber(number);
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setNumber(String number) {
        this.number = number;
    }
}
