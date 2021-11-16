/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akursat.second;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author johan
 */
public class MainClass {


    public static void main(String[] args) throws IllegalAccessException {
        JobSeeker jobSeeker = new JobSeeker();
        String language = "EN";
        modifyDescription(jobSeeker, language);
        System.out.println(jobSeeker);

    }


    public static void modifyDescription(Object object, String language) throws IllegalAccessException {
        Set<Field> fieldSet2 = new HashSet<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(Translatable.class))
                fieldSet2.add(field);
        }
        for (Field field : fieldSet2) {
            if (!(field.get(object) instanceof Map)) {
                if (field.get(object) instanceof Iterable && field.get(object)!=null) {
                    Iterable objectList = (Iterable) field.get(object);
                    for (Object ob : objectList) {
                        if(ob instanceof Map)
                            doSomethingToObject(field, ob, language);
                        else
                            modifyDescription(ob, language);
                    }
                } else {
                    if(field.get(object)!=null)
                    modifyDescription(field.get(object), language);
                }
            }else{
                doSomethingToObject(field, object, language);
            }
        }
    }

    private static void doSomethingToObject(Field field, Object object, String language) {
        try {
            field.setAccessible(true);
            Map<String, String> description;
            if(!(object instanceof Map))
                description = (Map<String, String>) (field.get(object));
            else
                description = (Map<String, String>) (object);
//            boolean enFilled = description.get("EN") != null || !description.get("EN").isEmpty();
//            boolean arFilled = description.get("AR") != null || !description.get("AR").isEmpty();
            if (language.equals("EN")) {
                //FILL AR
//                description.put("AR", translations in AR of description.get("EN"));
                description.put("AR", "arabic");
//                field.set(object, description);
            }
            if (language.equals("AR")) {
                //FILL EN
//                description.put("EN", translations in EN of description.get("AR"));
                description.put("EN", "english");
//                field.set(object, description);
            }
//            field.set(object, description);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
