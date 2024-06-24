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

    // Konstruktor
    public Vampire(String name, int age) {
        this.name = name;
        this.age = age;
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
    public void attackHuman(Human human) {
    }

    public void drinkBlood(double amount) {
    }

    public void takeDamage(int damage) {
        if (this.transparency) {
            
            if (Math.random() > 0.5) {
                return;
            }
        }
        this.energy -= damage;
        if (this.energy <= 0) {
            this.finallyDead = true;
        }
    }

    public void attack(VampireHunter vh) {
    }

    public boolean flee() {
        return Math.random() <= 0.6;
    }

    @Override
    public String toString() {
        return "Vampir Name: " + name + "\nAlter: " + age +
               "\nMächtigkeit: " + grandness + "\nHunger: " + hunger + 
               "\nEnergie: " + energy + "\nFähigkeiten:\n  - Double Power: " + 
               (doublePower ? "aktiviert" : "deaktiviert") +
               "\n  - Transparency: " + (transparency ? "aktiviert" : "deaktiviert");
    }
}
