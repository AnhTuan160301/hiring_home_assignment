package com.example.demo.controller.RequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequest {

    private String title;
    private String description;
    private Boolean isCompleted;
}
