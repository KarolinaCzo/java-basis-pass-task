package task.model;

import java.io.*;
import java.util.*;

public class PersonsData {
    private ArrayList<Person> data;

    public PersonsData(ArrayList<Person> data) {
        this.data = data;
    }

    public void manageData() {
        // Using Scanner to get input from user
        Scanner input = new Scanner(System.in);

        // User input
        int userInput = -1;

        // Available actions
        System.out.println("Available actions \n" +
                "0 - exit \n" +
                "1 - show data from file \n" +
                "2 - sort data by last name (ascending) \n" +
                "3 - sort data by birth year (descending) \n" +
                "4 - add data to file \n");
        System.out.println("Please provide one of the numbers above: \n");

        while (userInput != 0) {
            try {
                userInput = input.nextInt();

                switch (userInput) {
                    case 0:
                        System.out.println("Bye");
                        break;
                    case 1:
                        // After overriding the toString method in Person class,
                        // here we can just print the data to the console
                        System.out.println("Data from file:");
                        data.forEach(System.out::println);
                        chooseNext();
                        break;
                    case 2:
                        // Create a copy of the original data (sortedData) to not alter the original array after sorting
                        ArrayList<Person> sortedByLastName = new ArrayList<>(data);
                        Collections.sort(sortedByLastName);
                        System.out.println("Data sorted by last name, ascending:");
                        sortedByLastName.forEach(System.out::println);
                        chooseNext();
                        break;
                    case 3:
                        // Create a copy of the original data (sortedData) to not alter the original array after sorting
                        ArrayList<Person> sortedByYear = new ArrayList<>(data);
                        // Created a custom comparator to sort data by birth year
                        Collections.sort(sortedByYear, new PersonComparatorInverseBirthYear());
                        System.out.println("Data sorted by birth year, descending: ");
                        sortedByYear.forEach(System.out::println);
                        chooseNext();
                        break;
                    case 4:
                        addData();
                        chooseNext();
                        break;
                    default:
                        System.out.println("Option " + userInput + " is not available. " + "Please choose one of the following: \n" +
                                "0 - exit \n" +
                                "1 - show data from file \n" +
                                "2 - sort data by last name (ascending) \n" +
                                "3 - sort data by birth year (descending) \n" +
                                "4 - add data to file \n");
                }
            } catch (Exception exception){
                System.out.println("Invalid input. Please provide a number: \n");
                input.next();
            }
        }
    }

    public void chooseNext() {
        System.out.println("\n Choose next action \n" +
                "0 - exit \n" +
                "1 - show data from file \n" +
                "2 - sort data by last name (ascending) \n" +
                "3 - sort data by birth year (descending) \n" +
                "4 - add data to file \n");
    }

    public void addData() {
        String line = "";
        System.out.println("Please provide new person data.");

        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter first name: ");
            String newFirstName = input.next();
            System.out.println("Enter last name: ");
            String newLastName = input.next();
            System.out.println("Enter birth year: ");
            int newBirthYear = input.nextInt();
            System.out.println("Enter PESEL: ");
            long newPesel= input.nextLong();

            String newPerson = newFirstName +","+ newLastName +","+ newBirthYear +","+ newPesel;

            BufferedReader reader = new BufferedReader(new FileReader("data.csv"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("newData.csv")));
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.write(newPerson);
            writer.newLine();
            writer.close();
            reader.close();
        } catch (InputMismatchException ime) {
            System.err.println("Invalid input");
        } catch (FileNotFoundException fnfe) {
            System.err.println("An attempt to open the file denoted by a specified pathname has failed");
        } catch (IOException ioe) {
            System.err.println("I/O error occurred while altering file");
        } finally {
            System.out.println("Created new file: newData.csv");
            System.out.println("If no errors occurred, file should store new person data.");
        }
    }

}
