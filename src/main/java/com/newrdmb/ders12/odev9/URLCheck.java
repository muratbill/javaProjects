package com.newrdmb.ders12.odev9;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class URLCheck {

    public static void validateURL(String mylink) throws InvalidURLException {
        try {
            URL url = new URL(mylink);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                throw new InvalidURLException("Hatali URL veya yanit yok: " + mylink);
            }
        } catch (MalformedURLException e) {
            throw new InvalidURLException("Malformed URL: " + mylink);
        } catch (IOException e) {
            throw new InvalidURLException("Baglanti hatasi: " + mylink);
        }
    }
}
class InvalidURLException extends Exception {
    public InvalidURLException(String message) {
        super(message);
    }
}
