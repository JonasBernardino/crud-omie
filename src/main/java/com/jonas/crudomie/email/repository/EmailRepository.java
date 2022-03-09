package com.jonas.crudomie.email.repository;

import com.jonas.crudomie.email.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
