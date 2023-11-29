package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.N;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.enums.SkillLevel;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.ids.CandidateSkillID;

@Entity
@Table(name = "candidate_skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CandidateSkillID.class)
public class CandidateSkill {

    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    @Column(name = "more_infos", length = 1000)
    private String more_infos;
    @Column(name = "skill_level",nullable = false)
    private SkillLevel skillLevel;

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getMore_infos() {
        return more_infos;
    }

    public void setMore_infos(String more_infos) {
        this.more_infos = more_infos;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }



    @Override
    public String toString() {
        return "CandidateSkill{" +
                "skill=" + skill +
                ", candidate=" + candidate +
                ", more_infos='" + more_infos + '\'' +
                ", skillLevel=" + skillLevel +
                '}';
    }
}
