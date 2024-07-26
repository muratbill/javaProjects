package com.newrdmb.ders17JDBI.odev12;
import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        JDBIOrnek instance = JDBIOrnek.getInstance();
        Jdbi jdbi = instance.getJdbi();
        DBOperations dbops = new DBOperations(jdbi);
        if (jdbi == null) {
            System.err.println("Failed to establish jdbi. Exiting.");
            return;
        }
        dbops.createTable();

//        dbops.insertData("John Wayne","Engineer",43,"Engineering",1234);
//        dbops.insertData("Emma Watson","Accountant",43,"Finance",1235);
//        dbops.insertData("Mehmet Can","Project manager",45,"R&D",1236);
//        dbops.insertData("Tim Burton","Security",24,"Security",1237);
//          dbops.updateData("Tim Cooking",null,null,null,1237);

        dbops.deleteData(1237);
        List<Map<String, Object>> dataBySicilNo = dbops.fetchDataBySicilNo(1237);
        for (Map<String, Object> row : dataBySicilNo) {
            System.out.println(STR."Isim: \{row.get("adsoyad")}");
            System.out.println(STR."Gorev: \{row.get("gorev")}");
            System.out.println(STR."yas: \{row.get("yas")}");
            System.out.println(STR."Bolum: \{row.get("bolum")}");
            System.out.println(STR."Sicil No: \{row.get("sicilno")}");
        }


    }
}
