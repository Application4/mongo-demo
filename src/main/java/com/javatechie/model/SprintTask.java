package com.javatechie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//if you will not specify collection then it will create a collection with your model class or document class name
// (RDBMS) Schema = (NOSQL) database
// (RDBMS) Table = (NoSQL) collection
@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SprintTask {

    @Id
    private String taskId;
    private String description;
    private int severity;
    private String assignee;
    private int storyPoint;
}
