package model.service.impl;

import model.dao.DepartmentDao;
import model.entity.Department;
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
public class DepartmentServiceTest {
    Department department;
    List<Department> departmentList;

    @Before
    public void setUp() {
        departmentList = new ArrayList<>();
        department = new Department(1, "town1", "street1", "1", 1);
        departmentList.add(department);
        departmentList.add(new Department(2, "town2", "street2", "2", 2));
    }

    @Mock
    private DepartmentDao departmentDao;
    @InjectMocks
    private DepartmentService departmentService;

    @Test
    public void shouldReturnDepartmentById() {
        when(departmentDao.findById(1)).thenReturn(department);
        Department actual = departmentService.findById(1);
        Department expected = department;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllDepartments() {
        when(departmentDao.findAll()).thenReturn(departmentList);
        List<Department> actual = departmentService.findAll();
        List<Department> expected = departmentList;
        Assert.assertEquals(expected, actual);
    }
}

