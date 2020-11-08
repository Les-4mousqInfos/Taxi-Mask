package fr.et.intechinfo.mousqinfos.taximask.services;

import fr.et.intechinfo.mousqinfos.taximask.models.Client;
import fr.et.intechinfo.mousqinfos.taximask.models.Commande;
import fr.et.intechinfo.mousqinfos.taximask.models.Voiture;
import fr.et.intechinfo.mousqinfos.taximask.repository.CommandeRepository;
import fr.et.intechinfo.mousqinfos.taximask.utils.JwtUtil;
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
    private JwtUtil jwtUtil;
    @Autowired
    private ClientServiceImpl clientService;

    public Commande save(Commande commande){
        try {
        //logger.info(commande.toString());
            Voiture v = voitureService.getVoitureByImmatricule(commande.getVoiture().getImmatriculation());
            if(!(v instanceof Voiture)){
                //create a new Voiture
                voitureService.save(commande.getVoiture());
            }
            //enregistrement commande
         //   logger.info(commande.getVoiture().toString());
         //verification token client
         if(StringUtils.isNoneEmpty(commande.getTokenUn())){
            //recuperation du client via le token
            Long uid = Long.parseLong(jwtUtil.getPayLoadFromToken(commande.getTokenUn()));
             Client c = clientService.getClientById(uid);
             if(c instanceof Client){
                 commande.setClient(c);
                 commandeRepository.save(commande);
             }else{
                 commandeRepository.save(commande);
                 String tokenCId = jwtUtil.generateToken(commande.getId()+"");
                 commande.setTokenUn(tokenCId);
             }
         }
         return commande;
        }catch (Exception ex){
             logger.error(ex.getMessage(), ex.getCause());
            return null;
        }
    }

}
