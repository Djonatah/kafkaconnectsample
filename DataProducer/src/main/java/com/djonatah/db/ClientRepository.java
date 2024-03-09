package com.djonatah.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
