package com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.controller;

import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.model.About;
import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.repository.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about")
@CrossOrigin("*")
public class AboutController {

    @Autowired
    private AboutRepository aboutRepository;

    @GetMapping
    public List<About> getAbout() {
        return aboutRepository.findAll();
    }

    @PostMapping
    public About create(@RequestBody About about) {
        return aboutRepository.save(about);
    }

    @PutMapping("/{id}")
    public About update(@PathVariable Long id, @RequestBody About aboutDetails) {
        About about = aboutRepository.findById(id).orElseThrow();
        about.setFullName(aboutDetails.getFullName());
        about.setTitle(aboutDetails.getTitle());
        about.setSummary(aboutDetails.getSummary());
        about.setProfileImageUrl(aboutDetails.getProfileImageUrl());
        about.setResumeUrl(aboutDetails.getResumeUrl());
        about.setLocation(aboutDetails.getLocation());
        about.setEmail(aboutDetails.getEmail());
        about.setPhone(aboutDetails.getPhone());
        about.setLinkedInUrl(aboutDetails.getLinkedInUrl());
        about.setGithubUrl(aboutDetails.getGithubUrl());
        return aboutRepository.save(about);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        aboutRepository.deleteById(id);
    }
}
