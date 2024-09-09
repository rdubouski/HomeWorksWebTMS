package com.mysite.lesson24;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.ZoneId;

@WebServlet(value = "/minsk")
public class MinskTime extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ZoneId zone = ZoneId.of("Europe/Minsk");
        LocalTime now = LocalTime.now(zone);

        PrintWriter writer = resp.getWriter();
        writer.write("Minsk %s".formatted(now));
    }
}
