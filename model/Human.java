package model;

public class Human {
    private int amountOfBlood;

//Konstruktor
public Human (int amountOfBlood) {
    this.amountOfBlood = amountOfBlood;
}

// Getter & Setter
public int getAmountOfBlood () {
    return amountOfBlood;
}

public void setAmountOfBlood (int amountOfBlood) {
    this.amountOfBlood = amountOfBlood;
}

//Methode
public boolean flee () {
    return Math.random() <= 0.2;
}

public void looseBlood(double amount) {
    
}

}
