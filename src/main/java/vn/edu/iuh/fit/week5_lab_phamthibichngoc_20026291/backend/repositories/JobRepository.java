package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.Job;

public interface JobRepository extends JpaRepository<Job, Long> , JpaSpecificationExecutor<Job> {
}