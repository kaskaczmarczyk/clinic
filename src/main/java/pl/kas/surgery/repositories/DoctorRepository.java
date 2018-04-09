package pl.kas.surgery.repositories;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.kas.surgery.domain.Doctor;
import pl.kas.surgery.domain.Room;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
@Getter
public class DoctorRepository {
    private Map<Integer, Doctor> doctorMap = new HashMap<>();

    public DoctorRepository() throws ParseException, IOException, URISyntaxException {
        fillRepository();
    }

    private void fillRepository() throws URISyntaxException, IOException, ParseException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("doctors.txt")).toURI());
        List<String> list = Files.readAllLines(path);
        list.remove(0);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        for (String string : list) {
            String[] split = string.split("\t");
            Integer doctorId = Integer.valueOf(split[0]);
            Doctor doctor = new Doctor();
            doctor.setSurname(split[1]);
            doctor.setName(split[2]);
            //doctor.setSpecjalization(split[3]);
            calendar.setTime(format.parse(split[4]));
            doctor.setBirthdate(calendar);
            Room room = new Room();
            room.setRoomNumber(Integer.valueOf(split[7]));

            doctorMap.put(doctorId, doctor);
        }
    }

    public Map<Integer, Doctor> getDoctorMap(){
        return doctorMap;
    }
}
