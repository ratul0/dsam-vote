package com.dsam.vote.entity;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "candidate")
public class Candidate {
    @Id
    private Long id;
    private String firstName;
    private String sureName;
    private String facultyName;
    private boolean nominated = false;
    private int voteCount = 0;

    public Candidate() {
    }

    public Candidate(String firstName, String sureName, String facultyName) {
        this.firstName = firstName;
        this.sureName = sureName;
        this.facultyName = facultyName.toLowerCase();
    }

    public Candidate(String firstName, String sureName, String facultyName, boolean nominated, int voteCount) {
        this.firstName = firstName;
        this.sureName = sureName;
        this.facultyName = facultyName;
        this.nominated = nominated;
        this.voteCount = voteCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public boolean getNominated() {
        return nominated;
    }

    public void setNominated(boolean nominated) {
        nominated = nominated;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName.toLowerCase();
    }

    @Override
    public String toString() {
        return firstName+" "+ sureName;
    }
}
