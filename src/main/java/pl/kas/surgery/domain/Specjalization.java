package pl.kas.surgery.domain;

import lombok.Data;

@Data
public class Specjalization {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
