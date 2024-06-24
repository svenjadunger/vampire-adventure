package model;

public class Demon {
    private String name;
    private String vampireAbility;

    //Konstruktor
public Demon (String name, String vamipreAbility) {
    this.name = name;
    this.vampireAbility = vamipreAbility;
}

// Getter & Setter
public String getName () {
    return name;
}

public void setName (String name) {
    this.name = name;
}
public String getVampireAbility () {
    return vampireAbility;
}

public void setVampireAbility (String vamipreAbility) {
    this.vampireAbility = vamipreAbility;
}

//Methode
public void presentTask () {
    
}

}
