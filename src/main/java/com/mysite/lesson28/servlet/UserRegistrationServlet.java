package com.mysite.lesson28.servlet;

import com.mysite.lesson28.model.User;
import com.mysite.lesson28.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/user/reg")
@MultipartConfig
public class UserRegistrationServlet extends HttpServlet {

    private final InMemoryUserStorage userStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/lesson28/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Part avatar = req.getPart("avatar");
        byte[] avatarBytes = avatar.getInputStream().readAllBytes();

        User user = new User(name, username, password, avatarBytes);
        userStorage.save(user);

        resp.sendRedirect("/");
    }
}
