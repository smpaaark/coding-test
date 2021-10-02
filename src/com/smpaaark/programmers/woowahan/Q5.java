package com.smpaaark.programmers.woowahan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q5 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        try {
            String inputString = "";
            List<String> list = new ArrayList<>();
            while ((inputString = br.readLine()) != null && inputString.trim().length() > 0) {
                list.add(inputString);
            }

            list.stream()
                    .map(s -> s.toUpperCase())
                    .filter(s -> s.length() >= 5 && s.length() < 10)
                        .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
