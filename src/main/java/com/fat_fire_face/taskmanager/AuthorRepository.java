package com.fat_fire_face.taskmanager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {


    Author findByUsername(String username);


    //методы...
}
