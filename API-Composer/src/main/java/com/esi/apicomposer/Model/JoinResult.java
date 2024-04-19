package com.esi.apicomposer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class JoinResult {
    private Long idFormation;
    private String nomFormation;
    private String nomEtudiant;
    private String promo;
    private String nomEtablissement;
}

