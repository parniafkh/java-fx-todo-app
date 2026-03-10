package com.parnia.todo;

public class TodoTask {
    private String title;
    private boolean completed;
    public TodoTask(String title) {
        this.title = title;
        this.completed = false;
    }
        // Getter und Setter
        public String getTitle() { return title; }
        public boolean isCompleted() { return completed; }
        public void setCompleted(boolean completed) { this.completed = completed; }

    @Override
    public String toString(){
        return (completed ? "[ERLEDIGT] " : "") + title;
    }

}
