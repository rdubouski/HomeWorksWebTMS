package com.mysite.lesson22;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class HistoryHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        OperationHistory operationHistory =new OperationHistory();
        String message = String.valueOf(operationHistory.readHistory());

        exchange.sendResponseHeaders(200, message.length());
        exchange.getResponseBody().write(message.getBytes());
        exchange.getResponseBody().close();
    }
}