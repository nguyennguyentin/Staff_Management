package org.example.staff_maganement.model;
public class Title {
    private int idTitle;
    private String nameTitle;

    // Constructors
    public Title() {}

    public Title(int idTitle, String nameTitle) {
        this.idTitle = idTitle;
        this.nameTitle = nameTitle;
    }

    // Getters and Setters
    public int getIdTitle() {
        return idTitle;
    }

    public void setIdTitle(int idTitle) {
        this.idTitle = idTitle;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    // ToString for easy representation
    @Override
    public String toString() {
        return "Title [idTitle=" + idTitle + ", nameTitle=" + nameTitle + "]";
    }
}

