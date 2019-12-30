package com.dsam.vote.repo;

import com.dsam.vote.entity.Voter;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.cloud.gcp.data.datastore.repository.query.Query;

import java.util.List;

public interface VoterRepo extends DatastoreRepository<Voter,Long> {
    Voter getVoterByEmail(String email);
    List<Voter> findVoterByVoted(boolean status);
}
