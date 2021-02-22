package com.projects.hibernate.hibernatejpa.repository;

import com.projects.hibernate.hibernatejpa.HibernateJpaApplication;
import com.projects.hibernate.hibernatejpa.entity.Course;
import com.projects.hibernate.hibernatejpa.entity.Passport;
import com.projects.hibernate.hibernatejpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest(classes = HibernateJpaApplication.class)
class StudentRepositoryTest {
private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;
    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void someTest(){
        repository.extracted();
    }



    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails(){
        Student student=entityManager.find(Student.class,20001L   );
        logger.info("student -->{}", student);
        logger.info("passport -->{}",student.getPassport());

    }
    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent(){
        Passport passport=entityManager.find(Passport.class,40001L);
        logger.info("passport -->{}", passport);
        logger.info("student -->{}",passport.getStudent());

    }


}