package com.contrado.source;

import java.util.HashMap;
import java.util.Map;

public class ProjectConstants {

    public static int formProductPrice;
    public static int detailProductPrice;
    private static Map<String, Integer> priceVal = new HashMap<>();

    public static void setFormProductPrice(int price) {
        priceVal.put("formProductPrice", price);
    }

    public static int getFormProductPrice() {
        return priceVal.get("formProductPrice");
    }

    public static void setDetailProductPrice(int price) {
        priceVal.put("detailProductPrice", price);
    }

    public static int getDetailProductPrice() {
        return priceVal.get("detailProductPrice");
    }

}
