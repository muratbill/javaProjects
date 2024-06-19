package com.newrdmb.ders11.odev8;

class Todo {
    private String task;
    private boolean completed;

    public Todo(String task) {
        this.task = task;
        this.completed = false;
    }

    public String getTask() {
        return task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    @Override
    public String toString() {
        return "Task: "  + task + " (Completed: " + completed + ")";
    }
}