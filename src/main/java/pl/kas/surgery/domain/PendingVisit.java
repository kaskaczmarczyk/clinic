package pl.kas.surgery.domain;

import lombok.Data;
import java.time.LocalTime;
import java.util.Calendar;

@Data
public class PendingVisit {
    private Calendar date;
    private int priority;
    private Patient patient;
    private Doctor doctor;
    private Room room;
    private LocalTime time;
}
