package com.example.demo.controller.RequestModel;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatingTaskRequest {

    @NotBlank(message = "Cannot Blank or Null")
    private String title;

    @NotBlank(message = "Cannot Blank or Null")
    private String description;
}
