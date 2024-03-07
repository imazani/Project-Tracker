package com.imazani.ProjectTracker.repository;

import com.imazani.ProjectTracker.model.Project;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

    @Query("SELECT * FROM POST WHERE assignedTo = :id")
    List<Project> findByUser(Integer id);
}
