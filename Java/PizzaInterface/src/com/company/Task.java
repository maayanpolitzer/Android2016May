package com.company;

/**
 * Created by hackeru on 6/6/2016.
 */
public class Task {

    private String name;
    private boolean isComplete;
    private OnTaskFinishListener project;
    private int duration;

    public Task(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public void startTask(){
        System.out.println(name + " task started");
        startPrepare();
    }

    public void setProject(Project project){
        this.project = project;
    }

    private void startPrepare(){
        try {
            Thread.sleep(duration * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doneTask();
    }

    private void doneTask(){
        isComplete = true;
        System.out.println(name + " task is Done!!!");
        project.checkAllTasks();
    }

    public boolean isComplete() {
        return isComplete;
    }
}
