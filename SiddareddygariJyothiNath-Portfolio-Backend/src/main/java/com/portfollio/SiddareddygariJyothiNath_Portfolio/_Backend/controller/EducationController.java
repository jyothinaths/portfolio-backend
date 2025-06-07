package com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.controller;

import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.model.Education;
import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
@CrossOrigin(origins = "*")
public class EducationController {

    @Autowired
    private EducationRepository educationRepository;

    @GetMapping
    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Education getEducationById(@PathVariable Long id) {
        return educationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Education entry not found with ID: " + id));
    }

    @PostMapping
    public Education createEducation(@RequestBody Education education) {
        return educationRepository.save(education);
    }

    @PutMapping("/{id}")
    public Education updateEducation(@PathVariable Long id, @RequestBody Education updatedEducation) {
        return educationRepository.findById(id).map(education -> {
            education.setDegree(updatedEducation.getDegree());
            education.setInstitution(updatedEducation.getInstitution());
            education.setLocation(updatedEducation.getLocation());
            education.setStartDate(updatedEducation.getStartDate());
            education.setEndDate(updatedEducation.getEndDate());
            return educationRepository.save(education);
        }).orElseThrow(() -> new RuntimeException("Education entry not found with ID: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Long id) {
        educationRepository.deleteById(id);
    }
}
