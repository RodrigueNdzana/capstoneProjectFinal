package ac.za.mycput.service.Interface;



import ac.za.mycput.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> getAllSubject();

    Subject saveSubject(Subject subject);

    Subject findSubjectName(String subjectName);

    Subject updateSubject(Subject subject);

    void deleteSubjectById(Long id);

    Subject getSubjectByiD(Long id);
}
