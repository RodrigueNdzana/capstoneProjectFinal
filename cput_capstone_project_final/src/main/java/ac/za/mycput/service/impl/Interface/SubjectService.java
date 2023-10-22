package ac.za.mycput.service.impl.Interface;



import ac.za.mycput.entity.Subject;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubject();

    Subject saveSubject(Subject subject);

    Subject findSubjectName(String subjectName);

    Subject updateSubject(Subject subject);

    void deleteSubjectById(Long id);

    Subject getSubjectByiD(Long id);



    Subject getSubjectName(String subjectName);

    @Query(value = "select * from subjects s where s.subjectName like %:keyword%", nativeQuery = true)
    List<Subject> findByKeywordSubject(String keyword);
}
