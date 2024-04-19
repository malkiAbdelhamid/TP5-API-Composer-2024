package com.esi.msscolarite.api;



import com.esi.msscolarite.entities.Etudiant;
import com.esi.msscolarite.model.Formation;
import com.esi.msscolarite.proxy.BourseProxy;
import com.esi.msscolarite.proxy.FormationProxy;
import com.esi.msscolarite.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ScolariteAPI {

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    FormationProxy formationProxy;

    @Autowired
    BourseProxy bourseProxy;

    @GetMapping("/etudiants/{id}")
    public Etudiant getEtudiantWithFormationBourse(@PathVariable("id") Long ide)
    {
        Etudiant etudiant=etudiantRepository.findById(ide).get();

        Formation formation= formationProxy.getFormation(etudiant.getIdFormation());

        etudiant.setFormation(formation);
        etudiant.setVirements(new ArrayList(bourseProxy.getVirements(ide,"toscolarite").getContent()));

        return  etudiant;
    }

    @GetMapping("/etudiants")
    public List<Etudiant> getEtudiantsWithFormationBourse()
    {
       List<Etudiant> etudiants= etudiantRepository.findAll();

       etudiants.forEach((e)->{
               e.setVirements(new ArrayList<>(bourseProxy.getVirements(e.getIdEtudiant(),
                       "toscolarite").getContent()));

                e.setFormation(formationProxy.getFormation(e.getIdFormation()));
       }

       );

       return etudiants;
    }




}
