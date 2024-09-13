package com.mysite.lesson28.servlet;

import com.mysite.lesson28.model.User;
import com.mysite.lesson28.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@WebServlet("/user/profile")
public class UserProfileServlet extends HttpServlet {

    private final InMemoryUserStorage userStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Optional<User> byUsername = userStorage.findByUsername(username);
        if (byUsername.isPresent()) {
            User user = byUsername.get();
            String avatar = Base64.getEncoder().encodeToString(user.getAvatar());
            req.setAttribute("user", user);
            req.setAttribute("avatar", avatar);
        }

        getServletContext().getRequestDispatcher("/pages/lesson28/profile.jsp").forward(req, resp);
    }
}
