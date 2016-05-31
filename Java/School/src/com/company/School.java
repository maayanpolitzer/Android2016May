package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 5/30/2016.
 */
public class School {

    private ArrayList<Person> list;

    public School(){
        list = new ArrayList<>();
    }

    public void add(Person person){
        list.add(person);
    }

    public void sayHelloToAll(){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) instanceof Employee) {
                list.get(i).sayHi();
            }
        }
    }


}
