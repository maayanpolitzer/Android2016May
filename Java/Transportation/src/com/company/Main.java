package com.company;

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person("Maayan", 1986, true, 32700163);
        Person p2 = new Person("Boaz", 1985, true, 342453456);

        Car c1 = new Car(p1, "BMW", 2);
        Car c2 = new Car(p1, "ALFA-ROMEO", 4);

        System.out.println(c1.getCarInfo());
        System.out.println(c1.setOwner(p1));
        System.out.println(c1.getCarInfo());
        System.out.println(p1.getName() + " is " + p1.getAge() + " years old.");
        c1.getOwner().setName("Moshe");
        System.out.println(c1.getCarInfo());
        /*
        System.out.println(c1.totalCars);
        System.out.println(c2.totalCars);
        c2.totalCars = 67;
        System.out.println(c1.totalCars);
        System.out.println(c2.totalCars);
        */
        System.out.println(Car.getTotalCars());


/*
        //System.out.println(c1.getOwner());
        c1.setOwner("Liri");
        //System.out.println(c1.getOwner());
        //System.out.println(c1.getCarInfo());
        //System.out.println(c2.getCarInfo());
        */
    }
}
