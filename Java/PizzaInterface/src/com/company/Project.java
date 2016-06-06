package com.company;

/**
 * Created by hackeru on 6/6/2016.
 */
public class Project implements OnTaskFinishListener {

    private Task[] tasks;

    public Project(Task[] tasks){
        this.tasks = tasks;
    }

    public void startProject(){
        System.out.println("Project started");
        for (int i = 0; i < tasks.length; i++){
            tasks[i].setProject(this);
            tasks[i].startTask();
        }
    }

    public void projectDone(){
        System.out.println("The project is DONE!");
    }

    @Override
    public void checkAllTasks() {
        for (int i = 0; i < tasks.length; i++){
            if (!tasks[i].isComplete()){    // tasks[i].isComplete() == false
                return;
            }
        }
        projectDone();
        /*
        int counter = 0;
        for (int i = 0; i < tasks.length; i++){
            if (tasks[i].isComplete()){
                counter++;
            }
        }
        if (counter == tasks.length){
            projectDone();
        }
        */
    }
}
