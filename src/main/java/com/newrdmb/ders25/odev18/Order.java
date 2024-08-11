package com.newrdmb.ders25.odev18;

import lombok.Data;

@Data
public class Order {
    private long id;
    private long petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

}
