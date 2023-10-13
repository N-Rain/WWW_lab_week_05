package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.ids;

import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.Candidate;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.Skill;

import java.io.Serializable;
import java.util.Objects;

public class CandidateSkillID implements Serializable {
    private Skill skill;
    private Candidate candidate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidateSkillID that)) return false;
        return Objects.equals(skill, that.skill) && Objects.equals(candidate, that.candidate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skill, candidate);
    }
}
