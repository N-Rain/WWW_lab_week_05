package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.services.CandidateServices;

@RestController("/api/vi")
public class CandidateResources {
    @Autowired
    private CandidateServices services;
}