package pl.kas.surgery.domain;

import lombok.Data;

@Data
public class PatientAdress {
    private String street;
    private String houseNumber;
    private String flatNumber;
    private String city;
    private String zipcode;
}
