package com.droppa.services.spring.droppaclone.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.droppa.services.spring.droppaclone.models.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount,Integer>{

	Optional<UserAccount> findByEmail(String email);
}
