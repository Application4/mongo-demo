package com.javatechie;

import com.javatechie.model.SprintTask;
import com.javatechie.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RestController
@RequestMapping("/sprint/tasks")
public class MongoDemoApplication {

    @Autowired
    private TaskRepository repository;

    @PostMapping
    public SprintTask addNewTask(@RequestBody SprintTask sprintTask) {
        sprintTask.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(sprintTask);
    }

	@GetMapping
    public List<SprintTask> getAllTasksFromBoard() {
        return repository.findAll(Sort.by("severity"));
    }

	@GetMapping("/{id}")
    public SprintTask getMyTask(@PathVariable String id) {
        return repository.findById(id).get();
    }

	@GetMapping("/severity/{severity}")
	public List<SprintTask> getTaskBySeverity(@PathVariable int severity){
		return repository.findBySeverity(severity);
	}

    @GetMapping("/assignee/{assignee}")
    public List<SprintTask> getTaskByAssignee(@PathVariable String assignee){
        return repository.getTaskByAssignee(assignee);
    }

    @GetMapping("/assignee/{assignee}/severity/{severity}")
    public List<SprintTask> getTaskByAssigneeAndSeverity(@PathVariable String assignee,@PathVariable int severity){
        return repository.getTaskByAssigneeAndSeverity(assignee, severity);
    }
    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }

}
