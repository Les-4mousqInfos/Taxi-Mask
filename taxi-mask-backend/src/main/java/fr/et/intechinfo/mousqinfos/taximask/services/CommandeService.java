package fr.et.intechinfo.mousqinfos.taximask.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import fr.et.intechinfo.mousqinfos.taximask.models.Commande;
import fr.et.intechinfo.mousqinfos.taximask.models.Utilisateur;
import fr.et.intechinfo.mousqinfos.taximask.models.Voiture;
import fr.et.intechinfo.mousqinfos.taximask.repository.CommandeRepository;
import fr.et.intechinfo.mousqinfos.taximask.security.jwt.JwtUtils;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map <String, Object> getCommandeEnAttente() throws StripeException {
        Utilisateur user = new Utilisateur(); //(Utilisateur) userDetailsService.getCurrentUser();
        user.setId(1L);
        Map result= new HashMap();
        if(user!=null){
          List commandes=commandeRepository.findAll();// commandeRepository.findByUtilisateurAndComplete(user,false);
          result.put("commandes", commandes);
          List price = commandeRepository.getCommandesPrice( false);
          Double prixTotal = price!=null? Double.parseDouble(price.get(0).toString()):0D;
          result.put("price", price.get(0));
          result.put("sessionCheckout", stripeCheckoutSessionConfigure(10000D, commandes.size()));
          logger.info(price.get(0).toString());
          return  result;
        }
        return null;
    }

    /**
     * Creation du session checkout de stripe
     * @param price
     * @param quantity
     * @return
     * @throws StripeException
     */
    public Session stripeCheckoutSessionConfigure(Double price, Integer quantity) throws StripeException {
        Stripe.apiKey = "sk_test_VTjPMwrlHiQYu5AS6ChnzMwv000INB4NLC";

        List<Object> paymentMethodTypes =
                new ArrayList<>();
        paymentMethodTypes.add("card");
        List<Object> lineItems = new ArrayList<>();
        Map<String, Object> lineItem1 = new HashMap<>();
        lineItem1.put("price", price);
        lineItem1.put("currency", "euro");
        lineItem1.put("quantity", quantity);
        lineItems.add(lineItem1);
        Map<String, Object> params = new HashMap<>();
        params.put(
                "success_url",
                "https://example.com/success"
        );
        params.put(
                "cancel_url",
                "https://example.com/cancel"
        );
        params.put(
                "payment_method_types",
                paymentMethodTypes
        );
        params.put("line_items", lineItems);
        params.put("mode", "payment");

        return Session.create(params);
    }

}
