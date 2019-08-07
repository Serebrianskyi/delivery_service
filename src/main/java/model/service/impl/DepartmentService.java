package model.service.impl;

import model.dao.DepartmentDao;
import model.dao.FactoryDao;
import model.entity.Department;
import model.service.GenericService;
import org.apache.log4j.Logger;

import java.util.List;

public class DepartmentService implements GenericService<Department> {
    private Logger logger = Logger.getLogger(DepartmentService.class);
    private FactoryDao factoryDao = FactoryDao.getInstance();
    private DepartmentDao departmentDao = factoryDao.createDepartmentDao();

    @Override
    public void create(Department entity) {
        departmentDao.create(entity);
    }

    @Override
    public Department findById(int id) {
        return departmentDao.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public void update(Department entity) {
        departmentDao.update(entity);
    }

    @Override
    public void delete(int id) {
        departmentDao.delete(id);
    }

    public Department findDepartmentByTownAndStreet(String town, String street){
        return departmentDao.findDepartmentByTownAndStreet(town,street);
    }

    public Department findDepartmentByTown(String town){
        return departmentDao.findDepartmentByTown(town);
    }

    public boolean departmentIsCreated(Department department){
        return departmentDao.departmentIsCreated(department);
    }
}
