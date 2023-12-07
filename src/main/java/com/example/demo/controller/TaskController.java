package com.example.demo.controller;

import com.example.demo.controller.RequestModel.CreatingTaskRequest;
import com.example.demo.controller.RequestModel.UpdateTaskRequest;
import com.example.demo.controller.response.TaskResponse;
import com.example.demo.entity.Tasks;
import com.example.demo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(APIName.TASKS)
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> addTask(@Valid @RequestBody CreatingTaskRequest taskRequest){

        Tasks tasks = new Tasks();

        if(taskRequest.getTitle() != null){
            tasks.setTitle(taskRequest.getTitle().trim());
        }
        if(taskRequest.getDescription() != null){
            tasks.setDescription(taskRequest.getDescription().trim());
        }
        taskService.save(tasks);

        return new ResponseEntity<>("Create Successfully", HttpStatus.OK);
    }

    @RequestMapping(path = APIName.ID, method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> updateTask(@PathVariable(name = "id") String id,
                             @RequestBody UpdateTaskRequest updateTaskRequest){
        Optional<Tasks> tasks = taskService.getById(id);

        if(tasks.isEmpty()){
            return new ResponseEntity<>("Cannot find task", HttpStatus.NOT_FOUND);
        }
        Tasks updateTask = tasks.get();
        if (updateTaskRequest.getTitle() != null && !updateTaskRequest.getTitle().trim().isEmpty() && !updateTaskRequest.getTitle().equals(updateTask.getTitle())) {
            updateTask.setTitle(updateTaskRequest.getTitle());
        }
        if (updateTaskRequest.getDescription() != null && !updateTaskRequest.getDescription().trim().isEmpty() && !updateTaskRequest.getDescription().equals(updateTask.getDescription())) {
            updateTask.setDescription(updateTaskRequest.getDescription());
        }
        if(updateTaskRequest.getIsCompleted() != null){
            updateTask.setCompleted(updateTaskRequest.getIsCompleted());
        }
        taskService.save(updateTask);
        return new ResponseEntity<>("Update Successfully", HttpStatus.OK);
    }

    @RequestMapping(path = APIName.ID, method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deleteTask(@PathVariable(name = "id") String id){

        Optional<Tasks> tasks = taskService.getById(id);
        if(tasks.isEmpty()){
            return new ResponseEntity<>("Cannot find task", HttpStatus.NOT_FOUND);
        }
        Tasks deleteTask = tasks.get();
        taskService.delete(deleteTask);
        return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
    }

    @RequestMapping(path = APIName.ID, method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<?> getTaskById(@PathVariable(name = "id") String id){
        Optional<Tasks> tasks = taskService.getById(id);
        if(tasks.isEmpty()){
            return new ResponseEntity<>("Cannot find task", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<TaskResponse>(new TaskResponse(tasks.get()) ,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<?> getAllTasks(){
        List<Tasks> tasks = taskService.getAllTasks();
        List<TaskResponse> taskResponses = tasks.stream().map(TaskResponse::new).collect(Collectors.toList());
        return new ResponseEntity<>(taskResponses, HttpStatus.OK);
    }
}
