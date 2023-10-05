package ac.za.mycput.controller;

import ac.za.mycput.entity.Course;
import ac.za.mycput.repository.CourseRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseControllerTest {
    CourseRepository courseRepository;

    @Test
    void listCourses() {

    }

    @Test
    void createCourseForm() {
    }

    @Test
    void saveCourse() {
        // Create Date instances for startDate and endDate
        Date startDate = new Date(99, 9, 17); // October 17, 1999
        Date endDate = new Date(120, 11, 7); // December 7, 2020
        Course course1 = new Course(12,"ADP3","all about coding",startDate, endDate,"Technology","room 123");
    courseRepository.save(course1);
    }

    @Test
    void editCourseForm() {
    }

    @Test
    void updateCourse() {
    }

    @Test
    void deleteCourse() {
    }

    @Test
    void testSaveCourse() {
    }

    @Test
    void testUpdateCourse() {
    }

    @Test
    void testDeleteCourse() {
    }
}