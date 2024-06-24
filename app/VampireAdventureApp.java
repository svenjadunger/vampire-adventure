package app;

import java.util.Scanner;
import java.util.Random;
import model.Vampire;

/**
 * @author profMajuntke, lucaslar
 * VampireAdventureApp ist das Hauptprogramm, das ein Menü anzeigt, in dem man einen Vampir erstellen,
 * die Daten anzeigen, den Vampir löschen und ein Abenteuer starten kann.
 */
public class VampireAdventureApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Vampire aktuellerVampir;
    private static Random random = new Random();


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
        scanner.nextLine();
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
                showVampireData();
                break;
            case 3:
                deleteVampire();
                break;
            case 4:
                startAdventure();
                break;
            case 5:
                exitGame();
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
            "(3)\t Vampir entfernen",
            "(4)\t Abenteuer starten",
            "(5)\t Beenden"
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

    private static void createVampire() {
        System.out.print("Geben Sie den Namen des Vampirs ein: ");
        String name = scanner.nextLine();
        System.out.print("Geben Sie das Alter des Vampirs ein: ");
        int alter = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Geben Sie die Blutgruppe des Vampirs ein: ");
        String blutgruppe = scanner.nextLine();

        aktuellerVampir = new Vampire(name, alter, blutgruppe);
        System.out.println("\nVampir erfolgreich erstellt!\n");
    }

    private static void showVampireData() {
        if (aktuellerVampir == null) {
            System.out.println("\nEs gibt keinen Vampir, den man anzeigen kann.\n");
        } else {
            System.out.println("\n" + aktuellerVampir + "\n");
        }
    }

    private static void deleteVampire() {
        if (aktuellerVampir == null) {
            System.out.println("\nEs gibt keinen Vampir, den man löschen kann.\n");
        } else {
            aktuellerVampir = null;
            System.out.println("\nVampir erfolgreich gelöscht!\n");
        }
    }

    private static void startAdventure() {
        if (aktuellerVampir == null) {
            System.out.println("\nEs gibt keinen Vampir, mit dem man ein Abenteuer starten kann.\n");
            return;
        }

        for (int round = 1; round <= 12; round ++) {
        System.out.println("\nRise vampires, the sun has gone down and there is lots that needs to be done. \nTime is running: Round 1");
            
            int event = random.nextInt(100) + 1;
            if (event <= 60) {
                meetHuman();
            } else if (event <= 80) {
                meetDemon();
            } else if (event <= 90) {
                meetVampireHunter();
            } else {
                System.out.println("\nNichts passiert.\n");
            }
    aktuellerVampir.setHunger(aktuellerVampir.getHunger() + 1);
    if (aktuellerVampir.getHunger() >= 5) {
        System.out.println("Der Vampir hat zu viel hunger und ist gestorben.");
        aktuellerVampir = null;
        return;
    }
    aktuellerVampir.setEnergy(aktuellerVampir.getEnergy() + 10);
    }

    }
    private static void meetHuman() {
        System.out.println("\nDu begegnest einem Menschen. Was möchtest du tun?");
        System.out.println("1. Mensch angreifen");
        System.out.println("2. Nichts tun");
        
        int choice = readUserInput();
        if (choice == 1) {
        System.out.print("Wie viel Blut möchtest du trinken (0-6 Liter)? ");
        double bloodAmount = scanner.nextDouble();
        scanner.nextLine(); 
        aktuellerVampir.drinkBlood(bloodAmount);
        System.out.println("Du hast " + bloodAmount + " Liter Blut getrunken.");
        } else {
        System.out.println("Du hast den Menschen in Ruhe gelassen.");
        }
        }
        
        private static void meetDemon() {
        System.out.println("\nEin Dämon erscheint. Er fordert dich zu einem Rätsel heraus.");
       
        }
        
        private static void meetVampireHunter() {
        System.out.println("\nEin Vampirjäger kreuzt deinen Weg. Deine Zeit ist gekommen...");
        System.out.println("1. Fliehen");
        System.out.println("2. Kämpfen");
        
        int choice = readUserInput();
        if (choice == 1) {
        boolean success = aktuellerVampir.flee();
        if (success) {
        System.out.println("Du konntest erfolgreich fliehen.");
        } else {
        System.out.println("Fluchtversuch gescheitert. Du musst kämpfen.");
        fightVampireHunter();
        }
        } else {
        fightVampireHunter();
        }
        }
        
        private static void fightVampireHunter() {
        System.out.println("Kampf beginnt...");
        aktuellerVampir.takeDamage(5);
        if (aktuellerVampir.isFinallyDead()) {
        System.out.println("Der Vampirjäger hat dich besiegt. Spiel vorbei.");
        aktuellerVampir = null;
        } else {
        System.out.println("Du hast den Vampirjäger besiegt.");
        }
        }        

    private static void exitGame() {
        System.out.println("\nSpiel wird beendet. Auf Wiedersehen!\n");
        System.exit(0);
    }

}
