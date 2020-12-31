
package com.lambda.zoos.services;

import com.lambda.zoos.models.Zoo;
import com.lambda.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "ZooServices")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    ZooRepository zoosrepos;
    public Zoo findZooByZooId(long zooid) {
        return zoosrepos.findById(zooid)
            .orElseThrow(() -> new EntityNotFoundException("ZOOID " + zooid + "NOT FOUND"));
    }
}

