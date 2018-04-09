package pl.kas.surgery.domain;

import lombok.Data;

@Data
public class Prescription {
    private Patient patient;
    private Doctor doctor;
    private String duration;
}
