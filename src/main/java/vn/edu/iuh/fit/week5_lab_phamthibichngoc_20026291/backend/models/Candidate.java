package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "candidate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id", nullable = false)
    private long id;

    @Column(name = "dob",nullable = false)
    private LocalDate dob;
    @Column(name = "email",nullable = false, unique = true)
    private String email;
    @Column(name = "full_name", nullable = false)
    private String full_name;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;


    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "address", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateSkill> candidateSkills = new ArrayList<>();

}
