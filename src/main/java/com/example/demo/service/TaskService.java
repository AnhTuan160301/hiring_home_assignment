package com.example.demo.service;

import com.example.demo.entity.Tasks;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public interface TaskService {

    void save(Tasks tasks);

    void delete(Tasks tasks);

    Optional<Tasks> getById(String id);

    List<Tasks> getAllTasks();


}
