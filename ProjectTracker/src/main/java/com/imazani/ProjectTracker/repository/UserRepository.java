package com.imazani.ProjectTracker.repository;

import com.imazani.ProjectTracker.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Profile, Integer> {
}
