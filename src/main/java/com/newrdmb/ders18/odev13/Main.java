package com.newrdmb.ders18.odev13;
import java.util.Scanner;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Personel p1 = new Personel();
        Personel p2 = new Personel();
        Personel p3 = new Personel();
        p1.isim_soyisim = "Michael Jackson";
        p1.yas = 40;
        p1.gorev = "Software Engineer";
        p1.maas = 70000.0F;
        p1.tam_zamanli = true;
//        // Define the past date as May 8, 2000
        p1.iseGiris = LocalDate.of(2000,5,8);
        System.out.println("Personel ismi: " + p1.isim_soyisim + " || Gorevi: " + p1.gorev + " || Yas: " + p1.yas + " || Tam zamanli: " + p1.tam_zamanli);
        p1.gorevSuresi(p1.iseGiris);
        p1.maasZammi(15000);
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        System.out.println("Lutfen calisilan gun sayisini giriniz: ");
        int gun = MaasHesaplama.input.nextInt();
        MaasHesaplama mh1 = new MaasHesaplama();
        mh1.katsayi = 1500;
        if (gun < 0) {
            System.out.println("Gun sayisi negatif olamaz");
        } else {
            mh1.gelir(gun);
        }

    }
}
