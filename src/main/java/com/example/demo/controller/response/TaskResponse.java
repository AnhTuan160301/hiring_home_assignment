package com.example.demo.controller.response;


import com.example.demo.entity.Tasks;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {
    private String title;
    private String description;
    private boolean isCompleted;

    public TaskResponse(Tasks tasks){
        this.title = tasks.getTitle();
        this.description = tasks.getDescription();
        this.isCompleted = tasks.isCompleted();

    }
}
