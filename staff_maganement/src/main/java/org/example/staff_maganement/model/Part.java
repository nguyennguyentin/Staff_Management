package org.example.staff_maganement.model;
public class Part {
    private int idPart;
    private String namePart;

    // Constructors
    public Part() {}

    public Part(int idPart, String namePart) {
        this.idPart = idPart;
        this.namePart = namePart;
    }

    // Getters and Setters
    public int getIdPart() {
        return idPart;
    }

    public void setIdPart(int idPart) {
        this.idPart = idPart;
    }

    public String getNamePart() {
        return namePart;
    }

    public void setNamePart(String namePart) {
        this.namePart = namePart;
    }

    // ToString for easy representation
    @Override
    public String toString() {
        return "Part [idPart=" + idPart + ", namePart=" + namePart + "]";
    }
}

