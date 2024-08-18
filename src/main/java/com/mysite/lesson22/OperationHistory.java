package com.mysite.lesson22;

import java.io.*;

public class OperationHistory {

    File historyFile;

    public OperationHistory() {
        String pathHistory = "src/main/resources/lesson22/history.txt";
        historyFile = new File(pathHistory);
    }

    public void writeHistory(String string) {
        try (OutputStream outputStream = new FileOutputStream(historyFile, true)) {
            outputStream.write(string.getBytes());
        } catch (IOException e) {
            System.out.println("\nФайла не существует!\n");
        }
    }

    public StringBuilder readHistory() {
        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(historyFile))) {
            String readString;
            while ((readString = bufferedReader.readLine()) != null) {
                result.append(readString);
                result.append("\n");
            }
        } catch (IOException e) {
            System.out.println("\nФайла не существует!\n");
        }
        return result;
    }

}
