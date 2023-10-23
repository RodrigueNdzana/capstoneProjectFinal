package ac.za.mycput.service.impl.Interface;
/*

 */
import ac.za.mycput.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course saveCourse(Course course);

   // Course findCourseByCode(String courseCode);

    Course updateCourse(Course course);



    Course getCourseById(Long id);

    Course getCourseName(String courseName);

    Course getByCourseCode(String courseCode);

    void deleteByCourseName(String courseName);
}


