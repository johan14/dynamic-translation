/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akursat.second;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akursat
 */
public class MainClass {

    private ArrayList<Result> result;
    private List<String> cleanList;
    private List<Object> referencelist;

    public static void main(String[] args) {
        MainClass mc = new MainClass();

        Collection<File> all = new ArrayList<File>();
        mc.addTree(new File("./target/classes/com/akursat/second"), all);
        mc.selectClasses(all);

        mc.instanceList();
        mc.loadAnnotatedClases();
    }

    // return all .java files in package
    void addTree(File file, Collection<File> all) {
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                all.add(child);
                addTree(child, all);
            }
        }
    }

    //fix name of files
    void selectClasses(Collection<File> all) {
        cleanList = new ArrayList<>();
        for (File file : all) {
            cleanList.add(file.toString().substring(file.toString().lastIndexOf("/") + 1).replace(".class", ""));
        }

    }

    //Create Object list with newInstace
    Object createObject(String className) {
        Object object = null;
        try {
            Class classDefinition = Class.forName(className);
            object = classDefinition.newInstance();
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return object;
    }

    //Create reference list
    void instanceList() {
        referencelist = new ArrayList<>();
        Object[] o = new Object[cleanList.size()];

        int i = 0;
        for (String className : cleanList) {
            try {
                o[i] = (Object) createObject("com.akursat.second." + className.toString());
                referencelist.add(o[i]);
            } catch (java.lang.UnsupportedOperationException ex) {
                // Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                i++;
            }

        }

    }

    void loadAnnotatedClases() {
        result = new ArrayList<>();
        try {
            // get price for each of class
            for (Object object : referencelist) {
                if (object == null) {
                } else {
                    Food canno = object.getClass().getAnnotation(Food.class);
                    Method[] methodK = object.getClass().getMethods();
                    int time = 0;
                    for (Method method : methodK) {
                        Time manno = method.getAnnotation(Time.class);
                        if (manno != null) {
                            time += manno.takes();
                        }
                    }
                    if (canno != null) {
                        result.add(new Result(object.getClass().getName(), canno.price(), time));
                    }
                }
            }
        } catch (SecurityException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Result arg : result) {
            System.out.println("Result:" + arg.getName() + " /   " + arg.getPrice() + " /  " + arg.getTime());
        }
    }

}
