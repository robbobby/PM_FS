package com.buggyrjh.pmtool.controllers;

import com.buggyrjh.pmtool.domain.Project;
import com.buggyrjh.pmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Stream;

import static jdk.internal.net.http.common.Log.errors;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @PostMapping("")
    public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult result) {
        if (result.hasErrors()) {
            String[] errors;
            String errorMessages[] = new Stream(result.getAllErrors()).reduce(''(errorMessageTotal, newError) -> errorMessageTotal + newError);
            return new ResponseEntity<>(String.format("Invalid Project Object in Project Post Mapping: %h",), HttpStatus.BAD_REQUEST);
        }

        this.projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
}
