package com.fat_fire_face.taskmanager;

import jakarta.persistence.*;

@Entity
public class Task {
    //тело задачи
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private String assignee;


    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

        public Long getId(){
            return id;
        }

        public String getTitle(){
            return title;
        }

        public String getDescription(){
            return description;
        }

        public String getStatus(){
            return status;
        }

        public String getPriority(){
            return priority;
        }

        public Author getAuthor(){
            return author;
        }

        public String getAssignee(){
            return assignee;
        }


        public void setTitle(String title){
            this.title = title;
        }

        public void setDescription(String description){
            this.description = description;
        }

        public void setStatus(String status){
            this.status = status;
        }

        public void setPriority(String priority){
            this.priority = priority;
        }
        //изменить стринговое имя автора на класс Author, связав с id, количеством задач и валидацией
        public void setAuthor(Author author){
            this.author = author;
        }

        public void setAssignee(String assignee){
            this.assignee = assignee;
        }
}
