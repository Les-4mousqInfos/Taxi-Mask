package fr.et.intechinfo.mousqinfos.taximask.controllers;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import fr.et.intechinfo.mousqinfos.taximask.models.Commande;
import fr.et.intechinfo.mousqinfos.taximask.payload.response.CommandeResponse;
import fr.et.intechinfo.mousqinfos.taximask.payload.response.MessageResponse;
import fr.et.intechinfo.mousqinfos.taximask.services.CommandeService;
import fr.et.intechinfo.mousqinfos.taximask.utils.CommandeRequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
@CrossOrigin(origins = "http://localhost:8080")
public class CommandeController {
    private static Logger logger = LoggerFactory.getLogger(CommandeController.class);
    @Autowired
    private CommandeService commandeService;


    @PostMapping
    public ResponseEntity <?> createCommande(@RequestBody Commande commande){
   //  try {
            logger.info(commande.toString());
          Commande c = commandeService.traitementCommande(commande);
          return ResponseEntity.ok().body(c);
     /* }catch (Exception ex){
          logger.error(ex.getMessage());
          return  ResponseEntity
                  .badRequest()
                  .body(new MessageResponse(ex.getMessage()));
      }*/
    }

    /**
     * Liste des commandes par utilisateur
     * @return
     */
    @GetMapping
    public ResponseEntity <?> getCommandesByUser(){
        try {
            List commandes = commandeService.getCommandesByUser();
            return ResponseEntity.ok().body(commandes);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return  ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(ex.getMessage()));
        }

    }

    @GetMapping("/all")
    public String getCommandesAllByUser(@RequestBody String userId){
        return "cooo";
    }
}
