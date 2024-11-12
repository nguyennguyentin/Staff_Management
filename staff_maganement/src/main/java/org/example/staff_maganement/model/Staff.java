package org.example.staff_maganement.model;
import java.sql.Date;

public class Staff {
    private int idStaff;
    private String nameStaff;
    private Date birthday;
    private String cmnd;
    private Part part;
    private Title title;

    // Constructors
    public Staff() {}

    public Staff(int idStaff, String nameStaff, Date birthday, String cmnd, Part part, Title title) {
        this.idStaff = idStaff;
        this.nameStaff = nameStaff;
        this.birthday = birthday;
        this.cmnd = cmnd;
        this.part = part;
        this.title = title;
    }

    public Staff(String nameStaff, java.sql.Date birthday, String cmnd, Part part, Title title) {
    }


    // Getters and Setters
    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
