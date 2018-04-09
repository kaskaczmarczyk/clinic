package pl.kas.surgery.domain;

import lombok.Data;

@Data
public class Product {
    private int number;
    private String price;
    private VatTypes vatTypes;
    private Provider provider;
    private int minNumber;
    private String name;
}
