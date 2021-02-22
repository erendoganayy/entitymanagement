package com.projects.hibernate.hibernatejpa.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "passport")
    private Student student;


   //constractors
    protected Passport(){ }
    public Passport(String number){
        this.number=number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "passport {" +
                "number='" + number + '\'' +
                '}';
    }
}
