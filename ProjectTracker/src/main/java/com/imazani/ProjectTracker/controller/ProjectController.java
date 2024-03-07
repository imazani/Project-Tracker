package com.imazani.ProjectTracker.controller;

import com.imazani.ProjectTracker.dto.ProjectDetails;
import com.imazani.ProjectTracker.model.Project;
import com.imazani.ProjectTracker.repository.ProjectRepository;
import com.imazani.ProjectTracker.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectController(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<Project> findAll(){
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Project findByID(@PathVariable("id") Project project) {
        return project;
    }

    @GetMapping("/{id}/details")
    public ProjectDetails getProjectDetails(@PathVariable("id") Project project) {
        return new ProjectDetails(project, userRepository.findById(project.getUser().getId()).get());
    }
}
