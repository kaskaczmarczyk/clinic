package pl.kas.surgery.domain;

import lombok.Data;

@Data
public class Provider {
    private String street;
    private String adressNumber;
    private String name;
    private int nip;
    private int regon;
    private int krs;
}
