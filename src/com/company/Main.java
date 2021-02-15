package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("seznam-spolecnosti.dat"));
        String line;
        int i = 0;
        String[] spolecnosti = new String[10];
        while ((line = br.readLine()) != null) {
            spolecnosti[i] = line;
            i++;
        }
        String[] soubory = {"VF_2015.dat", "VF_2016.dat", "VF_2017.dat", "VF_2018.dat", "VF_2019.dat", "VF_2020.dat"};
        for (int j = 0; j < soubory.length; j++) {
            BufferedReader soubor = new BufferedReader(new FileReader(soubory[j]));
            String[] csvsoubor = soubory[j].split(".");
            String csvfile = soubory[j] + ".csv";
            BufferedWriter csv = new BufferedWriter(new FileWriter(csvfile));
            String radek;
            while ((radek = soubor.readLine())!= null){
                String[] polozky = radek.split(String.valueOf(','));
                String ico = polozky[1];
                for (int k = 0; k < i; k++) {
                    String[] spolecnost = spolecnosti[k].split(":");
                    //System.out.println(ico + " " + spolecnost[1]);
                    if (ico.equals(spolecnost[1])){
                        System.out.println(polozky[0] + "," + spolecnost[0] + "," + polozky[2]);
                        csv.write(polozky[0] + "," + spolecnost[0] + "," + polozky[2] + "\r\n");
                    }
                    //else {
                      //  BufferedWriter
                    //}
                }
            }
        }
    }
}
