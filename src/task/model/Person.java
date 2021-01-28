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

    // Overriding toString() method to determine how to display data
    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + birthYear + ", " + pesel;
    }

    // Overriding compareTo() method to determine how to sort data (ascending by last name)
    @Override
    public int compareTo(Person person) {
        int primary = lastName.compareTo(person.lastName);
        return primary != 0 ? primary
                : lastName.compareTo(person.lastName);
    }

    // This method is used in PersonComparatorInverseBirthYear
    // We have to get the birth year to sort it descending
    public int getBirthYear() { return birthYear; }
}
