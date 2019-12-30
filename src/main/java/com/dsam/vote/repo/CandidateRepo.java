package com.dsam.vote.repo;

import com.dsam.vote.entity.Candidate;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import java.util.List;

public interface CandidateRepo extends DatastoreRepository<Candidate, Long> {
    List<Candidate> findCandidateByFacultyName(String facultyName);
    List<Candidate> findCandidateByNominated(boolean status);
}
