package com.newrdmb.ders15.odev11;

public class Main {
    public static void main(String[] args) {
        MySingleton instance = MySingleton.getInstance();
        instance.myMessage();

        System.out.println("Builder ornekleri: *****************");
        MyCar arabam = new MyCar.MyCarBuilder("Citroen")
                .model("C3").year(2024).color("Red")
                .engineType("Electric").build();
        System.out.println("Birinci araba: " + arabam);

        MyCar arabam2 = new MyCar.MyCarBuilder("Renault").model("Symbool").build();
        System.out.println("Ikinci araba: " + arabam2);


    }
}
