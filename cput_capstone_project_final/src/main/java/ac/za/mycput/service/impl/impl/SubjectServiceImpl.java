package ac.za.mycput.service.impl.impl;


import ac.za.mycput.entity.Subject;
import ac.za.mycput.repository.SubjectRepository;

import ac.za.mycput.service.impl.Interface.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("SubjectServiceImpl")
public class SubjectServiceImpl implements SubjectService {
    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        super();
        this.subjectRepository = subjectRepository;
    }
    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }



    @Override
    public Subject findSubjectName(String subjectName) {
        return subjectRepository.findBySubjectName(subjectName);
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubjectById(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject getSubjectByiD(Long id) {
        return subjectRepository.findById(id).get();
    }

    @Override
    public Subject getSubjectName(String subjectName) {
        return null;
    }

    @Override
    public List<Subject> findByKeywordSubject(String keyword) {
        return subjectRepository.findByKeywordSubject(keyword);
    }
}
