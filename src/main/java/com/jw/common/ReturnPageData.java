package com.jw.common;

import java.util.HashMap;
import java.util.Map;

public class ReturnPageData {

    public static Map<String, Object> fillingData(long count, Object list) {
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("data", list);
        return map;
    }
}
