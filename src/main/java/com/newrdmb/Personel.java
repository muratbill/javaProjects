package com.newrdmb;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
//import java.util.Scanner;

//import static com.newrdmb.maasHesaplama.input;

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

    public static void main(String[] args) {
//        Personel p1 = new Personel();
//        Personel p2 = new Personel();
//        Personel p3 = new Personel();
//        p1.isim_soyisim = "Michael Jackson";
//        p1.yas = 40;
//        p1.gorev = "Software Engineer";
//        p1.maas = 70000.0F;
//        p1.tam_zamanli = true;
//        // Define the past date as May 8, 2000
//        p1.iseGiris = LocalDate.of(2000,5,8);
//
//
//
//        p2.isim_soyisim = "Can Can";
//        p2.yas = 30;
//        p2.gorev = "Doctor";
//        p2.maas = 80000.0F;
//        p2.tam_zamanli = true;
//        p2.iseGiris = LocalDate.of(2018,1,10);
//
//
//        p3.isim_soyisim = "David Bowie";
//        p3.yas = 20;
//        p3.gorev = "Cook";
//        p3.maas = 50000.0F;
//        p3.tam_zamanli = false;
//        p3.iseGiris = LocalDate.of(2021,3,29);
//
//
//        System.out.println("Personel ismi: " + p1.isim_soyisim + " || Gorevi: " + p1.gorev + " || Yas: " + p1.yas + " || Tam zamanli: " + p1.tam_zamanli);
//        p1.gorevSuresi(p1.iseGiris);
//        p1.maasZammi(15000);
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        System.out.println("Personel ismi: " + p2.isim_soyisim + " || Gorevi: " + p2.gorev + " || Yas: " + p2.yas + " || Tam zamanli: " + p2.tam_zamanli);
//        p2.gorevSuresi(p2.iseGiris);
//        p2.maasZammi(10000);
//        System.out.println("---------------------------------------------------------------------------------------------------------------");
//        System.out.println("Personel ismi: " + p3.isim_soyisim + " || Gorevi: " + p3.gorev + " || Yas: " + p3.yas + " || Tam zamanli: " + p3.tam_zamanli);
//        p3.gorevSuresi(p3.iseGiris);
//        p3.maasZammi(9000);

//        System.out.println("Lutfen calisilan gun sayisini giriniz: ");
//        int gun = input.nextInt();
//
//        maasHesaplama mh1 = new maasHesaplama();
//        mh1.katsayi = 1500;
//
//        if (gun < 0) {
//            System.out.println("Gun sayisi negatif olamaz");
//        } else {
//            mh1.gelir(gun);
//        }
      // kelimeDizisi kelimeObj = new kelimeDizisi();
       //kelimeObj.kelimeTuretme();
    }

}
