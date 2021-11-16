/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akursat.second;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JobSeeker {

    @Translatable
    Map<String, String> description;

    @Translatable
    Map<String, String> name;

    @Translatable
    NestedModel nestedModel;

    public Map<String, String> getDescriptions() {
        return description;
    }

    public void setDescriptions(Map<String, String> descriptions) {
        this.description = descriptions;
    }

    public JobSeeker() {
        description = new HashMap<>(); description.put("ingridient", "salami");
        name = new HashMap<>(); name.put("ingridient", "salami");
        nestedModel = new NestedModel();
        Map<String,String> name = new HashMap<>();
        name.put("nested","nested");
        nestedModel.setName(name);
    }

    public JobSeeker(Map descriptions) {
        this.description = descriptions;
    }

    public Map<String, String> getName() {
        return name;
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }


}
