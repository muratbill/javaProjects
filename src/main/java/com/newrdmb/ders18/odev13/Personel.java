package com.newrdmb.ders18.odev13;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Personel {
    String isim_soyisim;
    Integer yas;
    String gorev;
    LocalDate iseGiris;

    Float maas;
    Boolean tam_zamanli;

    void maasZammi(Integer zam){
        System.out.println("Onceki maas: " + maas);
        maas += zam;
        System.out.println("Yillik Zam sonrasi maas: " + maas);


    }
    void gorevSuresi(LocalDate join_date) {

        // Get today's date
        LocalDate today = LocalDate.now();

        // Calculate the difference in years
        long yearsBetween = ChronoUnit.YEARS.between(join_date, today);
        System.out.println("Gorev suresi: " + yearsBetween + " yil.");
    }
}
