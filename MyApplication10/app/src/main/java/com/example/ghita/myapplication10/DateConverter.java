package com.example.ghita.myapplication10;

/**
 * Created by Omar on 20/01/2017.
 */
import java.util.Map;
import java.util.HashMap;

public class DateConverter {

    static Map<Integer, String> map = new HashMap<Integer, String>();
    public static String getMonth(int month){
        map.put(0,"Janvier");
        map.put(1,"Février");
        map.put(2,"Mars");
        map.put(3,"Avril");
        map.put(4,"Mai");
        map.put(5,"Juin");
        map.put(6,"Juillet");
        map.put(7,"Août");
        map.put(8,"Septembre");
        map.put(9,"Octobre");
        map.put(10,"Novembre");
        map.put(11,"Décembre");
        String smonth;
        smonth = map.get(month);
        return smonth;
    }
}
