package com.fat_fire_face.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task updateTask(Long taskID, Task updatedTask){
        Optional<Task> currentTaskOptional = taskRepository.findById(taskID);
            if (currentTaskOptional.isPresent()){
                Task currentTask = currentTaskOptional.get();
                currentTask.setTitle(updatedTask.getTitle());
                currentTask.setDescription(updatedTask.getDescription());
                currentTask.setAssignee(updatedTask.getAssignee());
                currentTask.setAuthor(updatedTask.getAuthor());
                currentTask.setPriority(updatedTask.getPriority());
                currentTask.setStatus(updatedTask.getStatus());
                return taskRepository.save(currentTask);
            }
            else return null;
            }

    public Task getTaskById(Long taskId){
        return taskRepository.findById(taskId).
                orElseThrow(() -> new NoSuchElementException("задача с ID: "+ taskId + " не найдена"));
    }

    public Task createTask(Task task, Author author){
        task.setAuthor(author);
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }
}
