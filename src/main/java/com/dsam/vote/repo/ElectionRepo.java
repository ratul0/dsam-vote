package com.dsam.vote.repo;

import com.dsam.vote.entity.Election;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface ElectionRepo extends DatastoreRepository<Election,Long> {

}
