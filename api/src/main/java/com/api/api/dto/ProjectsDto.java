package com.api.api.dto;

import lombok.Data;

@Data
public class ProjectsDto {

    private Long id;
    private String name;
    private String description;
    private int votes;

    public ProjectsDto() {
        // Default constructor
    }

}
