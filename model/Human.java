package model;

public class Human {
    private int amountOfBlood;

    // Konstruktor
    public Human() {
        // Zufällige Menge an Blut zwischen 6 und 8 Litern festlegen
        this.amountOfBlood = 6 + (int) (Math.random() * 3);
    }

    // Getter und Setter
    public int getAmountOfBlood() {
        return amountOfBlood;
    }

    public void setAmountOfBlood(int amountOfBlood) {
        this.amountOfBlood = amountOfBlood;
    }

    // Methode zum Fliehen
    public boolean flee() {
        // 20% Chance erfolgreich zu fliehen
        return Math.random() <= 0.2;
    }

    // Methode um Blut zu verlieren
    public void loseBlood(double amount) {
        this.amountOfBlood -= amount;
        System.out.println("Der Mensch hat " + amount + " Liter Blut verloren.");
        // Wenn der Mensch weniger als 5 Liter Blut hat, wird er in einen Vampir
        // verwandelt
        if (this.amountOfBlood < 5) {
            System.out.println("Der Mensch hat sich in einen Vampir verwandelt.");
        }
    }
}
