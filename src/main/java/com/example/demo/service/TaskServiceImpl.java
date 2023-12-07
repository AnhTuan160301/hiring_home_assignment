package com.example.demo.service;

import com.example.demo.entity.Tasks;
import com.example.demo.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{


    private final TasksRepository taskRepository;

    public TaskServiceImpl(TasksRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void save(Tasks tasks) {
        taskRepository.save(tasks);

    }

    @Override
    public void delete(Tasks tasks) {
        taskRepository.delete(tasks);

    }

    @Override
    public Optional<Tasks> getById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return (List<Tasks>) taskRepository.findAll();
    }
}
