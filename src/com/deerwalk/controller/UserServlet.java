package com.deerwalk.controller;

import com.deerwalk.model.User;
import com.deerwalk.service.UserService;
import com.deerwalk.model.Role;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Dell on 10/30/2017.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("login")){
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            PrintWriter writer = response.getWriter();
            writer.write("Email:" + email + "<br>");
            writer.write("Password:" + password);

            User user = new UserService().getUser(email, password);
            if (user != null) {

                HttpSession session=request.getSession();
                session.setAttribute("user",user);//default 30min samman basxa
                Role role1=new UserService().getRole(user.getId());
                request.setAttribute("u",user);
                request.setAttribute("r",role1);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("connected.jsp");
                requestDispatcher.forward(request, response);
            }
        }
        else if(page.equalsIgnoreCase("register")){
            PrintWriter writer=response.getWriter();
            response.setContentType("text/html");
            String name=request.getParameter("name");
            String password=request.getParameter("password");
            String email=request.getParameter("email");


            User user=new User();

            user.setPassword(password);
            user.setEmail(email);
            user.setName(name);

            boolean isSuccess=new UserService().registerUser(user);//UserService userService=new UserService() and userService.registerUser()
            if(isSuccess) {
                User user1 =  new UserService().getUserByEmail(user.getEmail());

                int role = new UserService().insertRole(user1.getId());
                if (role > 0) {
                    Role role1=new UserService().getRole(user1.getId());
                    request.setAttribute("r",role1);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("connected.jsp");
                    requestDispatcher.forward(request, response);
                }
            }


        }
        else if(page.equalsIgnoreCase("editUser")){
            String id=request.getParameter("id");
            String name=request.getParameter("name");
            String password=request.getParameter("password");
            String email=request.getParameter("email");

            User user=new User();

            user.setId(Integer.parseInt(id));
            user.setName(name);
            user.setPassword(password);
            user.setEmail(email);

            boolean isSuccess=new UserService().updateUser(user);
            if(isSuccess){
                List<User> userList=new UserService().getUserList();
                System.out.println("Total user:"+userList);
                request.setAttribute("user",userList);
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/html/user/list.jsp");
                requestDispatcher.forward(request,response);
            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page=request.getParameter("page");
        if(page.equalsIgnoreCase("list")){
            List<User> userList=new UserService().getUserList();
            System.out.println("Total user:"+userList.size());
            request.setAttribute("user",userList);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/html/user/list.jsp");
            requestDispatcher.forward(request,response);
        }
        else if(page.equalsIgnoreCase("editUser")){
            String id=request.getParameter("id");
            User user=new UserService().editUser(id);
            if(user!=null){
                request.setAttribute("u",user);
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/html/user/edit.jsp");
                requestDispatcher.forward(request,response);
            }
        }
        else if(page.equalsIgnoreCase("deleteUser")){
            String id=request.getParameter("id");
            int user=new UserService().deleteUser(id);
            if(user>0){
                List<User> userList=new UserService().getUserList();
                System.out.println("Total user:"+userList);
                request.setAttribute("user",userList);
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/html/user/list.jsp");
                requestDispatcher.forward(request,response);
            }

        }else if(page.equalsIgnoreCase("logout")){
            HttpSession session=request.getSession();
            if(session!=null){
                session.invalidate();
            }
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }

    }
}
