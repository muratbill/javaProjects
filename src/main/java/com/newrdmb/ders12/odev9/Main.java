package com.newrdmb.ders12.odev9;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class Main {
    public static void main(String[] args) {

        //Duzgun calisan URL
        //String testURL = "https://www.google.com";

        //Malformed URL test
        //String testURL = "http0://example99.com";

        //Baglanti Hatasi testi
        //String testURL = "http://example99.com";

        //Hatali URL veya yanit yok icin test
        String testURL = "https://www.amazon.com/error";

        try {
            URLCheck.validateURL(testURL);
            System.out.println("Baglandi.Hadi iyisin");
        } catch (InvalidURLException e) {
            System.err.println(e.getMessage());
        }
    }
}
