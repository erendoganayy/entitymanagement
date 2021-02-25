package com.projects.hibernate.hibernatejpa.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NamedQueries(value={
        @NamedQuery(name="query_get_all_courses",query="select c from Course c"),
        @NamedQuery(name="query_get_jpa_courses",query="select c from Course c where name like '%JPA'")

})

public class Course {
//c
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;



   //constractors
    protected Course(){ }
    public Course(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
