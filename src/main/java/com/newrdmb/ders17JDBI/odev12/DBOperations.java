package com.newrdmb.ders17JDBI.odev12;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.UnableToExecuteStatementException;
import java.util.List;
import java.util.Map;

public class DBOperations {

    private final Jdbi jdbi;

    public DBOperations(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    // Method to insert data into the table
    public void insertData(String adsoyad, String gorev, Integer yas, String bolum, int sicilno) {



            jdbi.useHandle(handle -> {
                handle.execute("INSERT INTO ad_soyad (adsoyad, gorev, yas, bolum, sicilno) VALUES (?, ?, ?, ?, ?)",
                        adsoyad, gorev, yas, bolum, sicilno);
            });
            System.out.println("Data inserted.");
        }


    // Method to update data in the table
    public void updateData(String newad, String newgorev, Integer newyas, String newbolum, int sicilno) {



            StringBuilder updateQuery = new StringBuilder("UPDATE ad_soyad SET ");
            boolean first = true;

            if (newad != null) {
                updateQuery.append("adsoyad = :newad");
                first = false;
            }
            if (newgorev != null) {
                if (!first) updateQuery.append(", ");
                updateQuery.append("gorev = :newgorev");
                first = false;
            }
            if (newyas != null) {
                if (!first) updateQuery.append(", ");
                updateQuery.append("yas = :newyas");
                first = false;
            }
            if (newbolum != null) {
                if (!first) updateQuery.append(", ");
                updateQuery.append("bolum = :newbolum");
            }
            updateQuery.append(" WHERE sicilno = :sicilno");
            try {

            int affected_rows = jdbi.withHandle(handle ->
            handle.createUpdate(updateQuery.toString())
                    .bind("newad", newad)
                    .bind("newgorev", newgorev)
                    .bind("newyas", newyas)
                    .bind("newbolum", newbolum)
                    .bind("sicilno", sicilno)
                    .execute()
            );
                if (affected_rows == 0) {
                    System.err.println(STR."Herhangi bir update islemi olmadi \{sicilno}");
                } else {
                    System.out.println("Update basarili..");
                }
            } catch (UnableToExecuteStatementException e) {
                System.err.println(STR."Error updating data: \{e.getMessage()}");
            }

             }
    // Method to delete data from the table
    public void deleteData(int sicilno) {
        try {
            int affected_rows = jdbi.withHandle(handle ->
                handle.createUpdate("DELETE FROM ad_soyad WHERE sicilno = :sicilno")
                        .bind("sicilno",sicilno)
                        .execute()
            );

            if (affected_rows == 0) {
                System.err.println(STR."Veri bulunamadi: \{sicilno}");
            } else {
                System.out.println(STR."Silinen sicilno: \{sicilno}");
            }
        } catch (UnableToExecuteStatementException e) {
            System.out.println("Veri silinemedi ");
        }
    }

    public void createTable(){
        jdbi.useHandle(handle -> handle.execute("CREATE TABLE IF NOT EXISTS ad_soyad (" +
                "adsoyad VARCHAR(50), " +
                "gorev VARCHAR(50), " +
                "yas INT, " +
                "bolum VARCHAR(50), " +
                "sicilno int PRIMARY KEY)"));
        System.out.println("Table created or already exists.");
    }
    public List<Map<String, Object>> fetchDataBySicilNo(int sicilno) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM ad_soyad  WHERE sicilno = :sicilno")
                        .bind("sicilno", sicilno)
                        .mapToMap()
                        .list());

    }
}


