package com.projects.hibernate.hibernatejpa.repository;

import com.projects.hibernate.hibernatejpa.HibernateJpaApplication;
import com.projects.hibernate.hibernatejpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest(classes = HibernateJpaApplication.class)
class JPQLTest {
private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void jpql_basic(){
        Query query= em.createNamedQuery("query_get_all_courses");
        List resultList = query.getResultList();
        logger.info("select c from course c -> {}",resultList);
    }
    @Test
    public void jpql_typed(){
        TypedQuery<Course> query =em.createNamedQuery("query_get_all_courses",Course.class);
        List<Course> resultList =query.getResultList();
        logger.info("select c from course c -> {}",resultList);
    }
    @Test
    public void jpql_where(){
        TypedQuery<Course> query =em.createNamedQuery("query_get_jpa_courses",Course.class);
        List<Course> resultList =query.getResultList();
        logger.info("select c from course c where name like 'JPA'-> {}",resultList);
    }




}