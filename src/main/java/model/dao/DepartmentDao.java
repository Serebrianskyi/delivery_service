package model.dao;

import model.entity.Department;

public interface DepartmentDao extends GenericDao<Department> {
    Department findDepartmentByTown(String town);

    Department findDepartmentByTownAndStreet(String town, String street);

    boolean departmentIsCreated(Department department);
}
