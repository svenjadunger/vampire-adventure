package app;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import model.Vampire;
import model.VampireHunter;


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
            int choice = readMenuChoice();
            if (choice == 0) { // Wahl für den Test der Ereignisverteilung
                testEventDistribution();
            } else {
                handle(choice);
            }
            System.out.println("====================");
        }
    }



/**
     * Methode zur Überprüfung der Verteilung der Ereignisse
     */
    public static void testEventDistribution() {
        int humanCount = 0;
        int demonCount = 0;
        int hunterCount = 0;
        int nothingCount = 0;

        for (int i = 0; i < 1000; i++) {
            int event = random.nextInt(100) + 1;
            if (event <= 60) {
                humanCount++;
            } else if (event <= 80) {
                demonCount++;
            } else if (event <= 90) {
                hunterCount++;
            } else {
                nothingCount++;
            }
        }

        System.out.println("Menschen: " + humanCount);
        System.out.println("Dämonen: " + demonCount);
        System.out.println("VampireHunter: " + hunterCount);
        System.out.println("Nichts passiert: " + nothingCount);
    }




/**
     * Reads user input for the main menu and returns the chosen menu option.
     *
     * @return the menu option chosen by the user
     */
    private static int readMenuChoice() {
        int choiceInternal = -1;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("\nBitte, geben Sie die Nummer des gewaehlten Menueeintrags ein (1-5):\t");
            try {
                choiceInternal = scanner.nextInt();
                scanner.nextLine();
                if (choiceInternal >= 1 && choiceInternal <= 5) {
                    validInput = true;
                } else {
                    System.out.println("Ungueltige Eingabe. Bitte geben Sie eine Zahl zwischen 1 und 5 ein.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungueltige Eingabe. Bitte geben Sie eine Zahl zwischen 1 und 5 ein.");
                scanner.nextLine(); // Konsumiere die ungültige Eingabe
            }
        }
        return choiceInternal;
    }


    /**
     * Reads user input from the console and returns the chosen menu option.
     *
     * @return the menu option chosen by the user
     */
    private static int readUserInput(int min, int max) {
        int choiceInternal = -1;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("\nBitte, geben Sie die Nummer des gewaehlten Menueeintrags ein (" + min + "-" + max + "):\t");
            try {
                choiceInternal = scanner.nextInt();
                scanner.nextLine();
                if (choiceInternal >= min && choiceInternal <= max) {
                    validInput = true;
                } else {
                    System.out.println("Ungueltige Eingabe. Bitte geben Sie eine Zahl zwischen " + min + " und " + max + " ein.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungueltige Eingabe. Bitte geben Sie eine Zahl zwischen " + min + " und " + max + " ein.");
                scanner.nextLine(); // Konsumiere die ungültige Eingabe
            }
        }
        return choiceInternal;
    }
    

/**
     * Reads user input from the console and returns the user's answer for a task.
     *
     * @return the user's answer as an integer
     */
    private static int readUserAnswer() {
        int answer = -1;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Deine Antwort: ");
            try {
                answer = scanner.nextInt();
                scanner.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ungueltige Eingabe. Bitte geben Sie eine gültige Zahl ein.");
                scanner.nextLine(); // Konsumiere die ungültige Eingabe
            }
        }
        return answer;
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
       
        System.out.println("   __       __   ____       ____");
        System.out.println("   ) \\     / (   )   \\     /   (");
        System.out.println("  )_  \\_V_/  _(   )_  \\_V_/  _(");
        System.out.println("    )__   __(       )__   __(             cjr");
        System.out.println("       `-'             `-'");
    }

 /**
 * Erstellt einen neuen Vampir und speichert ihn in der Variable 'aktuellerVampir'.
 * Fordert den Benutzer zur Eingabe des Namens, des Alters und der Blutgruppe des Vampirs auf.
 */
/**
 * Erstellt einen neuen Vampir und speichert ihn in der Variable 'aktuellerVampir'.
 * Fordert den Benutzer zur Eingabe des Namens, des Alters und der Blutgruppe des Vampirs auf.
 */
private static void createVampire() {
    String name = "";
    while (name.isEmpty() || name.matches("\\d+")) {
        System.out.print("Geben Sie den Namen des Vampirs ein: ");
        name = scanner.nextLine();
        if (name.isEmpty() || name.matches("\\d+")) {
            System.out.println("Ungueltige Eingabe. Der Name darf nicht leer sein und keine Zahlen enthalten.");
        }
    }

    int alter = -1;
    while (alter < 0) {
        System.out.print("Geben Sie das Alter des Vampirs ein: ");
        try {
            alter = scanner.nextInt();
            scanner.nextLine();
            if (alter < 0) {
                System.out.println("Ungueltige Eingabe. Bitte geben Sie eine positive Zahl ein.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ungueltige Eingabe. Bitte geben Sie eine gültige Zahl ein.");
            scanner.nextLine(); // Konsumiere die ungültige Eingabe
        }
    }

    System.out.print("Geben Sie die Blutgruppe des Vampirs ein: ");
    String blutgruppe = scanner.nextLine();

    aktuellerVampir = new Vampire(name, alter, blutgruppe);
    System.out.println("\nVampir erfolgreich erstellt!\n");
}

    /**
    * Zeigt die Daten des aktuellen Vampirs an, wenn einer existiert.
    * Gibt eine Nachricht aus, falls kein Vampir existiert.
    */
    private static void showVampireData() {
        if (aktuellerVampir == null) {
            System.out.println("\nEs gibt keinen Vampir, den man anzeigen kann.\n");
        } else {
            System.out.println("\n" + aktuellerVampir + "\n");
        }
    }

    /**
    * Löscht den aktuellen Vampir, falls einer existiert.
    * Gibt eine Nachricht aus, falls kein Vampir existiert.
    */
    private static void deleteVampire() {
        if (aktuellerVampir == null) {
            System.out.println("\nEs gibt keinen Vampir, den man löschen kann.\n");
        } else {
            aktuellerVampir = null;
            System.out.println("\nVampir erfolgreich gelöscht!\n");
        }
    }

    /**
    * Startet ein Abenteuer mit dem aktuellen Vampir.
    * Wenn kein Vampir existiert, wird eine entsprechende Nachricht ausgegeben.
    * In jedem Durchgang wird ein zufälliges Ereignis ausgelöst und der Hunger sowie die Energie des Vampirs angepasst.
    */
    private static void startAdventure() {
        if (aktuellerVampir == null) {
            System.out.println("\nEs gibt keinen Vampir, mit dem man ein Abenteuer starten kann.\n");
            return;
        }
    
        for (int round = 1; round <= 12; round++) {
            System.out.println("\nRise vampires, the sun has gone down and there is lots that needs to be done. \nTime is running: Round " + round);
            
            int event = random.nextInt(100) + 1;
            if (event <= 60) {
                meetHuman();
            } else if (event <= 80) {
                meetDemon();
            } else if (event <= 90) {
                meetVampireHunter();
            } else if (round == 12) { // Am Ende der Nacht den größten Vampirjäger treffen
                System.out.println("\nDer größte Vampirjäger des Jahrhunderts taucht auf!\n");
                fightGreatestVampireHunter(new VampireHunter("Größter Vampirjäger", 100));
                return; // Beenden das Abenteuer nach Kampf
            } else {
                System.out.println("\nNichts passiert.\n");
            }
            aktuellerVampir.setHunger(aktuellerVampir.getHunger() + 1);
            if (aktuellerVampir.getHunger() >= 5) {
                System.out.println("Der Vampir hat zu viel hunger und ist gestorben.");
                aktuellerVampir = null;
                System.out.println("Spiel vorbei.");
                return;
            }
            aktuellerVampir.setEnergy(aktuellerVampir.getEnergy() + 10);
        }
        System.out.println("Das Abenteuer ist zu Ende. Die Nacht bricht an.");
    }

    /**
    * Begegnung mit einem Menschen. Der Benutzer kann entscheiden, ob er den Menschen angreift oder nicht.
    * Wenn der Benutzer den Menschen angreift, kann er eine bestimmte Menge Blut trinken.
    */
    

    private static void meetHuman() {
        System.out.println("\nDu begegnest einem Menschen. Was möchtest du tun?");
        System.out.println("1. Mensch angreifen");
        System.out.println("2. Nichts tun");
        
        
    int choice = readUserInput(1, 2);
        if (choice == 1) {
            double bloodAmount = -1;
            while (bloodAmount < 0 || bloodAmount > 6) {
                System.out.print("Wie viel Blut möchtest du trinken (0-6 Liter)? ");
                try {
                    bloodAmount = scanner.nextDouble();
                    scanner.nextLine();
                    if (bloodAmount < 0 || bloodAmount > 6) {
                        System.out.println("Ungueltige Menge. Bitte geben Sie eine Menge zwischen 0 und 6 Litern ein.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ungueltige Eingabe. Bitte geben Sie eine gültige Zahl ein.");
                    scanner.nextLine();
                }
            }
            aktuellerVampir.drinkBlood(bloodAmount);
            System.out.println("Du hast " + bloodAmount + " Liter Blut getrunken.");
        } else {
            System.out.println("Du hast den Menschen in Ruhe gelassen.");
        }
    }



/**
 * Begegnung mit einem Dämon. Der Spieler kann mit dem Dämon sprechen oder sich entfernen.
 */
private static void meetDemon() {
    System.out.println("\n\"One of the great demons appears from the shadows...\"");
    System.out.println("Was möchtest du tun?");
    System.out.println("1. Mit dem Dämon sprechen");
    System.out.println("2. Weggehen");

    
    int choice = readUserInput(1, 2);
    if (choice == 1) {
        System.out.println("\nDer Dämon erzählt dir seine Geschichte.");
        System.out.println("Der Dämon fragt: \"Bist du bereit, eine Aufgabe zu erfüllen?\"");
        System.out.println("1. Ja");
        System.out.println("2. Nein");

        int taskChoice = readUserInput(1,2);
        if (taskChoice == 1) {
            System.out.println("\nDer Dämon gibt dir eine Aufgabe:");
            System.out.println("1. Zähle die Sequenz 'tam'");
            System.out.println("2. Biss-Kralle-Knoblauch");
            System.out.println("3. Rückwärts-Wörter");
            int taskSelection = readUserInput(1,3);
            switch (taskSelection) {
                case 1:
                    countStringsTask();
                    break;
                case 2:
                    biteClawGarlic();
                    break;
                case 3:
                    reverseWordsTask();
                    break;
                default:
                    System.out.println("Ungueltige Eingabe. Der Dämon verschwindet.");
            }
        } else {
            System.out.println("\nDu hast die Aufgabe abgelehnt. Der Dämon verschwindet.");
        }
    } else {
        System.out.println("\nDu gehst weg und der Dämon verschwindet im Nebel.");
    }
}



/**
 * Aufgabe, bei der man innerhalb von 30 Sekunden folgende Wörter rückwarts korrekt eingeben muss
 */
private static void reverseWordsTask() {
    System.out.println("\nDer Dämon stellt dir eine Aufgabe: Gebe die folgenden Wörter rückwärts ein.");
    
    String[] words = {"Sonne", "Mond", "Sterne", "Vampir", "Blut", "Nacht", "Jäger", "Kampf", "Dunkel", "Schloss"};
    Random random = new Random();
    String[] selectedWords = new String[3];
    for (int i = 0; i < 3; i++) {
        selectedWords[i] = words[random.nextInt(words.length)]; //zufällig zw 0-9
    }

    for (String word : selectedWords) {
        System.out.println("Wort: " + word);
    }

    // Starte die Zeitmessung
    long startTime = System.currentTimeMillis(); //millisekunden

    System.out.println("Du hast 30 Sekunden, um die Wörter rückwärts einzugeben.");
    String[] reversedWords = new String[3];
    for (int i = 0; i < 3; i++) {
        System.out.print("Rückwärts-Eingabe: ");
        reversedWords[i] = scanner.nextLine();
    }

    // Zeitmessung beenden
    long endTime = System.currentTimeMillis();
    long timeTaken = (endTime - startTime) / 1000; //sekunden

    boolean allCorrect = true;
    for (int i = 0; i < 3; i++) {
        if (!new StringBuilder(selectedWords[i]).reverse().toString().equals(reversedWords[i])) {
            allCorrect = false;
            break;
        }
    } //stringbuilder(zeichen ändern) objekt enthält selectedwords, umkehren,tostring verwandelt,vergleich umgekehrte wörter

    if (timeTaken > 30) {
        System.out.println("Zeit abgelaufen! Du hast " + timeTaken + " Sekunden gebraucht.");
    } else if (allCorrect) {
        System.out.println("Richtig! Du hast die Aufgabe in " + timeTaken + " Sekunden gelöst.");
        aktuellerVampir.setTransparency(true);
    } else {
        System.out.println("Falsch! Du hast mindestens ein Wort nicht korrekt rückwärts eingegeben.");
    }
}




    /**
    *Begegnung mit einem Vampirjäger. Der Benutzer kann entscheiden, ob er flieht oder kämpft.
    *Wenn der Fluchtversuch scheitert, muss der Benutzer kämpfen.
    */
    private static void meetVampireHunter() {
        System.out.println("\nEin Vampirjäger kreuzt deinen Weg. Deine Zeit ist gekommen...");
        System.out.println("1. Fliehen");
        System.out.println("2. Kämpfen");
        
        int choice = readUserInput(1,2);
        VampireHunter vampireHunter = new VampireHunter("Hunter", 30); 
        if (choice == 1) {
            boolean success = aktuellerVampir.flee();
            if (success) {
                System.out.println("Du konntest erfolgreich fliehen.");
            } else {
                System.out.println("Fluchtversuch gescheitert. Du musst kämpfen.");
                fightVampireHunter(vampireHunter);
            }
        } else {
            fightVampireHunter(vampireHunter);
        }
    }
      
    /**
    *Kampf mit einem Vampirjäger. Der Vampir nimmt Schaden und kann sterben, falls er zu viel Schaden nimmt.
    *Wenn der Vampirjäger besiegt wird, wird eine entsprechende Nachricht ausgegeben.
    */
    private static void fightVampireHunter(VampireHunter vampireHunter) {
        System.out.println("Kampf beginnt...");
        // angriff und schaden wird zurückgegeben, pbjekt wird reduziert um lebenspunkte
        aktuellerVampir.takeDamage(vampireHunter.attack(aktuellerVampir));
        if (aktuellerVampir.isFinallyDead()) {
            System.out.println("Der Vampirjäger hat dich besiegt. Spiel vorbei.");
            aktuellerVampir = null;
        } else {
            vampireHunter.takeDamage(aktuellerVampir.attack(vampireHunter));
            if (!vampireHunter.isAlive()) {
                System.out.println("Du hast den Vampirjäger besiegt.");
            } else {
                System.out.println("Der Kampf geht weiter...");
            }
        }
    }
    
    private static void fightGreatestVampireHunter(VampireHunter vampireHunter) {
        System.out.println("Der entscheidende Kampf beginnt...");
        while (aktuellerVampir != null && vampireHunter.isAlive()) {
            System.out.println("\nDer Vampirjäger greift an.");
            //vampirejäger greift vampir an und vampir nimmt schaden
            aktuellerVampir.takeDamage(vampireHunter.attack(aktuellerVampir));
            if (aktuellerVampir.isFinallyDead()) {
                System.out.println("Der größte Vampirjäger hat dich besiegt. Spiel vorbei.");
                aktuellerVampir = null;
                System.exit(0);
            } else {
                System.out.println("Deine Energie: " + aktuellerVampir.getEnergy());
                System.out.println("Energie des Vampirjägers: " + vampireHunter.getEnergy());
                System.out.println("1. Angreifen");
                System.out.println("2. Fliehen");
    
                int choice = readUserInput(1, 2);
                if (choice == 1) {
                    vampireHunter.takeDamage(aktuellerVampir.attack(vampireHunter));
                    if (!vampireHunter.isAlive()) {
                        System.out.println("Herzlichen Glückwunsch! Du hast den größten Vampirjäger des Jahrhunderts besiegt und das Spiel gewonnen!");
                        System.exit(0);
                    }
                } else {
                    boolean success = aktuellerVampir.flee();
                    if (success) {
                        System.out.println("Du konntest erfolgreich fliehen.");
                        return; // Beenden des Kampfes
                    } else {
                        System.out.println("Fluchtversuch gescheitert. Du musst weiter kämpfen.");
                    }
                }
            }
        }
    }
    
    
 /**
 * Fügt die `CountStrings`-Aufgabe hinzu. Der Spieler muss die Anzahl der "tam"-Sequenzen in einem zufälligen
 * String innerhalb einer bestimmten Zeitspanne zählen.
 */
private static void countStringsTask() {
    System.out.println("\nDer Dämon stellt dir eine weitere Aufgabe.");
    System.out.println("Zähle, wie oft die Sequenz 'tam' in dem folgenden String vorkommt:");

    String characters = "tamrex";
    String generatedString = "";
    Random random = new Random();

    // Generiert einen zufälligen String mit "tam" und "rex"
    for (int i = 0; i < 50; i++) {
        generatedString += characters.charAt(random.nextInt(characters.length()));
    }

    System.out.println("String: " + generatedString);

    // Starte die Zeitmessung
    long startTime = System.currentTimeMillis();

    // Der Spieler hat 20 Sekunden Zeit
    System.out.println("Du hast 20 Sekunden, um die Anzahl der 'tam'-Sequenzen zu zählen und einzugeben.");

    int playerAnswer = readUserAnswer();

    // Zeitmessung beenden
    long endTime = System.currentTimeMillis();
    long timeTaken = (endTime - startTime) / 1000;

    int correctAnswer = countOccurrences(generatedString, "tam");

    if (timeTaken > 20) {
        System.out.println("Zeit abgelaufen! Du hast " + timeTaken + " Sekunden gebraucht.");
    } else if (playerAnswer == correctAnswer) {
        System.out.println("Richtig! Du hast die Aufgabe in " + timeTaken + " Sekunden gelöst.");
        // Belohnung für die richtige Antwort
        aktuellerVampir.setDoublePower(true);
    } else {
        System.out.println("Falsch! Die richtige Antwort war " + correctAnswer + ".");
    }
}

/**
 * Zählt die Vorkommen eines Substrings in einem String.
 *
 * @param str der zu durchsuchende String
 * @param sub der zu zählende Substring
 * @return die Anzahl der Vorkommen des Substrings
 */
private static int countOccurrences(String str, String sub) {
    int count = 0;
    int idx = 0;

    while ((idx = str.indexOf(sub, idx)) != -1) {
        count++;
        idx += sub.length();
    }
    return count;
}

/**
 * Fügt die `Bite-Claw-Garlic`-Aufgabe hinzu. Der Spieler muss zwischen Biss, Kralle und Knoblauch wählen,
 * und der Computer trifft eine zufällige Wahl. Die Gewinnerin wird gemäß den Spielregeln bestimmt.
 */
private static void biteClawGarlic() {
    System.out.println("\nDer Dämon fordert dich zu einer Runde Biss-Kralle-Knoblauch heraus.");
    System.out.println("Wähle eine Option:");
    System.out.println("1. Biss");
    System.out.println("2. Kralle");
    System.out.println("3. Knoblauch");

    int playerChoice = readUserInput(1,3);
    String[] choices = {"Biss", "Kralle", "Knoblauch"};
    // playerChoice = 1 entspricht choices[0] (also "Biss").
    String playerMove = choices[playerChoice - 1];
    String computerMove = choices[new Random().nextInt(choices.length)];

    System.out.println("Du hast " + playerMove + " gewählt.");
    System.out.println("Der Computer hat " + computerMove + " gewählt.");

    if (playerMove.equals(computerMove)) {
        System.out.println("Unentschieden! Niemand gewinnt.");
    } else if ((playerMove.equals("Biss") && computerMove.equals("Kralle")) ||
               (playerMove.equals("Kralle") && computerMove.equals("Knoblauch")) ||
               (playerMove.equals("Knoblauch") && computerMove.equals("Biss"))) {
        System.out.println("Du gewinnst! Du erhältst die Fähigkeit 'Transparency'.");
        aktuellerVampir.setTransparency(true);
    } else {
        System.out.println("Der Computer gewinnt! Du verlierst diese Runde.");
    }
}






    /**
    *Beendet das Spiel und gibt eine Abschiedsnachricht aus.
    */
    private static void exitGame() {
        System.out.println("\nSpiel wird beendet. Auf Wiedersehen!\n");
        System.exit(0);
    }

}
