package com.mysite.lesson25;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/calc")
public class Calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        OperationHistory operationHistory = new OperationHistory();
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        String result = "%s %s %s = %s";
        String response = switch (req.getParameter("type")) {
            case "sum" -> result.formatted(num1, "+", num2, num1 + num2);
            case "sub" -> result.formatted(num1, "-", num2, num1 - num2);
            case "mul" -> result.formatted(num1, "*", num2, num1 * num2);
            case "div" -> result.formatted(num1, "/", num2, num1 / num2);
            default -> throw new IllegalStateException("Unexpected value: " + req.getParameter("type"));
        };
        operationHistory.writeHistory(response + "\n");
        PrintWriter writer = resp.getWriter();
        writer.write(response);
    }
}
