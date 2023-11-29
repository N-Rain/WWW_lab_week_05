package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.Candidate;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.repositories.CandidateRepository;

import java.util.Collections;
import java.util.List;

@Service
public class CandidateServices {
    @Autowired
    private CandidateRepository candidateRepository;
    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }

    public Page<Candidate> findPaginated(Pageable pageable){
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Candidate> candidateList;
        List<Candidate> candidates = candidateRepository.findAll();
        if (candidates.size() < startItem){
            candidateList = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, candidates.size());
            candidateList = candidates.subList(startItem, toIndex);
        }

        Page<Candidate> candidatePage = new PageImpl<>(candidateList, PageRequest.of(currentPage, pageSize), candidates.size());

        return candidatePage;
    }
}
