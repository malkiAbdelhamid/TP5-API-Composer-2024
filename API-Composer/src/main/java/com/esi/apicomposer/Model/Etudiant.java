package com.esi.apicomposer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {
    private String nom;
    private String promo;
    private Long idFormation;
    private String nomEtablissement;
}
