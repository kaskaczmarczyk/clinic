package pl.kas.surgery.domain;

import lombok.Data;

@Data
public class Room {
    private int roomNumber;
    private int floor;
    private String specjalRoom;

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setSpecjalRoom(String specjalRoom) {
        this.specjalRoom = specjalRoom;
    }
}
