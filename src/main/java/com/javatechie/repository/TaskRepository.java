package com.javatechie.repository;

import com.javatechie.model.SprintTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<SprintTask,String> {
    List<SprintTask> findBySeverity(int severity);

    @Query(value = "{assignee : ?0}",fields = "{'description' : 1, 'severity' : 2}")
    List<SprintTask> getTaskByAssignee(String assignee);


    @Query("{assignee: ?0, severity: ?1}")
    List<SprintTask> getTaskByAssigneeAndSeverity(String assignee,int severity);


}
