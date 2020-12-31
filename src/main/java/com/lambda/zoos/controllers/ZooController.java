package com.lambda.zoos.controllers;

import com.lambda.zoos.models.Zoo;
import com.lambda.zoos.repositories.ZooRepository;
import com.lambda.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zoos")
public class ZooController
{
    @Autowired
    ZooRepository zoosrepos;

    @Autowired
    ZooService zooservice;

    @GetMapping(value = "/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        List <Zoo> zoosList = new ArrayList<>();
        zoosrepos.findAll().iterator().forEachRemaining(zoosList::add);

        return new ResponseEntity<>(zoosList, HttpStatus.OK);
    }

    @GetMapping(value = "/zoos/{zooid}", produces = {"application/json"})
    public ResponseEntity<?> listZooById(@PathVariable long zooid)
    {
       Zoo z = zooservice.findZooByZooId(zooid);

        return new ResponseEntity<>(z, HttpStatus.OK);
    }

}
