package model.service.impl;

import model.dao.UserDao;
import model.entity.User;
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
public class UserServiceTest {
    User user;
    List<User> userList;

    @Before
    public void setUp() {
        userList = new ArrayList<>();
        user = new User(1,"name1","surName1",
                "lastName1","email1","password1",1);
        userList.add(user);
        userList.add(new User(2,"name2","surName2",
                "lastName2","email2","password2",2));
    }

    @Mock
    private UserDao userDao;
    @InjectMocks
    private UserService userService;

    @Test
    public void shouldReturnUserById() {
        when(userDao.findById(1)).thenReturn(user);
        User actual = userService.findById(1);
        User expected = user;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllUsers() {
        when(userDao.findAll()).thenReturn(userList);
        List<User> actual = userService.findAll();
        List<User> expected = userList;
        Assert.assertEquals(expected, actual);
    }
}
