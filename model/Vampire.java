package model;

public class Vampire {
    private String name;
    private int alter;
    private String blutgruppe;

    public Vampire(String name, int alter, String blutgruppe) {
        this.name = name;
        this.alter = alter;
        this.blutgruppe = blutgruppe;
    }

    // Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getBlutgruppe() {
        return blutgruppe;
    }

    public void setBlutgruppe(String blutgruppe) {
        this.blutgruppe = blutgruppe;
    }

   
}
