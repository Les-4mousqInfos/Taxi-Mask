package fr.et.intechinfo.mousqinfos.taximask.services;

import fr.et.intechinfo.mousqinfos.taximask.models.Commande;
import fr.et.intechinfo.mousqinfos.taximask.models.Utilisateur;
import fr.et.intechinfo.mousqinfos.taximask.models.Voiture;
import fr.et.intechinfo.mousqinfos.taximask.repository.CommandeRepository;

import fr.et.intechinfo.mousqinfos.taximask.security.services.UserDetailsServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CommandeService {

    private static Logger logger = LoggerFactory.getLogger(CommandeService.class);
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private VoitureService voitureService;
   
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Value("${upload-dir}")
    private String FILE_DIRECTORY;


    /**
     * Traitement d'un enregistrement de commande
     * @param commande
     * @return
     */
    public Commande traitementCommande(Commande commande) throws IOException {
        Utilisateur user = (Utilisateur) userDetailsService.getCurrentUser();
        commande.setUtilisateur(user);
        String filename = storageFile(commande.getCarteGrise());
        commande.setCarteGriseFileName(filename);
        filename = storageFile(commande.getPhotoVoiture());
        commande.setPhotoVoitureFileName(filename);
        save(commande);
        return commande;
    }

    /**
     * Gestion de fichiers
     * @param file
     * @return
     * @throws IOException
     */
    public String storageFile(MultipartFile file) throws IOException {
        if(!new File(FILE_DIRECTORY).exists())
        {
            System.out.println("create");
            // Créer le dossier avec tous ses parents
            new File(FILE_DIRECTORY).mkdirs();

        }
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(FILE_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename()+" ");

        Files.write(fileNameAndPath, file.getBytes());
        return FILE_DIRECTORY+"\\"+file.getOriginalFilename();
    }

    /**
     * Enregistrement d'une commande
     * @param commande
     * @return
     * @throws Exception
     */
    public Commande save(Commande commande) {
    //logger.info(commande.toString());
        Voiture v = voitureService.getVoitureByImmatricule(commande.getImmatriculation());
        if(!(v instanceof Voiture)){
            //create a new Voiture
            v = new Voiture();
            v.setImmatriculation(commande.getImmatriculation());
            v.setMarque(commande.getMarque());
            v.setModele(commande.getModele());
            v.setDatePreimma(commande.getDateImmatriculation());
            voitureService.save(v);
        }
        //enregistrement commande
        commande.setVoiture(v);
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
