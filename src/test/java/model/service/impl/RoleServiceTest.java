package model.service.impl;

import model.dao.RoleDao;
import model.entity.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceTest {
    Role role;
    List<Role> roleList;

    @Before
    public void setUp() {
        roleList = new ArrayList<>();
        role = new Role(1,"name1","description1");
        roleList.add(role);
        roleList.add(new Role(2,"name2","description2"));
    }

    @Mock
    private RoleDao roleDao;
    @InjectMocks
    private RoleService roleService;

    @Test
    public void shouldReturnRoleById() {
        when(roleDao.findById(1)).thenReturn(role);
        Role actual = roleService.findById(1);
        Role expected = role;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllRoles() {
        when(roleDao.findAll()).thenReturn(roleList);
        List<Role> actual = roleService.findAll();
        List<Role> expected = roleList;
        Assert.assertEquals(expected, actual);
    }
}
