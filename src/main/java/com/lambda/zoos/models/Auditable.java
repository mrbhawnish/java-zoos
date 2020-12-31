package com.lambda.zoos.models;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * @MappedSuperClass - Since relational databases do not support ionheritance,
 * Sprint Boot provides a way to say that this class is a "parent" class whose fields will be included in the child class
 * The child class is the one that forms the entity for the database
 * @EntityListeners - When an entity is accessed by the Spring Framework, the argument in of the Entity Listener annotation will be invoked!
 * Thus this annotation is "listening" for when an entity is accessed and then performs its argument
 * AuditingEntityListener.class - The class that captures the data for and updates the annotations used in auditing -
 * CreatedBy, CreatedDate, ModifiedBy, ModifiedDate
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class Auditable
{
    @CreatedBy   // holds the field for the username of who created this row
    protected String createdBy;

    /**
     * Temporal(TIMESTAMP) - Sets the precision of the date being saved. In this case Date and Time
      */

    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;

    @LastModifiedBy
    protected String lastModifiedBy;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastModifiedDate;


    public String getCreatedBy()
    {
        return createdBy;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public String getLastModifiedBy()
    {
        return lastModifiedBy;
    }

    public Date getLastModifiedDate()
    {
        return lastModifiedDate;
    }
}
