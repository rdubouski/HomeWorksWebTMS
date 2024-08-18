package com.mysite.lesson22;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CalculatorHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        Map<String, String> parameters = getParameters(query);

        String result = "%s %s %s = %s";

        int num1 = Integer.parseInt(parameters.get("num1"));
        int num2 = Integer.parseInt(parameters.get("num2"));

        String response = switch (parameters.get("type")) {
            case "sum" -> result.formatted(num1, "+", num2, num1 + num2);
            case "sub" -> result.formatted(num1, "-", num2, num1 - num2);
            case "mul" -> result.formatted(num1, "*", num2, num1 * num2);
            case "div" -> result.formatted(num1, "/", num2, num1 / num2);
            default -> throw new IllegalStateException("Unexpected value: " + parameters.get("type"));
        };


        exchange.sendResponseHeaders(200, response.length());

        exchange.getResponseBody().write(response.getBytes());

        exchange.getResponseBody().close();
    }

    private static Map<String, String> getParameters(String query) {
        String[] split = query.split("&");
        Map<String, String> parameters = new HashMap<>();

        for (String s : split) {
            String[] split1 = s.split("=");
            parameters.put(split1[0], split1[1]);
        }

        return parameters;
    }
}