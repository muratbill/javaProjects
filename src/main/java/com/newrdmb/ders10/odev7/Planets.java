package com.newrdmb.ders10.odev7;

import java.util.Arrays;
import java.util.Comparator;

public class Planets {
    public static void main(String[] args) {
        System.out.println("Gezegenler listesi: ");
        for(Gezegenler gez: Gezegenler.values()){

            System.out.println(gez);
        }
        Gezegenler enbuyuk = Gezegenler.JUPITER;
        System.out.println("En buyuk gezegen: " + enbuyuk + ' ' +  Gezegenler.JUPITER.getRadius() + " kilometredir.");
        Gezegenler enuzak = Gezegenler.NEPTUNE;
        System.out.println("En uzak gezegen: " + enuzak + ' ' +  Gezegenler.NEPTUNE.getDistanceFromSun() + " milyon kilometredir.");
        Gezegenler speed = Gezegenler.JUPITER;
        System.out.println("Gunes etrafinda En yuksek donus hizi: " + speed + ' ' +  Gezegenler.JUPITER.getRotationSpeed() + " ssatdir.");
        Gezegenler[] planets = Gezegenler.values();
        Arrays.sort(planets, Comparator.comparingDouble(Gezegenler::getDistanceFromSun).reversed());
        System.out.println("------------------------------------------------------------");
        System.out.println("Gezegenleri    gunese uzakligina gore en buyukten-en kucuge siralarsak: ");
        for (Gezegenler planet : planets) {
            System.out.println(planet.name() + ": " + planet.getDistanceFromSun() + " million km");
        }
    }
}
