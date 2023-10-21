package ac.za.mycput.repository;
/*

 */


import ac.za.mycput.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department getByDepartmentId(String departmentId);

    void deleteByDepartmentId(String departmentId);
}


