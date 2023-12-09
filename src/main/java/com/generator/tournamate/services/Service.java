package com.generator.tournamate.services;

import java.util.Collections;
import java.util.List;
public class Service {
    public static List shuffle(List list){
        Collections.shuffle(list);
        return list;
    }
    public static List sort(List list){
        Collections.sort(list);
        return list;
    }


}
