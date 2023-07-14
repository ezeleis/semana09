package com.example.security.Entities.Repositories;

import com.example.security.Entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
        List<Pessoa> findAllByStatus(boolean status);
        @Query("SELECT p FROM Pessoa p WHERE p.name LIKE %:filter% OR p.email LIKE %:filter%")
        List<Pessoa> findByFilter(String filter);
}

