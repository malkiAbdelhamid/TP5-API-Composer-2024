package com.esi.msscolarite.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name="tocompose", types = {Etudiant.class})
public interface EtudiantProjectionToCompose {

    public String getNom();
    public String getPromo();
    public Long getIdFormation();

    @Value("#{target.etablissement.nom}")
    public String getNomEtablissement();
}
