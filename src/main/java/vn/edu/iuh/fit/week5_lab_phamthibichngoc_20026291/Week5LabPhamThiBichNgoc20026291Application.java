package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.enums.SkillLevel;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.Address;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.Candidate;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.CandidateSkill;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models.enums.CountryCode;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.repositories.CandidateRepository;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Week5LabPhamThiBichNgoc20026291Application {

    public static void main(String[] args) {
        SpringApplication.run(Week5LabPhamThiBichNgoc20026291Application.class, args);
    }
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Bean
    CommandLineRunner initData(){
        return args -> {
            Random random = new Random();
            for (int i = 1; i < 1000; i++){
                Address address = new Address(random.nextInt(1, 1000), "Go Vap", "TPHCM", CountryCode.VIETNAM, random.nextInt(70000, 80000)+"");
                addressRepository.save(address);
                Candidate candidate = new Candidate(LocalDate.of(2000,random.nextInt(1,13),random.nextInt(1,29)), "email_"+i+"@gmail.com","Name #"+i,"0123456",address);
                candidateRepository.save(candidate);
                System.out.println("Added" + candidate);
            }
        };
    }

}
