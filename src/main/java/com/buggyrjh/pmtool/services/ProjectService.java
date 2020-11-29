package com.buggyrjh.pmtool.services;

import com.buggyrjh.pmtool.domain.Project;
import com.buggyrjh.pmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        // Add logic
        return projectRepository.save(project);
    }
}
