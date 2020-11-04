package fr.et.intechinfo.mousqinfos.taximask.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.et.intechinfo.mousqinfos.taximask.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
	List<Commande> findByClientId(Long clientId);

}
