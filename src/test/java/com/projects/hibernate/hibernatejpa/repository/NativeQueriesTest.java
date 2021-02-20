package com.projects.hibernate.hibernatejpa.repository;

import com.projects.hibernate.hibernatejpa.HibernateJpaApplication;
import com.projects.hibernate.hibernatejpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@SpringBootTest(classes = HibernateJpaApplication.class)
class NativeQueriesTest {
private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void native_queries_basic(){
        Query query= em.createNativeQuery("SELECT * FROM COURSE",Course.class);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE -> {}",resultList);
    }
    @Test
    public void native_queries_with_named_parameter(){
        Query query= em.createNativeQuery("SELECT * FROM COURSE where id= :id",Course.class);
        query.setParameter("id",1);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE -> {}",resultList);
    }
    @Test
    @Transactional
    public void native_queries_to_update(){
        Query query= em.createNativeQuery("UPDATE COURSE set last_updated_date=sysdate()",Course.class);
        int numberOfRowsUpdated = query.executeUpdate();
        logger.info("Number of rows updated -> {}",numberOfRowsUpdated);
    }





}