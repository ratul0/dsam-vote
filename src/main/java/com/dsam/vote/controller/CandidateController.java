package com.dsam.vote.controller;

import com.dsam.vote.entity.Candidate;
import com.dsam.vote.repo.CandidateRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class CandidateController {
    final CandidateRepo candidateRepo;

    public CandidateController(CandidateRepo candidateRepo) {
        this.candidateRepo = candidateRepo;
    }

    @GetMapping("/")
    public String test(){
        return "12";
    }

    @GetMapping("/add")
    public String add(){
        Candidate c1 = new Candidate("yousuf","rat","English",true,0);
        Candidate c2 =new Candidate("user2","last2","English",true,0);
        Candidate c3 =new Candidate("user3","last3","English",true,0);
        Candidate c4 = new Candidate("user4","last4","English");
        Candidate c5 = new Candidate("user5","last5","Math");
        this.candidateRepo.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
        return "candidates added";
    }

    @GetMapping("/nominated")
    public String nominated(){
        return ""+this.candidateRepo.findCandidateByNominated(true).size();
    }

    @GetMapping("/faculty")
    public String faculty(){
        return ""+this.candidateRepo.findCandidateByFacultyName("math").size();
    }

    @GetMapping("/clear")
    public String clear(){
        this.candidateRepo.deleteAll();
        return "Reset";
    }
}
