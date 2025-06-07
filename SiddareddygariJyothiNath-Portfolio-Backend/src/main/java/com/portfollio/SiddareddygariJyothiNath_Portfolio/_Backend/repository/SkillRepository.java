package com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.repository;

import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByCategory(String category); // Optional: filter by category
}
