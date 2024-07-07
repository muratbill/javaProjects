package com.newrdmb.ders15.odev11;

public class MyCar {
     final  String make;
    final  String model;
    final  int year;
    final  String engineType;
    final  String color;
    private MyCar(MyCarBuilder myCarBuilder){
        this.make = myCarBuilder.make;
        this.model = myCarBuilder.model;
        this.year = myCarBuilder.year;
        this.engineType = myCarBuilder.engineType;
        this.color = myCarBuilder.color;
    }


    @Override
    public String toString() {
        return STR."Car{make='\{make}\{'\''}, model='\{model}\{'\''}, year=\{year}, color='\{color}\{'\''}, engineType='\{engineType}\{'\''}\{'}'}";
    }
    public static MyCarBuilder builder(String make) {
        return new MyCarBuilder(make);
    }
    public static  class MyCarBuilder {
        private final String make;
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