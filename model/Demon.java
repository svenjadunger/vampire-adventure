package model;
import java.util.Scanner;

public class Demon {
    private String name;
    private String vampireAbility;

    // Konstruktor
    public Demon(String name, String vampireAbility) {
        this.name = name;
        this.vampireAbility = vampireAbility;
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVampireAbility() {
        return vampireAbility;
    }

    public void setVampireAbility(String vampireAbility) {
        this.vampireAbility = vampireAbility;
    }

    // Methode zum Präsentieren der Aufgabe / des Rätsels
    public void presentTask() {
        // Beispiel-Aufgabe: Zahlenrate-Rätsel
        System.out.println("Der Dämon stellt dir ein Rätsel:");
        System.out.println("Ich denke an eine Zahl zwischen 1 und 10. Kannst du sie erraten?");
        
        int randomNumber = (int) (Math.random() * 10) + 1;
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 3; i++) { // Drei Versuche
            System.out.print("Dein Tipp: ");
            int guess = scanner.nextInt();
            
            if (guess == randomNumber) {
                System.out.println("Das ist richtig! Du erhältst die Fähigkeit: " + vampireAbility);
                return;
            } else {
                System.out.println("Falsch. Versuch es nochmal.");
            }
        }
        
        System.out.println("Leider hast du die Zahl nicht erraten. Der Dämon verschwindet.");
    }
}
