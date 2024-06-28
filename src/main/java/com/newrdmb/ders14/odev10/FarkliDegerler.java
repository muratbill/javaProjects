package com.newrdmb.ders14.odev10;
import java.util.ArrayList;

public class FarkliDegerler<T> {
   private T deger;
   private ArrayList<T> mylist;
   public FarkliDegerler(){
       mylist = new ArrayList<>();

   }
   public void setDeger(T deger){
       this.deger = deger;
   }

    public void addElement(T sayi) {
        mylist.add(sayi);
    }
   public T getDeger(){
       return deger;
   }
    public T getElement(int index) {
        return mylist.get(index);
    }
}
