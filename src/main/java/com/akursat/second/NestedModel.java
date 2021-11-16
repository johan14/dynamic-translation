package com.akursat.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedModel {

    public Map<String, String> getName() {
        return name;
    }

    public NestedModel() {
        map = new HashMap<>();
        map.put("hi","hi");
        list = new ArrayList<>();
        list.add(map);
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }

    @Translatable
    Map<String, String> name;

    @Translatable
    List<Map<String,String>> list;

    Map<String ,String> map;


}
