package com.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.model.User;

public interface UserDAO {
public boolean loginValidated(User users);
public void addUser(User user);
public List<User> loadAll();
public boolean findUser(int uid);
public boolean deleteUser(String uname);
public boolean updateUser(String name,User user);
}
