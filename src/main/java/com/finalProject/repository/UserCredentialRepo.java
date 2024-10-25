package com.finalProject.repository;

import com.finalProject.entity.UserCredential;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserCredentialRepo extends ListCrudRepository<UserCredential, Long> {

    Optional<UserCredential> findByEmail(String email);

}
