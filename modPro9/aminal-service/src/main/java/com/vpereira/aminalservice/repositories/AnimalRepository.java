package com.vpereira.aminalservice.repositories;

import com.vpereira.aminalservice.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL AND a.tipoAnimal = ?1 ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted(String type);

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL AND a.tipoAnimal = ?1")
    List<Animal> findAdopted(String type);

    @Query("SELECT a FROM Animal a WHERE a.tipoAnimal = ?1")
    List<Animal> findByType(String type);

    @Query("SELECT nomeRecebedor, COUNT(*) FROM Animal GROUP BY nomeRecebedor")
    List<Object[]> countResgate();
}
