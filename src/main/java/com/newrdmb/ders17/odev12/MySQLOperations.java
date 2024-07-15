package com.newrdmb.ders17.odev12;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MySQLOperations {
    private Connection connection;

    public MySQLOperations(Connection connection) {
        this.connection = connection;
    }

    public void createTable(Connection connection) {
        String createQuery = """
                CREATE TABLE ad_soyad(per_adsoyad varchar(50) not null,per_gorev varchar(50) not null,
                per_yas smallint not null,per_bolum varchar(50) not null, per_sicilno integer not null,
                PRIMARY KEY (per_sicilno));
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(createQuery)) {
            preparedStatement.execute();
            System.out.println("Table created");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertData(String name, String gorev, Integer age, String bolum, int sicilno) {
        String insertQuery = "INSERT INTO ad_soyad (per_adsoyad, per_gorev, per_yas, per_bolum, per_sicilno) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, gorev);
            if (age != null) {
                preparedStatement.setInt(3, age);
            } else {
                preparedStatement.setNull(3, java.sql.Types.INTEGER);
            }
            preparedStatement.setString(4, bolum);
            preparedStatement.setInt(5, sicilno);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(STR."Inserted \{rowsAffected} row(s) into the table.");
        } catch (SQLException e) {
            System.out.println("Kayit islemi basarisiz..");
        }
    }

    public void updateData(String name, String gorev, Integer age, String bolum, int sicilno) {
        StringBuilder updateQuery = new StringBuilder("UPDATE ad_soyad SET ");
        boolean first = true;

        if (name != null) {
            updateQuery.append("per_adsoyad = ?");
            first = false;
        }
        if (gorev != null) {
            if (!first) updateQuery.append(", ");
            updateQuery.append("per_gorev = ?");
            first = false;
        }
        if (age != null) {
            if (!first) updateQuery.append(", ");
            updateQuery.append("per_yas = ?");
            first = false;
        }
        if (bolum != null) {
            if (!first) updateQuery.append(", ");
            updateQuery.append("per_bolum = ?");
        }
        updateQuery.append(" WHERE per_sicilno = ?");

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery.toString())) {
            int parameterIndex = 1;
            if (name != null) {
                preparedStatement.setString(parameterIndex++, name);
            }
            if (bolum != null) {
                preparedStatement.setString(parameterIndex++, bolum);
            }
            if (age != null) {
                preparedStatement.setInt(parameterIndex++, age);
            }
            if (gorev != null) {
                preparedStatement.setString(parameterIndex++, gorev);
            }
            preparedStatement.setInt(parameterIndex, sicilno);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(STR."Updated \{rowsAffected} row(s) in the table.");
        } catch (SQLException e) {
            System.out.println("Update islemi basarisiz.");
        }
    }

    public void fetchData() {
        String selectQuery = "SELECT * FROM ad_soyad";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println(STR."Ad Soyad: \{resultSet.getString("per_adsoyad")}");
                System.out.println(STR."Gorevi: \{resultSet.getString("per_gorev")}");
                System.out.println(STR."Yas: \{resultSet.getInt("per_yas")}");
                System.out.println(STR."Bolum: \{resultSet.getString("per_bolum")}");
                System.out.println(STR."Sicil no: \{resultSet.getInt("per_sicilno")}");
            }
        } catch (SQLException e) {
            System.out.println("Sorgu basarisiz dondu.");
        }
    }
    public void deleteData(int sicilno) {
        String deleteQuery = "DELETE FROM ad_soyad WHERE per_sicilno = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, sicilno);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(STR."Deleted \{rowsAffected} row(s) from the table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

