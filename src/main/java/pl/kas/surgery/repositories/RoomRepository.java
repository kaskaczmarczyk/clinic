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
import java.util.*;

@Service
@Getter
public class RoomRepository {
    private Map<Integer, Room> roomMap = new HashMap<>();

    public RoomRepository() throws IOException, URISyntaxException {
        fillRepository();
    }

    private void fillRepository() throws IOException, URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("rooms.txt")).toURI());
        List<String> list = Files.readAllLines(path);
        list.remove(0);

        for (String string : list) {
            String[] split = string.split("\t");
            Integer roomId = Integer.valueOf(split[0]);
            Room room = new Room();
            room.setRoomNumber(Integer.valueOf(split[1]));
            room.setFloor(Integer.valueOf(split[2]));
            room.setSpecjalRoom(split[3]);
            roomMap.put(roomId, room);
        }
    }

    public Map<Integer, Room> getRoomMap(){
        return roomMap;
    }
}
