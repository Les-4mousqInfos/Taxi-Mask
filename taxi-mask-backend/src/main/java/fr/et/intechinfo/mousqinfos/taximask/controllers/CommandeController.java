package fr.et.intechinfo.mousqinfos.taximask.controllers;

import fr.et.intechinfo.mousqinfos.taximask.models.Client;
import fr.et.intechinfo.mousqinfos.taximask.models.Commande;
import fr.et.intechinfo.mousqinfos.taximask.services.CommandeService;
import fr.et.intechinfo.mousqinfos.taximask.utils.CommandeRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandes")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @PostMapping
    public ResponseEntity <Commande> nouvelleCommande(@RequestBody CommandeRequestBody commande){
      Commande c = commandeService.save(commande);
      return ResponseEntity.ok().body(c);
    }

    @GetMapping
    public String getCommande(){
        return "cooo";
    }
}
