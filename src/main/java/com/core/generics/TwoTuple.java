package com.core.generics;

public class TwoTuple<T, A> extends Holder<T>{
    private A a;

    public TwoTuple(T t, A a){
        super(t);
        this.a = a;
    }

    @Override
    public String toString(){
        return ""+a+" "+type;
    }

}
