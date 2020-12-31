package com.lambda.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "zooanimals")
@IdClass(ZooAnimalsId.class)
public class ZooAnimals extends Auditable implements Serializable
{
    /**
     * Foreign key into the zoo table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "animals", allowSetters = true)
    private Zoo zoo;

    /**
     * Foreign key into the animal table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zoos", allowSetters = true)
    private Animal animal;

    String incomingzoo;

    /**
     * Default constructor used primarily by the JPA.
     */
    public ZooAnimals()
    {
    }

    /**
     * Given the params, create a new zoo animal combination
     *
     * @param zoo         The zoo object of the zoo animal combination
     * @param animal      The animal object of the zoo animal combination
     * @param incomingzoo The zoo object of the zoo where the animal is coming from.
     */
    public ZooAnimals(
        Zoo zoo,
        Animal animal,
        String incomingzoo)
    {
        this.zoo = zoo;
        this.animal = animal;
        this.incomingzoo = incomingzoo;
    }

    /**
     * Given the params, create a new zoo animal combination
     *
     * @param zoo    The zoo object of the zoo animal combination
     * @param animal The animal object of the zoo animal combination
     *               incomingzoo is set to null
     */
    public ZooAnimals(
        Zoo zoo,
        Animal animal)
    {
        this.zoo = zoo;
        this.animal = animal;
        this.incomingzoo = null;
    }

    /**
     * The getter for zoo
     *
     * @return the complete zoo object of this zoo animal combination
     */
    public Zoo getZoo()
    {
        return zoo;
    }

    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
    }


    public Animal getAnimal()
    {
        return animal;
    }


    public void setAnimal(Animal animal)
    {
        this.animal = animal;
    }


    public String getIncomingzoo()
    {
        return incomingzoo;
    }


    public void setIncomingzoo(String incomingzoo)
    {
        this.incomingzoo = incomingzoo;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        ZooAnimals that = (ZooAnimals) o;
        return ((this.zoo == null) ? 0 : this.zoo.getZooid()) == ((that.zoo == null) ? 0 : that.zoo.getZooid()) &&
            ((this.animal == null) ? 0 : this.animal.getAnimalid()) == ((that.animal == null) ? 0 : that.animal.getAnimalid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}