package fr.et.intechinfo.mousqinfos.taximask.services;

import fr.et.intechinfo.mousqinfos.taximask.models.Commande;
import fr.et.intechinfo.mousqinfos.taximask.models.Utilisateur;
import fr.et.intechinfo.mousqinfos.taximask.models.Voiture;
import fr.et.intechinfo.mousqinfos.taximask.repository.CommandeRepository;
import fr.et.intechinfo.mousqinfos.taximask.security.jwt.JwtUtils;
import fr.et.intechinfo.mousqinfos.taximask.utils.Jwt;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

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

    /**
     * Traitement d'un enregistrement de commande
     * @param commande
     * @param token
     * @return
     */
    public Commande traitementCommande(Commande commande, String token) {
       token = token.length()>6 ? token.substring(7, token.length()): "";
        if(token!=null && StringUtils.isNoneEmpty(token)){
            Long uid = Long.parseLong(jwtUtils.getUserNameFromJwtToken(token));
            Utilisateur u = utilisateurService.getUserById(uid);
            commande.setUtilisateur(u);
          return   save(commande);
        }
        save(commande);
        String tokenUn = jwtUtils.generateToken(commande.getId()+"");
        commande.setTokenUn(tokenUn);
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

}
