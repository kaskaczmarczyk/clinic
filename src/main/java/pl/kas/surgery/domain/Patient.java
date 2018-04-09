package pl.kas.surgery.domain;

import lombok.Data;
import java.util.Calendar;

@Data
public class Patient {
    private String name;
    private String surname;
    private Calendar birthDate;
    private String pesel;
    private String phoneNumber;
    private String gender;
    private String email;
    private String referralDate;
    private String user;
    private String password;
    private PatientCashbox patientCashbox;
    private PatientAdress patientAdress;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReferralDate(String referralDate) {
        this.referralDate = referralDate;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPatientCashbox(PatientCashbox patientCashbox) {
        this.patientCashbox = patientCashbox;
    }

    public void setPatientAdress(PatientAdress patientAdress) {
        this.patientAdress = patientAdress;
    }
}
