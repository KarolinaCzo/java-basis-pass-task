package task;

import task.model.Person;
import task.model.PersonsData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Helpful links:
// https://www.computerhope.com/issues/ch001356.htm
// https://www.javatpoint.com/how-to-read-csv-file-in-java
// https://stackoverflow.com/a/5585800
// https://stackoverflow.com/a/9307771
// https://stackoverflow.com/questions/8469882/reading-multiple-scanner-inputs

public class Main {

    public static void main(String[] args) {
        String line = "";
        String splitBy = ",";
        ArrayList<Person> persons = new ArrayList<>();

        // Parsing a CSV file into BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader("data.csv"))) {
            // 'while' returns a boolean value
            while ((line = reader.readLine()) != null) {
                String[] person = line.split(splitBy); // Use comma as separator
                // Add each Person to persons array list
                persons.add(new Person(person[0], person[1], Integer.parseInt(person[2]), Long.parseLong(person[3])));
            }
        // Handling of all exceptions
        // Exception names from the first letters of the exception full name
        } catch (FileNotFoundException fnfe) {
            System.err.println("An attempt to open the file denoted by a specified pathname has failed");
        } catch (NumberFormatException nfe) {
            System.err.println("Error occurred while parsing birth date or pesel");
        } catch (IOException ioe) {
            System.err.println("I/O error occurred while performing readLine()");
        }

        PersonsData fileData = new PersonsData(persons);
        // Run available actions
        fileData.manageData();
    }

}
