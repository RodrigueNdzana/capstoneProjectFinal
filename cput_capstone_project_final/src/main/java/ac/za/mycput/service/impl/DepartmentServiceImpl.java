package ac.za.mycput.service.impl;
/*

 */


import ac.za.mycput.entity.Department;
import ac.za.mycput.repository.DepartmentRepository;
import ac.za.mycput.service.Interface.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DepartmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        super();
        this.departmentRepository = departmentRepository;
    }
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getByDepartmentId(String departmentId) {
        return departmentRepository.getByDepartmentId(departmentId);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }



    @Override
    public Department getById(Long id) {
        return departmentRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }


}


