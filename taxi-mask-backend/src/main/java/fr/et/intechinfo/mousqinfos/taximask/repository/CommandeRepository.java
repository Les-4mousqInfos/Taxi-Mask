package fr.et.intechinfo.mousqinfos.taximask.repository;

import java.util.List;
import java.util.Optional;

import fr.et.intechinfo.mousqinfos.taximask.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.et.intechinfo.mousqinfos.taximask.models.Commande;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
	List<Commande> findByUtilisateur(Long userId);
	List<Commande> findByUtilisateurAndComplete(Utilisateur utilisateur, Boolean complete);
	//@Query("select c from Commande c where c.utilisateur=:userId and c.complete=:complete")
	//List<Commande> getCommandeByUserComplete(@Param("complete") Boolean complete, @Param("userId") Long userId);

	//@Query("select sum(c.prixProtection) as price from Commande c where c.utilisateur=:userId and c.complete=:complete group by c.prixProtection ")
	//List getCommandesPrice(@Param("userId") Long userId, @Param("complete") Boolean complete);

	@Query("select coalesce(sum(c.prixProtection),0) as price from Commande c where c.complete=:complete ")
	List getCommandesPrice(@Param("complete") Boolean complete);

}
