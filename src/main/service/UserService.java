package main.service;

import main.dao.UserDAO;
import main.model.User;

import java.util.List;

public class UserService {

    private UserDAO userDAO;

    public UserService(){this.userDAO=new UserDAO();}

    public List<User> getAllUser(){
        return userDAO.getUser();
    }

    public boolean insertUser (User user){
        return this.userDAO.insertUser(user);
    }
}
