package com.dsam.vote.controller;

import com.dsam.vote.entity.Voter;
import com.dsam.vote.repo.VoterRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class VoterController {
    final VoterRepo voterRepo;

    public VoterController(VoterRepo voterRepo) {
        this.voterRepo = voterRepo;
    }

    @GetMapping("/voter")
    public String add(){
        Voter voter1 = new Voter("rat@test.com");
        Voter voter2 = new Voter("cat@test.com");
        Voter voter3 = new Voter("bat@test.com");
        this.voterRepo.saveAll(Arrays.asList(voter1,voter2,voter3));
        return "voters added";
    }

    @GetMapping("/email")
    public String getByEmail(){
        Voter voter = this.voterRepo.getVoterByEmail("cat@test.com");
        voter.setToken(null);
        voter.setVoted(true);
        voterRepo.save(voter);
        return "voters updated";
    }

    @GetMapping("/valid")
    public String validVoter(){

        return "valid voters "+ this.voterRepo.findVoterByVoted(false).size();
    }

    @GetMapping("/vc")
    public String clear(){
        this.voterRepo.deleteAll();
        return "voters clear";
    }

}
