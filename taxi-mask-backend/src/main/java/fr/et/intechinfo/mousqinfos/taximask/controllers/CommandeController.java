package fr.et.intechinfo.mousqinfos.taximask.controllers;

import fr.et.intechinfo.mousqinfos.taximask.models.Client;
import fr.et.intechinfo.mousqinfos.taximask.models.Commande;
import fr.et.intechinfo.mousqinfos.taximask.services.CommandeService;
import fr.et.intechinfo.mousqinfos.taximask.utils.CommandeRequestBody;
import fr.et.intechinfo.mousqinfos.taximask.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandes")

public class CommandeController {
    @Autowired
    private CommandeService commandeService;


    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity <Commande> createCommande(@RequestBody Commande commande){
        System.out.println("vccc=="+commande);
      Commande c = commandeService.save(commande);
      return c!=null? ResponseEntity.ok().body(c): ResponseEntity.status(300).body(null);
    }

    @GetMapping
    public String getCommande(){
        return "cooo";
    }
}
