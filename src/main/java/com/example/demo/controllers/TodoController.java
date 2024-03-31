package com.example.demo.controllers;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @Autowired private TodoService todoService;

    @PostMapping("/")
    public ResponseEntity<?> createTask(@RequestBody Todo task){
        try{
            return ResponseEntity.ok(todoService.createTask(task));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllTasks(){
        try{
            return ResponseEntity.ok(todoService.getAllTasks());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable Long taskId, @RequestBody Todo task){
        try{
            return ResponseEntity.ok(todoService.updateTask(taskId, task));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId){
        try{
            return ResponseEntity.ok(todoService.deleteTask(taskId));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
