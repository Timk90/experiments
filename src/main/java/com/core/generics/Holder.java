package com.core.generics;


public class Holder<T> {
    //private T type; - не удастся получить доступ
    public final T type; //вместо этого можно так
    Holder(T a){
        this.type = a;
    }

    public T get(){
        return type;
    }

//    public void set(T a){
//        this.type = a;
//    }

    @Override
    public String toString() {
        return ""+type;
    }
}
