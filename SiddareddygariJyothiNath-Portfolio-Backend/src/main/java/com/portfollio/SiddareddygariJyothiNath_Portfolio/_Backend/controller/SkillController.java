package com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.controller;

import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.model.Skill;
import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "*")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @PostMapping
    public Skill createSkill(@RequestBody Skill skill) {
        return skillRepository.save(skill);
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id, @RequestBody Skill updatedSkill) {
        return skillRepository.findById(id).map(skill -> {
            skill.setName(updatedSkill.getName());
            skill.setCategory(updatedSkill.getCategory());
            skill.setProficiency(updatedSkill.getProficiency());
            skill.setIconUrl(updatedSkill.getIconUrl());
            return skillRepository.save(skill);
        }).orElseThrow(() -> new RuntimeException("Skill not found with ID: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillRepository.deleteById(id);
    }
}
