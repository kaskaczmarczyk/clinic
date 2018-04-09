package pl.kas.surgery.domain;

import lombok.Data;

import java.util.Calendar;

@Data
public class Doctor {
    private String name;
    private String surname;
    private String phone;
    private Calendar birthdate;
    private Room room;
    private Specjalization specjalization;
    private String user;
    private String password;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public void setSpecjalization(Specjalization specjalization) {
        this.specjalization = specjalization;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
