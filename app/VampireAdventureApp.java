package app;

import java.util.Scanner;

/**
 * @author profMajuntke, lucaslar
 */
public class VampireAdventureApp {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * The main method is the entry point of the application. It displays an ASCII art bat,
     * shows the menu, and processes user input in an infinite loop.
     *
     * @param args command line arguments (not used)
     *
     */
    public static void main(String[] args) {
        showBat();
        while (true) {
            showMenu();
            int choice = readUserInput();
            handle(choice);
            System.out.println("====================");
        }
    }

    /**
     * Reads user input from the console and returns the chosen menu option.
     *
     * @return the menu option chosen by the user
     */
    private static int readUserInput() {
        System.out.print("\nBitte, geben Sie die Nummer des gewaehlten Menueeintrags ein:\t");
        int choiceInternal = scanner.nextInt();
        return choiceInternal;
    }

    /**
     * Handles the user's menu choice and executes the corresponding action.
     *
     * @param choice the menu option chosen by the user
     */
    private static void handle(int choice) {
        switch (choice) {
            case 1:
                createVampire();
                break;
            case 2:
                break;
            case 3:
                break;
            default: {
                System.out.println("Ungueltige Eingabe. Bitte ueberpruefen Sie Ihre Eingabe");
            }
            break;
        }
    }

    /**
     *Displays the main menu with options to create, display, or remove a vampire.
     */
    private static void showMenu() {
        System.out.println("\n======= Vampire Adventure 1.0 =======\n");

        final String[] menuItems = {
                "(1)\t Vampir anlegen",
                "(2)\t Vampirdaten anzeigen",
                "(3)\t Vampir entfernen"
        };
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
    }

    private static void showBat() {
        //This ASCII pic can be found at
        //https://asciiart.website/index.php?art=animals/bats
        System.out.println("   __       __   ____       ____");
        System.out.println("   ) \\     / (   )   \\     /   (");
        System.out.println("  )_  \\_V_/  _(   )_  \\_V_/  _(");
        System.out.println("    )__   __(       )__   __(             cjr");
        System.out.println("       `-'             `-'");
    }

    /**
     *Placeholder method for creating a new vampire.
     *Prints out a message indicating where the vampire creation logic should go.
     */
    private static void createVampire() {
        System.out.println("\nLeider hat diese Methode noch keinen Code ... aber Du kannst sicher nachvollziehen, wie der Ablauf ist. Hier soll ein neuer Vampir angelegt werden.\n");
    }
}
