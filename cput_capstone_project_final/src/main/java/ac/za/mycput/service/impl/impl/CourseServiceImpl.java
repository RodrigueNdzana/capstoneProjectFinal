package ac.za.mycput.service.impl.impl;
/*

 */

import ac.za.mycput.entity.Course;
import ac.za.mycput.repository.CourseRepository;

import ac.za.mycput.service.impl.Interface.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseServiceImpl")
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        super();
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

//    @Override
//    public Course findCourseByCode(String courseCode) {
//        return courseRepository.findCourseByCourseCode(courseCode);
//    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }


    @Override
    public void deleteByCourseName(String courseName) {
        courseRepository.deleteByCourseName(courseName);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findCourseById(id);
    }
    @Override
    public Course getCourseName(String courseName) {
        return courseRepository.findByCourseName(courseName);
    }

    @Override
    public Course getByCourseCode(String courseCode) {
        return courseRepository.getByCourseCode(courseCode);
    }

}


