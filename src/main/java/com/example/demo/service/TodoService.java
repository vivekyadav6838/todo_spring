package com.example.demo.service;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired private TodoRepository todoRepository;

    public Todo createTask(Todo task) {
        return todoRepository.save(task);
    }

    public List<Todo> getAllTasks() {
        return todoRepository.findAll();
    }

    public Todo updateTask(Long taskId, Todo task) {
        Todo task1 = todoRepository.findTodoById(taskId);
        task1.setTask(task.getTask());
        return todoRepository.save(task1);
    }

    public Todo deleteTask(Long taskId) {
        Todo task =  todoRepository.findTodoById(taskId);
        todoRepository.delete(task);
        return task;
    }
}
