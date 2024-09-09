package com.mysite.lesson24;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.ZoneId;

@WebServlet(value = "/washington")
public class WashingtonTime extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ZoneId zone = ZoneId.of("America/Los_Angeles");
        LocalTime now = LocalTime.now(zone);

        PrintWriter writer = resp.getWriter();
        writer.write("Washington %s".formatted(now));
    }
}
