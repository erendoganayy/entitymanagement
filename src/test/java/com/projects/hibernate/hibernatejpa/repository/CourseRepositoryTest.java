package com.projects.hibernate.hibernatejpa.repository;

import com.projects.hibernate.hibernatejpa.HibernateJpaApplication;
import com.projects.hibernate.hibernatejpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = HibernateJpaApplication.class)
class CourseRepositoryTest {
private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    public void findByIDtest(){
        Course course= repository.findById(10001L);
        logger.info("Testing is Running");
        assertEquals("Learning JPA",course.getName(),"doesnt equals");
    }

    @Test
    @DirtiesContext
    public void deleteByIDtest(){
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }
    @Test
    @DirtiesContext
    public void saveTest (){
        Course course = repository.findById(10001L);
        assertEquals("Learning JPA",course.getName());

        course.setName("Learning JPA - Updated");
        repository.save(course);

        Course course1=repository.findById(10001L);
        assertEquals("Learning JPA - Updated",course1.getName());
    }
    @Test
    @DirtiesContext
    public void playWithEntityManagerTest (){
repository.playWithEntityManager();
    }


}