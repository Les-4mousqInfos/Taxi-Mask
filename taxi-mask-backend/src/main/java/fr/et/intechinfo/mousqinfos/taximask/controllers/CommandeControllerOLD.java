
package fr.et.intechinfo.mousqinfos.taximask.controllers;
/*
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.et.intechinfo.mousqinfos.taximask.exceptions.ResourceNotFoundException;
import fr.et.intechinfo.mousqinfos.taximask.models.Commande;
import fr.et.intechinfo.mousqinfos.taximask.repository.ClientRepository;
import fr.et.intechinfo.mousqinfos.taximask.repository.CommandeRepository;

@RestController
public class CommandeControllerOLD {
	
	@Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients/{clientId}/commandes")
    public List < Commande > getCommandesByClient(@PathVariable(value = "postId") Long clientId) {
        return commandeRepository.findByClientId(clientId);
    }

    @PostMapping("/clients/{clientId}/commandes")
    public Commande createCommande(@PathVariable(value = "clientId") Long clientId,
        @Valid @RequestBody Commande commande) throws ResourceNotFoundException {
        return clientRepository.findById(clientId).map(client -> {
            commande.setClient(client);
            return commandeRepository.save(commande);
        }).orElseThrow(() -> new ResourceNotFoundException("client not found"));
    }

    @PutMapping("/clients/{clientId}/commandes/{commandeId}")
    public Commande updateCommande(@PathVariable(value = "clientId") Long clientId,
        @PathVariable(value = "commandeId") Long commandeId, @Valid @RequestBody Commande commandeRequest)
    throws ResourceNotFoundException {
        if (!clientRepository.existsById(clientId)) {
            throw new ResourceNotFoundException("clientId not found");
        }

        return commandeRepository.findById(commandeId).map(commande -> {
            commande.setTrappe(commandeRequest.getTrappe());
            commande.setTypeProtection(commandeRequest.getTypeProtection());
            commande.setPrixProtection(commandeRequest.getPrixProtection());
           
            
            commande.setToit(commandeRequest.getToit());
            commande.setEtiquette(commande.getEtiquette());
           
            return commandeRepository.save(commande);
        }).orElseThrow(() -> new ResourceNotFoundException("commande id not found"));
    }

    @DeleteMapping("/clients/{clientId}/commandes/{commandeId}")
    public ResponseEntity < ? > deleteCommande(@PathVariable(value = "clientId") Long clientId,
        @PathVariable(value = "commandeId") Long commandeId) throws ResourceNotFoundException {
        return commandeRepository.findByIdAndClientId(commandeId, clientId).map(commande -> {
            commandeRepository.delete(commande);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
            "Commande not found with id " + commandeId + " and clientId " + clientId));
    }



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


}*/
