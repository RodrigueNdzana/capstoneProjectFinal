package ac.za.mycput.service.impl.Interface;


import ac.za.mycput.entity.Educator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EducatorService {
    List<Educator> getAllEducators();

    Educator saveEducator(Educator educator);


    Educator updateEducator(Educator educator);

    void deleteEducatorById(Long id);

    Educator getEducatorById(Long id);

    Educator findEducatorName(String educatorName);

    Educator getByEducatorNumber(String educatorNumber);
    @Query(value = "select * from educator e where e.educatorNumber like %:keyword% or e.educatorName like %:keyword%", nativeQuery = true)
    List<Educator> findByKeyword(@Param("keyword") String keyword);
}
