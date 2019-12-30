package com.dsam.vote.controller;

import com.dsam.vote.entity.Election;
import com.dsam.vote.entity.Voter;
import com.dsam.vote.repo.ElectionRepo;
import com.google.cloud.Timestamp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Date;

@RestController
public class ElectionController {
    final ElectionRepo electionRepo;

    public ElectionController(ElectionRepo electionRepo) {
        this.electionRepo = electionRepo;
    }

    @GetMapping("/ae")
    public String add(){
        if(this.electionRepo.count() > 0){
            return "election already exists.";
        }
        Election election = new Election(Timestamp.now(),Timestamp.parseTimestamp("2020-01-20T06:30:00"));

        this.electionRepo.save(election);
        return "election added";
    }
}
