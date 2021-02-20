package com.projects.hibernate.hibernatejpa.repository;

import com.projects.hibernate.hibernatejpa.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class CourseRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    EntityManager em;

    public Course findById(Long id){
       return em.find(Course.class,id);
    }
    public Course save(Course course){
        long x=course.getId();

        if(isNull(course.getId())){
            em.persist(course);
            //insert
        }
        else
        {
         em.merge(course);
            //updating existing context
        }
return course;

    }
    public void deleteById(Long id){
        Course course=findById(id);
        em.remove(course);
    }

    public void playWithEntityManager(){
            Course course=new Course("Web services in 100 steps ");
            em.persist(course);

             Course course2=findById(10001L);
             course2.setName("ben update edildim walla knk");


    }


}
