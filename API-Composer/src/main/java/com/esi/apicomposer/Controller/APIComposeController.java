package com.esi.apicomposer.Controller;

import com.esi.apicomposer.Model.Etudiant;
import com.esi.apicomposer.Model.Formation;
import com.esi.apicomposer.Model.JoinResult;
import com.esi.apicomposer.Proxy.EtudiantProxy;
import com.esi.apicomposer.Proxy.FormationProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class APIComposeController {

    private final FormationProxy formationProxy;
    private final EtudiantProxy etudiantProxy;

    @GetMapping("/regular-join")
    public List<JoinResult> getReguralJojn()
    {
        ArrayList<JoinResult> joinResults=new ArrayList<>();
        ArrayList<Formation>  formations =
                new ArrayList<>(formationProxy.getFormations().getContent());
       ArrayList<Etudiant> etudiants=
                new ArrayList<>(etudiantProxy.getEtudiants("tocomposer").getContent());
        formations.forEach(f->{
            etudiants.forEach(e->{
              if(f.getIdFormation().equals(e.getIdFormation()))
                  joinResults.add(new JoinResult(f.getIdFormation(),
                          f.getNom(),
                          e.getNom(),
                          e.getPromo(),
                          e.getNomEtablissement()));
            });
        });
        return joinResults;
    }

    @GetMapping("/pipe-join")
    public List<JoinResult> getPipeJoin()
    {   ArrayList<JoinResult> joinResults=new ArrayList<>();
        ArrayList<Formation>  formations =
                new ArrayList<>(formationProxy.getFormations().getContent());

        formations.forEach(f->{
            ArrayList<Etudiant> etudiantsByIdf=
                    new ArrayList(etudiantProxy.getLesEtudiantsbyIdf(
                                    f.getIdFormation(),
                            "tocomposer").getContent());
            etudiantsByIdf.forEach(e->{
                joinResults.add(new JoinResult(f.getIdFormation(),
                        f.getNom(),
                        e.getNom(),
                        e.getPromo(),
                        e.getNomEtablissement()));
            });
        });
        return  joinResults;
    }
}
