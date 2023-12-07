package com.fat_fire_face.taskmanager;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //скорректировать по требованиям валидации
    final int EMAIL_MIN_LENGTH = 3;
    final int EMAIL_MAX_LENGTH = 320;
   @NotBlank(message = "поле не может быть пустым")
   @Size(min = EMAIL_MIN_LENGTH, max = EMAIL_MAX_LENGTH, message = "адрес электорнной почты должен содержать от 3 до 320 символов")
   @Email(message = "адрес электронной почты должен содержать локальное имя, символ @ и доменное имя. Например, user123!@example.com")
    private String username;
    private String password;

    @OneToMany(mappedBy = "author")
    private List<Task> tasks;

    public Author(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public List<Task> getAllAuthorTasks(){
        return tasks;
    }
}
