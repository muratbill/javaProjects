package com.newrdmb.ders15.odev11;

public class Main {
    public static void main(String[] args) {
        MySingleton instance = MySingleton.getInstance();
        instance.myMessage();

        System.out.println("Builder ornekleri: *****************");
        MyCar arabam = MyCar.builder("Citroen")
                .model("C3").year(2024).color("Red")
                .engineType("Electric").build();
        System.out.println(STR."Birinci araba: \{arabam}");

        MyCar arabam2 = MyCar.builder("Renault").model("Symbool").build();
        System.out.println(STR."Ikinci araba: \{arabam2}");


    }
}
