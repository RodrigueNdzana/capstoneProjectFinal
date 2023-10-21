package ac.za.mycput.service.Interface;
/*

 */
import ac.za.mycput.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course saveCourse(Course course);

   // Course findCourseByCode(String courseCode);

    Course updateCourse(Course course);

    void deleteCourseById(Long id);

    Course getCourseById(Long id);

    Course getByCourseCode(String courseCode);
}


