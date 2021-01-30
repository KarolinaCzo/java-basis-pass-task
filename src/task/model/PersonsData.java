package task.model;

import java.io.*;
import java.util.*;

public class PersonsData {
    private ArrayList<Person> data;

    public PersonsData(ArrayList<Person> data) {
        this.data = data;
    }

    public void manageData() {
        Scanner input = new Scanner(System.in);

        int userInput = -1;

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
                        System.out.println("Data from file:");
                        data.forEach(System.out::println);
                        chooseNext();
                        break;
                    case 2:
                        ArrayList<Person> sortedByLastName = new ArrayList<>(data);
                        Collections.sort(sortedByLastName);
                        System.out.println("Data sorted by last name, ascending:");
                        sortedByLastName.forEach(System.out::println);
                        chooseNext();
                        break;
                    case 3:
                        ArrayList<Person> sortedByYear = new ArrayList<>(data);
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

            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data.csv"), true));
            writer.write(newPerson);
            writer.newLine();
            writer.close();
        } catch (InputMismatchException ime) {
            System.err.println("Invalid input");
        } catch (FileNotFoundException fnfe) {
            System.err.println("An attempt to open the file denoted by a specified pathname has failed");
        } catch (IOException ioe) {
            System.err.println("I/O error occurred while altering file");
        } finally {
            System.out.println("If no errors occurred, file data.csv should store new person data.");
        }
    }

}
