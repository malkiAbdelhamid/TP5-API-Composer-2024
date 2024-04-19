package com.esi.msscolarite.repositories;

import com.esi.msscolarite.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findEtudiantByIdFormation(Long idf);

}