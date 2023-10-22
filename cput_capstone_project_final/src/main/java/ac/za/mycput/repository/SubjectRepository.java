package ac.za.mycput.repository;

import ac.za.mycput.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    Subject findBySubjectName(String subjectName);

    @Query(value = "select * from subjects s where s.subjectName like %:keyword%", nativeQuery = true)
    List<Subject> findByKeywordSubject(String keyword);
}
