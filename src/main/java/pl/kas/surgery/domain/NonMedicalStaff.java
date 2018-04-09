package pl.kas.surgery.domain;

import lombok.Data;
import java.util.Calendar;

@Data
public class NonMedicalStaff {
    private String name;
    private String surname;
    private String phoneNumber;
    private Calendar birthDate;
}
