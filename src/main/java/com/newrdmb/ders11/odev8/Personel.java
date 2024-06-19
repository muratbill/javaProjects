package com.newrdmb.ders11.odev8;
import java.time.LocalDate;

public abstract class Personel {
    private String name;
    private String surname;
    private LocalDate birthdate;

    public Personel(String name, String surname, LocalDate birthdate) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    @Override
    public String toString() {
        return name + " " + surname + " (" + birthdate + ")";
    }
}

class Woman extends Personel {
    public Woman(String name, String surname, LocalDate birthdate) {
        super(name, surname, birthdate);
    }

}

class Man extends Personel {
    public Man(String name, String surname, LocalDate birthdate) {
        super(name, surname, birthdate);
    }

}