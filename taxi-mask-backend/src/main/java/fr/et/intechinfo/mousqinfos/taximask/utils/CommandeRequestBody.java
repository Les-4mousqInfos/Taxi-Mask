package fr.et.intechinfo.mousqinfos.taximask.utils;


import fr.et.intechinfo.mousqinfos.taximask.models.Voiture;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CommandeRequestBody {

    private String trappe;
    private String typeProtection;
    private double prix;
    private String toit;
    private String etiquette;
    private Date datePreimma;
    private Voiture voiture;
}
