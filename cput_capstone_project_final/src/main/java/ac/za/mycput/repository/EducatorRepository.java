package ac.za.mycput.repository;

import ac.za.mycput.entity.Educator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducatorRepository extends JpaRepository<Educator,Long> {

    Educator getByEducatorNumber(String educatorNumber);
    Educator findByEducatorName(String educatorName);
    @Query(value = "select * from educator e where e.educatorNumber like %:keyword% or e.educatorName like %:keyword%", nativeQuery = true)
    List<Educator> findByKeyword(@Param("keyword") String keyword);

}
