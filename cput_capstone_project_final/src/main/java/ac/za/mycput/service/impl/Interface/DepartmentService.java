package ac.za.mycput.service.impl.Interface;


import ac.za.mycput.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department>getAllDepartment();

    Department getByDepartmentId(String departmentId);

    Department updateDepartment(Department department);

    void deleteById(Long id);

    Department getById(Long id);


    //void deleteByDepartmentId(String departmentId);
}

