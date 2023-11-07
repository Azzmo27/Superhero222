package org.example;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    Database database = new Database();
    Controller controller = new Controller(database);
    Scanner scanner = new Scanner(System.in);


    public void StartProgram() {
        boolean exitProgram = false;
        while (!exitProgram) {
            System.out.println("Menu ");
            System.out.println("1. Add superhero");
            System.out.println("2. Remove Superhero");
            System.out.println("3. Vis liste over superhelte");
            System.out.println("4. Vis superhelt");
            System.out.println("5. Vis alle superhelte sorteret");
            System.out.println("6. Edit superhero");
            System.out.println("7. Create Superhero");
            System.out.println("8. Afslut programmet");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Write in the real name: ");
                        String name = scanner.nextLine();
                        System.out.println("Write in your superhero name: ");
                        String superheroName = scanner.nextLine();
                        System.out.println("Write in superpower: ");
                        String superpower = scanner.nextLine();
                        System.out.println("Write in year of creation: ");
                        int yearCreated = scanner.nextInt();
                        boolean isHuman;
                        do {
                            System.out.print("Is your superhero human? (Yes/No): ");
                            String isHumanInput = scanner.nextLine().toLowerCase();
                            if (isHumanInput.equals("Yes")) {
                                isHuman = true;
                                break;
                            } else if (isHumanInput.equals("No")) {
                                isHuman = false;
                                break;
                            } else {
                                System.out.println("Invalid answar. Write either 'Yes' or  'no'.");
                            }
                        } while (true);
                        System.out.println("How strong is your superhero? ");
                        int strength = scanner.nextInt();
                        controller.addSuperhero(name, superheroName, superpower, yearCreated, isHuman, strength);
                        System.out.println("The superhero is added to the database.");
                        break;
                    case 2:
                        System.out.println("Write in the name of the superhero that you would like to delete");
                        database.showSuperheroes();
                        String superName = scanner.nextLine();
                        database.removeSuperhero(superName);
                        break;
                    case 3:
                        database.showSuperheroes();
                        break;
                    case 4:
                        database.searchSuperhero();
                        break;
                    case 5:
                        //
                    case 6:
                        database.editSuperhero();
                        break;
                    case 7:
                        database.CreateSuperhero();
                        break;
                    case 8:
                        System.out.println("Goodbye!");
                        exitProgram = true; // Afslut programmet
                        break;
                    default:
                        System.out.println("Invalid choice. Try again ...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Type in a valid værdi.");
                scanner.nextLine();
            } catch (DateTimeParseException e) {
                System.out.println("Error: wrong formation. Use only YYYY.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An error has occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }}