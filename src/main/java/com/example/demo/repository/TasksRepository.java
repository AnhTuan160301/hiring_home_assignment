package com.example.demo.repository;

import com.example.demo.entity.Tasks;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface TasksRepository extends  CrudRepository<Tasks, String> {


    Optional<Tasks> findById(String id);

}
