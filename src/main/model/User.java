package main.model;

import java.util.Objects;

public class User {
    private Integer idUser;
    private String username;
    private String password;
    private String role;

    public User(Integer idUser,String username,String password,String role) {
        this.idUser=idUser;
        this.username=username;
        this.password=password;
        this.role=role;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUser, user.idUser) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUser, username, password, role);
    }
    @Override
    public String toString(){
        return "USER: \nUsername: "+username+"\nRole: "+role;

    }
}
