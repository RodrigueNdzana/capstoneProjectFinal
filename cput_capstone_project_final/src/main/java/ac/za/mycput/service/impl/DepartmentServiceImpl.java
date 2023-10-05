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
    public Department getDepartmentId(String departmentId) {
        return departmentRepository.getByDepartmentId(departmentId);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentId(String departmentId) {
        departmentRepository.deleteByDepartmentId(departmentId);
    }
}


