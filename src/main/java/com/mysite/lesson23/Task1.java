package com.mysite.lesson23;

//Написать программу для парсинга xml документа. Необходимо распарсить xml документ и
//содержимое тегов line записать в другой документ. Название файла для записи должно
//состоять из значений тегов и имеет вид: <firstName><lastName><title>.txt
//Дополнительно реализовать следующий функционал: если с консоли введено значение 1 -
//распарсить документ с помощью SAX, если с консоли введено значение 2 - распарсить
//документ с помощью DOM.


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Scanner;

public class Task1 {

    public static StringBuilder pathOut = new StringBuilder();
    public static FileWriter fileWriter;
    public static StringBuilder fn = new StringBuilder();
    public static StringBuilder ln = new StringBuilder();
    public static StringBuilder t = new StringBuilder();

    public static void main(String[] args) {

        String pathInput = "src/main/resources/lesson23/input.xml";

        Scanner scanner = new Scanner(System.in);
        System.out.print("1 - SAX\n2 - DOM\nInput: ");
        int choice;
        choice = scanner.nextInt();
        if (choice == 1) {
            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser parser = factory.newSAXParser();
                setTitle handler = new setTitle();
                parser.parse(new File(pathInput), handler);
                try {
                    pathOut.append("src/main/resources/lesson23/");
                    pathOut.append(fn);
                    pathOut.append(ln);
                    pathOut.append(t);
                    pathOut.append(".txt");
                    fileWriter = new FileWriter(String.valueOf(pathOut));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                getLine lineHandler = new getLine();
                parser.parse(new File(pathInput), lineHandler);
                fileWriter.flush();
                fileWriter.close();
            } catch (ParserConfigurationException | SAXException | IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Done SAX");
        } else if (choice == 2) {
            try {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = builder.parse(pathInput);
                document.getDocumentElement().normalize();
                pathOut.append("src/main/resources/lesson23/");
                pathOut.append(document.getElementsByTagName("firstName").item(0).getTextContent());
                pathOut.append(document.getElementsByTagName("lastName").item(0).getTextContent());
                pathOut.append(document.getElementsByTagName("title").item(0).getTextContent());
                pathOut.append(".txt");
                fileWriter = new FileWriter(String.valueOf(pathOut));
                NodeList lines = document.getElementsByTagName("line");
                for (int i = 0; i < lines.getLength(); i++) {
                    Node line = lines.item(i);
                    fileWriter.write(line.getTextContent());
                    fileWriter.write("\n");
                }
                fileWriter.flush();
                fileWriter.close();

            } catch (ParserConfigurationException | SAXException | IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Done DOM");
        } else {
            System.out.println("Wrong!");
        }
    }

    private static class setTitle extends DefaultHandler {

        private String elementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes){
            elementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length){
            String information = new String(ch, start, length);

            if (!information.isEmpty()) {
                if (elementName.equals("firstName")) {
                    fn.append(information.trim());
                }
                if (elementName.equals("lastName")) {
                    ln.append(information.trim());
                }
                if (elementName.equals("title")) {
                    t.append(information.trim());
                }
            }
        }
    }

    private static class getLine extends DefaultHandler {

        private String elementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes){
            elementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length){
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (elementName.equals("line")) {
                    try {
                        fileWriter.write(information.trim());
                        fileWriter.write("\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
