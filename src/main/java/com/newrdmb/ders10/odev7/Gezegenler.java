package com.newrdmb.ders10.odev7;

public enum Gezegenler{
    MERCURY(1,57.9,2440,58.6),
    VENUS(2,108.2,6052,243),
    EARTH(3,149.6,6371,24),
    MARS(4,227.9,3390,24.6),
    Jupiter(5,778.5,69911,9.93),
    Saturn(6,1430,58232,10.7),
    Uranus(7,2870,25362,17.24),
    Neptune(8,4500,24622,16.11);
    private int siraNo;
    private double distanceFromSun;
    private double radius;
    private double rotationSpeed;
    Gezegenler(int siraNo,double distanceFromSun,double radius,double rotationSpeed){
        this.siraNo = siraNo;
        this.distanceFromSun = distanceFromSun;
        this.radius = radius;
        this.rotationSpeed = rotationSpeed;
    }
    public int getSiraNo(){
        return siraNo;
    }
    public double getDistanceFromSun(){
        return distanceFromSun;
    }
    public double getRadius(){
        return radius;

    }
    public double getRotationSpeed(){
        return rotationSpeed;
    }


}
