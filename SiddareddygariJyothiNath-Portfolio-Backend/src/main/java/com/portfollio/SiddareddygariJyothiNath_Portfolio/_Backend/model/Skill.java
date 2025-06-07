package com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.model;

import jakarta.persistence.*;


@Entity
public class Skill {
    @Id
    @GeneratedValue
    private Long id;

    private String name;        // e.g., "Java", "React", "AWS"
    private String category;    // e.g., "Frontend", "Backend", "DevOps"
    private int proficiency;    // 1–100 (to show in progress bar)
    private String iconUrl;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

        // optional icon for UI
}
