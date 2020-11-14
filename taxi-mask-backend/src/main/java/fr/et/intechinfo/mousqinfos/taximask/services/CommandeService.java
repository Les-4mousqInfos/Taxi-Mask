package fr.et.intechinfo.mousqinfos.taximask.services;

import fr.et.intechinfo.mousqinfos.taximask.models.Commande;
import fr.et.intechinfo.mousqinfos.taximask.models.Utilisateur;
import fr.et.intechinfo.mousqinfos.taximask.models.Voiture;
import fr.et.intechinfo.mousqinfos.taximask.repository.CommandeRepository;
import fr.et.intechinfo.mousqinfos.taximask.security.jwt.JwtUtils;
import fr.et.intechinfo.mousqinfos.taximask.security.services.UserDetailsServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.List;

@Service
public class CommandeService {

    private static Logger logger = LoggerFactory.getLogger(CommandeService.class);
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private VoitureService voitureService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * Traitement d'un enregistrement de commande
     * @param commande
     * @return
     */
    public Commande traitementCommande(Commande commande) {
        Utilisateur user = (Utilisateur) userDetailsService.getCurrentUser();
        commande.setUtilisateur(user);
        save(commande);
        return commande;
    }


    /**
     * Enregistrement d'une commande
     * @param commande
     * @return
     * @throws Exception
     */
    public Commande save(Commande commande) {
    //logger.info(commande.toString());
        Voiture v = voitureService.getVoitureByImmatricule(commande.getVoiture().getImmatriculation());
        if(!(v instanceof Voiture)){
            //create a new Voiture
            voitureService.save(commande.getVoiture());
        }
        //enregistrement commande
         commandeRepository.save(commande);
         return commande;
    }

    /**
     * Liste des commandes par utilisateur
     * @return
     */
    public List<Commande> getCommandesByUser() throws Exception{
        Utilisateur user = (Utilisateur) userDetailsService.getCurrentUser();
        if(user!=null){
          return   commandeRepository.findByUtilisateur(user.getId());
        }
        //return  null; 
        return  commandeRepository.findAll();
    }

}
