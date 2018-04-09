package pl.kas.surgery.domain;

import lombok.Data;
import java.time.LocalTime;
import java.util.Calendar;

@Data
public class Visit {
    private int patientId;
    private int doctorId;
    private int roomId;
    private Calendar date;
    private int priority;
    private LocalTime time;

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
