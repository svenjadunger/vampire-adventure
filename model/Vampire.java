package model;

public class Vampire {
    private String name;
    private int age; 
    private int grandness;
    private int hunger;
    private int energy;
    private boolean finallyDead;
    private boolean doublePower;
    private boolean transparency;
    private String blutgruppe;

    // Konstruktor
    public Vampire(String name, int age, String blutgruppe) {
        this.name = name;
        this.age = age;
        this.blutgruppe = blutgruppe;
        this.grandness = 0; 
        this.hunger = 0; 
        this.energy = 10; 
        this.finallyDead = false;
        this.doublePower = false;
        this.transparency = false;
    }

    // Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBlutgruppe () {
        return blutgruppe;
    }

    public void setBlutgruppe (String blutgruppe) {
        this.blutgruppe = blutgruppe;
    }

    public int getGrandness() {
        return grandness;
    }

    public void setGrandness(int grandness) {
        this.grandness = grandness;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public boolean isFinallyDead() {
        return finallyDead;
    }

    public void setFinallyDead(boolean finallyDead) {
        this.finallyDead = finallyDead;
    }

    public boolean isDoublePower() {
        return doublePower;
    }

    public void setDoublePower(boolean doublePower) {
        this.doublePower = doublePower;
    }

    public boolean isTransparency() {
        return transparency;
    }

    public void setTransparency(boolean transparency) {
        this.transparency = transparency;
    }

    // Methoden
    // Methode zum Angreifen eines Menschen
    public void attackHuman(Human human) {
        System.out.println("Der Vampir greift einen Menschen an.");
        // 60% Chance, den Menschen ruhigzustellen
        if (Math.random() <= 0.6) {
            System.out.println("Der Mensch wurde erfolgreich ruhiggestellt.");
        } else {
            System.out.println("Der Angriff ist fehlgeschlagen.");
        }
    }

     // Methode zum Trinken von Blut
     public void drinkBlood(double amount) {
        if (amount < 0 || amount > 6) {
            System.out.println("Ungueltige Menge. Bitte geben Sie eine Menge zwischen 0 und 6 Litern ein.");
            return;
        }
    
        System.out.println("Der Vampir trinkt " + amount + " Liter Blut.");
    
        if (amount >= 5) {
            System.out.println("Der Mensch wird in einen Vampir verwandelt.");
        }
    
        this.hunger = 0;
    
        this.energy += amount;
        if (this.energy > 20) {
            this.energy = 20;
        }
    
        System.out.println("Der Hunger des Vampirs ist nun " + this.hunger + " und seine Energie ist " + this.energy + ".");
    }
    

    
        // Methode um Schaden zu nehmen
    public void takeDamage(int damage) {
        // Wenn der Vampir die Fähigkeit Transparenz hat, gibt es eine 50% Chance, keinen Schaden zu nehmen
        if (this.transparency) {
            if (Math.random() > 0.5) {
                System.out.println("Dank der Transparenz hat der Vampir keinen Schaden genommen.");
                return;
            }
        }

        // Schaden abziehen
        this.energy -= damage;
        System.out.println("Der Vampir hat " + damage + " Schaden genommen.");
        // Wenn Energie <= 0, ist der Vampir tot
        if (this.energy <= 0) {
            this.finallyDead = true;
            System.out.println("Der Vampir ist tot.");
        }
    }

    // Methode um einen Vampirjäger anzugreifen
    public void attack(VampireHunter vh) {
        int damage = (int) (Math.random() * 5); // Zufälliger Schaden zwischen 0 und 5
        if (this.doublePower) {
            damage *= 2; // Wenn doppelte Kraft, dann Schaden verdoppeln
        }
        System.out.println("Der Vampir verursacht " + damage + " Schaden am Vampirjäger.");
        vh.takeDamage(damage); // Schaden dem Vampirjäger zufügen
    }


    // Methode um zu fliehen
    public boolean flee() {
        // 60% Chance erfolgreich zu fliehen
        boolean success = Math.random() <= 0.6;
        if (success) {
            System.out.println("Der Vampir konnte erfolgreich fliehen.");
        } else {
            System.out.println("Der Fluchtversuch ist gescheitert.");
        }
        return success;
    }




// Überschriebene toString-Methode, um die Eigenschaften des Vampirs als String zurückzugeben
@Override
public String toString() {
    return "Vampir Name: " + name + "\n" +
           "Alter: " + age + "\n" +
           "Blutgruppe: " + blutgruppe + "\n" +
           "Mächtigkeit: " + grandness + "\n" +
           "Hunger: " + hunger + "\n" +
           "Energie: " + energy + "\n" +
           "Endgültig tot: " + finallyDead + "\n" +
           "Doppelte Kraft: " + doublePower + "\n" +
           "Transparenz: " + transparency;
}

   
}
