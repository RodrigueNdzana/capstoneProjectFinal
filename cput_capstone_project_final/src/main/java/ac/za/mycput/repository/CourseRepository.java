package ac.za.mycput.repository;

import ac.za.mycput.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Course findCourseByCourseCode(String courseCode);
    void deleteCourseById(Long id);
}
