package com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.controller;


import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.model.Experience;
import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin(origins = "*")
public class ExperienceController {

    @Autowired
    private ExperienceRepository experienceRepository;

    @GetMapping
    public List<Experience> getAllExperience() {
        return experienceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Experience getExperienceById(@PathVariable Long id) {
        return experienceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experience not found with ID: " + id));
    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceRepository.save(experience);
    }

    @PutMapping("/{id}")
    public Experience updateExperience(@PathVariable Long id, @RequestBody Experience updatedExperience) {
        return experienceRepository.findById(id).map(experience -> {
            experience.setJobTitle(updatedExperience.getJobTitle());
            experience.setCompany(updatedExperience.getCompany());
            experience.setDescription(updatedExperience.getDescription());
            experience.setLocation(updatedExperience.getLocation());
            experience.setStartDate(updatedExperience.getStartDate());
            experience.setEndDate(updatedExperience.getEndDate());
            return experienceRepository.save(experience);
        }).orElseThrow(() -> new RuntimeException("Experience not found with ID: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Long id) {
        experienceRepository.deleteById(id);
    }
}
