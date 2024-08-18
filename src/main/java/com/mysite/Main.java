package com.mysite;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

        httpServer.createContext("/calculator", new CalculatorHandler());

        httpServer.start();
    }
}