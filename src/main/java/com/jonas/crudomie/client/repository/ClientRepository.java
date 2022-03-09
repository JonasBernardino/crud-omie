package com.jonas.crudomie.client.repository;

import com.jonas.crudomie.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
