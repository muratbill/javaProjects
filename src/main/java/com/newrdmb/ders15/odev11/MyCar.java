package com.newrdmb.ders15.odev11;

public class MyCar {
    private String make;
    private String model;
    private int year;
    private String engineType;
    private String color;
    private MyCar(MyCarBuilder myCarBuilder){
        make = myCarBuilder.make;
        model = myCarBuilder.model;
        year = myCarBuilder.year;
        engineType = myCarBuilder.engineType;
        color = myCarBuilder.color;
    }


    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", engineType='" + engineType + '\'' +

                '}';
    }
    public static  class MyCarBuilder {
        private String make;
        private String model;
        private int year;
        private String engineType;
        private String color;


        // Sadece make degerini constructor yapisinda zorunlu tuttum./
        public MyCarBuilder(String make) {
            this.make = make;

        }

        public MyCarBuilder model(String model) {
            this.model = model;
            return this;
        }

        public MyCarBuilder year(int year) {
            this.year = year;
            return this;
        }

        public MyCarBuilder engineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public MyCarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public MyCar build() {
            return new MyCar(this);
        }
    }
}