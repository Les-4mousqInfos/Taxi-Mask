package fr.et.intechinfo.mousqinfos.taximask.controllers;

import fr.et.intechinfo.mousqinfos.taximask.models.Commande;
import fr.et.intechinfo.mousqinfos.taximask.payload.response.CommandeResponse;
import fr.et.intechinfo.mousqinfos.taximask.payload.response.MessageResponse;
import fr.et.intechinfo.mousqinfos.taximask.services.CommandeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandes")

public class CommandeController {
    private static Logger logger = LoggerFactory.getLogger(CommandeController.class);
    @Autowired
    private CommandeService commandeService;


    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity <?> createCommande(@RequestHeader HttpHeaders headers, @RequestBody Commande commande){
    //  try {
          String token = headers.get("Authorization").get(0);
         // System.out.println("vccc=="+headers);
          Commande c = commandeService.traitementCommande(commande, token);
          return ResponseEntity.ok().body(c);
    /*  }catch (Exception ex){
          logger.error(ex.getMessage());
          return  ResponseEntity
                  .badRequest()
                  .body(new MessageResponse(ex.getMessage()));
      }*/
    }

    @GetMapping
    public String getCommande(){
        return "cooo";
    }
}
