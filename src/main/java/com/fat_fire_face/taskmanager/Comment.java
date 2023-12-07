package com.fat_fire_face.taskmanager;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)

    public Long getId(){
        return id;
    }

    public String getText(){
        return text;
    }

    public Task getTask(){
        return task;
    }


    public void setText(String text){
        this.text = text;
    }

    public void setTask(Task task){
        this.task = task;
    }
}
