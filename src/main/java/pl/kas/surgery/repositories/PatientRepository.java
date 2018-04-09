package pl.kas.surgery.repositories;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.kas.surgery.domain.Patient;
import pl.kas.surgery.domain.PatientAdress;
import pl.kas.surgery.domain.PatientCashbox;

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
public class PatientRepository {
    Map<Integer, Patient> patientMap = new HashMap<>();

    public PatientRepository() throws IOException, URISyntaxException, ParseException {
        fillRepository();
    }

    private void fillRepository() throws IOException, URISyntaxException, ParseException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("patients.txt")).toURI());
        List<String> list = Files.readAllLines(path);
        list.remove(0);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        for (String string : list) {
            String[] split = string.split("\t");
            Integer patientId = Integer.valueOf(split[0]);
            Patient patient = new Patient();
            patient.setSurname(split[1]);
            patient.setName(split[2]);
            patient.setPesel(split[3]);
            calendar.setTime(format.parse(split[4]));
            patient.setBirthDate(calendar);
            patient.setPhoneNumber(split[5]);
            patient.setGender(split[6]);
            patient.setEmail(split[7]);
            patient.setReferralDate(split[8]);
            patient.setUser(split[9]);
            patient.setPassword(split[10]);
            PatientCashbox patientCashbox = new PatientCashbox();
            patientCashbox.setName(split[11]);
            patient.setPatientCashbox(patientCashbox);
            PatientAdress patientAdress = new PatientAdress();
            patient.setPatientAdress(patientAdress);

            patientMap.put(patientId, patient);
        }
    }

    public Map<Integer, Patient> getPatientMap(){
        return patientMap;
    }
}
