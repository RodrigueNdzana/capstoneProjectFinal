package ac.za.mycput.service.Interface;


import ac.za.mycput.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department>getAllDepartment();

    Department getDepartmentId(String departmentId);

    Department updateDepartment(Department department);

    void deleteDepartmentId(String departmentId);


}

