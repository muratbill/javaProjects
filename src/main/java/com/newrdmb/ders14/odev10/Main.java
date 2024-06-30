package com.newrdmb.ders14.odev10;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FarkliDegerler<Integer> sayi = new FarkliDegerler<>();
        sayi.setDeger(100);
        System.out.println("Verilen sayi degeri: " + sayi.getDeger());

        FarkliDegerler<String> cumle = new FarkliDegerler<>();
        cumle.setDeger("Bugun gunlerden Cuma");
        System.out.println(cumle.getDeger());

        FarkliDegerler<Double> liste = new FarkliDegerler<>();
        liste.addElement(1.1);
        liste.addElement(2.2);
        liste.addElement(3.3);
        System.out.println(liste.getElement(0));
        System.out.println(liste.getElement(2));
        System.out.println("--------------------------");
        System.out.println("Stream ornekleri: ");

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integerList = new ArrayList<>();
        System.out.println("Enter integers (type 'done' to finish):");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                // Sayi ise ekle
                integerList.add(scanner.nextInt());
            } else {
                // Done yaz enter tusuna bas sona ersin
                String input = scanner.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer or 'done' to finish.");
                }
            }
        }

        scanner.close();
        List<Integer> filteredList = integerList.stream()
                .filter(num -> num == 2)
                .collect(Collectors.toList());

        if (filteredList.isEmpty()) {
            System.out.println(-1);
        } else {
            filteredList.forEach(System.out::println);
        }

    }
}
