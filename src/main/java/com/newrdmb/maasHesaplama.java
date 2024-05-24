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

    public static void main(String[] args) {
        System.out.println("Lutfen calisilan gun sayisini giriniz: ");
        int gun = input.nextInt();

        maasHesaplama mh1 = new maasHesaplama();
        mh1.katsayi = 1500;

        if (gun < 0) {
            System.out.println("Gun sayisi negatif olamaz");
        } else {
            mh1.gelir(gun);
        }

    }
}
