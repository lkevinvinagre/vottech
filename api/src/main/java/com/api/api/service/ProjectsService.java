package com.api.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.dto.ProjectsDto;
import com.api.api.dto.ResponseModel;
import com.api.api.models.Projects;
import com.api.api.repository.ProjectsRepository;
import com.api.api.utils.ProjectsMapper;

@Service
public class ProjectsService {

    @Autowired
    private ProjectsRepository projectsRepo;

    public List<ProjectsDto> getAllProjects() 
    {
        List<Projects> search = projectsRepo.findAll();
        if(search.isEmpty())return List.of();
        return ProjectsMapper.toDtoList(search);
    }
    public ResponseModel createProject(ProjectsDto projectData)
    {
        ResponseModel response = new ResponseModel();
        try
        {
            if(projectsRepo.existsByName(projectData.getName()))
            {
                response.setMessage("Projeto já existe");
                response.setStatus(409);
                return response;
            }
            Projects project = ProjectsMapper.toEntity(projectData);
            projectsRepo.save(project);
            response.setMessage("Projeto criado com sucesso");
            response.setStatus(201);
            return response;
        }
        catch (Exception e)
        {
            response.setMessage("Erro ao criar projeto: " + e.getMessage());
            response.setStatus(500);
            return response;
        }
    }
}
