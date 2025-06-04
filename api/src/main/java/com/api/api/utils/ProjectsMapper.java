package com.api.api.utils;

import java.util.List;

import com.api.api.dto.ProjectsDto;
import com.api.api.models.Projects;

public class ProjectsMapper {

    public static ProjectsDto toDto(Projects project) {
        ProjectsDto dto = new ProjectsDto();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setVotes(project.getVotes());
        return dto;
    }

    public static Projects toEntity(ProjectsDto dto) {
        Projects project = new Projects();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setVotes(dto.getVotes());
        return project;
    }
    public static List<ProjectsDto> toDtoList(List<Projects> projects) {
        return projects.stream()
                .map(ProjectsMapper::toDto)
                .toList();
    }

}
