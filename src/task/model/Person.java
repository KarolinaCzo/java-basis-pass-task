package task.model;

public class Person implements Comparable<Person> {
    private final String firstName;
    private final String lastName;
    private final int birthYear;
    private final long pesel;

    public Person(String firstName, String lastName, int birthYear, long pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + birthYear + ", " + pesel;
    }

    @Override
    public int compareTo(Person person) {
        int primary = lastName.compareTo(person.lastName);
        return primary != 0 ? primary
                : lastName.compareTo(person.lastName);
    }

    public int getBirthYear() { return birthYear; }
}
