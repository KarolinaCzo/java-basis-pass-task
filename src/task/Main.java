package task;

import task.model.Person;
import task.model.PersonsData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String line = "";
        String splitBy = ",";
        ArrayList<Person> persons = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("data.csv"))) {
            while ((line = reader.readLine()) != null) {
                String[] person = line.split(splitBy);
                persons.add(new Person(person[0], person[1], Integer.parseInt(person[2]), Long.parseLong(person[3])));
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("An attempt to open the file denoted by a specified pathname has failed");
        } catch (NumberFormatException nfe) {
            System.err.println("Error occurred while parsing birth date or pesel");
        } catch (IOException ioe) {
            System.err.println("I/O error occurred while performing readLine()");
        }

        PersonsData fileData = new PersonsData(persons);

        fileData.manageData();
    }

}
