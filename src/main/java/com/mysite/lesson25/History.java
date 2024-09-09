package com.mysite.lesson25;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/hist")
public class History extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        OperationHistory operationHistory = new OperationHistory();
        String message = String.valueOf(operationHistory.readHistory());
        PrintWriter writer = resp.getWriter();
        writer.write(message);
    }
}
