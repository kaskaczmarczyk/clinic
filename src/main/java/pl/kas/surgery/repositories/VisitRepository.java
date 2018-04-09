package pl.kas.surgery.repositories;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.kas.surgery.domain.Visit;

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
public class VisitRepository {

    private Map<Integer, Visit> visitMap = new HashMap<>();

    public VisitRepository() throws IOException, URISyntaxException, ParseException {
        fillRepository();
    }

    private void fillRepository() throws IOException, URISyntaxException, ParseException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("visits.txt")).toURI());
        List<String> list = Files.readAllLines(path);
        list.remove(0);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        for (String string : list) {
            String[] split = string.split("\t");
            Integer visitId = Integer.valueOf(split[0]);
            Visit visit = new Visit();
            visit.setPatientId(Integer.valueOf(split[1]));
            visit.setDoctorId(Integer.valueOf(split[2]));
            visit.setRoomId(Integer.valueOf(split[3]));
            calendar.setTime(format.parse(split[4]));
            visit.setDate(calendar);
            visit.setPriority(Integer.valueOf(split[5]));
            //godzina
            visitMap.put(visitId, visit);
        }
    }

    public Map<Integer, Visit> getVisitMap(){
        return visitMap;
    }
}
