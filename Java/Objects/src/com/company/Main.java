package com.company;


public class Main {

    static int x = 5;

    public static void main(String[] args) {
        /*
        Person p = new Person();
        p.name = "Maayan";
        p.age = 29;
        p.male = true;

        Person p2 = new Person();
        System.out.println(p2);

        int y = 87;

        sum();
        System.out.println(x);
        */


        Vehicle v = new Vehicle("BMW", "green", 5, 4, 18000, 190, 1984, true);
        Vehicle v2 = new Vehicle("Fiat", "Blue", 4, 2, 200000, 205, 1955, false);


        //System.out.println(v.getPrice());
        v.setPrice(40000);
        v.setColor("pink");
        System.out.println(v.getPrice());
        System.out.println(v2.getPrice());
        System.out.println((v.getPrice() + v2.getPrice()) * 0.95);





    }

    /*
    public static void printNumbers(){
        x = 7;
    }

    public static void sum(){
        x += 6;
    }
    */
}
