package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.enums.SkillLevel;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.enums.SkillType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long id;

    @Column(name = "skill_description", nullable = false)
    private String skill_description;

    @Column(name = "skill_name", nullable = false)
    private String skill_name;

    @Column(name = "type", nullable = false)
    private SkillType type;

    @OneToMany(mappedBy = "skill")
    private List<JobSkill> jobSkills;

    @OneToMany(mappedBy = "skill")
    private List<CandidateSkill> candidateSkills;

}
