package com.deerwalk.service;

import com.deerwalk.controller.UserServlet;
import com.deerwalk.model.Question;
import com.deerwalk.model.Role;
import com.deerwalk.model.User;


import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 10/30/2017.
 */
public class UserService {
    public User getUser(String email, String password) {
        User user=null;
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="select * from user where email=? and password=?";
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            boolean val=statement.execute();
            if(val){
                ResultSet resultSet=statement.getResultSet();
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String email1=resultSet.getString("email");
                    String password1=resultSet.getString("password");
                    String name=resultSet.getString("name");

                    user=new User();
                    user.setId(id);
                    user.setEmail(email1);
                    user.setPassword(password1);
                    user.setName(name);


                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public boolean registerUser(User user){
        boolean isSuccess=false;
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="insert into user(name,password,email)values(?,?,?)";
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getEmail());
            int affectedRows=statement.executeUpdate();
            if(affectedRows>0){
                isSuccess=true;
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
    public List<User> getUserList(){
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="select * from user";
        List<User> userList = new ArrayList<User>();
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            boolean val=statement.execute();
            if(val){
                ResultSet resultSet=statement.getResultSet();
                while(resultSet.next()){
                    int id=resultSet.getInt("id");
                    String name=resultSet.getString("name");
                    String email=resultSet.getString("email");
                    String password=resultSet.getString("password");

                    User user=new User();

                    user.setId(id);
                    user.setName(name);
                    user.setEmail(email);
                    user.setPassword(password);



                    userList.add(user);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;

    }

    public User editUser(String id) {
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="select * from user where id=?";
        User user=null;
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
            boolean val=statement.execute();
            if(val){
                ResultSet resultSet=statement.getResultSet();
                while(resultSet.next()){
                    int id1=resultSet.getInt("id");
                    String name=resultSet.getString("name");
                    String password=resultSet.getString("password");
                    String email=resultSet.getString("email");


                    user=new User();

                    user.setId(id1);
                    user.setName(name);
                    user.setPassword(password);
                    user.setEmail(email);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int deleteUser(String id) {
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="delete from user where id=?";
        int affectedRows=0;
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,Integer.parseInt(id));
            affectedRows=statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public boolean updateUser(User user) {
        boolean isSuccess=false;
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="update user set name=?, password=?, email=? where id=?";
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getEmail());
            statement.setInt(4,user.getId());
            int affectedRows=statement.executeUpdate();
            if(affectedRows>0){
                isSuccess=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public int insertRole(int id) {
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="insert into role(user_id,role)values(?,?)";
        int affectedRows=0;
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setString(2,"user");
            affectedRows=statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public Role getRole(int id) {
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="select * from role where user_id=?";
        Role role1=null;

        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            boolean val=statement.execute();
            if(val){
                ResultSet resultSet=statement.getResultSet();
                while(resultSet.next()){
                    int id1=resultSet.getInt("id");
                    int userId=resultSet.getInt("user_id");
                    String role=resultSet.getString("role");

                    role1=new Role();

                    role1.setId(id1);
                    role1.setUserId(userId);
                    role1.setRole(role);




                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role1;
    }

    public User getUserByEmail(String email) {
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="select * from user where email=?";
        User user=null;
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,email);
            boolean val=statement.execute();
            if(val){
                ResultSet resultSet=statement.getResultSet();
                while(resultSet.next()){
                    int id=resultSet.getInt("id");
                    String name=resultSet.getString("name");
                    String email1=resultSet.getString("email");
                    String password=resultSet.getString("password");

                    user=new User();
                    user.setId(id);
                    user.setEmail(email1);
                    user.setPassword(password);
                    user.setName(name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
