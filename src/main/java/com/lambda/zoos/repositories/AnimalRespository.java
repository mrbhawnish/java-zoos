package com.lambda.zoos.repositories;

import com.lambda.zoos.models.Animal;
import com.lambda.zoos.views.AnimalsCountZoos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRespository extends CrudRepository<Animal, Long>
{
    @Query(value = "SELECT a.animaltype as animaltype, a.animalid as animalid, count(*) as countzoos" +
        "FROM ZOOS z" +
        "LEFT JOIN ZOOANIMALS za" +
        "ON za.ZOOID = z.ZOOID" +
        " JOIN ANIMALS a ON a.animalid = za.animalid" +
        "GROUP BY a.animaltype;",
        nativeQuery = true)
    List<AnimalsCountZoos> getCountZooAnimals();
}
