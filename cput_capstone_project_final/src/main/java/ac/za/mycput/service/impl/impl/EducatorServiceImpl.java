package ac.za.mycput.service.impl.impl;

import ac.za.mycput.entity.Educator;
import ac.za.mycput.repository.EducatorRepository;

import ac.za.mycput.service.impl.Interface.EducatorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("EducatorServiceImpl")
public class EducatorServiceImpl implements EducatorService {
    private EducatorRepository educatorRepository;
    private EducatorServiceImpl(EducatorRepository educatorRepository){
        super();
        this.educatorRepository = educatorRepository;
    }
    @Override
    public List<Educator> getAllEducators() {
        return educatorRepository.findAll();
    }

    @Override
    public Educator saveEducator(Educator educator) {
        return educatorRepository.save(educator);
    }

    @Override
    public Educator updateEducator(Educator educator) {
        return educatorRepository.save(educator);
    }

    @Override
    public void deleteEducatorById(Long id) {
        educatorRepository.deleteById(id);
    }

    @Override
    public Educator getEducatorById(Long id) {
        return educatorRepository.findById(id).get();
    }
    @Override
    public Educator findEducatorName(String educatorName) {
        return educatorRepository.findByEducatorName(educatorName);
    }

    @Override
    public Educator getByEducatorNumber(String educatorNumber) {
        return educatorRepository.getByEducatorNumber(educatorNumber);
    }

    @Override
    public List<Educator> findByKeyword(String keyword) {
        return educatorRepository.findByKeyword(keyword);
    }
}
