package com.newrdmb.ders15.odev11;

public class MySingleton {
    private static MySingleton mySingleton;
    private MySingleton(){}
    public static MySingleton getInstance(){
        if(mySingleton == null){
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }
    public void myMessage(){
        System.out.println("My name is Murat. Do not call me again and again!!");
    }
}
