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

    public String getSkill_description() {
        return skill_description;
    }

    public void setSkill_description(String skill_description) {
        this.skill_description = skill_description;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public List<JobSkill> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(List<JobSkill> jobSkills) {
        this.jobSkills = jobSkills;
    }

    public List<CandidateSkill> getCandidateSkills() {
        return candidateSkills;
    }

    public void setCandidateSkills(List<CandidateSkill> candidateSkills) {
        this.candidateSkills = candidateSkills;
    }



    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skill_description='" + skill_description + '\'' +
                ", skill_name='" + skill_name + '\'' +
                ", type=" + type +
                ", jobSkills=" + jobSkills +
                ", candidateSkills=" + candidateSkills +
                '}';
    }
}
