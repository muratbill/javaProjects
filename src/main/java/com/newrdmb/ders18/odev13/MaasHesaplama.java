package com.newrdmb.ders18.odev13;

import java.util.Scanner;

public class MaasHesaplama {
    static Scanner input = new Scanner(System.in);
    public double katsayi;
    public double maas;

    public void gelir(int gunSayisi) {

        maas = (gunSayisi >= 26) ? (25 * katsayi) + ((gunSayisi - 25) * 1000) : (gunSayisi * katsayi);
        System.out.println("Elde edilen gelir: " + maas);

    }
}
