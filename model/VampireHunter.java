package model;

public class VampireHunter {
    private String name;
    private int energy;

       //Konstruktor
public VampireHunter (String name, int energy) {
    this.name = name;
    this.energy = energy;
}
// Getter & Setter
public String getName () {
    return name;
}

public void setName (String name) {
    this.name = name;
}

public int getEnergy () {
    return energy;
}
public void setEnergy (int energy) {
    this.energy = energy;
}

 // Methode zum Angreifen eines Vampirs
 public int attack(Vampire vampire) {
    System.out.println("Der Vampirjäger greift einen Vampir an.");
    // 50% Chance, den Vampir zu treffen und 3 Schaden zu verursachen
    if (Math.random() <= 0.5) {
        System.out.println("Der Angriff war erfolgreich. Der Vampir nimmt 3 Schaden.");
        vampire.takeDamage(3);
        return 3;
    } else {
        System.out.println("Der Angriff ist fehlgeschlagen.");
        return 0;
    }
}

// Methode um Schaden zu nehmen
public void takeDamage(int amount) {
    this.energy -= amount;
    System.out.println("Der Vampirjäger hat " + amount + " Schaden genommen.");
    // Wenn die Energie <= 0 ist, ist der Vampirjäger tot
    if (this.energy <= 0) {
        this.energy = 0; // Energie sollte nicht negativ sein
        System.out.println("Der Vampirjäger ist tot.");
    }
}

// Methode um zu fliehen (Vampirjäger flieht nie)
public boolean flee() {
    System.out.println("Ein Vampirjäger flieht nie!");
    return false;
}

// Methode um zu prüfen, ob der Vampirjäger am Leben ist
public boolean isAlive() {
    return this.energy > 0;
}
}

