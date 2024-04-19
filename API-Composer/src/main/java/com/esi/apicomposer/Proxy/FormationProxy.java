package com.esi.apicomposer.Proxy;

import com.esi.apicomposer.Model.Formation;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ms-formation")
@LoadBalancerClient(name="ms-formation")
public interface FormationProxy {

    @GetMapping("/formations")
    public CollectionModel<Formation> getFormations();

    @GetMapping("/formations/{id}")
    public Formation getFormationById(@PathVariable("id") Long id);
}
