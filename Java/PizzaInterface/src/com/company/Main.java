package com.company;

public class Main {

    public static void main(String[] args) {

        Task[] tasks = new Task[3];
        tasks[0] = new Task("Knead", 3);
        tasks[1] = new Task("Shape", 3);
        tasks[2] = new Task("Bake", 3);

        Project pizzaProject = new Project(tasks);

        pizzaProject.startProject();

    }
}
