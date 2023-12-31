package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.Address;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.Candidate;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.services.CandidateServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateServices candidateServices;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/list")
    public String showCandidateList(Model model){
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/list_no_paging";
    }

    @GetMapping("/candidates")
    public String showCandidateListPaging(Model model, @RequestParam("page")Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage = candidateServices.findAll(currentPage - 1, pageSize, "id", "asc");
        model.addAttribute("candidatePage", candidatePage);
        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/list";
    }

    @GetMapping(path = "/show-add-form")
    public ModelAndView add(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Candidate candidate = new Candidate();
        candidate.setAddress(new Address());
        modelAndView.addObject("candidate", candidate);
        modelAndView.addObject("address", candidate.getAddress());
        modelAndView.addObject("countries", vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.enums.CountryCode.values());
        modelAndView.setViewName("candidates/add");
        return modelAndView;
    }

    @PostMapping("/candidates/add")
    public String addCandidate(@ModelAttribute("candidate") Candidate candidate,
                               @ModelAttribute("address") Address address, BindingResult result, Model model){
        addressRepository.save(address);
        candidate.setAddress(address);
        candidateRepository.save(candidate);
        return "redirect:/candidates";
    }

    @GetMapping(path = "/show-update-form/{id}")
    public ModelAndView update(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        Optional<Candidate> opt = candidateRepository.findById(id);
        if (opt.isPresent()){
            Candidate candidate = opt.get();
            modelAndView.addObject("candidate", candidate);
            modelAndView.addObject("address", candidate.getAddress());
            modelAndView.addObject("countries", vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.enums.CountryCode.values());
            modelAndView.setViewName("candidates/update");
        }

        return modelAndView;
    }
    @PostMapping("/candidates/update")
    public String updateCandidate(@ModelAttribute("candidate") Candidate candidate,
                               @ModelAttribute("address") Address address, BindingResult result, Model model){
        addressRepository.save(address);
        candidateRepository.save(candidate);
        return "redirect:/candidates";
    }
}
