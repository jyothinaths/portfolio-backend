package com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.controller;

import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.model.Project;
import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {
    @Autowired
    private ProjectRepository repo;

    @GetMapping
    public List<Project> getAll() { return repo.findAll(); }

    @PostMapping public Project create(@RequestBody Project p) { return repo.save(p); }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable Long id, @RequestBody Project p) {
        return repo.findById(id).map(existing -> {
            p.setId(id);
            return ResponseEntity.ok(repo.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
