package task.model;

import java.util.Comparator;

public class PersonComparatorInverseBirthYear implements Comparator<Person> {
    @Override
    public int compare(Person person, Person otherPerson) {
        if(person.getBirthYear() > otherPerson.getBirthYear()) {
            return -1;
        } else if(person.getBirthYear() == otherPerson.getBirthYear()) {
            return 0;
        } else {
            return 1;
        }
    }
}
