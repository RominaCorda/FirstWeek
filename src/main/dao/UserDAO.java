package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public UserDAO(){}
    private final String var="local";
    private final String queryGet="select * from users where role=\""+var+"\"";
    private final String queryIn="insert into users (idUser,username,password,role) values(null,?,?,\"local\")";
    public List<User> getUser(){
        List<User> listUser= new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryGet);
            while (resultSet.next()) {
                int idUser = resultSet.getInt("idUser");
                String username = resultSet.getString("username");
                String password = "*******";
                String role = resultSet.getString("role");
                listUser.add(new User(idUser,username,password,role));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }return listUser;
    }

    public boolean insertUser(User user) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryIn);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            return preparedStatement.execute();


        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;

        }
    }


}
