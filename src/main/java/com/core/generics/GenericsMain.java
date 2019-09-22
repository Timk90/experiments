package com.core.generics;

public class GenericsMain {
    public static void main(String[] args) {
        Holder<Integer> holder;
        holder = new Holder<>(44);
        System.out.println(holder.get());
        //holder.set(6565);
        System.out.println(holder.get());

        Holder<String> holderStr;
        holderStr = new Holder<>("Hello holder");
        System.out.println(holderStr.get());
        //holderStr.set("Bye... ");
        System.out.println(holderStr.get());

        TwoTuple<Integer, Integer> twoInt = new TwoTuple<>(44, 55);
        System.out.println(twoInt.toString());
    }


}
