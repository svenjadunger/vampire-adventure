package app;

import java.util.InputMismatchException; // Import für Eingabe-Fehlerbehandlung, z.B. Wort statt Zahl
import java.util.Scanner;
import java.util.Random;
import model.Vampire;
import model.VampireHunter;


/**
 * @author profMajuntke, lucaslar
 * VampireAdventureApp ist das Hauptprogramm, das ein Menü anzeigt, in dem man einen Vampir erstellen,
 * die Daten anzeigen, den Vampir löschen und ein Abenteuer starten kann.
 */
//Hauptklasse 
public class VampireAdventureApp {
    //um Benutzereingaben zu lesen
    private static Scanner scanner = new Scanner(System.in);
    //private statische Variable, die eine Instanz der Klasse Vampir speichert
    private static Vampire aktuellerVampir;
    private static Random random = new Random();


    public static void main(String[] args) {
        showBat();
        //Endlosschleife, Hauptmenü wird immer wieder gezeigt bis Programm beendet 
        while (true) {
            showMenu();
            //lest Zahlen und speichert in choice
            int choice = readMenuChoice();
            if (choice == 0) { // wenn 0, dann aufrufen von testEventDistrubution 
                // Funktion zur Zufallsereignisverteilung 
                testEventDistribution();
            } else {
                // wenn nicht 0, dann Aufruf handle vererbeitung von Wahl des Benutzers
                handle(choice);
            }
            System.out.println("====================");
        }
    }



/**
     * Methode zur Überprüfung der Verteilung der Ereignisse
     */
    public static void testEventDistribution() {
        // zählt, wie oft ein Mensch getroffen wird
        int humanCount = 0;
        int demonCount = 0;
        int hunterCount = 0;
        // zählt, wie oft nichts passiert
        int nothingCount = 0;

        // 1000 höhere Genauigkeit
        for (int i = 0; i < 1000; i++) {
            //zufälliger Wert zwischen 1 und 100 generiert 
            int event = random.nextInt(100) + 1;
            if (event <= 60) {
                humanCount++;
                //20% Demon
            } else if (event <= 80) {
                demonCount++;
                // 10% Vampirjäger 
            } else if (event <= 90) {
                hunterCount++;
                // 10% nichts passiert
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
        // speichert die gewählte Menüoption (choiseInternal)
        // 0 könnte versehentlich gültige Eingabe sein
        int choiceInternal = -1;
        boolean validInput = false;
        // Schleife läuft solange bis validInput ist true
        while (!validInput) {
            System.out.print("\nBitte, geben Sie die Nummer des gewaehlten Menueeintrags ein (1-5):\t");
            // versucht die Eingabe des Benutzers als int zu lesen, wenn keine gültige Zahl dann InputMismatchException
            try {
                // scanner.nextInt liest die nächste Eingabe als int
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
        return choiceInternal; // Menü erneut anzeigen
    }


    /**
     * Reads user input from the console and returns the chosen menu option.
     *
     * @return the menu option chosen by the user
     */
    private static int readUserInput(int min, int max) {
        int choiceInternal = -1;
        boolean validInput = false;
        // Schleife läuft nur wenn falsch ist bis es true ist
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

        // Array von String Objekten 
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
private static void createVampire() {
    String name;
    while (true) {
        System.out.print("Geben Sie den Namen des Vampirs ein: ");
        name = scanner.nextLine();
        if (!name.matches(".*\\d.*")) { // Überprüft, ob der Name keine Zahlen enthält
            break;
        }
        System.out.println("Ungueltige Eingabe. Der Name darf keine Zahlen enthalten.");
    }

    int alter;
    while (true) {
        System.out.print("Geben Sie das Alter des Vampirs ein: ");
        if (scanner.hasNextInt()) {
            alter = scanner.nextInt();
            scanner.nextLine(); // Konsumiert die Zeile, um Scanner-Probleme zu vermeiden
            break;
        } else {
            System.out.println("Ungueltige Eingabe. Bitte geben Sie eine gültige Zahl ein.");
            scanner.nextLine(); // Konsumiert die ungültige Eingabe
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
            
            // zufallszahl zwischen 0 und 99 + 1, also 1 bis 100
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
            // nach jeden Ereignis wird hunger des Vampirs um 1 erhöht
            aktuellerVampir.setHunger(aktuellerVampir.getHunger() + 1);
            if (aktuellerVampir.getHunger() >= 5) {
                System.out.println("Der Vampir hat zu viel hunger und ist gestorben.");
                aktuellerVampir = null; // Spiel zu Ende
                System.out.println("Spiel vorbei.");
                return;
            }
            // die Energie erhöht sich nach jeder Runde um 10 Punkte
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
                    // liest die Eingabe als double
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

            // im Fall 2
        } else {
            System.out.println("Du hast den Menschen in Ruhe gelassen.");
        }
    }



/**
 * Begegnung mit einem Dämon. Der Spieler kann mit dem Dämon sprechen oder sich entfernen.
 */
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

        int taskChoice = readUserInput(1, 2);
        if (taskChoice == 1) {
            // Zufällige Auswahl einer Aufgabe
            Random random = new Random();
            int taskSelection = random.nextInt(3) + 1; // Zufällige Zahl zwischen 1 und 3
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
        // StringBuilder tut mit reverse das Wort umdrehen, toString verwandelt es in ein String und equals vergleicht es mit der Eingabe
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
//characters enthält zeichen tamrex
// characters enthält die Zeichen t, a, m, r, e, und x.
//Ein StringBuilder-Objekt wird erstellt, um den zufälligen String zu bauen.
//Eine Schleife läuft 50 Mal, und in jedem Durchlauf wird ein zufälliges Zeichen aus characters ausgewählt und an generatedString angehängt.
        String characters = "tamrex";
        //objekt um zufälligen string zu erstellen
        //generatedstring ist ein stringbuilder objekt, um zufälligen string zusammenzusetzen
        StringBuilder generatedString = new StringBuilder();
        Random random = new Random();

        // Generiert einen zufälligen String mit "tam" und "rex"
        //zufälliges zeichen wird zu generatedstring hinzugefügt, randomnextint gibt zufälligen index zwischen 0 u. d. Länge von character zurück, charat gibt zeichen an der zufälligen position in characterstring zurücl
        for (int i = 0; i < 50; i++) {
            // charAt tam Position vom String
            generatedString.append(characters.charAt(random.nextInt(characters.length())));
        }
//konvertierung in string
        String challengeString = generatedString.toString();
        System.out.println("String: " + challengeString);

        // Starte die Zeitmessung
        long startTime = System.currentTimeMillis();

        // Der Spieler hat 20 Sekunden Zeit
        System.out.println("Du hast 20 Sekunden, um die Anzahl der 'tam'-Sequenzen zu zählen und einzugeben.");
        
        int playerAnswer = readUserAnswer();

        // Zeitmessung beenden
        long endTime = System.currentTimeMillis();
        long timeTaken = (endTime - startTime) / 1000;

       
        int correctAnswer = countOccurrences(challengeString, "tam");

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

     //str zu suchen, sub zu zählender string
     //str= gesamter zu durchsende string, in dem wir nach substring suchen(tamrex)
     //der substring tam
    private static int countOccurrences(String str, String sub) {
        //zählt substrings= tam
        int count = 0;
        // startposition suche
        int idx = 0;

        //sucht tam im string und zählt wie oft sie vorkommt; solange vorkommen substring
        while ((idx = str.indexOf(sub, idx)) != -1) {
            count++;
            //sucht nach 1. tam und beginnt bei idx
            //wenn nicht findet -1
            //+1 wenn substring gefunden wurde
            idx += sub.length();
            //erhöht länge substring, postition für nächste suche
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
