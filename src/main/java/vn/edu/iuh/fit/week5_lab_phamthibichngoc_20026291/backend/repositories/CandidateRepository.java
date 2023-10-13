package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}