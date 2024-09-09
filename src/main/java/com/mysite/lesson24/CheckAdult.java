package com.mysite.lesson24;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/adult")
public class CheckAdult extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int age = Integer.parseInt(req.getParameter("age"));
        PrintWriter writer = resp.getWriter();
        if (age < 18) {
            writer.write("No adult");
        } else {
            writer.write("Adult");
        }

    }
}
