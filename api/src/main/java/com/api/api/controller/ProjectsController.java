package com.api.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.dto.ProjectsDto;
import com.api.api.dto.ResponseModel;
import com.api.api.models.Projects;
import com.api.api.service.ProjectsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/projects")
public class ProjectsController {

    @Autowired
    private ProjectsService projectsService;

    @GetMapping("/list")
    public ResponseEntity<List<ProjectsDto>> listProjects() {
        List<ProjectsDto> projects = projectsService.getAllProjects();
        if(!projects.isEmpty()) {
            return ResponseEntity.status(201).body(projects);
        } else {
            return ResponseEntity.status(404).body(List.of());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseModel> postMethodName(@RequestBody ProjectsDto projectData) {
        ResponseModel response = projectsService.createProject(projectData);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    
    

}
