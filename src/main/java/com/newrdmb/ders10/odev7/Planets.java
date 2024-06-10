package com.newrdmb.ders10.odev7;

import java.util.Arrays;
import java.util.Comparator;

public class Planets {
    public static void main(String[] args) {
        System.out.println("Gezegenler listesi: ");
        for(Gezegenler gez: Gezegenler.values()){

            System.out.println(gez);
        }
        Gezegenler enbuyuk = Gezegenler.Jupiter;
        System.out.println("En buyuk gezegen: " + enbuyuk + ' ' +  Gezegenler.Jupiter.getRadius() + " kilometredir.");
        Gezegenler enuzak = Gezegenler.Neptune;
        System.out.println("En uzak gezegen: " + enuzak + ' ' +  Gezegenler.Neptune.getDistanceFromSun() + " milyon kilometredir.");
        Gezegenler speed = Gezegenler.Jupiter;
        System.out.println("Gunes etrafinda En yuksek donus hizi: " + speed + ' ' +  Gezegenler.Jupiter.getRotationSpeed() + " ssatdir.");
        Gezegenler[] planets = Gezegenler.values();
        Arrays.sort(planets, Comparator.comparingDouble(Gezegenler::getDistanceFromSun).reversed());
        System.out.println("------------------------------------------------------------");
        System.out.println("Gezegenleri    gunese uzakligina gore en buyukten-en kucuge siralarsak: ");
        for (Gezegenler planet : planets) {
            System.out.println(planet.name() + ": " + planet.getDistanceFromSun() + " million km");
        }
    }
}
