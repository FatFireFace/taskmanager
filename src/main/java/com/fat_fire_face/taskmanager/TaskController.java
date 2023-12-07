package com.fat_fire_face.taskmanager;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private AuthorService authorService;

    @Operation(summary = "Получить список всех задач")
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @Operation(summary = "Выводит задачу по заданному ID")
    @GetMapping("/{taskID}")
    public Task getTaskById(@PathVariable Long taskId){
        return taskService.getTaskById(taskId);
    }

    @Operation(summary = "Изменяет задачу под заданым ID")
    @PutMapping("/{taskID}")
    public Task updateTask(@PathVariable Long taskID, @RequestBody Task task){
        return taskService.updateTask(taskID, task);
    }

    @Operation(summary = "Создает новую задачу")
    @PostMapping
    public Task createTask(@RequestBody Task task, @RequestParam Long authorId){
        Author author = authorService.getAuthorById(authorId);
        if (author != null) {
        return taskService.createTask(task, author);}
    else return null;
    }

    @Operation(summary = "Удаляет задачу под выбранным ID")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }

    @Operation(summary = "Удаляет все задачи")
    @DeleteMapping
    public void deleteAllTasks(){
        taskService.deleteAllTasks();
    }
}
