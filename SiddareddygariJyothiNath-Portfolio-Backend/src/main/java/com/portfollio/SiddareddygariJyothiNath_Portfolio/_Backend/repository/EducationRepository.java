package com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.repository;


import com.portfollio.SiddareddygariJyothiNath_Portfolio._Backend.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
