package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.enums.SkillLevel;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.ids.JobSkillID;

@Entity
@Table(name = "job_skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(JobSkillID.class)
public class JobSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "more_infos", nullable = false, length = 1000)
    private String more_infos;

    @Column(name = "skill_level", nullable = false)
    private SkillLevel skill_level;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getMore_infos() {
        return more_infos;
    }

    public void setMore_infos(String more_infos) {
        this.more_infos = more_infos;
    }

    public SkillLevel getSkill_level() {
        return skill_level;
    }

    public void setSkill_level(SkillLevel skill_level) {
        this.skill_level = skill_level;
    }


    @Override
    public String toString() {
        return "JobSkill{" +
                "job=" + job +
                ", skill=" + skill +
                ", more_infos='" + more_infos + '\'' +
                ", skill_level=" + skill_level +
                '}';
    }
}
