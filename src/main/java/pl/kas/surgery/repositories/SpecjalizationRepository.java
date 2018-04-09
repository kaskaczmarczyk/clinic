package pl.kas.surgery.repositories;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.kas.surgery.domain.Specjalization;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Getter
public class SpecjalizationRepository {
    Map<Integer, Specjalization> specjalizationMap = new HashMap<>();

    public SpecjalizationRepository() throws IOException, URISyntaxException {
        fillRepository();
    }

    private void fillRepository() throws IOException, URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("specjalizations.txt")).toURI());
        List<String> list = Files.readAllLines(path);
        list.remove(0);

        for (String string : list) {
            String[] split = string.split("\t");
            Integer specjalizationId = Integer.valueOf(split[0]);
            Specjalization specjalization = new Specjalization();
            specjalization.setName(split[1]);
            specjalizationMap.put(specjalizationId, specjalization);
        }
    }

    public Map<Integer, Specjalization> getSpecjalizationMap(){
        return specjalizationMap;
    }
}
