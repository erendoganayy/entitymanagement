package com.projects.hibernate.hibernatejpa.repository;

import com.projects.hibernate.hibernatejpa.entity.Passport;
import com.projects.hibernate.hibernatejpa.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class StudentRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    EntityManager em;

    public void extracted() {
        //db operation1 --> Retrieve a student
        Student student=em.find(Student.class,20001L);
        //db op2 --> retrieve passport
        Passport passport=student.getPassport();
        //db op3 --> update passport
        passport.setNumber("Z123457");
        //db op4 --> update student
        student.setName("Ranga- updated");
    }

    public Student findById(Long id){
       return em.find(Student.class,id);
    }
    public Student save(Student student){
        long x=student.getId();

        if(isNull(student.getId())){
            em.persist(student);
            //insert
        }
        else
        {
         em.merge(student);
            //updating existing context
        }
return student;

    }
    public void deleteById(Long id){
        Student student=findById(id);
        em.remove(student);
    }

    public void saveStudentWithPassport(){
        Passport passport=new Passport("Z123456");
        em.persist(passport);

        Student student=new Student("Mike Yeni ogrenci ");
        student.setPassport(passport);
        em.persist(student);

    }


}
