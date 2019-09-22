package com.broadening.spectra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BroadeningMain broadeningMain = new BroadeningMain();
        System.out.println("Initial set up is: " + broadeningMain);
        System.out.println("Хотите поменять стандартные установки? [y/n]");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;

        try {
            while (flag){
                String str = in.readLine();
                if (str.equals("y")) {
                    flag = !flag;

                    boolean flag1 = true;
                    while (flag1) {
                        System.out.println("Тип уширения:" + BroadType.values());
                        String broadType = in.readLine();
                        if(broadType.equals(BroadType.valueOf(broadType))) {
                            broadeningMain.setBroadeningType(BroadType.valueOf(broadType));
                            flag1 = !flag1;
                        }else{
                            System.out.println("Некорректный тип уширения... Допустимы "+BroadType.values());
                        }
                        System.out.println("Тип уширения изменен:" + broadeningMain);

                    }
                } else if (str.equals("n")) {
                    System.out.println("Используем стандартные параметры для КР спектра");
                    flag = !flag;
                } else {
                    System.out.println("Неправильное значение аргумента ввода. Допустипо y или n");
                }
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }


        broadeningMain.readFromFile("spectra_xy.txt");
        broadeningMain.broadening();
        broadeningMain.writeToFile("out.txt");
    }
}
