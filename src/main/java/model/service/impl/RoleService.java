package model.service.impl;

import model.dao.FactoryDao;
import model.dao.RoleDao;
import model.entity.Role;
import model.service.GenericService;
import org.apache.log4j.Logger;

import java.util.List;

public class RoleService implements GenericService<Role> {
    private Logger logger = Logger.getLogger(RoleService.class);
    private FactoryDao factoryDao = FactoryDao.getInstance();
    private RoleDao roleDao = factoryDao.createRoleDao();

    @Override
    public void create(Role entity) {
        roleDao.create(entity);
    }

    @Override
    public Role findById(int id) {
        return roleDao.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void update(Role entity) {
        roleDao.update(entity);
    }

    @Override
    public void delete(int id) {
        roleDao.delete(id);
    }
}
