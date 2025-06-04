package com.api.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.api.models.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {

    boolean existsByName(String name);

}
