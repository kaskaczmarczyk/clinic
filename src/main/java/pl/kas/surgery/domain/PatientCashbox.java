package pl.kas.surgery.domain;

import lombok.Data;

@Data
public class PatientCashbox {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}