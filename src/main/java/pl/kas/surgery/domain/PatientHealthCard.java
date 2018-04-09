package pl.kas.surgery.domain;

import lombok.Data;
import java.util.List;

@Data
public class PatientHealthCard {
    private int weight;
    private int growth;
    private Patient patient;
    private List<Visit> visits;
}
