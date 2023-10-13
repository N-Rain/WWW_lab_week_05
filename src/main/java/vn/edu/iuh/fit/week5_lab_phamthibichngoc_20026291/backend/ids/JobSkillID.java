package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.ids;

import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.Job;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.Skill;

import java.io.Serializable;
import java.util.Objects;

public class JobSkillID implements Serializable {
    private Skill skill;
    private Job job;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobSkillID that)) return false;
        return Objects.equals(skill, that.skill) && Objects.equals(job, that.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skill, job);
    }
}
