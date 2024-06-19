package com.newrdmb.ders11.odev8;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;

    public class PersonelList {
        private List<Personel> personelList;

        public PersonelList() {
            this.personelList = new ArrayList<>();
        }

        public void addPersonel(Personel personel) {
            this.personelList.add(personel);
        }

        public void removePersonel(Personel personel) {
            this.personelList.remove(personel);
        }

        public void changePersonel(int index, Personel personel) {
            if (index >= 0 && index < personelList.size()) {
                this.personelList.set(index, personel);
            }
        }

        public List<Personel> getPersonelList() {
            return personelList;
        }

        public int calculateRemainingYearsForRetirement(Personel personel) {
            int retirementAge = personel instanceof Woman ? 60 : 65;
            LocalDate now = LocalDate.now();
            Period period = Period.between(personel.getBirthdate(), now);
            int age = period.getYears();
            int remainingYears = retirementAge - age;
            return remainingYears > 0 ? remainingYears : 0;
        }
    }


