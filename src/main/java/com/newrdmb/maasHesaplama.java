package com.newrdmb;
import java.util.Scanner;
public class maasHesaplama {

    static Scanner input = new Scanner(System.in);
    double katsayi;
    double maas;

    void gelir(int gunSayisi) {

        maas = (gunSayisi > 25) ? (25 * katsayi) + ((gunSayisi - 25) * 1000) : (gunSayisi * katsayi);
        System.out.println("Elde edilen gelir: " + maas);

    }


}
