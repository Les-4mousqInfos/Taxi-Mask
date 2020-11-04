package fr.et.intechinfo.mousqinfos.taximask.services;

import fr.et.intechinfo.mousqinfos.taximask.models.Commande;
import fr.et.intechinfo.mousqinfos.taximask.repository.CommandeRepository;
import fr.et.intechinfo.mousqinfos.taximask.utils.CommandeRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public Commande save(CommandeRequestBody commande){
        return  null;
    }

}
